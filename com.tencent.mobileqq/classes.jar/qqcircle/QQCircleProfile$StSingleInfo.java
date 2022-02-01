package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleProfile$StSingleInfo
  extends MessageMicro<StSingleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "value" }, new Object[] { Integer.valueOf(0), "" }, StSingleInfo.class);
  public final PBEnumField type = PBField.initEnum(0);
  public final PBStringField value = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StSingleInfo
 * JD-Core Version:    0.7.0.1
 */