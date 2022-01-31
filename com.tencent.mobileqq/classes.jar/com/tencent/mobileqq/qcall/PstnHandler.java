package com.tencent.mobileqq.qcall;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.PstnNumberManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.phone.PhoneNumberInfo;
import com.tencent.mobileqq.phone.PhoneNumberUtil;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.manager.TicketManager;
import tencent.im.cs.longconn.hd_video.CmdPSTNCallbackNotifyAccept;
import tencent.im.cs.longconn.hd_video.CmdPSTNCallbackNotifyLogout;
import tencent.im.cs.longconn.hd_video.MsgBody;
import tencent.im.cs.longconn.hd_video.VideoHead;
import tencent.im.cs.longconn.voip.hd_video_voip_2.BalanceAccount;
import tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneBindReqBody;
import tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneBindRspBody;
import tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneCancelCallBackReqBody;
import tencent.im.cs.longconn.voip.hd_video_voip_2.ReqBody;
import tencent.im.cs.longconn.voip.hd_video_voip_2.RspBody;
import tencent.im.cs.longconn.voip.hd_video_voip_2.TelInfo;
import tencent.im.cs.longconn.voip.hd_video_voip_2.VoipHead;
import tencent.im.oidb.cmd0x4f1.oidb_0x4f1.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class PstnHandler
  extends BusinessHandler
{
  private static int jdField_a_of_type_Int = 1;
  private static int b;
  private static int c = 3;
  private static int d = 6;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  
  static
  {
    jdField_b_of_type_Int = 2;
  }
  
  public PstnHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(1, 42005);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(2, 42006);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(3, 26014);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(4, 26012);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(5, 42012);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(6, 42011);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(7, 42007);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(8, 42008);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(9, 26015);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.append(10, 26013);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnHandler", 2, "PSTNHandler sendSharpPstnCallbackAck");
    }
    ToServiceMsg localToServiceMsg = super.a("SharpSvr.s2cackpstncallback");
    localToServiceMsg.putWupBuffer(paramArrayOfByte);
    localToServiceMsg.setNeedCallback(false);
    super.b(localToServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        int i;
        boolean bool2;
        boolean bool1;
        paramFromServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PstnHandler", 2, "sso merge error");
        }
      }
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
    {
      i = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("PstnHandler", 2, "handle_oidb_0x4ff_75 ret=" + i);
      }
      if ((i == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        i = paramToServiceMsg.length;
        bool2 = true;
        if (QLog.isColorLevel()) {
          QLog.i("PstnHandler", 2, " ==== handleSetPstnInfo  success === ");
        }
        bool1 = bool2;
        if (4 > i) {
          break label206;
        }
        paramToServiceMsg = String.valueOf(PkgTools.a(paramToServiceMsg, 0));
        if (paramToServiceMsg != null)
        {
          bool1 = bool2;
          if (paramToServiceMsg.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
            break label206;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.w("PstnHandler", 2, "handleSetPstnInfo uin error");
        }
      }
    }
    bool1 = false;
    label206:
    if (bool1) {
      a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    super.a(60001, bool1, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    bool3 = false;
    bool2 = false;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder().append(" === handleGetPstnCardInfo isSuccess:　").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label79;
      }
    }
    label79:
    for (int i = paramArrayOfByte.length;; i = -1)
    {
      QLog.d("PstnHandler", 2, i);
      if (paramArrayOfByte != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PstnHandler", 2, " === handleGetPstnCardInfo === data is null ====");
      }
      return;
    }
    Object localObject3 = null;
    localObject2 = null;
    paramToServiceMsg = null;
    localObject1 = localObject3;
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramArrayOfByte = new oidb_0x5eb.RspBody();
          paramArrayOfByte.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramArrayOfByte.rpt_msg_uin_data.size() <= 0) {
            continue;
          }
          paramToServiceMsg = new PstnCardInfo();
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool2 = bool3;
        paramToServiceMsg = localObject2;
        localObject1 = paramToServiceMsg;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PstnHandler", 2, "OidbSvc.0x5eb_47 merge error " + paramFromServiceMsg.toString());
        localObject1 = paramToServiceMsg;
        bool1 = bool2;
        continue;
        bool1 = false;
        localObject1 = paramToServiceMsg;
        continue;
      }
      try
      {
        paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramArrayOfByte.rpt_msg_uin_data.get(0);
        paramToServiceMsg.uin = String.valueOf(paramFromServiceMsg.uint64_uin.get());
        paramToServiceMsg.pstn_c2c_vip = paramFromServiceMsg.uint32_pstn_c2c_vip.get();
        paramToServiceMsg.pstn_multi_vip = paramFromServiceMsg.uint32_pstn_multi_vip.get();
        paramToServiceMsg.pstn_c2c_try_status = paramFromServiceMsg.uint32_pstn_c2c_try_flag.get();
        paramToServiceMsg.pstn_multi_try_status = paramFromServiceMsg.uint32_pstn_multi_try_flag.get();
        paramToServiceMsg.pstn_ever_c2c_vip = paramFromServiceMsg.uint32_pstn_ever_c2c_vip.get();
        paramToServiceMsg.pstn_ever_multi_vip = paramFromServiceMsg.uint32_pstn_ever_multi_vip.get();
        paramToServiceMsg.pstn_c2c_call_time = paramFromServiceMsg.uint32_pstn_c2c_call_time.get();
        paramToServiceMsg.pstn_multi_call_time = paramFromServiceMsg.uint32_pstn_multi_call_time.get();
        paramToServiceMsg.pstn_c2c_last_guide_recharge_time = paramFromServiceMsg.uint32_pstn_c2c_last_guide_recharge_time.get();
        paramToServiceMsg.pstn_multi_last_guide_recharge_time = paramFromServiceMsg.uint32_pstn_multi_last_guide_recharge_time.get();
        if (paramToServiceMsg.pstn_ever_c2c_vip != 0) {
          paramToServiceMsg.pstn_c2c_try_status = 1;
        }
        if (paramToServiceMsg.pstn_ever_multi_vip != 0) {
          paramToServiceMsg.pstn_multi_try_status = 1;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool2 = bool3;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PstnHandler", 2, "OidbSvc.0x5eb_47,handleGetPstnCardInfo, " + paramToServiceMsg.toString());
        }
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          paramFromServiceMsg = (PstnManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.a(paramToServiceMsg);
          }
        }
        bool1 = true;
        localObject1 = paramToServiceMsg;
        super.a(60000, bool1, localObject1);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        bool2 = true;
        continue;
      }
      localObject1 = localObject3;
      bool1 = bool2;
      if (paramFromServiceMsg.uint32_result.has())
      {
        QLog.i("PstnHandler", 1, " === handleGetPstnCardInfo : result | " + paramFromServiceMsg.uint32_result.get());
        localObject1 = localObject3;
        bool1 = bool2;
      }
    }
  }
  
  protected Class a()
  {
    return PstnObserver.class;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    b();
    super.a(60002, true, new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("PstnHandler", 2, " req is null || res is null");
      }
    }
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
      if (QLog.isColorLevel()) {
        QLog.i("PstnHandler", 2, "onReceive: cmd=" + str);
      }
      if ("OidbSvc.0x5eb_47".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_75".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4f1_0".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
      if ("im_sso_sharp.sharp_cs_voip".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
    } while (!"SharpSvr.s2cpstncallback".equals(str));
    c(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnHandler", 1, "im_sso_sharp.sharp_cs_voip " + paramFromServiceMsg.isSuccess());
    }
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isCallTypeReq", false);
    String str1 = paramToServiceMsg.extraData.getString("phoneNum");
    String str2 = paramToServiceMsg.extraData.getString("selfPhoneNum");
    int n = paramToServiceMsg.extraData.getInt("uinType");
    String str3 = paramToServiceMsg.extraData.getString("peerUin");
    boolean bool2 = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel()) {
      QLog.e("PstnHandler", 2, "handleCallTypeRsp, isCalltypeReq=" + bool1 + ", isSuccess=" + bool2);
    }
    if (!bool1) {
      return;
    }
    Object localObject;
    if (bool2)
    {
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (QLog.isColorLevel()) {
        QLog.e("PstnHandler", 2, "handleCallTypeRsp, wupBuffer.length=" + paramFromServiceMsg.length);
      }
      if (paramFromServiceMsg.length >= 4)
      {
        paramToServiceMsg = new byte[paramFromServiceMsg.length - 4];
        PkgTools.a(paramToServiceMsg, 0, paramFromServiceMsg, 4, paramFromServiceMsg.length - 4);
        localObject = new hd_video_voip_2.RspBody();
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        ((hd_video_voip_2.RspBody)localObject).mergeFrom(paramToServiceMsg);
        if (!((hd_video_voip_2.RspBody)localObject).msg_voip_head.has()) {
          break label988;
        }
        l1 = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.uint64_uin.get();
        l2 = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.uint64_seq.get();
        i = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.uint32_cmd.get();
        i1 = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.uint32_error_no.get();
        l3 = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.uint32_term_type.get();
        paramToServiceMsg = ((hd_video_voip_2.RspBody)localObject).msg_voip_head.bytes_build_ver.get().toByteArray();
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          long l2;
          long l3;
          paramToServiceMsg = new String(paramToServiceMsg, "utf-8");
          if (QLog.isColorLevel()) {
            QLog.d("PstnHandler", 2, "handleCallTypeRsp, uin:" + l1 + ", msgSeq:" + l2 + ", cmdType:" + i + ", sharpErrorCode:" + i1 + ", terminalType:" + l3 + ", version:" + paramToServiceMsg);
          }
          if (i1 == 0)
          {
            m = 1;
            if (!((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.has()) {
              break label1034;
            }
            j = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint32_call_type.get();
            l1 = 0L;
            if (((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint64_call_id.has()) {
              l1 = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint64_call_id.get();
            }
            if (((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_id.has())
            {
              paramToServiceMsg = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_id.get().toByteArray();
              try
              {
                paramToServiceMsg = new String(paramToServiceMsg, "utf-8");
                if (!((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_prompt.has()) {
                  continue;
                }
                paramFromServiceMsg = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_prompt.get().toByteArray();
              }
              catch (Exception paramToServiceMsg)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("PstnHandler", 2, "handleCallTypeRsp, callbackId parse failed");
                }
              }
            }
            else
            {
              try
              {
                paramFromServiceMsg = new String(paramFromServiceMsg, "utf-8");
                if (!((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_phone.has()) {
                  continue;
                }
                paramArrayOfByte = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.bytes_call_phone.get().toByteArray();
              }
              catch (Exception paramFromServiceMsg)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("PstnHandler", 2, "handleCallTypeRsp, callbackPrompt parse failed");
                }
              }
            }
            try
            {
              paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
              if (!((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint32_ability.has()) {
                break label1028;
              }
              i = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint32_ability.get();
              if (!((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint32_call_phone_type.has()) {
                break label1013;
              }
              m = ((hd_video_voip_2.RspBody)localObject).msg_phone_bind_rsp_body.uint32_call_phone_type.get();
              k = j;
              j = i;
              i = k;
              localObject = UinUtils.a(l1);
              if (QLog.isColorLevel()) {
                QLog.d("PstnHandler", 2, "handleCallTypeRsp, callType:" + i + ", peerCallIdString:" + (String)localObject + ", peerCallId:" + l1 + ", callbackId:" + paramToServiceMsg + ", callbackPrompt:" + paramFromServiceMsg + ", callbackPhone:" + paramArrayOfByte + ", ability:" + j + ", phoneNumType:" + m);
              }
              if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int != -1) {
                continue;
              }
              a(str2, str1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), n, str3, paramToServiceMsg);
              return;
            }
            catch (Exception paramArrayOfByte)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("PstnHandler", 2, "handleCallTypeRsp, callbackPhone parse failed");
            }
            paramToServiceMsg = paramToServiceMsg;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("PstnHandler", 2, "im_sso_sharp.sharp_cs_voip merge error ", paramToServiceMsg);
          }
        }
        catch (Exception paramToServiceMsg)
        {
          int m;
          if (QLog.isColorLevel()) {
            QLog.e("PstnHandler", 2, "handleCallTypeRsp, version parse failed");
          }
          paramToServiceMsg = "";
          continue;
          paramToServiceMsg = null;
          continue;
          paramFromServiceMsg = null;
          continue;
          paramArrayOfByte = null;
          continue;
          paramToServiceMsg = new PstnHandler.CallTypeRspParam(i1, i, l1, paramToServiceMsg, paramFromServiceMsg, paramArrayOfByte, j, str1, m);
          PstnNumberManager.a(paramArrayOfByte, m);
          super.a(60004, true, paramToServiceMsg);
          return;
        }
      }
      super.a(60004, false, Integer.valueOf(i1));
      return;
      label988:
      if (QLog.isColorLevel()) {
        QLog.e("PstnHandler", 2, "handleCallTypeRsp, no handle return false");
      }
      super.a(60004, false, null);
      return;
      label1013:
      int k = i;
      int i = j;
      int j = k;
      continue;
      label1028:
      i = 0;
      continue;
      label1034:
      j = 0;
      paramArrayOfByte = null;
      paramFromServiceMsg = null;
      i = 0;
      long l1 = 0L;
      paramToServiceMsg = null;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.d("PstnHandler", 1, " sendGetPstnInfo uin is null ");
    }
    do
    {
      return;
      oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
      try
      {
        long l = Long.parseLong(paramString);
        if (QLog.isColorLevel()) {
          QLog.w("PstnHandler", 2, " === sendGetPstnCardInfor === uin:  " + paramString + " ====");
        }
        localReqBody.rpt_uint64_uins.add(Long.valueOf(l));
        localReqBody.uint32_req_pstn_c2c_vip.set(1);
        localReqBody.uint32_req_pstn_multi_vip.set(1);
        localReqBody.uint32_req_pstn_c2c_call_time.set(1);
        localReqBody.uint32_req_pstn_multi_call_time.set(1);
        localReqBody.uint32_req_pstn_c2c_try_flag.set(1);
        localReqBody.uint32_req_pstn_multi_try_flag.set(1);
        localReqBody.uint32_req_pstn_ever_c2c_vip.set(1);
        localReqBody.uint32_req_pstn_ever_multi_vip.set(1);
        localReqBody.uint32_req_pstn_c2c_last_guide_recharge_time.set(1);
        localReqBody.uint32_req_pstn_multi_last_guide_recharge_time.set(1);
        super.b(super.a("OidbSvc.0x5eb_47", 1515, 47, localReqBody.toByteArray()));
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.w("PstnHandler", 2, "send_query_pstn error", paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    long l1 = PstnUtils.a(paramString3);
    long l2 = PstnUtils.a(paramString4);
    Object localObject1 = new hd_video_voip_2.VoipHead();
    ((hd_video_voip_2.VoipHead)localObject1).uint64_uin.set(l1);
    Object localObject2 = ((hd_video_voip_2.VoipHead)localObject1).uint64_seq;
    int i = MobileQQService.jdField_a_of_type_Int;
    MobileQQService.jdField_a_of_type_Int = i + 1;
    ((PBUInt64Field)localObject2).set(i);
    ((hd_video_voip_2.VoipHead)localObject1).uint32_cmd.set(1);
    ((hd_video_voip_2.VoipHead)localObject1).bytes_build_ver.set(ByteStringMicro.copyFromUtf8("7.6.3"));
    ((hd_video_voip_2.VoipHead)localObject1).uint32_term_type.set(4);
    ((hd_video_voip_2.VoipHead)localObject1).int32_sub_service_type.set(7000);
    if (QLog.isColorLevel()) {
      QLog.d("PstnHandler", 2, "REQ_TYPE_PSTN_DOUBLE: toPhone=" + paramString2 + ", toUin=" + paramString4 + ", fromPhone=" + paramString1 + ", fromUin=" + paramString3 + ", uinType=" + paramInt + ", seq=" + MobileQQService.jdField_a_of_type_Int);
    }
    paramString3 = new hd_video_voip_2.TelInfo();
    Object localObject3 = PhoneNumberUtil.a(paramString1);
    paramString3.bytes_nation.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject3).a));
    paramString3.bytes_prefix.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject3).b));
    paramString3.bytes_mobile.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject3).c));
    paramString3.uint64_uin.set(l1);
    paramString3.uint64_uin_type.set(jdField_a_of_type_Int);
    localObject2 = new hd_video_voip_2.TelInfo();
    if (!TextUtils.isEmpty(paramString2))
    {
      PhoneNumberInfo localPhoneNumberInfo = PhoneNumberUtil.a(paramString2);
      if (!TextUtils.isEmpty(localPhoneNumberInfo.a))
      {
        ((hd_video_voip_2.TelInfo)localObject2).bytes_nation.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.a));
        if (!TextUtils.isEmpty(localPhoneNumberInfo.b)) {
          ((hd_video_voip_2.TelInfo)localObject2).bytes_prefix.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.b));
        }
        ((hd_video_voip_2.TelInfo)localObject2).bytes_mobile.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.c));
      }
    }
    else
    {
      ((hd_video_voip_2.TelInfo)localObject2).uint64_uin.set(l2);
      if (paramInt != 0) {
        break label679;
      }
      ((hd_video_voip_2.TelInfo)localObject2).uint64_uin_type.set(jdField_a_of_type_Int);
    }
    for (;;)
    {
      localObject3 = new hd_video_voip_2.CmdPhoneBindReqBody();
      ((hd_video_voip_2.CmdPhoneBindReqBody)localObject3).uint32_from_flag.set(1);
      ((hd_video_voip_2.CmdPhoneBindReqBody)localObject3).msg_from_tel.set(paramString3);
      ((hd_video_voip_2.CmdPhoneBindReqBody)localObject3).msg_to_tel.set((MessageMicro)localObject2);
      ((hd_video_voip_2.CmdPhoneBindReqBody)localObject3).uint32_call_policy.set(0);
      paramString3 = new hd_video_voip_2.BalanceAccount();
      paramString3.uint32_from_app.set(2);
      paramString3.uint32_account_type.set(1);
      localObject2 = new hd_video_voip_2.ReqBody();
      ((hd_video_voip_2.ReqBody)localObject2).msg_voip_head.set((MessageMicro)localObject1);
      ((hd_video_voip_2.ReqBody)localObject2).msg_phone_bind_req_body.set((MessageMicro)localObject3);
      ((hd_video_voip_2.ReqBody)localObject2).msg_bm.set(paramString3);
      localObject1 = ((hd_video_voip_2.ReqBody)localObject2).toByteArray();
      paramString3 = new byte[localObject1.length + 4];
      PkgTools.a(paramString3, 0, localObject1.length);
      PkgTools.a(paramString3, 4, (byte[])localObject1, localObject1.length);
      if (QLog.isDevelopLevel()) {
        QLog.d("PstnHandler", 4, "buff : " + StringUtil.b(new String(paramString3)));
      }
      localObject1 = super.a("im_sso_sharp.sharp_cs_voip");
      ((ToServiceMsg)localObject1).extraData.putBoolean("isCallTypeReq", true);
      ((ToServiceMsg)localObject1).extraData.putString("phoneNum", paramString2);
      ((ToServiceMsg)localObject1).extraData.putInt("uinType", paramInt);
      ((ToServiceMsg)localObject1).extraData.putString("peerUin", paramString4);
      ((ToServiceMsg)localObject1).extraData.putString("selfPhoneNum", paramString1);
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      ((ToServiceMsg)localObject1).putWupBuffer(paramString3);
      super.b((ToServiceMsg)localObject1);
      return;
      ((hd_video_voip_2.TelInfo)localObject2).bytes_nation.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject3).a));
      break;
      label679:
      ((hd_video_voip_2.TelInfo)localObject2).uint64_uin_type.set(d);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnHandler", 2, "CANCEL_CALLBACK_PSTN_DOUBLE: toPhone=" + paramString2 + ", toUin=" + paramString4 + ", fromPhone=" + paramString1 + ", fromUin=" + paramString3 + ", uinType=" + paramInt + ", callbackId=" + paramString5);
    }
    long l1 = PstnUtils.a(paramString3);
    long l2 = PstnUtils.a(paramString4);
    paramString3 = new hd_video_voip_2.VoipHead();
    paramString3.uint64_uin.set(l1);
    paramString4 = paramString3.uint64_seq;
    int i = MobileQQService.jdField_a_of_type_Int;
    MobileQQService.jdField_a_of_type_Int = i + 1;
    paramString4.set(i);
    paramString3.uint32_cmd.set(5);
    paramString3.bytes_build_ver.set(ByteStringMicro.copyFromUtf8("7.6.3"));
    paramString3.uint32_term_type.set(4);
    paramString4 = new hd_video_voip_2.TelInfo();
    Object localObject = PhoneNumberUtil.a(paramString1);
    paramString4.bytes_nation.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject).a));
    paramString4.bytes_prefix.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject).b));
    paramString4.bytes_mobile.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject).c));
    paramString3.uint64_uin.set(l1);
    paramString4.uint64_uin_type.set(jdField_a_of_type_Int);
    paramString1 = new hd_video_voip_2.TelInfo();
    if (!TextUtils.isEmpty(paramString2))
    {
      PhoneNumberInfo localPhoneNumberInfo = PhoneNumberUtil.a(paramString2);
      if (!TextUtils.isEmpty(localPhoneNumberInfo.a))
      {
        paramString1.bytes_nation.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.a));
        if (!TextUtils.isEmpty(localPhoneNumberInfo.b)) {
          paramString1.bytes_prefix.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.b));
        }
        paramString1.bytes_mobile.set(ByteStringMicro.copyFromUtf8(localPhoneNumberInfo.c));
      }
    }
    else
    {
      paramString1.uint64_uin.set(l2);
      if (paramInt != 0) {
        break label594;
      }
      paramString1.uint64_uin_type.set(jdField_a_of_type_Int);
    }
    for (;;)
    {
      localObject = new hd_video_voip_2.CmdPhoneCancelCallBackReqBody();
      ((hd_video_voip_2.CmdPhoneCancelCallBackReqBody)localObject).msg_from_tel.set(paramString4);
      ((hd_video_voip_2.CmdPhoneCancelCallBackReqBody)localObject).msg_to_tel.set(paramString1);
      if (!TextUtils.isEmpty(paramString5)) {
        ((hd_video_voip_2.CmdPhoneCancelCallBackReqBody)localObject).bytes_call_id.set(ByteStringMicro.copyFromUtf8(paramString5));
      }
      paramString1 = new hd_video_voip_2.BalanceAccount();
      paramString1.uint32_from_app.set(2);
      paramString1.uint32_account_type.set(1);
      paramString4 = new hd_video_voip_2.ReqBody();
      paramString4.msg_voip_head.set(paramString3);
      paramString4.msg_phone_cancel_callback_req_body.set((MessageMicro)localObject);
      paramString4.msg_bm.set(paramString1);
      paramString3 = paramString4.toByteArray();
      paramString1 = new byte[paramString3.length + 4];
      PkgTools.a(paramString1, 0, paramString3.length);
      PkgTools.a(paramString1, 4, paramString3, paramString3.length);
      if (QLog.isDevelopLevel()) {
        QLog.d("PstnHandler", 4, "buff : " + StringUtil.b(new String(paramString1)));
      }
      paramString3 = super.a("im_sso_sharp.sharp_cs_voip");
      paramString3.extraData.putString("phoneNum", paramString2);
      paramString3.putWupBuffer(paramString1);
      super.b(paramString3);
      return;
      paramString1.bytes_nation.set(ByteStringMicro.copyFromUtf8(((PhoneNumberInfo)localObject).a));
      break;
      label594:
      paramString1.uint64_uin_type.set(d);
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5eb_47");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_75");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4f1_0");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (PstnManager localPstnManager = (PstnManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);; localPstnManager = null)
    {
      long l;
      if (localPstnManager != null)
      {
        l = System.currentTimeMillis();
        if ((localPstnManager.jdField_a_of_type_Long == 0L) || (l / 1000L - localPstnManager.jdField_a_of_type_Long > localPstnManager.jdField_a_of_type_Int))
        {
          localObject = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
          if (localObject == null) {
            break label209;
          }
        }
      }
      label209:
      for (Object localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());; localObject = null)
      {
        if (localObject == null)
        {
          QLog.d("PstnHandler", 1, " get skey failed");
          return;
        }
        QLog.i("PstnHandler", 1, " === sendGetPstnSwitch === ");
        localPstnManager.jdField_a_of_type_Long = (l / 1000L);
        oidb_0x4f1.ReqBody localReqBody = new oidb_0x4f1.ReqBody();
        if (localPstnManager.a() != null) {
          localReqBody.bytes_cookies.set(localPstnManager.a());
        }
        localReqBody.bytes_skey.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
        super.b(super.a("OidbSvc.0x4f1_0", 1265, 0, localReqBody.toByteArray()));
        return;
        QLog.d("PstnHandler", 1, " req pstn gray flag time is too short");
        return;
        QLog.d("PstnHandler", 1, " req pstn gray flag pstnManager is null ");
        return;
      }
    }
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 8
    //   6: ldc 50
    //   8: iconst_1
    //   9: new 106	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 350
    //   19: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_2
    //   23: invokevirtual 193	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   26: invokevirtual 196	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_2
    //   36: invokevirtual 193	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   39: ifeq +299 -> 338
    //   42: new 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   45: dup
    //   46: invokespecial 84	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   49: astore_1
    //   50: aload_1
    //   51: aload_3
    //   52: invokevirtual 92	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   55: pop
    //   56: aload_1
    //   57: getfield 96	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   60: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   63: ifeq +233 -> 296
    //   66: aload_1
    //   67: getfield 96	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   70: invokevirtual 104	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   73: ifne +223 -> 296
    //   76: new 840	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody
    //   79: dup
    //   80: invokespecial 841	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:<init>	()V
    //   83: astore_3
    //   84: aload_3
    //   85: aload_1
    //   86: getfield 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   89: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   92: invokevirtual 137	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   95: invokevirtual 842	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: pop
    //   99: aload_3
    //   100: getfield 845	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:uint32_pstn_gray_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   103: invokevirtual 104	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   106: istore 4
    //   108: aload_3
    //   109: getfield 848	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:uint32_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 104	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   115: istore 5
    //   117: aload_3
    //   118: getfield 849	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:bytes_cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   124: astore_2
    //   125: aload_3
    //   126: getfield 852	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:uint32_c2c_trial_authority	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: invokevirtual 104	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   132: istore 6
    //   134: aload_3
    //   135: getfield 855	tencent/im/oidb/cmd0x4f1/oidb_0x4f1$RspBody:uint32_multi_trial_authority	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   138: invokevirtual 104	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   141: istore 7
    //   143: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +83 -> 229
    //   149: new 106	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 857
    //   159: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload 4
    //   164: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 859
    //   170: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload 5
    //   175: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: ldc_w 861
    //   181: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: astore_3
    //   185: aload_2
    //   186: ifnonnull +99 -> 285
    //   189: ldc_w 863
    //   192: astore_1
    //   193: ldc 50
    //   195: iconst_2
    //   196: aload_3
    //   197: aload_1
    //   198: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 865
    //   204: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: iload 6
    //   209: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc_w 867
    //   215: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload 7
    //   220: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 122	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: getfield 153	com/tencent/mobileqq/qcall/PstnHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   233: ifnull +34 -> 267
    //   236: aload_0
    //   237: getfield 153	com/tencent/mobileqq/qcall/PstnHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   240: sipush 142
    //   243: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   246: checkcast 303	com/tencent/mobileqq/qcall/PstnManager
    //   249: astore_1
    //   250: aload_1
    //   251: ifnull +16 -> 267
    //   254: aload_1
    //   255: iload 4
    //   257: iload 5
    //   259: aload_2
    //   260: iload 6
    //   262: iload 7
    //   264: invokevirtual 870	com/tencent/mobileqq/qcall/PstnManager:a	(IILcom/tencent/mobileqq/pb/ByteStringMicro;II)V
    //   267: iconst_1
    //   268: istore 8
    //   270: aload_0
    //   271: ldc_w 871
    //   274: iload 8
    //   276: iload 4
    //   278: invokestatic 540	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   281: invokespecial 177	com/tencent/mobileqq/app/BusinessHandler:a	(IZLjava/lang/Object;)V
    //   284: return
    //   285: aload_2
    //   286: invokevirtual 137	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   289: invokestatic 876	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   292: astore_1
    //   293: goto -100 -> 193
    //   296: aload_1
    //   297: getfield 96	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   300: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   303: ifeq +35 -> 338
    //   306: ldc 50
    //   308: iconst_1
    //   309: new 106	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 878
    //   319: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: getfield 96	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   326: invokevirtual 104	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   329: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 122	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: iconst_0
    //   339: istore 4
    //   341: goto -71 -> 270
    //   344: astore_1
    //   345: iconst_0
    //   346: istore 5
    //   348: iload 9
    //   350: istore 8
    //   352: iload 5
    //   354: istore 4
    //   356: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq -89 -> 270
    //   362: ldc 50
    //   364: iconst_2
    //   365: new 106	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 880
    //   375: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_1
    //   379: invokevirtual 312	java/lang/Exception:toString	()Ljava/lang/String;
    //   382: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: iload 9
    //   393: istore 8
    //   395: iload 5
    //   397: istore 4
    //   399: goto -129 -> 270
    //   402: astore_1
    //   403: iload 4
    //   405: istore 5
    //   407: goto -59 -> 348
    //   410: astore_1
    //   411: iconst_1
    //   412: istore 9
    //   414: iload 4
    //   416: istore 5
    //   418: goto -70 -> 348
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	PstnHandler
    //   0	421	1	paramToServiceMsg	ToServiceMsg
    //   0	421	2	paramFromServiceMsg	FromServiceMsg
    //   0	421	3	paramArrayOfByte	byte[]
    //   106	309	4	i	int
    //   115	302	5	j	int
    //   132	129	6	k	int
    //   141	122	7	m	int
    //   4	390	8	bool1	boolean
    //   1	412	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   42	108	344	java/lang/Exception
    //   296	338	344	java/lang/Exception
    //   108	143	402	java/lang/Exception
    //   143	185	410	java/lang/Exception
    //   193	229	410	java/lang/Exception
    //   229	250	410	java/lang/Exception
    //   254	267	410	java/lang/Exception
    //   285	293	410	java/lang/Exception
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PstnHandler", 2, "PSTNHandler receive pstn callback message ");
    }
    a(paramArrayOfByte);
    paramToServiceMsg = new hd_video.MsgBody();
    int i = paramArrayOfByte[0];
    try
    {
      j = paramArrayOfByte[(paramArrayOfByte.length - 1)];
      if ((i != 40) || (j != 41))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PstnHandler", 2, "PSTNHandler handleSharpPstnCallback invalid format");
        }
      }
      else
      {
        i = paramArrayOfByte[1] << 24 | paramArrayOfByte[2] << 16 | paramArrayOfByte[3] << 8 | paramArrayOfByte[4];
        j = paramArrayOfByte.length - i - 10;
        paramFromServiceMsg = new byte[j];
        System.arraycopy(paramArrayOfByte, i + 9, paramFromServiceMsg, 0, j);
        paramToServiceMsg = (hd_video.MsgBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        if ((paramToServiceMsg.msg_video_head.has()) && (((hd_video.VideoHead)paramToServiceMsg.msg_video_head.get()).enum_body_type.has()))
        {
          i = ((hd_video.VideoHead)paramToServiceMsg.msg_video_head.get()).enum_body_type.get();
          if (i == 22)
          {
            if (!paramToServiceMsg.msg_pstn_callback_notify_accept.has()) {
              return;
            }
            paramFromServiceMsg = paramToServiceMsg.msg_pstn_callback_notify_accept.bytes_call_id.get().toStringUtf8();
            i = paramToServiceMsg.msg_pstn_callback_notify_accept.uint32_accept_time.get();
            if (QLog.isColorLevel()) {
              QLog.d("PstnHandler", 2, "PSTNHandler handleSharpPstnCallback notify accept");
            }
            super.a(60006, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i) });
          }
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      int j;
      if (QLog.isColorLevel())
      {
        QLog.d("PstnHandler", 2, "PSTNHandler receive pstn callback exception", paramToServiceMsg);
        return;
        if ((i == 23) && (paramToServiceMsg.msg_pstn_callback_notify_logout.has()))
        {
          paramFromServiceMsg = paramToServiceMsg.msg_pstn_callback_notify_logout.bytes_call_id.get().toStringUtf8();
          i = paramToServiceMsg.msg_pstn_callback_notify_logout.uint32_call_time.get();
          j = paramToServiceMsg.msg_pstn_callback_notify_logout.uint32_call_status.get();
          if (QLog.isColorLevel()) {
            QLog.d("PstnHandler", 2, "PSTNHandler handleSharpPstnCallback notify logout, callId:" + paramFromServiceMsg + ", duration:" + i + ", status:" + j);
          }
          paramArrayOfByte = ((PstnManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142)).a(paramFromServiceMsg);
          BaseApplication localBaseApplication;
          int k;
          boolean bool;
          if (paramArrayOfByte != null)
          {
            localBaseApplication = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
            k = paramArrayOfByte.istroop;
            bool = paramArrayOfByte.isSend();
            if (i <= 0) {
              break label511;
            }
          }
          label511:
          for (paramToServiceMsg = UITools.a(i);; paramToServiceMsg = "0")
          {
            paramArrayOfByte.msg = TransfileUtile.a(VideoMsgTools.a(localBaseApplication, 59, k, bool, paramToServiceMsg), 59L, 3, false);
            VideoMsgTools.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte);
            super.a(60007, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.PstnHandler
 * JD-Core Version:    0.7.0.1
 */