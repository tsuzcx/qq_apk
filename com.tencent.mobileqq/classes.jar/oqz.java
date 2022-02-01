import java.util.concurrent.ConcurrentHashMap;

public class oqz
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
    a.remove(Integer.valueOf(paramInt));
    a.put(Integer.valueOf(paramInt), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqz
 * JD-Core Version:    0.7.0.1
 */