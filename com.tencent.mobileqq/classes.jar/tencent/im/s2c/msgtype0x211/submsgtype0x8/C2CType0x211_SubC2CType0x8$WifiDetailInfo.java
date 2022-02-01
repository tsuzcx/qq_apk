package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class C2CType0x211_SubC2CType0x8$WifiDetailInfo
  extends MessageMicro<WifiDetailInfo>
{
  public static final int BOOL_SELF_ESTABLISH_FIELD_NUMBER = 1;
  public static final int STR_MAC_FIELD_NUMBER = 3;
  public static final int STR_SSID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "bool_self_establish", "str_ssid", "str_mac" }, new Object[] { Boolean.valueOf(false), "", "" }, WifiDetailInfo.class);
  public final PBBoolField bool_self_establish = PBField.initBool(false);
  public final PBStringField str_mac = PBField.initString("");
  public final PBStringField str_ssid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.WifiDetailInfo
 * JD-Core Version:    0.7.0.1
 */