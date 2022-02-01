package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$NumRedRspBody
  extends MessageMicro<NumRedRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field i_inteval = PBField.initInt32(0);
  public final PBInt32Field i_retcode = PBField.initInt32(0);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumRedBusi> rpt_num_red = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumRedBusi.class);
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "i_retcode", "str_errmsg", "i_inteval", "uint64_uin", "rpt_num_red" }, new Object[] { localInteger, "", localInteger, Long.valueOf(0L), null }, NumRedRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedRspBody
 * JD-Core Version:    0.7.0.1
 */