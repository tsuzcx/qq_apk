package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleInvite$GetActInviteCircleRsp
  extends MessageMicro<GetActInviteCircleRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "userinfo", "leftQuota" }, new Object[] { null, null, Integer.valueOf(0) }, GetActInviteCircleRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field leftQuota = PBField.initInt32(0);
  public final PBRepeatMessageField<QQCircleInvite.StInviteUser> userinfo = PBField.initRepeatMessage(QQCircleInvite.StInviteUser.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleInvite.GetActInviteCircleRsp
 * JD-Core Version:    0.7.0.1
 */