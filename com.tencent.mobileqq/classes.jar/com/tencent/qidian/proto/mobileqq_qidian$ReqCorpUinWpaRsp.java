package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_qidian$ReqCorpUinWpaRsp
  extends MessageMicro<ReqCorpUinWpaRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sigmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
  public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_ret", "uint32_aio_type", "bytes_sigmsg" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro }, ReqCorpUinWpaRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.ReqCorpUinWpaRsp
 * JD-Core Version:    0.7.0.1
 */