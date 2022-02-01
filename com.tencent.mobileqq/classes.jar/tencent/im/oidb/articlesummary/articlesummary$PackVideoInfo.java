package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$PackVideoInfo
  extends MessageMicro<PackVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_third_action = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_third_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_third_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_third_uin_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_third_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 66, 88, 98, 106, 114, 122 }, new String[] { "uint32_busi_type", "bytes_vid", "uint32_width", "uint32_height", "uint32_duration", "uint64_file_size", "bytes_video_url", "bytes_share_url", "uint64_third_uin", "bytes_third_uin_name", "bytes_third_name", "bytes_third_icon", "bytes_third_action" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localInteger, localInteger, localLong, localByteStringMicro2, localByteStringMicro3, localLong, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, PackVideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.PackVideoInfo
 * JD-Core Version:    0.7.0.1
 */