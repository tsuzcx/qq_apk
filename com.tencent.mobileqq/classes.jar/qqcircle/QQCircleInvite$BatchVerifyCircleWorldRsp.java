package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleInvite$BatchVerifyCircleWorldRsp
  extends MessageMicro<BatchVerifyCircleWorldRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "userinfo" }, new Object[] { null, null }, BatchVerifyCircleWorldRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<QQCircleInvite.StCircleUser> userinfo = PBField.initRepeatMessage(QQCircleInvite.StCircleUser.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleInvite.BatchVerifyCircleWorldRsp
 * JD-Core Version:    0.7.0.1
 */