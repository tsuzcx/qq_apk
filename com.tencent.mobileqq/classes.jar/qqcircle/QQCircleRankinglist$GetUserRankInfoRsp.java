package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRankinglist$GetUserRankInfoRsp
  extends MessageMicro<GetUserRankInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "uid", "inTopicListCount", "items" }, new Object[] { null, "", Integer.valueOf(0), null }, GetUserRankInfoRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field inTopicListCount = PBField.initInt32(0);
  public final PBRepeatMessageField<QQCircleRankinglist.SimpleRankItem> items = PBField.initRepeatMessage(QQCircleRankinglist.SimpleRankItem.class);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.GetUserRankInfoRsp
 * JD-Core Version:    0.7.0.1
 */