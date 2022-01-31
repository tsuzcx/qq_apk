import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qhy
  implements awuu<awoi>
{
  private List<qhz> a = new ArrayList();
  
  public List<awoi> a(awvi paramawvi)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      qhz localqhz = (qhz)localIterator.next();
      if (localqhz.a(paramawvi.a)) {
        localArrayList.add(localqhz);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = osg.a().c().iterator();
    while (localIterator.hasNext())
    {
      qaz localqaz = (qaz)localIterator.next();
      this.a.add(new qhz(localqaz));
    }
  }
  
  public void a(awvi paramawvi, awuv<awoi> paramawuv)
  {
    paramawuv.a(a(paramawvi), 1);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhy
 * JD-Core Version:    0.7.0.1
 */