package com.tencent.mobileqq.kandian.repo.common;

import java.util.List;

public class ReadInJoyUserInfoModule$Request0xb81Params
{
  private int jdField_a_of_type_Int;
  private List<ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  private ReadInJoyUserInfoModule$Request0xb81Params(ReadInJoyUserInfoModule.Request0xb81Params.Builder paramBuilder)
  {
    this.jdField_a_of_type_Int = ReadInJoyUserInfoModule.Request0xb81Params.Builder.a(paramBuilder);
    this.b = ReadInJoyUserInfoModule.Request0xb81Params.Builder.b(paramBuilder);
    this.c = ReadInJoyUserInfoModule.Request0xb81Params.Builder.c(paramBuilder);
    this.d = ReadInJoyUserInfoModule.Request0xb81Params.Builder.d(paramBuilder);
    this.e = ReadInJoyUserInfoModule.Request0xb81Params.Builder.e(paramBuilder);
    this.jdField_a_of_type_JavaUtilList = ReadInJoyUserInfoModule.Request0xb81Params.Builder.a(paramBuilder);
    this.f = ReadInJoyUserInfoModule.Request0xb81Params.Builder.f(paramBuilder);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request0xb81Params, \nreqClientType = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0))
    {
      localStringBuilder.append("accountInfoReqs = \n");
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localStringBuilder.append("[");
        localStringBuilder.append(i);
        localStringBuilder.append("] ");
        localStringBuilder.append(((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)this.jdField_a_of_type_JavaUtilList.get(i)).toString());
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule.Request0xb81Params
 * JD-Core Version:    0.7.0.1
 */