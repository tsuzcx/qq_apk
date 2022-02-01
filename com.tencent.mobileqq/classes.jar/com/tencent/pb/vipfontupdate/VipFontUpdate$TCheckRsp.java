package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class VipFontUpdate$TCheckRsp
  extends MessageMicro<TCheckRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = initFieldMap(new int[] { 8, 18, 24 }, new String[] { "i32_ret", "st_tips_info", "valid_time" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, TCheckRsp.class);
  public final PBInt32Field i32_ret = initInt32(0);
  public VipFontUpdate.TTipsInfo st_tips_info = new VipFontUpdate.TTipsInfo();
  public final PBInt64Field valid_time = initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TCheckRsp
 * JD-Core Version:    0.7.0.1
 */