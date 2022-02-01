package com.tencent.mobileqq.startup.step;

import abfc;
import android.support.v4.util.LruCache;
import bcpk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class InitMemoryCache
  extends Step
{
  private static volatile boolean a;
  
  protected boolean doStep()
  {
    int i = 4194304;
    if (a) {}
    do
    {
      long l;
      do
      {
        return true;
        a = true;
        abfc localabfc = abfc.a();
        QQHashMap.setManager(localabfc);
        QQConcurrentHashMap.setManager(localabfc);
        QQLruCache.setManager(localabfc);
        LruCache.setManager(localabfc);
        QLog.e("qiqili", 1, "InitMemoryCache BaseApplicationImpl.sProcessId =" + BaseApplicationImpl.sProcessId + "BaseApplicationImpl.processName=" + BaseApplicationImpl.processName);
        BaseApplicationImpl.sImageHashMap = new ConcurrentHashMap();
        if (BaseApplicationImpl.sProcessId == 1)
        {
          l = MemoryManager.a() * 3L / 16L;
          BaseApplicationImpl.sImageCache = new bcpk(Integer.valueOf((int)l));
          BaseApplicationImpl.sImageCacheSize = (int)l;
          return true;
        }
        if (BaseApplicationImpl.sProcessId == 5)
        {
          l = MemoryManager.a() * 3L / 16L;
          BaseApplicationImpl.sImageCache = new bcpk(Integer.valueOf((int)l));
          BaseApplicationImpl.sImageCacheSize = (int)l;
          return true;
        }
        if ((!BaseApplicationImpl.processName.endsWith(":peak")) && (!BaseApplicationImpl.processName.endsWith(":dataline")) && (!BaseApplicationImpl.processName.endsWith(":secmsg")) && (!BaseApplicationImpl.processName.endsWith(":dingdong")) && (!BaseApplicationImpl.processName.endsWith(":miniapp")) && (!BaseApplicationImpl.processName.endsWith(":troophomework")) && (!BaseApplicationImpl.processName.endsWith(":live"))) {
          break;
        }
        j = (int)(MemoryManager.a() * 3L / 16L);
        if (j > 4194304) {
          i = j;
        }
        BaseApplicationImpl.sImageCache = new bcpk(Integer.valueOf(i));
        BaseApplicationImpl.sImageCacheSize = j;
      } while (!QLog.isColorLevel());
      QLog.d("MemoryCache", 2, "memory size:" + j);
      return true;
      if ((BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 2))
      {
        l = MemoryManager.a() * 3L / 16L;
        BaseApplicationImpl.sImageCache = new bcpk(Integer.valueOf((int)l));
        BaseApplicationImpl.sImageCacheSize = (int)l;
        return true;
      }
    } while (!BaseApplicationImpl.processName.endsWith(":video"));
    int j = (int)(MemoryManager.a() / 16L);
    if (j > 4194304) {
      i = j;
    }
    BaseApplicationImpl.sImageCache = new bcpk(Integer.valueOf(i));
    BaseApplicationImpl.sImageCacheSize = j;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMemoryCache
 * JD-Core Version:    0.7.0.1
 */