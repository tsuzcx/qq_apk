package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQGameMakeTeamInfo$TeamBase
  extends MessageMicro<TeamBase>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 794 }, new String[] { "appid", "team_bus_id", "team_id", "captain", "tm", "ark_meta", "msg_seq" }, new Object[] { "", "", "", null, Long.valueOf(0L), "", "" }, TeamBase.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField ark_meta = PBField.initString("");
  public QQGameMakeTeamInfo.PersonalInfo captain = new QQGameMakeTeamInfo.PersonalInfo();
  public final PBStringField msg_seq = PBField.initString("");
  public final PBStringField team_bus_id = PBField.initString("");
  public final PBStringField team_id = PBField.initString("");
  public final PBInt64Field tm = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.qqgame.QQGameMakeTeamInfo.TeamBase
 * JD-Core Version:    0.7.0.1
 */