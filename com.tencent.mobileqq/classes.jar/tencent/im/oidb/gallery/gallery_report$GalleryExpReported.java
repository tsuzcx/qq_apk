package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class gallery_report$GalleryExpReported
  extends MessageMicro<GalleryExpReported>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField client_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field exptime = PBField.initUInt64(0L);
  public final PBFloatField mem_size = PBField.initFloat(0.0F);
  public final PBUInt32Field phone_type = PBField.initUInt32(0);
  public final PBUInt32Field pos = PBField.initUInt32(0);
  public final PBBytesField proxy_bytes = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field source = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 37, 42, 48, 56, 66, 402 }, new String[] { "phone_type", "client_ver", "source", "mem_size", "city", "exptime", "pos", "rowkey", "proxy_bytes" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Float.valueOf(0.0F), localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, GalleryExpReported.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery_report.GalleryExpReported
 * JD-Core Version:    0.7.0.1
 */