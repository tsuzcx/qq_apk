package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xac5$NowVideoFeed
  extends MessageMicro<NowVideoFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tnow_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_view_times = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "bytes_cover_url", "bytes_video_url", "uint32_video_duration", "uint32_view_times", "bytes_tnow_video_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localByteStringMicro3 }, NowVideoFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac5.cmd0xac5.NowVideoFeed
 * JD-Core Version:    0.7.0.1
 */