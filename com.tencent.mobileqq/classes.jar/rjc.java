import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class rjc<K, V>
{
  private Map a = new LinkedHashMap();
  
  public void a(V paramV, rjd paramrjd)
  {
    this.a.put(paramrjd, paramV);
  }
  
  public boolean a(K paramK, rje paramrje)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      rjd localrjd = (rjd)localIterator.next();
      if ((localrjd != null) && (!localrjd.a(paramK)))
      {
        if ((paramrje != null) && (this.a.get(localrjd) != null)) {
          paramrje.a(this.a.get(localrjd));
        }
        return false;
      }
    }
    if (paramrje != null) {
      paramrje.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjc
 * JD-Core Version:    0.7.0.1
 */