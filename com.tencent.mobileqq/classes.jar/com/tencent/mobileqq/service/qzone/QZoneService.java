package com.tencent.mobileqq.service.qzone;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneDelPhotoWallRequest;
import cooperation.qzone.QZoneGetPhotoWallRequest;
import cooperation.qzone.QZoneRequestEncoder;

public class QZoneService
  extends BaseProtocolCoder
{
  private static String[] a = { "QzoneService", "SQQzoneSvc" };
  
  private UniPacket a(String paramString)
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setEncodeName("utf8");
    a(localUniPacket);
    localUniPacket.put("uin", Long.valueOf(Long.parseLong(paramString)));
    return localUniPacket;
  }
  
  private Object a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = QZoneRequestEncoder.decodeCoverResponse(paramFromServiceMsg.getWupBuffer());
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("decodeGetQZoneCover|jceObj = ");
      paramToServiceMsg.append(paramFromServiceMsg);
      QLog.i("Q.qzonecover.", 2, paramToServiceMsg.toString());
    }
    return paramFromServiceMsg;
  }
  
  private void a(UniPacket paramUniPacket)
  {
    paramUniPacket.setEncodeName("utf8");
    paramUniPacket.put("version", Integer.valueOf(1091030));
    paramUniPacket.put("Q-UA", AppSetting.e());
    paramUniPacket.put("rupt", Boolean.valueOf(false));
  }
  
  private byte[] a(ToServiceMsg paramToServiceMsg)
  {
    UniPacket localUniPacket = a(paramToServiceMsg.getUin());
    localUniPacket.put("uin", Long.valueOf(Long.parseLong(paramToServiceMsg.getUin())));
    a(localUniPacket);
    localUniPacket.setServantName("QzoneServer");
    localUniPacket.setFuncName("GetNewAndUnread");
    return WupUtil.a(localUniPacket.encode());
  }
  
  private Object b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = QZoneGetPhotoWallRequest.decodePhotoWallResponse(paramFromServiceMsg.getWupBuffer());
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("decodeGetQZonePhotoWall|jceObj = ");
      paramToServiceMsg.append(paramFromServiceMsg);
      QLog.i("Q.qzonephotowall", 2, paramToServiceMsg.toString());
    }
    return paramFromServiceMsg;
  }
  
  private byte[] b(ToServiceMsg paramToServiceMsg)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("flag", Integer.valueOf(1));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetQZoneCover|uin = ");
      localStringBuilder.append(str);
      localStringBuilder.append(",flag=");
      localStringBuilder.append(localInteger.intValue());
      QLog.i("Q.qzonecover.", 2, localStringBuilder.toString());
    }
    long l4 = 0L;
    long l1;
    long l2;
    try
    {
      l1 = Long.parseLong(str);
      try
      {
        l2 = Long.parseLong(paramToServiceMsg.getUin());
        l3 = l1;
      }
      catch (Exception paramToServiceMsg) {}
      l2 = l4;
    }
    catch (Exception paramToServiceMsg)
    {
      l1 = 0L;
    }
    long l3 = l1;
    if (QLog.isColorLevel())
    {
      QLog.i("Q.qzonecover.", 2, paramToServiceMsg.toString());
      l3 = l1;
      l2 = l4;
    }
    return new QZoneRequestEncoder(l3, l2, localInteger.intValue()).encode();
  }
  
  private Object c(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = QZoneDelPhotoWallRequest.decodeDelResponse(paramFromServiceMsg.getWupBuffer());
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("decodeDelQZonePhotoWall|jceObj = ");
      paramToServiceMsg.append(paramFromServiceMsg);
      QLog.i("Q.qzonephotowall", 2, paramToServiceMsg.toString());
    }
    return paramFromServiceMsg;
  }
  
  private byte[] c(ToServiceMsg paramToServiceMsg)
  {
    String str2 = (String)paramToServiceMsg.getAttribute("uin");
    String str1 = (String)paramToServiceMsg.getAttribute("photo_id");
    Long localLong = (Long)paramToServiceMsg.getAttribute("photo_time");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleDetQZonePhotoWall|uin = ");
      localStringBuilder.append(str2);
      QLog.i("Q.qzonephotowall", 2, localStringBuilder.toString());
    }
    long l1;
    try
    {
      l1 = Long.parseLong(str2);
      try
      {
        l2 = Long.parseLong(paramToServiceMsg.getUin());
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break label116;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      l1 = 0L;
    }
    QLog.i("Q.qzonephotowall", 2, paramToServiceMsg.toString());
    label116:
    long l2 = 0L;
    return new QZoneDelPhotoWallRequest(l1, l2, str1, localLong).encode();
  }
  
  private byte[] d(ToServiceMsg paramToServiceMsg)
  {
    String str2 = (String)paramToServiceMsg.getAttribute("uin");
    String str1 = (String)paramToServiceMsg.getAttribute("attachInfo");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetQZonePhotoWall|uin = ");
      localStringBuilder.append(str2);
      QLog.i("Q.qzonephotowall", 2, localStringBuilder.toString());
    }
    long l1;
    try
    {
      l1 = Long.parseLong(str2);
      try
      {
        l2 = Long.parseLong(paramToServiceMsg.getUin());
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break label105;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      l1 = 0L;
    }
    QLog.i("Q.qzonephotowall", 2, paramToServiceMsg.toString());
    label105:
    long l2 = 0L;
    return new QZoneGetPhotoWallRequest(l1, l2, str1).encode();
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("SQQzoneSvc.getCover".equals(str)) {
      return a(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SQQzoneSvc.getPhotoWall".equals(str)) {
      return b(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SQQzoneSvc.delPhotoWall".equals(str)) {
      return c(paramFromServiceMsg, paramToServiceMsg);
    }
    return null;
  }
  
  public void decodeRespMsg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean enableBinaryProtocol()
  {
    return true;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return false;
  }
  
  public byte[] encodeReqMsg(ToServiceMsg paramToServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("QzoneService.GetNewAndUnread".equals(str)) {
      return a(paramToServiceMsg);
    }
    if ("SQQzoneSvc.getCover".equals(str)) {
      return b(paramToServiceMsg);
    }
    if ("SQQzoneSvc.getPhotoWall".equals(str)) {
      return d(paramToServiceMsg);
    }
    if ("SQQzoneSvc.delPhotoWall".equals(str)) {
      return c(paramToServiceMsg);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneService
 * JD-Core Version:    0.7.0.1
 */