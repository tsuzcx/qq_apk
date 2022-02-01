package com.tencent.mobileqq.together.writetogether.websocket.msg;

import beko;

public class UserChangesReqMsg$UserChangesReqBody
{
  public beko apool;
  public int baseRev;
  public int changeSetCount;
  public String changeset;
  public boolean head;
  public boolean keydata;
  public boolean oSubId;
  public boolean offlineMsg;
  public int pver = 2;
  public String subId = "BB08J2";
  public BaseWriteTogetherMsg.Type type = BaseWriteTogetherMsg.Type.USER_CHANGES;
  public String uuId;
  
  public UserChangesReqMsg$UserChangesReqBody() {}
  
  public UserChangesReqMsg$UserChangesReqBody(int paramInt, String paramString1, beko parambeko, String paramString2)
  {
    this.baseRev = paramInt;
    this.changeset = paramString1;
    this.apool = parambeko;
    this.uuId = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.UserChangesReqMsg.UserChangesReqBody
 * JD-Core Version:    0.7.0.1
 */