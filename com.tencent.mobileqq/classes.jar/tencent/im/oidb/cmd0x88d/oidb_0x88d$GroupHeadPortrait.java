package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x88d$GroupHeadPortrait
  extends MessageMicro<GroupHeadPortrait>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "uint32_pic_cnt", "rpt_msg_info", "uint32_default_id", "uint32_verifying_pic_cnt", "rpt_msg_verifyingpic_info" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), null }, GroupHeadPortrait.class);
  public final PBRepeatMessageField<oidb_0x88d.GroupHeadPortraitInfo> rpt_msg_info = PBField.initRepeatMessage(oidb_0x88d.GroupHeadPortraitInfo.class);
  public final PBRepeatMessageField<oidb_0x88d.GroupHeadPortraitInfo> rpt_msg_verifyingpic_info = PBField.initRepeatMessage(oidb_0x88d.GroupHeadPortraitInfo.class);
  public final PBUInt32Field uint32_default_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_verifying_pic_cnt = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait
 * JD-Core Version:    0.7.0.1
 */