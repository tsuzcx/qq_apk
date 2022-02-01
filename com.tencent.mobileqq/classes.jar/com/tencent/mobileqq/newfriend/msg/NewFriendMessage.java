package com.tencent.mobileqq.newfriend.msg;

import mqq.app.AppRuntime;

public abstract class NewFriendMessage
{
  public String c;
  public long d;
  public boolean e = false;
  
  public String a()
  {
    return "";
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    return false;
  }
  
  public String b(AppRuntime paramAppRuntime)
  {
    return this.c;
  }
  
  public abstract boolean b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.NewFriendMessage
 * JD-Core Version:    0.7.0.1
 */