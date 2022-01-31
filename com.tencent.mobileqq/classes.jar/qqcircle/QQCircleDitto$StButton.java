package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleDitto$StButton
  extends MessageMicro<StButton>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "name", "needShow", "jumpUrl", "buttonValue" }, new Object[] { "", Boolean.valueOf(false), "", Integer.valueOf(0) }, StButton.class);
  public final PBUInt32Field buttonValue = PBField.initUInt32(0);
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBBoolField needShow = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleDitto.StButton
 * JD-Core Version:    0.7.0.1
 */