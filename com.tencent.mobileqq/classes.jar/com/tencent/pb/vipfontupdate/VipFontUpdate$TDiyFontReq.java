package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VipFontUpdate$TDiyFontReq
  extends MessageMicro<TDiyFontReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = initFieldMap(new int[] { 10 }, new String[] { "rpt_font_req_info" }, new Object[] { null }, TDiyFontReq.class);
  public final PBRepeatMessageField<VipFontUpdate.TDiyFontReq.TDiyFontReqInfo> rpt_font_req_info = initRepeatMessage(VipFontUpdate.TDiyFontReq.TDiyFontReqInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TDiyFontReq
 * JD-Core Version:    0.7.0.1
 */