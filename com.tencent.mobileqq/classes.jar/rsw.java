import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rsw
{
  public static <T> int a(Iterable<T> paramIterable, rsy<T> paramrsy)
  {
    if (paramIterable != null)
    {
      int i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        if (paramrsy.a(paramIterable.next())) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static <T, E> List<E> a(Iterable<T> paramIterable, rsx<T, E> paramrsx)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramrsx != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add(paramrsx.a(paramIterable.next()));
      }
    }
    return localArrayList;
  }
  
  public static <T> List<T> a(Iterable<T> paramIterable, rsy<T> paramrsy)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramrsy != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (paramrsy.a(localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsw
 * JD-Core Version:    0.7.0.1
 */