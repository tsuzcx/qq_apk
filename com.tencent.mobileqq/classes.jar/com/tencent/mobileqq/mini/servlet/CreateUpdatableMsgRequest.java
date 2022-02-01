package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StCreateUpdatableMsgReq;
import NS_MINI_INTERFACE.INTERFACE.StCreateUpdatableMsgRsp;
import NS_MINI_INTERFACE.INTERFACE.StUpdatableMsgShareInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class CreateUpdatableMsgRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_updatablemsg.CreateUpdatableMsg";
  private static final String TAG = "CreateUpdatableMsgRequest";
  public static final int UPDATABLE_MSG_FROM_AUDIT = 3;
  public static final int UPDATABLE_MSG_FROM_EXPERIENCE = 2;
  public static final int UPDATABLE_MSG_FROM_ONLINE = 1;
  private INTERFACE.StCreateUpdatableMsgReq req = new INTERFACE.StCreateUpdatableMsgReq();
  
  public CreateUpdatableMsgRequest(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, byte[] paramArrayOfByte)
  {
    this.req.appid.set(paramString1);
    this.req.templateId.set(paramString2);
    this.req.from.set(paramInt1);
    this.req.serviceType.set(paramInt4);
    if (paramArrayOfByte != null) {
      this.req.sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramString1 = new INTERFACE.StUpdatableMsgShareInfo();
    paramString1.scene.set(paramInt2);
    if (paramInt3 > 0) {
      paramString1.subScene.set(paramInt3);
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("Create StUpdatableMsgShareInfo with wrong scene:");
        paramString2.append(paramInt2);
        QLog.e("CreateUpdatableMsgRequest", 2, paramString2.toString());
      }
      else
      {
        paramString1.chatUin.set(paramString3);
        paramString1.groupId.set("");
      }
    }
    else
    {
      paramString1.groupId.set(paramString3);
      paramString1.chatUin.set("");
    }
    this.req.shareInfo.set(paramString1);
  }
  
  public static INTERFACE.StCreateUpdatableMsgRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StCreateUpdatableMsgRsp();
    try
    {
      ((INTERFACE.StCreateUpdatableMsgRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("CreateUpdatableMsgRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.CreateUpdatableMsgRequest
 * JD-Core Version:    0.7.0.1
 */