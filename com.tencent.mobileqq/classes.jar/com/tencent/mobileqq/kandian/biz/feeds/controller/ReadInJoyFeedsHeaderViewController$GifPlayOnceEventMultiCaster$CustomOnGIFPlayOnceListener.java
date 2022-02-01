package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

class ReadInJoyFeedsHeaderViewController$GifPlayOnceEventMultiCaster$CustomOnGIFPlayOnceListener
  implements GifDrawable.OnGIFPlayOnceListener
{
  AbstractGifImage a;
  
  ReadInJoyFeedsHeaderViewController$GifPlayOnceEventMultiCaster$CustomOnGIFPlayOnceListener(AbstractGifImage paramAbstractGifImage)
  {
    this.a = paramAbstractGifImage;
  }
  
  public void onPlayOnce()
  {
    Object localObject = (List)ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.a().get(this.a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if (localWeakReference.get() != null) {
          ((ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.GifStateListener)localWeakReference.get()).a();
        }
      }
    }
    this.a.setGIFPlayOnceListener(null);
    ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.b().remove(this.a);
    ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.a().remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.CustomOnGIFPlayOnceListener
 * JD-Core Version:    0.7.0.1
 */