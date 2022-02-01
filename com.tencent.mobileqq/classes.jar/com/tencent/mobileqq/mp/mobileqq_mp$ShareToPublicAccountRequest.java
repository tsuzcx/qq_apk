package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$ShareToPublicAccountRequest
  extends MessageMicro<ShareToPublicAccountRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uin", "url", "luin" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L) }, ShareToPublicAccountRequest.class);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBUInt32Field uin = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ShareToPublicAccountRequest
 * JD-Core Version:    0.7.0.1
 */