package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleInvite$GetCircleInviteRsp
  extends MessageMicro<GetCircleInviteRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "extInfo", "inviteID", "nick", "ticket", "frdFuel" }, new Object[] { null, "", "", "", Integer.valueOf(0) }, GetCircleInviteRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field frdFuel = PBField.initInt32(0);
  public final PBStringField inviteID = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBStringField ticket = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleInvite.GetCircleInviteRsp
 * JD-Core Version:    0.7.0.1
 */