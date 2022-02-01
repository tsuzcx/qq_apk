package com.tencent.mobileqq.pb;

public final class UserDynamicTab$SetTabListResponse
  extends MessageMicro<SetTabListResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "sequence", "reson_code" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, SetTabListResponse.class);
  public final PBUInt32Field reson_code = PBField.initUInt32(0);
  public final PBUInt64Field sequence = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.UserDynamicTab.SetTabListResponse
 * JD-Core Version:    0.7.0.1
 */