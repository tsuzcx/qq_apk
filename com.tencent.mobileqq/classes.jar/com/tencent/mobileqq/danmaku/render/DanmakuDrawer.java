package com.tencent.mobileqq.danmaku.render;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.mobileqq.danmaku.core.CacheDrawManager;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.WindowConfig;

public class DanmakuDrawer
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final CacheDrawManager jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager;
  private final Rect b = new Rect();
  
  public DanmakuDrawer(CacheDrawManager paramCacheDrawManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager = paramCacheDrawManager;
  }
  
  private boolean a(Canvas paramCanvas, BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext, BaseDanmakuRender paramBaseDanmakuRender)
  {
    paramDanmakuContext = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.a(paramBaseDanmaku, paramDanmakuContext);
    if (paramDanmakuContext == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramBaseDanmaku.f(), (int)paramBaseDanmaku.g());
    this.b.set((int)paramBaseDanmaku.b(), (int)paramBaseDanmaku.c(), (int)paramBaseDanmaku.d(), (int)paramBaseDanmaku.e());
    paramCanvas.drawBitmap(paramDanmakuContext, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void b(Canvas paramCanvas, BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext, BaseDanmakuRender paramBaseDanmakuRender)
  {
    int i = paramCanvas.save();
    paramBaseDanmakuRender.a(paramCanvas, paramBaseDanmaku, paramDanmakuContext, paramBaseDanmaku.h(), paramBaseDanmaku.i());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext, BaseDanmakuRender paramBaseDanmakuRender)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      if (!paramBaseDanmaku.e()) {
        break;
      }
    } while (a(paramCanvas, paramBaseDanmaku, paramDanmakuContext, paramBaseDanmakuRender));
    WindowConfig.a(false);
    b(paramCanvas, paramBaseDanmaku, paramDanmakuContext, paramBaseDanmakuRender);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.render.DanmakuDrawer
 * JD-Core Version:    0.7.0.1
 */