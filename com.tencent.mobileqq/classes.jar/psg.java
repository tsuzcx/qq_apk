import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class psg
{
  public static <T> int a(Iterable<T> paramIterable, psi<T> parampsi)
  {
    if (paramIterable != null)
    {
      int i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        if (parampsi.a(paramIterable.next())) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static <T, E> List<E> a(Iterable<T> paramIterable, psh<T, E> parampsh)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (parampsh != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add(parampsh.a(paramIterable.next()));
      }
    }
    return localArrayList;
  }
  
  public static <T> List<T> a(Iterable<T> paramIterable, psi<T> parampsi)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIterable != null) && (parampsi != null))
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (parampsi.a(localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     psg
 * JD-Core Version:    0.7.0.1
 */