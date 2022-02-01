package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipFontUpdate$TCheckReq
  extends MessageMicro<TCheckReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field i32_font_id = initInt32(0);
  public final PBInt32Field i32_type = initInt32(0);
  public final PBStringField str_message_test = initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = initFieldMap(new int[] { 8, 16, 26 }, new String[] { "i32_type", "i32_font_id", "str_message_test" }, new Object[] { localInteger, localInteger, "" }, TCheckReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TCheckReq
 * JD-Core Version:    0.7.0.1
 */