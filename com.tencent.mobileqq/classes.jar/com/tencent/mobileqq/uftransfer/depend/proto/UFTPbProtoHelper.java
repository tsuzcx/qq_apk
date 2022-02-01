package com.tencent.mobileqq.uftransfer.depend.proto;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CSetUploadSucReq;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadReq;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadRsp;
import com.tencent.mobileqq.uftransfer.proto.UFTDiscUploadReq;
import com.tencent.mobileqq.uftransfer.proto.UFTDiscUploadRsp;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadReReq;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadReq;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x1ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x1RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public class UFTPbProtoHelper
{
  public static UFTC2CUploadRsp a(cmd0x346.ApplyUploadHitRspV2 paramApplyUploadHitRspV2)
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = new UFTC2CUploadRsp();
    if (paramApplyUploadHitRspV2.int32_ret_code.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadHitRspV2.int32_ret_code.get());
    }
    if (paramApplyUploadHitRspV2.str_ret_msg.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadHitRspV2.str_ret_msg.get());
    }
    if (paramApplyUploadHitRspV2.uint64_total_space.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadHitRspV2.uint64_total_space.get());
    }
    if (paramApplyUploadHitRspV2.uint64_used_space.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadHitRspV2.uint64_used_space.get());
    }
    if (paramApplyUploadHitRspV2.str_upload_ip.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadHitRspV2.str_upload_ip.get());
    } else if (paramApplyUploadHitRspV2.str_upload_domain.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadHitRspV2.str_upload_domain.get());
    } else {
      QLog.i("[UFTTransfer] UFTPbProtoHelper", 1, "=_= ^! [CS Replay] getC2CUploadHitRspV2 has neither ip nor domain");
    }
    if (paramApplyUploadHitRspV2.uint32_upload_port.has()) {
      localUFTC2CUploadRsp.a((short)paramApplyUploadHitRspV2.uint32_upload_port.get());
    }
    if (paramApplyUploadHitRspV2.bytes_uuid.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadHitRspV2.bytes_uuid.get().toByteArray());
    }
    if (paramApplyUploadHitRspV2.bytes_upload_key.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadHitRspV2.bytes_upload_key.get().toByteArray());
    }
    if (paramApplyUploadHitRspV2.str_upload_https_domain.has()) {
      localUFTC2CUploadRsp.c(paramApplyUploadHitRspV2.str_upload_https_domain.get());
    }
    if (paramApplyUploadHitRspV2.uint32_upload_https_port.has()) {
      localUFTC2CUploadRsp.b((short)paramApplyUploadHitRspV2.uint32_upload_https_port.get());
    }
    if (paramApplyUploadHitRspV2.str_upload_dns.has()) {
      localUFTC2CUploadRsp.d(paramApplyUploadHitRspV2.str_upload_dns.get());
    }
    return localUFTC2CUploadRsp;
  }
  
  public static UFTC2CUploadRsp a(cmd0x346.ApplyUploadRspV2 paramApplyUploadRspV2)
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = new UFTC2CUploadRsp();
    if (paramApplyUploadRspV2.int32_ret_code.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV2.int32_ret_code.get());
    }
    if (paramApplyUploadRspV2.str_ret_msg.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV2.str_ret_msg.get());
    }
    if (paramApplyUploadRspV2.uint64_total_space.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV2.uint64_total_space.get());
    }
    if (paramApplyUploadRspV2.uint64_used_space.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadRspV2.uint64_used_space.get());
    }
    if (paramApplyUploadRspV2.uint64_uploaded_size.has()) {
      localUFTC2CUploadRsp.c(paramApplyUploadRspV2.uint64_uploaded_size.get());
    }
    if (paramApplyUploadRspV2.str_upload_ip.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadRspV2.str_upload_ip.get());
    } else if (paramApplyUploadRspV2.str_upload_domain.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadRspV2.str_upload_domain.get());
    } else {
      UFTLog.b("[UFTTransfer] UFTPbProtoHelper", 1, "=_= ^! [CS Replay] getC2CUploadRspV2 has neither ip nor domain");
    }
    if (paramApplyUploadRspV2.uint32_upload_port.has()) {
      localUFTC2CUploadRsp.a((short)paramApplyUploadRspV2.uint32_upload_port.get());
    }
    if (paramApplyUploadRspV2.bytes_uuid.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV2.bytes_uuid.get().toByteArray());
    }
    if (paramApplyUploadRspV2.bytes_upload_key.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadRspV2.bytes_upload_key.get().toByteArray());
    }
    if (paramApplyUploadRspV2.bool_file_exist.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV2.bool_file_exist.get());
    }
    if (paramApplyUploadRspV2.uint32_upload_port.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadRspV2.uint32_pack_size.get());
    }
    if (paramApplyUploadRspV2.uint32_httpsvr_api_ver.has()) {
      localUFTC2CUploadRsp.c(paramApplyUploadRspV2.uint32_httpsvr_api_ver.get());
    }
    if (paramApplyUploadRspV2.bytes_sha.has()) {
      localUFTC2CUploadRsp.c(paramApplyUploadRspV2.bytes_sha.get().toByteArray());
    }
    if ((paramApplyUploadRspV2.rpt_str_uploadip_list.has()) && (paramApplyUploadRspV2.rpt_str_uploadip_list.get().size() > 0)) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV2.rpt_str_uploadip_list.get());
    }
    if (paramApplyUploadRspV2.str_upload_https_domain.has()) {
      localUFTC2CUploadRsp.c(paramApplyUploadRspV2.str_upload_https_domain.get());
    }
    if (paramApplyUploadRspV2.uint32_upload_https_port.has()) {
      localUFTC2CUploadRsp.b((short)paramApplyUploadRspV2.uint32_upload_https_port.get());
    }
    if (paramApplyUploadRspV2.str_upload_dns.has()) {
      localUFTC2CUploadRsp.d(paramApplyUploadRspV2.str_upload_dns.get());
    }
    if (paramApplyUploadRspV2.str_upload_lanip.has()) {
      localUFTC2CUploadRsp.e(paramApplyUploadRspV2.str_upload_lanip.get());
    }
    return localUFTC2CUploadRsp;
  }
  
  public static UFTC2CUploadRsp a(cmd0x346.ApplyUploadRspV3 paramApplyUploadRspV3, boolean paramBoolean)
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = new UFTC2CUploadRsp();
    if (paramApplyUploadRspV3.int32_ret_code.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV3.int32_ret_code.get());
    }
    if (paramApplyUploadRspV3.str_ret_msg.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV3.str_ret_msg.get());
    }
    if (paramApplyUploadRspV3.uint64_total_space.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV3.uint64_total_space.get());
    }
    if (paramApplyUploadRspV3.uint64_used_space.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadRspV3.uint64_used_space.get());
    }
    if (paramApplyUploadRspV3.uint64_uploaded_size.has()) {
      localUFTC2CUploadRsp.c(paramApplyUploadRspV3.uint64_uploaded_size.get());
    }
    if (paramApplyUploadRspV3.str_upload_ip.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadRspV3.str_upload_ip.get());
    } else if (paramApplyUploadRspV3.str_upload_domain.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadRspV3.str_upload_domain.get());
    } else {
      UFTLog.c("[UFTTransfer] UFTPbProtoHelper", 1, "=_= ^! [CS Replay] getC2CUploadRsV3 has neither ip nor domain");
    }
    if (paramApplyUploadRspV3.uint32_upload_port.has()) {
      localUFTC2CUploadRsp.a((short)paramApplyUploadRspV3.uint32_upload_port.get());
    }
    if (paramApplyUploadRspV3.bytes_uuid.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV3.bytes_uuid.get().toByteArray());
    }
    if (paramApplyUploadRspV3.bytes_upload_key.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadRspV3.bytes_upload_key.get().toByteArray());
    }
    if (paramApplyUploadRspV3.bool_file_exist.has()) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV3.bool_file_exist.get());
    }
    localUFTC2CUploadRsp.b(paramBoolean);
    if (localUFTC2CUploadRsp.n()) {
      if (localUFTC2CUploadRsp.g())
      {
        if (paramApplyUploadRspV3.str_fileidcrc.has()) {
          localUFTC2CUploadRsp.f(paramApplyUploadRspV3.str_fileidcrc.get());
        }
      }
      else if (paramApplyUploadRspV3.bytes_media_plateform_upload_key.has()) {
        localUFTC2CUploadRsp.e(paramApplyUploadRspV3.bytes_media_plateform_upload_key.get().toByteArray());
      } else {
        UFTLog.b("[UFTTransfer] UFTPbProtoHelper", 1, "getC2CUploadRsV3: bUseMediaPlatform but has not bytes_media_plateform_upload_key");
      }
    }
    if (paramApplyUploadRspV3.uint32_upload_port.has()) {
      localUFTC2CUploadRsp.b(paramApplyUploadRspV3.uint32_pack_size.get());
    }
    if ((paramApplyUploadRspV3.rpt_str_uploadip_list.has()) && (paramApplyUploadRspV3.rpt_str_uploadip_list.get().size() > 0)) {
      localUFTC2CUploadRsp.a(paramApplyUploadRspV3.rpt_str_uploadip_list.get());
    }
    if (paramApplyUploadRspV3.str_upload_https_domain.has()) {
      localUFTC2CUploadRsp.c(paramApplyUploadRspV3.str_upload_https_domain.get());
    }
    if (paramApplyUploadRspV3.uint32_upload_https_port.has()) {
      localUFTC2CUploadRsp.b((short)paramApplyUploadRspV3.uint32_upload_https_port.get());
    }
    if (paramApplyUploadRspV3.str_upload_dns.has()) {
      localUFTC2CUploadRsp.d(paramApplyUploadRspV3.str_upload_dns.get());
    }
    if (paramApplyUploadRspV3.str_upload_lanip.has()) {
      localUFTC2CUploadRsp.e(paramApplyUploadRspV3.str_upload_lanip.get());
    }
    return localUFTC2CUploadRsp;
  }
  
  public static UFTDiscUploadRsp a(cmd0x345.RspBody.SubCmd0x1RspBody paramSubCmd0x1RspBody)
  {
    UFTDiscUploadRsp localUFTDiscUploadRsp = new UFTDiscUploadRsp();
    if (paramSubCmd0x1RspBody.str_file_id.has()) {
      localUFTDiscUploadRsp.a(paramSubCmd0x1RspBody.str_file_id.get());
    }
    if (paramSubCmd0x1RspBody.str_file_key.has()) {
      localUFTDiscUploadRsp.b(paramSubCmd0x1RspBody.str_file_key.get());
    }
    if (paramSubCmd0x1RspBody.str_check_sum.has()) {
      localUFTDiscUploadRsp.c(paramSubCmd0x1RspBody.str_check_sum.get());
    }
    if (paramSubCmd0x1RspBody.str_host.has()) {
      localUFTDiscUploadRsp.d(paramSubCmd0x1RspBody.str_host.get());
    }
    if (paramSubCmd0x1RspBody.uint32_port.has()) {
      localUFTDiscUploadRsp.b(paramSubCmd0x1RspBody.uint32_port.get());
    }
    if (paramSubCmd0x1RspBody.str_file_name.has()) {
      localUFTDiscUploadRsp.e(paramSubCmd0x1RspBody.str_file_name.get());
    }
    if (paramSubCmd0x1RspBody.str_warn.has()) {
      localUFTDiscUploadRsp.f(paramSubCmd0x1RspBody.str_warn.get());
    }
    if (paramSubCmd0x1RspBody.str_https_domain.has()) {
      localUFTDiscUploadRsp.g(paramSubCmd0x1RspBody.str_https_domain.get());
    }
    if (paramSubCmd0x1RspBody.uint32_https_port.has()) {
      localUFTDiscUploadRsp.a((short)paramSubCmd0x1RspBody.uint32_https_port.get());
    }
    if (paramSubCmd0x1RspBody.str_dns.has()) {
      localUFTDiscUploadRsp.h(paramSubCmd0x1RspBody.str_dns.get());
    }
    return localUFTDiscUploadRsp;
  }
  
  public static UFTTroopUploadRsp a(oidb_0x6d6.ResendRspBody paramResendRspBody)
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = new UFTTroopUploadRsp();
    if (paramResendRspBody.int32_ret_code.has()) {
      localUFTTroopUploadRsp.a(paramResendRspBody.int32_ret_code.get());
    }
    if (paramResendRspBody.str_ret_msg.has()) {
      localUFTTroopUploadRsp.a(paramResendRspBody.str_ret_msg.get());
    }
    if (paramResendRspBody.str_client_wording.has()) {
      localUFTTroopUploadRsp.b(paramResendRspBody.str_client_wording.get());
    }
    if (paramResendRspBody.str_upload_ip.has()) {
      localUFTTroopUploadRsp.d(paramResendRspBody.str_upload_ip.get());
    }
    if (paramResendRspBody.bytes_check_key.has()) {
      localUFTTroopUploadRsp.a(paramResendRspBody.bytes_check_key.get().toByteArray());
    }
    return localUFTTroopUploadRsp;
  }
  
  public static UFTTroopUploadRsp a(oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody)
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = new UFTTroopUploadRsp();
    if (paramUploadFileRspBody.int32_ret_code.has()) {
      localUFTTroopUploadRsp.a(paramUploadFileRspBody.int32_ret_code.get());
    }
    if (paramUploadFileRspBody.str_ret_msg.has()) {
      localUFTTroopUploadRsp.a(paramUploadFileRspBody.str_ret_msg.get());
    }
    if (paramUploadFileRspBody.str_client_wording.has()) {
      localUFTTroopUploadRsp.b(paramUploadFileRspBody.str_client_wording.get());
    }
    if (paramUploadFileRspBody.str_file_id.has()) {
      localUFTTroopUploadRsp.c(paramUploadFileRspBody.str_file_id.get());
    }
    if (paramUploadFileRspBody.str_upload_ip.has()) {
      localUFTTroopUploadRsp.d(paramUploadFileRspBody.str_upload_ip.get());
    }
    if (paramUploadFileRspBody.str_server_dns.has()) {
      localUFTTroopUploadRsp.e(paramUploadFileRspBody.str_server_dns.get());
    }
    if (paramUploadFileRspBody.bytes_check_key.has()) {
      localUFTTroopUploadRsp.a(paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    }
    if (paramUploadFileRspBody.uint32_bus_id.has()) {
      localUFTTroopUploadRsp.b(paramUploadFileRspBody.uint32_bus_id.get());
    }
    if (paramUploadFileRspBody.str_upload_ip_lan_v4.has()) {
      localUFTTroopUploadRsp.a(paramUploadFileRspBody.str_upload_ip_lan_v4.get());
    }
    if (paramUploadFileRspBody.str_upload_ip_lan_v6.has()) {
      localUFTTroopUploadRsp.b(paramUploadFileRspBody.str_upload_ip_lan_v6.get());
    }
    if (paramUploadFileRspBody.uint32_upload_port.has()) {
      localUFTTroopUploadRsp.c(paramUploadFileRspBody.uint32_upload_port.get());
    }
    return localUFTTroopUploadRsp;
  }
  
  public static cmd0x345.ReqBody.SubCmd0x1ReqBody a(UFTDiscUploadReq paramUFTDiscUploadReq)
  {
    cmd0x345.ReqBody.SubCmd0x1ReqBody localSubCmd0x1ReqBody = new cmd0x345.ReqBody.SubCmd0x1ReqBody();
    localSubCmd0x1ReqBody.str_md5.set(paramUFTDiscUploadReq.c());
    localSubCmd0x1ReqBody.str_sha.set(paramUFTDiscUploadReq.d());
    localSubCmd0x1ReqBody.str_file_name.set(paramUFTDiscUploadReq.e());
    localSubCmd0x1ReqBody.uint64_file_size.set(paramUFTDiscUploadReq.f());
    localSubCmd0x1ReqBody.uint32_upload_type.set(1);
    long l = Long.parseLong(paramUFTDiscUploadReq.b());
    localSubCmd0x1ReqBody.uint32_disscus_uin.set((int)l);
    l = Long.parseLong(paramUFTDiscUploadReq.a());
    localSubCmd0x1ReqBody.uint32_sender_uin.set((int)l);
    localSubCmd0x1ReqBody.uint32_costom_id.set(0);
    return localSubCmd0x1ReqBody;
  }
  
  public static cmd0x346.ApplyUploadReqV2 a(UFTC2CUploadReq paramUFTC2CUploadReq)
  {
    cmd0x346.ApplyUploadReqV2 localApplyUploadReqV2 = new cmd0x346.ApplyUploadReqV2();
    localApplyUploadReqV2.uint64_sender_uin.set(paramUFTC2CUploadReq.c());
    localApplyUploadReqV2.uint64_recver_uin.set(paramUFTC2CUploadReq.d());
    localApplyUploadReqV2.uint64_file_size.set(paramUFTC2CUploadReq.a());
    localApplyUploadReqV2.str_file_name.set(paramUFTC2CUploadReq.b());
    localApplyUploadReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramUFTC2CUploadReq.i()));
    localApplyUploadReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramUFTC2CUploadReq.l()));
    localApplyUploadReqV2.str_local_filepath.set(paramUFTC2CUploadReq.m());
    localApplyUploadReqV2.uint32_danger_level.set(paramUFTC2CUploadReq.n());
    localApplyUploadReqV2.uint64_total_space.set(paramUFTC2CUploadReq.o());
    return localApplyUploadReqV2;
  }
  
  public static cmd0x346.UploadSuccReq a(UFTC2CSetUploadSucReq paramUFTC2CSetUploadSucReq)
  {
    cmd0x346.UploadSuccReq localUploadSuccReq = new cmd0x346.UploadSuccReq();
    localUploadSuccReq.uint64_sender_uin.set(paramUFTC2CSetUploadSucReq.c());
    localUploadSuccReq.uint64_recver_uin.set(paramUFTC2CSetUploadSucReq.d());
    localUploadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramUFTC2CSetUploadSucReq.a()));
    if (paramUFTC2CSetUploadSucReq.e())
    {
      if (!TextUtils.isEmpty(paramUFTC2CSetUploadSucReq.b()))
      {
        localUploadSuccReq.str_fileidcrc.set(paramUFTC2CSetUploadSucReq.b());
        UFTLog.b("[UFTTransfer] UFTPbProtoHelper", 1, "getC2CSetUploadSucReq: UseMediaPlatform enabled");
        return localUploadSuccReq;
      }
      UFTLog.d("[UFTTransfer] UFTPbProtoHelper", 1, "getC2CSetUploadSucReq: UseMediaPlatform enabled but FileIdCrc is null");
    }
    return localUploadSuccReq;
  }
  
  public static oidb_0x6d6.ResendReqBody a(UFTTroopUploadReReq paramUFTTroopUploadReReq)
  {
    oidb_0x6d6.ResendReqBody localResendReqBody = new oidb_0x6d6.ResendReqBody();
    localResendReqBody.uint32_bus_id.set(paramUFTTroopUploadReReq.a());
    localResendReqBody.uint32_app_id.set(3);
    localResendReqBody.uint64_group_code.set(paramUFTTroopUploadReReq.b());
    localResendReqBody.str_file_id.set(paramUFTTroopUploadReReq.d());
    localResendReqBody.bytes_sha.set(ByteStringMicro.copyFrom(paramUFTTroopUploadReReq.c()));
    return localResendReqBody;
  }
  
  public static oidb_0x6d6.UploadFileReqBody a(UFTTroopUploadReq paramUFTTroopUploadReq)
  {
    oidb_0x6d6.UploadFileReqBody localUploadFileReqBody = new oidb_0x6d6.UploadFileReqBody();
    localUploadFileReqBody.uint32_bus_id.set(paramUFTTroopUploadReq.a());
    localUploadFileReqBody.uint32_app_id.set(3);
    localUploadFileReqBody.uint64_group_code.set(paramUFTTroopUploadReq.c());
    localUploadFileReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramUFTTroopUploadReq.d()));
    localUploadFileReqBody.bytes_sha.set(ByteStringMicro.copyFrom(paramUFTTroopUploadReq.e()));
    if ((paramUFTTroopUploadReq.f() != null) && (paramUFTTroopUploadReq.f().length > 0)) {
      localUploadFileReqBody.bytes_sha3.set(ByteStringMicro.copyFrom(paramUFTTroopUploadReq.f()));
    }
    if (TextUtils.isEmpty(paramUFTTroopUploadReq.b())) {
      localUploadFileReqBody.str_parent_folder_id.set("/");
    } else {
      localUploadFileReqBody.str_parent_folder_id.set(paramUFTTroopUploadReq.b());
    }
    localUploadFileReqBody.str_file_name.set(paramUFTTroopUploadReq.g());
    localUploadFileReqBody.str_local_path.set(paramUFTTroopUploadReq.h());
    localUploadFileReqBody.uint32_entrance.set(paramUFTTroopUploadReq.j());
    localUploadFileReqBody.uint64_file_size.set(paramUFTTroopUploadReq.i());
    localUploadFileReqBody.bool_support_multi_upload.set(paramUFTTroopUploadReq.k());
    return localUploadFileReqBody;
  }
  
  public static cmd0x346.ApplyUploadHitReqV2 b(UFTC2CUploadReq paramUFTC2CUploadReq)
  {
    cmd0x346.ApplyUploadHitReqV2 localApplyUploadHitReqV2 = new cmd0x346.ApplyUploadHitReqV2();
    localApplyUploadHitReqV2.uint64_sender_uin.set(paramUFTC2CUploadReq.c());
    localApplyUploadHitReqV2.uint64_recver_uin.set(paramUFTC2CUploadReq.d());
    localApplyUploadHitReqV2.uint64_file_size.set(paramUFTC2CUploadReq.a());
    localApplyUploadHitReqV2.str_file_name.set(paramUFTC2CUploadReq.b());
    localApplyUploadHitReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramUFTC2CUploadReq.i()));
    localApplyUploadHitReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramUFTC2CUploadReq.l()));
    localApplyUploadHitReqV2.bytes_sha.set(ByteStringMicro.copyFrom(paramUFTC2CUploadReq.k()));
    localApplyUploadHitReqV2.str_local_filepath.set(paramUFTC2CUploadReq.m());
    localApplyUploadHitReqV2.uint32_danger_level.set(paramUFTC2CUploadReq.n());
    localApplyUploadHitReqV2.uint64_total_space.set(paramUFTC2CUploadReq.o());
    return localApplyUploadHitReqV2;
  }
  
  public static cmd0x346.ApplyUploadReqV3 c(UFTC2CUploadReq paramUFTC2CUploadReq)
  {
    cmd0x346.ApplyUploadReqV3 localApplyUploadReqV3 = new cmd0x346.ApplyUploadReqV3();
    localApplyUploadReqV3.uint64_sender_uin.set(paramUFTC2CUploadReq.c());
    localApplyUploadReqV3.uint64_recver_uin.set(paramUFTC2CUploadReq.d());
    localApplyUploadReqV3.uint64_file_size.set(paramUFTC2CUploadReq.a());
    localApplyUploadReqV3.str_file_name.set(paramUFTC2CUploadReq.b());
    localApplyUploadReqV3.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramUFTC2CUploadReq.i()));
    if (paramUFTC2CUploadReq.j() != null) {
      localApplyUploadReqV3.bytes_md5.set(ByteStringMicro.copyFrom(paramUFTC2CUploadReq.j()));
    }
    localApplyUploadReqV3.bytes_sha.set(ByteStringMicro.copyFrom(paramUFTC2CUploadReq.k()));
    if (paramUFTC2CUploadReq.l() != null) {
      localApplyUploadReqV3.bytes_3sha.set(ByteStringMicro.copyFrom(paramUFTC2CUploadReq.l()));
    }
    localApplyUploadReqV3.uint32_contenttype.set(0);
    localApplyUploadReqV3.str_local_filepath.set(paramUFTC2CUploadReq.m());
    localApplyUploadReqV3.uint32_danger_level.set(paramUFTC2CUploadReq.n());
    localApplyUploadReqV3.uint64_total_space.set(paramUFTC2CUploadReq.o());
    return localApplyUploadReqV3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.proto.UFTPbProtoHelper
 * JD-Core Version:    0.7.0.1
 */