package com.tencent.mobileqq.troop.troopsetting.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingHandler;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x91c.cmd0x91c.ReqBody;
import tencent.im.oidb.cmd0x91c.cmd0x91c.RspBody;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.MemberInfo;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.ReqBody;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.ReqGroupInfo;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.RspBody;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.RspGroupInfo;
import tencent.im.oidb.cmd0xf16.oidb_0xf16.GroupRemarkInfoReq;
import tencent.im.oidb.cmd0xf16.oidb_0xf16.GroupRemarkInfoRsp;
import tencent.im.oidb.cmd0xf16.oidb_0xf16.ReqBody;
import tencent.im.oidb.cmd0xf16.oidb_0xf16.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopSettingHandler
  extends TroopBaseHandler
  implements ITroopSettingHandler
{
  private ConcurrentHashMap<String, Long> a = new ConcurrentHashMap();
  
  public TroopSettingHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramToServiceMsg.extraData.getString("troopUin");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("troopRemark");
      Object localObject = new oidb_0xf16.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (i == 0)
      {
        paramFromServiceMsg = (oidb_0xf16.GroupRemarkInfoRsp)((oidb_0xf16.RspBody)localObject).msg_remark_info_rsp.get();
        if ((paramFromServiceMsg.uint64_group_code.has()) && (paramFromServiceMsg.int32_result.has()))
        {
          long l = paramFromServiceMsg.uint64_group_code.get();
          paramObject = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
          if ((TextUtils.equals(String.valueOf(l), str)) && (paramObject != null) && (paramFromServiceMsg.int32_result.get() == 0))
          {
            localObject = paramObject.getTroopInfo(str);
            if (localObject != null)
            {
              ((TroopInfo)localObject).troopRemark = paramToServiceMsg;
              paramObject.saveTroopInfo((TroopInfo)localObject);
            }
          }
          else if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleModifyTroopRemarkResp_0xf16 failed int32_result: ");
            paramToServiceMsg.append(paramFromServiceMsg.int32_result.get());
            QLog.i("TroopSettingHandler", 2, paramToServiceMsg.toString());
          }
          notifyUI(TroopSettingObserver.a, true, new Object[] { str, Integer.valueOf(paramFromServiceMsg.int32_result.get()) });
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleModifyTroopRemarkResp_0xf16 failed result: ");
        paramToServiceMsg.append(i);
        QLog.i("TroopSettingHandler", 2, paramToServiceMsg.toString());
      }
      notifyUI(TroopSettingObserver.a, false, new Object[] { str, Integer.valueOf(0) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingHandler", 2, "handleModifyTroopRemarkResp_0xf16 req == null || res == null");
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(TroopSettingObserver.b, false, null);
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0.0F) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramFromServiceMsg = new cmd0x91c.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          notifyUI(TroopSettingObserver.b, true, new Object[] { String.valueOf(paramFromServiceMsg.uint64_group_code.get()), Integer.valueOf(paramFromServiceMsg.uint64_application_submit_time.get()) });
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          notifyUI(TroopSettingObserver.b, false, null);
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("oidb_91c error : ");
            paramFromServiceMsg.append(paramToServiceMsg.toString());
            QLog.e("TroopSettingHandler", 2, paramFromServiceMsg.toString());
          }
          return;
        }
      }
      notifyUI(TroopSettingObserver.b, false, null);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label225:
      break label225;
    }
    notifyUI(TroopSettingObserver.b, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("memberUin");
    int j = paramToServiceMsg.extraData.getInt("cmd");
    int k = paramToServiceMsg.extraData.getInt("type", 0);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle_oidb_0xa80_0:");
      paramToServiceMsg.append(str1);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append(str2);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append(j);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      paramToServiceMsg.append(" type=");
      paramToServiceMsg.append(k);
      QLog.d(".troop.closeRcvMsgTmp", 2, paramToServiceMsg.toString());
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      notifyUI(TroopSettingObserver.c, false, new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(k) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    for (;;)
    {
      boolean bool;
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        i = -1;
        if (paramToServiceMsg.uint32_result.has()) {
          i = paramToServiceMsg.uint32_result.get();
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("sso result:");
          paramFromServiceMsg.append(i);
          QLog.d(".troop.closeRcvMsgTmp", 2, paramFromServiceMsg.toString());
        }
        if (i != 0)
        {
          notifyUI(TroopSettingObserver.c, false, new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(k) });
          return;
        }
        paramFromServiceMsg = new oidb_cmd0xa80.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramToServiceMsg = paramFromServiceMsg.rpt_msg_rsp_group_info.get();
          if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
            break label812;
          }
          paramToServiceMsg = (oidb_cmd0xa80.RspGroupInfo)paramToServiceMsg.get(0);
          int m = paramToServiceMsg.uint32_result.get();
          long l = paramToServiceMsg.uint64_group_code.get();
          paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
          if (!QLog.isColorLevel()) {
            break label812;
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("ret=");
          paramFromServiceMsg.append(m);
          paramFromServiceMsg.append(",");
          paramFromServiceMsg.append(l);
          paramFromServiceMsg.append(",");
          paramFromServiceMsg.append(paramToServiceMsg);
          QLog.d(".troop.closeRcvMsgTmp", 2, paramFromServiceMsg.toString());
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handle_oidb_0xa80_0:");
          paramFromServiceMsg.append(paramToServiceMsg.toString());
          QLog.d(".troop.closeRcvMsgTmp", 2, paramFromServiceMsg.toString());
          notifyUI(TroopSettingObserver.c, false, new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(k) });
          return;
        }
        paramObject = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
        paramFromServiceMsg = paramObject.getTroopInfo(String.valueOf(str1));
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg != null) {
          break label830;
        }
        paramToServiceMsg = new TroopInfo();
        paramToServiceMsg.troopuin = str1;
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handle_oidb_0xa80_0, pkg.mergeFrom:");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.e(".troop.closeRcvMsgTmp", 2, paramFromServiceMsg.toString());
        notifyUI(TroopSettingObserver.c, false, new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(k) });
        return;
      }
      paramToServiceMsg.setCmdUinFlagEx2(bool, k);
      paramObject.saveTroopInfo(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("TroopSettingHandler", 2, new Object[] { "handle_oidb_0xa80_0: invoked. GroupResp", " info: ", paramToServiceMsg, " type: ", Integer.valueOf(k), " troopUin: ", str1, " info.troopname: ", paramToServiceMsg.troopname });
      }
      if (i == 0)
      {
        notifyUI(TroopSettingObserver.c, true, new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(k) });
        return;
      }
      label812:
      if (k != 0) {
        if (k == 9)
        {
          continue;
          label830:
          if (j == 1) {
            bool = true;
          } else {
            bool = false;
          }
        }
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = paramObject;
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
      {
        int i = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleOidb0x4ff_86Rsp ret=");
          paramObject.append(i);
          QLog.i("TroopSettingHandler", 2, paramObject.toString());
        }
        if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
          if (4 <= paramFromServiceMsg.length)
          {
            paramFromServiceMsg = String.valueOf(PkgTools.getLongData(paramFromServiceMsg, 0));
            if ((TextUtils.isEmpty(paramFromServiceMsg)) || (!paramFromServiceMsg.equals(this.appRuntime.getAccount())))
            {
              if (!QLog.isColorLevel()) {
                break label203;
              }
              QLog.w("Q.dating", 2, "handleOidb0x4ff_86Rsp uin error");
              break label203;
            }
          }
          bool = true;
          break label206;
        }
      }
    }
    label203:
    boolean bool = false;
    label206:
    notifyUI(TroopSettingObserver.d, bool, new Object[] { Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("switch", false)) });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    int k;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
      {
        k = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleAutoAgreeInvite2GroupIn50Flag ret=");
          paramFromServiceMsg.append(k);
          QLog.i("TroopSettingHandler", 2, paramFromServiceMsg.toString());
        }
        if ((k != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramFromServiceMsg = new oidb_0x5eb.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        if (paramFromServiceMsg.rpt_msg_uin_data.has())
        {
          paramToServiceMsg = paramFromServiceMsg.rpt_msg_uin_data.get().iterator();
          bool2 = false;
          i = 1;
          bool1 = bool2;
          j = i;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        boolean bool2;
        int i;
        boolean bool1;
        int j;
        label250:
        continue;
      }
      try
      {
        if (!paramToServiceMsg.hasNext()) {
          continue;
        }
        paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramToServiceMsg.next();
        if (paramFromServiceMsg.uint32_req_invite2group_auto_agree_flag.has())
        {
          j = paramFromServiceMsg.uint32_req_invite2group_auto_agree_flag.get();
          i = j;
          bool2 = true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
    }
    break label250;
    i = 1;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleAutoAgreeInvite2GroupIn50Flag ret=");
      paramToServiceMsg.append(k);
      QLog.i("TroopSettingHandler", 2, paramToServiceMsg.toString());
    }
    bool1 = false;
    j = i;
    break label305;
    bool1 = false;
    j = 1;
    label305:
    i = TroopSettingObserver.e;
    if (j == 0) {
      bool2 = bool3;
    } else {
      bool2 = false;
    }
    notifyUI(i, bool1, new Object[] { Boolean.valueOf(bool2) });
  }
  
  protected String a()
  {
    return "TroopSettingHandler";
  }
  
  public void a()
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    long l = Long.parseLong(this.appRuntime.getCurrentAccountUin());
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_invite2group_auto_agree_flag.set(1);
    localObject = makeOIDBPkg("OidbSvc.0x5eb_94", 1515, 94, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("OidbSvc.0x5eb_94", true);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString)
  {
    Object localObject = new cmd0x91c.ReqBody();
    ((cmd0x91c.ReqBody)localObject).uint64_group_code.set(Long.valueOf(paramString).longValue());
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2332);
    paramString.uint32_service_type.set(1);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x91c.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x91c_1");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send_oidb_0xa80_0:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d(".troop.closeRcvMsgTmp", 2, ((StringBuilder)localObject1).toString());
    }
    long l1;
    if (paramInt1 == 1)
    {
      this.a.remove(paramString1);
    }
    else if (paramInt1 == 0)
    {
      l1 = System.currentTimeMillis();
      if ((this.a.containsKey(paramString1)) && (l1 - ((Long)this.a.get(paramString1)).longValue() < 15000L))
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.closeRcvMsgTmp", 2, "send 0xa80cmd==0 less 15s");
        }
        return;
      }
      this.a.put(paramString1, Long.valueOf(l1));
    }
    try
    {
      l1 = Long.parseLong(paramString2);
      long l2 = Long.parseLong(paramString1);
      Object localObject2 = new oidb_cmd0xa80.MemberInfo();
      ((oidb_cmd0xa80.MemberInfo)localObject2).uint64_member_uin.set(l1);
      if (paramInt2 == 0) {
        ((oidb_cmd0xa80.MemberInfo)localObject2).uint32_heartbeat_time.set((int)(System.currentTimeMillis() / 1000L));
      } else {
        ((oidb_cmd0xa80.MemberInfo)localObject2).uint64_group_msg_mask.set(paramInt2);
      }
      localObject1 = new oidb_cmd0xa80.ReqGroupInfo();
      ((oidb_cmd0xa80.ReqGroupInfo)localObject1).rpt_msg_member_info.add((MessageMicro)localObject2);
      ((oidb_cmd0xa80.ReqGroupInfo)localObject1).uint64_group_code.set(l2);
      ((oidb_cmd0xa80.ReqGroupInfo)localObject1).uint32_op.set(paramInt1);
      localObject2 = new oidb_cmd0xa80.ReqBody();
      ((oidb_cmd0xa80.ReqBody)localObject2).rpt_msg_req_group_info.add((MessageMicro)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2688);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xa80.ReqBody)localObject2).toByteArray()));
      localObject2 = createToServiceMsg("OidbSvc.0xa80_0");
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putString("troopUin", paramString1);
      ((ToServiceMsg)localObject2).extraData.putString("memberUin", paramString2);
      ((ToServiceMsg)localObject2).extraData.putInt("cmd", paramInt1);
      sendPbReq((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("send_oidb_0xa80_0:");
        paramString2.append(paramString1.toString());
        QLog.e(".troop.closeRcvMsgTmp", 2, paramString2.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send_oidb_0xa80:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" type=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(" time=");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append(" op=");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d(".troop.closeRcvMsgTmp", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      long l1 = Long.parseLong(paramString2);
      long l2 = Long.parseLong(paramString1);
      Object localObject2 = new oidb_cmd0xa80.MemberInfo();
      ((oidb_cmd0xa80.MemberInfo)localObject2).uint64_member_uin.set(l1);
      if (paramInt2 == 512) {
        ((oidb_cmd0xa80.MemberInfo)localObject2).uint32_group_msg_hide_switch.set(paramInt3);
      } else if (paramInt2 == 1024) {
        ((oidb_cmd0xa80.MemberInfo)localObject2).uint32_group_msg_preview_switch.set(paramInt3);
      } else if (paramInt2 == 2048) {
        ((oidb_cmd0xa80.MemberInfo)localObject2).uint32_group_ringtone_switch.set(paramInt3);
      } else if (paramInt2 == 4096) {
        ((oidb_cmd0xa80.MemberInfo)localObject2).uint32_group_vibrate_switch.set(paramInt3);
      } else if (paramInt2 == 9) {
        ((oidb_cmd0xa80.MemberInfo)localObject2).uint32_group_ringtone_id.set(paramInt3);
      }
      localObject1 = new oidb_cmd0xa80.ReqGroupInfo();
      ((oidb_cmd0xa80.ReqGroupInfo)localObject1).rpt_msg_member_info.add((MessageMicro)localObject2);
      ((oidb_cmd0xa80.ReqGroupInfo)localObject1).uint64_group_code.set(l2);
      ((oidb_cmd0xa80.ReqGroupInfo)localObject1).uint32_op.set(paramInt1);
      ((oidb_cmd0xa80.ReqGroupInfo)localObject1).uint32_client_type.set(1);
      localObject2 = new oidb_cmd0xa80.ReqBody();
      ((oidb_cmd0xa80.ReqBody)localObject2).rpt_msg_req_group_info.add((MessageMicro)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2688);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(4);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xa80.ReqBody)localObject2).toByteArray()));
      localObject2 = createToServiceMsg("OidbSvc.0xa80_0");
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putString("troopUin", paramString1);
      ((ToServiceMsg)localObject2).extraData.putString("memberUin", paramString2);
      ((ToServiceMsg)localObject2).extraData.putInt("cmd", paramInt1);
      ((ToServiceMsg)localObject2).extraData.putInt("type", paramInt2);
      sendPbReq((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("send_oidb_0xa80:");
        paramString2.append(paramString1.toString());
        QLog.e(".troop.closeRcvMsgTmp", 2, paramString2.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramString3 == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("modifyTroopRemarkBy0xf16 troopCode=");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("troopUin");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("troopRemark");
        ((StringBuilder)localObject).append(paramString3);
        QLog.d("TroopSettingHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new oidb_0xf16.ReqBody();
      oidb_0xf16.GroupRemarkInfoReq localGroupRemarkInfoReq = new oidb_0xf16.GroupRemarkInfoReq();
      localGroupRemarkInfoReq.bytes_remark_name.set(ByteStringMicro.copyFromUtf8(paramString3));
      try
      {
        localGroupRemarkInfoReq.uint64_group_uin.set(Long.parseLong(paramString1));
        localGroupRemarkInfoReq.uint64_group_code.set(Long.parseLong(paramString2));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("modifyTroopRemarkBy0xf16 NumberFormatException TroopCode=");
          localStringBuilder.append(paramString1);
          localStringBuilder.append("TroopUin");
          localStringBuilder.append(paramString2);
          QLog.e("TroopSettingHandler", 1, localStringBuilder.toString());
        }
      }
      ((oidb_0xf16.ReqBody)localObject).msg_remark_info_req.set(localGroupRemarkInfoReq);
      paramString1 = makeOIDBPkg("OidbSvc.0xf16_1", 3862, 1, ((oidb_0xf16.ReqBody)localObject).toByteArray());
      paramString1.extraData.putString("troopUin", paramString2);
      paramString1.extraData.putString("troopRemark", paramString3);
      sendPbReq(paramString1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = ByteBuffer.allocate(13);
    ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong(this.appRuntime.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort((short)-25190).putShort((short)2).putShort(paramBoolean ^ true);
    localObject = makeOIDBPkg("OidbSvc.0x4ff_86", 1279, 86, ((ByteBuffer)localObject).array());
    ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xf16_1");
      this.allowCmdSet.add("OidbSvc.0x91c_1");
      this.allowCmdSet.add("OidbSvc.0xa80_0");
      this.allowCmdSet.add("OidbSvc.0x4ff_86");
      this.allowCmdSet.add("OidbSvc.0x5eb_94");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopSettingObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("TroopSettingHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopSettingHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0xf16_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x91c_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa80_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_86".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_94".equals(paramFromServiceMsg.getServiceCmd())) {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.api.impl.TroopSettingHandler
 * JD-Core Version:    0.7.0.1
 */