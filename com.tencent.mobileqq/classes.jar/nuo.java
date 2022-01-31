import java.util.ArrayList;
import java.util.List;

public class nuo
{
  private static List<nyi> a;
  
  private nuo()
  {
    a = new ArrayList();
  }
  
  public static nuo a()
  {
    return nuq.a();
  }
  
  public List<nyi> a()
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
  
  public void a(nyi paramnyi)
  {
    if ((paramnyi == null) || (a == null)) {}
    while (a.contains(paramnyi)) {
      return;
    }
    a.add(paramnyi);
  }
  
  public void b(nyi paramnyi)
  {
    if ((a == null) || (a.size() == 0)) {}
    while (!a.contains(paramnyi)) {
      return;
    }
    a.remove(paramnyi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nuo
 * JD-Core Version:    0.7.0.1
 */