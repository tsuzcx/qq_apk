package com.tencent.mobileqq.together.writetogether.websocket.msg;

public abstract interface IWriteTogetherMsg<H, B>
{
  public abstract void fromJson(String paramString1, String paramString2);
  
  public abstract String toJson();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.IWriteTogetherMsg
 * JD-Core Version:    0.7.0.1
 */