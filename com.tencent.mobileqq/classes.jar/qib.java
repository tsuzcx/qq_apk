import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qib
  implements awus<awog>
{
  private List<qic> a = new ArrayList();
  
  public List<awog> a(awvg paramawvg)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      qic localqic = (qic)localIterator.next();
      if (localqic.a(paramawvg.a)) {
        localArrayList.add(localqic);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = osj.a().c().iterator();
    while (localIterator.hasNext())
    {
      qbc localqbc = (qbc)localIterator.next();
      this.a.add(new qic(localqbc));
    }
  }
  
  public void a(awvg paramawvg, awut<awog> paramawut)
  {
    paramawut.a(a(paramawvg), 1);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qib
 * JD-Core Version:    0.7.0.1
 */