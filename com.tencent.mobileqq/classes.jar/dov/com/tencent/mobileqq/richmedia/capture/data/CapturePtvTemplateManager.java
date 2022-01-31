package dov.com.tencent.mobileqq.richmedia.capture.data;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import anve;
import anvf;
import anvg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CapturePtvTemplateManager
{
  public static File a;
  public static final Long a;
  static Object jdField_a_of_type_JavaLangObject;
  public static String a;
  public static String b;
  public Handler a;
  CapturePtvTemplateManager.CapturePtvTemplateRefreshListener jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$CapturePtvTemplateRefreshListener;
  CaptureRedDotConfig jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig;
  public List a;
  String c;
  String d;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(60000L);
    jdField_a_of_type_JavaLangString = "ptv_template_usable";
    b = "ptv_debug";
    jdField_a_of_type_JavaLangObject = new Object();
    int i = 0;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Exception localException)
    {
      label42:
      File localFile;
      break label42;
    }
    if (i != 0) {}
    for (localFile = new File(AppConstants.aJ);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      jdField_a_of_type_JavaIoFile = new File(localFile, "capture_ptv_template");
      jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_a_of_type_JavaLangString + File.separator;
      b = jdField_a_of_type_JavaIoFile.getPath() + File.separator + b;
      return;
    }
  }
  
  private CapturePtvTemplateManager()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static final CapturePtvTemplateManager a()
  {
    return anvg.a();
  }
  
  public static String a(File paramFile)
  {
    paramFile = FileUtils.a(paramFile);
    if ((paramFile == null) || (paramFile.length <= 0)) {
      return null;
    }
    if (Build.VERSION.SDK_INT <= 8) {
      return new String(paramFile);
    }
    try
    {
      paramFile = new String(paramFile, "UTF-8");
      return paramFile;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      if (QLog.isDevelopLevel()) {
        paramFile.printStackTrace();
      }
    }
    return null;
  }
  
  public static List a(CapturePtvTemplateManager paramCapturePtvTemplateManager, String paramString, CaptureRedDotConfig paramCaptureRedDotConfig)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "parseConfigRaw " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramCapturePtvTemplateManager != null)
        {
          if (paramString.has("guide_video_url")) {
            paramCapturePtvTemplateManager.c = paramString.getString("guide_video_url");
          }
          if (paramString.has("guide_video_md5")) {
            paramCapturePtvTemplateManager.d = paramString.getString("guide_video_md5");
          }
          if (paramString.has("gestureGapFrame")) {
            com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource.jdField_a_of_type_JavaLangString = paramString.getString("gestureGapFrame");
          }
          if (paramString.has("gestureGapTime")) {
            com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource.b = paramString.getString("gestureGapTime");
          }
          if (paramString.has("gesturethreadcoldtime")) {
            com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource.c = paramString.getString("gesturethreadcoldtime");
          }
          if (paramString.has("gestureShouldUpload")) {
            com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource.jdField_a_of_type_Boolean = paramString.getBoolean("gestureShouldUpload");
          }
        }
        if (paramCaptureRedDotConfig != null)
        {
          int j = paramString.optInt("iconRedDotVersion");
          boolean bool = paramString.optBoolean("needRedDot");
          int k = paramString.optInt("redDotShowTime", CaptureRedDotConfig.SHOW_TIME_DEFAULT);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramCaptureRedDotConfig.iconVersion + ",ver=" + j + ",showRed=" + bool + ",showTime=" + k);
          }
          paramCaptureRedDotConfig.showTime = k;
          if (paramCaptureRedDotConfig.iconVersion != j)
          {
            paramCaptureRedDotConfig.iconVersion = j;
            paramCaptureRedDotConfig.showRedDot = bool;
            paramCaptureRedDotConfig.hasShow = false;
            paramCaptureRedDotConfig.firstShowTime = 0L;
          }
          j = paramString.optInt("defaultCategoryVersion");
          k = paramString.optInt("defaultCategoryId", -1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramCaptureRedDotConfig.defaultCategoryVer + ",ver=" + j + ",defaultCategoryId=" + k);
          }
          if (paramCaptureRedDotConfig.defaultCategoryVer != j)
          {
            paramCaptureRedDotConfig.defaultCategoryVer = j;
            paramCaptureRedDotConfig.defaultCategoryId = k;
            paramCaptureRedDotConfig.hasChoose = false;
          }
          j = paramString.optInt("defaultUseVersion");
          paramCapturePtvTemplateManager = paramString.optString("defaultUseId");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramCaptureRedDotConfig.defaultUseVer + ",ver=" + j + ",defaultUseId=" + paramCapturePtvTemplateManager);
          }
          if (paramCaptureRedDotConfig.defaultUseVer != j)
          {
            paramCaptureRedDotConfig.defaultUseVer = j;
            paramCaptureRedDotConfig.defaultUseId = paramCapturePtvTemplateManager;
            paramCaptureRedDotConfig.hasUse = false;
          }
          j = paramString.optInt("itemRedDotVersion");
          if (paramCaptureRedDotConfig.redDotVersion != j)
          {
            paramCaptureRedDotConfig.redDotVersion = j;
            paramCaptureRedDotConfig.redDotItems.clear();
            if (paramString.has("itemNeedRedDot"))
            {
              paramCapturePtvTemplateManager = new StringBuilder();
              paramCapturePtvTemplateManager.append("parseConfig|redDotList:");
              JSONArray localJSONArray = paramString.getJSONArray("itemNeedRedDot");
              if (i < localJSONArray.length())
              {
                String str = localJSONArray.optString(i);
                if (TextUtils.isEmpty(str)) {
                  break label700;
                }
                CaptureRedDotConfig.RedDotItemConfig localRedDotItemConfig = new CaptureRedDotConfig.RedDotItemConfig();
                localRedDotItemConfig.filterId = str;
                paramCapturePtvTemplateManager.append(str).append(",");
                paramCaptureRedDotConfig.redDotItems.put(str, localRedDotItemConfig);
                break label700;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|redDotItem= " + paramCapturePtvTemplateManager.toString());
              }
            }
          }
        }
        if (!paramString.has("category")) {
          break;
        }
        paramCapturePtvTemplateManager = a(paramString.getJSONArray("category"), paramCaptureRedDotConfig);
        return paramCapturePtvTemplateManager;
      }
      catch (JSONException paramCapturePtvTemplateManager) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      paramCapturePtvTemplateManager.printStackTrace();
      return null;
      label700:
      i += 1;
    }
  }
  
  static List a(JSONArray paramJSONArray, CaptureRedDotConfig paramCaptureRedDotConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "parse config: " + paramJSONArray);
    }
    if (paramJSONArray == null) {
      return null;
    }
    int j = paramJSONArray.length();
    if (j <= 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j) {}
    for (;;)
    {
      TemplateGroupItem localTemplateGroupItem;
      int k;
      boolean bool;
      try
      {
        localTemplateGroupItem = new TemplateGroupItem();
        localObject = paramJSONArray.getJSONObject(i);
        if (((JSONObject)localObject).has("content")) {
          localTemplateGroupItem.jdField_a_of_type_JavaUtilList = PtvTemplateManager.PtvTemplateInfo.convertFrom(((JSONObject)localObject).getJSONArray("content"));
        }
        if (((JSONObject)localObject).has("categoryName")) {
          localTemplateGroupItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("categoryName");
        }
        if (!((JSONObject)localObject).has("categoryId")) {
          break label381;
        }
        localTemplateGroupItem.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("categoryId");
        if (paramCaptureRedDotConfig == null) {
          break label401;
        }
        k = ((JSONObject)localObject).optInt("redDotVersion");
        bool = ((JSONObject)localObject).optBoolean("needRedDot");
        localObject = (CaptureRedDotConfig.CategoryRedConfig)paramCaptureRedDotConfig.categories.get(Integer.valueOf(localTemplateGroupItem.jdField_a_of_type_Int));
        if (localObject != null)
        {
          if (((CaptureRedDotConfig.CategoryRedConfig)localObject).version == k) {
            break label398;
          }
          ((CaptureRedDotConfig.CategoryRedConfig)localObject).version = k;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject).showRedDot = bool;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject).hasShow = false;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject).firstShowTime = 0L;
          if ((localTemplateGroupItem.jdField_a_of_type_JavaUtilList == null) || (localTemplateGroupItem.jdField_a_of_type_JavaUtilList.isEmpty())) {
            break label354;
          }
          Iterator localIterator = localTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
          if (!localIterator.hasNext()) {
            break label354;
          }
          ((PtvTemplateManager.PtvTemplateInfo)localIterator.next()).categoryId = localTemplateGroupItem.jdField_a_of_type_Int;
          continue;
          return localArrayList;
        }
      }
      catch (JSONException paramJSONArray)
      {
        if (QLog.isColorLevel()) {
          paramJSONArray.printStackTrace();
        }
      }
      Object localObject = new CaptureRedDotConfig.CategoryRedConfig();
      ((CaptureRedDotConfig.CategoryRedConfig)localObject).categoryId = localTemplateGroupItem.jdField_a_of_type_Int;
      ((CaptureRedDotConfig.CategoryRedConfig)localObject).version = k;
      ((CaptureRedDotConfig.CategoryRedConfig)localObject).showRedDot = bool;
      continue;
      label354:
      if ((paramCaptureRedDotConfig != null) && (localObject != null)) {
        paramCaptureRedDotConfig.categories.put(Integer.valueOf(((CaptureRedDotConfig.CategoryRedConfig)localObject).categoryId), localObject);
      }
      label381:
      localArrayList.add(localTemplateGroupItem);
      i += 1;
      break;
      label398:
      continue;
      label401:
      localObject = null;
    }
  }
  
  private void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("rebuildTemplateInfos, cur_runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {}
    do
    {
      return;
      paramFile = a(paramFile);
    } while (TextUtils.isEmpty(paramFile));
    paramFile = a(a(), paramFile, null);
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig_PTV", 2, "rebuildTemplateInfos");
    }
    a(paramFile);
  }
  
  @TargetApi(9)
  public void a()
  {
    b();
    File localFile = new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg");
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "initLocalTemplateConfigInfo config file not exist.");
      }
      a(false);
      return;
    }
    a(localFile);
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      ThreadManager.getSubThreadHandler().post(new anvf(this));
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "updateFaceuTemplateConfigInfo size=" + this.jdField_a_of_type_JavaUtilList.size());
      }
    } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$CapturePtvTemplateRefreshListener == null);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$CapturePtvTemplateRefreshListener.a();
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new anve(this, paramBoolean), null, false);
  }
  
  /* Error */
  public boolean a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: getfield 515	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   8: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: new 59	java/io/File
    //   19: dup
    //   20: getstatic 74	dov/com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   23: aload_1
    //   24: getfield 515	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   27: invokespecial 72	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual 464	java/io/File:exists	()Z
    //   35: ifeq -21 -> 14
    //   38: aload_2
    //   39: invokevirtual 80	java/io/File:getPath	()Ljava/lang/String;
    //   42: invokestatic 517	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_2
    //   46: aload_2
    //   47: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne -36 -> 14
    //   53: aload_2
    //   54: aload_1
    //   55: getfield 520	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:md5	Ljava/lang/String;
    //   58: invokevirtual 523	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   61: ifeq -47 -> 14
    //   64: new 76	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   71: getstatic 34	dov/com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: getfield 515	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   81: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 87	java/io/File:separator	Ljava/lang/String;
    //   87: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_3
    //   94: new 59	java/io/File
    //   97: dup
    //   98: aload_3
    //   99: ldc_w 525
    //   102: invokespecial 528	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: astore_2
    //   106: new 59	java/io/File
    //   109: dup
    //   110: aload_3
    //   111: ldc_w 530
    //   114: invokespecial 528	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: astore_3
    //   118: aload_2
    //   119: invokevirtual 464	java/io/File:exists	()Z
    //   122: ifne +58 -> 180
    //   125: aload_3
    //   126: invokevirtual 464	java/io/File:exists	()Z
    //   129: ifne +51 -> 180
    //   132: new 59	java/io/File
    //   135: dup
    //   136: getstatic 74	dov/com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   139: aload_1
    //   140: getfield 515	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   143: invokespecial 72	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   146: getstatic 34	dov/com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   149: invokestatic 534	com/tencent/biz/common/util/ZipUtils:a	(Ljava/io/File;Ljava/lang/String;)V
    //   152: iconst_1
    //   153: ireturn
    //   154: astore_1
    //   155: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq -144 -> 14
    //   161: aload_1
    //   162: invokevirtual 535	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_1
    //   168: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq -157 -> 14
    //   174: aload_1
    //   175: invokevirtual 536	java/lang/Exception:printStackTrace	()V
    //   178: iconst_0
    //   179: ireturn
    //   180: iconst_1
    //   181: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	CapturePtvTemplateManager
    //   0	182	1	paramPtvTemplateInfo	PtvTemplateManager.PtvTemplateInfo
    //   30	89	2	localObject1	Object
    //   93	33	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	46	154	java/lang/UnsatisfiedLinkError
    //   132	152	167	java/lang/Exception
  }
  
  public void b()
  {
    CaptureRedDotConfig localCaptureRedDotConfig = CaptureRedDotConfig.getRedDotConfigFromFile(jdField_a_of_type_JavaIoFile.getAbsolutePath(), "_PTV");
    if (localCaptureRedDotConfig != null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */