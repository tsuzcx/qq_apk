package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleDitto$StDividingLine
  extends MessageMicro<StDividingLine>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "summary", "buttonInfo" }, new Object[] { "", null }, StDividingLine.class);
  public QQCircleDitto.StButton buttonInfo = new QQCircleDitto.StButton();
  public final PBStringField summary = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleDitto.StDividingLine
 * JD-Core Version:    0.7.0.1
 */