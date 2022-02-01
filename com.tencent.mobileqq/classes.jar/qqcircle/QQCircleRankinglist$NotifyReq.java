package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRankinglist$NotifyReq
  extends MessageMicro<NotifyReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "extInfo", "listType", "toUid", "feedid", "cost", "feedCreateTime" }, new Object[] { null, Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L) }, NotifyReq.class);
  public final PBInt32Field cost = PBField.initInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt64Field feedCreateTime = PBField.initUInt64(0L);
  public final PBStringField feedid = PBField.initString("");
  public final PBInt32Field listType = PBField.initInt32(0);
  public final PBStringField toUid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.NotifyReq
 * JD-Core Version:    0.7.0.1
 */