package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class synclogic$GuildNode
  extends MessageMicro<GuildNode>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field guild_code = PBField.initUInt64(0L);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBBytesField guild_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<synclogic.ChannelNode> rpt_channel_nodes = PBField.initRepeatMessage(synclogic.ChannelNode.class);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "guild_id", "guild_code", "rpt_channel_nodes", "guild_name" }, new Object[] { localLong, localLong, null, localByteStringMicro }, GuildNode.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.synclogic.synclogic.GuildNode
 * JD-Core Version:    0.7.0.1
 */