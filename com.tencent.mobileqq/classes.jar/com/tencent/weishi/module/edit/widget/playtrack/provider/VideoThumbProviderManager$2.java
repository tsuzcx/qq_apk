package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.os.Handler;
import android.support.v4.util.LruCache;
import com.tencent.tavcut.util.Logger;
import java.util.ArrayList;

class VideoThumbProviderManager$2
  implements RunnableHandler
{
  VideoThumbProviderManager$2(VideoThumbProviderManager paramVideoThumbProviderManager) {}
  
  public void postRunnable(Runnable paramRunnable)
  {
    VideoThumbProviderManager.access$100(this.this$0).postAtFrontOfQueue(paramRunnable);
  }
  
  public void runnableFailAndReleaseCache()
  {
    long l = this.this$0.getCacheSize();
    int i = VideoThumbProviderManager.access$200(this.this$0).size();
    VideoThumbProviderManager.access$300(this.this$0).trimToSize(VideoThumbProviderManager.access$300(this.this$0).maxSize() / 2);
    Logger.e("VideoThumbProviderManager", "runnableFailAndReleaseCache currentCacheSize:" + l + ",size:" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager.2
 * JD-Core Version:    0.7.0.1
 */