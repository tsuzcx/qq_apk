package com.tencent.mobileqq.kandian.biz.framework;

import android.util.Pair;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;

class RIJOnScrollListener$3
  implements Runnable
{
  RIJOnScrollListener$3(RIJOnScrollListener paramRIJOnScrollListener, Pair paramPair) {}
  
  public void run()
  {
    AdRequestData localAdRequestData = new AdRequestData();
    localAdRequestData.a = true;
    ReadInJoyLogicEngine.a().a(this.this$0.a.a().b(), 3, ((Integer)this.a.first).intValue(), ((Integer)this.a.second).intValue(), localAdRequestData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJOnScrollListener.3
 * JD-Core Version:    0.7.0.1
 */