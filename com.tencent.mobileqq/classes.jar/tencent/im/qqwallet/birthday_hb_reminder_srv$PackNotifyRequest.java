package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class birthday_hb_reminder_srv$PackNotifyRequest
  extends MessageMicro<PackNotifyRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "listid", "send_uin", "recv_uin", "invalid_time", "ts", "sign" }, new Object[] { "", "", "", "", "", "" }, PackNotifyRequest.class);
  public final PBStringField invalid_time = PBField.initString("");
  public final PBStringField listid = PBField.initString("");
  public final PBStringField recv_uin = PBField.initString("");
  public final PBStringField send_uin = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
  public final PBStringField ts = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.birthday_hb_reminder_srv.PackNotifyRequest
 * JD-Core Version:    0.7.0.1
 */