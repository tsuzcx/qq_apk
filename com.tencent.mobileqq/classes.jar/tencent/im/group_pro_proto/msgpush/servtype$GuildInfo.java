package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.group_pro.comm.common.MsgSeq;

public final class servtype$GuildInfo
  extends MessageMicro<GuildInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_guild_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_profile = PBField.initBytes(ByteStringMicro.EMPTY);
  public common.MsgSeq msg_channel_change_seq = new common.MsgSeq();
  public common.MsgSeq msg_guild_info_change_seq = new common.MsgSeq();
  public servtype.GroupProStatus msg_guild_status = new servtype.GroupProStatus();
  public common.MsgSeq msg_member_change_seq = new common.MsgSeq();
  public final PBRepeatField<Long> rpt_admin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_robot_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_admin_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_guild_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_robot_max_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_face_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_guild_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_owner_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 32, 40, 48, 56, 66, 72, 80, 88, 96, 106, 112, 122, 128, 40018, 40026, 40034 }, new String[] { "uint64_guild_code", "uint64_owner_id", "uint64_create_time", "uint32_member_max_num", "uint32_member_num", "uint32_guild_type", "bytes_guild_name", "rpt_robot_list", "rpt_admin_list", "uint32_robot_max_num", "uint32_admin_max_num", "bytes_profile", "uint64_face_seq", "msg_guild_status", "uint32_channel_num", "msg_member_change_seq", "msg_guild_info_change_seq", "msg_channel_change_seq" }, new Object[] { localLong, localLong, localLong, localInteger, localInteger, localInteger, localByteStringMicro1, localLong, localLong, localInteger, localInteger, localByteStringMicro2, localLong, null, localInteger, null, null, null }, GuildInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.GuildInfo
 * JD-Core Version:    0.7.0.1
 */