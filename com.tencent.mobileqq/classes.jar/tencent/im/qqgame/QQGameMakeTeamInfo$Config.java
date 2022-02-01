package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQGameMakeTeamInfo$Config
  extends MessageMicro<Config>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "expire", "max_req_teams", "req_interval" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Config.class);
  public final PBInt32Field expire = PBField.initInt32(0);
  public final PBInt32Field max_req_teams = PBField.initInt32(0);
  public final PBInt32Field req_interval = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.qqgame.QQGameMakeTeamInfo.Config
 * JD-Core Version:    0.7.0.1
 */