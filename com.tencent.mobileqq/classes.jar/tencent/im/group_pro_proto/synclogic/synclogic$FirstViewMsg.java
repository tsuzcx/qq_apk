package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class synclogic$FirstViewMsg
  extends MessageMicro<FirstViewMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field get_msg_time = PBField.initUInt64(0L);
  public final PBUInt32Field push_flag = PBField.initUInt32(0);
  public final PBRepeatMessageField<synclogic.ChannelMsg> rpt_channel_msgs = PBField.initRepeatMessage(synclogic.ChannelMsg.class);
  public final PBRepeatMessageField<synclogic.GuildNode> rpt_guild_nodes = PBField.initRepeatMessage(synclogic.GuildNode.class);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "push_flag", "seq", "rpt_guild_nodes", "rpt_channel_msgs", "get_msg_time" }, new Object[] { localInteger, localInteger, null, null, Long.valueOf(0L) }, FirstViewMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.synclogic.synclogic.FirstViewMsg
 * JD-Core Version:    0.7.0.1
 */