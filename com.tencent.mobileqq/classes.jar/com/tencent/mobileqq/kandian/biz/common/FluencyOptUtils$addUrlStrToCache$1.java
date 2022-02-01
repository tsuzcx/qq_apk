package com.tencent.mobileqq.kandian.biz.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class FluencyOptUtils$addUrlStrToCache$1
  implements Runnable
{
  FluencyOptUtils$addUrlStrToCache$1(String paramString) {}
  
  public final void run()
  {
    try
    {
      URL localURL = new URL(this.a);
      FluencyOptUtils.a(FluencyOptUtils.a).put(this.a, localURL);
      return;
    }
    catch (MalformedURLException localMalformedURLException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.FluencyOptUtils.addUrlStrToCache.1
 * JD-Core Version:    0.7.0.1
 */