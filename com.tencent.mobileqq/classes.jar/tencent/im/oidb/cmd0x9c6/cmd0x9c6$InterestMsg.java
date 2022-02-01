package tencent.im.oidb.cmd0x9c6;

import appoint.define.appoint_define.InterestTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x9c6$InterestMsg
  extends MessageMicro<InterestMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_ddwUin", "msg_interest_tag", "rpt_latest_interest_tags", "uint32_mod_time" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0) }, InterestMsg.class);
  public appoint_define.InterestTag msg_interest_tag = new appoint_define.InterestTag();
  public final PBRepeatMessageField<appoint_define.InterestTag> rpt_latest_interest_tags = PBField.initRepeatMessage(appoint_define.InterestTag.class);
  public final PBUInt32Field uint32_mod_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_ddwUin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9c6.cmd0x9c6.InterestMsg
 * JD-Core Version:    0.7.0.1
 */