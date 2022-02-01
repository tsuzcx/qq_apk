package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFontUpdate$TFontSsoReq
  extends MessageMicro<TFontSsoReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field i32_implat = initInt32(0);
  public VipFontUpdate.TCheckReq st_check_req = new VipFontUpdate.TCheckReq();
  public VipFontUpdate.TDiyFontReq st_diyfont_req = new VipFontUpdate.TDiyFontReq();
  public VipFontUpdate.TFontFreshReq st_fresh_req = new VipFontUpdate.TFontFreshReq();
  public VipFontUpdate.TGetPosterFontReq st_getposterfont_req = new VipFontUpdate.TGetPosterFontReq();
  public VipFontUpdate.TFontMd5CheckReq st_md5_check_req = new VipFontUpdate.TFontMd5CheckReq();
  public VipFontUpdate.TPosterReq st_poster_req = new VipFontUpdate.TPosterReq();
  public VipFontUpdate.TSetPosterFontReq st_setposterfont_req = new VipFontUpdate.TSetPosterFontReq();
  public final PBStringField str_mqqver = initString("");
  public final PBStringField str_osver = initString("");
  public final PBUInt32Field u32_cmd = initUInt32(0);
  public final PBUInt64Field u64_seq = initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "u32_cmd", "u64_seq", "i32_implat", "str_osver", "str_mqqver", "st_fresh_req", "st_md5_check_req", "st_poster_req", "st_check_req", "st_diyfont_req", "st_getposterfont_req", "st_setposterfont_req" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, "", "", null, null, null, null, null, null, null }, TFontSsoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoReq
 * JD-Core Version:    0.7.0.1
 */