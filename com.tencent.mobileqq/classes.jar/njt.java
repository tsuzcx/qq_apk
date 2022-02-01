import java.util.Iterator;
import java.util.List;

public class njt
{
  public static njj a()
  {
    return a(1);
  }
  
  public static njj a(int paramInt)
  {
    Object localObject = apws.a().a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        njj localnjj = (njj)((Iterator)localObject).next();
        if (localnjj.a == paramInt) {
          return localnjj;
        }
      }
    }
    return new njj(0, 10, 15);
  }
  
  public static njj b()
  {
    return a(2);
  }
  
  public static njj c()
  {
    return a(3);
  }
  
  public static njj d()
  {
    return a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njt
 * JD-Core Version:    0.7.0.1
 */