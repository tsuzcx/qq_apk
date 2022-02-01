package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleBitmap$SingleResult
  extends MessageMicro<SingleResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "uid", "ret", "value", "strValue" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "" }, SingleResult.class);
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBStringField strValue = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
  public final PBInt32Field value = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleBitmap.SingleResult
 * JD-Core Version:    0.7.0.1
 */