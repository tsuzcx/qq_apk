package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class GameMsgGreeting$QueryAIOGreetInfoRsp
  extends MessageMicro<QueryAIOGreetInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "greetType", "nextGreetTime" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, QueryAIOGreetInfoRsp.class);
  public final PBInt32Field greetType = PBField.initInt32(0);
  public final PBInt64Field nextGreetTime = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryAIOGreetInfoRsp
 * JD-Core Version:    0.7.0.1
 */