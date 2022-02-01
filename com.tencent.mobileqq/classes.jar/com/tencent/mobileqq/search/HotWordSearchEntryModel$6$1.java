package com.tencent.mobileqq.search;

import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

class HotWordSearchEntryModel$6$1
  implements GifDrawable.OnGIFPlayOnceListener
{
  HotWordSearchEntryModel$6$1(HotWordSearchEntryModel.6 param6, AbstractGifImage paramAbstractGifImage) {}
  
  public void onPlayOnce()
  {
    this.a.setStrongGIFPlayOnceListener(null);
    if (this.b.c != null) {
      this.b.c.b();
    }
    if (this.b.a.get() == null) {
      return;
    }
    AbstractGifImage.pauseAll();
    ((URLImageView)this.b.a.get()).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel.6.1
 * JD-Core Version:    0.7.0.1
 */