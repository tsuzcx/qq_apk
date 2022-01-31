package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0xbf2$PhoneAddrBook
  extends MessageMicro<PhoneAddrBook>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "str_phone", "str_nick", "str_head_url", "str_long_nick" }, new Object[] { "", "", "", "" }, PhoneAddrBook.class);
  public final PBStringField str_head_url = PBField.initString("");
  public final PBStringField str_long_nick = PBField.initString("");
  public final PBStringField str_nick = PBField.initString("");
  public final PBStringField str_phone = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbf2.PhoneAddrBook
 * JD-Core Version:    0.7.0.1
 */