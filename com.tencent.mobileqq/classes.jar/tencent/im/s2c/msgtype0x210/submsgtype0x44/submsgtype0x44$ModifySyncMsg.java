package tencent.im.s2c.msgtype0x210.submsgtype0x44;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x44$ModifySyncMsg
  extends MessageMicro<ModifySyncMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_time" }, new Object[] { Integer.valueOf(0) }, ModifySyncMsg.class);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ModifySyncMsg
 * JD-Core Version:    0.7.0.1
 */