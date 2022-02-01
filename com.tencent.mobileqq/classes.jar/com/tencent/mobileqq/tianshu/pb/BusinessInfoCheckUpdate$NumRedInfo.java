package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BusinessInfoCheckUpdate$NumRedInfo
  extends MessageMicro<NumRedInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBInt32Field appset = PBField.initInt32(0);
  public final PBStringField extend = PBField.initString("");
  public final PBBoolField flag = PBField.initBool(false);
  public final PBUInt32Field modify_ts = PBField.initUInt32(0);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumRedPath> num_red_path = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumRedPath.class);
  public final PBUInt32Field red_total_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58 }, new String[] { "appid", "flag", "modify_ts", "num_red_path", "appset", "red_total_num", "extend" }, new Object[] { localInteger, Boolean.valueOf(false), localInteger, null, localInteger, localInteger, "" }, NumRedInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedInfo
 * JD-Core Version:    0.7.0.1
 */