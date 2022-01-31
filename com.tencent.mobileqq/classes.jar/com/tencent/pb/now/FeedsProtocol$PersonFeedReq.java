package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedsProtocol$PersonFeedReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "start", "num", "uid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, PersonFeedReq.class);
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.PersonFeedReq
 * JD-Core Version:    0.7.0.1
 */