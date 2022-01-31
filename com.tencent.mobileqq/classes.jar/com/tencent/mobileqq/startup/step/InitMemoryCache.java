package com.tencent.mobileqq.startup.step;

import aiey;
import android.support.v4.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.cache.MemoryClearManagerNew;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.memory.MemoryReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class InitMemoryCache
  extends Step
{
  private static volatile boolean a;
  
  protected boolean a()
  {
    if (a) {}
    for (;;)
    {
      return true;
      a = true;
      MemoryClearManagerNew localMemoryClearManagerNew = MemoryClearManagerNew.a();
      QQHashMap.setManager(localMemoryClearManagerNew);
      QQConcurrentHashMap.setManager(localMemoryClearManagerNew);
      QQLruCache.setManager(localMemoryClearManagerNew);
      LruCache.setManager(localMemoryClearManagerNew);
      BaseApplicationImpl.sImageHashMap = new ConcurrentHashMap();
      long l;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        l = MemoryManager.a() * 3L / 16L;
        BaseApplicationImpl.sImageCache = new aiey(Integer.valueOf((int)l));
        BaseApplicationImpl.sImageCacheSize = (int)l;
      }
      while ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 5) || (BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 9) || (BaseApplicationImpl.sProcessId == 10))
      {
        MemoryReporter.a().b();
        MemoryClearManagerNew.a().d();
        return true;
        if (BaseApplicationImpl.sProcessId == 5)
        {
          l = MemoryManager.a() * 3L / 16L;
          BaseApplicationImpl.sImageCache = new aiey(Integer.valueOf((int)l));
          BaseApplicationImpl.sImageCacheSize = (int)l;
        }
        else
        {
          int j;
          int i;
          if ((BaseApplicationImpl.processName.endsWith(":peak")) || (BaseApplicationImpl.processName.endsWith(":dataline")) || (BaseApplicationImpl.processName.endsWith(":secmsg")) || (BaseApplicationImpl.processName.endsWith(":dingdong")))
          {
            j = (int)(MemoryManager.a() * 3L / 16L);
            i = 4194304;
            if (j > 4194304) {
              i = j;
            }
            BaseApplicationImpl.sImageCache = new aiey(Integer.valueOf(i));
            BaseApplicationImpl.sImageCacheSize = j;
            if (QLog.isColorLevel()) {
              QLog.d("MemoryCache", 2, "memory size:" + j);
            }
          }
          else if ((BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 2))
          {
            l = MemoryManager.a() * 3L / 16L;
            BaseApplicationImpl.sImageCache = new aiey(Integer.valueOf((int)l));
            BaseApplicationImpl.sImageCacheSize = (int)l;
          }
          else if (BaseApplicationImpl.processName.endsWith(":video"))
          {
            j = (int)(MemoryManager.a() / 16L);
            i = 4194304;
            if (j > 4194304) {
              i = j;
            }
            BaseApplicationImpl.sImageCache = new aiey(Integer.valueOf(i));
            BaseApplicationImpl.sImageCacheSize = j;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMemoryCache
 * JD-Core Version:    0.7.0.1
 */