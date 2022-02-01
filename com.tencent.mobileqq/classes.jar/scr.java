import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class scr<K, V>
{
  private Map a = new LinkedHashMap();
  
  public void a(V paramV, scs paramscs)
  {
    this.a.put(paramscs, paramV);
  }
  
  public boolean a(K paramK, sct paramsct)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      scs localscs = (scs)localIterator.next();
      if ((localscs != null) && (!localscs.a(paramK)))
      {
        if ((paramsct != null) && (this.a.get(localscs) != null)) {
          paramsct.a(this.a.get(localscs));
        }
        return false;
      }
    }
    if (paramsct != null) {
      paramsct.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scr
 * JD-Core Version:    0.7.0.1
 */