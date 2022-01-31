package com.tencent.mobileqq.richmedia.capture.data;

import agsz;
import agta;
import agtb;
import agtc;
import agtd;
import agte;
import agtf;
import agtg;
import agth;
import agti;
import agtj;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.util.DanceGameReporter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.shortvideo.util.FaceDanceEntryUtil;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
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
  public static int a;
  public static File a;
  public static final Long a;
  static Object jdField_a_of_type_JavaLangObject;
  public static String a;
  public static int b;
  public static File b;
  public static String b;
  public static String c;
  long jdField_a_of_type_Long = 0L;
  public Handler a;
  public CapturePtvTemplateManager.CapturePtvTemplateRefreshListener a;
  public CaptureRedDotConfig a;
  private TemplateGroupItem jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem;
  private PtvTemplateManager.IPtvTemplateDownloadListener jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener;
  public PtvTemplateManager.PtvTemplateInfo a;
  private Observable jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List a;
  public ArrayList b;
  String d;
  String e;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(10000L);
    jdField_a_of_type_JavaLangString = "ptv_template_usable";
    jdField_b_of_type_JavaLangString = "ptv_debug";
    jdField_c_of_type_JavaLangString = "new_ptv_template_usable";
    jdField_a_of_type_JavaLangObject = new Object();
    int i = 0;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Exception localException)
    {
      label47:
      File localFile;
      break label47;
    }
    if (i != 0) {}
    for (localFile = new File(AppConstants.aJ);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      jdField_a_of_type_JavaIoFile = new File(localFile, "capture_ptv_template");
      jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_a_of_type_JavaLangString + File.separator;
      jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_b_of_type_JavaLangString;
      jdField_b_of_type_JavaIoFile = new File(localFile, "new_ptv_template");
      jdField_c_of_type_JavaLangString = jdField_b_of_type_JavaIoFile.getPath() + File.separator + jdField_c_of_type_JavaLangString + File.separator;
      jdField_b_of_type_Int = 10;
      return;
    }
  }
  
  private CapturePtvTemplateManager()
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static final CapturePtvTemplateManager a()
  {
    return agth.a();
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
  
  public static String a(String paramString)
  {
    return jdField_c_of_type_JavaLangString + paramString + File.separator;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = jdField_a_of_type_JavaLangString + paramString1;
    paramString1 = jdField_c_of_type_JavaLangString + paramString2 + File.separator + paramString1;
    if (new File(paramString1).exists()) {
      return paramString1;
    }
    return str;
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
            paramCapturePtvTemplateManager.d = paramString.getString("guide_video_url");
          }
          if (paramString.has("guide_video_md5")) {
            paramCapturePtvTemplateManager.e = paramString.getString("guide_video_md5");
          }
          if (paramString.has("gestureGapFrame")) {
            com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource.jdField_a_of_type_JavaLangString = paramString.getString("gestureGapFrame");
          }
          if (paramString.has("gestureGapTime")) {
            com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource.jdField_b_of_type_JavaLangString = paramString.getString("gestureGapTime");
          }
          if (paramString.has("gesturethreadcoldtime")) {
            com.tencent.sveffects.SvEffectSdkInitor.QQGestureResource.jdField_c_of_type_JavaLangString = paramString.getString("gesturethreadcoldtime");
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
                  break label714;
                }
                CaptureRedDotConfig.RedDotItemConfig localRedDotItemConfig = new CaptureRedDotConfig.RedDotItemConfig();
                localRedDotItemConfig.filterId = str;
                paramCapturePtvTemplateManager.append(str).append(",");
                paramCaptureRedDotConfig.redDotItems.put(str, localRedDotItemConfig);
                break label714;
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
      label714:
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
      Object localObject3;
      int k;
      Object localObject4;
      Object localObject5;
      try
      {
        localTemplateGroupItem = new TemplateGroupItem();
        localObject3 = paramJSONArray.getJSONObject(i);
        if (((JSONObject)localObject3).has("content")) {
          localTemplateGroupItem.jdField_a_of_type_JavaUtilList = PtvTemplateManager.PtvTemplateInfo.convertFrom(((JSONObject)localObject3).getJSONArray("content"));
        }
        if (((JSONObject)localObject3).has("categoryName")) {
          localTemplateGroupItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).getString("categoryName");
        }
        if (((JSONObject)localObject3).has("GetRedBag"))
        {
          if (((JSONObject)localObject3).getInt("GetRedBag") == 1)
          {
            bool = true;
            localTemplateGroupItem.jdField_a_of_type_Boolean = bool;
            RedBagVideoManager.a((JSONObject)localObject3);
          }
        }
        else
        {
          if ((((JSONObject)localObject3).has("TipsVer")) && (((JSONObject)localObject3).has("Tips")))
          {
            localTemplateGroupItem.jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("TipsVer");
            localTemplateGroupItem.jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).getString("Tips");
          }
          if (!((JSONObject)localObject3).has("categoryId")) {
            break label488;
          }
          localTemplateGroupItem.jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("categoryId");
          if (paramCaptureRedDotConfig == null) {
            break label711;
          }
          k = ((JSONObject)localObject3).optInt("redDotVersion");
          bool = ((JSONObject)localObject3).optBoolean("needRedDot");
          localObject1 = (CaptureRedDotConfig.CategoryRedConfig)paramCaptureRedDotConfig.categories.get(Integer.valueOf(localTemplateGroupItem.jdField_a_of_type_Int));
          if (localObject1 == null) {
            break label425;
          }
          if (((CaptureRedDotConfig.CategoryRedConfig)localObject1).version == k) {
            break label708;
          }
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).version = k;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).hasShow = false;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).firstShowTime = 0L;
          if ((localTemplateGroupItem.jdField_a_of_type_JavaUtilList == null) || (localTemplateGroupItem.jdField_a_of_type_JavaUtilList.isEmpty())) {
            break label461;
          }
          localObject4 = localTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label461;
          }
          localObject5 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject4).next();
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryId = localTemplateGroupItem.jdField_a_of_type_Int;
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryName = localTemplateGroupItem.jdField_a_of_type_JavaLangString;
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
      boolean bool = false;
      continue;
      label425:
      Object localObject1 = new CaptureRedDotConfig.CategoryRedConfig();
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId = localTemplateGroupItem.jdField_a_of_type_Int;
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).version = k;
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
      continue;
      label461:
      if ((paramCaptureRedDotConfig != null) && (localObject1 != null)) {
        paramCaptureRedDotConfig.categories.put(Integer.valueOf(((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId), localObject1);
      }
      label488:
      bool = ((JSONObject)localObject3).has("commonRes");
      if (bool) {
        try
        {
          Object localObject6 = ((JSONObject)localObject3).getJSONObject("commonRes");
          localObject1 = ((JSONObject)localObject6).getString("dg_stage_name");
          RecentDanceConfigMgr.a((String)localObject1);
          localObject3 = ((JSONObject)localObject6).getString("dg_stage_resurl");
          localObject4 = ((JSONObject)localObject6).getString("dg_stage_resmd5");
          localObject5 = ((JSONObject)localObject6).getString("dg_model_name");
          String str = ((JSONObject)localObject6).getString("dg_model_resurl");
          localObject6 = ((JSONObject)localObject6).getString("dg_model_resmd5");
          if (localTemplateGroupItem.jdField_a_of_type_JavaUtilList != null)
          {
            Iterator localIterator = localTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator.hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator.next();
              if ((localPtvTemplateInfo.kind == 3) || (localPtvTemplateInfo.kind == 4))
              {
                localPtvTemplateInfo.dgStageName = ((String)localObject1);
                localPtvTemplateInfo.dgStageResurl = ((String)localObject3);
                localPtvTemplateInfo.dgStageResmd5 = ((String)localObject4);
                localPtvTemplateInfo.dgModelName = ((String)localObject5);
                localPtvTemplateInfo.dgModelResurl = str;
                localPtvTemplateInfo.dgModelResmd5 = ((String)localObject6);
              }
            }
          }
          localArrayList.add(localTemplateGroupItem);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
      break;
      label708:
      continue;
      label711:
      Object localObject2 = null;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = new CaptureRedDotConfig(2);
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_PTV", 2, "parseFilterConfigZip RedDot is null");
        }
      }
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip TextUtils.isEmpty(config) return");
        }
        NewFlowCameraReporter.a(-1);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip config=" + paramString);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(paramString);
          paramString = "";
          str = "";
          if (((JSONObject)localObject2).has("pendantMD5")) {
            paramString = ((JSONObject)localObject2).getString("pendantMD5");
          }
          if (!((JSONObject)localObject2).has("pendantUrl")) {
            break label549;
          }
          ??? = ((JSONObject)localObject2).getString("pendantUrl");
          if (((JSONObject)localObject2).has("pendantName")) {
            str = ((JSONObject)localObject2).getString("pendantName");
          }
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip pendantMD5=" + paramString + " pendantUrl=" + (String)???);
          }
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)???))) {
            break label279;
          }
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "zipMd5 or zipUrl empty return!");
          }
          NewFlowCameraReporter.a(-1);
          return;
        }
        catch (JSONException paramQQAppInterface) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        paramQQAppInterface.printStackTrace();
        return;
        label279:
        Object localObject2 = jdField_a_of_type_JavaIoFile + File.separator;
        String str = jdField_a_of_type_JavaIoFile + File.separator + str;
        File localFile = new File(jdField_a_of_type_JavaIoFile, "temp_ptv_template_zip");
        if (localFile.exists())
        {
          localFile.delete();
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip file.delete()");
          }
        }
        Object localObject3 = new File(str);
        if (((File)localObject3).exists())
        {
          ((File)localObject3).delete();
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip filejson.delete()");
          }
        }
        localObject3 = new HttpNetReq();
        ((HttpNetReq)localObject3).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new agtb(this, paramString, (String)localObject2, paramQQAppInterface, str);
        ((HttpNetReq)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
        ((HttpNetReq)localObject3).jdField_a_of_type_Int = 0;
        ((HttpNetReq)localObject3).jdField_c_of_type_JavaLangString = localFile.getPath();
        ((HttpNetReq)localObject3).jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
        try
        {
          paramQQAppInterface = BaseApplicationImpl.getApplication().getRuntime();
          if (!QQAppInterface.class.isInstance(paramQQAppInterface)) {
            break;
          }
          ((QQAppInterface)paramQQAppInterface).getNetEngine(0).a((NetReq)localObject3);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("CapturePtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + (String)???);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          return;
        }
      }
      label549:
      ??? = "";
    }
  }
  
  private void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
    if (b(paramPtvTemplateInfo))
    {
      paramPtvTemplateInfo.usable = a(paramPtvTemplateInfo);
      paramString = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (TemplateGroupItem)paramString.next();
        if (((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList != null)
        {
          localObject = ((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
            if (localPtvTemplateInfo.id.equals(paramPtvTemplateInfo.id)) {
              localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(paramPtvTemplateInfo, paramPtvTemplateInfo.usable);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
    }
  }
  
  private void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString, long paramLong1, long paramLong2)
  {
    paramString = (agtj)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_a_of_type_Long = paramLong1;
      paramString.b = paramLong2;
      paramString.jdField_a_of_type_Boolean = true;
      paramLong2 = 0L;
      long l2 = 1L;
      paramLong1 = l2;
      long l1 = paramLong2;
      if (!paramPtvTemplateInfo.dgStageUsable)
      {
        paramString = (agtj)this.jdField_a_of_type_JavaUtilHashMap.get(paramPtvTemplateInfo.dgStageName);
        paramLong1 = l2;
        l1 = paramLong2;
        if (paramString != null)
        {
          if (!paramString.jdField_a_of_type_Boolean) {
            break label255;
          }
          l1 = 0L + paramString.jdField_a_of_type_Long;
          paramLong1 = paramString.b + 1L;
        }
      }
      paramLong2 = paramLong1;
      l2 = l1;
      if (!paramPtvTemplateInfo.dgModelUsable)
      {
        paramString = (agtj)this.jdField_a_of_type_JavaUtilHashMap.get(paramPtvTemplateInfo.dgModelName);
        paramLong2 = paramLong1;
        l2 = l1;
        if (paramString != null)
        {
          if (!paramString.jdField_a_of_type_Boolean) {
            break label268;
          }
          l2 = l1 + paramString.jdField_a_of_type_Long;
          paramLong2 = paramLong1 + paramString.b;
        }
      }
      label164:
      paramLong1 = paramLong2;
      l1 = l2;
      if (!paramPtvTemplateInfo.usable)
      {
        paramString = (agtj)this.jdField_a_of_type_JavaUtilHashMap.get(paramPtvTemplateInfo.name);
        paramLong1 = paramLong2;
        l1 = l2;
        if (paramString != null)
        {
          if (!paramString.jdField_a_of_type_Boolean) {
            break label282;
          }
          l1 = l2 + paramString.jdField_a_of_type_Long;
          paramLong1 = paramLong2 + paramString.b;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(paramPtvTemplateInfo, (int)(l1 * 100L / paramLong1));
        }
        return;
        label255:
        paramLong1 = 1000L + 1L;
        l1 = paramLong2;
        break;
        label268:
        paramLong2 = paramLong1 + 1000L;
        l2 = l1;
        break label164;
        label282:
        paramLong1 = paramLong2 + 1000L;
        l1 = l2;
      }
    }
    QLog.d("CapturePtvTemplateManager", 1, "ProcessUpdate error occur! info:" + paramPtvTemplateInfo.toString());
  }
  
  private void a(File paramFile, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("rebuildTemplateInfos, cur_runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {}
    do
    {
      do
      {
        return;
        paramFile = a(paramFile);
      } while (TextUtils.isEmpty(paramFile));
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
      b();
    } while (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$CapturePtvTemplateRefreshListener == null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$CapturePtvTemplateRefreshListener.a();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new agta(paramString2, paramString1));
  }
  
  public static boolean a()
  {
    File localFile1 = new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg");
    File localFile2 = new File(jdField_a_of_type_JavaIoFile, "temp_ptv_template_zip");
    return (localFile1.exists()) && (localFile2.exists());
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString1))
    {
      bool1 = false;
      return bool1;
    }
    File localFile = new File(jdField_b_of_type_JavaIoFile, paramString2);
    if (localFile.exists()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localFile = new File(jdField_a_of_type_JavaIoFile, paramString1);
        if (!localFile.exists()) {}
      }
      for (;;)
      {
        try
        {
          Object localObject = FileUtils.b(localFile.getPath());
          int j = i;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            bool1 = ((String)localObject).equalsIgnoreCase(paramString2);
            j = i;
            if (bool1) {
              j = 1;
            }
          }
          i = j;
          if (i != 0)
          {
            localObject = a(paramString1, paramString2) + File.separator;
            paramString1 = new File((String)localObject, "params.json");
            localObject = new File((String)localObject, "params.dat");
            long l = paramString1.length();
            if ((!paramString1.exists()) || (l >= 1L))
            {
              bool1 = bool2;
              if (paramString1.exists()) {
                break;
              }
              if (paramBoolean)
              {
                bool1 = bool2;
                if (((File)localObject).exists()) {
                  break;
                }
              }
            }
            try
            {
              ZipUtils.a(localFile, a(paramString2));
              return true;
            }
            catch (Exception paramString1)
            {
              if (QLog.isColorLevel()) {
                paramString1.printStackTrace();
              }
              return false;
            }
            continue;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          if (QLog.isColorLevel()) {
            localUnsatisfiedLinkError.printStackTrace();
          }
        }
        return false;
      }
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.size() >= 30);
  }
  
  private boolean b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    return (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) || ((!this.jdField_a_of_type_JavaUtilArrayList.contains(paramPtvTemplateInfo.dgStageName)) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramPtvTemplateInfo.dgModelName)) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramPtvTemplateInfo.name)));
  }
  
  private ArrayList c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    boolean bool1 = QmcfManager.a().a(2);
    boolean bool2 = FaceDanceEntryUtil.c();
    if ((!bool1) || (!bool2))
    {
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        TemplateGroupItem localTemplateGroupItem = (TemplateGroupItem)localIterator1.next();
        List localList = localTemplateGroupItem.jdField_a_of_type_JavaUtilList;
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator2.next();
          if (((!bool1) && (localPtvTemplateInfo.kind == 3)) || ((!bool2) && (localPtvTemplateInfo.kind == 4)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("CapturePtvTemplateManager", 2, "should hide dg item! isQmcfEnableEntry=" + bool1 + " isFaceDanceEnableEntry=" + bool2 + " itemID=" + localPtvTemplateInfo.id);
            }
            localIterator2.remove();
          }
        }
        if (localList.size() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, "should hide dg tab! isQmcfEnableEntry=" + bool1 + " isFaceDanceEnableEntry=" + bool2 + " categoryID=" + localTemplateGroupItem.jdField_a_of_type_Int);
          }
          localIterator1.remove();
        }
      }
      DanceGameReporter.a().a(bool1, bool2);
    }
    return localArrayList;
  }
  
  private static boolean c(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      for (;;)
      {
        return false;
        Object localObject = new File(jdField_a_of_type_JavaIoFile, paramString1);
        if (((File)localObject).exists()) {
          try
          {
            localObject = FileUtils.b(((File)localObject).getPath());
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramString2)))
            {
              localObject = jdField_a_of_type_JavaLangString + paramString1 + File.separator;
              paramString2 = new File((String)localObject, "params.json");
              localObject = new File((String)localObject, "params.dat");
              long l = paramString2.length();
              if (((!paramString2.exists()) || (l >= 1L)) && ((paramString2.exists()) || ((paramBoolean) && (((File)localObject).exists())))) {
                break label194;
              }
              if (!QLog.isColorLevel()) {}
            }
          }
          catch (UnsatisfiedLinkError paramString1)
          {
            try
            {
              ZipUtils.a(new File(jdField_a_of_type_JavaIoFile, paramString1), jdField_a_of_type_JavaLangString);
              return true;
            }
            catch (Exception paramString1) {}
            paramString1 = paramString1;
          }
        }
      }
      paramString1.printStackTrace();
      return false;
    } while (!QLog.isColorLevel());
    paramString1.printStackTrace();
    return false;
    label194:
    return true;
  }
  
  private void e()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(this.jdField_a_of_type_JavaUtilList);
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (TemplateGroupItem)((Iterator)localObject1).next();
      int k = i;
      int m = j;
      if (((TemplateGroupItem)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Object localObject3 = new ArrayList();
        ((List)localObject3).addAll(((TemplateGroupItem)localObject2).jdField_a_of_type_JavaUtilList);
        localObject2 = ((List)localObject3).iterator();
        for (;;)
        {
          k = i;
          m = j;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            k = i + 1;
            ((PtvTemplateManager.PtvTemplateInfo)localObject3).usable = a((PtvTemplateManager.PtvTemplateInfo)localObject3);
            i = k;
            if (((PtvTemplateManager.PtvTemplateInfo)localObject3).usable)
            {
              j += 1;
              i = k;
            }
          }
        }
      }
      j = m;
      i = k;
    }
    SharedPreUtils.a(j, i);
  }
  
  public int a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.hasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_PTV", 2, "getDefaultCategoryId=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public TemplateGroupItem a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TemplateGroupItem localTemplateGroupItem = (TemplateGroupItem)localIterator.next();
      if (localTemplateGroupItem.jdField_a_of_type_Int == paramInt) {
        return localTemplateGroupItem;
      }
    }
    return null;
  }
  
  public TemplateGroupItem a(TemplateGroupItem paramTemplateGroupItem)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("recent_template_setting", 0);
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localObject1 = ((SharedPreferences)localObject1).getString("recent_template_list" + (String)localObject2, null);
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "getRecentTemplate list=" + (String)localObject1);
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return paramTemplateGroupItem;
      localObject1 = ((String)localObject1).split("\\$");
      int i = 0;
      while (i < localObject1.length)
      {
        localObject2 = localObject1[i].split("\\|");
        if ((localObject2 != null) && (localObject2.length == 2))
        {
          int j = Integer.valueOf(localObject2[1]).intValue();
          localObject2 = a(localObject2[0], j);
          if (localObject2 != null) {
            paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
        }
        i += 1;
      }
    }
  }
  
  public PtvTemplateManager.PtvTemplateInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(String paramString, int paramInt)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      Iterator localIterator = a().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (TemplateGroupItem)localIterator.next();
        } while ((((TemplateGroupItem)localObject).jdField_a_of_type_Int != paramInt) || (((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList == null));
        localObject = ((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
    } while (!localPtvTemplateInfo.id.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "QIMPtvTemplateManager existTemplateInfo id=" + paramString + " tagId=" + paramInt);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = c();
    if (!RedBagVideoManager.a(jdField_a_of_type_Int))
    {
      List localList = a();
      if ((localList != null) && (!localList.isEmpty())) {
        localArrayList.removeAll(localList);
      }
    }
    return localArrayList;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TemplateGroupItem localTemplateGroupItem = (TemplateGroupItem)localIterator.next();
      if (localTemplateGroupItem.jdField_a_of_type_Boolean) {
        localArrayList.add(localTemplateGroupItem);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$CapturePtvTemplateRefreshListener = null;
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.updateRedDotInfo(paramInt1, paramInt2, paramString))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateRedDotInfo==> type=");
            if (paramInt1 == 2)
            {
              localStringBuilder.append(",categoryId=").append(paramInt2);
              QLog.d("QIMRedDotConfig_PTV", 2, localStringBuilder.toString());
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
            this.jdField_a_of_type_AndroidOsHandler.post(new agtf(this));
          }
        }
        else {
          return;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "notifyEventId eventId" + paramInt);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if (paramPtvTemplateInfo == null) {
      return;
    }
    if ((paramPtvTemplateInfo.kind == 3) || (paramPtvTemplateInfo.kind == 4))
    {
      c(paramAppInterface, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
      return;
    }
    b(paramAppInterface, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString1) != null) {}
    for (;;)
    {
      return;
      Object localObject = new agtj(this);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
      localObject = new HttpNetReq();
      ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new agti(this, paramString1, paramString2, paramString3);
      ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = paramString2;
      ((HttpNetReq)localObject).jdField_a_of_type_Int = 0;
      ((HttpNetReq)localObject).jdField_c_of_type_JavaLangString = new File(jdField_a_of_type_JavaIoFile, paramString1).getPath();
      ((HttpNetReq)localObject).a(paramPtvTemplateInfo);
      ((HttpNetReq)localObject).jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a((NetReq)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("CapturePtvTemplateManager", 2, "downloadDGTemplateItem url: " + paramString2);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    a(paramQQAppInterface, paramString);
  }
  
  public void a(CapturePtvTemplateManager.CapturePtvTemplateRefreshListener paramCapturePtvTemplateRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$CapturePtvTemplateRefreshListener = paramCapturePtvTemplateRefreshListener;
  }
  
  public void a(PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = paramIPtvTemplateDownloadListener;
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem = new TemplateGroupItem("我的");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList = new ArrayList(30);
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.size())
      {
        if (((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.get(i)).id.equals(paramPtvTemplateInfo.id)) {
          j = i;
        }
        i += 1;
      }
      if (j == -1) {
        if (!b())
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          a(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem);
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
          }
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent index=" + j);
        return;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.remove(29);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
        a(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem);
        continue;
        if (j != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.remove(j);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          a(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem);
        }
      }
    }
  }
  
  public void a(Observer paramObserver, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable = new Observable();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramObserver, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    List localList;
    do
    {
      return;
      while (!paramList.hasNext()) {
        paramList = paramList.iterator();
      }
      localList = ((TemplateGroupItem)paramList.next()).jdField_a_of_type_JavaUtilList;
    } while (localList == null);
    int i = 0;
    label49:
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i < localList.size())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localList.get(i);
      if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.predownload) && (!TextUtils.isEmpty(localPtvTemplateInfo.resurl))) {
        break label102;
      }
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      label102:
      if (a(localPtvTemplateInfo))
      {
        localPtvTemplateInfo.usable = true;
      }
      else
      {
        localPtvTemplateInfo.usable = false;
        HttpNetReq localHttpNetReq = new HttpNetReq();
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new agtd(this, localPtvTemplateInfo);
        localHttpNetReq.jdField_a_of_type_JavaLangString = localPtvTemplateInfo.resurl;
        localHttpNetReq.jdField_a_of_type_Int = 0;
        localHttpNetReq.jdField_c_of_type_JavaLangString = new File(jdField_b_of_type_JavaIoFile, localPtvTemplateInfo.md5).getPath();
        localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
        try
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if ((localAppRuntime != null) && ((localAppRuntime instanceof ToolRuntimePeak)))
          {
            ((PeakAppInterface)((ToolRuntimePeak)localAppRuntime).onGetSubRuntime("peak")).getNetEngine(0).a(localHttpNetReq);
            if (QLog.isColorLevel()) {
              QLog.i("CapturePtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + localPtvTemplateInfo.resurl);
            }
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        e();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("CapturePtvTemplateManager", 2, "updateFaceuTemplateConfigInfo size=" + this.jdField_a_of_type_JavaUtilList.size());
        return;
        ThreadManager.getSubThreadHandler().post(new agte(this));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new agsz(this, paramBoolean), null, false);
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          return false;
        }
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.needShowRedDot(paramInt1, paramInt2, paramString);
        if ((bool) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ShowRedDot ==> type=");
          localStringBuilder.append(paramInt1);
          if (paramInt1 == 2)
          {
            localStringBuilder.append(",categoryId=").append(paramInt2);
            QLog.d("QIMRedDotConfig_PTV", 2, localStringBuilder.toString());
          }
        }
        else
        {
          return bool;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public boolean a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      boolean bool;
      do
      {
        return false;
        if (paramPtvTemplateInfo.kind != 3) {
          break;
        }
        paramPtvTemplateInfo.dgStageUsable = c(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
        paramPtvTemplateInfo.dgModelUsable = c(paramPtvTemplateInfo.dgModelName, paramPtvTemplateInfo.dgModelResmd5, false);
        bool = c(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
        if (QLog.isColorLevel()) {
          QLog.d("CapturePtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(bool), paramPtvTemplateInfo.id }));
        }
      } while ((!paramPtvTemplateInfo.dgStageUsable) || (!paramPtvTemplateInfo.dgModelUsable));
      return bool;
      if (paramPtvTemplateInfo.kind != 4) {
        break;
      }
      paramPtvTemplateInfo.dgStageUsable = c(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
    } while (!paramPtvTemplateInfo.dgStageUsable);
    return c(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
    return a(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, true);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind;
    }
    return -999;
  }
  
  public ArrayList b()
  {
    ArrayList localArrayList = a();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem = new TemplateGroupItem("我的");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList = new ArrayList(30);
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem);
    }
    localArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem);
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "getRecentTemplateAndConfigTemplate al size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void b()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new agtc(this), jdField_a_of_type_JavaLangLong.longValue());
  }
  
  public void b(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if ((paramPtvTemplateInfo == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new agtg(this, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
      localHttpNetReq.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
      localHttpNetReq.jdField_a_of_type_Int = 0;
      localHttpNetReq.jdField_c_of_type_JavaLangString = new File(jdField_b_of_type_JavaIoFile, paramPtvTemplateInfo.md5).getPath();
      localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a(localHttpNetReq);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("CapturePtvTemplateManager", 2, "startDownloadTemplate url: " + paramPtvTemplateInfo.resurl);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  @TargetApi(9)
  public void b(boolean paramBoolean)
  {
    c();
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
  
  public void c()
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
  
  public void c(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if ((paramPtvTemplateInfo == null) || (paramAppInterface == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("CapturePtvTemplateManager", 2, String.format("DGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(paramPtvTemplateInfo.usable), paramPtvTemplateInfo.id }));
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = paramIPtvTemplateDownloadListener;
      if (!paramPtvTemplateInfo.dgStageUsable) {
        a(paramAppInterface, paramPtvTemplateInfo, paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResurl, paramPtvTemplateInfo.dgStageResmd5);
      }
      if (!paramPtvTemplateInfo.dgModelUsable) {
        a(paramAppInterface, paramPtvTemplateInfo, paramPtvTemplateInfo.dgModelName, paramPtvTemplateInfo.dgModelResurl, paramPtvTemplateInfo.dgModelResmd5);
      }
    } while (paramPtvTemplateInfo.usable);
    a(paramAppInterface, paramPtvTemplateInfo, paramPtvTemplateInfo.name, paramPtvTemplateInfo.resurl, paramPtvTemplateInfo.md5);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramPtvTemplateInfo);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaIoFile.getAbsolutePath(), "_PTV");
      }
      return;
    }
    CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaIoFile.getAbsolutePath(), "_PTV");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem == null) {}
    StringBuilder localStringBuilder;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.isEmpty()));
        localStringBuilder = new StringBuilder();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject1).next();
          localStringBuilder.append(((PtvTemplateManager.PtvTemplateInfo)localObject2).id).append("|");
          localStringBuilder.append(((PtvTemplateManager.PtvTemplateInfo)localObject2).categoryId).append("$");
        }
      } while (TextUtils.isEmpty(localStringBuilder.toString()));
      Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("recent_template_setting", 0);
      Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ((SharedPreferences)localObject1).edit().putString("recent_template_list" + (String)localObject2, localStringBuilder.toString());
      ((SharedPreferences)localObject1).edit().commit();
    } while (!QLog.isColorLevel());
    QLog.d("CapturePtvTemplateManager", 2, "saveRecentTemplate list=" + localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */