package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class birthday_hb_reminder_srv$ListQueryReply
  extends MessageMicro<ListQueryReply>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<birthday_hb_reminder_srv.HbList> hb_list = PBField.initRepeatMessage(birthday_hb_reminder_srv.HbList.class);
  public final PBInt32Field pack_count = PBField.initInt32(0);
  public final PBEnumField ret_code = PBField.initEnum(0);
  public final PBStringField ret_msg = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "ret_code", "ret_msg", "pack_count", "hb_list" }, new Object[] { localInteger, "", localInteger, null }, ListQueryReply.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.birthday_hb_reminder_srv.ListQueryReply
 * JD-Core Version:    0.7.0.1
 */