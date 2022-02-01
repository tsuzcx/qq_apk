package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.supportui.utils.struct.Pools.SynchronizedPool;

public class c
{
  private static final Pools.SynchronizedPool<c> e = new Pools.SynchronizedPool(20);
  public String a;
  public String b;
  public String c;
  public HippyArray d;
  
  public static c a(String paramString1, String paramString2, String paramString3, HippyArray paramHippyArray)
  {
    c localc2 = (c)e.acquire();
    c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new c();
    }
    localc1.b(paramString1, paramString2, paramString3, paramHippyArray);
    return localc1;
  }
  
  private void b(String paramString1, String paramString2, String paramString3, HippyArray paramHippyArray)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramHippyArray;
  }
  
  public void a()
  {
    this.d = null;
    e.release(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.c
 * JD-Core Version:    0.7.0.1
 */