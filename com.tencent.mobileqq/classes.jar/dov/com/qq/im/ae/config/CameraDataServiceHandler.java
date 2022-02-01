package dov.com.qq.im.ae.config;

import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraConfig;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.AEPath.CAMERA;
import dov.com.qq.im.ae.AEPath.GIF;
import dov.com.qq.im.ae.AEPath.GIF.FILES;
import dov.com.qq.im.ae.AEPath.PLAY;
import dov.com.qq.im.ae.AEPath.PLAY.FILES;
import dov.com.qq.im.ae.AEPath.Watermark;
import dov.com.qq.im.ae.AEPath.Watermark.FILES;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil.NetInfo;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEWatermarkMaterialManager;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AECommonUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.qq.im.capture.QIMManager;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class CameraDataServiceHandler
  extends BusinessHandler
{
  private static final String jdField_a_of_type_JavaLangString = CameraDataServiceHandler.class.getSimpleName();
  public static final Type a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  protected Map<String, Long> a;
  
  static
  {
    jdField_a_of_type_JavaLangReflectType = new CameraDataServiceHandler.1().getType();
  }
  
  public CameraDataServiceHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    LogUtils.setEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private boolean a(JsonObject paramJsonObject)
  {
    return AECommonUtil.a(GsonUtils.optString(paramJsonObject, "verFrom"), GsonUtils.optString(paramJsonObject, "verTo"));
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    label200:
    Object localObject;
    int j;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqStoryCamera", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("CameraModuleSvc.GetCompressedCategoryMaterialV2MqStoryCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      FileUtils.a(AEMaterialManager.b(), paramObject);
      paramObject = (AEMaterialManager)QIMManager.a().c(18);
      if (paramObject != null) {
        paramObject.a(true);
      }
      paramObject = (AEMaterialManager)QIMManager.a(18);
      paramObject.b();
      paramObject.b(AEPath.CAMERA.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqStoryCamera"))) {
        break label281;
      }
      paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqStoryCamera")).longValue());
      localObject = AEBaseDataReporter.a();
      j = paramFromServiceMsg.getResultCode();
      if (localGetCategoryMaterialRsp == null) {
        break label287;
      }
    }
    label281:
    label287:
    for (int i = localGetCategoryMaterialRsp.Code;; i = -1024)
    {
      ((AEBaseDataReporter)localObject).a(j, paramObject, "CameraModuleSvc.GetCompressedCategoryMaterialV2.MqStoryCamera", i);
      return;
      if (!AEDashboardUtil.a()) {
        break;
      }
      localObject = AEDashboardUtil.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqStoryCamera", "response", paramObject));
        break;
      }
      paramObject = "-1";
      break label200;
    }
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    Object localObject;
    label195:
    int j;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqEmoCamera", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("CameraModuleSvc.GetCompressedCategoryMaterialV2MqEmoCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      localObject = new File(AEPath.GIF.FILES.g);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      FileUtils.a(AEPath.GIF.b, paramObject);
      CameraOperationHelper.a().postValue(Boolean.valueOf(true));
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqEmoCamera"))) {
        break label276;
      }
      paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqEmoCamera")).longValue());
      localObject = AEBaseDataReporter.a();
      j = paramFromServiceMsg.getResultCode();
      if (localGetCategoryMaterialRsp == null) {
        break label282;
      }
    }
    label276:
    label282:
    for (int i = localGetCategoryMaterialRsp.Code;; i = -1024)
    {
      ((AEBaseDataReporter)localObject).a(j, paramObject, "CameraModuleSvc.GetCompressedCategoryMaterialV2.MqEmoCamera", i);
      return;
      if (!AEDashboardUtil.a()) {
        break;
      }
      localObject = AEDashboardUtil.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqEmoCamera", "response", paramObject));
        break;
      }
      paramObject = "-1";
      break label195;
    }
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    Object localObject;
    label204:
    int j;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (localGetCategoryMaterialRsp.Categories != null) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqCircleWatermark", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("CameraModuleSvc.GetCompressedCategoryMaterialV2MqCircleWatermark", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      localObject = new File(AEPath.Watermark.FILES.c);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      FileUtils.a(AEPath.Watermark.b, paramObject);
      if ((CaptureContext.a() instanceof PeakAppInterface)) {
        AEWatermarkMaterialManager.a().a();
      }
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqCircleWatermark"))) {
        break label287;
      }
      paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqCircleWatermark")).longValue());
      localObject = AEBaseDataReporter.a();
      j = paramFromServiceMsg.getResultCode();
      if (localGetCategoryMaterialRsp == null) {
        break label293;
      }
    }
    label287:
    label293:
    for (int i = localGetCategoryMaterialRsp.Code;; i = -1024)
    {
      ((AEBaseDataReporter)localObject).a(j, paramObject, "CameraModuleSvc.GetCompressedCategoryMaterialV2.MqCircleWatermark", i);
      return;
      if (!AEDashboardUtil.a()) {
        break;
      }
      localObject = AEDashboardUtil.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCompressedCategoryMaterialV2.MqCircleWatermark", "response", paramObject));
        break;
      }
      paramObject = "-1";
      break label204;
    }
  }
  
  private void e(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDebugVersion()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] start");
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)paramObject;
    Object localObject;
    label237:
    int j;
    if ((localGetPlayShowCatMatTreeRsp != null) && (localGetPlayShowCatMatTreeRsp.Code == 0) && (!localGetPlayShowCatMatTreeRsp.Categories.isEmpty()))
    {
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] response=" + localGetPlayShowCatMatTreeRsp);
      }
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetPlayShowCatMatTree", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("CameraModuleSvc.GetPlayShowCatMatTree", localGetPlayShowCatMatTreeRsp.ETag, 4);
      paramObject = GsonUtils.obj2Json(localGetPlayShowCatMatTreeRsp, jdField_a_of_type_JavaLangReflectType);
      localObject = new File(AEPath.PLAY.FILES.d);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      FileUtils.a(AEPath.PLAY.b, paramObject);
      CameraOperationHelper.b().postValue(Boolean.valueOf(true));
      if ((this.jdField_a_of_type_JavaUtilMap == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetPlayShowCatMatTree"))) {
        break label350;
      }
      paramObject = "" + (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetPlayShowCatMatTree")).longValue());
      localObject = AEBaseDataReporter.a();
      j = paramFromServiceMsg.getResultCode();
      if (localGetPlayShowCatMatTreeRsp != null) {
        break label356;
      }
    }
    label350:
    label356:
    for (int i = -1024;; i = localGetPlayShowCatMatTreeRsp.Code)
    {
      ((AEBaseDataReporter)localObject).a(j, paramObject, "CameraModuleSvc.GetPlayShowCatMatTree", i);
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] end");
      }
      return;
      if (QLog.isDebugVersion()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[handlePlayShowCategoryMaterials] response=empty");
      }
      if (!AEDashboardUtil.a()) {
        break;
      }
      localObject = AEDashboardUtil.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((MutableLiveData)localObject).postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetPlayShowCatMatTree", "response", paramObject));
        break;
      }
      paramObject = "-1";
      break label237;
    }
  }
  
  public void a()
  {
    if (!NetworkUtil.a())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCameraConfig] no network....");
      return;
    }
    if (AEDashboardUtil.a()) {
      AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCameraConfig", "request", "null"));
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "【REQUEST】reqCameraConfig");
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetCameraConfig", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.appRuntime.getAccount(), "CameraModuleSvc.GetCameraConfig");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "【Handle】handleCameraConfig:" + paramFromServiceMsg.isSuccess());
    if (!paramFromServiceMsg.isSuccess())
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCameraConfig", "response", "failed"));
      }
      return;
    }
    GetCameraConfigRsp localGetCameraConfigRsp = (GetCameraConfigRsp)paramObject;
    Object localObject1;
    String str;
    Object localObject7;
    label180:
    int j;
    label264:
    int i;
    label344:
    label602:
    Object localObject5;
    if (localGetCameraConfigRsp.ConfigMap != null)
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCameraConfig", "response", "succeeded with content"));
      }
      paramObject = "";
      localObject1 = "";
      Iterator localIterator = localGetCameraConfigRsp.ConfigMap.entrySet().iterator();
      str = "";
      if (localIterator.hasNext())
      {
        localObject7 = (Map.Entry)localIterator.next();
        Object localObject2 = (CameraConfig)((Map.Entry)localObject7).getValue();
        if (TextUtils.isEmpty(str))
        {
          str = ((CameraConfig)localObject2).ExpId;
          localObject7 = (String)((Map.Entry)localObject7).getKey();
          if (!"app_ui_playshow_ad_id".equals(localObject7)) {
            break label264;
          }
          localObject2 = ((CameraConfig)localObject2).ConfigContent;
          paramObject = localObject1;
          localObject1 = localObject2;
        }
        for (;;)
        {
          localObject2 = localObject1;
          localObject1 = paramObject;
          paramObject = localObject2;
          break;
          str = str + "," + ((CameraConfig)localObject2).ExpId;
          break label180;
          if ("app_alg_entrance_qzone_id_from833".equals(localObject7))
          {
            localObject2 = ((CameraConfig)localObject2).ConfigContent;
            localObject1 = paramObject;
            paramObject = localObject2;
          }
          else
          {
            Object localObject3;
            if ("app_ui_camera_ad_id".equals(localObject7))
            {
              try
              {
                localObject2 = new JsonParser().parse(((CameraConfig)localObject2).ConfigContent).getAsJsonArray();
                if ((localObject2 != null) && (((JsonArray)localObject2).size() > 0))
                {
                  j = ((JsonArray)localObject2).size();
                  i = 0;
                  if (i < j)
                  {
                    localObject7 = (JsonObject)((JsonArray)localObject2).get(i);
                    if (!a((JsonObject)localObject7)) {
                      break label1469;
                    }
                    AECameraPrefsUtil.a().a("camera_ad_op_id", GsonUtils.optString((JsonObject)localObject7, "opID"), 4);
                    AECameraPrefsUtil.a().a("camera_ad_show", GsonUtils.optBoolean((JsonObject)localObject7, "showOp"), 4);
                    AECameraPrefsUtil.a().a("camera_ad_icon_url", GsonUtils.optString((JsonObject)localObject7, "opIcon"), 4);
                    AECameraPrefsUtil.a().a("camera_ad_type", GsonUtils.optString((JsonObject)localObject7, "type"), 4);
                    AECameraPrefsUtil.a().a("camera_ad_schema", GsonUtils.optString((JsonObject)localObject7, "schema"), 4);
                  }
                }
                else
                {
                  AECameraPrefsUtil.a().a("camera_ad_op_id", "", 4);
                  AECameraPrefsUtil.a().a("camera_ad_show", false, 4);
                  AECameraPrefsUtil.a().a("camera_ad_icon_url", "", 4);
                  AECameraPrefsUtil.a().a("camera_ad_type", "", 4);
                  AECameraPrefsUtil.a().a("camera_ad_schema", "", 4);
                }
              }
              catch (Exception localException1)
              {
                AEQLog.d(jdField_a_of_type_JavaLangString, "camera ad ab test inflate error.");
                localObject3 = paramObject;
                paramObject = localObject1;
                localObject1 = localObject3;
              }
            }
            else
            {
              Object localObject4;
              if ("app_ui_pendant_btn_ad_id".equals(localObject7))
              {
                try
                {
                  localObject3 = new JsonParser().parse(((CameraConfig)localObject3).ConfigContent).getAsJsonArray();
                  if ((localObject3 != null) && (((JsonArray)localObject3).size() > 0))
                  {
                    j = ((JsonArray)localObject3).size();
                    i = 0;
                    if (i < j)
                    {
                      localObject7 = (JsonObject)((JsonArray)localObject3).get(i);
                      if (!a((JsonObject)localObject7)) {
                        break label1489;
                      }
                      AECameraPrefsUtil.a().a("camera_ad_pendent_op_id", GsonUtils.optString((JsonObject)localObject7, "opID"), 4);
                      AECameraPrefsUtil.a().a("camera_ad_pendent_show", GsonUtils.optBoolean((JsonObject)localObject7, "showOp"), 4);
                      AECameraPrefsUtil.a().a("camera_ad_pendent_type", GsonUtils.optString((JsonObject)localObject7, "type"), 4);
                      AECameraPrefsUtil.a().a("camera_ad_pendent_icon_url", GsonUtils.optString((JsonObject)localObject7, "opIcon"), 4);
                      AECameraPrefsUtil.a().a("camera_ad_pendent_schema", GsonUtils.optString((JsonObject)localObject7, "schema"), 4);
                      AECameraPrefsUtil.a().a("camera_ad_pendent_icon_type", GsonUtils.optString((JsonObject)localObject7, "iconType"), 4);
                      AECameraPrefsUtil.a().a("camera_ad_pendent_categoryId", GsonUtils.optInt((JsonObject)localObject7, "categoryId"), 4);
                    }
                  }
                  else
                  {
                    AECameraPrefsUtil.a().a("camera_ad_pendent_op_id", "", 4);
                    AECameraPrefsUtil.a().a("camera_ad_pendent_show", false, 4);
                    AECameraPrefsUtil.a().a("camera_ad_pendent_type", "", 4);
                    AECameraPrefsUtil.a().a("camera_ad_pendent_icon_url", "", 4);
                    AECameraPrefsUtil.a().a("camera_ad_pendent_schema", "", 4);
                    AECameraPrefsUtil.a().a("camera_ad_pendent_icon_type", "", 4);
                    AECameraPrefsUtil.a().a("camera_ad_pendent_categoryId", -1, 4);
                  }
                }
                catch (Exception localException2)
                {
                  AEQLog.d(jdField_a_of_type_JavaLangString, "camera pendent ad ab test inflate error.");
                  localObject4 = paramObject;
                  paramObject = localObject1;
                  localObject1 = localObject4;
                }
              }
              else if ("app_alg_filter_timeout_id".equals(localObject7))
              {
                localObject4 = ((CameraConfig)localObject4).ConfigContent;
                AECameraPrefsUtil.a().a("app_alg_filter_timeout_id", (String)localObject4, 4);
                localObject4 = paramObject;
                paramObject = localObject1;
                localObject1 = localObject4;
              }
              else
              {
                if (!"app_ui_camera_circle_ad_id".equals(localObject7)) {
                  break label1167;
                }
                try
                {
                  localObject4 = new JsonParser().parse(((CameraConfig)localObject4).ConfigContent).getAsJsonArray();
                  if ((localObject4 != null) && (((JsonArray)localObject4).size() > 0))
                  {
                    j = ((JsonArray)localObject4).size();
                    i = 0;
                    label962:
                    if (i < j)
                    {
                      localObject7 = (JsonObject)((JsonArray)localObject4).get(i);
                      if (!a((JsonObject)localObject7)) {
                        break label1509;
                      }
                      AECameraPrefsUtil.a().a("circle_camera_ad_op_id", GsonUtils.optString((JsonObject)localObject7, "opID"), 4);
                      AECameraPrefsUtil.a().a("circle_camera_ad_icon_url", GsonUtils.optString((JsonObject)localObject7, "opIcon"), 4);
                      AECameraPrefsUtil.a().a("circle_camera_ad_type", GsonUtils.optString((JsonObject)localObject7, "type"), 4);
                      AECameraPrefsUtil.a().a("circle_camera_ad_schema", GsonUtils.optString((JsonObject)localObject7, "schema"), 4);
                      AECameraPrefsUtil.a().a("circle_camera_ad_show", GsonUtils.optBoolean((JsonObject)localObject7, "showOp"), 4);
                    }
                  }
                  else
                  {
                    AECameraPrefsUtil.a().a("circle_camera_ad_op_id", "", 4);
                    AECameraPrefsUtil.a().a("circle_camera_ad_icon_url", "", 4);
                    AECameraPrefsUtil.a().a("circle_camera_ad_type", "", 4);
                    AECameraPrefsUtil.a().a("circle_camera_ad_schema", "", 4);
                    AECameraPrefsUtil.a().a("circle_camera_ad_show", false, 4);
                  }
                }
                catch (Exception localException3)
                {
                  AEQLog.d(jdField_a_of_type_JavaLangString, "camera ad ab test inflate error.");
                  localObject5 = paramObject;
                  paramObject = localObject1;
                  localObject1 = localObject5;
                }
              }
            }
          }
        }
        label1167:
        if (!"app_ui_camera_circle_entry_id".equals(localObject7)) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject5 = new JsonParser().parse(((CameraConfig)localObject5).ConfigContent).getAsJsonArray();
        if ((localObject5 != null) && (((JsonArray)localObject5).size() > 0))
        {
          j = ((JsonArray)localObject5).size();
          i = 0;
          if (i < j)
          {
            localObject7 = (JsonObject)((JsonArray)localObject5).get(i);
            if (!a((JsonObject)localObject7)) {
              break label1529;
            }
            localObject5 = GsonUtils.optString((JsonObject)localObject7, "ABContent");
            AECameraPrefsUtil.a().a("circle_entry_type_camera", "camera".endsWith((String)localObject5), 4);
          }
        }
        else
        {
          AECameraPrefsUtil.a().a("circle_entry_type_camera", false, 4);
        }
      }
      catch (Exception localException4)
      {
        AEQLog.d(jdField_a_of_type_JavaLangString, "camera entry ab test inflate error.");
      }
      Object localObject6 = paramObject;
      paramObject = localObject1;
      localObject1 = localObject6;
      break;
      AECameraPrefsUtil.a().a("CameraModuleSvc.GetCameraConfig", str, 4);
      AECameraPrefsUtil.a().a("app_ui_playshow_ad_id", paramObject, 4);
      AECameraPrefsUtil.a().a("app_alg_entrance_qzone_id_from833", (String)localObject1, 4);
      paramObject = AEBaseDataReporter.a();
      i = paramFromServiceMsg.getResultCode();
      long l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCameraConfig")) {}
      for (long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCameraConfig")).longValue();; l1 = 0L)
      {
        paramObject.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetCameraConfig", localGetCameraConfigRsp.Code);
        return;
        if (!AEDashboardUtil.a()) {
          break;
        }
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCameraConfig", "response", "succeeded without content"));
        break;
      }
      localObject6 = paramObject;
      paramObject = localObject1;
      localObject1 = localObject6;
      break;
      label1469:
      i += 1;
      break label344;
      localObject6 = paramObject;
      paramObject = localObject1;
      localObject1 = localObject6;
      break;
      label1489:
      i += 1;
      break label602;
      localObject6 = paramObject;
      paramObject = localObject1;
      localObject1 = localObject6;
      break;
      label1509:
      i += 1;
      break label962;
      localObject6 = paramObject;
      paramObject = localObject1;
      localObject1 = localObject6;
      break;
      label1529:
      i += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (!NetworkUtil.a())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[reqCompressedMaterials] no network....");
      return;
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "【REQUEST】requestCompressedMaterials" + paramString);
    if (AEDashboardUtil.a()) {
      AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetCompressedCategoryMaterialV2." + paramString, "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetCompressedCategoryMaterialV2." + paramString, Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.appRuntime.getAccount(), "CameraModuleSvc.GetCompressedCategoryMaterialV2");
    localToServiceMsg.extraData.putString("ServiceId", paramString);
    send(localToServiceMsg);
  }
  
  public void b()
  {
    if (!NetworkUtil.a())
    {
      if (QLog.isDebugVersion())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[reqPlayShowCategoryMaterials] no network....");
        QLog.d(jdField_a_of_type_JavaLangString, 4, "[reqPlayShowCategoryMaterials] end");
      }
      return;
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "【REQUEST】reqPlayShowCategoryMaterials");
    if (AEDashboardUtil.a()) {
      AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("CameraModuleSvc.GetPlayShowCatMatTree", "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetPlayShowCatMatTree", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.appRuntime.getAccount(), "CameraModuleSvc.GetPlayShowCatMatTree");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  public void c()
  {
    ThreadManager.getFileThreadHandler().post(new CameraDataServiceHandler.2(this));
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    c();
    if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetCompressedCategoryMaterialV2"))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("ServiceId");
      if (paramToServiceMsg.endsWith("MqStoryCamera")) {
        b(paramFromServiceMsg, paramObject);
      }
    }
    do
    {
      do
      {
        return;
        if (paramToServiceMsg.endsWith("MqEmoCamera"))
        {
          c(paramFromServiceMsg, paramObject);
          return;
        }
      } while (!paramToServiceMsg.endsWith("MqCircleWatermark"));
      d(paramFromServiceMsg, paramObject);
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetCameraConfig"))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramToServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetPlayShowCatMatTree"));
    e(paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.config.CameraDataServiceHandler
 * JD-Core Version:    0.7.0.1
 */