import java.util.ArrayList;
import java.util.List;

public class ofz
{
  private static List<ojt> a;
  
  private ofz()
  {
    a = new ArrayList();
  }
  
  public static ofz a()
  {
    return ogb.a();
  }
  
  public List<ojt> a()
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
  
  public void a(ojt paramojt)
  {
    if ((paramojt == null) || (a == null)) {}
    while (a.contains(paramojt)) {
      return;
    }
    a.add(paramojt);
  }
  
  public void b(ojt paramojt)
  {
    if ((a == null) || (a.size() == 0)) {}
    while (!a.contains(paramojt)) {
      return;
    }
    a.remove(paramojt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ofz
 * JD-Core Version:    0.7.0.1
 */