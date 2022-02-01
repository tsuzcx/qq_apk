package dov.com.qq.im.ae.config;

import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBulkImageClassifyReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBulkImageClassifyRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusRsp;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

public class CameraPeakDataService
  extends CameraDataService
{
  private static final String[] a = { "CameraModuleSvc" };
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetFontDataReq localGetFontDataReq = new GetFontDataReq();
    localGetFontDataReq.Content = paramToServiceMsg.extraData.getString("Content");
    localGetFontDataReq.FontName = paramToServiceMsg.extraData.getString("FontName");
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetFontData");
    paramUniPacket.put("CameraModuleSvc.GetFontData", localGetFontDataReq);
    return true;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetImgValidStatusReq localGetImgValidStatusReq = new GetImgValidStatusReq();
    localGetImgValidStatusReq.Rawdata = paramToServiceMsg.extraData.getByteArray("Rawdata");
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetImgValidStatus");
    paramUniPacket.put("CameraModuleSvc.GetImgValidStatus", localGetImgValidStatusReq);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetBulkImageClassifyReq localGetBulkImageClassifyReq = new GetBulkImageClassifyReq();
    localGetBulkImageClassifyReq.MultiPics = ((ArrayList)paramToServiceMsg.extraData.getSerializable("AI_FILTER_REQ_PICS"));
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetBulkImageClassify");
    paramUniPacket.put("CameraModuleSvc.GetBulkImageClassify", localGetBulkImageClassifyReq);
    paramToServiceMsg.setTimeout(15000L);
    return true;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetOnlineUserNumReq();
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetOnlineUserNum");
    paramUniPacket.put("CameraModuleSvc.GetOnlineUserNum", paramToServiceMsg);
    return true;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetCameraConfigReq();
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetCameraConfig");
    paramUniPacket.put("CameraModuleSvc.GetCameraConfig", paramToServiceMsg);
    return true;
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetRecommandTextByEmotionReq localGetRecommandTextByEmotionReq = new GetRecommandTextByEmotionReq();
    localGetRecommandTextByEmotionReq.Rawdata = paramToServiceMsg.extraData.getByteArray("Rawdata");
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetRecommandTextByEmotion");
    paramUniPacket.put("CameraModuleSvc.GetRecommandTextByEmotion", localGetRecommandTextByEmotionReq);
    return true;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetTextValidStatusReq localGetTextValidStatusReq = new GetTextValidStatusReq();
    localGetTextValidStatusReq.EmoText = paramToServiceMsg.extraData.getString("EmoText");
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetTextValidStatus");
    paramUniPacket.put("CameraModuleSvc.GetTextValidStatus", localGetTextValidStatusReq);
    return true;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetRecommandTextByEmotion", new GetRecommandTextByEmotionRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetTextValidStatus", new GetTextValidStatusRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetCameraConfig", new GetCameraConfigRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetOnlineUserNum", new GetOnlineUserNumRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetFontData", new GetFontDataRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetImgValidStatus", new GetImgValidStatusRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetBulkImageClassify", new GetBulkImageClassifyRsp());
    }
    return super.decode(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    return super.encodeReqMsg(paramToServiceMsg, paramUniPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.config.CameraPeakDataService
 * JD-Core Version:    0.7.0.1
 */