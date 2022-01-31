package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345$RspBody$FileAttr
  extends MessageMicro<FileAttr>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_file_path = PBField.initString("");
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_owner = PBField.initUInt32(0);
  public final PBUInt32Field uint32_trans_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_uin = PBField.initUInt32(0);
  public final PBUInt64Field uint64_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 74, 82, 88, 96, 104 }, new String[] { "uint64_size", "uint32_ttl", "uint32_download_times", "uint32_owner", "uint32_trans_from", "str_file_path", "bytes_md5", "bytes_sha", "bytes_sha3", "str_file_name", "uint32_create_time", "uint32_modify_time", "uint32_upload_uin" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FileAttr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.RspBody.FileAttr
 * JD-Core Version:    0.7.0.1
 */