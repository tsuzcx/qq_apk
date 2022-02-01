package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqconnect$QunProRobotAppInfo
  extends MessageMicro<QunProRobotAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "token", "callback_url" }, new Object[] { "", "" }, QunProRobotAppInfo.class);
  public final PBStringField callback_url = PBField.initString("");
  public final PBStringField token = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.QunProRobotAppInfo
 * JD-Core Version:    0.7.0.1
 */