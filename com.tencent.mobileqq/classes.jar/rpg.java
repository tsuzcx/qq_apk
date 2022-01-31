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

public class rpg
{
  public static final String a;
  private static rpg a;
  public HashMap<rph, RunningJob> a;
  public ThreadPoolExecutor a;
  public AtomicBoolean a;
  public roz a;
  public HashMap<rph, RunningJob> b = new HashMap();
  private HashMap<rph, Boolean> c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + rpg.class.getSimpleName();
  }
  
  private rpg()
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
        rpn.a(jdField_a_of_type_JavaLangString, "start memLimit:" + i);
      }
      this.jdField_a_of_type_Roz = new roz(i);
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
  
  public static rpg a()
  {
    if (jdField_a_of_type_Rpg == null) {}
    try
    {
      if (jdField_a_of_type_Rpg == null) {
        jdField_a_of_type_Rpg = new rpg();
      }
      return jdField_a_of_type_Rpg;
    }
    finally {}
  }
  
  public rpd a(rph paramrph)
  {
    if (paramrph == null) {
      return null;
    }
    return this.jdField_a_of_type_Roz.a(paramrph);
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        rpn.a(jdField_a_of_type_JavaLangString, "clean");
      }
      this.jdField_a_of_type_Roz.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((RunningJob)((Map.Entry)localIterator.next()).getValue()).a();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
  }
  
  public void a(rph paramrph)
  {
    try
    {
      if (paramrph.b) {
        this.c.put(paramrph, Boolean.valueOf(true));
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramrph);
      this.b.remove(paramrph);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(rph paramrph, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	rpg:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 194	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 170	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +19 -> 34
    //   18: aload_2
    //   19: invokevirtual 171	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   22: aload_0
    //   23: getfield 125	rpg:jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   26: aload_2
    //   27: invokevirtual 198	java/util/concurrent/ThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 55	rpg:b	Ljava/util/HashMap;
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
    //   0	62	0	this	rpg
    //   0	62	1	paramrph	rph
    //   0	62	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	57	finally
    //   18	31	57	finally
    //   34	46	57	finally
    //   50	54	57	finally
  }
  
  public void a(rph paramrph, rpf paramrpf)
  {
    if (paramrph != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = paramrph.a;
        if (localObject == null) {
          return;
        }
        localObject = this.jdField_a_of_type_Roz.a(paramrph);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            rpn.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramrph + ", cache bitmap exist! callback:" + paramrpf);
          }
          if (paramrpf != null) {
            paramrpf.a(paramrph, ((rpd)localObject).a());
          }
          ((rpd)localObject).a();
          continue;
        }
        if (!paramrph.b) {
          break label116;
        }
      }
      finally {}
      if (!this.c.containsKey(paramrph))
      {
        label116:
        RunningJob localRunningJob = (RunningJob)this.jdField_a_of_type_JavaUtilHashMap.get(paramrph);
        localObject = localRunningJob;
        if (localRunningJob == null)
        {
          localObject = localRunningJob;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            localObject = (RunningJob)this.b.get(paramrph);
          }
        }
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            rpn.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramrph + " already exist", true);
          }
          ((RunningJob)localObject).a(paramrpf);
        }
        else
        {
          localObject = new RunningJob(this, paramrph);
          ((RunningJob)localObject).a(paramrpf);
          ThreadManager.executeOnSubThread(new ImageManager.1(this, paramrph, (RunningJob)localObject));
        }
      }
    }
  }
  
  public boolean a(URL paramURL)
  {
    return (paramURL != null) && (ayoi.a(paramURL.toString()) != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      rpn.a(jdField_a_of_type_JavaLangString, "pause", true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      rpn.a(jdField_a_of_type_JavaLangString, "resume", true);
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
 * Qualified Name:     rpg
 * JD-Core Version:    0.7.0.1
 */