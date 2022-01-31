package tencent.im.s2c.msgtype0x210.submsgtype0x8f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x8f$SourceID
  extends MessageMicro<SourceID>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source_type", "uint64_source_code" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, SourceID.class);
  public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_source_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x8f.submsgtype0x8f.SourceID
 * JD-Core Version:    0.7.0.1
 */