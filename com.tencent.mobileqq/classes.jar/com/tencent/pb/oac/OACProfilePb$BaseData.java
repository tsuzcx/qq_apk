package com.tencent.pb.oac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OACProfilePb$BaseData
  extends MessageMicro<BaseData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field account_flag = PBField.initUInt32(0);
  public final PBUInt64Field account_flag2 = PBField.initUInt64(0L);
  public final PBUInt64Field account_flag3 = PBField.initUInt64(0L);
  public final PBUInt32Field account_type = PBField.initUInt32(0);
  public final PBStringField display_number = PBField.initString("");
  public final PBUInt32Field follow_type = PBField.initUInt32(0);
  public final PBBoolField is_recv_msg = PBField.initBool(false);
  public final PBBoolField is_recv_push = PBField.initBool(false);
  public final PBBoolField is_show_follow_button = PBField.initBool(false);
  public final PBStringField name = PBField.initString("");
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBStringField summary = PBField.initString("");
  public final PBStringField unified_account_descrpition = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Boolean localBoolean = Boolean.valueOf(false);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 240, 248, 256 }, new String[] { "puin", "name", "display_number", "summary", "unified_account_descrpition", "is_recv_msg", "is_recv_push", "account_type", "follow_type", "is_show_follow_button", "account_flag", "account_flag2", "account_flag3" }, new Object[] { localLong, "", "", "", "", localBoolean, localBoolean, localInteger, localInteger, localBoolean, localInteger, localLong, localLong }, BaseData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.oac.OACProfilePb.BaseData
 * JD-Core Version:    0.7.0.1
 */