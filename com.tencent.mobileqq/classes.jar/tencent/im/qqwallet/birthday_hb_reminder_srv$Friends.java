package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class birthday_hb_reminder_srv$Friends
  extends MessageMicro<Friends>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "uin", "birthdate" }, new Object[] { "", "" }, Friends.class);
  public final PBStringField birthdate = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.birthday_hb_reminder_srv.Friends
 * JD-Core Version:    0.7.0.1
 */