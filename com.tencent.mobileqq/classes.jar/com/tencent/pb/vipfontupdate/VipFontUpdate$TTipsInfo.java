package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipFontUpdate$TTipsInfo
  extends MessageMicro<TTipsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "i32_type", "str_msg", "str_title", "str_button", "str_url", "str_vip_type", "str_month", "str_aid" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", "", "" }, TTipsInfo.class);
  public final PBInt32Field i32_type = initInt32(0);
  public final PBStringField str_aid = initString("");
  public final PBStringField str_button = initString("");
  public final PBStringField str_month = initString("");
  public final PBStringField str_msg = initString("");
  public final PBStringField str_title = initString("");
  public final PBStringField str_url = initString("");
  public final PBStringField str_vip_type = initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TTipsInfo
 * JD-Core Version:    0.7.0.1
 */