package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class galleryFeeds$Picture
  extends MessageMicro<Picture>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_height = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_width = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 32, 40 }, new String[] { "bytes_pic_url", "uint64_width", "uint64_height" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L) }, Picture.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.gallery.galleryFeeds.Picture
 * JD-Core Version:    0.7.0.1
 */