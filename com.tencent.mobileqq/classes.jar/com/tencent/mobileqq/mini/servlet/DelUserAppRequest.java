package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StDelUserAppReq;
import NS_MINI_INTERFACE.INTERFACE.StDelUserAppRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class DelUserAppRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.DelUserApp";
  private INTERFACE.StDelUserAppReq req = new INTERFACE.StDelUserAppReq();
  
  public DelUserAppRequest(COMM.StCommonExt paramStCommonExt, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.req.appId.set(paramString);
    this.req.verType.set(paramInt1);
    this.req.isRecommend.set(paramInt2);
    this.req.source.set(paramInt3);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.noDelTop.set(paramInt4);
  }
  
  public static INTERFACE.StDelUserAppRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StDelUserAppRsp();
    try
    {
      ((INTERFACE.StDelUserAppRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("ProtoBufRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.DelUserAppRequest
 * JD-Core Version:    0.7.0.1
 */