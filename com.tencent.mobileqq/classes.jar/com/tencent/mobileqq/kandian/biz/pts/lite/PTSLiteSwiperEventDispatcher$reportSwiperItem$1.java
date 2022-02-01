package com.tencent.mobileqq.kandian.biz.pts.lite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PTSLiteSwiperEventDispatcher$reportSwiperItem$1
  implements Runnable
{
  PTSLiteSwiperEventDispatcher$reportSwiperItem$1(PTSLiteSwiperEventDispatcher paramPTSLiteSwiperEventDispatcher) {}
  
  public final void run()
  {
    Iterator localIterator = ((Map)PTSLiteSwiperEventDispatcher.a(this.this$0)).entrySet().iterator();
    while (localIterator.hasNext())
    {
      PTSLiteSwiperEventDispatcher.ItemExposureData localItemExposureData = (PTSLiteSwiperEventDispatcher.ItemExposureData)((Map.Entry)localIterator.next()).getValue();
      PTSLiteSwiperEventDispatcher.a(this.this$0, localItemExposureData.a(), localItemExposureData.a(), localItemExposureData.b());
    }
    PTSLiteSwiperEventDispatcher.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteSwiperEventDispatcher.reportSwiperItem.1
 * JD-Core Version:    0.7.0.1
 */