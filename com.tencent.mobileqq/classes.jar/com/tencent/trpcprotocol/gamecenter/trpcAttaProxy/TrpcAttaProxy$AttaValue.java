package com.tencent.trpcprotocol.gamecenter.trpcAttaProxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class TrpcAttaProxy$AttaValue
  extends MessageMicro<AttaValue>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, AttaValue.class);
  public final PBStringField key = PBField.initString("");
  public final PBStringField value = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.trpcAttaProxy.TrpcAttaProxy.AttaValue
 * JD-Core Version:    0.7.0.1
 */