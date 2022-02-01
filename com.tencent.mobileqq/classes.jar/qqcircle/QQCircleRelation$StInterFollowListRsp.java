package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StRelationInfo;

public final class QQCircleRelation$StInterFollowListRsp
  extends MessageMicro<StInterFollowListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "relationInfo", "total", "hasMore", "attachInfo" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0), "" }, StInterFollowListRsp.class);
  public final PBStringField attachInfo = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field hasMore = PBField.initInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StRelationInfo> relationInfo = PBField.initRepeatMessage(FeedCloudMeta.StRelationInfo.class);
  public final PBInt64Field total = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRelation.StInterFollowListRsp
 * JD-Core Version:    0.7.0.1
 */