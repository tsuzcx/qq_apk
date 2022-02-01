package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CMTime;
import java.util.ArrayList;
import java.util.Iterator;

class VideoThumbProviderManager$1
  implements VideoThumbListener
{
  VideoThumbProviderManager$1(VideoThumbProviderManager paramVideoThumbProviderManager) {}
  
  public void onThumbGenerated(Object paramObject, CMTime paramCMTime, Bitmap paramBitmap)
  {
    Iterator localIterator = VideoThumbProviderManager.access$000(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((VideoThumbListener)localIterator.next()).onThumbGenerated(paramObject, paramCMTime, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager.1
 * JD-Core Version:    0.7.0.1
 */