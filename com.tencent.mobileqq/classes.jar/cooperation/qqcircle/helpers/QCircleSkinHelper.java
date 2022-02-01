package cooperation.qqcircle.helpers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudCommon.Entry;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class QCircleSkinHelper
{
  public static final String SKIN_DARK_MODE_CONFIG_PATH = "darkmode/config.ini";
  public static final String SKIN_DEFAULT_MODE_CONFIG_PATH = "defaultmode/config.ini";
  public static final String SKIN_IMAGE_URL_SECTION = "ImageURL";
  public static final String SKIN_PACKAGE_PATH_SP_KEY = "qcircle_skin_package_path";
  private static final String TAG = "QCircleSkinHelper";
  private static volatile QCircleSkinHelper sHelper;
  private boolean isDefaultMode = true;
  private Class<?> mClassObject;
  private Method mColorMethod;
  private Method mColorNameMethod;
  private Context mContext;
  private Method mContextMethod;
  private QCircleIniFile mDefaultIniFile;
  private RFWDownloader.RFWDownloadListener mDownLoadListener;
  private Method mDrawableMethod;
  private Method mDrawableNameMethod;
  private QCircleIniFile mSkinIniFile;
  private long mStartDownloadTime;
  private long mStartLoadTime;
  
  private void findInvokeDtClass(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader();
      if (paramContext == null) {
        return;
      }
      paramContext = paramContext.getParent();
      if (paramContext != null)
      {
        this.mClassObject = paramContext.loadClass("com.tencent.shadow.core.runtime.skin.loader.SkinManager");
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static QCircleSkinHelper getInstance()
  {
    if (sHelper == null) {}
    try
    {
      if (sHelper == null) {
        sHelper = new QCircleSkinHelper();
      }
      return sHelper;
    }
    finally {}
  }
  
  private int getSkinPackageVersion(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    Matcher localMatcher = Pattern.compile("darkmode-v(\\d+).skin").matcher(paramString);
    paramString = "";
    try
    {
      while (localMatcher.find()) {
        paramString = localMatcher.group(1);
      }
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  private void initIniFile()
  {
    ((IThreadManagerApi)QRoute.api(IThreadManagerApi.class)).executeOnSubThread(new QCircleSkinHelper.1(this));
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
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (!QCircleCommonUtil.isInNightMode());
      i = paramString.lastIndexOf('.');
      str = paramString;
    } while (i == -1);
    return paramString.substring(0, i) + "_dark" + paramString.substring(i);
  }
  
  public void downloadSkinPackage(String paramString, QCircleSkinHelper.SkinDownLoadLister paramSkinDownLoadLister)
  {
    String str1 = RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).getDefaultSavePath(paramString);
    String str2 = SharePreferenceUtils.a(MobileQQ.sMobileQQ.getApplicationContext(), "qcircle_skin_package_path");
    if (getSkinPackageVersion(str1) < getSkinPackageVersion(str2)) {}
    do
    {
      return;
      if (!str1.equals(str2)) {
        break;
      }
    } while (paramSkinDownLoadLister == null);
    paramSkinDownLoadLister.onRspCallback(true, str1);
    return;
    if ((new File(str1).exists()) && (paramSkinDownLoadLister != null)) {
      paramSkinDownLoadLister.onRspCallback(true, str1);
    }
    this.mStartDownloadTime = System.currentTimeMillis();
    this.mDownLoadListener = new QCircleSkinHelper.2(this, paramString, paramSkinDownLoadLister, str2);
    RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).download(paramString, this.mDownLoadListener);
  }
  
  public int getColor(int paramInt)
  {
    try
    {
      if (this.isDefaultMode) {
        return this.mContext.getResources().getColor(paramInt);
      }
      if (this.mClassObject == null)
      {
        Log.e("QCircleSkinHelper", "invokeGetColor  firstTime");
        findInvokeDtClass(this.mContext);
      }
      if ((this.mColorMethod == null) && (this.mClassObject != null)) {
        this.mColorMethod = this.mClassObject.getMethod("getColor", new Class[] { Integer.TYPE });
      }
      if (this.mColorMethod != null)
      {
        paramInt = ((Integer)this.mColorMethod.invoke(null, new Object[] { Integer.valueOf(paramInt) })).intValue();
        return paramInt;
      }
      return 0;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public int getColor(String paramString)
  {
    try
    {
      int i;
      if (this.isDefaultMode)
      {
        i = this.mContext.getResources().getIdentifier(paramString, "color", this.mContext.getPackageName());
        return this.mContext.getResources().getColor(i);
      }
      if (this.mClassObject == null)
      {
        Log.e("QCircleSkinHelper", "invokeGetColor  firstTime");
        findInvokeDtClass(this.mContext);
      }
      if ((this.mColorNameMethod == null) && (this.mClassObject != null)) {
        this.mColorNameMethod = this.mClassObject.getMethod("getColor", new Class[] { String.class });
      }
      if (this.mColorNameMethod != null)
      {
        i = ((Integer)this.mColorNameMethod.invoke(null, new Object[] { paramString })).intValue();
        return i;
      }
      return 0;
    }
    catch (Exception paramString)
    {
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
      if (this.mClassObject == null)
      {
        Log.e("QCircleSkinHelper", "invokeGetDrawable  firstTime");
        findInvokeDtClass(this.mContext);
      }
      if ((this.mDrawableMethod == null) && (this.mClassObject != null)) {
        this.mDrawableMethod = this.mClassObject.getMethod("getDrawable", new Class[] { Integer.TYPE });
      }
      if (this.mDrawableMethod != null)
      {
        Drawable localDrawable = (Drawable)this.mDrawableMethod.invoke(null, new Object[] { Integer.valueOf(paramInt) });
        return localDrawable;
      }
      return null;
    }
    catch (Exception localException)
    {
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
      if (this.mClassObject == null)
      {
        Log.e("QCircleSkinHelper", "invokeGetDrawable  firstTime");
        findInvokeDtClass(this.mContext);
      }
      if ((this.mDrawableNameMethod == null) && (this.mClassObject != null)) {
        this.mDrawableNameMethod = this.mClassObject.getMethod("getDrawable", new Class[] { String.class });
      }
      if (this.mDrawableNameMethod != null)
      {
        paramString = (Drawable)this.mDrawableNameMethod.invoke(null, new Object[] { paramString });
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
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
      return (String)this.mDefaultIniFile.get("ImageURL", paramString);
    }
    return (String)this.mSkinIniFile.get("ImageURL", paramString);
  }
  
  public void init(Context paramContext)
  {
    setContext(paramContext);
    this.mDefaultIniFile = new QCircleIniFile();
    this.mSkinIniFile = new QCircleIniFile();
    initIniFile();
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
    this.mStartLoadTime = System.currentTimeMillis();
    try
    {
      if (this.mClassObject == null)
      {
        Log.e("QCircleSkinHelper", "invokeLoadSkin firstTime");
        findInvokeDtClass(this.mContext);
      }
      if (this.mClassObject != null)
      {
        Object localObject = this.mClassObject.getMethod("getsInstance", null).invoke(null, null);
        this.mClassObject.getDeclaredMethod("loadSkinResource", new Class[] { String.class }).invoke(localObject, new Object[] { paramString });
        this.isDefaultMode = false;
        reportLoadSkinEvent("0", (float)(System.currentTimeMillis() - this.mStartLoadTime) / 1000.0F);
        return;
      }
      reportLoadSkinEvent("-1", (float)(System.currentTimeMillis() - this.mStartLoadTime) / 1000.0F);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Log.e("QCircleSkinHelper", "invokeLoadSkin Exception : " + paramString.getMessage());
      reportLoadSkinEvent("-1", (float)(System.currentTimeMillis() - this.mStartLoadTime) / 1000.0F);
    }
  }
  
  public void resetDefaultSkin()
  {
    try
    {
      if (this.mClassObject == null)
      {
        Log.e("QCircleSkinHelper", "invokeResetDefaultSkin  firstTime");
        findInvokeDtClass(this.mContext);
      }
      if (this.mClassObject != null)
      {
        Object localObject = this.mClassObject.getMethod("getsInstance", null).invoke(null, null);
        this.mClassObject.getDeclaredMethod("restoreDefaultTheme", null).invoke(localObject, null);
        this.isDefaultMode = true;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
    try
    {
      if (this.mClassObject == null)
      {
        Log.e("QCircleSkinHelper", "invokeSetContext  firstTime");
        findInvokeDtClass(paramContext);
      }
      if ((this.mContextMethod == null) && (this.mClassObject != null)) {
        this.mContextMethod = this.mClassObject.getMethod("setContext", new Class[] { Context.class });
      }
      if (this.mContextMethod != null) {
        this.mContextMethod.invoke(null, new Object[] { this.mContext });
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.helpers.QCircleSkinHelper
 * JD-Core Version:    0.7.0.1
 */