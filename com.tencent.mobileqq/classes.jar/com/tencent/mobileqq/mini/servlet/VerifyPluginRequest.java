package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StPlugin;
import NS_MINI_INTERFACE.INTERFACE.StVerifyPluginReq;
import NS_MINI_INTERFACE.INTERFACE.StVerifyPluginRsp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VerifyPluginRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.VerifyPlugin";
  public static final String TAG = "VerifyPluginRequest";
  private INTERFACE.StVerifyPluginReq req = new INTERFACE.StVerifyPluginReq();
  
  public VerifyPluginRequest(String paramString, List<INTERFACE.StPlugin> paramList)
  {
    this.req.appid.set(paramString);
    this.req.plugins.set(paramList);
  }
  
  public static INTERFACE.StVerifyPluginRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StVerifyPluginRsp();
    try
    {
      ((INTERFACE.StVerifyPluginRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("VerifyPluginRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.VerifyPluginRequest
 * JD-Core Version:    0.7.0.1
 */