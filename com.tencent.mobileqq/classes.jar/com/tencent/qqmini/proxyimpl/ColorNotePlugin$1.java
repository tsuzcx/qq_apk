package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class ColorNotePlugin$1
  implements Runnable
{
  ColorNotePlugin$1(ColorNotePlugin paramColorNotePlugin, IColorNoteController paramIColorNoteController, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    this.a.addToRecentNote();
    this.b.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.1
 * JD-Core Version:    0.7.0.1
 */