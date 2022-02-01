import java.util.ArrayList;
import java.util.List;

public class pac
{
  private static List<pfh> a;
  
  private pac()
  {
    a = new ArrayList();
  }
  
  public static pac a()
  {
    return pae.a();
  }
  
  public List<pfh> a()
  {
    if (a == null) {
      return null;
    }
    return a;
  }
  
  public void a()
  {
    if (a != null) {
      a.clear();
    }
  }
  
  public void a(pfh parampfh)
  {
    if ((parampfh == null) || (a == null)) {}
    while (a.contains(parampfh)) {
      return;
    }
    a.add(parampfh);
  }
  
  public void b(pfh parampfh)
  {
    if ((a == null) || (a.size() == 0)) {
      return;
    }
    a.remove(parampfh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pac
 * JD-Core Version:    0.7.0.1
 */