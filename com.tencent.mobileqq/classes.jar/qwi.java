import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class qwi<K, V>
{
  private Map a = new LinkedHashMap();
  
  public void a(V paramV, qwj paramqwj)
  {
    this.a.put(paramqwj, paramV);
  }
  
  public boolean a(K paramK, qwk paramqwk)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      qwj localqwj = (qwj)localIterator.next();
      if ((localqwj != null) && (!localqwj.a(paramK)))
      {
        if ((paramqwk != null) && (this.a.get(localqwj) != null)) {
          paramqwk.a(this.a.get(localqwj));
        }
        return false;
      }
    }
    if (paramqwk != null) {
      paramqwk.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qwi
 * JD-Core Version:    0.7.0.1
 */