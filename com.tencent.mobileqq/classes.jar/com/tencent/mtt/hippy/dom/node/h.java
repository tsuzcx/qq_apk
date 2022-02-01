package com.tencent.mtt.hippy.dom.node;

import android.graphics.Picture;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.StaticLayout;
import com.tencent.mtt.hippy.common.HippyHandlerThread;
import com.tencent.mtt.hippy.utils.LogUtils;

public class h
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
    float f;
    if (Build.VERSION.SDK_INT < 20)
    {
      i = j;
      if ((paramLayout instanceof StaticLayout))
      {
        i = paramLayout.getLineAscent(paramLayout.getLineCount() - 1);
        j = paramLayout.getLineDescent(paramLayout.getLineCount() - 1);
        f = (j - i - paramLayout.getSpacingAdd()) / paramLayout.getSpacingMultiplier();
        f = j - i - f;
        if (f < 0.0F) {
          break label98;
        }
      }
    }
    label98:
    for (i = (int)(f + 0.5D);; i = -(int)(-f + 0.5D)) {
      return paramLayout.getHeight() - i;
    }
  }
  
  private int c(Layout paramLayout)
  {
    int i = 0;
    int k = 0;
    if (paramLayout == null) {
      return k;
    }
    int m = paramLayout.getLineCount();
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      i = Math.max(i, (int)paramLayout.getLineRight(j));
      j += 1;
    }
  }
  
  private boolean d(Layout paramLayout)
  {
    try
    {
      paramLayout.draw(this.b.beginRecording(c(paramLayout), b(paramLayout)));
      this.b.endRecording();
      return true;
    }
    catch (Exception paramLayout)
    {
      LogUtils.e("TextNode", "warmUpTextLayoutCache error", paramLayout);
    }
    return false;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.quit();
    }
    this.a = null;
  }
  
  public void a(Layout paramLayout)
  {
    if ((this.a != null) && (this.a.isThreadAlive())) {
      this.a.runOnQueue(new h.1(this, paramLayout));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.h
 * JD-Core Version:    0.7.0.1
 */