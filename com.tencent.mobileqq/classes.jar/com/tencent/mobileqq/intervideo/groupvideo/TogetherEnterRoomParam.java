package com.tencent.mobileqq.intervideo.groupvideo;

import android.content.Context;
import android.support.annotation.NonNull;

public class TogetherEnterRoomParam
{
  final Context a;
  final String b;
  String c = "";
  String d = "";
  String e = "";
  String f;
  String g;
  String h;
  String i;
  
  public TogetherEnterRoomParam(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public void d(String paramString)
  {
    this.f = paramString;
  }
  
  public void e(String paramString)
  {
    this.h = paramString;
  }
  
  public void f(String paramString)
  {
    this.i = paramString;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" roomId: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" roomGroupCode: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" roomShowNumber: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" fromId: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" openType: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" fromGroupId: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" fromGroupOwnerUin: ");
    localStringBuilder.append(this.i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.TogetherEnterRoomParam
 * JD-Core Version:    0.7.0.1
 */