package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$SubCmd0x7Req
  extends MessageMicro<SubCmd0x7Req>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "u32_tab_id", "str_item_id" }, new Object[] { Integer.valueOf(0), "" }, SubCmd0x7Req.class);
  public final PBStringField str_item_id = PBField.initString("");
  public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x7Req
 * JD-Core Version:    0.7.0.1
 */