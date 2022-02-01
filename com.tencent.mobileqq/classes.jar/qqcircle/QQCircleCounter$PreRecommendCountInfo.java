package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleCounter$PreRecommendCountInfo
  extends MessageMicro<PreRecommendCountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "redPointMsgType", "feedInfo", "feedList" }, new Object[] { Integer.valueOf(0), null, null }, PreRecommendCountInfo.class);
  public QQCircleCounter.RecommendRedPointBackupFeedInfo feedInfo = new QQCircleCounter.RecommendRedPointBackupFeedInfo();
  public final PBRepeatMessageField<QQCircleCounter.PreRecommendFeedInfo> feedList = PBField.initRepeatMessage(QQCircleCounter.PreRecommendFeedInfo.class);
  public final PBInt32Field redPointMsgType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleCounter.PreRecommendCountInfo
 * JD-Core Version:    0.7.0.1
 */