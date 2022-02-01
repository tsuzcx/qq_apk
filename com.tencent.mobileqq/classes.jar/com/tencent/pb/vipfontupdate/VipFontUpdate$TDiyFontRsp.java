package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VipFontUpdate$TDiyFontRsp
  extends MessageMicro<TDiyFontRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = initFieldMap(new int[] { 10 }, new String[] { "rpt_font_rsp_info" }, new Object[] { null }, TDiyFontRsp.class);
  public final PBRepeatMessageField<VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo> rpt_font_rsp_info = initRepeatMessage(VipFontUpdate.TDiyFontRsp.TDiyFontRspInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontRsp
 * JD-Core Version:    0.7.0.1
 */