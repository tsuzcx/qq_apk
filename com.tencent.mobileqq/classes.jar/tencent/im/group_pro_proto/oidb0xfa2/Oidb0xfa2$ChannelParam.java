package tencent.im.group_pro_proto.oidb0xfa2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb0xfa2$ChannelParam
  extends MessageMicro<ChannelParam>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field begin_seq = PBField.initUInt64(0L);
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field end_seq = PBField.initUInt64(0L);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBUInt64Field msg_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "guild_id", "channel_id", "begin_seq", "end_seq", "msg_time" }, new Object[] { localLong, localLong, localLong, localLong, localLong }, ChannelParam.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xfa2.Oidb0xfa2.ChannelParam
 * JD-Core Version:    0.7.0.1
 */