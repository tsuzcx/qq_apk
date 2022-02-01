package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Bdh_extinfo$PicInfo
  extends MessageMicro<PicInfo>
{
  public static final int BYTES_BIN_MD5_FIELD_NUMBER = 3;
  public static final int UINT32_IDX_FIELD_NUMBER = 1;
  public static final int UINT32_SIZE_FIELD_NUMBER = 2;
  public static final int UINT32_TYPE_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_bin_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
  public final PBUInt32Field uint32_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_idx", "uint32_size", "bytes_bin_md5", "uint32_type" }, new Object[] { localInteger, localInteger, localByteStringMicro, localInteger }, PicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.PicInfo
 * JD-Core Version:    0.7.0.1
 */