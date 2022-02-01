import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class rsg<K, V>
{
  private Map a = new LinkedHashMap();
  
  public void a(V paramV, rsh paramrsh)
  {
    this.a.put(paramrsh, paramV);
  }
  
  public boolean a(K paramK, rsi paramrsi)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      rsh localrsh = (rsh)localIterator.next();
      if ((localrsh != null) && (!localrsh.a(paramK)))
      {
        if ((paramrsi != null) && (this.a.get(localrsh) != null)) {
          paramrsi.a(this.a.get(localrsh));
        }
        return false;
      }
    }
    if (paramrsi != null) {
      paramrsi.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsg
 * JD-Core Version:    0.7.0.1
 */