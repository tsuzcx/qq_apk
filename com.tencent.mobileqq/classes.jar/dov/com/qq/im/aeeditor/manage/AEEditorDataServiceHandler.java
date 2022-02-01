package dov.com.qq.im.aeeditor.manage;

import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import camera.RECOMMEND_GENERAL_DATASTRUCT.BigShowRecommendInfo;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendRsp;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.google.gson.Gson;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.ttpic.baseutils.log.LogUtils;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil.NetInfo;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AEEditorDataServiceHandler
  extends BusinessHandler
{
  private static final String a;
  protected Map<String, Long> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AEEditorDataServiceHandler.class.getSimpleName();
  }
  
  public AEEditorDataServiceHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    LogUtils.setEnable(false);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = (GetCatMatTreeRsp)paramObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.Code == 0) && (paramFromServiceMsg.Categories != null) && (!paramFromServiceMsg.Categories.isEmpty()))
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCircleCatMatTree.MqCircleEditor", "response", "succeeded with content"));
      }
      AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor", paramFromServiceMsg.ETag, 4);
      paramFromServiceMsg = paramFromServiceMsg.Categories.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (MetaCategory)paramFromServiceMsg.next();
        if (paramObject.id.equals("10002"))
        {
          paramObject = new Gson().toJson(paramObject.subCategories);
          FileUtils.a(AEditorMaterialManager.a().a(), paramObject);
        }
        else if (paramObject.id.equals("10003"))
        {
          paramObject = new Gson().toJson(paramObject.subCategories);
          FileUtils.a(AEditorMaterialManager.a().b(), paramObject);
        }
      }
    }
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (GetBigShowRecommendRsp)paramObject;
    if ((localObject != null) && (((GetBigShowRecommendRsp)localObject).Code == 0) && (((GetBigShowRecommendRsp)localObject).Materials != null) && (!((GetBigShowRecommendRsp)localObject).Materials.isEmpty()))
    {
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetBigShowRecommend.MqCircleEditor", "response", "succeeded with content"));
      }
      paramFromServiceMsg = new ArrayList();
      paramObject = new ArrayList();
      localObject = ((GetBigShowRecommendRsp)localObject).Materials.iterator();
      while (((Iterator)localObject).hasNext())
      {
        BigShowRecommendInfo localBigShowRecommendInfo = (BigShowRecommendInfo)((Iterator)localObject).next();
        paramFromServiceMsg.add(localBigShowRecommendInfo.MaterialInfo);
        paramObject.add(localBigShowRecommendInfo.Reason);
      }
      AEditorMaterialManager.a().a(paramFromServiceMsg, paramObject);
      return;
    }
    AEditorMaterialManager.a().a();
  }
  
  public void a(String paramString)
  {
    if (!NetworkUtil.a())
    {
      LogUtils.w(jdField_a_of_type_JavaLangString, "[requestEditorMaterials] no network....");
      return;
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "【REQUEST】requestEditorMaterials" + paramString);
    if (AEDashboardUtil.a()) {
      AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCircleCatMatTree." + paramString, "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("ShadowBackendSvc.GetCircleCatMatTree." + paramString, Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetCircleCatMatTree");
    localToServiceMsg.extraData.putString("ServiceId", paramString);
    send(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList<byte[]> paramArrayList)
  {
    if (!NetworkUtil.a())
    {
      AEditorMaterialManager.a().a();
      return;
    }
    if (AEDashboardUtil.a()) {
      AEDashboardUtil.a().postValue(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetBigShowRecommend." + paramString, "request", "null"));
    }
    this.jdField_a_of_type_JavaUtilMap.put("ShadowBackendSvc.GetBigShowRecommend." + paramString, Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetBigShowRecommend");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putString("ServiceId", paramString);
    localBundle.putSerializable("framebytes", paramArrayList);
    send(localToServiceMsg);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetCircleCatMatTree")) {
      a(paramFromServiceMsg, paramObject);
    }
    if (paramToServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetBigShowRecommend")) {
      b(paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorDataServiceHandler
 * JD-Core Version:    0.7.0.1
 */