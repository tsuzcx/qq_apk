package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameMsgGreeting$GreetReply
  extends MessageMicro<GreetReply>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg", "retCode" }, new Object[] { "", Integer.valueOf(0) }, GreetReply.class);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field retCode = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.GreetReply
 * JD-Core Version:    0.7.0.1
 */