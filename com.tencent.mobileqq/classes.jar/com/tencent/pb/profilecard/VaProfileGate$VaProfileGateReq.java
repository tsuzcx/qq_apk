package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VaProfileGate$VaProfileGateReq
  extends MessageMicro<VaProfileGateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uCmd", "stPrivilegeReq", "stGiftReq", "rpt_task_item", "rpt_oidb_flag", "st_vip_care" }, new Object[] { Integer.valueOf(0), null, null, null, null, null }, VaProfileGateReq.class);
  public final PBRepeatMessageField<VaProfileGate.OidbFlagInfo> rpt_oidb_flag = PBField.initRepeatMessage(VaProfileGate.OidbFlagInfo.class);
  public final PBRepeatMessageField<VaProfileGate.CommTaskInfo> rpt_task_item = PBField.initRepeatMessage(VaProfileGate.CommTaskInfo.class);
  public VaProfileGate.GetGiftListReq stGiftReq = new VaProfileGate.GetGiftListReq();
  public VaProfileGate.PrivilegeBaseInfoReq stPrivilegeReq = new VaProfileGate.PrivilegeBaseInfoReq();
  public VaProfileGate.GetVipCareReq st_vip_care = new VaProfileGate.GetVipCareReq();
  public final PBUInt32Field uCmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate.VaProfileGateReq
 * JD-Core Version:    0.7.0.1
 */