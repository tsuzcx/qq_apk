package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSwitch$SetCirclePopupSwitchReq
  extends MessageMicro<SetCirclePopupSwitchReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "enable" }, new Object[] { "" }, SetCirclePopupSwitchReq.class);
  public final PBStringField enable = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.SetCirclePopupSwitchReq
 * JD-Core Version:    0.7.0.1
 */