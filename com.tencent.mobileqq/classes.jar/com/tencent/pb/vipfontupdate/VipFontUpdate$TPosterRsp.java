package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VipFontUpdate$TPosterRsp
  extends MessageMicro<TPosterRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "i32_valid", "rpt_mine_list", "rpt_recommend_list" }, new Object[] { Integer.valueOf(0), null, null }, TPosterRsp.class);
  public final PBInt32Field i32_valid = PBField.initInt32(0);
  public final PBRepeatMessageField<VipFontUpdate.TPosterInfo> rpt_mine_list = PBField.initRepeatMessage(VipFontUpdate.TPosterInfo.class);
  public final PBRepeatMessageField<VipFontUpdate.TPosterInfo> rpt_recommend_list = PBField.initRepeatMessage(VipFontUpdate.TPosterInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TPosterRsp
 * JD-Core Version:    0.7.0.1
 */