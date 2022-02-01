package tencent.im.oidb.cmd0xe94;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xe94$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytesDocid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64GroupCode = PBField.initUInt64(0L);
  public final PBUInt64Field uint64Uid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64Uid", "uint64GroupCode", "bytesDocid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe94.oidb_cmd0xe94.ReqBody
 * JD-Core Version:    0.7.0.1
 */