package com.tencent.mobileqq.comment.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xdea$AddBarrageRspBody
  extends MessageMicro<AddBarrageRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret_code", "str_err_msg", "str_wording" }, new Object[] { Integer.valueOf(0), "", "" }, AddBarrageRspBody.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_err_msg = PBField.initString("");
  public final PBStringField str_wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.oidb.oidb_0xdea.AddBarrageRspBody
 * JD-Core Version:    0.7.0.1
 */