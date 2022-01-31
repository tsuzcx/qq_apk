package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_new_anchor_follow_interface$SelectFollowAndPayListRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uin", "user_listen_list", "user_pay_list", "ret", "err_msg" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, SelectFollowAndPayListRsp.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBRepeatField user_listen_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField user_pay_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_new_anchor_follow_interface.SelectFollowAndPayListRsp
 * JD-Core Version:    0.7.0.1
 */