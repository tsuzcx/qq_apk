package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipFontUpdate$TFontMd5CheckRsp$TMd5Ret
  extends MessageMicro<TMd5Ret>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field i32_check_font_id = initInt32(0);
  public final PBInt32Field i32_check_ret = initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = initFieldMap(new int[] { 8, 16 }, new String[] { "i32_check_font_id", "i32_check_ret" }, new Object[] { localInteger, localInteger }, TMd5Ret.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckRsp.TMd5Ret
 * JD-Core Version:    0.7.0.1
 */