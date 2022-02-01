package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleCommentranking$GetCommentRankingListReq
  extends MessageMicro<GetCommentRankingListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 58 }, new String[] { "extInfo", "feedID", "count", "attachInfo", "rankingTypeID", "feedUserID", "friendList" }, new Object[] { null, "", Long.valueOf(0L), "", Integer.valueOf(0), "", "" }, GetCommentRankingListReq.class);
  public final PBStringField attachInfo = PBField.initString("");
  public final PBInt64Field count = PBField.initInt64(0L);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField feedID = PBField.initString("");
  public final PBStringField feedUserID = PBField.initString("");
  public final PBRepeatField<String> friendList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field rankingTypeID = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleCommentranking.GetCommentRankingListReq
 * JD-Core Version:    0.7.0.1
 */