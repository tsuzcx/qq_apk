package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSwitch$GetCircleSwitchReq
  extends MessageMicro<GetCircleSwitchReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "switchKey" }, new Object[] { "" }, GetCircleSwitchReq.class);
  public final PBStringField switchKey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.GetCircleSwitchReq
 * JD-Core Version:    0.7.0.1
 */