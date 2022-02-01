package com.tencent.mobileqq.danmaku.render;

import android.graphics.Canvas;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.util.ContentSize;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class BaseDanmakuRender<D extends BaseDanmaku>
{
  private ArrayList<IDanmakuOverlayDrawer> a;
  
  private void c(Canvas paramCanvas, D paramD, DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((IDanmakuOverlayDrawer)localIterator.next()).a(paramCanvas, paramD, paramDanmakuContext, paramFloat1, paramFloat2);
      }
    }
  }
  
  public abstract ContentSize a(D paramD);
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, D paramD, DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramDanmakuContext, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramDanmakuContext, paramFloat1, paramFloat2);
  }
  
  public void a(D paramD) {}
  
  public abstract boolean a(BaseDanmaku paramBaseDanmaku);
  
  public abstract void b(Canvas paramCanvas, D paramD, DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.render.BaseDanmakuRender
 * JD-Core Version:    0.7.0.1
 */