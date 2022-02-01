package com.tencent.mobileqq.danmaku.tool;

import android.support.v4.util.LruCache;

class DanmakuDrawableCacheManager$1
  extends LruCache<String, T>
{
  DanmakuDrawableCacheManager$1(DanmakuDrawableCacheManager paramDanmakuDrawableCacheManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, T paramT)
  {
    int i;
    if (paramT == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = DanmakuDrawableCacheManager.a(this.a, paramT);
      i = j;
    } while (j != 0);
    return this.a.a(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.tool.DanmakuDrawableCacheManager.1
 * JD-Core Version:    0.7.0.1
 */