package dov.com.qq.im.ae.config;

import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class CameraDataService
  extends BaseProtocolCoder
{
  public static final HashMap<String, String> a;
  private static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "CameraModuleSvc" };
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private String a(String paramString)
  {
    return AECameraPrefsUtil.a().a(paramString, "", 4);
  }
  
  private ArrayList<MetaSdkInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    MetaSdkInfo localMetaSdkInfo = new MetaSdkInfo();
    localMetaSdkInfo.sdk = 0;
    localMetaSdkInfo.sdkVersion = AEModule.getVersion(MobileQQ.getContext());
    localArrayList.add(localMetaSdkInfo);
    return localArrayList;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetCameraConfigReq();
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetCameraConfig");
    paramUniPacket.put("CameraModuleSvc.GetCameraConfig", paramToServiceMsg);
    return true;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetCategoryMaterialReq localGetCategoryMaterialReq = new GetCategoryMaterialReq();
    localGetCategoryMaterialReq.ServiceId = paramToServiceMsg.extraData.getString("ServiceId");
    localGetCategoryMaterialReq.ETag = a("CameraModuleSvc.GetCompressedCategoryMaterialV2" + localGetCategoryMaterialReq.ServiceId);
    localGetCategoryMaterialReq.SdkInfos = a();
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetCompressedCategoryMaterialV2");
    paramUniPacket.put("CameraModuleSvc.GetCompressedCategoryMaterialV2", localGetCategoryMaterialReq);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetPlayShowCatMatTreeReq();
    paramToServiceMsg.ETag = a("CameraModuleSvc.GetPlayShowCatMatTree");
    paramToServiceMsg.MqVersion = "8.5.5";
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetPlayShowCatMatTree");
    paramUniPacket.put("CameraModuleSvc.GetPlayShowCatMatTree", paramToServiceMsg);
    return true;
  }
  
  public final <T> T a(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    CompressUniPacket localCompressUniPacket = new CompressUniPacket(true);
    try
    {
      localCompressUniPacket.setEncodeName("utf-8");
      localCompressUniPacket.decode(paramArrayOfByte);
      return localCompressUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetCameraConfig", new GetCameraConfigRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterialV2")) {
      return a(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetCompressedCategoryMaterialV2", new GetCategoryMaterialRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) {
      return a(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetPlayShowCatMatTree", new GetPlayShowCatMatTreeRsp());
    }
    return null;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterialV2")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.config.CameraDataService
 * JD-Core Version:    0.7.0.1
 */