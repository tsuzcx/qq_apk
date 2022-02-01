import java.util.Iterator;
import java.util.List;

public class nqt
{
  public static nqh a()
  {
    return a(1);
  }
  
  public static nqh a(int paramInt)
  {
    Object localObject = aqzv.a().a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        nqh localnqh = (nqh)((Iterator)localObject).next();
        if (localnqh.a == paramInt) {
          return localnqh;
        }
      }
    }
    return new nqh(0, 10, 15);
  }
  
  public static nqh b()
  {
    return a(2);
  }
  
  public static nqh c()
  {
    return a(3);
  }
  
  public static nqh d()
  {
    return a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nqt
 * JD-Core Version:    0.7.0.1
 */