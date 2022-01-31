import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.ReportWatchVideoEntry;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class tcp
  implements tch
{
  private final LinkedList<tcq> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private ConcurrentHashMap<Integer, tnq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private void e()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager().a(ReportWatchVideoEntry.class, ReportWatchVideoEntry.class.getSimpleName(), false, null, null, null, null, null, null);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ReportWatchVideoEntry localReportWatchVideoEntry = (ReportWatchVideoEntry)((Iterator)localObject).next();
        tcq localtcq = new tcq();
        localtcq.a(localReportWatchVideoEntry);
        this.jdField_a_of_type_JavaUtilLinkedList.add(localtcq);
      }
    }
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList.size());
    ((ArrayList)localObject).addAll(this.jdField_a_of_type_JavaUtilLinkedList);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      tcq localtcq = (tcq)((Iterator)localObject).next();
      if (localtcq.jdField_a_of_type_Long < l - 86400000L)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(localtcq);
        localArrayList.add(localtcq);
      }
    }
    a(localArrayList);
  }
  
  private void g()
  {
    Object localObject = new ArrayList(tlm.a);
    int i = 0;
    while ((this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) && (i < tlm.a))
    {
      ((ArrayList)localObject).add(this.jdField_a_of_type_JavaUtilLinkedList.removeFirst());
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = new tlm().a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet(), (ArrayList)localObject);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(((tnq)localObject).c), localObject);
    }
  }
  
  public void a() {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    a(new tcq(paramString1, paramString2, paramBoolean1, paramLong, paramInt1, paramInt2), paramBoolean2);
  }
  
  public void a(tcq paramtcq, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramtcq))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramtcq);
        ved.d("Q.qqstory:ReportWatchVideoManager", String.format("saveWatchVid vid=%s, videoUid=%s, list size=%d", new Object[] { paramtcq.jdField_a_of_type_JavaLangString, paramtcq.b, Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      }
      if (paramBoolean) {
        QQStoryContext.a().a().createEntityManager().b(paramtcq.a());
      }
      return;
    }
  }
  
  public void a(@NonNull tnq paramtnq)
  {
    try
    {
      ved.d("Q.qqstory:ReportWatchVideoManager", "handleResponse. requestHashMap.size()=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramtnq.c));
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
        {
          paramtnq = new tcr();
          stb.a().dispatch(paramtnq);
        }
      }
      return;
    }
    finally
    {
      paramtnq = finally;
      throw paramtnq;
    }
  }
  
  public boolean a(List<tcq> paramList)
  {
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    aukr localaukr = localaukp.a();
    try
    {
      localaukr.a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        tcq localtcq = (tcq)paramList.next();
        ReportWatchVideoEntry localReportWatchVideoEntry = new ReportWatchVideoEntry();
        localReportWatchVideoEntry.setStatus(1001);
        localaukp.a(localReportWatchVideoEntry, "vid=?", new String[] { localtcq.jdField_a_of_type_JavaLangString });
      }
    }
    finally
    {
      localaukr.b();
    }
    localaukr.b();
    return false;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        e();
        ved.d("Q.qqstory:ReportWatchVideoManager", String.format("init. reportWatchVideoList.size=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      }
      f();
      ved.d("Q.qqstory:ReportWatchVideoManager", String.format("startSendRequests. data size=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0)
      {
        tcr localtcr = new tcr();
        stb.a().dispatch(localtcr);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        g();
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tcp
 * JD-Core Version:    0.7.0.1
 */