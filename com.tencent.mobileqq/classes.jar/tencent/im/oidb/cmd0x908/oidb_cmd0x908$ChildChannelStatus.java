package tencent.im.oidb.cmd0x908;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x908$ChildChannelStatus
  extends MessageMicro<ChildChannelStatus>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_channel_header_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_child_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_topic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subscription_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_system_recomm = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48 }, new String[] { "uint32_child_channel_id", "uint32_status", "bytes_channel_header_url", "uint32_subscription_count", "uint32_system_recomm", "uint32_is_topic" }, new Object[] { localInteger, localInteger, localByteStringMicro, localInteger, localInteger, localInteger }, ChildChannelStatus.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x908.oidb_cmd0x908.ChildChannelStatus
 * JD-Core Version:    0.7.0.1
 */