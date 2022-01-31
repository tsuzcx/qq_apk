package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFontUpdate$TFontSsoRsp
  extends MessageMicro<TFontSsoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 66, 82, 90, 98 }, new String[] { "i32_ret", "str_msg", "u32_cmd", "u64_seq", "st_fresh_rsp", "st_md5_check_rsp", "st_poster_rsp", "st_check_rsp", "st_diyfont_rsp", "st_getposterfont_rsp", "st_setposterfont_rsp" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), null, null, null, null, null, null, null }, TFontSsoRsp.class);
  public final PBInt32Field i32_ret = PBField.initInt32(0);
  public VipFontUpdate.TCheckRsp st_check_rsp = new VipFontUpdate.TCheckRsp();
  public VipFontUpdate.TDiyFontRsp st_diyfont_rsp = new VipFontUpdate.TDiyFontRsp();
  public VipFontUpdate.TFontFreshRsp st_fresh_rsp = new VipFontUpdate.TFontFreshRsp();
  public VipFontUpdate.TGetPosterFontRsp st_getposterfont_rsp = new VipFontUpdate.TGetPosterFontRsp();
  public VipFontUpdate.TFontMd5CheckRsp st_md5_check_rsp = new VipFontUpdate.TFontMd5CheckRsp();
  public VipFontUpdate.TPosterRsp st_poster_rsp = new VipFontUpdate.TPosterRsp();
  public VipFontUpdate.TSetPosterFontRsp st_setposterfont_rsp = new VipFontUpdate.TSetPosterFontRsp();
  public final PBStringField str_msg = PBField.initString("");
  public final PBUInt32Field u32_cmd = PBField.initUInt32(0);
  public final PBUInt64Field u64_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoRsp
 * JD-Core Version:    0.7.0.1
 */