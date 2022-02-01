package com.tencent.mobileqq.danmaku.render;

import android.graphics.Canvas;
import android.text.TextPaint;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.WindowConfig;
import com.tencent.mobileqq.danmaku.util.ContentSize;
import com.tencent.mobileqq.danmaku.util.DrawUtils;

public class DefaultDanmakuRender
  extends BaseDanmakuRender
{
  private TextPaint a = new TextPaint();
  
  private String a(BaseDanmaku paramBaseDanmaku)
  {
    return String.valueOf(paramBaseDanmaku.a());
  }
  
  public ContentSize a(BaseDanmaku paramBaseDanmaku)
  {
    WindowConfig localWindowConfig = DanmakuContext.a();
    float f1 = DrawUtils.a(localWindowConfig.c(), a(paramBaseDanmaku)) + localWindowConfig.f() + localWindowConfig.f();
    float f2 = DrawUtils.a(localWindowConfig.c());
    f2 = localWindowConfig.e() * 2.0F + f2;
    paramBaseDanmaku.a(f2);
    paramBaseDanmaku.b(f1);
    return new ContentSize(f1, f2);
  }
  
  public boolean a(BaseDanmaku paramBaseDanmaku)
  {
    return true;
  }
  
  public void b(Canvas paramCanvas, BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2)
  {
    paramDanmakuContext = DanmakuContext.a();
    this.a.setTextSize(paramDanmakuContext.c());
    this.a.setColor(-1);
    paramCanvas.drawText(a(paramBaseDanmaku), paramDanmakuContext.f() + paramFloat1, paramDanmakuContext.e() + paramFloat2 - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.render.DefaultDanmakuRender
 * JD-Core Version:    0.7.0.1
 */