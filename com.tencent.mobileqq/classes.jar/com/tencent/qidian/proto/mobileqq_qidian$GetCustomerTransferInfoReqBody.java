package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$GetCustomerTransferInfoReqBody
  extends MessageMicro<GetCustomerTransferInfoReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_mobile_client = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
  public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_qq_uin", "uint64_kfext_uin", "uint32_mobile_client", "uint32_ver_no" }, new Object[] { localLong, localLong, localInteger, localInteger }, GetCustomerTransferInfoReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.GetCustomerTransferInfoReqBody
 * JD-Core Version:    0.7.0.1
 */