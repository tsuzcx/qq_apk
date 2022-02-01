package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.mobileqq.apollo.utils.ApolloHttpUtil;
import com.tencent.mobileqq.cmshow.engine.EngineType;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;

final class HttpUtil$8
  implements Runnable
{
  HttpUtil$8(String paramString1, String[] paramArrayOfString, ApolloHttpResponseCallback paramApolloHttpResponseCallback, String paramString2, byte[] paramArrayOfByte, ApolloHttpProgressCallback paramApolloHttpProgressCallback1, ApolloHttpProgressCallback paramApolloHttpProgressCallback2) {}
  
  public void run()
  {
    if ((!this.a.startsWith("http://stubcmshow.qq.com/cm3d/")) && (!this.a.startsWith("https://stubcmshow.qq.com/cm3d/")))
    {
      ApolloHttpUtil.a(this.a, this.d, this.b, this.e, this.c, this.f, this.g);
      return;
    }
    IApolloResManager localIApolloResManager = ApolloResManagerFacade.a.a(EngineType.BK);
    ApolloHttpUtil.a(this.a, this.b, this.c, localIApolloResManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.8
 * JD-Core Version:    0.7.0.1
 */