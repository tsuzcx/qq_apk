package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCounter$RecommendRedPointBackupFeedInfo
  extends MessageMicro<RecommendRedPointBackupFeedInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "feedId", "createTs", "feedAuthor" }, new Object[] { "", Long.valueOf(0L), "" }, RecommendRedPointBackupFeedInfo.class);
  public final PBInt64Field createTs = PBField.initInt64(0L);
  public final PBStringField feedAuthor = PBField.initString("");
  public final PBStringField feedId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleCounter.RecommendRedPointBackupFeedInfo
 * JD-Core Version:    0.7.0.1
 */