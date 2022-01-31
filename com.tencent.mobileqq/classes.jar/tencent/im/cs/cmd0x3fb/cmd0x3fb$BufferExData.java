package tencent.im.cs.cmd0x3fb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x3fb$BufferExData
  extends MessageMicro<BufferExData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField string_value = PBField.initString("");
  public final PBUInt32Field uint32_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_value = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_index", "uint32_value", "string_value", "bytes_value" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro }, BufferExData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x3fb.cmd0x3fb.BufferExData
 * JD-Core Version:    0.7.0.1
 */