package com.tencent.mobileqq.danmaku.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.WindowConfig;
import com.tencent.mobileqq.danmaku.render.BaseDanmakuRender;
import com.tencent.mobileqq.danmaku.tool.BitmapCacheManager;
import com.tencent.mobileqq.danmaku.util.DanmakuUtils;

public class CacheDrawManager
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final BitmapCacheManager jdField_a_of_type_ComTencentMobileqqDanmakuToolBitmapCacheManager = new BitmapCacheManager();
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuToolBitmapCacheManager.a();
  }
  
  public Bitmap a(BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext)
  {
    if (paramBaseDanmaku != null) {
      try
      {
        if (paramBaseDanmaku.f())
        {
          Object localObject2 = paramBaseDanmaku.a();
          Object localObject1;
          if (localObject2 == null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolBitmapCacheManager.a((int)paramBaseDanmaku.h(), (int)paramBaseDanmaku.i());
          }
          else if (((Bitmap)localObject2).getWidth() >= (int)paramBaseDanmaku.h())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramBaseDanmaku.i()) {}
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqDanmakuToolBitmapCacheManager.a((Bitmap)localObject2);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolBitmapCacheManager.a((int)paramBaseDanmaku.h(), (int)paramBaseDanmaku.i());
          }
          paramBaseDanmaku.a((Bitmap)localObject1);
          if (localObject1 == null) {
            return null;
          }
          localObject2 = paramBaseDanmaku.a();
          if (localObject2 == null)
          {
            localObject2 = new Canvas((Bitmap)localObject1);
            paramBaseDanmaku.a((Canvas)localObject2);
          }
          else
          {
            ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
          }
          ((Bitmap)localObject1).eraseColor(0);
          paramBaseDanmaku.c(false);
          paramDanmakuContext.a(paramBaseDanmaku).a((Canvas)localObject2, paramBaseDanmaku, paramDanmakuContext, DanmakuContext.a().g(), DanmakuContext.a().c());
          return localObject1;
        }
        paramBaseDanmaku = paramBaseDanmaku.a();
        return paramBaseDanmaku;
      }
      finally {}
    }
    throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
  }
  
  public void a()
  {
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localHandlerThread != null)
    {
      if (!localHandlerThread.isAlive()) {
        return;
      }
      if (DanmakuUtils.a())
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
        return;
      }
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolBitmapCacheManager.a(paramBitmap);
  }
  
  public void a(BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext) {}
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuToolBitmapCacheManager.c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolBitmapCacheManager.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuToolBitmapCacheManager.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.CacheDrawManager
 * JD-Core Version:    0.7.0.1
 */