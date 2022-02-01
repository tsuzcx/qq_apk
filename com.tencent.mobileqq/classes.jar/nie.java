import java.util.Iterator;
import java.util.List;

public class nie
{
  public static nhu a()
  {
    return a(1);
  }
  
  public static nhu a(int paramInt)
  {
    Object localObject = ardc.a().a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        nhu localnhu = (nhu)((Iterator)localObject).next();
        if (localnhu.a == paramInt) {
          return localnhu;
        }
      }
    }
    return new nhu(0, 10, 15);
  }
  
  public static nhu b()
  {
    return a(2);
  }
  
  public static nhu c()
  {
    return a(3);
  }
  
  public static nhu d()
  {
    return a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nie
 * JD-Core Version:    0.7.0.1
 */