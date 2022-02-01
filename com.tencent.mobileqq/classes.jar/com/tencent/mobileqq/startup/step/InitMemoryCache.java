package com.tencent.mobileqq.startup.step;

import android.support.v4.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;
import java.util.concurrent.ConcurrentHashMap;

public class InitMemoryCache
  extends Step
{
  private static volatile boolean a = false;
  
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
        MemoryClearManager localMemoryClearManager = MemoryClearManager.a();
        QQHashMap.setManager(localMemoryClearManager);
        QQConcurrentHashMap.setManager(localMemoryClearManager);
        QQLruCache.setManager(localMemoryClearManager);
        LruCache.setManager(localMemoryClearManager);
        QLog.e("qiqili", 1, "InitMemoryCache BaseApplicationImpl.sProcessId =" + BaseApplicationImpl.sProcessId + "BaseApplicationImpl.processName=" + BaseApplicationImpl.processName);
        com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        if (BaseApplicationImpl.sProcessId == 1)
        {
          l = MemoryManager.a() * 3L / 16L;
          com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new InitMemoryCache.InnerMQLruCache(Integer.valueOf((int)l));
          com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_Int = (int)l;
          return true;
        }
        if (BaseApplicationImpl.sProcessId == 5)
        {
          l = MemoryManager.a() * 3L / 16L;
          com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new InitMemoryCache.InnerMQLruCache(Integer.valueOf((int)l));
          com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_Int = (int)l;
          return true;
        }
        if ((!BaseApplicationImpl.processName.endsWith(":peak")) && (!BaseApplicationImpl.processName.endsWith(":dataline")) && (!BaseApplicationImpl.processName.endsWith(":secmsg")) && (!BaseApplicationImpl.processName.endsWith(":dingdong")) && (!BaseApplicationImpl.processName.endsWith(":miniapp")) && (!BaseApplicationImpl.processName.endsWith(":mini")) && (!BaseApplicationImpl.processName.endsWith(":mini1")) && (!BaseApplicationImpl.processName.endsWith(":mini2")) && (!BaseApplicationImpl.processName.endsWith(":mini3")) && (!BaseApplicationImpl.processName.endsWith(":mini4")) && (!BaseApplicationImpl.processName.endsWith(":mini5")) && (!BaseApplicationImpl.processName.endsWith(":mini6")) && (!BaseApplicationImpl.processName.endsWith(":mini7")) && (!BaseApplicationImpl.processName.endsWith(":troophomework")) && (!BaseApplicationImpl.processName.endsWith(":live")) && (!BaseApplicationImpl.processName.endsWith(":openSdk"))) {
          break;
        }
        j = (int)(MemoryManager.a() * 3L / 16L);
        if (j > 4194304) {
          i = j;
        }
        com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new InitMemoryCache.InnerMQLruCache(Integer.valueOf(i));
        com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_Int = j;
      } while (!QLog.isColorLevel());
      QLog.d("MemoryCache", 2, "memory size:" + j);
      return true;
      if ((BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 2))
      {
        l = MemoryManager.a() * 3L / 16L;
        com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new InitMemoryCache.InnerMQLruCache(Integer.valueOf((int)l));
        com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_Int = (int)l;
        return true;
      }
    } while (!BaseApplicationImpl.processName.endsWith(":video"));
    int j = (int)(MemoryManager.a() / 16L);
    if (j > 4194304) {
      i = j;
    }
    com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new InitMemoryCache.InnerMQLruCache(Integer.valueOf(i));
    com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_Int = j;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMemoryCache
 * JD-Core Version:    0.7.0.1
 */