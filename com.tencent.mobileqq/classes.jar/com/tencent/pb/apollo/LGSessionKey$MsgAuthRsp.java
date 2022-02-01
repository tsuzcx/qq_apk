package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class LGSessionKey$MsgAuthRsp
  extends MessageMicro<MsgAuthRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field create_ts = PBField.initUInt64(0L);
  public final PBUInt64Field expired_ts = PBField.initUInt64(0L);
  public final PBBytesField sign = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "create_ts", "expired_ts", "sign" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, MsgAuthRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.apollo.LGSessionKey.MsgAuthRsp
 * JD-Core Version:    0.7.0.1
 */