package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StComment;

public final class QQCircleCommentranking$GetTopCommentsRsp
  extends MessageMicro<GetTopCommentsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "commentList" }, new Object[] { null, null }, GetTopCommentsRsp.class);
  public final PBRepeatMessageField<FeedCloudMeta.StComment> commentList = PBField.initRepeatMessage(FeedCloudMeta.StComment.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleCommentranking.GetTopCommentsRsp
 * JD-Core Version:    0.7.0.1
 */