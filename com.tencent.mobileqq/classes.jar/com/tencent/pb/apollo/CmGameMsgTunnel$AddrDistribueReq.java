package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CmGameMsgTunnel$AddrDistribueReq
  extends MessageMicro<AddrDistribueReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "appid", "net_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AddrDistribueReq.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt32Field net_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.apollo.CmGameMsgTunnel.AddrDistribueReq
 * JD-Core Version:    0.7.0.1
 */