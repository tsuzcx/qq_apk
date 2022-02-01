package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class gallery$PictureInfo
  extends MessageMicro<PictureInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cut_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_cut_height = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_cut_width = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_height = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_index = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_width = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 64 }, new String[] { "bytes_pic_url", "bytes_pic_desc", "uint64_index", "uint64_width", "uint64_height", "bytes_cut_pic_url", "uint64_cut_width", "uint64_cut_height" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localLong, localLong, localLong, localByteStringMicro3, localLong, localLong }, PictureInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery.PictureInfo
 * JD-Core Version:    0.7.0.1
 */