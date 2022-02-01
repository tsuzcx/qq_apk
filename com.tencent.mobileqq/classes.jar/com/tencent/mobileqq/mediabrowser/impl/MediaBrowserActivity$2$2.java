package com.tencent.mobileqq.mediabrowser.impl;

import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;

class MediaBrowserActivity$2$2
  implements Runnable
{
  MediaBrowserActivity$2$2(MediaBrowserActivity.2 param2, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void run()
  {
    if (MediaBrowserActivity.a(this.g.a) != null) {
      MediaBrowserActivity.a(this.g.a).notifyImageProgress(this.a, this.b, this.c, this.d, this.e, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.impl.MediaBrowserActivity.2.2
 * JD-Core Version:    0.7.0.1
 */