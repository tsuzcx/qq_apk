package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleNotify$CircleMessage
  extends MessageMicro<CircleMessage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field action = PBField.initInt32(0);
  public final PBStringField avatarUrl = PBField.initString("");
  public final PBInt32Field circleType = PBField.initInt32(0);
  public final PBStringField emailSuffix = PBField.initString("");
  public final PBStringField msgID = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "circleType", "action", "msgID", "name", "emailSuffix", "avatarUrl" }, new Object[] { localInteger, localInteger, "", "", "", "" }, CircleMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleNotify.CircleMessage
 * JD-Core Version:    0.7.0.1
 */