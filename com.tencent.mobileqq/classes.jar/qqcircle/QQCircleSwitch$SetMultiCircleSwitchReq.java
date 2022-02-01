package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleSwitch$SetMultiCircleSwitchReq
  extends MessageMicro<SetMultiCircleSwitchReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "sws" }, new Object[] { null }, SetMultiCircleSwitchReq.class);
  public final PBRepeatMessageField<QQCircleSwitch.StSwitch> sws = PBField.initRepeatMessage(QQCircleSwitch.StSwitch.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.SetMultiCircleSwitchReq
 * JD-Core Version:    0.7.0.1
 */