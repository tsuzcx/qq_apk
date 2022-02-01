package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSwitch$GetCirclePopupSwitchRsp
  extends MessageMicro<GetCirclePopupSwitchRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "enable", "popup" }, new Object[] { "", null }, GetCirclePopupSwitchRsp.class);
  public final PBStringField enable = PBField.initString("");
  public QQCircleSwitch.StPopup popup = new QQCircleSwitch.StPopup();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.GetCirclePopupSwitchRsp
 * JD-Core Version:    0.7.0.1
 */