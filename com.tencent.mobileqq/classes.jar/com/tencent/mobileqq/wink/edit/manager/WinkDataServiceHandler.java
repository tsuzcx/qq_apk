package com.tencent.mobileqq.wink.edit.manager;

import android.os.Bundle;
import android.text.TextUtils;
import camera.RECOMMEND_GENERAL_DATASTRUCT.BigShowRecommendInfo;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendReq;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendRsp;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeReq;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.google.gson.Gson;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.edit.base.AEPath.Editor.FILES;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.edit.service.WinkMsfServlet;
import com.tencent.mobileqq.wink.edit.service.WinkSendService;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;

public class WinkDataServiceHandler
  extends WinkDataBaseServiceHandler
{
  private static final String a = "WinkDataServiceHandler";
  
  public WinkDataServiceHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = (GetCatMatTreeRsp)paramObject;
    Object localObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.Code == 0) && (paramFromServiceMsg.Categories != null) && (!paramFromServiceMsg.Categories.isEmpty()))
    {
      AECameraPrefsUtil.a().a(AECameraPrefsUtil.d, paramFromServiceMsg.ETag, 4);
      paramFromServiceMsg = paramFromServiceMsg.Categories.iterator();
      for (;;)
      {
        boolean bool2 = paramFromServiceMsg.hasNext();
        boolean bool1 = false;
        if (!bool2) {
          break;
        }
        paramObject = (MetaCategory)paramFromServiceMsg.next();
        if (paramObject.id.equals("10004"))
        {
          localObject = new Gson().toJson(paramObject.subCategories);
          bool1 = FileUtils.writeFile(WinkEditorMaterialManager.a().a(AEPath.Editor.FILES.d, "editor_filter_update_template.json"), (String)localObject);
          WinkEditorResourceManager.c().m();
        }
        else if (paramObject.id.equals("10002"))
        {
          localObject = new Gson().toJson(paramObject.subCategories);
          bool1 = FileUtils.writeFile(WinkEditorMaterialManager.a().a(AEPath.Editor.FILES.b, "editor_text_sticker_update_template.json"), (String)localObject);
          WinkEditorResourceManager.c().o();
        }
        else if (paramObject.id.equals("10001"))
        {
          localObject = new Gson().toJson(paramObject.subCategories);
          bool1 = FileUtils.writeFile(WinkEditorMaterialManager.a().a(AEPath.Editor.FILES.c, "editor_auto_template_update_template.json"), (String)localObject);
          WinkEditorResourceManager.c().n();
        }
        else if (paramObject.id.equals("10003"))
        {
          localObject = new Gson().toJson(paramObject.subCategories);
          bool1 = FileUtils.writeFile(WinkEditorMaterialManager.a().a(AEPath.Editor.FILES.g, "editor_text_update_template.json"), (String)localObject);
          WinkEditorResourceManager.c().p();
        }
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.id);
        localStringBuilder.append(" isWriteFile:");
        localStringBuilder.append(bool1);
        WinkQLog.a((String)localObject, localStringBuilder.toString());
      }
      WinkEditorResourceManager.c().a(false);
    }
    else
    {
      paramObject = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("response code:");
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg = Integer.valueOf(paramFromServiceMsg.Code);
      } else {
        paramFromServiceMsg = "null";
      }
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      WinkQLog.a(paramObject, ((StringBuilder)localObject).toString());
    }
    notifyUI(1, true, null);
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (GetBigShowRecommendRsp)paramObject;
    if ((localObject != null) && (((GetBigShowRecommendRsp)localObject).Code == 0) && (((GetBigShowRecommendRsp)localObject).Materials != null) && (!((GetBigShowRecommendRsp)localObject).Materials.isEmpty()))
    {
      paramFromServiceMsg = new ArrayList();
      paramObject = new ArrayList();
      localObject = ((GetBigShowRecommendRsp)localObject).Materials.iterator();
      while (((Iterator)localObject).hasNext())
      {
        BigShowRecommendInfo localBigShowRecommendInfo = (BigShowRecommendInfo)((Iterator)localObject).next();
        paramFromServiceMsg.add(localBigShowRecommendInfo.MaterialInfo);
        paramObject.add(localBigShowRecommendInfo.Reason);
      }
      WinkEditorMaterialManager.a().a(paramFromServiceMsg, paramObject);
      WinkEditorResourceManager.c().n();
      return;
    }
    WinkEditorMaterialManager.a().d();
    WinkEditorResourceManager.c().n();
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetCatMatTreeReq localGetCatMatTreeReq = new GetCatMatTreeReq();
    localGetCatMatTreeReq.ServiceId = paramToServiceMsg.extraData.getString("ServiceId");
    localGetCatMatTreeReq.ETag = b(AECameraPrefsUtil.d);
    localGetCatMatTreeReq.SdkInfos = a();
    localGetCatMatTreeReq.GroupId = "2";
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetCircleCatMatTree");
    paramUniPacket.put("ShadowBackendSvc.GetCircleCatMatTree", localGetCatMatTreeReq);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetBigShowRecommendReq localGetBigShowRecommendReq = new GetBigShowRecommendReq();
    localGetBigShowRecommendReq.framePics = ((ArrayList)paramToServiceMsg.extraData.getSerializable("framebytes"));
    localGetBigShowRecommendReq.SdkVersion = ((MetaSdkInfo)a().get(0)).sdkVersion;
    localGetBigShowRecommendReq.MediaType = paramToServiceMsg.extraData.getInt("media_type", 0);
    paramUniPacket.setServantName("ShadowBackendSvc");
    paramUniPacket.setFuncName("ShadowBackendSvc.GetKuaishanMaterialRecommend");
    paramUniPacket.put("ShadowBackendSvc.GetKuaishanMaterialRecommend", localGetBigShowRecommendReq);
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleCatMatTree")) {
      return a(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetCircleCatMatTree", new GetCatMatTreeRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetKuaishanMaterialRecommend")) {
      return a(paramFromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetKuaishanMaterialRecommend", new GetBigShowRecommendRsp());
    }
    return null;
  }
  
  protected ArrayList<MetaSdkInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    MetaSdkInfo localMetaSdkInfo = new MetaSdkInfo();
    localMetaSdkInfo.sdk = 0;
    Object localObject = "2.6.0.23";
    if (!TextUtils.isEmpty("2.6.0.23"))
    {
      String[] arrayOfString = "2.6.0.23".split("\\.");
      if (arrayOfString.length > 3)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(arrayOfString[0]);
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(arrayOfString[1]);
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(arrayOfString[2]);
        localObject = ((StringBuilder)localObject).toString();
      }
      localMetaSdkInfo.sdkVersion = ((String)localObject);
    }
    localArrayList.add(localMetaSdkInfo);
    return localArrayList;
  }
  
  public void a(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      WinkQLog.c(a, "[requestEditorMaterials] no network....");
      return;
    }
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【REQUEST】requestEditorMaterials");
    localStringBuilder.append(paramString);
    WinkQLog.b((String)localObject, localStringBuilder.toString());
    localObject = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetCircleCatMatTree");
    ((ToServiceMsg)localObject).extraData.putString("ServiceId", paramString);
    WinkSendService.a((ToServiceMsg)localObject, getClass().getName(), WinkMsfServlet.class);
  }
  
  public void a(String paramString, ArrayList<byte[]> paramArrayList, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      WinkEditorMaterialManager.a().d();
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetKuaishanMaterialRecommend");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putString("ServiceId", paramString);
    localBundle.putSerializable("framebytes", paramArrayList);
    localBundle.putInt("media_type", paramInt);
    WinkSendService.a(localToServiceMsg, getClass().getName(), WinkMsfServlet.class);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleCatMatTree")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetKuaishanMaterialRecommend")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  protected String b(String paramString)
  {
    return AECameraPrefsUtil.a().b(paramString, "", 4);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return WinkEditorFragment.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetCircleCatMatTree")) {
      a(paramFromServiceMsg, paramObject);
    }
    if (paramToServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetKuaishanMaterialRecommend")) {
      b(paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler
 * JD-Core Version:    0.7.0.1
 */