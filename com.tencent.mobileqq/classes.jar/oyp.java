import java.util.ArrayList;
import java.util.List;

public class oyp
{
  private static List<pcp> a;
  
  private oyp()
  {
    a = new ArrayList();
  }
  
  public static oyp a()
  {
    return oyr.a();
  }
  
  public List<pcp> a()
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
  
  public void a(pcp parampcp)
  {
    if ((parampcp == null) || (a == null)) {}
    while (a.contains(parampcp)) {
      return;
    }
    a.add(parampcp);
  }
  
  public void b(pcp parampcp)
  {
    if ((a == null) || (a.size() == 0)) {
      return;
    }
    a.remove(parampcp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyp
 * JD-Core Version:    0.7.0.1
 */