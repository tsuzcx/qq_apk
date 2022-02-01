package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleSwitch$GetCircleSwitchRsp
  extends MessageMicro<GetCircleSwitchRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "sw" }, new Object[] { null }, GetCircleSwitchRsp.class);
  public QQCircleSwitch.StSwitch sw = new QQCircleSwitch.StSwitch();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.GetCircleSwitchRsp
 * JD-Core Version:    0.7.0.1
 */