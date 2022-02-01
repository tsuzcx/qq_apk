import java.util.Iterator;
import java.util.List;

public class ngj
{
  public static nfz a()
  {
    return a(1);
  }
  
  public static nfz a(int paramInt)
  {
    Object localObject = aqnx.a().a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        nfz localnfz = (nfz)((Iterator)localObject).next();
        if (localnfz.a == paramInt) {
          return localnfz;
        }
      }
    }
    return new nfz(0, 10, 15);
  }
  
  public static nfz b()
  {
    return a(2);
  }
  
  public static nfz c()
  {
    return a(3);
  }
  
  public static nfz d()
  {
    return a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ngj
 * JD-Core Version:    0.7.0.1
 */