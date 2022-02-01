package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameMsgGreeting$QueryGreetInfoRequest
  extends MessageMicro<QueryGreetInfoRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField appid = PBField.initString("");
  public final PBInt32Field area = PBField.initInt32(0);
  public final PBStringField openid = PBField.initString("");
  public final PBInt32Field partition = PBField.initInt32(0);
  public final PBInt32Field platid = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "openid", "area", "partition", "platid", "appid" }, new Object[] { "", localInteger, localInteger, localInteger, "" }, QueryGreetInfoRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryGreetInfoRequest
 * JD-Core Version:    0.7.0.1
 */