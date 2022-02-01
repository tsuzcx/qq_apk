package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class EmosmPb$SubCmd0x10MoveOrderReq
  extends MessageMicro<SubCmd0x10MoveOrderReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_tab_id" }, new Object[] { Integer.valueOf(0) }, SubCmd0x10MoveOrderReq.class);
  public final PBRepeatField<Integer> uint32_tab_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x10MoveOrderReq
 * JD-Core Version:    0.7.0.1
 */