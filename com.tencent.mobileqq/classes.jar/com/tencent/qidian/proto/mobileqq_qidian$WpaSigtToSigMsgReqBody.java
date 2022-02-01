package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$WpaSigtToSigMsgReqBody
  extends MessageMicro<WpaSigtToSigMsgReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sigT_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_sigT_ext", "uint64_kfext_uin" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, WpaSigtToSigMsgReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.WpaSigtToSigMsgReqBody
 * JD-Core Version:    0.7.0.1
 */