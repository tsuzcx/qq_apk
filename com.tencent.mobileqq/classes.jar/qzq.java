import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qzq
{
  public static <T> int a(Iterable<T> paramIterable, qzs<T> paramqzs)
  {
    if (paramIterable != null)
    {
      int i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        if (paramqzs.a(paramIterable.next())) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static <T, E> List<E> a(Iterable<T> paramIterable, qzr<T, E> paramqzr)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramqzr != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add(paramqzr.a(paramIterable.next()));
      }
    }
    return localArrayList;
  }
  
  public static <T> List<T> a(Iterable<T> paramIterable, qzs<T> paramqzs)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramqzs != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (paramqzs.a(localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzq
 * JD-Core Version:    0.7.0.1
 */