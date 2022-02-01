package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$STAIOFixRecommend
  extends MessageMicro<STAIOFixRecommend>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "u32_pos", "rpt_list" }, new Object[] { Integer.valueOf(0), null }, STAIOFixRecommend.class);
  public final PBRepeatMessageField<EmosmPb.STRecommendTabInfo> rpt_list = PBField.initRepeatMessage(EmosmPb.STRecommendTabInfo.class);
  public final PBUInt32Field u32_pos = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.STAIOFixRecommend
 * JD-Core Version:    0.7.0.1
 */