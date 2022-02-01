package com.tencent.qqmini.sdk.auth;

public class AuthStateItem
{
  public int authFlag;
  public String scopeName;
  
  public AuthStateItem(String paramString, int paramInt)
  {
    this.scopeName = paramString;
    this.authFlag = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.AuthStateItem
 * JD-Core Version:    0.7.0.1
 */