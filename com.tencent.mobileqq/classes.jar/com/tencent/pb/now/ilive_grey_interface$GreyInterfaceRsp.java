package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_grey_interface$GreyInterfaceRsp
  extends MessageMicro<GreyInterfaceRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret_code", "err_msg", "result" }, new Object[] { Integer.valueOf(0), "", "" }, GreyInterfaceRsp.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBStringField result = PBField.initString("");
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_grey_interface.GreyInterfaceRsp
 * JD-Core Version:    0.7.0.1
 */