package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserSetDynamicPlugin$SetListResponse
  extends MessageMicro<SetListResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "sequence", "reson_code" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, SetListResponse.class);
  public final PBUInt32Field reson_code = PBField.initUInt32(0);
  public final PBUInt64Field sequence = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin.SetListResponse
 * JD-Core Version:    0.7.0.1
 */