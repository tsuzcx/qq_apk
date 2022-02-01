package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.group_pro.comm.common.MsgSeq;

public final class servtype$ChannelInfo
  extends MessageMicro<ChannelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public common.MsgSeq last_cnt_msg_seq = new common.MsgSeq();
  public common.MsgSeq last_msg_seq = new common.MsgSeq();
  public servtype.LiveChannelInfo msg_live_channel_info = new servtype.LiveChannelInfo();
  public servtype.VoiceChannelInfo msg_voice_channel_info = new servtype.VoiceChannelInfo();
  public final PBUInt32Field uint32_banned_speak = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_speak_permission = PBField.initUInt32(0);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_creator_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 90, 98, 114, 122, 128 }, new String[] { "uint64_channel_id", "bytes_channel_name", "uint64_creator_id", "uint64_create_time", "uint64_guild_id", "uint32_msg_notify_type", "uint32_channel_type", "uint32_speak_permission", "last_msg_seq", "last_cnt_msg_seq", "msg_voice_channel_info", "msg_live_channel_info", "uint32_banned_speak" }, new Object[] { localLong, localByteStringMicro, localLong, localLong, localLong, localInteger, localInteger, localInteger, null, null, null, null, localInteger }, ChannelInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.ChannelInfo
 * JD-Core Version:    0.7.0.1
 */