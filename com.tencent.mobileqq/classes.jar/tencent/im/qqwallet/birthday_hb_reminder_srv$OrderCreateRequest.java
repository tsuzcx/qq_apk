package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class birthday_hb_reminder_srv$OrderCreateRequest
  extends MessageMicro<OrderCreateRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "listid", "amount", "send_uin", "send_name", "recv_uin", "recv_name", "birthdate", "arrival_time", "ts", "sign" }, new Object[] { "", Long.valueOf(0L), "", "", "", "", "", "", "", "" }, OrderCreateRequest.class);
  public final PBInt64Field amount = PBField.initInt64(0L);
  public final PBStringField arrival_time = PBField.initString("");
  public final PBStringField birthdate = PBField.initString("");
  public final PBStringField listid = PBField.initString("");
  public final PBStringField recv_name = PBField.initString("");
  public final PBStringField recv_uin = PBField.initString("");
  public final PBStringField send_name = PBField.initString("");
  public final PBStringField send_uin = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
  public final PBStringField ts = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.birthday_hb_reminder_srv.OrderCreateRequest
 * JD-Core Version:    0.7.0.1
 */