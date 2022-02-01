package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRelation$StInterFollowListReq
  extends MessageMicro<StInterFollowListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "extInfo", "leftRightKey", "rightRightKey", "num", "attachInfo" }, new Object[] { null, null, null, Integer.valueOf(0), "" }, StInterFollowListReq.class);
  public final PBStringField attachInfo = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public QQCircleRelation.FollowListKeyType leftRightKey = new QQCircleRelation.FollowListKeyType();
  public final PBInt32Field num = PBField.initInt32(0);
  public QQCircleRelation.FollowListKeyType rightRightKey = new QQCircleRelation.FollowListKeyType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleRelation.StInterFollowListReq
 * JD-Core Version:    0.7.0.1
 */