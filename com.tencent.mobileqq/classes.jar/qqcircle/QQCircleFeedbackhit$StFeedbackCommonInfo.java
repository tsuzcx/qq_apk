package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleFeedbackhit$StFeedbackCommonInfo
  extends MessageMicro<StFeedbackCommonInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "sourceUin", "feedId", "operationUin", "level", "sourceUinName" }, new Object[] { "", "", "", Integer.valueOf(0), "" }, StFeedbackCommonInfo.class);
  public final PBStringField feedId = PBField.initString("");
  public final PBInt32Field level = PBField.initInt32(0);
  public final PBStringField operationUin = PBField.initString("");
  public final PBStringField sourceUin = PBField.initString("");
  public final PBStringField sourceUinName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedbackhit.StFeedbackCommonInfo
 * JD-Core Version:    0.7.0.1
 */