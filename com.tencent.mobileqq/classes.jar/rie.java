import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rie
  implements bcmc<bcfr>
{
  private List<rif> a = new ArrayList();
  
  public List<bcfr> a(bcmq parambcmq)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      rif localrif = (rif)localIterator.next();
      if (localrif.a(parambcmq.a)) {
        localArrayList.add(localrif);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = pfa.a().c().iterator();
    while (localIterator.hasNext())
    {
      qwb localqwb = (qwb)localIterator.next();
      this.a.add(new rif(localqwb));
    }
  }
  
  public void a(bcmq parambcmq, bcmd<bcfr> parambcmd)
  {
    parambcmd.a(a(parambcmq), 1);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rie
 * JD-Core Version:    0.7.0.1
 */