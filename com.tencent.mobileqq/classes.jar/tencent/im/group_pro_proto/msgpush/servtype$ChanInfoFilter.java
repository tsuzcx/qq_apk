package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class servtype$ChanInfoFilter
  extends MessageMicro<ChanInfoFilter>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public servtype.LiveChannelInfoFilter msg_live_channel_info_filter = new servtype.LiveChannelInfoFilter();
  public servtype.VoiceChannelInfoFilter msg_voice_channel_info_filter = new servtype.VoiceChannelInfoFilter();
  public final PBUInt32Field uint32_banned_speak = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_name = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_creator_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_guild_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_cnt_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_speak_permission = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 32, 40, 48, 56, 64, 88, 96, 114, 122, 128 }, new String[] { "uint32_channel_name", "uint32_creator_id", "uint32_create_time", "uint32_guild_id", "uint32_msg_notify_type", "uint32_channel_type", "uint32_speak_permission", "uint32_last_msg_seq", "uint32_last_cnt_msg_seq", "msg_voice_channel_info_filter", "msg_live_channel_info_filter", "uint32_banned_speak" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, null, null, localInteger }, ChanInfoFilter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.ChanInfoFilter
 * JD-Core Version:    0.7.0.1
 */