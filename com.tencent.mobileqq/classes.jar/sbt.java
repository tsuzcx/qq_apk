import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sbt
  implements bclw<bcfj>
{
  private List<sbu> a = new ArrayList();
  
  public List<bcfj> a(bcmk parambcmk)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      sbu localsbu = (sbu)localIterator.next();
      if (localsbu.a(parambcmk.a)) {
        localArrayList.add(localsbu);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = pvj.a().c().iterator();
    while (localIterator.hasNext())
    {
      rpf localrpf = (rpf)localIterator.next();
      this.a.add(new sbu(localrpf));
    }
  }
  
  public void a(bcmk parambcmk, bclx<bcfj> parambclx)
  {
    parambclx.a(a(parambcmk), 1);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbt
 * JD-Core Version:    0.7.0.1
 */