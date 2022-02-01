package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WeiyunPB$DiskSimpleFileItemResult
  extends MessageMicro<DiskSimpleFileItemResult>
{
  public static final int FILE_ID_FIELD_NUMBER = 1;
  public static final int PDIR_KEY_FIELD_NUMBER = 5;
  public static final int PPDIR_KEY_FIELD_NUMBER = 4;
  public static final int RETCODE_FIELD_NUMBER = 2;
  public static final int RETMSG_FIELD_NUMBER = 21;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField file_id = PBField.initString("");
  public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field retcode = PBField.initInt32(0);
  public final PBStringField retmsg = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 34, 42, 170 }, new String[] { "file_id", "retcode", "ppdir_key", "pdir_key", "retmsg" }, new Object[] { "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, "" }, DiskSimpleFileItemResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskSimpleFileItemResult
 * JD-Core Version:    0.7.0.1
 */