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

public class spw
  implements spo
{
  private final LinkedList<spx> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private ConcurrentHashMap<Integer, tax> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
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
        spx localspx = new spx();
        localspx.a(localReportWatchVideoEntry);
        this.jdField_a_of_type_JavaUtilLinkedList.add(localspx);
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
      spx localspx = (spx)((Iterator)localObject).next();
      if (localspx.jdField_a_of_type_Long < l - 86400000L)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(localspx);
        localArrayList.add(localspx);
      }
    }
    a(localArrayList);
  }
  
  private void g()
  {
    Object localObject = new ArrayList(syt.a);
    int i = 0;
    while ((this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) && (i < syt.a))
    {
      ((ArrayList)localObject).add(this.jdField_a_of_type_JavaUtilLinkedList.removeFirst());
      i += 1;
    }
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = new syt().a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet(), (ArrayList)localObject);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(((tax)localObject).c), localObject);
    }
  }
  
  public void a() {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    a(new spx(paramString1, paramString2, paramBoolean1, paramLong, paramInt1, paramInt2), paramBoolean2);
  }
  
  public void a(spx paramspx, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramspx))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramspx);
        urk.d("Q.qqstory:ReportWatchVideoManager", String.format("saveWatchVid vid=%s, videoUid=%s, list size=%d", new Object[] { paramspx.jdField_a_of_type_JavaLangString, paramspx.b, Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      }
      if (paramBoolean) {
        QQStoryContext.a().a().createEntityManager().b(paramspx.a());
      }
      return;
    }
  }
  
  public void a(@NonNull tax paramtax)
  {
    try
    {
      urk.d("Q.qqstory:ReportWatchVideoManager", "handleResponse. requestHashMap.size()=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramtax.c));
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
        {
          paramtax = new spy();
          sgi.a().dispatch(paramtax);
        }
      }
      return;
    }
    finally
    {
      paramtax = finally;
      throw paramtax;
    }
  }
  
  public boolean a(List<spx> paramList)
  {
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    atmr localatmr = localatmp.a();
    try
    {
      localatmr.a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        spx localspx = (spx)paramList.next();
        ReportWatchVideoEntry localReportWatchVideoEntry = new ReportWatchVideoEntry();
        localReportWatchVideoEntry.setStatus(1001);
        localatmp.a(localReportWatchVideoEntry, "vid=?", new String[] { localspx.jdField_a_of_type_JavaLangString });
      }
    }
    finally
    {
      localatmr.b();
    }
    localatmr.b();
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
        urk.d("Q.qqstory:ReportWatchVideoManager", String.format("init. reportWatchVideoList.size=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      }
      f();
      urk.d("Q.qqstory:ReportWatchVideoManager", String.format("startSendRequests. data size=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0)
      {
        spy localspy = new spy();
        sgi.a().dispatch(localspy);
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
 * Qualified Name:     spw
 * JD-Core Version:    0.7.0.1
 */