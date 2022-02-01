package com.tencent.mobileqq.troop.troopmanager.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.TroopManagerBizHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopModifyHandler;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver.EditTroopLocationRet;
import com.tencent.mobileqq.troop.troopshare.TroopShareResp;
import com.tencent.mobileqq.util.Utils;
import com.tencent.protofile.join_group_link.join_group_link.ReqBody;
import com.tencent.protofile.join_group_link.join_group_link.RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.NewIntent;
import tencent.im.cs.modifyexamine.modifyexamine.ReqBody;
import tencent.im.cs.modifyexamine.modifyexamine.RspBody;
import tencent.im.kqq.profilesvr.GroupLocation.SetGroupLocationReq;
import tencent.im.kqq.profilesvr.GroupLocation.SetGroupLocationRes;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupCardPrefix;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.cmd0x903.cmd0x903.ReqBody;
import tencent.im.oidb.cmd0x903.cmd0x903.RspBody;
import tencent.im.oidb.cmd0x903.cmd0x903.SubCmd0x2Req;
import tencent.im.oidb.cmd0x903.cmd0x903.SubCmd0x2Rsp;
import tencent.im.oidb.oidb_0xc6c.GroupInfo;
import tencent.im.oidb.oidb_0xc6c.ReqBody;
import tencent.im.oidb.oidb_0xc6c.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopManagerBizHandler
  extends TroopBaseHandler
  implements ITroopManagerBizHandler
{
  public TroopManagerBizHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private TroopInfo a(long paramLong, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    Object localObject2 = localITroopInfoService.findTroopInfo(String.valueOf(paramLong));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TroopInfo();
      ((TroopInfo)localObject1).troopuin = String.valueOf(paramLong);
    }
    if (paramGroupInfo.uint32_group_create_time.has())
    {
      ((TroopInfo)localObject1).troopCreateTime = paramGroupInfo.uint32_group_create_time.get();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handle_oidb_0x88d_0|troopCreateTime ");
        ((StringBuilder)localObject2).append(((TroopInfo)localObject1).troopCreateTime);
        QLog.d("TroopManagerBizHandler", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if (paramGroupInfo.uint32_group_member_num.has())
    {
      ((TroopInfo)localObject1).wMemberNum = paramGroupInfo.uint32_group_member_num.get();
      ((TroopInfo)localObject1).wMemberNumClient = ((TroopInfo)localObject1).wMemberNum;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handle_oidb_0x88d_0|wMemberNumClient/wMemberNum:");
        ((StringBuilder)localObject2).append(((TroopInfo)localObject1).wMemberNum);
        ((StringBuilder)localObject2).append(" troopUin:");
        ((StringBuilder)localObject2).append(((TroopInfo)localObject1).troopuin);
        QLog.d("TroopManagerBizHandler", 2, ((StringBuilder)localObject2).toString());
      }
    }
    if (paramGroupInfo.string_group_question.has()) {
      ((TroopInfo)localObject1).joinTroopQuestion = paramGroupInfo.string_group_question.get().toStringUtf8();
    }
    if (paramGroupInfo.string_group_answer.has()) {
      ((TroopInfo)localObject1).joinTroopAnswer = paramGroupInfo.string_group_answer.get().toStringUtf8();
    }
    if (paramGroupInfo.uint32_group_flag_ext.has()) {
      ((TroopInfo)localObject1).dwGroupFlagExt = paramGroupInfo.uint32_group_flag_ext.get();
    }
    if (paramGroupInfo.uint32_group_type_flag.has()) {
      ((TroopInfo)localObject1).troopTypeExt = paramGroupInfo.uint32_group_type_flag.get();
    }
    if (paramGroupInfo.uint32_app_privilege_flag.has())
    {
      ((TroopInfo)localObject1).dwAppPrivilegeFlag = paramGroupInfo.uint32_app_privilege_flag.get();
      ((TroopInfo)localObject1).troopPrivilegeFlag = paramGroupInfo.uint32_app_privilege_flag.get();
    }
    if (paramGroupInfo.uint32_group_option.has()) {
      ((TroopInfo)localObject1).cGroupOption = ((short)paramGroupInfo.uint32_group_option.get());
    }
    if (paramGroupInfo.uint64_group_owner.has())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramGroupInfo.uint64_group_owner.get());
      ((TroopInfo)localObject1).troopowneruin = ((StringBuilder)localObject2).toString();
    }
    if (((TroopInfo)localObject1).isNewTroop()) {
      ((TroopInfo)localObject1).maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_conf_group.get();
    } else {
      ((TroopInfo)localObject1).maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_normal_group.get();
    }
    localITroopInfoService.saveTroopInfo((TroopInfo)localObject1);
    return localObject1;
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    TroopManagerBizObserver.EditTroopLocationRet localEditTroopLocationRet = new TroopManagerBizObserver.EditTroopLocationRet();
    localEditTroopLocationRet.c = paramIntent.getLongExtra("TroopUin", 0L);
    boolean bool2 = false;
    localEditTroopLocationRet.d = paramIntent.getBooleanExtra("isClear", false);
    localEditTroopLocationRet.e = paramIntent.getIntExtra("lat", 0);
    localEditTroopLocationRet.f = paramIntent.getIntExtra("lon", 0);
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      paramIntent = new GroupLocation.SetGroupLocationRes();
      paramIntent.mergeFrom(paramArrayOfByte);
      localEditTroopLocationRet.a = paramIntent.result.get();
      bool1 = bool2;
      if (localEditTroopLocationRet.a != 0) {
        break label220;
      }
      localEditTroopLocationRet.b = paramIntent.grouplocation.get();
      paramIntent = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
      if (paramIntent != null)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("");
        paramFromServiceMsg.append(localEditTroopLocationRet.c);
        paramFromServiceMsg = paramIntent.findTroopInfo(paramFromServiceMsg.toString());
        paramFromServiceMsg.strLocation = localEditTroopLocationRet.b;
        paramIntent.saveTroopInfo(paramFromServiceMsg);
      }
      bool1 = true;
    }
    catch (Exception paramIntent)
    {
      boolean bool1;
      label194:
      label220:
      break label194;
    }
    localEditTroopLocationRet.a = -1;
    bool1 = bool2;
    break label220;
    localEditTroopLocationRet.a = paramFromServiceMsg.getResultCode();
    bool1 = bool2;
    notifyUI(TroopManagerBizObserver.TYPE_EDIT_TROOP_LOCATION, bool1, localEditTroopLocationRet);
  }
  
  private void a(String paramString, oidb_0x88d.GroupInfo paramGroupInfo, Bundle paramBundle)
  {
    if (paramGroupInfo == null) {
      return;
    }
    String str1 = paramBundle.getString("inviteUin");
    int k = paramBundle.getInt("from");
    String str2 = paramBundle.getString("fromUin");
    boolean bool2 = paramBundle.getBoolean("isFromReqSystemMsgNew");
    TroopInfo localTroopInfo2 = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    int i = 0;
    boolean bool1;
    if (localTroopInfo2 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    TroopInfo localTroopInfo1 = localTroopInfo2;
    if (localTroopInfo2 == null)
    {
      localTroopInfo1 = new TroopInfo();
      localTroopInfo1.troopuin = paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.joinSplitMsg", 2, "handleGetTroopSeqAndJoinTime");
    }
    if (paramGroupInfo.uint32_group_class_ext.has()) {
      localTroopInfo1.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
    }
    int j;
    long l;
    if (!bool2)
    {
      localTroopInfo1.dwCmdUinJoinTime = paramGroupInfo.uint32_cmduin_join_time.get();
      j = paramBundle.getInt("joinTroopSeq", 0);
      l = paramBundle.getLong("joinTroopTime", 0L);
    }
    else
    {
      l = 0L;
      if (paramGroupInfo.uint32_cmduin_join_real_msg_seq.has()) {
        i = paramGroupInfo.uint32_cmduin_join_real_msg_seq.get();
      }
      j = i;
      if (paramGroupInfo.uint32_cmduin_join_time.has())
      {
        l = paramGroupInfo.uint32_cmduin_join_time.get();
        j = i;
      }
    }
    if (QLog.isColorLevel())
    {
      paramGroupInfo = new StringBuilder();
      paramGroupInfo.append("handleGetTroopSeqAndJoinTime troopuin = ");
      paramGroupInfo.append(paramString);
      paramGroupInfo.append(" isMember=");
      paramGroupInfo.append(bool1);
      paramGroupInfo.append(" joinTroopTime=");
      paramGroupInfo.append(l);
      paramGroupInfo.append(" joinTroopSeq = ");
      paramGroupInfo.append(j);
      paramGroupInfo.append("isFromReqSystemMsgNew ");
      paramGroupInfo.append(bool2);
      QLog.d("GrayTipsForTroop", 2, paramGroupInfo.toString());
    }
    TroopManagerBizHandlerProcessorConfig.a().a(this.appRuntime, localTroopInfo1, paramString, str1, str2, j, l, k, true);
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    int i = paramGroupInfo.uint32_app_privilege_flag.get();
    float f;
    if ((paramGroupInfo.st_group_ex_info.has()) && (paramGroupInfo.st_group_ex_info.uint32_money_for_add_group.has())) {
      f = paramGroupInfo.st_group_ex_info.uint32_money_for_add_group.get() * 0.01F;
    } else {
      f = 0.0F;
    }
    boolean bool1;
    if ((i & 0x80) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((i & 0x200) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = localITroopInfoService.findTroopInfo(paramString1);
    paramGroupInfo = localTroopInfo;
    if (localTroopInfo == null)
    {
      paramGroupInfo = new TroopInfo();
      paramGroupInfo.troopuin = paramString1;
    }
    long l = i;
    paramGroupInfo.troopPrivilegeFlag = l;
    paramGroupInfo.dwAppPrivilegeFlag = l;
    paramGroupInfo.mTroopNeedPayNumber = f;
    localITroopInfoService.saveTroopInfo(paramGroupInfo);
    notifyUI(TroopManagerBizObserver.TYPE_GET_PAY_TO_JOIN_TROOP_STATUS, paramBoolean, new Object[] { paramGroupInfo.troopuin, Boolean.valueOf(paramGroupInfo.isAdmin()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramString2 });
  }
  
  private void b(long paramLong)
  {
    TroopManagerBizHandler.4 local4 = new TroopManagerBizHandler.4(this, paramLong);
    this.appRuntime.addDefaultObservers(local4);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      str = paramToServiceMsg.extraData.getString("troopUin");
      paramToServiceMsg = new Object[2];
      paramToServiceMsg[0] = str;
      paramToServiceMsg[1] = Integer.valueOf(-1);
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(TroopManagerBizObserver.TYPE_GET_TROOP_MEMBER_MAX_NUM, false, paramToServiceMsg);
        return;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null)) {
        paramObject = new oidb_0x88d.RspBody();
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label285:
      break label305;
    }
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = paramObject.stzrspgroupinfo.get();
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
        int i = paramFromServiceMsg.uint32_result.get();
        if (i == 0)
        {
          int j = ((oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get()).uint32_group_member_max_num.get();
          notifyUI(TroopManagerBizObserver.TYPE_GET_TROOP_MEMBER_MAX_NUM, true, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
          return;
        }
        notifyUI(TroopManagerBizObserver.TYPE_GET_TROOP_MEMBER_MAX_NUM, false, new Object[] { str, Integer.valueOf(i) });
        return;
      }
      notifyUI(TroopManagerBizObserver.TYPE_GET_TROOP_MEMBER_MAX_NUM, false, paramToServiceMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label285;
    }
    notifyUI(TroopManagerBizObserver.TYPE_GET_TROOP_MEMBER_MAX_NUM, false, paramToServiceMsg);
    return;
    notifyUI(TroopManagerBizObserver.TYPE_GET_TROOP_MEMBER_MAX_NUM, false, paramToServiceMsg);
    return;
    label305:
    notifyUI(TroopManagerBizObserver.TYPE_GET_TROOP_MEMBER_MAX_NUM, false, paramToServiceMsg);
  }
  
  private void b(String paramString, Bundle paramBundle)
  {
    paramString = new TroopManagerBizHandler.8(this, paramString, paramBundle);
    this.appRuntime.addDefaultObservers(paramString);
  }
  
  private void c(long paramLong)
  {
    TroopManagerBizHandler.5 local5 = new TroopManagerBizHandler.5(this, paramLong);
    this.appRuntime.addDefaultObservers(local5);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("isAllowAnonymousChat", false);
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        if (paramToServiceMsg.uint32_result.get() != 0)
        {
          notifyUI(TroopManagerBizObserver.TYPE_ANONYMOUS_CHAT_SET_RESULT, false, Boolean.valueOf(bool));
          return;
        }
        notifyUI(TroopManagerBizObserver.TYPE_ANONYMOUS_CHAT_SET_RESULT, true, Boolean.valueOf(bool));
        return;
      }
      notifyUI(TroopManagerBizObserver.TYPE_ANONYMOUS_CHAT_SET_RESULT, false, Boolean.valueOf(bool));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label139:
      break label139;
    }
    notifyUI(TroopManagerBizObserver.TYPE_ANONYMOUS_CHAT_SET_RESULT, false, Boolean.valueOf(bool));
    return;
    notifyUI(TroopManagerBizObserver.TYPE_ANONYMOUS_CHAT_SET_RESULT, false, Boolean.valueOf(bool));
  }
  
  private void c(String paramString1, String paramString2)
  {
    paramString1 = new TroopManagerBizHandler.2(this, paramString1, paramString2);
    this.appRuntime.addDefaultObservers(paramString1);
  }
  
  private void d(long paramLong)
  {
    TroopManagerBizHandler.6 local6 = new TroopManagerBizHandler.6(this, paramLong);
    this.appRuntime.addDefaultObservers(local6);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(TroopManagerBizObserver.TYPE_TROOP_GET_MODIFY_EXAMINE, false, null);
      return;
    }
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramToServiceMsg = (byte[])paramObject;
      paramFromServiceMsg = new modifyexamine.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        boolean bool = paramFromServiceMsg.uint32_result.has();
        long l3 = -1L;
        long l1;
        if (bool) {
          l1 = paramFromServiceMsg.uint32_result.get();
        } else {
          l1 = -1L;
        }
        long l2;
        if (paramFromServiceMsg.uint32_limit_times.has()) {
          l2 = paramFromServiceMsg.uint32_limit_times.get();
        } else {
          l2 = -1L;
        }
        if (paramFromServiceMsg.uint32_modify_times.has()) {
          l3 = paramFromServiceMsg.uint32_modify_times.get();
        }
        if (paramFromServiceMsg.str_errmsg.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_errmsg.get();
        } else {
          paramToServiceMsg = "";
        }
        notifyUI(TroopManagerBizObserver.TYPE_TROOP_GET_MODIFY_EXAMINE, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), paramToServiceMsg });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopManagerBizHandler", 4, "onRspResend parsing error");
        }
        return;
      }
    }
    notifyUI(TroopManagerBizObserver.TYPE_TROOP_GET_MODIFY_EXAMINE, false, null);
  }
  
  private void d(String paramString)
  {
    paramString = new TroopManagerBizHandler.1(this, paramString);
    this.appRuntime.addDefaultObservers(paramString);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (paramToServiceMsg.extraData == null) {
        paramToServiceMsg = "";
      } else {
        paramToServiceMsg = paramToServiceMsg.extraData.getString("troop_uin");
      }
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xc6c.RspBody());
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleActiveExtTroop result code is: ");
      paramFromServiceMsg.append(i);
      QLog.i("troop_ext", 1, paramFromServiceMsg.toString());
      if (i == 0) {
        notifyUI(TroopManagerBizObserver.TYPE_NOTIFY_ACTIVE_EXT_TROOP_SUCCESS, true, new Object[] { paramToServiceMsg });
      }
      return;
    }
    QLog.i("troop_ext", 1, "handleActiveExtTroop req or resp is null.");
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(TroopManagerBizObserver.TYPE_OIDB_0X903_2, false, null);
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramFromServiceMsg = new cmd0x903.RspBody();
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label259:
      break label279;
    }
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (!paramFromServiceMsg.opt_msg_get_invited_uin_list_rsp.has()) {
        break label268;
      }
      new cmd0x903.SubCmd0x2Rsp();
      paramFromServiceMsg = (cmd0x903.SubCmd0x2Rsp)paramFromServiceMsg.opt_msg_get_invited_uin_list_rsp.get();
      paramToServiceMsg = Long.valueOf(paramFromServiceMsg.opt_uint64_group_code.get());
      paramObject = paramFromServiceMsg.rpt_uint64_uin.get();
      notifyUI(TroopManagerBizObserver.TYPE_OIDB_0X903_2, true, new Object[] { paramToServiceMsg, paramObject });
      if (!QLog.isColorLevel()) {
        break label268;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetInvitedUinList:");
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append(", uins=");
      if (paramObject == null) {
        paramToServiceMsg = "null";
      } else {
        paramToServiceMsg = paramObject.toString();
      }
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.d("TroopManagerBizHandler", 2, paramFromServiceMsg.toString());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      break label259;
    }
    notifyUI(TroopManagerBizObserver.TYPE_OIDB_0X903_2, false, null);
    label268:
    return;
    notifyUI(TroopManagerBizObserver.TYPE_OIDB_0X903_2, false, null);
    return;
    label279:
    notifyUI(TroopManagerBizObserver.TYPE_OIDB_0X903_2, false, null);
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopManagerBizHandler", 2, "handleTroopShareLink: start");
    }
    TroopShareResp localTroopShareResp = new TroopShareResp();
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      localTroopShareResp.c = paramToServiceMsg.extraData.getBoolean("isVerify");
      localTroopShareResp.a = paramToServiceMsg.extraData.getString("troopUin");
      int j = paramFromServiceMsg.getResultCode();
      i = -1;
      if (j == 1000)
      {
        paramToServiceMsg = new join_group_link.RspBody();
        bool2 = bool3;
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          bool2 = bool3;
          if (!paramToServiceMsg.error_code.has()) {
            break label416;
          }
          bool2 = bool3;
          i = paramToServiceMsg.error_code.get();
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            break label246;
          }
          QLog.d("TroopManagerBizHandler", 2, "handleTroopShareLink: RspBody parseFrom byte InvalidProtocolBufferMicroException");
          paramToServiceMsg.printStackTrace();
          bool3 = bool2;
          break label267;
        }
        bool2 = bool3;
        localTroopShareResp.b = i;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (paramToServiceMsg.group_code.has())
      {
        bool2 = bool1;
        localTroopShareResp.a = String.valueOf(paramToServiceMsg.group_code.get());
      }
      bool2 = bool1;
      bool3 = bool1;
      if (paramToServiceMsg.url.has())
      {
        bool2 = bool1;
        localTroopShareResp.d = paramToServiceMsg.url.get();
        bool3 = bool1;
        break label267;
        label246:
        localTroopShareResp.b = -1;
        bool3 = bool2;
      }
      label267:
      notifyUI(TroopManagerBizObserver.OBSERVER_TYPE_TROOP_LINK, bool3, localTroopShareResp);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleTroopShareLink.errCode:");
        paramToServiceMsg.append(localTroopShareResp.b);
        paramToServiceMsg.append("　troopUin:");
        paramToServiceMsg.append(localTroopShareResp.a);
        paramToServiceMsg.append(" isVerify:");
        paramToServiceMsg.append(localTroopShareResp.c);
        paramToServiceMsg.append(" shareUrl:");
        paramToServiceMsg.append(localTroopShareResp.d);
        QLog.d("TroopManagerBizHandler", 2, paramToServiceMsg.toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopManagerBizHandler", 2, "handleTroopShareLink: end");
      }
      return;
      notifyUI(TroopManagerBizObserver.OBSERVER_TYPE_TROOP_LINK, false, localTroopShareResp);
      if (QLog.isColorLevel()) {
        QLog.d("TroopManagerBizHandler", 2, "handlerBindSubAccount: req == null || resp == null");
      }
      return;
      label416:
      if (i != 0) {
        break;
      }
      bool1 = true;
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_global_group_level.set(1);
    localObject = makeOIDBPkg("OidbSvc.0x5eb_96", 1515, 96, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("OidbSvc.0x5eb_96", true);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, int paramInt)
  {
    a(paramLong, paramInt, -1, "");
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(150);
      localStringBuilder.append("getTroopInfoForSetJoinType");
      localStringBuilder.append("|troopuin = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("|flag = ");
      localStringBuilder.append(paramInt1);
      QLog.i("TroopManagerBizHandler", 2, localStringBuilder.toString());
    }
    b(paramLong, paramInt1, paramInt2, paramString);
    paramString = new oidb_0x88d.GroupInfo();
    if ((paramInt1 & 0x2) == 2) {
      paramString.uint32_group_create_time.set(0);
    }
    if ((paramInt1 & 0x4) == 4) {
      paramString.string_group_question.set(ByteStringMicro.EMPTY);
    }
    if ((paramInt1 & 0x8) == 8) {
      paramString.uint32_group_flag_ext.set(0);
    }
    if ((paramInt1 & 0x10) == 16) {
      paramString.uint32_group_type_flag.set(0);
    }
    if ((paramInt1 & 0x20) == 32) {
      paramString.uint32_group_member_num.set(0);
    }
    if ((paramInt1 & 0x800) == 2048) {
      paramString.string_group_answer.set(ByteStringMicro.EMPTY);
    }
    if ((paramInt1 & 0x40) == 64) {
      paramString.uint32_app_privilege_flag.set(0);
    }
    if ((paramInt1 & 0x80) == 128) {
      paramString.uint32_group_option.set(0);
    }
    if ((paramInt1 & 0x100) == 256) {
      paramString.uint64_group_owner.set(0L);
    }
    paramString.uint32_auto_agree_join_group_user_num_for_conf_group.set(0);
    paramString.uint32_auto_agree_join_group_user_num_for_normal_group.set(0);
    ((ITroopInfoHandler)this.appRuntime.getBusinessHandler(TroopInfoHandler.class.getName())).a(Long.valueOf(paramLong), paramString, "SUBCMD_GET_TROOP_CREATE_TIME_AND_NUM");
  }
  
  public void a(long paramLong, boolean paramBoolean, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(this.appRuntime.getApp(), TroopManagerBizHandler.PbServlet.class);
    localNewIntent.putExtra("cmd", "ProfileService.Pb.SetGroupLocation");
    GroupLocation.SetGroupLocationReq localSetGroupLocationReq = new GroupLocation.SetGroupLocationReq();
    localSetGroupLocationReq.groupcode.set(Utils.a(paramLong));
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localSetGroupLocationReq.grouplocation.set(str);
    localNewIntent.putExtra("data", localSetGroupLocationReq.toByteArray());
    localNewIntent.putExtra("TroopUin", paramLong);
    localNewIntent.putExtra("isClear", paramBoolean);
    paramString = str.split("\\|");
    int i = paramString.length;
    int j = 0;
    if (i == 4)
    {
      j = (int)(Float.valueOf(paramString[1]).floatValue() * 1000000.0F);
      i = (int)(Float.valueOf(paramString[2]).floatValue() * 1000000.0F);
    }
    else
    {
      i = 0;
    }
    localNewIntent.putExtra("lat", j);
    localNewIntent.putExtra("lon", i);
    this.appRuntime.startServlet(localNewIntent);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramIntent.getStringExtra("cmd");
    paramObject = (byte[])paramObject;
    if (str.equalsIgnoreCase("ProfileService.Pb.SetGroupLocation")) {
      a(paramIntent, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label213;
        }
        bool = true;
        if ((bool) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = new oidb_0x5eb.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramFromServiceMsg.rpt_msg_uin_data.has()) && (paramFromServiceMsg.rpt_msg_uin_data.size() > 0))
          {
            paramToServiceMsg = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0);
            long l = paramToServiceMsg.uint64_uin.get();
            if (!paramToServiceMsg.uint32_global_group_level.has()) {
              break label219;
            }
            i = paramToServiceMsg.uint32_global_group_level.get();
            notifyUI(TroopManagerBizObserver.TYPE_GET_GLOBAL_TROOP_LEVEL, bool, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      return;
      label213:
      boolean bool = false;
      continue;
      label219:
      i = -1;
    }
  }
  
  public void a(Long paramLong)
  {
    Object localObject = new TroopManagerBizHandler.7(this, paramLong);
    this.appRuntime.addDefaultObservers((BusinessObserver)localObject);
    localObject = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject).uint64_invite_no_auth_num_limit.set(0L);
    ((ITroopInfoHandler)this.appRuntime.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName())).a(paramLong, (oidb_0x88d.GroupInfo)localObject, "SUBCMD_GET_INVITE_NO_AUTH_LIMIT_NUM");
  }
  
  public void a(String paramString)
  {
    d(paramString);
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    localGroupInfo.uint32_group_admin_max_num.set(0);
    ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)this.appRuntime.getBusinessHandler(TroopInfoHandler.class.getName());
    try
    {
      localITroopInfoHandler.a(Long.valueOf(Long.parseLong(paramString)), localGroupInfo, "SUBCMD_GET_MAX_TROOP_ADMIN_NUM");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    b(paramString, paramBundle);
    paramBundle = new oidb_0x88d.GroupInfo();
    paramBundle.uint32_cmduin_join_msg_seq.set(0);
    paramBundle.uint32_cmduin_join_time.set(0);
    paramBundle.uint32_cmduin_join_real_msg_seq.set(0);
    paramBundle.uint32_group_class_ext.set(0);
    ((ITroopInfoHandler)this.appRuntime.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName())).a(Long.valueOf(Long.parseLong(paramString)), paramBundle, "SUBCMD_GET_TROOP_SEQ_AND_JOIN_TIME", 200000020, 5000L, 0);
  }
  
  public void a(String paramString1, String paramString2)
  {
    c(paramString1, paramString2);
    paramString2 = new oidb_0x88d.GroupInfo();
    paramString2.uint32_app_privilege_flag.set(0);
    Object localObject = new oidb_0x88d.GroupExInfoOnly();
    ((oidb_0x88d.GroupExInfoOnly)localObject).uint32_money_for_add_group.set(0);
    paramString2.st_group_ex_info.set((MessageMicro)localObject);
    localObject = (ITroopInfoHandler)this.appRuntime.getBusinessHandler(TroopInfoHandler.class.getName());
    try
    {
      ((ITroopInfoHandler)localObject).a(Long.valueOf(Long.parseLong(paramString1)), paramString2, "SUBCMD_GET_PAY_TO_JOIN_TROOP_STATUS");
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1))
      {
        QLog.e("TroopManagerBizHandler", 2, "modifyTroopNickRuleBy0x89a troopUin is empty!");
        return;
      }
      l = Long.parseLong(paramString1);
    }
    catch (Exception paramString1)
    {
      long l;
      label26:
      oidb_0x89a.GroupCardPrefix localGroupCardPrefix;
      break label26;
    }
    l = 0L;
    if (l == 0L)
    {
      QLog.e("TroopManagerBizHandler", 2, "modifyTroopNickRuleBy0x89a uin is 0!");
      return;
    }
    b(l);
    paramString1 = new oidb_0x89a.groupinfo();
    localGroupCardPrefix = new oidb_0x89a.GroupCardPrefix();
    if (!TextUtils.isEmpty(paramString2)) {
      localGroupCardPrefix.bytes_introduction.set(ByteStringMicro.copyFromUtf8(paramString2));
    } else {
      localGroupCardPrefix.bytes_introduction.set(ByteStringMicro.EMPTY);
    }
    paramString2 = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramString2.add(ByteStringMicro.copyFromUtf8((String)paramList.next()));
      }
    }
    paramString2.add(ByteStringMicro.EMPTY);
    localGroupCardPrefix.rpt_bytes_prefix.set(paramString2);
    paramString1.st_group_card_prefix.set(localGroupCardPrefix);
    ((ITroopModifyHandler)this.appRuntime.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName())).a(l, paramString1, "SUBCMD_MODIFY_TROOP_NICK_RULE");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      long l = Long.parseLong(paramString);
      c(l);
      paramString = new oidb_0x89a.groupinfo();
      int i = 0;
      if (!paramBoolean) {
        i = 8192;
      }
      paramString.uint32_group_flagext3.set(i);
      paramString.uint32_group_flagext3_mask.set(8192);
      ((ITroopModifyHandler)this.appRuntime.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName())).a(l, paramString, "SUBCMD_SET_CONFESS_TALK_SWITCH");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("setConfessTalkSwitch isOn :");
        paramString.append(paramBoolean);
        QLog.i("TroopManagerBizHandler", 2, paramString.toString());
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  void b(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    paramString = new TroopManagerBizHandler.3(this, paramLong, paramInt1, paramInt2, paramString);
    this.appRuntime.addDefaultObservers(paramString);
  }
  
  public void b(Long paramLong)
  {
    Object localObject = new cmd0x903.SubCmd0x2Req();
    ((cmd0x903.SubCmd0x2Req)localObject).opt_uint64_group_code.set(paramLong.longValue());
    paramLong = new cmd0x903.ReqBody();
    paramLong.opt_msg_get_invited_uin_list_req.set((MessageMicro)localObject);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2307);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramLong.toByteArray()));
    paramLong = createToServiceMsg("OidbSvc.0x903_2");
    paramLong.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    paramLong.setTimeout(30000L);
    sendPbReq(paramLong);
  }
  
  public void b(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      Object localObject1 = new oidb_0x88d.ReqBody();
      ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(0);
      Object localObject2 = new oidb_0x88d.ReqGroupInfo();
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(l);
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint32_last_get_group_name_time.set(0);
      oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
      localGroupInfo.uint32_group_member_max_num.set(0);
      localGroupInfo.uint32_active_member_num.set(0);
      ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set(localGroupInfo);
      ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
      localObject1 = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x88d_1");
      ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void b(String paramString1, String paramString2)
  {
    modifyexamine.ReqBody localReqBody = new modifyexamine.ReqBody();
    localReqBody.uint64_gc.set(Long.valueOf(paramString1).longValue());
    localReqBody.skey.set(paramString2);
    paramString1 = createToServiceMsg("ModifyExamine.GetModifyTimes");
    paramString1.putWupBuffer(localReqBody.toByteArray());
    sendPbReq(paramString1);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    try
    {
      long l = Long.parseLong(paramString);
      d(l);
      paramString = new oidb_0x89a.groupinfo();
      int i = 0;
      if (!paramBoolean) {
        i = 1073741824;
      }
      paramString.uint32_group_flagext3.set(i);
      paramString.uint32_group_flagext3_mask.set(1073741824);
      ((ITroopModifyHandler)this.appRuntime.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName())).a(l, paramString, "SUBCMD_SET_WRITE_TOGETHER_SWITCH", 25);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("setWriteTogetherSwitch isOn :");
        paramString.append(paramBoolean);
        QLog.i("TroopManagerBizHandler", 2, paramString.toString());
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void c(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("activeExtTroop troopUin: ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.i("troop_ext", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new oidb_0xc6c.ReqBody();
    try
    {
      ((oidb_0xc6c.ReqBody)localObject1).uint64_uin.set(Long.valueOf(this.appRuntime.getCurrentUin()).longValue());
      localObject2 = new oidb_0xc6c.GroupInfo();
      ((oidb_0xc6c.GroupInfo)localObject2).uint64_group_uin.set(Long.valueOf(paramString).longValue());
      ((oidb_0xc6c.ReqBody)localObject1).rpt_msg_group_info.add((MessageMicro)localObject2);
      localObject1 = makeOIDBPkg("OidbSvc.cmd0xc6c", 3180, 0, ((oidb_0xc6c.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("troop_uin", paramString);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("activeExtTroop exception: ");
      ((StringBuilder)localObject2).append(localNumberFormatException.getMessage());
      ((StringBuilder)localObject2).append(" uin : ");
      ((StringBuilder)localObject2).append(this.appRuntime.getCurrentUin());
      ((StringBuilder)localObject2).append(" troop uin: ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i("troop_ext", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = ByteBuffer.allocate(5);
    try
    {
      ((ByteBuffer)localObject).putInt(Integer.valueOf(paramString).intValue());
      if (paramBoolean) {
        ((ByteBuffer)localObject).put((byte)1);
      } else {
        ((ByteBuffer)localObject).put((byte)0);
      }
      localObject = ((ByteBuffer)localObject).array();
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1384);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(22);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
      localObject = createToServiceMsg("OidbSvc.0x568_22");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("isAllowAnonymousChat", paramBoolean);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label128:
      break label128;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAnonymousChat failed because NumberFormatException, troopUin : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopManagerBizHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopManagerBizHandler", 2, "getTroopShareLink: start");
    }
    join_group_link.ReqBody localReqBody = new join_group_link.ReqBody();
    if (paramBoolean) {
      localReqBody.type.set(1);
    } else {
      localReqBody.type.set(3);
    }
    localReqBody.group_code.set(Long.valueOf(paramString).longValue());
    ToServiceMsg localToServiceMsg = createToServiceMsg("GroupSvc.JoinGroupLink");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.extraData.putBoolean("isVerify", paramBoolean);
    localToServiceMsg.extraData.putString("troopUin", paramString);
    sendPbReq(localToServiceMsg);
  }
  
  protected String dv_()
  {
    return "TroopManagerBizHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x88d_1");
      this.allowCmdSet.add("OidbSvc.0x568_22");
      this.allowCmdSet.add("ModifyExamine.GetModifyTimes");
      this.allowCmdSet.add("OidbSvc.cmd0xc6c");
      this.allowCmdSet.add("OidbSvc.0x903_2");
      this.allowCmdSet.add("GroupSvc.JoinGroupLink");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopManagerBizObserver.class;
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
          QLog.d("TroopManagerBizHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!dv_().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopManagerBizHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0x88d_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x568_22".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ModifyExamine.GetModifyTimes".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.cmd0xc6c".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x903_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("GroupSvc.JoinGroupLink".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_96".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopManagerBizHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler
 * JD-Core Version:    0.7.0.1
 */