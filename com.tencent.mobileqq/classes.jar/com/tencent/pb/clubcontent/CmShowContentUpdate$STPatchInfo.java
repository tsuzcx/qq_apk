package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CmShowContentUpdate$STPatchInfo
  extends MessageMicro<STPatchInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field base_ver = PBField.initInt32(0);
  public final PBBytesField down_patch_file = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField patch_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field patch_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "base_ver", "patch_data", "patch_size", "down_patch_file" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, STPatchInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.clubcontent.CmShowContentUpdate.STPatchInfo
 * JD-Core Version:    0.7.0.1
 */