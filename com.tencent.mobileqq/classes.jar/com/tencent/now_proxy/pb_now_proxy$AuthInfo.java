package com.tencent.now_proxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pb_now_proxy$AuthInfo
  extends MessageMicro<AuthInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "original_id", "original_key", "original_id_type" }, new Object[] { "", "", Integer.valueOf(0) }, AuthInfo.class);
  public final PBStringField original_id = PBField.initString("");
  public final PBUInt32Field original_id_type = PBField.initUInt32(0);
  public final PBStringField original_key = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.now_proxy.pb_now_proxy.AuthInfo
 * JD-Core Version:    0.7.0.1
 */