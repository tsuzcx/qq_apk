package com.tencent.mobileqq.startup.step;

import android.support.v4.util.LruCache;
import azof;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import zie;

public class InitMemoryCache
  extends Step
{
  private static volatile boolean a;
  
  protected boolean doStep()
  {
    if (a) {}
    for (;;)
    {
      return true;
      a = true;
      zie localzie = zie.a();
      QQHashMap.setManager(localzie);
      QQConcurrentHashMap.setManager(localzie);
      QQLruCache.setManager(localzie);
      LruCache.setManager(localzie);
      QLog.e("qiqili", 1, "InitMemoryCache BaseApplicationImpl.sProcessId =" + BaseApplicationImpl.sProcessId + "BaseApplicationImpl.processName=" + BaseApplicationImpl.processName);
      BaseApplicationImpl.sImageHashMap = new ConcurrentHashMap();
      long l;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        l = MemoryManager.a() * 3L / 16L;
        BaseApplicationImpl.sImageCache = new azof(Integer.valueOf((int)l));
        BaseApplicationImpl.sImageCacheSize = (int)l;
      }
      while ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 5) || (BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 9) || (BaseApplicationImpl.sProcessId == 11) || (BaseApplicationImpl.sProcessId == 10))
      {
        ThreadManager.getSubThreadHandler().post(new InitMemoryCache.2(this));
        zie.a().d();
        return true;
        if (BaseApplicationImpl.sProcessId == 5)
        {
          l = MemoryManager.a() * 3L / 16L;
          BaseApplicationImpl.sImageCache = new azof(Integer.valueOf((int)l));
          BaseApplicationImpl.sImageCacheSize = (int)l;
        }
        else
        {
          int j;
          int i;
          if ((BaseApplicationImpl.processName.endsWith(":peak")) || (BaseApplicationImpl.processName.endsWith(":dataline")) || (BaseApplicationImpl.processName.endsWith(":secmsg")) || (BaseApplicationImpl.processName.endsWith(":dingdong")) || (BaseApplicationImpl.processName.endsWith(":miniapp")) || (BaseApplicationImpl.processName.endsWith(":troophomework")) || (BaseApplicationImpl.processName.endsWith(":live")))
          {
            j = (int)(MemoryManager.a() * 3L / 16L);
            i = 4194304;
            if (j > 4194304) {
              i = j;
            }
            BaseApplicationImpl.sImageCache = new azof(Integer.valueOf(i));
            BaseApplicationImpl.sImageCacheSize = j;
            if (QLog.isColorLevel()) {
              QLog.d("MemoryCache", 2, "memory size:" + j);
            }
            ThreadManager.getSubThreadHandler().post(new InitMemoryCache.1(this));
            zie.a().d();
          }
          else if ((BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 2))
          {
            l = MemoryManager.a() * 3L / 16L;
            BaseApplicationImpl.sImageCache = new azof(Integer.valueOf((int)l));
            BaseApplicationImpl.sImageCacheSize = (int)l;
          }
          else if (BaseApplicationImpl.processName.endsWith(":video"))
          {
            j = (int)(MemoryManager.a() / 16L);
            i = 4194304;
            if (j > 4194304) {
              i = j;
            }
            BaseApplicationImpl.sImageCache = new azof(Integer.valueOf(i));
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