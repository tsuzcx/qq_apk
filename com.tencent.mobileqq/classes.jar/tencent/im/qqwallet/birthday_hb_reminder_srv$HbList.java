package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class birthday_hb_reminder_srv$HbList
  extends MessageMicro<HbList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field amount = PBField.initInt32(0);
  public final PBStringField arrival_time = PBField.initString("");
  public final PBStringField birthdate = PBField.initString("");
  public final PBStringField create_time = PBField.initString("");
  public final PBStringField listid = PBField.initString("");
  public final PBStringField modify_time = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBEnumField state = PBField.initEnum(0);
  public final PBStringField uin = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66, 74 }, new String[] { "listid", "state", "amount", "uin", "name", "birthdate", "arrival_time", "create_time", "modify_time" }, new Object[] { "", localInteger, localInteger, "", "", "", "", "", "" }, HbList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.birthday_hb_reminder_srv.HbList
 * JD-Core Version:    0.7.0.1
 */