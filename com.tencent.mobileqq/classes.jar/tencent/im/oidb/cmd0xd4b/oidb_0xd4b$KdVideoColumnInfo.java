package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd4b$KdVideoColumnInfo
  extends MessageMicro<KdVideoColumnInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_column_intro = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_column_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cover_img = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_img = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field int64_last_update_time = PBField.initInt64(0L);
  public final PBUInt32Field uint32_cover_img_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_special_subscribed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_subscribed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subscribe_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_kd_subscribe_num = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 74, 80, 88, 96 }, new String[] { "uint32_video_column_id", "int64_last_update_time", "uint32_video_num", "uint32_is_subscribed", "uint32_subscribe_num", "bytes_column_title", "bytes_column_intro", "bytes_cover_img", "bytes_icon_img", "uint32_cover_img_style", "uint64_kd_subscribe_num", "uint32_is_special_subscribed" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, KdVideoColumnInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.KdVideoColumnInfo
 * JD-Core Version:    0.7.0.1
 */