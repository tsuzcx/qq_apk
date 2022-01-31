package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$FollowRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "uin", "ext", "account_type", "luin", "type" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, FollowRequest.class);
  public final PBUInt32Field account_type = PBField.initUInt32(0);
  public final PBStringField ext = PBField.initString("");
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest
 * JD-Core Version:    0.7.0.1
 */