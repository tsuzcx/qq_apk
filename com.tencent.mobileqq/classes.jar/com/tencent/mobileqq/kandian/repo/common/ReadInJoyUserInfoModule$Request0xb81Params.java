package com.tencent.mobileqq.kandian.repo.common;

import java.util.List;

public class ReadInJoyUserInfoModule$Request0xb81Params
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private List<ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq> g;
  private int h;
  
  private ReadInJoyUserInfoModule$Request0xb81Params(ReadInJoyUserInfoModule.Request0xb81Params.Builder paramBuilder)
  {
    this.a = ReadInJoyUserInfoModule.Request0xb81Params.Builder.a(paramBuilder);
    this.b = ReadInJoyUserInfoModule.Request0xb81Params.Builder.b(paramBuilder);
    this.c = ReadInJoyUserInfoModule.Request0xb81Params.Builder.c(paramBuilder);
    this.d = ReadInJoyUserInfoModule.Request0xb81Params.Builder.d(paramBuilder);
    this.e = ReadInJoyUserInfoModule.Request0xb81Params.Builder.e(paramBuilder);
    this.g = ReadInJoyUserInfoModule.Request0xb81Params.Builder.f(paramBuilder);
    this.f = ReadInJoyUserInfoModule.Request0xb81Params.Builder.g(paramBuilder);
    this.h = ReadInJoyUserInfoModule.Request0xb81Params.Builder.h(paramBuilder);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request0xb81Params, \nreqClientType = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\n');
    localStringBuilder.append("nick = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\n');
    localStringBuilder.append("headUrl = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\n');
    localStringBuilder.append("infoPriority = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\n');
    localStringBuilder = new StringBuilder(localStringBuilder.toString());
    List localList = this.g;
    if ((localList != null) && (localList.size() > 0))
    {
      localStringBuilder.append("accountInfoReqs = \n");
      int i = 0;
      while (i < this.g.size())
      {
        localStringBuilder.append("[");
        localStringBuilder.append(i);
        localStringBuilder.append("] ");
        localStringBuilder.append(((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)this.g.get(i)).toString());
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule.Request0xb81Params
 * JD-Core Version:    0.7.0.1
 */