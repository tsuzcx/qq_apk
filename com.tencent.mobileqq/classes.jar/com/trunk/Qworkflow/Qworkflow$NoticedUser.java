package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$NoticedUser
  extends MessageMicro<NoticedUser>
{
  public static final int ACCEPTED = 2;
  public static final int UNHANDLED = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_uin", "msg_user_source", "enum_handle_state" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(1) }, NoticedUser.class);
  public final PBEnumField enum_handle_state = PBField.initEnum(1);
  public Qworkflow.UserSource msg_user_source = new Qworkflow.UserSource();
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.NoticedUser
 * JD-Core Version:    0.7.0.1
 */