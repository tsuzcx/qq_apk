import java.util.HashMap;

public class lfz
{
  public int a;
  protected HashMap<String, Integer> a;
  
  public static int a(lfz paramlfz, String paramString)
  {
    if (paramlfz == null) {}
    while ((paramlfz.a == null) || (!paramlfz.a.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)paramlfz.a.get(paramString)).intValue();
  }
  
  public static void a(lfz paramlfz, String paramString, int paramInt)
  {
    if (paramlfz == null) {
      return;
    }
    if (paramlfz.a == null) {
      paramlfz.a = new HashMap();
    }
    paramlfz.a.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfz
 * JD-Core Version:    0.7.0.1
 */