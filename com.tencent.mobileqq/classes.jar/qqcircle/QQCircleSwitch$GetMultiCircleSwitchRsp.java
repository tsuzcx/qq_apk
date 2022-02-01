package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleSwitch$GetMultiCircleSwitchRsp
  extends MessageMicro<GetMultiCircleSwitchRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "sws" }, new Object[] { null }, GetMultiCircleSwitchRsp.class);
  public final PBRepeatMessageField<QQCircleSwitch.StSwitch> sws = PBField.initRepeatMessage(QQCircleSwitch.StSwitch.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.GetMultiCircleSwitchRsp
 * JD-Core Version:    0.7.0.1
 */