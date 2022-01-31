package tencent.im.oidb.cmd0xded;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xded$Node
  extends MessageMicro<Node>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field default_classify = PBField.initUInt32(0);
  public final PBRepeatField<Long> gc = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBBytesField item = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField keyword = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField rule = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48 }, new String[] { "item", "keyword", "type", "default_classify", "rule", "gc" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L) }, Node.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xded.oidb_0xded.Node
 * JD-Core Version:    0.7.0.1
 */