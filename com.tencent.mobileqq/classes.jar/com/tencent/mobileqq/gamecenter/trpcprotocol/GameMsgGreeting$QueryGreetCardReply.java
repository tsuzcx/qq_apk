package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameMsgGreeting$QueryGreetCardReply
  extends MessageMicro<QueryGreetCardReply>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field allowFriendGreeting = PBField.initInt32(0);
  public final PBInt32Field allowFriendVisitProfile = PBField.initInt32(0);
  public final PBInt32Field allowStrangerGreeting = PBField.initInt32(0);
  public final PBInt32Field allowStrangerVisitProfile = PBField.initInt32(0);
  public final PBInt32Field isShowUserGuide = PBField.initInt32(0);
  public final PBStringField noticeInfo = PBField.initString("");
  public final PBInt32Field noticeType = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56 }, new String[] { "allowFriendGreeting", "allowStrangerGreeting", "allowFriendVisitProfile", "allowStrangerVisitProfile", "noticeType", "noticeInfo", "isShowUserGuide" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, "", localInteger }, QueryGreetCardReply.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryGreetCardReply
 * JD-Core Version:    0.7.0.1
 */