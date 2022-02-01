package com.tencent.mobileqq.filter;

import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

public class QQFilterRenderManagerHolder
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  private static QQFilterRenderManager d;
  private static QQFilterRenderManager e;
  
  static
  {
    ((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init();
    ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).loadEffectSo();
  }
  
  public static QQFilterRenderManager a()
  {
    return new QQFilterRenderManager(new int[] { 70, 80, 90, 184 });
  }
  
  public static QQFilterRenderManager a(int paramInt)
  {
    if (paramInt == c) {
      return d;
    }
    return null;
  }
  
  public static void a(QQFilterRenderManager paramQQFilterRenderManager)
  {
    d = paramQQFilterRenderManager;
  }
  
  public static QQFilterRenderManager b()
  {
    try
    {
      if ((e != null) && (e.isSurfaceDestroyed())) {
        e = null;
      }
      if (e == null) {
        e = a();
      }
      QQFilterRenderManager localQQFilterRenderManager = e;
      return localQQFilterRenderManager;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filter.QQFilterRenderManagerHolder
 * JD-Core Version:    0.7.0.1
 */