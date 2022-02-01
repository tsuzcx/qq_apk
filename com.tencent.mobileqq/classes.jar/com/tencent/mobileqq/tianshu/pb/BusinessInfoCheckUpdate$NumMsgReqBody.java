package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$NumMsgReqBody
  extends MessageMicro<NumMsgReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field i_proto_ver = PBField.initInt32(0);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumMsgBusi> rpt_num_msg = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumMsgBusi.class);
  public final PBStringField str_client_ver = PBField.initString("");
  public final PBUInt32Field uint32_plat_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "i_proto_ver", "uint32_plat_id", "str_client_ver", "uint64_uin", "rpt_num_msg" }, new Object[] { localInteger, localInteger, "", Long.valueOf(0L), null }, NumMsgReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumMsgReqBody
 * JD-Core Version:    0.7.0.1
 */