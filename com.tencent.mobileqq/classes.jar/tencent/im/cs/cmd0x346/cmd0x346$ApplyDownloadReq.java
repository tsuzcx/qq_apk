package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyDownloadReq
  extends MessageMicro<ApplyDownloadReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_fileid = PBField.initString("");
  public final PBStringField str_fileidcrc = PBField.initString("");
  public final PBUInt32Field uint32_ext_uintype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_filetype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_https_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_owner_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 400, 482, 4000, 4008, 4802 }, new String[] { "uint64_uin", "bytes_uuid", "uint32_owner_type", "uint32_filetype", "str_fileidcrc", "uint32_ext_uintype", "uint32_need_https_url", "str_fileid" }, new Object[] { Long.valueOf(0L), localByteStringMicro, localInteger, localInteger, "", localInteger, localInteger, "" }, ApplyDownloadReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq
 * JD-Core Version:    0.7.0.1
 */