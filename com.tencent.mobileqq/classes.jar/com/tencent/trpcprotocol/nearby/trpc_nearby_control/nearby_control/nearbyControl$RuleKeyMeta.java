package com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearbyControl$RuleKeyMeta
  extends MessageMicro<RuleKeyMeta>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField floatValue = PBField.initFloat(0.0F);
  public final PBBytesField key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field longValue = PBField.initUInt64(0L);
  public final PBBytesField stringValue = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field value_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 37, 40 }, new String[] { "key", "stringValue", "longValue", "floatValue", "value_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Float.valueOf(0.0F), Integer.valueOf(0) }, RuleKeyMeta.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.RuleKeyMeta
 * JD-Core Version:    0.7.0.1
 */