package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class ColorNotePlugin$3$1$1
  implements ColorNotePlugin.AddColorSignListener
{
  ColorNotePlugin$3$1$1(ColorNotePlugin.3.1 param1) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAddColorSign:");
    localStringBuilder.append(paramBoolean);
    QLog.d("ColorNotePlugin", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.a.a.a.ok();
      return;
    }
    this.a.a.a.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.3.1.1
 * JD-Core Version:    0.7.0.1
 */