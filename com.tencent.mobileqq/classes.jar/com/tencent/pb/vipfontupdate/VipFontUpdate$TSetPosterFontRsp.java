package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipFontUpdate$TSetPosterFontRsp
  extends MessageMicro<TSetPosterFontRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "i32_ret", "st_tips_info" }, new Object[] { Integer.valueOf(0), null }, TSetPosterFontRsp.class);
  public final PBInt32Field i32_ret = PBField.initInt32(0);
  public VipFontUpdate.TTipsInfo st_tips_info = new VipFontUpdate.TTipsInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TSetPosterFontRsp
 * JD-Core Version:    0.7.0.1
 */