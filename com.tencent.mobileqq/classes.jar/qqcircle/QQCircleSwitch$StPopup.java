package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSwitch$StPopup
  extends MessageMicro<StPopup>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "title", "tips" }, new Object[] { "", "" }, StPopup.class);
  public final PBStringField tips = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.StPopup
 * JD-Core Version:    0.7.0.1
 */