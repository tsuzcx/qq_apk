package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class EmosmPb$SubCmd0x10MoveOrderRsp
  extends MessageMicro<SubCmd0x10MoveOrderRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_move_detail" }, new Object[] { Integer.valueOf(0) }, SubCmd0x10MoveOrderRsp.class);
  public final PBInt32Field int32_move_detail = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x10MoveOrderRsp
 * JD-Core Version:    0.7.0.1
 */