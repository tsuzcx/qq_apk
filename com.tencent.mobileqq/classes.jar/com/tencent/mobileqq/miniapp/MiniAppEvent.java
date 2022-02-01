package com.tencent.mobileqq.miniapp;

import com.tencent.biz.qqstory.base.BaseEvent;

public class MiniAppEvent
  extends BaseEvent
{
  public MiniAppInfo a;
  public boolean b;
  public int c;
  public String d;
  public Object[] e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppEvent {, isSuccess=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", src=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppEvent
 * JD-Core Version:    0.7.0.1
 */