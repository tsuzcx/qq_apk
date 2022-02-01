package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameMsgGreeting$QueryGreetInfoReply
  extends MessageMicro<QueryGreetInfoReply>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "tendencyDesc", "playDateTimeDesc", "expertAreaDesc", "vistorNum" }, new Object[] { "", "", "", Integer.valueOf(0) }, QueryGreetInfoReply.class);
  public final PBStringField expertAreaDesc = PBField.initString("");
  public final PBStringField playDateTimeDesc = PBField.initString("");
  public final PBStringField tendencyDesc = PBField.initString("");
  public final PBInt32Field vistorNum = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryGreetInfoReply
 * JD-Core Version:    0.7.0.1
 */