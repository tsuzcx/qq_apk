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
    ilive_nearby_user_control.GetGconfRsp localGetGconfRsp = new ilive_nearby_user_control.GetGconfRsp();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        localGetGconfRsp.mergeFrom(localRspBody.busi_buf.get().toByteArray());
        paramInt = localGetGconfRsp.ret_code.get();
        if ((paramInt != 0) || (!localGetGconfRsp.config_info.has())) {
          continue;
        }
        paramArrayOfByte = localGetGconfRsp.config_info.get();
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.e("VersionManager", 0, "getVersionGrayConfig error: " + paramArrayOfByte);
        paramArrayOfByte = paramBundle;
        continue;
      }
      paramIVersionGrayscaleCallback.a("true".equals(paramArrayOfByte));
      return;
      QLog.e("VersionManager", 0, "retCode: " + paramInt + ", msg:" + localGetGconfRsp.err_msg.get());
      paramArrayOfByte = paramBundle;
    }
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
      paramReqBody.version.set("8.5.5");
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
    if (paramIVersionGrayscaleCallback == null) {}
    oidb_0xada.ReqBody localReqBody;
    do
    {
      return;
      localReqBody = new oidb_0xada.ReqBody();
    } while (!a(localReqBody, paramAppInterface));
    long l = paramAppInterface.getLongAccountUin();
    ilive_nearby_user_control.GetGconfReq localGetGconfReq = new ilive_nearby_user_control.GetGconfReq();
    localGetGconfReq.uid.set(l);
    localReqBody.cmd.set(1008);
    localReqBody.subcmd.set(3);
    localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localGetGconfReq.toByteArray()));
    ProtoUtils.a(paramAppInterface, new VersionManager.1(this, paramIVersionGrayscaleCallback), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.VersionManager
 * JD-Core Version:    0.7.0.1
 */