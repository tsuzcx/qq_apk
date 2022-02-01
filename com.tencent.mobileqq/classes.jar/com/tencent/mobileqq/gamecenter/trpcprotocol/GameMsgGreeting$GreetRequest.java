package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameMsgGreeting$GreetRequest
  extends MessageMicro<GreetRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 42 }, new String[] { "appid", "scene" }, new Object[] { "", "" }, GreetRequest.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField scene = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.GreetRequest
 * JD-Core Version:    0.7.0.1
 */