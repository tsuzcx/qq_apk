package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.mobileqq.apollo.utils.ApolloHttpUtil;

final class HttpUtil$4
  implements Runnable
{
  HttpUtil$4(String paramString1, String paramString2, String[] paramArrayOfString, ApolloHttpCallBack paramApolloHttpCallBack, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    String str = this.a.toUpperCase();
    if (str.equals("GET"))
    {
      ApolloHttpUtil.a(this.b, this.c, this.d);
      return;
    }
    if (str.equals("POST"))
    {
      if (this.e)
      {
        ApolloHttpUtil.a(this.b, this.f, this.g, this.h, this.c, this.d);
        return;
      }
      ApolloHttpUtil.a(this.b, this.f, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.4
 * JD-Core Version:    0.7.0.1
 */