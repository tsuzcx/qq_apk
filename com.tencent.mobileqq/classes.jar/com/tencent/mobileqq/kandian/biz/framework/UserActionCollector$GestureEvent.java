package com.tencent.mobileqq.kandian.biz.framework;

import java.util.ArrayList;

public class UserActionCollector$GestureEvent
{
  public float a;
  public int a;
  public long a;
  public String a;
  public ArrayList<UserActionCollector.FeedScrollStateInfo> a;
  public long b;
  public String b;
  public long c;
  
  public UserActionCollector$GestureEvent(UserActionCollector paramUserActionCollector) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nGestureEvent{direction=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", deltaFromLastScroll=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", scrollDistance=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", scrollMills=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", scrollSpeed=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", scrollDownAndUpCoordinate='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clickCoordinate='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", scrollStateInfos=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.UserActionCollector.GestureEvent
 * JD-Core Version:    0.7.0.1
 */