package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StComment;

public final class QQCircleCommentranking$GetCommentRankingListRsp
  extends MessageMicro<GetCommentRankingListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "attachInfo", "hasMore", "comments" }, new Object[] { null, "", Integer.valueOf(0), null }, GetCommentRankingListRsp.class);
  public final PBStringField attachInfo = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudMeta.StComment> comments = PBField.initRepeatMessage(FeedCloudMeta.StComment.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field hasMore = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleCommentranking.GetCommentRankingListRsp
 * JD-Core Version:    0.7.0.1
 */