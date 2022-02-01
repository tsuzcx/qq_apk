package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class EmosmPb$SubCmd0x9BqAssocRsp
  extends MessageMicro<SubCmd0x9BqAssocRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_assoc_bqs", "i32_reset_exposure_flag" }, new Object[] { null, Integer.valueOf(0) }, SubCmd0x9BqAssocRsp.class);
  public final PBInt32Field i32_reset_exposure_flag = PBField.initInt32(0);
  public final PBRepeatMessageField<EmosmPb.BqAssocInfo> rpt_assoc_bqs = PBField.initRepeatMessage(EmosmPb.BqAssocInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocRsp
 * JD-Core Version:    0.7.0.1
 */