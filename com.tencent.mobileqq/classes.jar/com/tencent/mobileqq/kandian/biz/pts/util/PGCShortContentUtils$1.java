package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import java.net.URL;

final class PGCShortContentUtils$1
  implements IPublicAccountImageDownListener
{
  PGCShortContentUtils$1(Runnable paramRunnable) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Object paramObject)
  {
    paramURL = this.a;
    if (paramURL != null) {
      paramURL.run();
    }
  }
  
  public void a(URL paramURL, Throwable paramThrowable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils.1
 * JD-Core Version:    0.7.0.1
 */