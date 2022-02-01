package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CmGameMsgTunnel$AddrDistribueRsp
  extends MessageMicro<AddrDistribueRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "port", "ip_list", "aes_key", "distribute_ts", "sign" }, new Object[] { Integer.valueOf(0), "", "", Long.valueOf(0L), "" }, AddrDistribueRsp.class);
  public final PBStringField aes_key = PBField.initString("");
  public final PBUInt64Field distribute_ts = PBField.initUInt64(0L);
  public final PBRepeatField<String> ip_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field port = PBField.initUInt32(0);
  public final PBStringField sign = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.apollo.CmGameMsgTunnel.AddrDistribueRsp
 * JD-Core Version:    0.7.0.1
 */