package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleBase$CircleRankingData
  extends MessageMicro<CircleRankingData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "rankDesc", "rankIconUrl", "rankJumpUrl", "backIconUrl", "rankingType", "reportValue" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, CircleRankingData.class);
  public final PBStringField backIconUrl = PBField.initString("");
  public final PBStringField rankDesc = PBField.initString("");
  public final PBStringField rankIconUrl = PBField.initString("");
  public final PBStringField rankJumpUrl = PBField.initString("");
  public final PBInt32Field rankingType = PBField.initInt32(0);
  public final PBInt32Field reportValue = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleBase.CircleRankingData
 * JD-Core Version:    0.7.0.1
 */