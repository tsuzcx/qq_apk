package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_qidian$GetBusinessMobileRsp
  extends MessageMicro<GetBusinessMobileRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_ret", "str_mobile" }, new Object[] { null, "" }, GetBusinessMobileRsp.class);
  public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
  public final PBStringField str_mobile = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.GetBusinessMobileRsp
 * JD-Core Version:    0.7.0.1
 */