package tencent.im.s2c.msgtype0x210.submsgtype0x13b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x13b$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "op", "uint64_mute_friend" }, new Object[] { Integer.valueOf(2), Long.valueOf(0L) }, MsgBody.class);
  public final PBEnumField op = PBField.initEnum(2);
  public final PBUInt64Field uint64_mute_friend = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x13b.submsgtype0x13b.MsgBody
 * JD-Core Version:    0.7.0.1
 */