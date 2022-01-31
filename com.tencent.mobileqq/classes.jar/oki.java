import java.util.ArrayList;
import java.util.List;

public class oki
{
  private static List<ooe> a;
  
  private oki()
  {
    a = new ArrayList();
  }
  
  public static oki a()
  {
    return okk.a();
  }
  
  public List<ooe> a()
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
  
  public void a(ooe paramooe)
  {
    if ((paramooe == null) || (a == null)) {}
    while (a.contains(paramooe)) {
      return;
    }
    a.add(paramooe);
  }
  
  public void b(ooe paramooe)
  {
    if ((a == null) || (a.size() == 0)) {}
    while (!a.contains(paramooe)) {
      return;
    }
    a.remove(paramooe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oki
 * JD-Core Version:    0.7.0.1
 */