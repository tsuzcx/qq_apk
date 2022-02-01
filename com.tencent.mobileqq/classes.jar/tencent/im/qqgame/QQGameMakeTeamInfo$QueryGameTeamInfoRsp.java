package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQGameMakeTeamInfo$QueryGameTeamInfoRsp
  extends MessageMicro<QueryGameTeamInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "teams", "conf" }, new Object[] { null, null }, QueryGameTeamInfoRsp.class);
  public QQGameMakeTeamInfo.Config conf = new QQGameMakeTeamInfo.Config();
  public final PBRepeatMessageField<QQGameMakeTeamInfo.TeamInfo> teams = PBField.initRepeatMessage(QQGameMakeTeamInfo.TeamInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.qqgame.QQGameMakeTeamInfo.QueryGameTeamInfoRsp
 * JD-Core Version:    0.7.0.1
 */