package com.tencent.mobileqq.service.troop;

import KQQ.BatchRequest;
import KQQ.ReqBatchProcess;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetMultiTroopInfoReq;
import friendlist.GetTroopAppointRemarkReq;
import friendlist.GetTroopListReqV2Simplify;
import friendlist.GetTroopMemberListReq;
import friendlist.GetTroopRemarkReq;
import friendlist.ModifyGroupCardReq;
import friendlist.ModifyGroupInfoReq;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.cmd0x899.oidb_0x899.ReqBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopSender
{
  private AppInterface a;
  
  public TroopSender(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  private long a(String paramString)
  {
    long l = 0L;
    if (paramString != null) {
      if (paramString.length() <= 0) {
        return 0L;
      }
    }
    try
    {
      l = Long.parseLong(paramString);
      if (l < 10000L) {
        return 0L;
      }
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&", "&amp;").replace("'", "&apos;").replace("\"", "&quot;").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;");
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    byte b1 = paramToServiceMsg.extraData.getByte("bGetMSFMsgFlag");
    Object localObject = paramToServiceMsg.extraData.getByteArray("vecCookies");
    ArrayList localArrayList = (ArrayList)paramToServiceMsg.extraData.getSerializable("vecGroupInfo");
    byte b2 = paramToServiceMsg.extraData.getByte("bGroupFlagExt");
    byte b3 = paramToServiceMsg.extraData.getByte("bGetLongGroupName");
    paramToServiceMsg = new GetTroopListReqV2Simplify();
    paramToServiceMsg.uin = l;
    paramToServiceMsg.bGetMSFMsgFlag = b1;
    paramToServiceMsg.vecCookies = ((byte[])localObject);
    paramToServiceMsg.vecGroupInfo = localArrayList;
    paramToServiceMsg.bGroupFlagExt = b2;
    paramToServiceMsg.bGetLongGroupName = b3;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleTroopGetList bGetLongGroupName = ");
      ((StringBuilder)localObject).append(b3);
      QLog.d("TroopSender", 2, ((StringBuilder)localObject).toString());
    }
    paramToServiceMsg.shVersion = 9;
    paramToServiceMsg.versionNum = 1L;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopListReqV2Simplify");
    paramUniPacket.put("GetTroopListReqV2Simplify", paramToServiceMsg);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    Bundle localBundle = paramToServiceMsg.extraData;
    paramToServiceMsg = new GetTroopMemberListReq();
    paramToServiceMsg.uin = l;
    paramToServiceMsg.GroupCode = localBundle.getLong("troop_uin");
    paramToServiceMsg.GroupUin = localBundle.getLong("troop_code");
    paramToServiceMsg.Version = localBundle.getLong("version");
    paramToServiceMsg.NextUin = localBundle.getLong("nextuin");
    paramToServiceMsg.ReqType = localBundle.getInt("reqType", 0);
    paramToServiceMsg.GetListAppointTime = localBundle.getLong("get_list_appoint_time", 0L);
    paramToServiceMsg.cRichCardNameVer = 1;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopMemberListReq");
    paramUniPacket.put("GTML", paramToServiceMsg);
    if (QLog.isColorLevel())
    {
      paramUniPacket = new StringBuilder();
      paramUniPacket.append("FriendListService.handleTroopGetMemberList, troopUin: ");
      paramUniPacket.append(paramToServiceMsg.GroupCode);
      paramUniPacket.append(" |troopCode: ");
      paramUniPacket.append(paramToServiceMsg.GroupUin);
      paramUniPacket.append("|ReqType:");
      paramUniPacket.append(paramToServiceMsg.ReqType);
      paramUniPacket.append("|GetListAppointTime:");
      paramUniPacket.append(paramToServiceMsg.GetListAppointTime);
      QLog.d("TroopSender", 2, paramUniPacket.toString());
    }
    return true;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    GetTroopRemarkReq localGetTroopRemarkReq = new GetTroopRemarkReq();
    localGetTroopRemarkReq.uin = l;
    localGetTroopRemarkReq.GroupCode = paramToServiceMsg.getLong("troop_uin");
    localGetTroopRemarkReq.GroupUin = paramToServiceMsg.getLong("troop_code");
    if (localGetTroopRemarkReq.GroupCode != 0L)
    {
      if (localGetTroopRemarkReq.GroupUin == 0L) {
        return false;
      }
      localGetTroopRemarkReq.NextUin = paramToServiceMsg.getLong("nextuin");
      localGetTroopRemarkReq.Seq = 0L;
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetTroopRemarkReq");
      paramUniPacket.put("GTR", localGetTroopRemarkReq);
      return true;
    }
    return false;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetMultiTroopInfoReq(Long.parseLong(paramToServiceMsg.getUin()), (ArrayList)paramToServiceMsg.extraData.getSerializable("vecGroupCode"), (byte)1);
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetMultiTroopInfoReq");
    paramUniPacket.put("GMTIREQ", paramToServiceMsg);
    return true;
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Long.parseLong(paramToServiceMsg.getUin());
    ArrayList localArrayList = (ArrayList)paramToServiceMsg.extraData.getSerializable("vecUinInfo");
    long l1 = paramToServiceMsg.extraData.getLong("dwZero");
    long l2 = paramToServiceMsg.extraData.getLong("dwGroupCode");
    long l3 = paramToServiceMsg.extraData.getLong("dwNewSeq");
    paramToServiceMsg = new ModifyGroupCardReq();
    paramToServiceMsg.dwGroupCode = l2;
    paramToServiceMsg.dwNewSeq = l3;
    paramToServiceMsg.dwZero = l1;
    paramToServiceMsg.vecUinInfo = localArrayList;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("ModifyGroupCardReq");
    paramUniPacket.put("MGCREQ", paramToServiceMsg);
    return true;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    try
    {
      long l = Long.parseLong(paramToServiceMsg.getUin());
      ArrayList localArrayList = (ArrayList)paramToServiceMsg.extraData.getSerializable("vecUinList");
      if (localArrayList != null)
      {
        if (localArrayList.size() == 0) {
          return false;
        }
        Object localObject = paramToServiceMsg.extraData.getString("GroupUin");
        String str = paramToServiceMsg.extraData.getString("GroupCode");
        byte b = paramToServiceMsg.extraData.getByte("cRichInfo");
        paramToServiceMsg = new GetTroopAppointRemarkReq();
        paramToServiceMsg.cRichInfo = b;
        paramToServiceMsg.GroupCode = Long.parseLong((String)localObject);
        paramToServiceMsg.GroupUin = Long.parseLong(str);
        paramToServiceMsg.cRichCardNameVer = 1;
        localObject = new ArrayList();
        int i = 0;
        while (i < localArrayList.size())
        {
          ((ArrayList)localObject).add(Long.valueOf(Long.parseLong((String)localArrayList.get(i))));
          i += 1;
        }
        paramToServiceMsg.vecUinList = ((ArrayList)localObject);
        paramToServiceMsg.uin = l;
        paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        paramUniPacket.setFuncName("GetTroopAppointRemarkReq");
        paramUniPacket.put("GTA", paramToServiceMsg);
        return true;
      }
      return false;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    return false;
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    ModifyGroupInfoReq localModifyGroupInfoReq = new ModifyGroupInfoReq();
    localModifyGroupInfoReq.dwGroupCode = paramToServiceMsg.extraData.getLong("dwGroupCode");
    localModifyGroupInfoReq.cGroupOption = paramToServiceMsg.extraData.getLong("cGroupOption");
    localModifyGroupInfoReq.dwGroupClass = paramToServiceMsg.extraData.getLong("dwGroupClass");
    localModifyGroupInfoReq.strGroupName = paramToServiceMsg.extraData.getString("strGroupName");
    localModifyGroupInfoReq.wGroupFace = paramToServiceMsg.extraData.getInt("wGroupFace");
    localModifyGroupInfoReq.strGroupMemo = paramToServiceMsg.extraData.getString("strGroupMemo");
    localModifyGroupInfoReq.dwValidMask = paramToServiceMsg.extraData.getLong("dwValidMask");
    String str = paramToServiceMsg.extraData.getString("strFingerMemo");
    localModifyGroupInfoReq.strFingerMemo = paramToServiceMsg.extraData.getString("textEmoji");
    localModifyGroupInfoReq.strRichFingerMemo = b(str);
    localModifyGroupInfoReq.wVersion = 1;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("ModifyGroupInfoReq");
    paramUniPacket.put("MGIREQ", localModifyGroupInfoReq);
    return true;
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("troop_code");
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("is_admin");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("param_get_credit_info");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("param_get_troop_class_type");
    paramToServiceMsg.extraData.getInt("from", 0);
    if (l == 0L) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handlerBatchGetGroupInfoReq：");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(",isMember=");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(",isGetTroopCreditInfo=");
      ((StringBuilder)localObject1).append(bool2);
      QLog.i("TroopSender", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ReqBatchProcess();
    ((ReqBatchProcess)localObject1).batch_request_list = new ArrayList();
    Object localObject3;
    Object localObject2;
    if (bool3)
    {
      localObject3 = new oidb_0x88d.GroupInfo();
      ((oidb_0x88d.GroupInfo)localObject3).uint32_group_class_ext.set(0);
      ((oidb_0x88d.GroupInfo)localObject3).string_group_class_text.set(ByteStringMicro.EMPTY);
      ((oidb_0x88d.GroupInfo)localObject3).string_group_name.set(ByteStringMicro.EMPTY);
      ((oidb_0x88d.GroupInfo)localObject3).uint32_group_face.set(0);
      ((oidb_0x88d.GroupInfo)localObject3).uint64_subscription_uin.set(0L);
      ((oidb_0x88d.GroupInfo)localObject3).uint64_group_owner.set(0L);
      ((oidb_0x88d.GroupInfo)localObject3).uint32_is_modify_conf_group_name.set(0);
      ((oidb_0x88d.GroupInfo)localObject3).uint32_is_modify_conf_group_face.set(0);
      ((oidb_0x88d.GroupInfo)localObject3).uint32_is_conf_group.set(0);
      ((oidb_0x88d.GroupInfo)localObject3).uint32_group_member_num.set(0);
      ((oidb_0x88d.GroupInfo)localObject3).uint32_no_finger_open_flag.set(0);
      ((oidb_0x88d.GroupInfo)localObject3).uint32_no_code_finger_open_flag.set(0);
      ((oidb_0x88d.GroupInfo)localObject3).uint32_is_group_freeze.set(0);
      ((oidb_0x88d.GroupInfo)localObject3).uint32_group_flagext4.set(0);
      ((oidb_0x88d.GroupInfo)localObject3).uint32_group_freeze_reason.set(0);
      ((oidb_0x88d.GroupInfo)localObject3).uint64_alliance_id.set(0L);
      localObject2 = new oidb_0x88d.ReqGroupInfo();
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(l);
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint32_last_get_group_name_time.set(0);
      ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject3);
      localObject3 = new oidb_0x88d.ReqBody();
      ((oidb_0x88d.ReqBody)localObject3).uint32_appid.set(AppSetting.d());
      ((oidb_0x88d.ReqBody)localObject3).stzreqgroupinfo.add((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(bool1 ^ true);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject3).toByteArray()));
      localObject3 = new BatchRequest();
      ((BatchRequest)localObject3).type = 1;
      ((BatchRequest)localObject3).seq = 0;
      ((BatchRequest)localObject3).buffer = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
      ((ReqBatchProcess)localObject1).batch_request_list.add(localObject3);
    }
    for (;;)
    {
      break;
      if (bool2)
      {
        localObject2 = new oidb_0x88d.GroupInfo();
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_sec_level.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_sec_level_info.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flagext4.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_freeze_reason.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint64_alliance_id.set(0L);
        localObject3 = new oidb_0x88d.ReqGroupInfo();
        ((oidb_0x88d.ReqGroupInfo)localObject3).uint64_group_code.set(l);
        ((oidb_0x88d.ReqGroupInfo)localObject3).uint32_last_get_group_name_time.set(0);
        ((oidb_0x88d.ReqGroupInfo)localObject3).stgroupinfo.set((MessageMicro)localObject2);
        localObject2 = new oidb_0x88d.ReqBody();
        ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(AppSetting.d());
        ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject3);
        localObject3 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(2189);
        PBUInt32Field localPBUInt32Field = ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type;
        int i;
        if (bool1) {
          i = 19;
        } else {
          i = 1;
        }
        localPBUInt32Field.set(i);
        ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
        localObject2 = new BatchRequest();
        ((BatchRequest)localObject2).type = 1;
        ((BatchRequest)localObject2).seq = 0;
        ((BatchRequest)localObject2).buffer = ((oidb_sso.OIDBSSOPkg)localObject3).toByteArray();
        ((ReqBatchProcess)localObject1).batch_request_list.add(localObject2);
      }
      else
      {
        localObject2 = new oidb_0x88d.GroupInfo();
        ((oidb_0x88d.GroupInfo)localObject2).string_group_name.set(ByteStringMicro.EMPTY);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_grade.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_active_member_num.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flag_ext.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flag.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_certification_type.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).string_certification_text.set(ByteStringMicro.EMPTY);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_member_max_num.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_member_num.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_app_privilege_flag.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_type_flag.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_create_time.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint64_subscription_uin.set(0L);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_is_modify_conf_group_name.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_is_modify_conf_group_face.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_is_conf_group.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_no_finger_open_flag.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_no_code_finger_open_flag.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_is_group_freeze.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint64_alliance_id.set(0L);
        localObject3 = new oidb_0x88d.GroupExInfoOnly();
        ((oidb_0x88d.GroupExInfoOnly)localObject3).uint32_money_for_add_group.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).st_group_ex_info.set((MessageMicro)localObject3);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_is_allow_conf_group_member_modify_group_name.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_is_allow_conf_group_member_nick.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_is_allow_conf_group_member_at_all.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).string_long_group_name.set(ByteStringMicro.EMPTY);
        if (!bool1) {
          ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(0L);
        }
        localObject3 = new oidb_0x88d.GroupGeoInfo();
        ((oidb_0x88d.GroupGeoInfo)localObject3).bytes_geocontent.set(ByteStringMicro.EMPTY);
        ((oidb_0x88d.GroupInfo)localObject2).group_geo_info.set((MessageMicro)localObject3);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_class_ext.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).string_group_class_text.set(ByteStringMicro.EMPTY);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flagext3.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).string_group_rich_finger_memo.set(ByteStringMicro.EMPTY);
        localObject3 = new oidb_0x88d.TagRecord();
        ((oidb_0x88d.TagRecord)localObject3).uint32_bad_num.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).rpt_tag_record.add((MessageMicro)localObject3);
        ((oidb_0x88d.GroupInfo)localObject2).string_group_finger_memo.set(ByteStringMicro.EMPTY);
        ((oidb_0x88d.GroupInfo)localObject2).bytes_group_school_info.set(ByteStringMicro.EMPTY);
        ((oidb_0x88d.GroupInfo)localObject2).uint64_subscription_uin.set(0L);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_auto_agree_join_group_user_num_for_conf_group.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_auto_agree_join_group_user_num_for_normal_group.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flagext4.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_group_freeze_reason.set(0);
        ((oidb_0x88d.GroupInfo)localObject2).uint32_is_allow_recall_msg.set(0);
        localObject3 = new oidb_0x88d.ReqGroupInfo();
        ((oidb_0x88d.ReqGroupInfo)localObject3).uint64_group_code.set(l);
        ((oidb_0x88d.ReqGroupInfo)localObject3).uint32_last_get_group_name_time.set(0);
        ((oidb_0x88d.ReqGroupInfo)localObject3).stgroupinfo.set((MessageMicro)localObject2);
        localObject2 = new oidb_0x88d.ReqBody();
        ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(200000020);
        ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject3);
        localObject3 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(2189);
        ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(bool1 ^ true);
        ((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
        localObject2 = new BatchRequest();
        ((BatchRequest)localObject2).type = 1;
        ((BatchRequest)localObject2).seq = 0;
        ((BatchRequest)localObject2).buffer = ((oidb_sso.OIDBSSOPkg)localObject3).toByteArray();
        ((ReqBatchProcess)localObject1).batch_request_list.add(localObject2);
        localObject3 = new oidb_0x899.memberlist();
        ((oidb_0x899.memberlist)localObject3).uint64_member_uin.set(0L);
        localObject2 = new oidb_0x899.ReqBody();
        ((oidb_0x899.ReqBody)localObject2).uint64_group_code.set(l);
        ((oidb_0x899.ReqBody)localObject2).uint64_start_uin.set(0L);
        if (bool1) {
          ((oidb_0x899.ReqBody)localObject2).uint32_identify_flag.set(5);
        } else {
          ((oidb_0x899.ReqBody)localObject2).uint32_identify_flag.set(2);
        }
        ((oidb_0x899.ReqBody)localObject2).uint32_member_num.set(6);
        ((oidb_0x899.ReqBody)localObject2).uint32_filter_method.set(0);
        ((oidb_0x899.ReqBody)localObject2).memberlist_opt.set((MessageMicro)localObject3);
        localObject3 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(2201);
        if (bool1) {
          ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(0);
        } else {
          ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(1);
        }
        ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x899.ReqBody)localObject2).toByteArray()));
        localObject2 = new BatchRequest();
        ((BatchRequest)localObject2).type = 1;
        ((BatchRequest)localObject2).seq = 1;
        ((BatchRequest)localObject2).buffer = ((oidb_sso.OIDBSSOPkg)localObject3).toByteArray();
        ((ReqBatchProcess)localObject1).batch_request_list.add(localObject2);
        if (bool1)
        {
          localObject3 = new oidb_0x787.Filter();
          ((oidb_0x787.Filter)localObject3).uint32_sys_show_flag.set(0);
          ((oidb_0x787.Filter)localObject3).uint32_user_show_flag.set(0);
          ((oidb_0x787.Filter)localObject3).uint32_special_title.set(0);
          ((oidb_0x787.Filter)localObject3).uint32_user_show_flag_new.set(0);
          localObject2 = new oidb_0x787.ReqBody();
          ((oidb_0x787.ReqBody)localObject2).uint64_group_code.set(l);
          ((oidb_0x787.ReqBody)localObject2).uint64_begin_uin.set(0L);
          ((oidb_0x787.ReqBody)localObject2).uint64_data_time.set(0L);
          ((oidb_0x787.ReqBody)localObject2).rpt_uin_list.add(Long.valueOf(this.a.getLongAccountUin()));
          ((oidb_0x787.ReqBody)localObject2).opt_filter.set((MessageMicro)localObject3);
          localObject3 = new oidb_sso.OIDBSSOPkg();
          ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(1927);
          ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(1);
          ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject2).toByteArray()));
          localObject2 = new BatchRequest();
          ((BatchRequest)localObject2).type = 1;
          ((BatchRequest)localObject2).seq = 2;
          ((BatchRequest)localObject2).buffer = ((oidb_sso.OIDBSSOPkg)localObject3).toByteArray();
          ((ReqBatchProcess)localObject1).batch_request_list.add(localObject2);
        }
      }
    }
    paramUniPacket.setServantName("ProfileService");
    paramUniPacket.setFuncName("ReqBatchProcess");
    paramUniPacket.put("ReqBatchProcess", localObject1);
    paramToServiceMsg.putWupBuffer(paramUniPacket.encode());
    return true;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create wup buffer cmd: ");
      localStringBuilder.append(str);
      QLog.d("TroopSender", 2, localStringBuilder.toString());
    }
    if ("friendlist.GetTroopListReqV2".equalsIgnoreCase(str)) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.getTroopMemberList".equalsIgnoreCase(str)) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.getTroopRemark".equalsIgnoreCase(str)) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.GetMultiTroopInfoReq".equalsIgnoreCase(str)) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.ModifyGroupCardReq".equalsIgnoreCase(str)) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.GetTroopAppointRemarkReq".equalsIgnoreCase(str)) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if ("friendlist.ModifyGroupInfoReq".equalsIgnoreCase(str)) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if ("ProfileService.ReqBatchProcess".equalsIgnoreCase(str)) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.troop.TroopSender
 * JD-Core Version:    0.7.0.1
 */