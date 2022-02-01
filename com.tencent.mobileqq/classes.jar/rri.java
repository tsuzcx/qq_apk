import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rri
  implements bbtj<bbmy>
{
  private List<rrj> a = new ArrayList();
  
  public List<bbmy> a(bbtx parambbtx)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      rrj localrrj = (rrj)localIterator.next();
      if (localrrj.a(parambbtx.a)) {
        localArrayList.add(localrrj);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = pmh.a().c().iterator();
    while (localIterator.hasNext())
    {
      rfi localrfi = (rfi)localIterator.next();
      this.a.add(new rrj(localrfi));
    }
  }
  
  public void a(bbtx parambbtx, bbtk<bbmy> parambbtk)
  {
    parambbtk.a(a(parambbtx), 1);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rri
 * JD-Core Version:    0.7.0.1
 */