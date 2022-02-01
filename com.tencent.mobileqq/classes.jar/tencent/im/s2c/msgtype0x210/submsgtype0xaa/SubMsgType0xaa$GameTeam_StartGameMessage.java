package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xaa$GameTeam_StartGameMessage
  extends MessageMicro<GameTeam_StartGameMessage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_appStoreId = PBField.initString("");
  public final PBStringField str_appid = PBField.initString("");
  public final PBStringField str_gamedata = PBField.initString("");
  public final PBStringField str_packageName = PBField.initString("");
  public final PBStringField str_picUrl = PBField.initString("");
  public final PBStringField str_summary = PBField.initString("");
  public final PBStringField str_title = PBField.initString("");
  public final PBUInt32Field uint32_expire = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platformType = PBField.initUInt32(0);
  public final PBUInt64Field uint64_buildTeamTime = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_createMsgTime = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 66, 72, 80, 88 }, new String[] { "str_gamedata", "uint32_platformType", "str_title", "str_summary", "str_picUrl", "str_appid", "str_appStoreId", "str_packageName", "uint64_createMsgTime", "uint32_expire", "uint64_buildTeamTime" }, new Object[] { "", localInteger, "", "", "", "", "", "", localLong, localInteger, localLong }, GameTeam_StartGameMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_StartGameMessage
 * JD-Core Version:    0.7.0.1
 */