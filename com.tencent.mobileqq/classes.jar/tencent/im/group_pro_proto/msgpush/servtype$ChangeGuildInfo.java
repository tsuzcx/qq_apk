package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.group_pro.comm.common.MsgSeq;

public final class servtype$ChangeGuildInfo
  extends MessageMicro<ChangeGuildInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public common.MsgSeq msg_face_seq = new common.MsgSeq();
  public servtype.GuildInfo msg_guild_info = new servtype.GuildInfo();
  public servtype.GuildInfoFilter msg_guild_info_filter = new servtype.GuildInfoFilter();
  public common.MsgSeq msg_info_seq = new common.MsgSeq();
  public final PBUInt32Field uint32_update_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_operator_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58 }, new String[] { "uint64_guild_id", "uint64_operator_id", "msg_info_seq", "msg_face_seq", "uint32_update_type", "msg_guild_info_filter", "msg_guild_info" }, new Object[] { localLong, localLong, null, null, Integer.valueOf(0), null, null }, ChangeGuildInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.ChangeGuildInfo
 * JD-Core Version:    0.7.0.1
 */