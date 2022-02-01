import java.util.ArrayList;
import java.util.List;

public class osc
{
  private static List<owg> a;
  
  private osc()
  {
    a = new ArrayList();
  }
  
  public static osc a()
  {
    return ose.a();
  }
  
  public List<owg> a()
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
  
  public void a(owg paramowg)
  {
    if ((paramowg == null) || (a == null)) {}
    while (a.contains(paramowg)) {
      return;
    }
    a.add(paramowg);
  }
  
  public void b(owg paramowg)
  {
    if ((a == null) || (a.size() == 0)) {
      return;
    }
    a.remove(paramowg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osc
 * JD-Core Version:    0.7.0.1
 */