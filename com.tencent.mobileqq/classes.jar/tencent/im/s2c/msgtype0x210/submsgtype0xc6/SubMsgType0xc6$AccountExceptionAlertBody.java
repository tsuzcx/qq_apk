package tencent.im.s2c.msgtype0x210.submsgtype0xc6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xc6$AccountExceptionAlertBody
  extends MessageMicro<AccountExceptionAlertBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_content = PBField.initString("");
  public final PBStringField str_left_button_text = PBField.initString("");
  public final PBStringField str_right_button_link = PBField.initString("");
  public final PBStringField str_right_button_text = PBField.initString("");
  public final PBStringField str_title = PBField.initString("");
  public final PBUInt32Field uint32_left_button_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_right_button_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56 }, new String[] { "str_title", "str_content", "str_left_button_text", "str_right_button_text", "str_right_button_link", "uint32_left_button_id", "uint32_right_button_id" }, new Object[] { "", "", "", "", "", localInteger, localInteger }, AccountExceptionAlertBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6.AccountExceptionAlertBody
 * JD-Core Version:    0.7.0.1
 */