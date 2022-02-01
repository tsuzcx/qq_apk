package com.tencent.mtt.abtestsdk.manager;

import com.getkeepsafe.relinker.ReLinker;
import com.tencent.mmkv.MMKV.LibLoader;

class CacheManager$1
  implements MMKV.LibLoader
{
  CacheManager$1(CacheManager paramCacheManager) {}
  
  public void loadLibrary(String paramString)
  {
    ReLinker.a(CacheManager.access$000(this.this$0), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.manager.CacheManager.1
 * JD-Core Version:    0.7.0.1
 */