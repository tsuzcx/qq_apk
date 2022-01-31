package tencent.im.oidb.cmd0xbe0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xbe0$StackGallery
  extends MessageMicro<StackGallery>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_is_clicked = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_exposure = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_place = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_pic_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_read_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56 }, new String[] { "bytes_row_key", "uint32_place", "uint32_is_exposure", "uint32_is_clicked", "uint32_pic_count", "uint32_read_pic_count", "uint64_read_time" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, StackGallery.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe0.cmd0xbe0.StackGallery
 * JD-Core Version:    0.7.0.1
 */