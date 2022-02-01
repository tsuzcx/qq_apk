package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class gallery_report$GalleryClickReported
  extends MessageMicro<GalleryClickReported>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field clicktime = PBField.initUInt64(0L);
  public final PBBytesField client_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field go_away_time = PBField.initUInt64(0L);
  public final PBUInt32Field is_read_end = PBField.initUInt32(0);
  public final PBUInt32Field is_read_repeaded = PBField.initUInt32(0);
  public final PBFloatField mem_size = PBField.initFloat(0.0F);
  public final PBUInt64Field no_use_time = PBField.initUInt64(0L);
  public final PBRepeatMessageField<gallery_report.OnePicReported> one_pic_reported = PBField.initRepeatMessage(gallery_report.OnePicReported.class);
  public final PBUInt32Field phone_type = PBField.initUInt32(0);
  public final PBUInt32Field pic_num = PBField.initUInt32(0);
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 37, 42, 48, 56, 64, 74, 80, 88, 96, 106, 112, 402 }, new String[] { "phone_type", "client_ver", "source", "mem_size", "city", "clicktime", "go_away_time", "no_use_time", "one_pic_reported", "pic_num", "pos", "is_read_end", "rowkey", "is_read_repeaded", "proxy_bytes" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Float.valueOf(0.0F), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4 }, GalleryClickReported.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery_report.GalleryClickReported
 * JD-Core Version:    0.7.0.1
 */