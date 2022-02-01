package com.tencent.mobileqq.danmaku.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.WindowConfig;
import com.tencent.mobileqq.danmaku.render.BaseDanmakuRender;
import com.tencent.mobileqq.danmaku.util.ContentSize;
import com.tencent.mobileqq.danmaku.util.DanmakuUncaughtExceptionHandler;
import com.tencent.mobileqq.danmaku.util.DanmakuUtils;
import com.tencent.mobileqq.danmaku.util.Logger;
import java.util.List;

public class DanmakuMeasureManager
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private DanmakuContext jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext;
  
  public DanmakuMeasureManager(DanmakuContext paramDanmakuContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext = paramDanmakuContext;
  }
  
  private Handler a()
  {
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    if ((localHandlerThread == null) || (!localHandlerThread.isAlive())) {
      try
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DanmakuMeasureThread");
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandlerThread.setUncaughtExceptionHandler(new DanmakuUncaughtExceptionHandler());
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      catch (Throwable localThrowable)
      {
        Logger.d("DanmakuMeasureManager", new Object[] { localThrowable });
      }
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public static void a(DanmakuContext paramDanmakuContext, BaseDanmaku paramBaseDanmaku)
  {
    if (paramBaseDanmaku.b()) {
      return;
    }
    paramDanmakuContext = paramDanmakuContext.a(paramBaseDanmaku).a(paramBaseDanmaku);
    paramBaseDanmaku.d(paramDanmakuContext.a() + DanmakuContext.a().g() * 2);
    paramBaseDanmaku.e(paramDanmakuContext.b() + DanmakuContext.a().c() * 2);
    paramBaseDanmaku.g();
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
  
  public void a(BaseDanmaku paramBaseDanmaku, DanmakuMeasureManager.IMeasureCallback paramIMeasureCallback)
  {
    Handler localHandler = a();
    if (localHandler != null) {
      localHandler.post(new DanmakuMeasureManager.1(this, paramBaseDanmaku, paramIMeasureCallback));
    }
  }
  
  public void a(List<BaseDanmaku> paramList, DanmakuMeasureManager.IMeasureCallback paramIMeasureCallback)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Handler localHandler = a();
      if (localHandler != null) {
        localHandler.post(new DanmakuMeasureManager.2(this, paramList, paramIMeasureCallback));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager
 * JD-Core Version:    0.7.0.1
 */