package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipFontUpdate$TFontFreshRsp
  extends MessageMicro<TFontFreshRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = initFieldMap(new int[] { 8 }, new String[] { "i32_font_type" }, new Object[] { Integer.valueOf(0) }, TFontFreshRsp.class);
  public final PBInt32Field i32_font_type = initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TFontFreshRsp
 * JD-Core Version:    0.7.0.1
 */