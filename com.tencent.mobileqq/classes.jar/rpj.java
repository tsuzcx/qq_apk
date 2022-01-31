import android.support.v4.util.MQLruCache;
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

public class rpj
{
  public static final String a;
  private static rpj a;
  public HashMap<rpk, RunningJob> a;
  public ThreadPoolExecutor a;
  public AtomicBoolean a;
  public rpc a;
  public HashMap<rpk, RunningJob> b = new HashMap();
  private HashMap<rpk, Boolean> c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + rpj.class.getSimpleName();
  }
  
  private rpj()
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
        rpq.a(jdField_a_of_type_JavaLangString, "start memLimit:" + i);
      }
      this.jdField_a_of_type_Rpc = new rpc(i);
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.poolThreadName = "image-manager";
      localThreadPoolParams.corePoolsize = 4;
      localThreadPoolParams.maxPooolSize = 8;
      localThreadPoolParams.priority = 3;
      this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = ((ThreadPoolExecutor)ThreadManager.newFreeThreadPool(localThreadPoolParams));
      return;
      int j = (int)(MemoryManager.a() / 10L);
      i = j;
      if (j <= 4194304) {
        i = 4194304;
      }
    }
  }
  
  public static rpj a()
  {
    if (jdField_a_of_type_Rpj == null) {}
    try
    {
      if (jdField_a_of_type_Rpj == null) {
        jdField_a_of_type_Rpj = new rpj();
      }
      return jdField_a_of_type_Rpj;
    }
    finally {}
  }
  
  public rpg a(rpk paramrpk)
  {
    if (paramrpk == null) {
      return null;
    }
    return this.jdField_a_of_type_Rpc.a(paramrpk);
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        rpq.a(jdField_a_of_type_JavaLangString, "clean");
      }
      this.jdField_a_of_type_Rpc.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((RunningJob)((Map.Entry)localIterator.next()).getValue()).a();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
  }
  
  public void a(rpk paramrpk)
  {
    try
    {
      if (paramrpk.b) {
        this.c.put(paramrpk, Boolean.valueOf(true));
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramrpk);
      this.b.remove(paramrpk);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(rpk paramrpk, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	rpj:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 194	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 170	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +19 -> 34
    //   18: aload_2
    //   19: invokevirtual 171	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   22: aload_0
    //   23: getfield 125	rpj:jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   26: aload_2
    //   27: invokevirtual 198	java/util/concurrent/ThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 55	rpj:b	Ljava/util/HashMap;
    //   38: aload_1
    //   39: invokevirtual 194	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 170	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -16 -> 31
    //   50: aload_1
    //   51: invokevirtual 171	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   54: goto -23 -> 31
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	rpj
    //   0	62	1	paramrpk	rpk
    //   0	62	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	57	finally
    //   18	31	57	finally
    //   34	46	57	finally
    //   50	54	57	finally
  }
  
  public void a(rpk paramrpk, rpi paramrpi)
  {
    if (paramrpk != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = paramrpk.a;
        if (localObject == null) {
          return;
        }
        localObject = this.jdField_a_of_type_Rpc.a(paramrpk);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            rpq.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramrpk + ", cache bitmap exist! callback:" + paramrpi);
          }
          if (paramrpi != null) {
            paramrpi.a(paramrpk, ((rpg)localObject).a());
          }
          ((rpg)localObject).a();
          continue;
        }
        if (!paramrpk.b) {
          break label116;
        }
      }
      finally {}
      if (!this.c.containsKey(paramrpk))
      {
        label116:
        RunningJob localRunningJob = (RunningJob)this.jdField_a_of_type_JavaUtilHashMap.get(paramrpk);
        localObject = localRunningJob;
        if (localRunningJob == null)
        {
          localObject = localRunningJob;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            localObject = (RunningJob)this.b.get(paramrpk);
          }
        }
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            rpq.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramrpk + " already exist", true);
          }
          ((RunningJob)localObject).a(paramrpi);
        }
        else
        {
          localObject = new RunningJob(this, paramrpk);
          ((RunningJob)localObject).a(paramrpi);
          ThreadManager.executeOnSubThread(new ImageManager.1(this, paramrpk, (RunningJob)localObject));
        }
      }
    }
  }
  
  public boolean a(URL paramURL)
  {
    return (paramURL != null) && (ayog.a(paramURL.toString()) != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      rpq.a(jdField_a_of_type_JavaLangString, "pause", true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      rpq.a(jdField_a_of_type_JavaLangString, "resume", true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpj
 * JD-Core Version:    0.7.0.1
 */