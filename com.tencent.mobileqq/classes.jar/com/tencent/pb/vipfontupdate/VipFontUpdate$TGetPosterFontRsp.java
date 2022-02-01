package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VipFontUpdate$TGetPosterFontRsp
  extends MessageMicro<TGetPosterFontRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_using_list", "st_redpoint", "i32_recommend_font_id" }, new Object[] { null, null, Integer.valueOf(0) }, TGetPosterFontRsp.class);
  public final PBRepeatField<Integer> i32_recommend_font_id = initRepeat(PBInt32Field.__repeatHelper__);
  public final PBRepeatMessageField<VipFontUpdate.TPosterFontInfo> rpt_using_list = initRepeatMessage(VipFontUpdate.TPosterFontInfo.class);
  public VipFontUpdate.TPosterFontRedPoint st_redpoint = new VipFontUpdate.TPosterFontRedPoint();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TGetPosterFontRsp
 * JD-Core Version:    0.7.0.1
 */