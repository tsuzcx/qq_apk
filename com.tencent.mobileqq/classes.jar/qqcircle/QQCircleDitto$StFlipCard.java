package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleDitto$StFlipCard
  extends MessageMicro<StFlipCard>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "cardName", "opMask", "cardDetail" }, new Object[] { "", Integer.valueOf(0), null }, StFlipCard.class);
  public QQCircleDitto.StCardDetail cardDetail = new QQCircleDitto.StCardDetail();
  public final PBStringField cardName = PBField.initString("");
  public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleDitto.StFlipCard
 * JD-Core Version:    0.7.0.1
 */