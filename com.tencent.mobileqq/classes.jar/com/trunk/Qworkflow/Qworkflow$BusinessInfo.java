package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class Qworkflow$BusinessInfo
  extends MessageMicro<BusinessInfo>
{
  public static final int JIAXIAO_GROUP = 1;
  public static final int TIM_TODO = 2;
  public static final int UNDEFINED = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_busi_type = PBField.initEnum(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_busi_type", "bytes_userdef" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, BusinessInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.BusinessInfo
 * JD-Core Version:    0.7.0.1
 */