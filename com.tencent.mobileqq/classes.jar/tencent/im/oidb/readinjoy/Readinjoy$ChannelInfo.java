package tencent.im.oidb.readinjoy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Readinjoy$ChannelInfo
  extends MessageMicro<ChannelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_channel_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_channel_id", "uint32_channel_type", "bytes_channel_name", "bytes_channel_url" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2 }, ChannelInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.readinjoy.Readinjoy.ChannelInfo
 * JD-Core Version:    0.7.0.1
 */