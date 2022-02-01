package tencent.im.group_pro_proto.oidb0xfa2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.common.common.Msg;

public final class Oidb0xfa2$ChannelMsg
  extends MessageMicro<ChannelMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBRepeatMessageField<common.Msg> rpt_msgs = PBField.initRepeatMessage(common.Msg.class);
  public final PBUInt64Field rsp_begin_seq = PBField.initUInt64(0L);
  public final PBUInt64Field rsp_end_seq = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "guild_id", "channel_id", "result", "rsp_begin_seq", "rsp_end_seq", "rpt_msgs" }, new Object[] { localLong, localLong, Integer.valueOf(0), localLong, localLong, null }, ChannelMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xfa2.Oidb0xfa2.ChannelMsg
 * JD-Core Version:    0.7.0.1
 */