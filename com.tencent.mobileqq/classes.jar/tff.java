import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class tff
{
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<tfi>>> a = new ConcurrentHashMap();
  
  public static tff a()
  {
    return tfh.a();
  }
  
  private void a(String paramString, tfi paramtfi)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.a.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramtfi.hashCode()), new WeakReference(paramtfi));
    this.a.put(paramString, localConcurrentHashMap1);
    tlo.b("WSSimpleEventBus", 2, "registerReceiver event Name:" + paramString + ",key：[" + paramtfi.getClass().getSimpleName() + ":" + paramtfi.hashCode() + "], subscribers size:" + localConcurrentHashMap1.size());
  }
  
  private void b(String paramString, tfi paramtfi)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.a.get(paramString);
    if (localConcurrentHashMap == null) {
      return;
    }
    localConcurrentHashMap.remove(Integer.valueOf(paramtfi.hashCode()));
    if (localConcurrentHashMap.size() == 0) {
      this.a.remove(paramString);
    }
    tlo.b("WSSimpleEventBus", 2, "unRegisterReceiver event Name:" + paramString + ",key：[" + paramtfi.getClass().getSimpleName() + ":" + paramtfi.hashCode() + "], subscribers size:" + localConcurrentHashMap.size());
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject = (ConcurrentHashMap)this.a.get(paramWSSimpleBaseEvent.getClass().getName());
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((tfi)localWeakReference.get()).a(paramWSSimpleBaseEvent);
        }
      }
    }
  }
  
  public void a(tfi paramtfi)
  {
    if (paramtfi == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramtfi.a().iterator();
      while (localIterator.hasNext()) {
        a(((Class)localIterator.next()).getName(), paramtfi);
      }
    }
  }
  
  public void b(tfi paramtfi)
  {
    if (paramtfi == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramtfi.a().iterator();
      while (localIterator.hasNext()) {
        b(((Class)localIterator.next()).getName(), paramtfi);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tff
 * JD-Core Version:    0.7.0.1
 */