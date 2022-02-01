package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleEnvHub$Tips
  extends MessageMicro<Tips>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField canExpose = PBField.initBool(false);
  public final PBUInt32Field durationMs = PBField.initUInt32(0);
  public final PBInt32Field id = PBField.initInt32(0);
  public final PBStringField text = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "id", "text", "durationMs", "canExpose" }, new Object[] { localInteger, "", localInteger, Boolean.valueOf(false) }, Tips.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleEnvHub.Tips
 * JD-Core Version:    0.7.0.1
 */