package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobileqq_qidian$GetCustomerTransferInfoRspBody
  extends MessageMicro<GetCustomerTransferInfoRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_ret", "str_transfer_info", "str_link_info", "str_link_url", "str_pt_url" }, new Object[] { null, "", "", "", "" }, GetCustomerTransferInfoRspBody.class);
  public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
  public final PBStringField str_link_info = PBField.initString("");
  public final PBStringField str_link_url = PBField.initString("");
  public final PBStringField str_pt_url = PBField.initString("");
  public final PBStringField str_transfer_info = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.GetCustomerTransferInfoRspBody
 * JD-Core Version:    0.7.0.1
 */