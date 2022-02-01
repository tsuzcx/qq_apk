package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xaa$GameTeam_UpdateTeamMessage
  extends MessageMicro<GameTeam_UpdateTeamMessage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_gameId = PBField.initString("");
  public final PBStringField str_leaderUin = PBField.initString("");
  public final PBStringField str_modeImg = PBField.initString("");
  public final PBStringField str_teamId = PBField.initString("");
  public final PBUInt32Field uin32_leaderStatus = PBField.initUInt32(0);
  public final PBUInt32Field uint32_current_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expire = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_buildTeamTime = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_createMsgTime = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64, 74, 80 }, new String[] { "str_teamId", "str_gameId", "uint32_status", "str_modeImg", "uint32_current_count", "uint64_createMsgTime", "uint32_expire", "uint64_buildTeamTime", "str_leaderUin", "uin32_leaderStatus" }, new Object[] { "", "", localInteger, "", localInteger, localLong, localInteger, localLong, "", localInteger }, GameTeam_UpdateTeamMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_UpdateTeamMessage
 * JD-Core Version:    0.7.0.1
 */