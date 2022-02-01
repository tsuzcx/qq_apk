package com.tencent.qqlive.module.videoreport.dtreport.time.audio;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener;
import java.util.Iterator;
import java.util.Set;

class AudioSession$3
  implements PageManager.IPageListener
{
  AudioSession$3(AudioSession paramAudioSession) {}
  
  public void onPageIn(@NonNull PageInfo paramPageInfo, @NonNull Set<PageInfo> paramSet)
  {
    paramPageInfo = paramSet.iterator();
    while (paramPageInfo.hasNext())
    {
      paramSet = (PageInfo)paramPageInfo.next();
      AudioSession.access$200(this.this$0, paramSet);
    }
  }
  
  public void onPageOut(@NonNull PageInfo paramPageInfo, @NonNull Set<PageInfo> paramSet, boolean paramBoolean)
  {
    paramPageInfo = paramSet.iterator();
    while (paramPageInfo.hasNext())
    {
      paramSet = (PageInfo)paramPageInfo.next();
      AudioSession.access$300(this.this$0, paramSet);
    }
  }
  
  public void onPageUpdate(PageInfo paramPageInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.audio.AudioSession.3
 * JD-Core Version:    0.7.0.1
 */