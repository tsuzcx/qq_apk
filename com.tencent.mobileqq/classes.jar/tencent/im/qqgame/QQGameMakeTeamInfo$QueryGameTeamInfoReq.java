package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQGameMakeTeamInfo$QueryGameTeamInfoReq
  extends MessageMicro<QueryGameTeamInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "teams" }, new Object[] { null }, QueryGameTeamInfoReq.class);
  public final PBRepeatMessageField<QQGameMakeTeamInfo.TeamBase> teams = PBField.initRepeatMessage(QQGameMakeTeamInfo.TeamBase.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.qqgame.QQGameMakeTeamInfo.QueryGameTeamInfoReq
 * JD-Core Version:    0.7.0.1
 */