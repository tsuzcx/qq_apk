package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VipFontUpdate$TFontMd5CheckReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_md5_info" }, new Object[] { null }, TFontMd5CheckReq.class);
  public final PBRepeatMessageField rpt_md5_info = PBField.initRepeatMessage(VipFontUpdate.TFontMd5CheckReq.TMd5Info.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckReq
 * JD-Core Version:    0.7.0.1
 */