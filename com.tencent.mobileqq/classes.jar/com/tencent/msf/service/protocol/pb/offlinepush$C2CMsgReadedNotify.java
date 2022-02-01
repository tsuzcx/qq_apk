package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class offlinepush$C2CMsgReadedNotify
  extends MessageMicro
{
  public static final int LLASTREADTIME_FIELD_NUMBER = 2;
  public static final int LPEERUIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field lLastReadTime = PBField.initUInt64(0L);
  public final PBUInt64Field lPeerUin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "lPeerUin", "lLastReadTime" }, new Object[] { localLong, localLong }, C2CMsgReadedNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.offlinepush.C2CMsgReadedNotify
 * JD-Core Version:    0.7.0.1
 */