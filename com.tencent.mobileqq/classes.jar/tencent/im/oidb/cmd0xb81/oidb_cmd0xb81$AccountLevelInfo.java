package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$AccountLevelInfo
  extends MessageMicro<AccountLevelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField account_cc_level_icon_l = PBField.initString("");
  public final PBStringField account_cc_level_icon_s = PBField.initString("");
  public final PBStringField authorize_desc = PBField.initString("");
  public final PBStringField certified_gear = PBField.initString("");
  public final PBUInt32Field uint32_account_cc_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_certified_classify = PBField.initUInt32(0);
  public final PBUInt32Field uint32_certified_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 40, 50, 58, 66, 72, 80, 90 }, new String[] { "uint32_account_cc_level", "account_cc_level_icon_s", "account_cc_level_icon_l", "authorize_desc", "uint32_certified_type", "uint32_certified_classify", "certified_gear" }, new Object[] { localInteger, "", "", "", localInteger, localInteger, "" }, AccountLevelInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.AccountLevelInfo
 * JD-Core Version:    0.7.0.1
 */