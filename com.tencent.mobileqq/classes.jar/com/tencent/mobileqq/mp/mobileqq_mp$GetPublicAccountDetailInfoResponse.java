package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$GetPublicAccountDetailInfoResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 56, 64, 72, 82, 88, 96, 104, 112, 120, 128, 136, 144, 154, 162, 170, 178, 186, 192 }, new String[] { "ret_info", "seqno", "uin", "name", "display_number", "summary", "is_recv_msg", "is_recv_push", "certified_grade", "config_group_info", "is_show_share_button", "is_show_follow_button", "follow_type", "is_sync_lbs", "group_id", "show_flag", "account_flag", "luin", "config_background_color", "config_background_img", "config_group_info_new", "certified_description", "unified_account_descrpition", "account_flag2" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "", "", "", Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), null, Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", null, "", "", Long.valueOf(0L) }, GetPublicAccountDetailInfoResponse.class);
  public final PBUInt32Field account_flag = PBField.initUInt32(0);
  public final PBUInt64Field account_flag2 = PBField.initUInt64(0L);
  public final PBStringField certified_description = PBField.initString("");
  public final PBUInt32Field certified_grade = PBField.initUInt32(0);
  public final PBStringField config_background_color = PBField.initString("");
  public final PBStringField config_background_img = PBField.initString("");
  public final PBRepeatMessageField config_group_info = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
  public final PBRepeatMessageField config_group_info_new = PBField.initRepeatMessage(mobileqq_mp.ConfigGroupInfo.class);
  public final PBStringField display_number = PBField.initString("");
  public final PBUInt32Field follow_type = PBField.initUInt32(0);
  public final PBUInt32Field group_id = PBField.initUInt32(0);
  public final PBBoolField is_recv_msg = PBField.initBool(false);
  public final PBBoolField is_recv_push = PBField.initBool(false);
  public final PBBoolField is_show_follow_button = PBField.initBool(false);
  public final PBBoolField is_show_share_button = PBField.initBool(false);
  public final PBBoolField is_sync_lbs = PBField.initBool(false);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBStringField name = PBField.initString("");
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt32Field show_flag = PBField.initUInt32(0);
  public final PBStringField summary = PBField.initString("");
  public final PBUInt32Field uin = PBField.initUInt32(0);
  public final PBStringField unified_account_descrpition = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse
 * JD-Core Version:    0.7.0.1
 */