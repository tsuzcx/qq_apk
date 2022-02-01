package com.tencent.mobileqq.intervideo.yiqikan;

import com.tencent.mobileqq.mediafocus.MediaFocusManager;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;

class WatchFloatingWindowController$1
  implements IVideoInnerStatusListener
{
  WatchFloatingWindowController$1(WatchFloatingWindowController paramWatchFloatingWindowController) {}
  
  public void notifyVideoClose(int paramInt) {}
  
  public void notifyVideoSeek(int paramInt) {}
  
  public void notifyVideoStart()
  {
    if (WatchFloatingWindowController.a(this.a) != null)
    {
      MediaFocusManager.a().a(1, WatchFloatingWindowController.a(this.a));
      return;
    }
    this.a.a(false);
  }
  
  public void notifyVideoStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchFloatingWindowController.1
 * JD-Core Version:    0.7.0.1
 */