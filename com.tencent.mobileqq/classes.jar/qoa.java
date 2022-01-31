import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qoa
{
  public static <T> int a(Iterable<T> paramIterable, qoc<T> paramqoc)
  {
    if (paramIterable != null)
    {
      int i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        if (paramqoc.a(paramIterable.next())) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static <T, E> List<E> a(Iterable<T> paramIterable, qob<T, E> paramqob)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramqob != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add(paramqob.a(paramIterable.next()));
      }
    }
    return localArrayList;
  }
  
  public static <T> List<T> a(Iterable<T> paramIterable, qoc<T> paramqoc)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramqoc != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (paramqoc.a(localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qoa
 * JD-Core Version:    0.7.0.1
 */