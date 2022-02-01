package com.tencent.trpcprotocol.gamecenter.trpcproxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class TrpcProxy$TrpcMsg
  extends MessageMicro<TrpcMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "clientRPCName", "calleeApp", "calleeServer", "calleeService" }, new Object[] { "", "", "", "" }, TrpcMsg.class);
  public final PBStringField calleeApp = PBField.initString("");
  public final PBStringField calleeServer = PBField.initString("");
  public final PBStringField calleeService = PBField.initString("");
  public final PBStringField clientRPCName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.trpcproxy.TrpcProxy.TrpcMsg
 * JD-Core Version:    0.7.0.1
 */