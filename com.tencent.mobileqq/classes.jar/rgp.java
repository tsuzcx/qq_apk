import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rgp
{
  public static <T> int a(Iterable<T> paramIterable, rgr<T> paramrgr)
  {
    if (paramIterable != null)
    {
      int i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        if (paramrgr.a(paramIterable.next())) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static <T, E> List<E> a(Iterable<T> paramIterable, rgq<T, E> paramrgq)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramrgq != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add(paramrgq.a(paramIterable.next()));
      }
    }
    return localArrayList;
  }
  
  public static <T> List<T> a(Iterable<T> paramIterable, rgr<T> paramrgr)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramrgr != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (paramrgr.a(localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgp
 * JD-Core Version:    0.7.0.1
 */