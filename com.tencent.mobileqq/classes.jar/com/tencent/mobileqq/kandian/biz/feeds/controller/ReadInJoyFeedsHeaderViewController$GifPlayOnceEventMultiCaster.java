package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import mqq.util.WeakReference;

class ReadInJoyFeedsHeaderViewController$GifPlayOnceEventMultiCaster
{
  private static Map<AbstractGifImage, List<WeakReference<ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.GifStateListener>>> a = new WeakHashMap();
  private static Map<AbstractGifImage, ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.CustomOnGIFPlayOnceListener> b = new WeakHashMap();
  
  public void a()
  {
    a.clear();
    b.clear();
  }
  
  void a(ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.GifStateListener paramGifStateListener, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))
    {
      AbstractGifImage localAbstractGifImage = ((GifDrawable)paramURLDrawable.getCurrDrawable()).getImage();
      paramURLDrawable = new ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.CustomOnGIFPlayOnceListener(localAbstractGifImage);
      localAbstractGifImage.setGIFPlayOnceListener(paramURLDrawable);
      b.put(localAbstractGifImage, paramURLDrawable);
      List localList = (List)a.get(localAbstractGifImage);
      paramURLDrawable = localList;
      if (localList == null) {
        paramURLDrawable = new ArrayList();
      }
      paramURLDrawable.add(new WeakReference(paramGifStateListener));
      a.put(localAbstractGifImage, paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster
 * JD-Core Version:    0.7.0.1
 */