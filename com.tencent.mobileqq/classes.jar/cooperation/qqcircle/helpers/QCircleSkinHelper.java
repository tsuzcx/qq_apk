package cooperation.qqcircle.helpers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.mobileqq.auto.engine.skin.loader.SkinManager;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudCommon.Entry;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class QCircleSkinHelper
{
  public static final String SKIN_ASSERT_PACKAGE_NAME = "darkmode.skin";
  public static final String SKIN_ASSERT_PACKAGE_PATH;
  public static final String SKIN_CONFIG_FILE_NAME = "config.ini";
  public static final String SKIN_DARK_MODE_CONFIG_PATH;
  public static final String SKIN_DARK_MODE_TAG = "darkmode";
  public static final String SKIN_DEFAULT_MODE_CONFIG_PATH;
  public static final String SKIN_DEFAULT_MODE_TAG = "defaultmode";
  public static final String SKIN_IMAGE_URL_SECTION = "ImageURL";
  public static final String SKIN_PACKAGE_PATH_SP_KEY = "qcircle_skin_package_path";
  private static final String TAG = "QCircleSkinHelper";
  private static volatile QCircleSkinHelper sHelper;
  private boolean isDefaultMode = true;
  private Context mContext;
  private QCircleIniFile mDefaultIniFile;
  private RFWDownloader.RFWDownloadListener mDownLoadListener;
  private boolean mNeedReloadSkin = false;
  private QCircleIniFile mSkinIniFile;
  private long mStartDownloadTime;
  private long mStartLoadTime;
  private List<QCircleSkinHelper.OnThemeUpdateListener> mThemeUpdateListeners = new ArrayList();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("defaultmode");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("config.ini");
    SKIN_DEFAULT_MODE_CONFIG_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("darkmode");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("config.ini");
    SKIN_DARK_MODE_CONFIG_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("darkmode");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("darkmode.skin");
    SKIN_ASSERT_PACKAGE_PATH = localStringBuilder.toString();
  }
  
  public static QCircleSkinHelper getInstance()
  {
    if (sHelper == null) {
      try
      {
        if (sHelper == null) {
          sHelper = new QCircleSkinHelper();
        }
      }
      finally {}
    }
    return sHelper;
  }
  
  private int getSkinPackageVersion(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    Object localObject = Pattern.compile("darkmode-v(\\d+).skin").matcher(paramString);
    paramString = "";
    try
    {
      while (((Matcher)localObject).find()) {
        paramString = ((Matcher)localObject).group(1);
      }
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSkinPackageVersion error");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("QCircleSkinHelper", 1, ((StringBuilder)localObject).toString());
    }
    return 0;
  }
  
  private String getUrlFromIniFile(QCircleIniFile paramQCircleIniFile, String paramString)
  {
    if (paramQCircleIniFile == null) {
      return "";
    }
    paramQCircleIniFile = paramQCircleIniFile.get("ImageURL", paramString);
    if ((paramQCircleIniFile instanceof String)) {
      return (String)paramQCircleIniFile;
    }
    return "";
  }
  
  private void handleDownloadCallBack(boolean paramBoolean, String paramString1, String paramString2, QCircleSkinHelper.SkinDownLoadLister paramSkinDownLoadLister, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadSkinPackage  onRspCallback isSuccess = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("filePath = ");
    ((StringBuilder)localObject).append(paramString1);
    QLog.d("QCircleSkinHelper", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      localObject = "0";
    } else {
      localObject = "-1";
    }
    reportDownLoadSkinEvent(paramString2, (String)localObject, (float)(System.currentTimeMillis() - this.mStartDownloadTime) / 1000.0F);
    if (paramSkinDownLoadLister != null) {
      paramSkinDownLoadLister.onRspCallback(paramBoolean, paramString1);
    }
    if (!paramBoolean) {
      return;
    }
    paramString2 = new File(paramString3);
    if ((new File(paramString1).exists()) && ((!paramString2.exists()) || (paramString2.delete()))) {
      SharePreferenceUtils.a(MobileQQ.sMobileQQ.getApplicationContext(), "qcircle_skin_package_path", paramString1);
    }
  }
  
  private void initIniFile()
  {
    ((IThreadManagerApi)QRoute.api(IThreadManagerApi.class)).executeOnSubThread(new QCircleSkinHelper.1(this));
  }
  
  private void loadSkinPackage(String paramString)
  {
    this.mStartLoadTime = System.currentTimeMillis();
    try
    {
      SkinManager.getsInstance().loadSkinResource(paramString);
      this.isDefaultMode = false;
      reportLoadSkinEvent("0", (float)(System.currentTimeMillis() - this.mStartLoadTime) / 1000.0F);
      onThemeUpdate();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invokeLoadSkin error : ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("QCircleSkinHelper", 1, localStringBuilder.toString());
      reportLoadSkinEvent("-1", (float)(System.currentTimeMillis() - this.mStartLoadTime) / 1000.0F);
    }
  }
  
  private void onThemeUpdate()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onThemeUpdate");
    ((StringBuilder)localObject).append(this.mThemeUpdateListeners.size());
    QLog.d("QCircleSkinHelper", 1, ((StringBuilder)localObject).toString());
    localObject = this.mThemeUpdateListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QCircleSkinHelper.OnThemeUpdateListener)((Iterator)localObject).next()).onThemeUpdate();
    }
  }
  
  private void reportDownLoadSkinEvent(String paramString1, String paramString2, double paramDouble)
  {
    QCircleQualityReporter.reportQualityEvent("skin_package_download_event", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ret_code", paramString2), QCircleReportHelper.newEntry("time_cost", String.valueOf(paramDouble)), QCircleReportHelper.newEntry("url", paramString1) }), false);
  }
  
  private void reportLoadSkinEvent(String paramString, double paramDouble)
  {
    QCircleQualityReporter.reportQualityEvent("skin_package_load_event", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ret_code", paramString), QCircleReportHelper.newEntry("time_cost", String.valueOf(paramDouble)) }), false);
  }
  
  public String convertUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (!QCircleCommonUtil.isInNightMode()) {
      return paramString;
    }
    if (paramString.contains("defaultmode")) {
      return paramString.replace("defaultmode", "darkmode");
    }
    int i = paramString.lastIndexOf('.');
    if (i == -1) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, i));
    localStringBuilder.append("_dark");
    localStringBuilder.append(paramString.substring(i));
    return localStringBuilder.toString();
  }
  
  public void downloadSkinPackage(String paramString, QCircleSkinHelper.SkinDownLoadLister paramSkinDownLoadLister)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadSkinPackage url = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("skinDownLoadLister = ");
    ((StringBuilder)localObject).append(paramSkinDownLoadLister);
    QLog.d("QCircleSkinHelper", 1, ((StringBuilder)localObject).toString());
    localObject = RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).getDefaultSavePath(paramString);
    String str = SharePreferenceUtils.a(MobileQQ.sMobileQQ.getApplicationContext(), "qcircle_skin_package_path");
    if (getSkinPackageVersion((String)localObject) < getSkinPackageVersion(str)) {
      return;
    }
    if (((String)localObject).equals(str))
    {
      if (paramSkinDownLoadLister != null) {
        paramSkinDownLoadLister.onRspCallback(true, (String)localObject);
      }
      return;
    }
    if ((new File((String)localObject).exists()) && (paramSkinDownLoadLister != null)) {
      paramSkinDownLoadLister.onRspCallback(true, (String)localObject);
    }
    this.mStartDownloadTime = System.currentTimeMillis();
    this.mDownLoadListener = new QCircleSkinHelper.2(this, paramString, paramSkinDownLoadLister, str);
    RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).download(paramString, this.mDownLoadListener);
  }
  
  public int getColor(int paramInt)
  {
    try
    {
      if (this.isDefaultMode) {
        return this.mContext.getResources().getColor(paramInt);
      }
      paramInt = SkinManager.getColor(paramInt);
      return paramInt;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColor  error");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QCircleSkinHelper", 1, localStringBuilder.toString());
      localException.printStackTrace();
    }
    return 0;
  }
  
  public int getColor(String paramString)
  {
    try
    {
      if (this.isDefaultMode)
      {
        i = this.mContext.getResources().getIdentifier(paramString, "color", this.mContext.getPackageName());
        return this.mContext.getResources().getColor(i);
      }
      int i = SkinManager.getColor(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColor  error");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("QCircleSkinHelper", 1, localStringBuilder.toString());
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    try
    {
      if (this.isDefaultMode)
      {
        if (Build.VERSION.SDK_INT < 22) {
          return this.mContext.getResources().getDrawable(paramInt);
        }
        return this.mContext.getResources().getDrawable(paramInt, null);
      }
      Drawable localDrawable = SkinManager.getDrawable(paramInt);
      return localDrawable;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDrawable  error");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QCircleSkinHelper", 1, localStringBuilder.toString());
      localException.printStackTrace();
    }
    return null;
  }
  
  public Drawable getDrawable(String paramString)
  {
    try
    {
      if (this.isDefaultMode)
      {
        int i = this.mContext.getResources().getIdentifier(paramString, "drawable", this.mContext.getPackageName());
        if (Build.VERSION.SDK_INT < 22) {
          return this.mContext.getResources().getDrawable(i);
        }
        return this.mContext.getResources().getDrawable(i, null);
      }
      paramString = SkinManager.getDrawable(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDrawable  error");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("QCircleSkinHelper", 1, localStringBuilder.toString());
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String getOldSkinPath()
  {
    return SharePreferenceUtils.a(MobileQQ.sMobileQQ.getApplicationContext(), "qcircle_skin_package_path");
  }
  
  public String getUrl(String paramString)
  {
    if (this.isDefaultMode) {
      return getUrlFromIniFile(this.mDefaultIniFile, paramString);
    }
    return getUrlFromIniFile(this.mSkinIniFile, paramString);
  }
  
  public void init(Context paramContext)
  {
    setContext(paramContext);
    this.mDefaultIniFile = new QCircleIniFile();
    this.mSkinIniFile = new QCircleIniFile();
    initIniFile();
  }
  
  /* Error */
  public boolean installLocalSkinPackage(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: new 60	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 464	java/io/File:getParentFile	()Ljava/io/File;
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 205	java/io/File:exists	()Z
    //   23: ifne +12 -> 35
    //   26: aload_1
    //   27: invokevirtual 467	java/io/File:mkdirs	()Z
    //   30: ifne +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: getfield 88	cooperation/qqcircle/helpers/QCircleSkinHelper:mContext	Landroid/content/Context;
    //   39: invokevirtual 471	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   42: getstatic 73	cooperation/qqcircle/helpers/QCircleSkinHelper:SKIN_ASSERT_PACKAGE_PATH	Ljava/lang/String;
    //   45: invokevirtual 477	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   48: astore_1
    //   49: new 479	java/io/FileOutputStream
    //   52: dup
    //   53: aload_3
    //   54: invokespecial 482	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   57: astore_2
    //   58: aload_1
    //   59: aload_2
    //   60: invokestatic 488	cooperation/qqcircle/utils/QCircleFileUtils:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   63: pop2
    //   64: aload_1
    //   65: ifnull +15 -> 80
    //   68: aload_1
    //   69: invokevirtual 493	java/io/InputStream:close	()V
    //   72: goto +8 -> 80
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 494	java/io/IOException:printStackTrace	()V
    //   80: aload_2
    //   81: invokevirtual 497	java/io/OutputStream:close	()V
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 494	java/io/IOException:printStackTrace	()V
    //   91: iconst_1
    //   92: ireturn
    //   93: astore_3
    //   94: goto +10 -> 104
    //   97: astore_3
    //   98: goto +33 -> 131
    //   101: astore_3
    //   102: aconst_null
    //   103: astore_2
    //   104: goto +75 -> 179
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: goto +21 -> 131
    //   113: astore_3
    //   114: aconst_null
    //   115: astore 4
    //   117: aload_2
    //   118: astore_1
    //   119: aload 4
    //   121: astore_2
    //   122: goto +57 -> 179
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_2
    //   128: aload 4
    //   130: astore_1
    //   131: aload_3
    //   132: invokevirtual 264	java/lang/Exception:printStackTrace	()V
    //   135: ldc 29
    //   137: iconst_1
    //   138: ldc_w 499
    //   141: aload_3
    //   142: invokestatic 502	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_1
    //   146: ifnull +15 -> 161
    //   149: aload_1
    //   150: invokevirtual 493	java/io/InputStream:close	()V
    //   153: goto +8 -> 161
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 494	java/io/IOException:printStackTrace	()V
    //   161: aload_2
    //   162: ifnull +14 -> 176
    //   165: aload_2
    //   166: invokevirtual 497	java/io/OutputStream:close	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_1
    //   172: aload_1
    //   173: invokevirtual 494	java/io/IOException:printStackTrace	()V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_3
    //   179: aload_1
    //   180: ifnull +15 -> 195
    //   183: aload_1
    //   184: invokevirtual 493	java/io/InputStream:close	()V
    //   187: goto +8 -> 195
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual 494	java/io/IOException:printStackTrace	()V
    //   195: aload_2
    //   196: ifnull +15 -> 211
    //   199: aload_2
    //   200: invokevirtual 497	java/io/OutputStream:close	()V
    //   203: goto +8 -> 211
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 494	java/io/IOException:printStackTrace	()V
    //   211: aload_3
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	QCircleSkinHelper
    //   0	213	1	paramString	String
    //   1	199	2	localObject1	Object
    //   13	41	3	localFile	File
    //   93	1	3	localObject2	Object
    //   97	1	3	localException1	Exception
    //   101	1	3	localObject3	Object
    //   107	1	3	localException2	Exception
    //   113	1	3	localObject4	Object
    //   125	17	3	localException3	Exception
    //   178	34	3	localObject5	Object
    //   3	126	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   68	72	75	java/io/IOException
    //   80	84	86	java/io/IOException
    //   58	64	93	finally
    //   58	64	97	java/lang/Exception
    //   49	58	101	finally
    //   49	58	107	java/lang/Exception
    //   5	33	113	finally
    //   35	49	113	finally
    //   5	33	125	java/lang/Exception
    //   35	49	125	java/lang/Exception
    //   149	153	156	java/io/IOException
    //   165	169	171	java/io/IOException
    //   131	145	178	finally
    //   183	187	190	java/io/IOException
    //   199	203	206	java/io/IOException
  }
  
  public boolean isOldSkinPackageExist()
  {
    return new File(getOldSkinPath()).exists();
  }
  
  public boolean isSkinPackageExist(String paramString)
  {
    return new File(RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).getDefaultSavePath(paramString)).exists();
  }
  
  public void loadSkin(String paramString)
  {
    File localFile = new File(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadSkin :skinPath = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("isDefaultMode = ");
    localStringBuilder.append(this.isDefaultMode);
    localStringBuilder.append("skinPath exist = ");
    localStringBuilder.append(new File(paramString).exists());
    QLog.d("QCircleSkinHelper", 1, localStringBuilder.toString());
    if (!localFile.exists()) {
      return;
    }
    if (this.mNeedReloadSkin) {
      loadSkinPackage(paramString);
    }
    if (!this.isDefaultMode) {
      return;
    }
    loadSkinPackage(paramString);
  }
  
  public void registerOnThemeUpdateListener(QCircleSkinHelper.OnThemeUpdateListener paramOnThemeUpdateListener)
  {
    if (!this.mThemeUpdateListeners.contains(paramOnThemeUpdateListener)) {
      this.mThemeUpdateListeners.add(paramOnThemeUpdateListener);
    }
  }
  
  public void resetDefaultSkin()
  {
    if (this.isDefaultMode) {
      return;
    }
    try
    {
      SkinManager.getsInstance().restoreDefaultTheme();
      this.isDefaultMode = true;
      onThemeUpdate();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetDefaultSkin error : ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QCircleSkinHelper", 1, localStringBuilder.toString());
      localException.printStackTrace();
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
    SkinManager.setContext(paramContext);
  }
  
  public void setNeedReloadSkin(boolean paramBoolean)
  {
    this.mNeedReloadSkin = paramBoolean;
  }
  
  public void unregisterOnThemeUpdateListener(QCircleSkinHelper.OnThemeUpdateListener paramOnThemeUpdateListener)
  {
    this.mThemeUpdateListeners.remove(paramOnThemeUpdateListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.helpers.QCircleSkinHelper
 * JD-Core Version:    0.7.0.1
 */