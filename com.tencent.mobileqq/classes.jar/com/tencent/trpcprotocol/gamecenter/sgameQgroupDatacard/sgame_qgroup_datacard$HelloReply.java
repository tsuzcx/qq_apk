package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class sgame_qgroup_datacard$HelloReply
  extends MessageMicro<HelloReply>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg" }, new Object[] { "" }, HelloReply.class);
  public final PBStringField msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.HelloReply
 * JD-Core Version:    0.7.0.1
 */