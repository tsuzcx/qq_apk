package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class QQCirclePay$PayDescription
  extends MessageMicro<PayDescription>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "opTimes" }, new Object[] { Long.valueOf(0L) }, PayDescription.class);
  public final PBRepeatField<Long> opTimes = PBField.initRepeat(PBInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePay.PayDescription
 * JD-Core Version:    0.7.0.1
 */