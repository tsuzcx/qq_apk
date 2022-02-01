package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x64e$SRTClickInfo
  extends MessageMicro<SRTClickInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_srt_rule_list", "uint32_hit_srt_rule_index", "msg_hit_srt_rule" }, new Object[] { null, Integer.valueOf(0), null }, SRTClickInfo.class);
  public oidb_cmd0x64e.SRTRule msg_hit_srt_rule = new oidb_cmd0x64e.SRTRule();
  public final PBRepeatMessageField<oidb_cmd0x64e.SRTRule> msg_srt_rule_list = PBField.initRepeatMessage(oidb_cmd0x64e.SRTRule.class);
  public final PBUInt32Field uint32_hit_srt_rule_index = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo
 * JD-Core Version:    0.7.0.1
 */