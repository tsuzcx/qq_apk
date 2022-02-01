package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQGameMakeTeamInfo$TeamInfo
  extends MessageMicro<TeamInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 66, 72, 82, 794 }, new String[] { "appid", "team_bus_id", "team_id", "status", "icons", "main_text", "sub_text", "jump_url", "tm", "subscribe_id", "msg_seq" }, new Object[] { "", "", "", Integer.valueOf(0), "", "", "", "", Long.valueOf(0L), "", "" }, TeamInfo.class);
  public final PBStringField appid = PBField.initString("");
  public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField main_text = PBField.initString("");
  public final PBStringField msg_seq = PBField.initString("");
  public final PBEnumField status = PBField.initEnum(0);
  public final PBStringField sub_text = PBField.initString("");
  public final PBStringField subscribe_id = PBField.initString("");
  public final PBStringField team_bus_id = PBField.initString("");
  public final PBStringField team_id = PBField.initString("");
  public final PBInt64Field tm = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.qqgame.QQGameMakeTeamInfo.TeamInfo
 * JD-Core Version:    0.7.0.1
 */