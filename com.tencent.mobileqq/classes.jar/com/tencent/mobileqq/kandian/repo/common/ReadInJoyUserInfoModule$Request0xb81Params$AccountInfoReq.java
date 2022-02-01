package com.tencent.mobileqq.kandian.repo.common;

import java.io.Serializable;

public class ReadInJoyUserInfoModule$Request0xb81Params$AccountInfoReq
  implements Serializable
{
  private int accountType;
  private long friendStatus;
  private long uin;
  
  private ReadInJoyUserInfoModule$Request0xb81Params$AccountInfoReq(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.AccountInfoBuilder paramAccountInfoBuilder)
  {
    this.accountType = ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.AccountInfoBuilder.a(paramAccountInfoBuilder);
    this.uin = ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.AccountInfoBuilder.b(paramAccountInfoBuilder);
    this.friendStatus = ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.AccountInfoBuilder.c(paramAccountInfoBuilder);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AccountInfoReq, accountType = ");
    localStringBuilder.append(this.accountType);
    localStringBuilder.append(", uin = ");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\n');
    localStringBuilder.append("friendStatus = ");
    localStringBuilder.append(this.friendStatus);
    localStringBuilder.append('\n');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq
 * JD-Core Version:    0.7.0.1
 */