package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCounter$PreRecommendFeedInfo
  extends MessageMicro<PreRecommendFeedInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40 }, new String[] { "feedId", "createTs", "feedAuthor", "opUser", "opTs" }, new Object[] { "", Long.valueOf(0L), "", "", Long.valueOf(0L) }, PreRecommendFeedInfo.class);
  public final PBInt64Field createTs = PBField.initInt64(0L);
  public final PBStringField feedAuthor = PBField.initString("");
  public final PBStringField feedId = PBField.initString("");
  public final PBInt64Field opTs = PBField.initInt64(0L);
  public final PBStringField opUser = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleCounter.PreRecommendFeedInfo
 * JD-Core Version:    0.7.0.1
 */