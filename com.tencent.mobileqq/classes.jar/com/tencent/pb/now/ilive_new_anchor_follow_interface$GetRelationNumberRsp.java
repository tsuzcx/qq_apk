package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_new_anchor_follow_interface$GetRelationNumberRsp
  extends MessageMicro
{
  public static final int ERRCODE_BACKEEND_ERR = 2;
  public static final int ERRCODE_REQ_PARAM_ERR = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uin", "follow_count", "fans_count", "result", "err_msg" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, GetRelationNumberRsp.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field fans_count = PBField.initUInt32(0);
  public final PBUInt32Field follow_count = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_new_anchor_follow_interface.GetRelationNumberRsp
 * JD-Core Version:    0.7.0.1
 */