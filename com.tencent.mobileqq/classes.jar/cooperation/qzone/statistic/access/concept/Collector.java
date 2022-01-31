package cooperation.qzone.statistic.access.concept;

import bhmn;
import bhmp;
import bhmr;
import bhmu;
import bhmw;
import cooperation.qzone.statistic.access.WnsKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collector
  implements Runnable
{
  protected volatile long a;
  protected bhmn a;
  protected bhmp a;
  protected bhmr a;
  protected bhmu a;
  protected bhmw a;
  protected Thread a;
  protected List<Statistic> a;
  protected volatile boolean a;
  protected long b;
  protected volatile boolean b;
  protected volatile boolean c;
  
  public Collector()
  {
    this.jdField_a_of_type_Bhmp = bhmp.jdField_a_of_type_Bhmp;
    this.jdField_a_of_type_Bhmu = bhmu.jdField_a_of_type_Bhmu;
    this.jdField_a_of_type_Bhmn = bhmn.jdField_a_of_type_Bhmn;
    this.jdField_a_of_type_Bhmr = bhmr.jdField_a_of_type_Bhmr;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 3000L;
    this.jdField_a_of_type_Bhmw = new bhmw();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public bhmn a()
  {
    return this.jdField_a_of_type_Bhmn;
  }
  
  public bhmr a()
  {
    return this.jdField_a_of_type_Bhmr;
  }
  
  public bhmu a()
  {
    return this.jdField_a_of_type_Bhmu;
  }
  
  public bhmw a()
  {
    return this.jdField_a_of_type_Bhmw;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangThread != null) && (this.jdField_a_of_type_JavaLangThread.isAlive()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
    this.jdField_a_of_type_JavaLangThread = new Thread(this, "com.qzone.statistic.access.concept");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangThread.setName("Statistic.Collector");
    if (!this.jdField_a_of_type_JavaLangThread.isAlive()) {
      this.jdField_a_of_type_JavaLangThread.start();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(bhmn parambhmn)
  {
    this.jdField_a_of_type_Bhmn = parambhmn;
  }
  
  public void a(bhmp parambhmp)
  {
    this.jdField_a_of_type_Bhmp = parambhmp;
  }
  
  public void a(bhmr parambhmr)
  {
    this.jdField_a_of_type_Bhmr = parambhmr;
  }
  
  public void a(bhmu parambhmu)
  {
    this.jdField_a_of_type_Bhmu = parambhmu;
  }
  
  public void a(Statistic paramStatistic)
  {
    this.jdField_a_of_type_Bhmw.a(paramStatistic);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    c();
  }
  
  public void c()
  {
    boolean bool = true;
    e();
    List localList;
    Object localObject1;
    if ((this.jdField_a_of_type_Bhmp.a(this)) || (this.c))
    {
      this.c = false;
      localList = this.jdField_a_of_type_Bhmw.a();
      if ((localList != null) && (localList.size() > 0))
      {
        if (this.jdField_b_of_type_Boolean) {
          i = 1;
        }
        for (;;)
        {
          localObject1 = localList.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((Statistic)((Iterator)localObject1).next()).setValue(WnsKeys.Frequency, Integer.valueOf(i));
          }
          if (a() == null) {
            i = 1;
          } else {
            i = a().a();
          }
        }
        localObject1 = localList.toArray();
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          localList.addAll(this.jdField_a_of_type_JavaUtilList);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          this.jdField_a_of_type_JavaUtilList.add((Statistic)localObject2);
          i += 1;
        }
        localObject1 = a().a(localList);
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label284;
          }
          this.jdField_b_of_type_Boolean = false;
          if (!bool) {
            break label302;
          }
        }
      }
    }
    label284:
    label302:
    for (int i = a().a((String)localObject1, localList.size());; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      d();
      return;
      if (a() == null) {
        break;
      }
      bool = a().a();
      break;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_Long > 0L) {}
    try
    {
      Thread.sleep(this.jdField_b_of_type_Long);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public void f()
  {
    this.c = true;
    if ((this.jdField_a_of_type_JavaLangThread != null) && (this.jdField_a_of_type_JavaLangThread.isAlive())) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
  }
  
  public void g()
  {
    try
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    while (this.jdField_a_of_type_Boolean) {
      c();
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.Collector
 * JD-Core Version:    0.7.0.1
 */