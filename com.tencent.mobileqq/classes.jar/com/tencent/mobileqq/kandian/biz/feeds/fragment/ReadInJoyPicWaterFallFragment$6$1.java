package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitor;
import java.util.Map;

class ReadInJoyPicWaterFallFragment$6$1
  implements Runnable
{
  ReadInJoyPicWaterFallFragment$6$1(ReadInJoyPicWaterFallFragment.6 param6, boolean paramBoolean1, Map paramMap1, boolean paramBoolean2, Map paramMap2, String paramString) {}
  
  public void run()
  {
    if (this.a)
    {
      if (RIJChannelStayTimeMonitor.INSTANCE.isChannelShow(this.f.a.d())) {
        this.f.a(this.b, this.c, this.d, this.e);
      }
    }
    else {
      this.f.a(this.b, this.c, this.d, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.6.1
 * JD-Core Version:    0.7.0.1
 */