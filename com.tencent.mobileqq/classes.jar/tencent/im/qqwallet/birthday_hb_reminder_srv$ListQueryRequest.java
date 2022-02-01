package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class birthday_hb_reminder_srv$ListQueryRequest
  extends MessageMicro<ListQueryRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "uin", "friends" }, new Object[] { "", null }, ListQueryRequest.class);
  public final PBRepeatMessageField<birthday_hb_reminder_srv.Friends> friends = PBField.initRepeatMessage(birthday_hb_reminder_srv.Friends.class);
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.birthday_hb_reminder_srv.ListQueryRequest
 * JD-Core Version:    0.7.0.1
 */