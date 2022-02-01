package com.tencent.mtt.hippy.dom.node;

import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;
import com.tencent.mtt.hippy.views.image.HippyImageView.ImageEvent;

class c$2
  implements HippyImageLoader.Callback
{
  c$2(c paramc) {}
  
  public void a(HippyDrawable paramHippyDrawable) {}
  
  public void b(HippyDrawable paramHippyDrawable)
  {
    c.a(this.a, paramHippyDrawable);
    c.a(this.a, HippyImageView.ImageEvent.ONLOAD);
  }
  
  public void onRequestFail(Throwable paramThrowable, String paramString)
  {
    c.a(this.a, 0);
    c.a(this.a, HippyImageView.ImageEvent.ONERROR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.c.2
 * JD-Core Version:    0.7.0.1
 */