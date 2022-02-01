package com.tencent.trpcprotocol.gamecenter.trpcproxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class TrpcProxy$TrpcListRsp
  extends MessageMicro<TrpcListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "list", "errType", "ret", "msg" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, TrpcListRsp.class);
  public final PBEnumField errType = PBField.initEnum(0);
  public final PBRepeatMessageField<TrpcProxy.TrpcInovkeRsp> list = PBField.initRepeatMessage(TrpcProxy.TrpcInovkeRsp.class);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.trpcproxy.TrpcProxy.TrpcListRsp
 * JD-Core Version:    0.7.0.1
 */