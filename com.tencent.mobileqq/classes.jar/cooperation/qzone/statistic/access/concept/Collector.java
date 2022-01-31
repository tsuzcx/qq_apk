package cooperation.qzone.statistic.access.concept;

import bjsw;
import bjsy;
import bjta;
import bjtd;
import bjtf;
import cooperation.qzone.statistic.access.WnsKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collector
  implements Runnable
{
  protected volatile long a;
  protected bjsw a;
  protected bjsy a;
  protected bjta a;
  protected bjtd a;
  protected bjtf a;
  protected Thread a;
  protected List<Statistic> a;
  protected volatile boolean a;
  protected long b;
  protected volatile boolean b;
  protected volatile boolean c;
  
  public Collector()
  {
    this.jdField_a_of_type_Bjsy = bjsy.jdField_a_of_type_Bjsy;
    this.jdField_a_of_type_Bjtd = bjtd.jdField_a_of_type_Bjtd;
    this.jdField_a_of_type_Bjsw = bjsw.jdField_a_of_type_Bjsw;
    this.jdField_a_of_type_Bjta = bjta.jdField_a_of_type_Bjta;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 3000L;
    this.jdField_a_of_type_Bjtf = new bjtf();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public bjsw a()
  {
    return this.jdField_a_of_type_Bjsw;
  }
  
  public bjta a()
  {
    return this.jdField_a_of_type_Bjta;
  }
  
  public bjtd a()
  {
    return this.jdField_a_of_type_Bjtd;
  }
  
  public bjtf a()
  {
    return this.jdField_a_of_type_Bjtf;
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
  
  public void a(bjsw parambjsw)
  {
    this.jdField_a_of_type_Bjsw = parambjsw;
  }
  
  public void a(bjsy parambjsy)
  {
    this.jdField_a_of_type_Bjsy = parambjsy;
  }
  
  public void a(bjta parambjta)
  {
    this.jdField_a_of_type_Bjta = parambjta;
  }
  
  public void a(bjtd parambjtd)
  {
    this.jdField_a_of_type_Bjtd = parambjtd;
  }
  
  public void a(Statistic paramStatistic)
  {
    this.jdField_a_of_type_Bjtf.a(paramStatistic);
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
    if ((this.jdField_a_of_type_Bjsy.a(this)) || (this.c))
    {
      this.c = false;
      localList = this.jdField_a_of_type_Bjtf.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.Collector
 * JD-Core Version:    0.7.0.1
 */