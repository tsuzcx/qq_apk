package tencent.im.oidb.cmd0xeae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xeae$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_black_times", "str_black_times_used_up_tips", "str_black_times_used_up_title", "str_black_times_tips" }, new Object[] { Long.valueOf(0L), "", "", "" }, RspBody.class);
  public final PBStringField str_black_times_tips = PBField.initString("");
  public final PBStringField str_black_times_used_up_tips = PBField.initString("");
  public final PBStringField str_black_times_used_up_title = PBField.initString("");
  public final PBUInt64Field uint64_black_times = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeae.oidb_0xeae.RspBody
 * JD-Core Version:    0.7.0.1
 */