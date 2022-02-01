package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameMsgGreeting$QueryGreetCardRequest
  extends MessageMicro<QueryGreetCardRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField appid = PBField.initString("");
  public final PBInt32Field area = PBField.initInt32(0);
  public final PBStringField fromOpenid = PBField.initString("");
  public final PBInt32Field partition = PBField.initInt32(0);
  public final PBInt32Field platid = PBField.initInt32(0);
  public final PBStringField scene = PBField.initString("");
  public final PBStringField toOpenid = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58 }, new String[] { "fromOpenid", "toOpenid", "area", "partition", "platid", "appid", "scene" }, new Object[] { "", "", localInteger, localInteger, localInteger, "", "" }, QueryGreetCardRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryGreetCardRequest
 * JD-Core Version:    0.7.0.1
 */