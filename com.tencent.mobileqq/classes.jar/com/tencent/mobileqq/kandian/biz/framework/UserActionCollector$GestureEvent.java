package com.tencent.mobileqq.kandian.biz.framework;

import java.util.ArrayList;

public class UserActionCollector$GestureEvent
{
  public int a;
  public long b;
  public long c;
  public long d;
  public float e;
  public String f;
  public String g;
  public ArrayList<UserActionCollector.FeedScrollStateInfo> h;
  
  public UserActionCollector$GestureEvent(UserActionCollector paramUserActionCollector) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nGestureEvent{direction=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", deltaFromLastScroll=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", scrollDistance=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", scrollMills=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", scrollSpeed=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", scrollDownAndUpCoordinate='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clickCoordinate='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", scrollStateInfos=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.UserActionCollector.GestureEvent
 * JD-Core Version:    0.7.0.1
 */