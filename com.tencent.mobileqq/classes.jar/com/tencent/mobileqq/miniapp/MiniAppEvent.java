package com.tencent.mobileqq.miniapp;

import com.tencent.biz.qqstory.base.BaseEvent;

public class MiniAppEvent
  extends BaseEvent
{
  public int a;
  public MiniAppInfo a;
  public String a;
  public boolean a;
  public Object[] a;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppEvent {, isSuccess=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", src=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppEvent
 * JD-Core Version:    0.7.0.1
 */