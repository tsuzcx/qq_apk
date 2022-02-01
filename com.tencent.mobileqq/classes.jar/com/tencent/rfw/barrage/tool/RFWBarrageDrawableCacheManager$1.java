package com.tencent.rfw.barrage.tool;

import android.util.LruCache;

class RFWBarrageDrawableCacheManager$1
  extends LruCache<String, T>
{
  RFWBarrageDrawableCacheManager$1(RFWBarrageDrawableCacheManager paramRFWBarrageDrawableCacheManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, T paramT)
  {
    if (paramT == null) {
      return 0;
    }
    int j = RFWBarrageDrawableCacheManager.a(this.a, paramT);
    int i = j;
    if (j == 0) {
      i = this.a.a(paramT);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.tool.RFWBarrageDrawableCacheManager.1
 * JD-Core Version:    0.7.0.1
 */