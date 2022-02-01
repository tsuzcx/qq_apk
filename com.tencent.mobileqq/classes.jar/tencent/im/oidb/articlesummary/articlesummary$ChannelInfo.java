package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$ChannelInfo
  extends MessageMicro<ChannelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_channel_display_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_channel_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_topic = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "uint32_channel_id", "uint32_channel_type", "bytes_channel_name", "bytes_channel_display_name", "bytes_channel_url", "uint32_is_topic" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, ChannelInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.ChannelInfo
 * JD-Core Version:    0.7.0.1
 */