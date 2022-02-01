package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class ColorNotePlugin$2
  implements Runnable
{
  ColorNotePlugin$2(ColorNotePlugin paramColorNotePlugin, IColorNoteController paramIColorNoteController, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    this.a.onCannotAdd();
    this.b.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.2
 * JD-Core Version:    0.7.0.1
 */