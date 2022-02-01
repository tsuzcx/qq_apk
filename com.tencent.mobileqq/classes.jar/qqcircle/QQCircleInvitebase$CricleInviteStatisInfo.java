package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleInvitebase$CricleInviteStatisInfo
  extends MessageMicro<CricleInviteStatisInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "inviteID", "inviteuin", "inviteTime" }, new Object[] { "", "", Long.valueOf(0L) }, CricleInviteStatisInfo.class);
  public final PBStringField inviteID = PBField.initString("");
  public final PBInt64Field inviteTime = PBField.initInt64(0L);
  public final PBStringField inviteuin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleInvitebase.CricleInviteStatisInfo
 * JD-Core Version:    0.7.0.1
 */