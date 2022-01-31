package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRankinglist$NotifyReq
  extends MessageMicro<NotifyReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40 }, new String[] { "extInfo", "listType", "toUid", "feedid", "cost" }, new Object[] { null, Integer.valueOf(0), "", "", Integer.valueOf(0) }, NotifyReq.class);
  public final PBInt32Field cost = PBField.initInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField feedid = PBField.initString("");
  public final PBInt32Field listType = PBField.initInt32(0);
  public final PBStringField toUid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.NotifyReq
 * JD-Core Version:    0.7.0.1
 */