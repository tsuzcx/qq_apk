package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VaProfileGate$OidbFlagInfo
  extends MessageMicro<OidbFlagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField byets_value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_fieled = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_fieled", "byets_value" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, OidbFlagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate.OidbFlagInfo
 * JD-Core Version:    0.7.0.1
 */