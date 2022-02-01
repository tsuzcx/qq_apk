package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleBase$CircleAchievement
  extends MessageMicro<CircleAchievement>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field rocket = PBField.initInt32(0);
  public final PBStringField rocketButtonDesc = PBField.initString("");
  public final PBStringField rocketButtonUrl = PBField.initString("");
  public final PBStringField rocketDesc = PBField.initString("");
  public final PBStringField rocketIconUrl = PBField.initString("");
  public final PBStringField rocketTitle = PBField.initString("");
  public final PBInt32Field rocketToast = PBField.initInt32(0);
  public final PBStringField rocketToastUrl = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66 }, new String[] { "rocket", "rocketTitle", "rocketDesc", "rocketToast", "rocketIconUrl", "rocketToastUrl", "rocketButtonDesc", "rocketButtonUrl" }, new Object[] { localInteger, "", "", localInteger, "", "", "", "" }, CircleAchievement.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleBase.CircleAchievement
 * JD-Core Version:    0.7.0.1
 */