package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QPSingleUpdateProto$FileItem
  extends MessageMicro<FileItem>
{
  public static final int BYTES_HASH_FIELD_NUMBER = 2;
  public static final int BYTES_NAME_FIELD_NUMBER = 1;
  public static final int BYTES_UPDATED_HASH_FIELD_NUMBER = 3;
  public static final int UINT32_NEED_UPDATE_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_hash = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_updated_hash = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_need_update = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_name", "bytes_hash", "bytes_updated_hash", "uint32_need_update" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, FileItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdateProto.FileItem
 * JD-Core Version:    0.7.0.1
 */