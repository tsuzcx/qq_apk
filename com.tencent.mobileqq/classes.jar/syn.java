import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptLinkedBlockingDeque;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager.1;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public class syn
{
  public static final String a;
  private static syn jdField_a_of_type_Syn;
  ConcurrentHashMap<syo, RunningJob> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  CopyOnWriteArrayList<syo> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public ThreadPoolExecutor a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public syg a;
  ConcurrentHashMap<syo, RunningJob> b = new ConcurrentHashMap();
  private ConcurrentHashMap<syo, Boolean> c = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + syn.class.getSimpleName();
  }
  
  private syn()
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
        syv.a(jdField_a_of_type_JavaLangString, "start memLimit:" + i);
      }
      this.jdField_a_of_type_Syg = new syg(i);
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.poolThreadName = "image-manager";
      localThreadPoolParams.corePoolsize = 4;
      localThreadPoolParams.maxPooolSize = 8;
      localThreadPoolParams.priority = 3;
      if (psn.a.b()) {
        localThreadPoolParams.queue = new RIJImageOptLinkedBlockingDeque(128);
      }
      this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = ((ThreadPoolExecutor)ThreadManager.newFreeThreadPool(localThreadPoolParams));
      return;
      int j = (int)(MemoryManager.getAvailClassSize() / 10L);
      i = j;
      if (j <= 4194304) {
        i = 4194304;
      }
    }
  }
  
  public static syn a()
  {
    if (jdField_a_of_type_Syn == null) {}
    try
    {
      if (jdField_a_of_type_Syn == null) {
        jdField_a_of_type_Syn = new syn();
      }
      return jdField_a_of_type_Syn;
    }
    finally {}
  }
  
  public CopyOnWriteArrayList<syo> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public syk a(syo paramsyo)
  {
    if (paramsyo == null) {
      return null;
    }
    return this.jdField_a_of_type_Syg.a(paramsyo);
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        syv.a(jdField_a_of_type_JavaLangString, "clean");
      }
      this.jdField_a_of_type_Syg.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((RunningJob)((Map.Entry)localIterator.next()).getValue()).a();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    finally {}
  }
  
  public void a(syo paramsyo)
  {
    try
    {
      if (paramsyo.b) {
        this.c.put(paramsyo, Boolean.valueOf(true));
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramsyo);
      this.b.remove(paramsyo);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(syo paramsyo, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	syn:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 219	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 195	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +19 -> 34
    //   18: aload_2
    //   19: invokevirtual 196	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   22: aload_0
    //   23: getfield 146	syn:jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   26: aload_2
    //   27: invokevirtual 223	java/util/concurrent/ThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 62	syn:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   38: aload_1
    //   39: invokevirtual 219	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 195	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -16 -> 31
    //   50: aload_1
    //   51: invokevirtual 196	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   54: goto -23 -> 31
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	syn
    //   0	62	1	paramsyo	syo
    //   0	62	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	57	finally
    //   18	31	57	finally
    //   34	46	57	finally
    //   50	54	57	finally
  }
  
  public void a(syo paramsyo, sym paramsym)
  {
    if (paramsyo != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        if (paramsyo.a == null)
        {
          psp.a(6, paramsyo);
          return;
        }
        localObject = this.jdField_a_of_type_Syg.a(paramsyo);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            syv.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramsyo + ", cache bitmap exist! callback:" + paramsym);
          }
          psp.b(1, paramsyo);
          if (paramsym != null) {
            paramsym.a(paramsyo, ((syk)localObject).a());
          }
          ((syk)localObject).a();
          psp.a(6, paramsyo);
          continue;
        }
        if (!paramsyo.b) {
          break label140;
        }
      }
      finally {}
      if (this.c.containsKey(paramsyo))
      {
        psp.a(6, paramsyo);
      }
      else
      {
        label140:
        RunningJob localRunningJob = (RunningJob)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramsyo);
        localObject = localRunningJob;
        if (localRunningJob == null)
        {
          localObject = localRunningJob;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            localObject = (RunningJob)this.b.get(paramsyo);
          }
        }
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            syv.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramsyo + " already exist", true);
          }
          ((RunningJob)localObject).a(paramsym);
          paramsyo.e = 0;
          psp.a(6, paramsyo);
        }
        else
        {
          localObject = new RunningJob(this, paramsyo);
          ((RunningJob)localObject).a(paramsym);
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (AbsDownloader.getFile(paramsyo.a.toString()) == null))
          {
            this.b.put(paramsyo, localObject);
            if (QLog.isColorLevel()) {
              syv.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramsyo + " add to pending queue", true);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramsyo, localObject);
            psp.a(2, paramsyo);
            ThreadManager.post(new ImageManager.1(this, paramsyo, (RunningJob)localObject), 10, null, true);
          }
        }
      }
    }
  }
  
  public boolean a(URL paramURL)
  {
    return (paramURL != null) && (AbsDownloader.getFile(paramURL.toString()) != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      syv.a(jdField_a_of_type_JavaLangString, "pause", true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(syo paramsyo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramsyo);
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      syv.a(jdField_a_of_type_JavaLangString, "resume", true);
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
  
  public void c(syo paramsyo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramsyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syn
 * JD-Core Version:    0.7.0.1
 */