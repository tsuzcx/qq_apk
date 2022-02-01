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
    if (paramT == null) {
      return 0;
    }
    int j = DanmakuDrawableCacheManager.a(this.a, paramT);
    int i = j;
    if (j == 0) {
      i = this.a.a(paramT);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.tool.DanmakuDrawableCacheManager.1
 * JD-Core Version:    0.7.0.1
 */