package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameMsgGreeting$QueryAIOGreetInfoReq
  extends MessageMicro<QueryAIOGreetInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "fromRoleID", "toRoleID" }, new Object[] { "", "" }, QueryAIOGreetInfoReq.class);
  public final PBStringField fromRoleID = PBField.initString("");
  public final PBStringField toRoleID = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryAIOGreetInfoReq
 * JD-Core Version:    0.7.0.1
 */