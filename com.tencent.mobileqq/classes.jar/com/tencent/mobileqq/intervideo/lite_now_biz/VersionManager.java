package com.tencent.mobileqq.intervideo.lite_now_biz;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.protocol.CsTask;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.pb.now.ilive_grey_interface.GreyInterfaceReq;
import com.tencent.pb.now.ilive_nearby_user_control.GetGconfReq;
import com.tencent.pb.now.ilive_nearby_user_control.GetGconfRsp;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

public class VersionManager
{
  private void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle, VersionManager.IVersionGrayscaleCallback paramIVersionGrayscaleCallback)
  {
    if (paramInt != 0)
    {
      paramIVersionGrayscaleCallback.a(false);
      return;
    }
    paramBundle = "";
    oidb_0xada.RspBody localRspBody = new oidb_0xada.RspBody();
    Object localObject = new ilive_nearby_user_control.GetGconfRsp();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      ((ilive_nearby_user_control.GetGconfRsp)localObject).mergeFrom(localRspBody.busi_buf.get().toByteArray());
      paramInt = ((ilive_nearby_user_control.GetGconfRsp)localObject).ret_code.get();
      if ((paramInt == 0) && (((ilive_nearby_user_control.GetGconfRsp)localObject).config_info.has()))
      {
        paramArrayOfByte = ((ilive_nearby_user_control.GetGconfRsp)localObject).config_info.get();
      }
      else
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("retCode: ");
        paramArrayOfByte.append(paramInt);
        paramArrayOfByte.append(", msg:");
        paramArrayOfByte.append(((ilive_nearby_user_control.GetGconfRsp)localObject).err_msg.get());
        QLog.e("VersionManager", 0, paramArrayOfByte.toString());
        paramArrayOfByte = paramBundle;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getVersionGrayConfig error: ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.e("VersionManager", 0, ((StringBuilder)localObject).toString());
      paramArrayOfByte = paramBundle;
    }
    paramIVersionGrayscaleCallback.a("true".equals(paramArrayOfByte));
  }
  
  private boolean a(oidb_0xada.ReqBody paramReqBody, AppInterface paramAppInterface)
  {
    paramReqBody.uid.set(Long.parseLong(paramAppInterface.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(paramAppInterface.getCurrentAccountUin()));
    Object localObject = (TicketManager)paramAppInterface.getManager(2);
    String str = ((TicketManager)localObject).getA2(paramAppInterface.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(paramAppInterface.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("8.7.0");
      paramReqBody.original_id.set(paramAppInterface.getCurrentAccountUin());
      paramReqBody.original_key.set((String)localObject);
      paramReqBody.original_id_type.set(1);
      return true;
    }
    return false;
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, VersionManager.IVersionGrayscaleCallback paramIVersionGrayscaleCallback)
  {
    if (paramIVersionGrayscaleCallback == null) {
      return;
    }
    ilive_grey_interface.GreyInterfaceReq localGreyInterfaceReq = new ilive_grey_interface.GreyInterfaceReq();
    localGreyInterfaceReq.uin.set(Long.valueOf(paramAppInterface.getCurrentAccountUin()).longValue());
    localGreyInterfaceReq.version.set(DeviceInfoUtil.a());
    localGreyInterfaceReq.strVersion.set(DeviceInfoUtil.c());
    localGreyInterfaceReq.clientType.set(401);
    localGreyInterfaceReq.key.set(paramInt);
    new CsTask(paramAppInterface).a(974).b(1).a(new VersionManager.3(this, paramIVersionGrayscaleCallback)).a(new VersionManager.2(this, paramIVersionGrayscaleCallback)).a(localGreyInterfaceReq.toByteArray());
  }
  
  public void a(AppInterface paramAppInterface, VersionManager.IVersionGrayscaleCallback paramIVersionGrayscaleCallback)
  {
    if (paramIVersionGrayscaleCallback == null) {
      return;
    }
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (a(localReqBody, paramAppInterface))
    {
      long l = paramAppInterface.getLongAccountUin();
      ilive_nearby_user_control.GetGconfReq localGetGconfReq = new ilive_nearby_user_control.GetGconfReq();
      localGetGconfReq.uid.set(l);
      localReqBody.cmd.set(1008);
      localReqBody.subcmd.set(3);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localGetGconfReq.toByteArray()));
      ProtoUtils.a(paramAppInterface, new VersionManager.1(this, paramIVersionGrayscaleCallback), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.VersionManager
 * JD-Core Version:    0.7.0.1
 */