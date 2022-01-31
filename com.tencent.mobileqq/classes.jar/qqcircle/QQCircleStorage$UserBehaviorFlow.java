package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleStorage$UserBehaviorFlow
  extends MessageMicro<UserBehaviorFlow>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "records" }, new Object[] { null }, UserBehaviorFlow.class);
  public final PBRepeatMessageField<QQCircleStorage.UserBehaviorRecord> records = PBField.initRepeatMessage(QQCircleStorage.UserBehaviorRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleStorage.UserBehaviorFlow
 * JD-Core Version:    0.7.0.1
 */