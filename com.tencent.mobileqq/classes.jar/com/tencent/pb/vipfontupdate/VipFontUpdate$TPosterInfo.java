package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipFontUpdate$TPosterInfo
  extends MessageMicro<TPosterInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = initFieldMap(new int[] { 8, 18, 26 }, new String[] { "i32_font_id", "str_img_url", "str_tag_url" }, new Object[] { Integer.valueOf(0), "", "" }, TPosterInfo.class);
  public final PBInt32Field i32_font_id = initInt32(0);
  public final PBStringField str_img_url = initString("");
  public final PBStringField str_tag_url = initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TPosterInfo
 * JD-Core Version:    0.7.0.1
 */