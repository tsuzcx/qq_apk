import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rix
{
  public static <T> int a(Iterable<T> paramIterable, riz<T> paramriz)
  {
    if (paramIterable != null)
    {
      int i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        if (paramriz.a(paramIterable.next())) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static <T, E> List<E> a(Iterable<T> paramIterable, riy<T, E> paramriy)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramriy != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add(paramriy.a(paramIterable.next()));
      }
    }
    return localArrayList;
  }
  
  public static <T> List<T> a(Iterable<T> paramIterable, riz<T> paramriz)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramriz != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (paramriz.a(localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rix
 * JD-Core Version:    0.7.0.1
 */