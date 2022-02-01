package tencent.im.oidb.cmd0x5bd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5bd$SkinInfo
  extends MessageMicro<SkinInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_begin_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50 }, new String[] { "bytes_id", "bytes_name", "uint32_begin_timestamp", "uint32_end_timestamp", "uint64_seq", "bytes_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, Long.valueOf(0L), localByteStringMicro3 }, SkinInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo
 * JD-Core Version:    0.7.0.1
 */