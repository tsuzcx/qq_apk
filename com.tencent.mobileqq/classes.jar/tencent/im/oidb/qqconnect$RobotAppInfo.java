package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqconnect$RobotAppInfo
  extends MessageMicro<RobotAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106, 114 }, new String[] { "callback_url", "callback_addr", "callback_url_test", "callback_addr_test" }, new Object[] { "", "", "", "" }, RobotAppInfo.class);
  public final PBStringField callback_addr = PBField.initString("");
  public final PBStringField callback_addr_test = PBField.initString("");
  public final PBStringField callback_url = PBField.initString("");
  public final PBStringField callback_url_test = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.RobotAppInfo
 * JD-Core Version:    0.7.0.1
 */