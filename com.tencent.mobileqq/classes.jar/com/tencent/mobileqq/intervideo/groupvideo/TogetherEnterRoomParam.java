package com.tencent.mobileqq.intervideo.groupvideo;

import android.content.Context;
import android.support.annotation.NonNull;

public class TogetherEnterRoomParam
{
  final Context jdField_a_of_type_AndroidContentContext;
  final String jdField_a_of_type_JavaLangString;
  String b = "";
  String c = "";
  String d = "";
  String e;
  String f;
  String g;
  String h;
  
  public TogetherEnterRoomParam(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public void e(String paramString)
  {
    this.g = paramString;
  }
  
  public void f(String paramString)
  {
    this.h = paramString;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" roomId: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" roomGroupCode: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" roomShowNumber: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" fromId: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" openType: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" fromGroupId: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" fromGroupOwnerUin: ");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.TogetherEnterRoomParam
 * JD-Core Version:    0.7.0.1
 */