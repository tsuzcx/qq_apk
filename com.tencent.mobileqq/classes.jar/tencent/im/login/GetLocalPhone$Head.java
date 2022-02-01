package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetLocalPhone$Head
  extends MessageMicro<Head>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_account = PBField.initString("");
  public final PBStringField str_err_msg = PBField.initString("");
  public final PBStringField str_guid = PBField.initString("");
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_err_code = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint32_appid", "str_account", "uint32_err_code", "str_err_msg", "str_guid" }, new Object[] { localInteger, "", localInteger, "", "" }, Head.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.login.GetLocalPhone.Head
 * JD-Core Version:    0.7.0.1
 */