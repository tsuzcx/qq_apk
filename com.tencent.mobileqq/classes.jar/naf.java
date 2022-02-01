import java.util.concurrent.ConcurrentHashMap;

public class naf
{
  private ConcurrentHashMap<String, nag> a = new ConcurrentHashMap();
  
  public nag a(String paramString)
  {
    return (nag)this.a.get(paramString);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(String paramString)
  {
    this.a.remove(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    nag localnag2 = (nag)this.a.get(paramString);
    nag localnag1 = localnag2;
    if (localnag2 == null)
    {
      localnag1 = new nag(paramString);
      this.a.put(paramString, localnag1);
    }
    localnag1.a = paramInt;
  }
  
  public void b(String paramString, int paramInt)
  {
    nag localnag2 = (nag)this.a.get(paramString);
    nag localnag1 = localnag2;
    if (localnag2 == null)
    {
      localnag1 = new nag(paramString);
      this.a.put(paramString, localnag1);
    }
    localnag1.b += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     naf
 * JD-Core Version:    0.7.0.1
 */