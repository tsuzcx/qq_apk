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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public class sff
{
  public static final String a;
  private static sff a;
  public HashMap<sfg, RunningJob> a;
  public ThreadPoolExecutor a;
  public AtomicBoolean a;
  public sey a;
  public HashMap<sfg, RunningJob> b = new HashMap();
  private HashMap<sfg, Boolean> c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + sff.class.getSimpleName();
  }
  
  private sff()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    int i;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      BaseApplicationImpl.sImageCache.evict(0);
      i = BaseApplicationImpl.sImageCacheSize * 2 / 3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        sfm.a(jdField_a_of_type_JavaLangString, "start memLimit:" + i);
      }
      this.jdField_a_of_type_Sey = new sey(i);
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.poolThreadName = "image-manager";
      localThreadPoolParams.corePoolsize = 4;
      localThreadPoolParams.maxPooolSize = 8;
      localThreadPoolParams.priority = 3;
      if (pdy.b()) {
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
  
  public static sff a()
  {
    if (jdField_a_of_type_Sff == null) {}
    try
    {
      if (jdField_a_of_type_Sff == null) {
        jdField_a_of_type_Sff = new sff();
      }
      return jdField_a_of_type_Sff;
    }
    finally {}
  }
  
  public sfc a(sfg paramsfg)
  {
    if (paramsfg == null) {
      return null;
    }
    return this.jdField_a_of_type_Sey.a(paramsfg);
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        sfm.a(jdField_a_of_type_JavaLangString, "clean");
      }
      this.jdField_a_of_type_Sey.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((RunningJob)((Map.Entry)localIterator.next()).getValue()).a();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
  }
  
  public void a(sfg paramsfg)
  {
    try
    {
      if (paramsfg.b) {
        this.c.put(paramsfg, Boolean.valueOf(true));
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramsfg);
      this.b.remove(paramsfg);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(sfg paramsfg, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	sff:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 205	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 181	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +19 -> 34
    //   18: aload_2
    //   19: invokevirtual 182	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   22: aload_0
    //   23: getfield 136	sff:jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   26: aload_2
    //   27: invokevirtual 209	java/util/concurrent/ThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 55	sff:b	Ljava/util/HashMap;
    //   38: aload_1
    //   39: invokevirtual 205	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 181	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -16 -> 31
    //   50: aload_1
    //   51: invokevirtual 182	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   54: goto -23 -> 31
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	sff
    //   0	62	1	paramsfg	sfg
    //   0	62	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	57	finally
    //   18	31	57	finally
    //   34	46	57	finally
    //   50	54	57	finally
  }
  
  public void a(sfg paramsfg, sfe paramsfe)
  {
    if (paramsfg != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = paramsfg.a;
        if (localObject == null) {
          return;
        }
        localObject = this.jdField_a_of_type_Sey.a(paramsfg);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            sfm.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramsfg + ", cache bitmap exist! callback:" + paramsfe);
          }
          pdz.b(1, paramsfg);
          if (paramsfe != null) {
            paramsfe.a(paramsfg, ((sfc)localObject).a());
          }
          ((sfc)localObject).a();
          continue;
        }
        if (!paramsfg.b) {
          break label121;
        }
      }
      finally {}
      if (!this.c.containsKey(paramsfg))
      {
        label121:
        RunningJob localRunningJob = (RunningJob)this.jdField_a_of_type_JavaUtilHashMap.get(paramsfg);
        localObject = localRunningJob;
        if (localRunningJob == null)
        {
          localObject = localRunningJob;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            localObject = (RunningJob)this.b.get(paramsfg);
          }
        }
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            sfm.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramsfg + " already exist", true);
          }
          ((RunningJob)localObject).a(paramsfe);
        }
        else
        {
          localObject = new RunningJob(this, paramsfg);
          ((RunningJob)localObject).a(paramsfe);
          pdz.a(2, paramsfg);
          ThreadManager.executeOnSubThread(new ImageManager.1(this, paramsfg, (RunningJob)localObject));
        }
      }
    }
  }
  
  public boolean a(URL paramURL)
  {
    return (paramURL != null) && (bame.a(paramURL.toString()) != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      sfm.a(jdField_a_of_type_JavaLangString, "pause", true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      sfm.a(jdField_a_of_type_JavaLangString, "resume", true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    try
    {
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.jdField_a_of_type_JavaUtilHashMap.put(localEntry.getKey(), localEntry.getValue());
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute((Runnable)localEntry.getValue());
      }
      this.b.clear();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sff
 * JD-Core Version:    0.7.0.1
 */