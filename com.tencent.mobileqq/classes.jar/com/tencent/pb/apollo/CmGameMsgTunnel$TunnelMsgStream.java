package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CmGameMsgTunnel$TunnelMsgStream
  extends MessageMicro<TunnelMsgStream>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busi_buff = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField cmd = PBField.initString("");
  public final PBUInt64Field distribute_ts = PBField.initUInt64(0L);
  public final PBUInt64Field dst_uid = PBField.initUInt64(0L);
  public final PBStringField mqqver = PBField.initString("");
  public final PBStringField msg = PBField.initString("");
  public final PBStringField osver = PBField.initString("");
  public final PBUInt64Field platform = PBField.initUInt64(0L);
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBStringField sign = PBField.initString("");
  public final PBUInt64Field src_uid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 64, 74, 82, 88, 98 }, new String[] { "platform", "osver", "mqqver", "cmd", "seq", "distribute_ts", "src_uid", "dst_uid", "sign", "busi_buff", "ret", "msg" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro, Integer.valueOf(0), "" }, TunnelMsgStream.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.apollo.CmGameMsgTunnel.TunnelMsgStream
 * JD-Core Version:    0.7.0.1
 */