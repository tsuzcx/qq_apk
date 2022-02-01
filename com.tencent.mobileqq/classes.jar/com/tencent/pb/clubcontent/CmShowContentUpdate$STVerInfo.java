package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CmShowContentUpdate$STVerInfo
  extends MessageMicro<STVerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field biz_id = PBField.initInt32(0);
  public final PBInt32Field domain_id = PBField.initInt32(0);
  public final PBBytesField down_file = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_patch = PBField.initUInt32(0);
  public final PBInt64Field item_id = PBField.initInt64(0L);
  public final PBBytesField md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public CmShowContentUpdate.STPatchInfo patch_info = new CmShowContentUpdate.STPatchInfo();
  public final PBInt32Field ver = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 56, 66, 72 }, new String[] { "biz_id", "item_id", "name", "ver", "down_file", "md5", "is_patch", "patch_info", "domain_id" }, new Object[] { localInteger, Long.valueOf(0L), localByteStringMicro1, localInteger, localByteStringMicro2, localByteStringMicro3, localInteger, null, localInteger }, STVerInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.clubcontent.CmShowContentUpdate.STVerInfo
 * JD-Core Version:    0.7.0.1
 */