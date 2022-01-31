import java.util.HashMap;

public class kvp
{
  public int a;
  protected HashMap<String, Integer> a;
  
  public static int a(kvp paramkvp, String paramString)
  {
    if (paramkvp == null) {}
    while ((paramkvp.a == null) || (!paramkvp.a.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)paramkvp.a.get(paramString)).intValue();
  }
  
  public static void a(kvp paramkvp, String paramString, int paramInt)
  {
    if (paramkvp == null) {
      return;
    }
    if (paramkvp.a == null) {
      paramkvp.a = new HashMap();
    }
    paramkvp.a.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kvp
 * JD-Core Version:    0.7.0.1
 */