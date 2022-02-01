package com.tencent.widget;

public final class AuthorizationItem$ItemType
{
  public final String a;
  public final String b;
  public final int c;
  
  AuthorizationItem$ItemType(String paramString1, String paramString2, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
  }
  
  public static ItemType a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return AuthorizationItem.d;
        }
        return AuthorizationItem.c;
      }
      return AuthorizationItem.b;
    }
    return AuthorizationItem.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AuthorizationItem.ItemType
 * JD-Core Version:    0.7.0.1
 */