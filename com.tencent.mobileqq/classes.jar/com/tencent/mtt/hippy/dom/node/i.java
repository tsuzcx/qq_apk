package com.tencent.mtt.hippy.dom.node;

import android.graphics.Picture;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.StaticLayout;
import com.tencent.mtt.hippy.common.HippyHandlerThread;
import com.tencent.mtt.hippy.utils.LogUtils;

public class i
{
  private HippyHandlerThread a = new HippyHandlerThread("text-warm-thread");
  private Picture b = new Picture();
  
  private int b(Layout paramLayout)
  {
    int j = 0;
    if (paramLayout == null) {
      return 0;
    }
    int i = j;
    if (Build.VERSION.SDK_INT < 20)
    {
      i = j;
      if ((paramLayout instanceof StaticLayout))
      {
        i = paramLayout.getLineAscent(paramLayout.getLineCount() - 1);
        float f = paramLayout.getLineDescent(paramLayout.getLineCount() - 1) - i;
        f -= (f - paramLayout.getSpacingAdd()) / paramLayout.getSpacingMultiplier();
        double d;
        if (f >= 0.0F)
        {
          d = f;
          Double.isNaN(d);
          i = (int)(d + 0.5D);
        }
        else
        {
          d = -f;
          Double.isNaN(d);
          i = -(int)(d + 0.5D);
        }
      }
    }
    return paramLayout.getHeight() - i;
  }
  
  private int c(Layout paramLayout)
  {
    int i = 0;
    if (paramLayout == null) {
      return 0;
    }
    int k = paramLayout.getLineCount();
    int j = 0;
    while (i < k)
    {
      j = Math.max(j, (int)paramLayout.getLineRight(i));
      i += 1;
    }
    return j;
  }
  
  private void d(Layout paramLayout)
  {
    try
    {
      paramLayout.draw(this.b.beginRecording(c(paramLayout), b(paramLayout)));
      this.b.endRecording();
      return;
    }
    catch (Exception paramLayout)
    {
      LogUtils.e("TextNode", "warmUpTextLayoutCache error", paramLayout);
    }
  }
  
  public void a()
  {
    HippyHandlerThread localHippyHandlerThread = this.a;
    if (localHippyHandlerThread != null) {
      localHippyHandlerThread.quit();
    }
    this.a = null;
  }
  
  public void a(Layout paramLayout)
  {
    HippyHandlerThread localHippyHandlerThread = this.a;
    if ((localHippyHandlerThread != null) && (localHippyHandlerThread.isThreadAlive())) {
      this.a.runOnQueue(new i.1(this, paramLayout));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.i
 * JD-Core Version:    0.7.0.1
 */