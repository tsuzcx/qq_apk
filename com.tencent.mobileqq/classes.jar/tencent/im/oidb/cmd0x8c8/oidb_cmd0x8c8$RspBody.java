package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8c8$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint64_uin", "rpt_social_feeds_info", "rpt_del_feeds_id_list", "rpt_del_feeds_info_list" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), null }, RspBody.class);
  public final PBRepeatField rpt_del_feeds_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField rpt_del_feeds_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8.FeedsInfo.class);
  public final PBRepeatMessageField rpt_social_feeds_info = PBField.initRepeatMessage(oidb_cmd0x8c8.FeedsInfo.class);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.RspBody
 * JD-Core Version:    0.7.0.1
 */