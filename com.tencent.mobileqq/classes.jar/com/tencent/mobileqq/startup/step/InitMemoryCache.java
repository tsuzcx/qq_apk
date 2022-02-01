package com.tencent.mobileqq.startup.step;

import android.support.v4.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.IMemoryManager;
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
    if (a) {
      return true;
    }
    a = true;
    Object localObject = MemoryClearManager.a();
    QQHashMap.setManager((IMemoryManager)localObject);
    QQConcurrentHashMap.setManager((IMemoryManager)localObject);
    QQLruCache.setManager((IMemoryManager)localObject);
    LruCache.setManager((IMemoryManager)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("InitMemoryCache BaseApplicationImpl.sProcessId =");
    ((StringBuilder)localObject).append(BaseApplicationImpl.sProcessId);
    ((StringBuilder)localObject).append("BaseApplicationImpl.processName=");
    ((StringBuilder)localObject).append(BaseApplicationImpl.processName);
    QLog.e("qiqili", 1, ((StringBuilder)localObject).toString());
    com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (BaseApplicationImpl.sProcessId == 1)
    {
      i = (int)(MemoryManager.a() * 3L / 16L);
      com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new InitMemoryCache.InnerMQLruCache(Integer.valueOf(i));
      com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_Int = i;
      return true;
    }
    if (BaseApplicationImpl.sProcessId == 5)
    {
      i = (int)(MemoryManager.a() * 3L / 16L);
      com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new InitMemoryCache.InnerMQLruCache(Integer.valueOf(i));
      com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_Int = i;
      return true;
    }
    boolean bool = BaseApplicationImpl.processName.endsWith(":peak");
    int i = 4194304;
    int j;
    if ((!bool) && (!BaseApplicationImpl.processName.endsWith(":dataline")) && (!BaseApplicationImpl.processName.endsWith(":secmsg")) && (!BaseApplicationImpl.processName.endsWith(":dingdong")) && (!BaseApplicationImpl.processName.endsWith(":miniapp")) && (!BaseApplicationImpl.processName.endsWith(":mini")) && (!BaseApplicationImpl.processName.endsWith(":mini1")) && (!BaseApplicationImpl.processName.endsWith(":mini2")) && (!BaseApplicationImpl.processName.endsWith(":mini3")) && (!BaseApplicationImpl.processName.endsWith(":mini4")) && (!BaseApplicationImpl.processName.endsWith(":mini5")) && (!BaseApplicationImpl.processName.endsWith(":mini6")) && (!BaseApplicationImpl.processName.endsWith(":mini7")) && (!BaseApplicationImpl.processName.endsWith(":troophomework")) && (!BaseApplicationImpl.processName.endsWith(":live")) && (!BaseApplicationImpl.processName.endsWith(":openSdk")) && (!BaseApplicationImpl.processName.endsWith(":picture")))
    {
      if ((BaseApplicationImpl.sProcessId != 7) && (BaseApplicationImpl.sProcessId != 2))
      {
        if (BaseApplicationImpl.processName.endsWith(":video"))
        {
          j = (int)(MemoryManager.a() / 16L);
          if (j > 4194304) {
            i = j;
          }
          com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new InitMemoryCache.InnerMQLruCache(Integer.valueOf(i));
          com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_Int = j;
          return true;
        }
      }
      else
      {
        i = (int)(MemoryManager.a() * 3L / 16L);
        com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new InitMemoryCache.InnerMQLruCache(Integer.valueOf(i));
        com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_Int = i;
        return true;
      }
    }
    else
    {
      j = (int)(MemoryManager.a() * 3L / 16L);
      if (j > 4194304) {
        i = j;
      }
      com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new InitMemoryCache.InnerMQLruCache(Integer.valueOf(i));
      com.tencent.mobileqq.app.GlobalImageCache.jdField_a_of_type_Int = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("memory size:");
        ((StringBuilder)localObject).append(j);
        QLog.d("MemoryCache", 2, ((StringBuilder)localObject).toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMemoryCache
 * JD-Core Version:    0.7.0.1
 */