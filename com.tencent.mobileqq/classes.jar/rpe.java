import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rpe
  implements bbfe<bayt>
{
  private List<rpf> a = new ArrayList();
  
  public List<bayt> a(bbfs parambbfs)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      rpf localrpf = (rpf)localIterator.next();
      if (localrpf.a(parambbfs.a)) {
        localArrayList.add(localrpf);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = pkm.a().c().iterator();
    while (localIterator.hasNext())
    {
      rcz localrcz = (rcz)localIterator.next();
      this.a.add(new rpf(localrcz));
    }
  }
  
  public void a(bbfs parambbfs, bbff<bayt> parambbff)
  {
    parambbff.a(a(parambbfs), 1);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpe
 * JD-Core Version:    0.7.0.1
 */