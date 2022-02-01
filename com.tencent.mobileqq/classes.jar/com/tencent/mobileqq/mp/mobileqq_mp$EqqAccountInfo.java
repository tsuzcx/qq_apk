package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$EqqAccountInfo
  extends MessageMicro<EqqAccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field account_flag = PBField.initUInt64(0L);
  public final PBUInt32Field certified_grade = PBField.initUInt32(0);
  public final PBRepeatMessageField<mobileqq_mp.ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
  public final PBStringField display_number = PBField.initString("");
  public final PBStringField logo = PBField.initString("");
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBStringField name = PBField.initString("");
  public final PBStringField summary = PBField.initString("");
  public final PBUInt32Field uin = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 66, 72 }, new String[] { "uin", "name", "display_number", "summary", "certified_grade", "logo", "luin", "config_group_info", "account_flag" }, new Object[] { localInteger, "", "", "", localInteger, "", localLong, null, localLong }, EqqAccountInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.EqqAccountInfo
 * JD-Core Version:    0.7.0.1
 */