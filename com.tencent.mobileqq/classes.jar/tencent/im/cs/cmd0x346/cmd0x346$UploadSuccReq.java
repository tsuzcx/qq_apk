package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$UploadSuccReq
  extends MessageMicro<UploadSuccReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_fileidcrc = PBField.initString("");
  public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 242, 322 }, new String[] { "uint64_sender_uin", "uint64_recver_uin", "bytes_uuid", "str_fileidcrc" }, new Object[] { localLong, localLong, localByteStringMicro, "" }, UploadSuccReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq
 * JD-Core Version:    0.7.0.1
 */