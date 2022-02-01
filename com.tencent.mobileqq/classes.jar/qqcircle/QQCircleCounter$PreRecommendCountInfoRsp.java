package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCounter$PreRecommendCountInfoRsp
  extends MessageMicro<PreRecommendCountInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "retCode", "errorMsg", "countInfo" }, new Object[] { Integer.valueOf(0), "", null }, PreRecommendCountInfoRsp.class);
  public final PBRepeatMessageField<QQCircleCounter.PreRecommendCountInfo> countInfo = PBField.initRepeatMessage(QQCircleCounter.PreRecommendCountInfo.class);
  public final PBStringField errorMsg = PBField.initString("");
  public final PBInt32Field retCode = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleCounter.PreRecommendCountInfoRsp
 * JD-Core Version:    0.7.0.1
 */