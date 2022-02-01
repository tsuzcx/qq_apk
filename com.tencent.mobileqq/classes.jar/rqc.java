import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class rqc<K, V>
{
  private Map a = new LinkedHashMap();
  
  public void a(V paramV, rqd paramrqd)
  {
    this.a.put(paramrqd, paramV);
  }
  
  public boolean a(K paramK, rqe paramrqe)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      rqd localrqd = (rqd)localIterator.next();
      if ((localrqd != null) && (!localrqd.a(paramK)))
      {
        if ((paramrqe != null) && (this.a.get(localrqd) != null)) {
          paramrqe.a(this.a.get(localrqd));
        }
        return false;
      }
    }
    if (paramrqe != null) {
      paramrqe.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqc
 * JD-Core Version:    0.7.0.1
 */