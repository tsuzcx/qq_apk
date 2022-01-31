package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class gallery$ClassInfo
  extends MessageMicro<ClassInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField Bytes_channel = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField Bytes_second_channel = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_second_channel_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint64_channel_id", "Bytes_channel", "uint64_second_channel_id", "Bytes_second_channel" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, ClassInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery.ClassInfo
 * JD-Core Version:    0.7.0.1
 */