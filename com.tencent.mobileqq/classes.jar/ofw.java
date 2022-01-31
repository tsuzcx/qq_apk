import java.util.ArrayList;
import java.util.List;

public class ofw
{
  private static List<ojq> a;
  
  private ofw()
  {
    a = new ArrayList();
  }
  
  public static ofw a()
  {
    return ofy.a();
  }
  
  public List<ojq> a()
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
  
  public void a(ojq paramojq)
  {
    if ((paramojq == null) || (a == null)) {}
    while (a.contains(paramojq)) {
      return;
    }
    a.add(paramojq);
  }
  
  public void b(ojq paramojq)
  {
    if ((a == null) || (a.size() == 0)) {}
    while (!a.contains(paramojq)) {
      return;
    }
    a.remove(paramojq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ofw
 * JD-Core Version:    0.7.0.1
 */