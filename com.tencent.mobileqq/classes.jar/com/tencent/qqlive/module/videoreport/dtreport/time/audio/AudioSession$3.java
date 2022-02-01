package com.tencent.qqlive.module.videoreport.dtreport.time.audio;

import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener;

class AudioSession$3
  implements PageManager.IPageListener
{
  AudioSession$3(AudioSession paramAudioSession) {}
  
  public void onPageIn(PageInfo paramPageInfo)
  {
    AudioSession.access$200(this.this$0, paramPageInfo);
  }
  
  public void onPageOut(PageInfo paramPageInfo, boolean paramBoolean)
  {
    AudioSession.access$300(this.this$0, paramPageInfo);
  }
  
  public void onPageUpdate(PageInfo paramPageInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.audio.AudioSession.3
 * JD-Core Version:    0.7.0.1
 */