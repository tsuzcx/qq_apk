package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xaa$GameTeam_TurnOverMessage
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48, 56, 64, 72, 80, 88, 98, 104, 114 }, new String[] { "str_teamId", "uint32_sessionType", "str_sourceUin", "str_actionUin", "actionType", "uint32_currentCount", "uint32_totalCount", "uint64_createMsgTime", "uint32_status", "uint32_expire", "uint64_buildTeamTime", "str_leaderUin", "uin32_leaderStatus", "InviteSourceList" }, new Object[] { "", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), null }, GameTeam_TurnOverMessage.class);
  public final PBRepeatMessageField InviteSourceList = PBField.initRepeatMessage(SubMsgType0xaa.InviteSource.class);
  public final PBUInt32Field actionType = PBField.initUInt32(0);
  public final PBStringField str_actionUin = PBField.initString("");
  public final PBStringField str_leaderUin = PBField.initString("");
  public final PBStringField str_sourceUin = PBField.initString("");
  public final PBStringField str_teamId = PBField.initString("");
  public final PBUInt32Field uin32_leaderStatus = PBField.initUInt32(0);
  public final PBUInt32Field uint32_currentCount = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expire = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sessionType = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_totalCount = PBField.initUInt32(0);
  public final PBUInt64Field uint64_buildTeamTime = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_createMsgTime = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_TurnOverMessage
 * JD-Core Version:    0.7.0.1
 */