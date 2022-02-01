import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptLinkedBlockingDeque;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager.1;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public class sun
{
  public static final String a;
  private static sun jdField_a_of_type_Sun;
  ConcurrentHashMap<suo, RunningJob> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  CopyOnWriteArrayList<suo> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public ThreadPoolExecutor a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public sug a;
  ConcurrentHashMap<suo, RunningJob> b = new ConcurrentHashMap();
  private ConcurrentHashMap<suo, Boolean> c = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + sun.class.getSimpleName();
  }
  
  private sun()
  {
    int i;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      BaseApplicationImpl.sImageCache.evict(0);
      i = BaseApplicationImpl.sImageCacheSize * 2 / 3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        suv.a(jdField_a_of_type_JavaLangString, "start memLimit:" + i);
      }
      this.jdField_a_of_type_Sug = new sug(i);
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.poolThreadName = "image-manager";
      localThreadPoolParams.corePoolsize = 4;
      localThreadPoolParams.maxPooolSize = 8;
      localThreadPoolParams.priority = 3;
      if (pnh.a.b()) {
        localThreadPoolParams.queue = new RIJImageOptLinkedBlockingDeque(128);
      }
      this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = ((ThreadPoolExecutor)ThreadManager.newFreeThreadPool(localThreadPoolParams));
      return;
      int j = (int)(MemoryManager.a() / 10L);
      i = j;
      if (j <= 4194304) {
        i = 4194304;
      }
    }
  }
  
  public static sun a()
  {
    if (jdField_a_of_type_Sun == null) {}
    try
    {
      if (jdField_a_of_type_Sun == null) {
        jdField_a_of_type_Sun = new sun();
      }
      return jdField_a_of_type_Sun;
    }
    finally {}
  }
  
  public CopyOnWriteArrayList<suo> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public suk a(suo paramsuo)
  {
    if (paramsuo == null) {
      return null;
    }
    return this.jdField_a_of_type_Sug.a(paramsuo);
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        suv.a(jdField_a_of_type_JavaLangString, "clean");
      }
      this.jdField_a_of_type_Sug.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((RunningJob)((Map.Entry)localIterator.next()).getValue()).a();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    finally {}
  }
  
  public void a(suo paramsuo)
  {
    try
    {
      if (paramsuo.b) {
        this.c.put(paramsuo, Boolean.valueOf(true));
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramsuo);
      this.b.remove(paramsuo);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(suo paramsuo, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	sun:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 218	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 194	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +19 -> 34
    //   18: aload_2
    //   19: invokevirtual 195	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   22: aload_0
    //   23: getfield 146	sun:jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   26: aload_2
    //   27: invokevirtual 222	java/util/concurrent/ThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 62	sun:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   38: aload_1
    //   39: invokevirtual 218	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 194	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -16 -> 31
    //   50: aload_1
    //   51: invokevirtual 195	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   54: goto -23 -> 31
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	sun
    //   0	62	1	paramsuo	suo
    //   0	62	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	57	finally
    //   18	31	57	finally
    //   34	46	57	finally
    //   50	54	57	finally
  }
  
  public void a(suo paramsuo, sum paramsum)
  {
    if (paramsuo != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        if (paramsuo.a == null)
        {
          pnj.a(6, paramsuo);
          return;
        }
        localObject = this.jdField_a_of_type_Sug.a(paramsuo);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            suv.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramsuo + ", cache bitmap exist! callback:" + paramsum);
          }
          pnj.b(1, paramsuo);
          if (paramsum != null) {
            paramsum.a(paramsuo, ((suk)localObject).a());
          }
          ((suk)localObject).a();
          pnj.a(6, paramsuo);
          continue;
        }
        if (!paramsuo.b) {
          break label140;
        }
      }
      finally {}
      if (this.c.containsKey(paramsuo))
      {
        pnj.a(6, paramsuo);
      }
      else
      {
        label140:
        RunningJob localRunningJob = (RunningJob)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramsuo);
        localObject = localRunningJob;
        if (localRunningJob == null)
        {
          localObject = localRunningJob;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            localObject = (RunningJob)this.b.get(paramsuo);
          }
        }
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            suv.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramsuo + " already exist", true);
          }
          ((RunningJob)localObject).a(paramsum);
          paramsuo.e = 0;
          pnj.a(6, paramsuo);
        }
        else
        {
          localObject = new RunningJob(this, paramsuo);
          ((RunningJob)localObject).a(paramsum);
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (beqz.a(paramsuo.a.toString()) == null))
          {
            this.b.put(paramsuo, localObject);
            if (QLog.isColorLevel()) {
              suv.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramsuo + " add to pending queue", true);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramsuo, localObject);
            pnj.a(2, paramsuo);
            ThreadManager.post(new ImageManager.1(this, paramsuo, (RunningJob)localObject), 10, null, true);
          }
        }
      }
    }
  }
  
  public boolean a(URL paramURL)
  {
    return (paramURL != null) && (beqz.a(paramURL.toString()) != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      suv.a(jdField_a_of_type_JavaLangString, "pause", true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(suo paramsuo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramsuo);
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      suv.a(jdField_a_of_type_JavaLangString, "resume", true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    try
    {
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localEntry.getKey(), localEntry.getValue());
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute((Runnable)localEntry.getValue());
      }
      this.b.clear();
    }
    finally {}
  }
  
  public void c(suo paramsuo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramsuo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sun
 * JD-Core Version:    0.7.0.1
 */