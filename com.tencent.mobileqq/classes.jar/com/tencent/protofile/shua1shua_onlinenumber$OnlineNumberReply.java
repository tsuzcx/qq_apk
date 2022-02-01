package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class shua1shua_onlinenumber$OnlineNumberReply
  extends MessageMicro<OnlineNumberReply>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field interval = PBField.initUInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "ret", "msg", "num", "interval" }, new Object[] { localInteger, "", localInteger, localInteger }, OnlineNumberReply.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protofile.shua1shua_onlinenumber.OnlineNumberReply
 * JD-Core Version:    0.7.0.1
 */