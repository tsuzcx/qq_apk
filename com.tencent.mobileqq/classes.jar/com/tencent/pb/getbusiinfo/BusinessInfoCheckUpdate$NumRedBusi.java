package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BusinessInfoCheckUpdate$NumRedBusi
  extends MessageMicro<NumRedBusi>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58 }, new String[] { "uint32_appid", "i_new_flag", "uint32_modify_ts", "rpt_num_red_path", "int32_appset", "uint32_red_total_num", "str_extend" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), "" }, NumRedBusi.class);
  public final PBInt32Field i_new_flag = PBField.initInt32(0);
  public final PBInt32Field int32_appset = PBField.initInt32(0);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumRedPath> rpt_num_red_path = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumRedPath.class);
  public final PBStringField str_extend = PBField.initString("");
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_modify_ts = PBField.initUInt32(0);
  public final PBUInt32Field uint32_red_total_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedBusi
 * JD-Core Version:    0.7.0.1
 */