package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CSDataHighwayHead$ReqDataHighwayHead
  extends MessageMicro<ReqDataHighwayHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_req_extendinfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public CSDataHighwayHead.DataHighwayHead msg_basehead = new CSDataHighwayHead.DataHighwayHead();
  public CSDataHighwayHead.LoginSigHead msg_login_sig_head = new CSDataHighwayHead.LoginSigHead();
  public CSDataHighwayHead.SegHead msg_seghead = new CSDataHighwayHead.SegHead();
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "msg_basehead", "msg_seghead", "bytes_req_extendinfo", "uint64_timestamp", "msg_login_sig_head" }, new Object[] { null, null, localByteStringMicro, Long.valueOf(0L), null }, ReqDataHighwayHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.ReqDataHighwayHead
 * JD-Core Version:    0.7.0.1
 */