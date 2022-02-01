package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_short_video_label$OpensdkCB
  extends MessageMicro<OpensdkCB>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_fileid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_format = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_json = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_streamid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_videoid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_videourl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 98 }, new String[] { "uint32_start_time", "uint32_end_time", "bytes_streamid", "bytes_fileid", "bytes_videoid", "bytes_videourl", "bytes_format", "bytes_json" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, OpensdkCB.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_short_video_label.OpensdkCB
 * JD-Core Version:    0.7.0.1
 */