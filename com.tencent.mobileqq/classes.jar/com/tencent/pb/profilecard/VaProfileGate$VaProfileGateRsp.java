package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VaProfileGate$VaProfileGateRsp
  extends MessageMicro<VaProfileGateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field iRetCode = PBField.initInt32(0);
  public final PBRepeatMessageField<VaProfileGate.OidbFlagInfo> rpt_oidb_flag = PBField.initRepeatMessage(VaProfileGate.OidbFlagInfo.class);
  public final PBRepeatMessageField<VaProfileGate.CommTaskInfo> rpt_task_item = PBField.initRepeatMessage(VaProfileGate.CommTaskInfo.class);
  public final PBBytesField sRetMsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public VaProfileGate.GetGiftListRsp stGiftRsp = new VaProfileGate.GetGiftListRsp();
  public VaProfileGate.PrivilegeBaseInfoRsp stPrivilegeRsp = new VaProfileGate.PrivilegeBaseInfoRsp();
  public VaProfileGate.GetVipCareRsp st_vip_care = new VaProfileGate.GetVipCareRsp();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "iRetCode", "sRetMsg", "stPrivilegeRsp", "stGiftRsp", "rpt_task_item", "rpt_oidb_flag", "st_vip_care" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null, null, null }, VaProfileGateRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate.VaProfileGateRsp
 * JD-Core Version:    0.7.0.1
 */