package tencent.im.oidb.cmd0xbc9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xbc9$ContentBannerItem
  extends MessageMicro<ContentBannerItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_image_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_link_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_image_url", "bytes_link_url", "bytes_title", "bytes_rowkey" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ContentBannerItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.ContentBannerItem
 * JD-Core Version:    0.7.0.1
 */