package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$SubCmd0x1ReqDelTab
  extends MessageMicro<SubCmd0x1ReqDelTab>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> rpt_tab_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_tab_id", "rpt_tab_id" }, new Object[] { localInteger, localInteger }, SubCmd0x1ReqDelTab.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x1ReqDelTab
 * JD-Core Version:    0.7.0.1
 */