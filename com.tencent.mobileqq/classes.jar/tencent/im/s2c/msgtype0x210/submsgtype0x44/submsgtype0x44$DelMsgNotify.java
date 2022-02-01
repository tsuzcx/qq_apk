package tencent.im.s2c.msgtype0x210.submsgtype0x44;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x44$DelMsgNotify
  extends MessageMicro<DelMsgNotify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_sequence" }, new Object[] { Long.valueOf(0L) }, DelMsgNotify.class);
  public final PBUInt64Field uint64_sequence = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.DelMsgNotify
 * JD-Core Version:    0.7.0.1
 */