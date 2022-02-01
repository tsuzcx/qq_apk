package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;

class NearbyProxy$3
  implements Runnable
{
  NearbyProxy$3(NearbyProxy paramNearbyProxy) {}
  
  public void run()
  {
    ((DynamicNowManager)this.this$0.a.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.3
 * JD-Core Version:    0.7.0.1
 */