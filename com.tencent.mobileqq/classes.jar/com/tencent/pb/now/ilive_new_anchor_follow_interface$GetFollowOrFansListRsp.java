package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_new_anchor_follow_interface$GetFollowOrFansListRsp
  extends MessageMicro
{
  public static final int ERRCODE_CHECK_FANS_STATUS_ERR = 6;
  public static final int ERRCODE_CHECK_FOLLOW_STATUS_ERR = 5;
  public static final int ERRCODE_GET_LIST_ERR = 2;
  public static final int ERRCODE_GET_MEDAL_INFO_ERR = 8;
  public static final int ERRCODE_GET_SUBSCRIBE_ERR = 4;
  public static final int ERRCODE_GET_USER_HEADING_ERR = 7;
  public static final int ERRCODE_GET_USER_INFO_ERR = 3;
  public static final int ERRCODE_REQ_PARAM_ERR = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 82 }, new String[] { "type", "userInfoList", "is_subscribe", "uint32_total", "uint32_end_flag", "result", "is_open_sound", "is_open_vibration", "is_ios_push", "err_msg" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, GetFollowOrFansListRsp.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field is_ios_push = PBField.initUInt32(0);
  public final PBUInt32Field is_open_sound = PBField.initUInt32(0);
  public final PBUInt32Field is_open_vibration = PBField.initUInt32(0);
  public final PBUInt32Field is_subscribe = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total = PBField.initUInt32(0);
  public final PBRepeatMessageField userInfoList = PBField.initRepeatMessage(ilive_new_anchor_follow_interface.UserInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_new_anchor_follow_interface.GetFollowOrFansListRsp
 * JD-Core Version:    0.7.0.1
 */