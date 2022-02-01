package com.tencent.mobileqq.richmedia.capture.data;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
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
  public static File b;
  public static String b;
  public static String c;
  public Handler a;
  CapturePtvTemplateManager.CapturePtvTemplateRefreshListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$CapturePtvTemplateRefreshListener;
  CaptureRedDotConfig jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig;
  HashMap<Integer, CapturePtvTemplateManager.BusinessParam> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<TemplateGroupItem> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  String d;
  String e;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(2000L);
    jdField_a_of_type_JavaLangString = "ptv_template_usable";
    jdField_b_of_type_JavaLangString = "ptv_debug";
    c = "new_ptv_template_usable";
    jdField_a_of_type_JavaLangObject = new Object();
    Object localObject = BaseApplicationImpl.getApplication().getCacheDir();
    jdField_a_of_type_JavaIoFile = new File((File)localObject, "capture_ptv_template");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaIoFile.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaIoFile.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    jdField_b_of_type_JavaIoFile = new File((File)localObject, "new_ptv_template");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_b_of_type_JavaIoFile.getPath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(c);
    ((StringBuilder)localObject).append(File.separator);
    c = ((StringBuilder)localObject).toString();
  }
  
  private CapturePtvTemplateManager()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static final CapturePtvTemplateManager a()
  {
    return CapturePtvTemplateManager.CapturePtvTemplateManagerHolder.a();
  }
  
  public static String a(File paramFile)
  {
    paramFile = FileUtils.fileToBytes(paramFile);
    if (paramFile != null)
    {
      if (paramFile.length <= 0) {
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
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    if (new File(paramString1).exists()) {
      return paramString1;
    }
    return localObject;
  }
  
  static List<TemplateGroupItem> a(CapturePtvTemplateManager paramCapturePtvTemplateManager, String paramString, CaptureRedDotConfig paramCaptureRedDotConfig)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseConfigRaw ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("CapturePtvTemplateManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (paramCapturePtvTemplateManager != null)
        {
          if (localJSONObject.has("guide_video_url")) {
            paramCapturePtvTemplateManager.d = localJSONObject.getString("guide_video_url");
          }
          if (localJSONObject.has("guide_video_md5")) {
            paramCapturePtvTemplateManager.e = localJSONObject.getString("guide_video_md5");
          }
          if (localJSONObject.has("gestureGapFrame")) {
            com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource.jdField_a_of_type_JavaLangString = localJSONObject.getString("gestureGapFrame");
          }
          if (localJSONObject.has("gestureGapTime")) {
            com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource.jdField_b_of_type_JavaLangString = localJSONObject.getString("gestureGapTime");
          }
          if (localJSONObject.has("gesturethreadcoldtime")) {
            com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource.c = localJSONObject.getString("gesturethreadcoldtime");
          }
          if (localJSONObject.has("gestureShouldUpload")) {
            com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource.jdField_a_of_type_Boolean = localJSONObject.getBoolean("gestureShouldUpload");
          }
        }
        boolean bool1 = localJSONObject.has("bigheadCommonRes");
        paramString = "";
        if (!bool1) {
          break label912;
        }
        paramCapturePtvTemplateManager = localJSONObject.getJSONObject("bigheadCommonRes");
        if (paramCapturePtvTemplateManager == null) {
          break label912;
        }
        paramString = paramCapturePtvTemplateManager.optString("bighead_model_name", "");
        localObject1 = paramCapturePtvTemplateManager.optString("bighead_model_resurl", "");
        paramCapturePtvTemplateManager = paramCapturePtvTemplateManager.optString("bighead_model_resmd5", "");
        if (paramCaptureRedDotConfig != null)
        {
          int j = localJSONObject.optInt("iconRedDotVersion");
          bool1 = localJSONObject.optBoolean("needRedDot");
          i = localJSONObject.optInt("redDotShowTime", CaptureRedDotConfig.SHOW_TIME_DEFAULT);
          boolean bool2 = QLog.isColorLevel();
          if (bool2)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("parseConfig|oldVer= ");
            ((StringBuilder)localObject2).append(paramCaptureRedDotConfig.iconVersion);
            ((StringBuilder)localObject2).append(",ver=");
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject2).append(",showRed=");
            ((StringBuilder)localObject2).append(bool1);
            ((StringBuilder)localObject2).append(",showTime=");
            ((StringBuilder)localObject2).append(i);
            QLog.d("QIMRedDotConfig_PTV", 2, ((StringBuilder)localObject2).toString());
          }
          paramCaptureRedDotConfig.showTime = i;
          int k = paramCaptureRedDotConfig.iconVersion;
          i = 0;
          if (k != j)
          {
            paramCaptureRedDotConfig.iconVersion = j;
            paramCaptureRedDotConfig.showRedDot = bool1;
            paramCaptureRedDotConfig.hasShow = false;
            paramCaptureRedDotConfig.firstShowTime = 0L;
          }
          j = localJSONObject.optInt("defaultCategoryVersion");
          k = localJSONObject.optInt("defaultCategoryId", -1);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("parseConfig|oldVer= ");
            ((StringBuilder)localObject2).append(paramCaptureRedDotConfig.defaultCategoryVer);
            ((StringBuilder)localObject2).append(",ver=");
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject2).append(",defaultCategoryId=");
            ((StringBuilder)localObject2).append(k);
            QLog.d("QIMRedDotConfig_PTV", 2, ((StringBuilder)localObject2).toString());
          }
          if (paramCaptureRedDotConfig.defaultCategoryVer != j)
          {
            paramCaptureRedDotConfig.defaultCategoryVer = j;
            paramCaptureRedDotConfig.defaultCategoryId = k;
            paramCaptureRedDotConfig.hasChoose = false;
          }
          j = localJSONObject.optInt("defaultUseVersion");
          Object localObject2 = localJSONObject.optString("defaultUseId");
          Object localObject3;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("parseConfig|oldVer= ");
            ((StringBuilder)localObject3).append(paramCaptureRedDotConfig.defaultUseVer);
            ((StringBuilder)localObject3).append(",ver=");
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append(",defaultUseId=");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("QIMRedDotConfig_PTV", 2, ((StringBuilder)localObject3).toString());
          }
          if (paramCaptureRedDotConfig.defaultUseVer != j)
          {
            paramCaptureRedDotConfig.defaultUseVer = j;
            paramCaptureRedDotConfig.defaultUseId = ((String)localObject2);
            paramCaptureRedDotConfig.hasUse = false;
          }
          j = localJSONObject.optInt("itemRedDotVersion");
          if (paramCaptureRedDotConfig.redDotVersion != j)
          {
            paramCaptureRedDotConfig.redDotVersion = j;
            paramCaptureRedDotConfig.redDotItems.clear();
            if (localJSONObject.has("itemNeedRedDot"))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("parseConfig|redDotList:");
              localObject3 = localJSONObject.getJSONArray("itemNeedRedDot");
              if (i < ((JSONArray)localObject3).length())
              {
                String str = ((JSONArray)localObject3).optString(i);
                if (TextUtils.isEmpty(str)) {
                  break label921;
                }
                CaptureRedDotConfig.RedDotItemConfig localRedDotItemConfig = new CaptureRedDotConfig.RedDotItemConfig();
                localRedDotItemConfig.filterId = str;
                ((StringBuilder)localObject2).append(str);
                ((StringBuilder)localObject2).append(",");
                paramCaptureRedDotConfig.redDotItems.put(str, localRedDotItemConfig);
                break label921;
              }
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("parseConfig|redDotItem= ");
                ((StringBuilder)localObject3).append(((StringBuilder)localObject2).toString());
                QLog.d("QIMRedDotConfig_PTV", 2, ((StringBuilder)localObject3).toString());
              }
            }
          }
        }
        if (localJSONObject.has("category"))
        {
          paramCaptureRedDotConfig = a(localJSONObject.getJSONArray("category"), paramCaptureRedDotConfig);
          a(paramCaptureRedDotConfig, paramString, (String)localObject1, paramCapturePtvTemplateManager);
          return paramCaptureRedDotConfig;
        }
      }
      catch (JSONException paramCapturePtvTemplateManager)
      {
        if (QLog.isColorLevel()) {
          paramCapturePtvTemplateManager.printStackTrace();
        }
      }
      return null;
      label912:
      paramCapturePtvTemplateManager = "";
      localObject1 = paramCapturePtvTemplateManager;
      continue;
      label921:
      i += 1;
    }
  }
  
  /* Error */
  static List<TemplateGroupItem> a(JSONArray paramJSONArray, CaptureRedDotConfig paramCaptureRedDotConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 8
    //   3: ldc_w 378
    //   6: astore 7
    //   8: ldc_w 380
    //   11: astore 6
    //   13: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +40 -> 56
    //   19: new 70	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   26: astore 9
    //   28: aload 9
    //   30: ldc_w 382
    //   33: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 9
    //   39: aload 8
    //   41: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 172
    //   47: iconst_2
    //   48: aload 9
    //   50: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 176	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload 8
    //   58: ifnonnull +5 -> 63
    //   61: aconst_null
    //   62: areturn
    //   63: aload_0
    //   64: invokevirtual 346	org/json/JSONArray:length	()I
    //   67: istore_3
    //   68: iload_3
    //   69: ifgt +5 -> 74
    //   72: aconst_null
    //   73: areturn
    //   74: new 387	java/util/ArrayList
    //   77: dup
    //   78: invokespecial 388	java/util/ArrayList:<init>	()V
    //   81: astore 13
    //   83: iconst_0
    //   84: istore_2
    //   85: aload_1
    //   86: astore 9
    //   88: iload_2
    //   89: iload_3
    //   90: if_icmpge +753 -> 843
    //   93: new 390	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem
    //   96: dup
    //   97: invokespecial 391	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:<init>	()V
    //   100: astore 14
    //   102: aload_0
    //   103: iload_2
    //   104: invokevirtual 394	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   107: astore 12
    //   109: aload 12
    //   111: ldc_w 396
    //   114: invokevirtual 191	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   117: ifeq +19 -> 136
    //   120: aload 14
    //   122: aload 12
    //   124: ldc_w 396
    //   127: invokevirtual 340	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   130: invokestatic 402	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:convertFrom	(Lorg/json/JSONArray;)Ljava/util/List;
    //   133: putfield 403	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   136: aload 12
    //   138: ldc_w 405
    //   141: invokevirtual 191	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   144: ifeq +16 -> 160
    //   147: aload 14
    //   149: aload 12
    //   151: ldc_w 405
    //   154: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: putfield 406	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   160: aload 12
    //   162: ldc_w 408
    //   165: invokevirtual 191	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   168: ifeq +38 -> 206
    //   171: aload 12
    //   173: aload 6
    //   175: invokevirtual 191	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   178: ifeq +28 -> 206
    //   181: aload 14
    //   183: aload 12
    //   185: ldc_w 408
    //   188: invokevirtual 411	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   191: putfield 413	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_b_of_type_Int	I
    //   194: aload 14
    //   196: aload 12
    //   198: aload 6
    //   200: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   203: putfield 414	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   206: aload 12
    //   208: ldc_w 416
    //   211: invokevirtual 191	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   214: ifeq +641 -> 855
    //   217: aload 14
    //   219: aload 12
    //   221: ldc_w 416
    //   224: invokevirtual 411	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   227: putfield 418	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_Int	I
    //   230: aload 9
    //   232: ifnull +617 -> 849
    //   235: aload 12
    //   237: ldc_w 419
    //   240: invokevirtual 242	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   243: istore 4
    //   245: aload 12
    //   247: ldc 244
    //   249: invokevirtual 247	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   252: istore 5
    //   254: aload 9
    //   256: getfield 422	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig:categories	Ljava/util/HashMap;
    //   259: aload 14
    //   261: getfield 418	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_Int	I
    //   264: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: invokevirtual 431	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   270: checkcast 433	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig
    //   273: astore 8
    //   275: aload 8
    //   277: ifnull +42 -> 319
    //   280: aload 8
    //   282: getfield 436	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig:version	I
    //   285: iload 4
    //   287: if_icmpeq +559 -> 846
    //   290: aload 8
    //   292: iload 4
    //   294: putfield 436	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig:version	I
    //   297: aload 8
    //   299: iload 5
    //   301: putfield 437	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig:showRedDot	Z
    //   304: aload 8
    //   306: iconst_0
    //   307: putfield 438	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig:hasShow	Z
    //   310: aload 8
    //   312: lconst_0
    //   313: putfield 439	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig:firstShowTime	J
    //   316: goto +39 -> 355
    //   319: new 433	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig
    //   322: dup
    //   323: invokespecial 440	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig:<init>	()V
    //   326: astore 8
    //   328: aload 8
    //   330: aload 14
    //   332: getfield 418	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_Int	I
    //   335: putfield 442	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig:categoryId	I
    //   338: aload 8
    //   340: iload 4
    //   342: putfield 436	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig:version	I
    //   345: aload 8
    //   347: iload 5
    //   349: putfield 437	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig:showRedDot	Z
    //   352: goto +3 -> 355
    //   355: aload 14
    //   357: getfield 403	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   360: ifnull +73 -> 433
    //   363: aload 14
    //   365: getfield 403	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   368: invokeinterface 446 1 0
    //   373: ifne +60 -> 433
    //   376: aload 14
    //   378: getfield 403	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   381: invokeinterface 450 1 0
    //   386: astore 10
    //   388: aload 10
    //   390: invokeinterface 455 1 0
    //   395: ifeq +38 -> 433
    //   398: aload 10
    //   400: invokeinterface 459 1 0
    //   405: checkcast 398	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo
    //   408: astore 11
    //   410: aload 11
    //   412: aload 14
    //   414: getfield 418	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_Int	I
    //   417: putfield 460	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:categoryId	I
    //   420: aload 11
    //   422: aload 14
    //   424: getfield 406	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   427: putfield 462	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:categoryName	Ljava/lang/String;
    //   430: goto -42 -> 388
    //   433: aload 9
    //   435: ifnull +30 -> 465
    //   438: aload 8
    //   440: ifnull +25 -> 465
    //   443: aload 9
    //   445: getfield 422	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig:categories	Ljava/util/HashMap;
    //   448: aload 8
    //   450: getfield 442	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig$CategoryRedConfig:categoryId	I
    //   453: invokestatic 427	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   456: aload 8
    //   458: invokevirtual 361	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   461: pop
    //   462: goto +3 -> 465
    //   465: aload 12
    //   467: aload 7
    //   469: invokevirtual 191	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   472: istore 5
    //   474: aload 7
    //   476: astore 11
    //   478: aload 6
    //   480: astore 10
    //   482: iload 5
    //   484: ifeq +374 -> 858
    //   487: aload 7
    //   489: astore 9
    //   491: aload 6
    //   493: astore 8
    //   495: aload 12
    //   497: aload 7
    //   499: invokevirtual 227	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   502: astore 10
    //   504: aload 7
    //   506: astore 9
    //   508: aload 6
    //   510: astore 8
    //   512: aload 10
    //   514: ldc_w 464
    //   517: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   520: astore 15
    //   522: aload 7
    //   524: astore 9
    //   526: aload 6
    //   528: astore 8
    //   530: aload 15
    //   532: invokestatic 468	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Ljava/lang/String;)Z
    //   535: pop
    //   536: aload 7
    //   538: astore 9
    //   540: aload 6
    //   542: astore 8
    //   544: aload 10
    //   546: ldc_w 470
    //   549: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   552: astore 16
    //   554: aload 7
    //   556: astore 9
    //   558: aload 6
    //   560: astore 8
    //   562: aload 10
    //   564: ldc_w 472
    //   567: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   570: astore 17
    //   572: aload 7
    //   574: astore 9
    //   576: aload 6
    //   578: astore 8
    //   580: aload 10
    //   582: ldc_w 474
    //   585: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   588: astore 18
    //   590: aload 7
    //   592: astore 9
    //   594: aload 6
    //   596: astore 8
    //   598: aload 10
    //   600: ldc_w 476
    //   603: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   606: astore 19
    //   608: aload 7
    //   610: astore 9
    //   612: aload 6
    //   614: astore 8
    //   616: aload 10
    //   618: ldc_w 478
    //   621: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   624: astore 20
    //   626: aload 7
    //   628: astore 9
    //   630: aload 6
    //   632: astore 8
    //   634: aload 7
    //   636: astore 11
    //   638: aload 6
    //   640: astore 10
    //   642: aload 14
    //   644: getfield 403	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   647: ifnull +211 -> 858
    //   650: aload 7
    //   652: astore 9
    //   654: aload 6
    //   656: astore 8
    //   658: aload 14
    //   660: getfield 403	com/tencent/mobileqq/richmedia/capture/data/TemplateGroupItem:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   663: invokeinterface 450 1 0
    //   668: astore 12
    //   670: aload 7
    //   672: astore 9
    //   674: aload 6
    //   676: astore 8
    //   678: aload 7
    //   680: astore 11
    //   682: aload 6
    //   684: astore 10
    //   686: aload 12
    //   688: invokeinterface 455 1 0
    //   693: ifeq +165 -> 858
    //   696: aload 7
    //   698: astore 9
    //   700: aload 6
    //   702: astore 8
    //   704: aload 12
    //   706: invokeinterface 459 1 0
    //   711: checkcast 398	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo
    //   714: astore 10
    //   716: aload 10
    //   718: getfield 481	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:kind	I
    //   721: istore 4
    //   723: iload 4
    //   725: iconst_3
    //   726: if_icmpeq +12 -> 738
    //   729: aload 10
    //   731: getfield 481	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:kind	I
    //   734: iconst_4
    //   735: if_icmpne +45 -> 780
    //   738: aload 10
    //   740: aload 15
    //   742: putfield 484	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:dgStageName	Ljava/lang/String;
    //   745: aload 10
    //   747: aload 16
    //   749: putfield 487	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:dgStageResurl	Ljava/lang/String;
    //   752: aload 10
    //   754: aload 17
    //   756: putfield 490	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:dgStageResmd5	Ljava/lang/String;
    //   759: aload 10
    //   761: aload 18
    //   763: putfield 493	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:dgModelName	Ljava/lang/String;
    //   766: aload 10
    //   768: aload 19
    //   770: putfield 496	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:dgModelResurl	Ljava/lang/String;
    //   773: aload 10
    //   775: aload 20
    //   777: putfield 499	com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:dgModelResmd5	Ljava/lang/String;
    //   780: goto -110 -> 670
    //   783: astore 8
    //   785: goto +22 -> 807
    //   788: astore 8
    //   790: goto +17 -> 807
    //   793: astore 10
    //   795: aload 9
    //   797: astore 7
    //   799: aload 8
    //   801: astore 6
    //   803: aload 10
    //   805: astore 8
    //   807: aload 8
    //   809: invokevirtual 500	java/lang/Exception:printStackTrace	()V
    //   812: goto +3 -> 815
    //   815: aload 13
    //   817: aload 14
    //   819: invokeinterface 504 2 0
    //   824: pop
    //   825: iload_2
    //   826: iconst_1
    //   827: iadd
    //   828: istore_2
    //   829: goto -744 -> 85
    //   832: astore_0
    //   833: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   836: ifeq +7 -> 843
    //   839: aload_0
    //   840: invokevirtual 372	org/json/JSONException:printStackTrace	()V
    //   843: aload 13
    //   845: areturn
    //   846: goto -491 -> 355
    //   849: aconst_null
    //   850: astore 8
    //   852: goto -497 -> 355
    //   855: goto -390 -> 465
    //   858: aload 11
    //   860: astore 7
    //   862: aload 10
    //   864: astore 6
    //   866: goto -51 -> 815
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	869	0	paramJSONArray	JSONArray
    //   0	869	1	paramCaptureRedDotConfig	CaptureRedDotConfig
    //   84	745	2	i	int
    //   67	24	3	j	int
    //   243	484	4	k	int
    //   252	231	5	bool	boolean
    //   11	854	6	localObject1	Object
    //   6	855	7	localObject2	Object
    //   1	702	8	localObject3	Object
    //   783	1	8	localException1	Exception
    //   788	12	8	localException2	Exception
    //   805	46	8	localObject4	Object
    //   26	770	9	localObject5	Object
    //   386	388	10	localObject6	Object
    //   793	70	10	localException3	Exception
    //   408	451	11	localObject7	Object
    //   107	598	12	localObject8	Object
    //   81	763	13	localArrayList	ArrayList
    //   100	718	14	localTemplateGroupItem	TemplateGroupItem
    //   520	221	15	str1	String
    //   552	196	16	str2	String
    //   570	185	17	str3	String
    //   588	174	18	str4	String
    //   606	163	19	str5	String
    //   624	152	20	str6	String
    // Exception table:
    //   from	to	target	type
    //   729	738	783	java/lang/Exception
    //   738	780	783	java/lang/Exception
    //   716	723	788	java/lang/Exception
    //   495	504	793	java/lang/Exception
    //   512	522	793	java/lang/Exception
    //   530	536	793	java/lang/Exception
    //   544	554	793	java/lang/Exception
    //   562	572	793	java/lang/Exception
    //   580	590	793	java/lang/Exception
    //   598	608	793	java/lang/Exception
    //   616	626	793	java/lang/Exception
    //   642	650	793	java/lang/Exception
    //   658	670	793	java/lang/Exception
    //   686	696	793	java/lang/Exception
    //   704	716	793	java/lang/Exception
    //   93	136	832	org/json/JSONException
    //   136	160	832	org/json/JSONException
    //   160	206	832	org/json/JSONException
    //   206	230	832	org/json/JSONException
    //   235	275	832	org/json/JSONException
    //   280	316	832	org/json/JSONException
    //   319	352	832	org/json/JSONException
    //   355	388	832	org/json/JSONException
    //   388	430	832	org/json/JSONException
    //   443	462	832	org/json/JSONException
    //   465	474	832	org/json/JSONException
    //   495	504	832	org/json/JSONException
    //   512	522	832	org/json/JSONException
    //   530	536	832	org/json/JSONException
    //   544	554	832	org/json/JSONException
    //   562	572	832	org/json/JSONException
    //   580	590	832	org/json/JSONException
    //   598	608	832	org/json/JSONException
    //   616	626	832	org/json/JSONException
    //   642	650	832	org/json/JSONException
    //   658	670	832	org/json/JSONException
    //   686	696	832	org/json/JSONException
    //   704	716	832	org/json/JSONException
    //   716	723	832	org/json/JSONException
    //   729	738	832	org/json/JSONException
    //   738	780	832	org/json/JSONException
    //   807	812	832	org/json/JSONException
    //   815	825	832	org/json/JSONException
  }
  
  /* Error */
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: getstatic 49	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 508	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig	Lcom/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig;
    //   10: ifnonnull +31 -> 41
    //   13: aload_0
    //   14: new 251	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig
    //   17: dup
    //   18: iconst_2
    //   19: invokespecial 511	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig:<init>	(I)V
    //   22: putfield 508	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig	Lcom/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig;
    //   25: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +13 -> 41
    //   31: ldc_w 276
    //   34: iconst_2
    //   35: ldc_w 513
    //   38: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_3
    //   42: monitorexit
    //   43: aload_2
    //   44: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +24 -> 71
    //   50: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +13 -> 66
    //   56: ldc_w 515
    //   59: iconst_2
    //   60: ldc_w 517
    //   63: invokestatic 520	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iconst_m1
    //   67: invokestatic 524	com/tencent/mobileqq/activity/richmedia/NewFlowCameraReporter:a	(I)V
    //   70: return
    //   71: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +36 -> 110
    //   77: new 70	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   84: astore_3
    //   85: aload_3
    //   86: ldc_w 526
    //   89: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_3
    //   94: aload_2
    //   95: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: ldc_w 515
    //   102: iconst_2
    //   103: aload_3
    //   104: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 520	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: new 184	org/json/JSONObject
    //   113: dup
    //   114: aload_2
    //   115: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   118: astore 5
    //   120: ldc 223
    //   122: astore_2
    //   123: ldc 223
    //   125: astore_3
    //   126: ldc 223
    //   128: astore 4
    //   130: aload 5
    //   132: ldc_w 528
    //   135: invokevirtual 191	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   138: ifeq +12 -> 150
    //   141: aload 5
    //   143: ldc_w 528
    //   146: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore_2
    //   150: aload 5
    //   152: ldc_w 530
    //   155: invokevirtual 191	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   158: ifeq +12 -> 170
    //   161: aload 5
    //   163: ldc_w 530
    //   166: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore_3
    //   170: aload 5
    //   172: ldc_w 532
    //   175: invokevirtual 191	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   178: ifeq +13 -> 191
    //   181: aload 5
    //   183: ldc_w 532
    //   186: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 4
    //   191: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +56 -> 250
    //   197: new 70	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   204: astore 5
    //   206: aload 5
    //   208: ldc_w 534
    //   211: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 5
    //   217: aload_2
    //   218: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 5
    //   224: ldc_w 536
    //   227: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 5
    //   233: aload_3
    //   234: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: ldc_w 515
    //   241: iconst_2
    //   242: aload 5
    //   244: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload_2
    //   251: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +318 -> 572
    //   257: aload_3
    //   258: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   261: ifeq +6 -> 267
    //   264: goto +308 -> 572
    //   267: new 70	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   274: astore 5
    //   276: aload 5
    //   278: getstatic 68	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   281: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 5
    //   287: getstatic 82	java/io/File:separator	Ljava/lang/String;
    //   290: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 5
    //   296: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: astore 5
    //   301: new 70	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   308: astore 6
    //   310: aload 6
    //   312: getstatic 68	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   315: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 6
    //   321: getstatic 82	java/io/File:separator	Ljava/lang/String;
    //   324: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 6
    //   330: aload 4
    //   332: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 6
    //   338: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: astore 4
    //   343: new 61	java/io/File
    //   346: dup
    //   347: getstatic 68	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   350: ldc_w 538
    //   353: invokespecial 66	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   356: astore 6
    //   358: aload 6
    //   360: invokevirtual 162	java/io/File:exists	()Z
    //   363: ifeq +25 -> 388
    //   366: aload 6
    //   368: invokevirtual 541	java/io/File:delete	()Z
    //   371: pop
    //   372: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +13 -> 388
    //   378: ldc_w 515
    //   381: iconst_2
    //   382: ldc_w 543
    //   385: invokestatic 520	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: new 61	java/io/File
    //   391: dup
    //   392: aload 4
    //   394: invokespecial 159	java/io/File:<init>	(Ljava/lang/String;)V
    //   397: astore 7
    //   399: aload 7
    //   401: invokevirtual 162	java/io/File:exists	()Z
    //   404: ifeq +25 -> 429
    //   407: aload 7
    //   409: invokevirtual 541	java/io/File:delete	()Z
    //   412: pop
    //   413: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   416: ifeq +13 -> 429
    //   419: ldc_w 515
    //   422: iconst_2
    //   423: ldc_w 545
    //   426: invokestatic 520	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: new 547	com/tencent/mobileqq/transfile/HttpNetReq
    //   432: dup
    //   433: invokespecial 548	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   436: astore 7
    //   438: aload 7
    //   440: new 550	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager$3
    //   443: dup
    //   444: aload_0
    //   445: aload_2
    //   446: aload 5
    //   448: aload_1
    //   449: aload 4
    //   451: invokespecial 553	com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager$3:<init>	(Lcom/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   454: putfield 557	com/tencent/mobileqq/transfile/HttpNetReq:mCallback	Lcom/tencent/mobileqq/transfile/INetEngineListener;
    //   457: aload 7
    //   459: aload_3
    //   460: putfield 560	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   463: aload 7
    //   465: iconst_0
    //   466: putfield 563	com/tencent/mobileqq/transfile/HttpNetReq:mHttpMethod	I
    //   469: aload 7
    //   471: aload 6
    //   473: invokevirtual 75	java/io/File:getPath	()Ljava/lang/String;
    //   476: putfield 566	com/tencent/mobileqq/transfile/HttpNetReq:mOutPath	Ljava/lang/String;
    //   479: aload 7
    //   481: invokestatic 572	com/tencent/mobileqq/transfile/NetworkCenter:getInstance	()Lcom/tencent/mobileqq/transfile/NetworkCenter;
    //   484: invokevirtual 575	com/tencent/mobileqq/transfile/NetworkCenter:getNetType	()I
    //   487: invokestatic 581	com/tencent/mobileqq/utils/NetworkUtil:getConnRetryTimes	(I)I
    //   490: putfield 584	com/tencent/mobileqq/transfile/HttpNetReq:mContinuErrorLimit	I
    //   493: invokestatic 55	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   496: invokevirtual 588	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   499: astore_1
    //   500: ldc_w 590
    //   503: aload_1
    //   504: invokevirtual 595	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   507: ifeq +97 -> 604
    //   510: aload_1
    //   511: checkcast 590	com/tencent/mobileqq/app/QQAppInterface
    //   514: ldc_w 597
    //   517: ldc_w 599
    //   520: invokevirtual 603	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   523: checkcast 597	com/tencent/mobileqq/transfile/api/IHttpEngineService
    //   526: aload 7
    //   528: invokeinterface 607 2 0
    //   533: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +68 -> 604
    //   539: new 70	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   546: astore_1
    //   547: aload_1
    //   548: ldc_w 609
    //   551: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload_1
    //   556: aload_3
    //   557: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: ldc 172
    //   563: iconst_2
    //   564: aload_1
    //   565: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 176	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: return
    //   572: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +13 -> 588
    //   578: ldc_w 515
    //   581: iconst_2
    //   582: ldc_w 611
    //   585: invokestatic 520	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: iconst_m1
    //   589: invokestatic 524	com/tencent/mobileqq/activity/richmedia/NewFlowCameraReporter:a	(I)V
    //   592: return
    //   593: astore_1
    //   594: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +7 -> 604
    //   600: aload_1
    //   601: invokevirtual 372	org/json/JSONException:printStackTrace	()V
    //   604: return
    //   605: astore_1
    //   606: aload_3
    //   607: monitorexit
    //   608: aload_1
    //   609: athrow
    //   610: astore_1
    //   611: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	612	0	this	CapturePtvTemplateManager
    //   0	612	1	paramQQAppInterface	QQAppInterface
    //   0	612	2	paramString	String
    //   3	604	3	localObject1	Object
    //   128	322	4	str	String
    //   118	329	5	localObject2	Object
    //   308	164	6	localObject3	Object
    //   397	130	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   110	120	593	org/json/JSONException
    //   130	150	593	org/json/JSONException
    //   150	170	593	org/json/JSONException
    //   170	191	593	org/json/JSONException
    //   191	250	593	org/json/JSONException
    //   250	264	593	org/json/JSONException
    //   267	388	593	org/json/JSONException
    //   388	429	593	org/json/JSONException
    //   429	493	593	org/json/JSONException
    //   493	571	593	org/json/JSONException
    //   572	588	593	org/json/JSONException
    //   588	592	593	org/json/JSONException
    //   6	41	605	finally
    //   41	43	605	finally
    //   606	608	605	finally
    //   493	571	610	java/lang/Exception
  }
  
  private void a(CapturePtvTemplateManager.DLSession paramDLSession, CapturePtvTemplateManager.DLItem paramDLItem, long paramLong1, long paramLong2)
  {
    if (paramDLSession != null)
    {
      if (paramDLItem == null) {
        return;
      }
      Object localObject = (CapturePtvTemplateManager.BusinessParam)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramDLSession.jdField_a_of_type_Int));
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("multiSessionDownloadProcessUpdate: BusinessParam=null  kind=");
          ((StringBuilder)localObject).append(paramDLSession.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(" mItem.mName=");
          ((StringBuilder)localObject).append(paramDLItem.jdField_a_of_type_JavaLangString);
          QLog.e("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      paramDLItem.jdField_a_of_type_Long = paramLong1;
      paramDLItem.b = paramLong2;
      paramDLItem.c = true;
      paramLong2 = 0L;
      paramLong1 = 1L;
      paramDLItem = paramDLSession.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDLItem.hasNext())
      {
        CapturePtvTemplateManager.DLItem localDLItem = (CapturePtvTemplateManager.DLItem)paramDLItem.next();
        if (!localDLItem.jdField_a_of_type_Boolean)
        {
          localDLItem = (CapturePtvTemplateManager.DLItem)((CapturePtvTemplateManager.BusinessParam)localObject).jdField_a_of_type_JavaUtilHashMap.get(localDLItem.jdField_a_of_type_JavaLangString);
          if (localDLItem != null)
          {
            long l;
            if (localDLItem.c)
            {
              paramLong2 += localDLItem.jdField_a_of_type_Long;
              l = localDLItem.b;
            }
            else
            {
              l = 1000L;
            }
            paramLong1 += l;
          }
        }
      }
      if (paramDLSession.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
        paramDLSession.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(paramDLSession.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(paramLong2 * 100L / paramLong1));
      }
    }
  }
  
  private void a(File paramFile, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("rebuildTemplateInfos, cur_runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      return;
    }
    paramFile = a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {
      return;
    }
    paramFile = a(a(), paramFile, null);
    if (paramFile != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramFile);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig_PTV", 2, "rebuildTemplateInfos");
    }
    a(paramFile, paramBoolean);
    a();
    paramFile = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$CapturePtvTemplateRefreshListener;
    if (paramFile != null) {
      paramFile.a();
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new CapturePtvTemplateManager.2(paramString2, paramString1));
  }
  
  private static void a(List<TemplateGroupItem> paramList, String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if (paramList != null)
      {
        if (paramList.size() <= 0) {
          return;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (TemplateGroupItem)paramList.next();
          if ((((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList != null) && (((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.size() > 0))
          {
            localObject = ((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
              if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.kind == 20))
              {
                localPtvTemplateInfo.bigHeadName = paramString1;
                localPtvTemplateInfo.bigHeadUrl = paramString2;
                localPtvTemplateInfo.bigHeadMd5 = paramString3;
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a()
  {
    File localFile1 = new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg");
    File localFile2 = new File(jdField_a_of_type_JavaIoFile, "temp_ptv_template_zip");
    return (localFile1.exists()) && (localFile2.exists());
  }
  
  private boolean a(CapturePtvTemplateManager.DLSession paramDLSession)
  {
    CapturePtvTemplateManager.BusinessParam localBusinessParam = (CapturePtvTemplateManager.BusinessParam)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramDLSession.jdField_a_of_type_Int));
    if (localBusinessParam != null)
    {
      if (localBusinessParam.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return true;
      }
      paramDLSession = paramDLSession.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDLSession.hasNext())
      {
        CapturePtvTemplateManager.DLItem localDLItem = (CapturePtvTemplateManager.DLItem)paramDLSession.next();
        if (!(localBusinessParam.jdField_a_of_type_JavaUtilArrayList.contains(localDLItem.jdField_a_of_type_JavaLangString) ^ true)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean a(CapturePtvTemplateManager.DLSession paramDLSession, CapturePtvTemplateManager.DLItem paramDLItem)
  {
    if (paramDLSession != null)
    {
      if (paramDLItem == null) {
        return false;
      }
      CapturePtvTemplateManager.BusinessParam localBusinessParam = (CapturePtvTemplateManager.BusinessParam)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramDLSession.jdField_a_of_type_Int));
      if (localBusinessParam != null)
      {
        localBusinessParam.jdField_a_of_type_JavaUtilArrayList.remove(paramDLItem.jdField_a_of_type_JavaLangString);
        if (a(paramDLSession))
        {
          paramDLSession.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = a(paramDLSession.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
          paramDLItem = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramDLItem.hasNext())
          {
            Object localObject = (TemplateGroupItem)paramDLItem.next();
            if (((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList != null)
            {
              localObject = ((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.iterator();
              while (((Iterator)localObject).hasNext())
              {
                PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
                if (localPtvTemplateInfo.id.equals(paramDLSession.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
                  localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
                } else if (paramDLSession.jdField_a_of_type_Int == localPtvTemplateInfo.kind) {
                  localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
                }
              }
            }
          }
          if (paramDLSession.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
            paramDLSession.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(paramDLSession.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, paramDLSession.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
          }
          if (localBusinessParam.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
            localBusinessParam.jdField_a_of_type_JavaUtilHashMap.clear();
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject1 = new File(jdField_b_of_type_JavaIoFile, paramString2);
    boolean bool2 = ((File)localObject1).exists();
    boolean bool1 = bool2;
    Object localObject2;
    if (!bool2)
    {
      localObject2 = new File(jdField_a_of_type_JavaIoFile, paramString1);
      localObject1 = localObject2;
      bool1 = bool2;
      if (((File)localObject2).exists()) {
        try
        {
          String str = FileUtils.calcMd5(((File)localObject2).getPath());
          localObject1 = localObject2;
          bool1 = bool2;
          if (!TextUtils.isEmpty(str))
          {
            boolean bool3 = str.equalsIgnoreCase(paramString2);
            localObject1 = localObject2;
            bool1 = bool2;
            if (bool3)
            {
              bool1 = true;
              localObject1 = localObject2;
            }
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            localUnsatisfiedLinkError.printStackTrace();
            bool1 = bool2;
            localObject1 = localObject2;
          }
        }
      }
    }
    if (bool1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a(paramString1, paramString2));
      ((StringBuilder)localObject2).append(File.separator);
      localObject2 = ((StringBuilder)localObject2).toString();
      paramString1 = new File((String)localObject2, "params.json");
      localObject2 = new File((String)localObject2, "params.dat");
      long l = paramString1.length();
      if (((paramString1.exists()) && (l < 1L)) || ((!paramString1.exists()) && ((!paramBoolean) || (!((File)localObject2).exists())))) {
        try
        {
          ZipUtils.unZipFile((File)localObject1, a(paramString2));
          return true;
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel()) {
            paramString1.printStackTrace();
          }
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private void c()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(this.jdField_a_of_type_JavaUtilList);
    localObject1 = ((List)localObject1).iterator();
    int m = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (TemplateGroupItem)((Iterator)localObject1).next();
      if (((TemplateGroupItem)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Object localObject3 = new ArrayList();
        ((List)localObject3).addAll(((TemplateGroupItem)localObject2).jdField_a_of_type_JavaUtilList);
        localObject2 = ((List)localObject3).iterator();
        int k = i;
        int j = m;
        for (;;)
        {
          m = j;
          i = k;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            i = k + 1;
            ((PtvTemplateManager.PtvTemplateInfo)localObject3).usable = a((PtvTemplateManager.PtvTemplateInfo)localObject3);
            k = i;
            if (((PtvTemplateManager.PtvTemplateInfo)localObject3).usable)
            {
              j += 1;
              k = i;
            }
          }
        }
      }
    }
    SharedPreUtils.a(m, i);
  }
  
  private static boolean c(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = new File(jdField_a_of_type_JavaIoFile, paramString1);
    if (!((File)localObject).exists()) {
      return false;
    }
    try
    {
      localObject = FileUtils.calcMd5(((File)localObject).getPath());
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramString2)))
      {
        paramString2 = new StringBuilder();
        paramString2.append(jdField_a_of_type_JavaLangString);
        paramString2.append(paramString1);
        paramString2.append(File.separator);
        localObject = paramString2.toString();
        paramString2 = new File((String)localObject, "params.json");
        localObject = new File((String)localObject, "params.dat");
        long l = paramString2.length();
        if (((paramString2.exists()) && (l < 1L)) || ((!paramString2.exists()) && ((!paramBoolean) || (!((File)localObject).exists())))) {
          try
          {
            ZipUtils.unZipFile(new File(jdField_a_of_type_JavaIoFile, paramString1), jdField_a_of_type_JavaLangString);
            return true;
          }
          catch (Exception paramString1)
          {
            if (QLog.isColorLevel()) {
              paramString1.printStackTrace();
            }
            return false;
          }
        }
        return true;
      }
      return false;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      if (QLog.isColorLevel()) {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new CapturePtvTemplateManager.4(this), jdField_a_of_type_JavaLangLong.longValue());
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    a(paramQQAppInterface, paramString);
  }
  
  void a(List<TemplateGroupItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((TemplateGroupItem)paramList.next()).jdField_a_of_type_JavaUtilList;
        if (localList != null)
        {
          int i = 0;
          while (i < localList.size())
          {
            PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localList.get(i);
            Object localObject;
            if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.predownload) && (!TextUtils.isEmpty(localPtvTemplateInfo.resurl))) {
              if (a(localPtvTemplateInfo))
              {
                localPtvTemplateInfo.usable = true;
              }
              else
              {
                localPtvTemplateInfo.usable = false;
                int j = (int)(FileUtils.getAvailableInnernalMemorySize() / 1024.0F / 1024.0F);
                int k = (int)(localPtvTemplateInfo.sizeFree * 1024.0D);
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("preDownloadTemplates getAvailableInnernalMemorySize: ");
                  ((StringBuilder)localObject).append(j);
                  ((StringBuilder)localObject).append(" mSizeFree: ");
                  ((StringBuilder)localObject).append(k);
                  QLog.d("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
                }
                if (j < k)
                {
                  if (QLog.isColorLevel())
                  {
                    paramList = new StringBuilder();
                    paramList.append("preDownloadTemplates return getAvailableInnernalMemorySize: ");
                    paramList.append(j);
                    paramList.append(" mSizeFree: ");
                    paramList.append(k);
                    QLog.i("CapturePtvTemplateManager", 2, paramList.toString());
                  }
                  return;
                }
                localObject = new HttpNetReq();
                ((HttpNetReq)localObject).mCallback = new CapturePtvTemplateManager.5(this, localPtvTemplateInfo);
                ((HttpNetReq)localObject).mReqUrl = localPtvTemplateInfo.resurl;
                ((HttpNetReq)localObject).mHttpMethod = 0;
                ((HttpNetReq)localObject).mOutPath = new File(jdField_b_of_type_JavaIoFile, localPtvTemplateInfo.md5).getPath();
                ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
              }
            }
            try
            {
              AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
              if ((localAppRuntime != null) && ((localAppRuntime instanceof ToolRuntimePeak)))
              {
                localAppRuntime = ((ToolRuntimePeak)localAppRuntime).onGetSubRuntime("peak");
                if (localAppRuntime != null)
                {
                  ((IHttpEngineService)((PeakAppInterface)localAppRuntime).getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
                  if (QLog.isColorLevel())
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("startDownloadFilterConfigZip, url: ");
                    ((StringBuilder)localObject).append(localPtvTemplateInfo.resurl);
                    QLog.i("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
                  }
                }
              }
            }
            catch (Exception localException)
            {
              label459:
              break label459;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public void a(List<TemplateGroupItem> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (paramBoolean) {
        c();
      } else {
        ThreadManager.getSubThreadHandler().post(new CapturePtvTemplateManager.6(this));
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("updateFaceuTemplateConfigInfo size=");
        paramList.append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d("CapturePtvTemplateManager", 2, paramList.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new CapturePtvTemplateManager.1(this, paramBoolean), null, false);
  }
  
  public boolean a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo == null) {
      return false;
    }
    boolean bool;
    if (paramPtvTemplateInfo.kind == 3)
    {
      paramPtvTemplateInfo.dgStageUsable = c(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
      paramPtvTemplateInfo.dgModelUsable = c(paramPtvTemplateInfo.dgModelName, paramPtvTemplateInfo.dgModelResmd5, false);
      bool = c(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(bool), paramPtvTemplateInfo.id }));
      }
      if ((paramPtvTemplateInfo.dgStageUsable) && (paramPtvTemplateInfo.dgModelUsable)) {
        return bool;
      }
      return false;
    }
    if (paramPtvTemplateInfo.kind == 20)
    {
      if (!paramPtvTemplateInfo.bigHeadModelUsable) {
        paramPtvTemplateInfo.bigHeadModelUsable = c(paramPtvTemplateInfo.bigHeadName, paramPtvTemplateInfo.bigHeadMd5, false);
      }
      bool = c(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(bool), paramPtvTemplateInfo.id }));
      }
      if (paramPtvTemplateInfo.bigHeadModelUsable) {
        return bool;
      }
      return false;
    }
    if (paramPtvTemplateInfo.kind == 4)
    {
      paramPtvTemplateInfo.dgStageUsable = c(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
      if (paramPtvTemplateInfo.dgStageUsable) {
        return c(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
      }
      return false;
    }
    return a(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, true);
  }
  
  public void b()
  {
    CaptureRedDotConfig localCaptureRedDotConfig = CaptureRedDotConfig.getRedDotConfigFromFile(jdField_a_of_type_JavaIoFile.getAbsolutePath(), "_PTV");
    if (localCaptureRedDotConfig != null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
  
  @TargetApi(9)
  public void b(boolean paramBoolean)
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
    a(localFile, paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      CaptureRedDotConfig localCaptureRedDotConfig = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig;
      if ((localCaptureRedDotConfig != null) && (localCaptureRedDotConfig.update))
      {
        localCaptureRedDotConfig = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig;
        localCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(localCaptureRedDotConfig, jdField_a_of_type_JavaIoFile.getAbsolutePath(), "_PTV");
      }
    }
    else
    {
      CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaIoFile.getAbsolutePath(), "_PTV");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */