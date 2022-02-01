import java.util.ArrayList;
import java.util.List;

public class ord
{
  private static List<ovg> a;
  
  private ord()
  {
    a = new ArrayList();
  }
  
  public static ord a()
  {
    return orf.a();
  }
  
  public List<ovg> a()
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
  
  public void a(ovg paramovg)
  {
    if ((paramovg == null) || (a == null)) {}
    while (a.contains(paramovg)) {
      return;
    }
    a.add(paramovg);
  }
  
  public void b(ovg paramovg)
  {
    if ((a == null) || (a.size() == 0)) {
      return;
    }
    a.remove(paramovg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ord
 * JD-Core Version:    0.7.0.1
 */