package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class gallery_report$GallerySocialReported
  extends MessageMicro<GallerySocialReported>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field action = PBField.initInt32(0);
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField client_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_read_end = PBField.initUInt32(0);
  public final PBUInt32Field phone_type = PBField.initUInt32(0);
  public final PBUInt32Field pos = PBField.initUInt32(0);
  public final PBBytesField proxy_bytes = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field share_state = PBField.initInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 42, 88, 96, 106, 112, 120, 402 }, new String[] { "phone_type", "client_ver", "source", "city", "pos", "is_read_end", "rowkey", "share_state", "action", "proxy_bytes" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, GallerySocialReported.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery_report.GallerySocialReported
 * JD-Core Version:    0.7.0.1
 */