import java.util.concurrent.ConcurrentHashMap;

public class oet
{
  public static ConcurrentHashMap<Integer, Object> a = new ConcurrentHashMap();
  
  public static Object a(int paramInt)
  {
    if (a.containsKey(Integer.valueOf(paramInt))) {
      return a.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    a.remove(Integer.valueOf(paramInt));
  }
  
  public static void a(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (a.containsKey(Integer.valueOf(paramInt))) {
      a.remove(Integer.valueOf(paramInt));
    }
    a.put(Integer.valueOf(paramInt), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oet
 * JD-Core Version:    0.7.0.1
 */