package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class servtype$GuildInfoFilter
  extends MessageMicro<GuildInfoFilter>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_admin_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_admin_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_change_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_face_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_guild_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_guild_info_change_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_guild_name = PBField.initUInt32(0);
  public final PBUInt32Field uint32_guild_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_guild_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_change_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_owner_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile = PBField.initUInt32(0);
  public final PBUInt32Field uint32_robot_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_robot_max_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 40016, 40024, 40032 }, new String[] { "uint32_guild_code", "uint32_owner_id", "uint32_create_time", "uint32_member_max_num", "uint32_member_num", "uint32_guild_type", "uint32_guild_name", "uint32_robot_list", "uint32_admin_list", "uint32_robot_max_num", "uint32_admin_max_num", "uint32_profile", "uint32_face_seq", "uint32_guild_status", "uint32_channel_num", "uint32_member_change_seq", "uint32_guild_info_change_seq", "uint32_channel_change_seq" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, GuildInfoFilter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.GuildInfoFilter
 * JD-Core Version:    0.7.0.1
 */