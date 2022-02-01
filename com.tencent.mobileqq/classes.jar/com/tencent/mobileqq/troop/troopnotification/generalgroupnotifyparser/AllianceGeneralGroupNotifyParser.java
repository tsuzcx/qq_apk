package com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.general_group_notify.general_group_notify.ApplyAlliance;
import tencent.im.oidb.general_group_notify.general_group_notify.GroupAllianceNotify;
import tencent.im.oidb.general_group_notify.general_group_notify.GroupNotify;

public class AllianceGeneralGroupNotifyParser
  extends GeneralGroupNotifyParser
{
  protected AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo a(general_group_notify.GroupNotify paramGroupNotify)
  {
    AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo localAllianceGeneralGroupNotifyInfo = new AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo();
    int i = paramGroupNotify.opt_uint32_msg_type.get();
    localAllianceGeneralGroupNotifyInfo.l = i;
    if ((i == 1) && (paramGroupNotify.opt_st_alliance_notify.has()))
    {
      Object localObject = (general_group_notify.GroupAllianceNotify)paramGroupNotify.opt_st_alliance_notify.get();
      if (localObject != null)
      {
        localAllianceGeneralGroupNotifyInfo.m = ((general_group_notify.GroupAllianceNotify)localObject).uint32_alliance_notify_type.get();
        boolean bool = ((general_group_notify.GroupAllianceNotify)localObject).bytes_alliance_name.has();
        String str = "";
        if (bool) {
          paramGroupNotify = ((general_group_notify.GroupAllianceNotify)localObject).bytes_alliance_name.get().toStringUtf8();
        } else {
          paramGroupNotify = "";
        }
        localAllianceGeneralGroupNotifyInfo.a = paramGroupNotify;
        localAllianceGeneralGroupNotifyInfo.b = ((general_group_notify.GroupAllianceNotify)localObject).uint64_alliance_id.get();
        if (((general_group_notify.GroupAllianceNotify)localObject).bytes_alliance_owner_name.has()) {
          paramGroupNotify = ((general_group_notify.GroupAllianceNotify)localObject).bytes_alliance_owner_name.get().toStringUtf8();
        } else {
          paramGroupNotify = "";
        }
        localAllianceGeneralGroupNotifyInfo.c = paramGroupNotify;
        localAllianceGeneralGroupNotifyInfo.d = ((general_group_notify.GroupAllianceNotify)localObject).uint64_leader_group_code.get();
        localAllianceGeneralGroupNotifyInfo.e = ((general_group_notify.GroupAllianceNotify)localObject).uint32_result.get();
        if (((general_group_notify.GroupAllianceNotify)localObject).st_apply_alliance.has())
        {
          localObject = (general_group_notify.ApplyAlliance)((general_group_notify.GroupAllianceNotify)localObject).st_apply_alliance.get();
          localAllianceGeneralGroupNotifyInfo.f = ((general_group_notify.ApplyAlliance)localObject).uint64_apply_group_code.get();
          if (((general_group_notify.ApplyAlliance)localObject).bytes_apply_group_name.has()) {
            paramGroupNotify = ((general_group_notify.ApplyAlliance)localObject).bytes_apply_group_name.get().toStringUtf8();
          } else {
            paramGroupNotify = "";
          }
          localAllianceGeneralGroupNotifyInfo.g = paramGroupNotify;
          localAllianceGeneralGroupNotifyInfo.h = ((general_group_notify.ApplyAlliance)localObject).uint64_apply_group_owner_uin.get();
          if (((general_group_notify.ApplyAlliance)localObject).bytes_apply_group_owner_name.has()) {
            paramGroupNotify = ((general_group_notify.ApplyAlliance)localObject).bytes_apply_group_owner_name.get().toStringUtf8();
          } else {
            paramGroupNotify = "";
          }
          localAllianceGeneralGroupNotifyInfo.i = paramGroupNotify;
          localAllianceGeneralGroupNotifyInfo.j = ((general_group_notify.ApplyAlliance)localObject).uint64_source_group_uin.get();
          paramGroupNotify = str;
          if (((general_group_notify.ApplyAlliance)localObject).bytes_source_group_name.has()) {
            paramGroupNotify = ((general_group_notify.ApplyAlliance)localObject).bytes_source_group_name.get().toStringUtf8();
          }
          localAllianceGeneralGroupNotifyInfo.k = paramGroupNotify;
        }
      }
    }
    return localAllianceGeneralGroupNotifyInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.AllianceGeneralGroupNotifyParser
 * JD-Core Version:    0.7.0.1
 */