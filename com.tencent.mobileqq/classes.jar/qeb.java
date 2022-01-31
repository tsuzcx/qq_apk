import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qeb
{
  public static <T> int a(Iterable<T> paramIterable, qed<T> paramqed)
  {
    if (paramIterable != null)
    {
      int i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        if (paramqed.a(paramIterable.next())) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static <T, E> List<E> a(Iterable<T> paramIterable, qec<T, E> paramqec)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramqec != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add(paramqec.a(paramIterable.next()));
      }
    }
    return localArrayList;
  }
  
  public static <T> List<T> a(Iterable<T> paramIterable, qed<T> paramqed)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramqed != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (paramqed.a(localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qeb
 * JD-Core Version:    0.7.0.1
 */