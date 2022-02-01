package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class common$ExtInfo
  extends MessageMicro<ExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_member_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field event_version = PBField.initUInt64(0L);
  public final PBRepeatMessageField<common.Event> events = PBField.initRepeatMessage(common.Event.class);
  public final PBBytesField from_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField guild_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field name_type = PBField.initUInt32(0);
  public final PBUInt32Field notify_type = PBField.initUInt32(0);
  public final PBUInt32Field offline_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field visibility = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 66, 72, 80, 90 }, new String[] { "from_nick", "guild_name", "channel_name", "visibility", "notify_type", "offline_flag", "name_type", "bytes_member_name", "uint32_timestamp", "event_version", "events" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger, localInteger, localInteger, localInteger, localByteStringMicro4, localInteger, Long.valueOf(0L), null }, ExtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.common.common.ExtInfo
 * JD-Core Version:    0.7.0.1
 */