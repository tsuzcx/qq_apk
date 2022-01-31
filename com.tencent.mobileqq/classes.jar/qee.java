import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qee
{
  public static <T> int a(Iterable<T> paramIterable, qeg<T> paramqeg)
  {
    if (paramIterable != null)
    {
      int i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        if (paramqeg.a(paramIterable.next())) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static <T, E> List<E> a(Iterable<T> paramIterable, qef<T, E> paramqef)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramqef != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add(paramqef.a(paramIterable.next()));
      }
    }
    return localArrayList;
  }
  
  public static <T> List<T> a(Iterable<T> paramIterable, qeg<T> paramqeg)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (paramqeg != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (paramqeg.a(localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qee
 * JD-Core Version:    0.7.0.1
 */