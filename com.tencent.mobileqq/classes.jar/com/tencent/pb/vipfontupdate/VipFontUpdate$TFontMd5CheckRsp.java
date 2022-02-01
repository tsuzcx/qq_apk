package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VipFontUpdate$TFontMd5CheckRsp
  extends MessageMicro<TFontMd5CheckRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_md5_ret" }, new Object[] { null }, TFontMd5CheckRsp.class);
  public final PBRepeatMessageField<VipFontUpdate.TFontMd5CheckRsp.TMd5Ret> rpt_md5_ret = PBField.initRepeatMessage(VipFontUpdate.TFontMd5CheckRsp.TMd5Ret.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckRsp
 * JD-Core Version:    0.7.0.1
 */