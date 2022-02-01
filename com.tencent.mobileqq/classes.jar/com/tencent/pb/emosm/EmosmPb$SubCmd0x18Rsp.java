package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$SubCmd0x18Rsp
  extends MessageMicro<SubCmd0x18Rsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bool_jump_flag", "uint32_author_id" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0) }, SubCmd0x18Rsp.class);
  public final PBBoolField bool_jump_flag = PBField.initBool(false);
  public final PBUInt32Field uint32_author_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x18Rsp
 * JD-Core Version:    0.7.0.1
 */