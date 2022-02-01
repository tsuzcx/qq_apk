package com.tencent.mobileqq.writetogether.websocket.msg;

import com.tencent.mobileqq.easysync2.AttribPool;

public class UserChangesReqMsg$UserChangesReqBody
{
  public AttribPool apool;
  public int baseRev;
  public int changeSetCount;
  public String changeset;
  public boolean head;
  public boolean keydata;
  public boolean oSubId;
  public boolean offlineMsg;
  public int pver = 2;
  public String subId = "BB08J2";
  public Type type = Type.USER_CHANGES;
  public String uuId;
  
  public UserChangesReqMsg$UserChangesReqBody() {}
  
  public UserChangesReqMsg$UserChangesReqBody(int paramInt, String paramString1, AttribPool paramAttribPool, String paramString2)
  {
    this.baseRev = paramInt;
    this.changeset = paramString1;
    this.apool = paramAttribPool;
    this.uuId = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.UserChangesReqMsg.UserChangesReqBody
 * JD-Core Version:    0.7.0.1
 */