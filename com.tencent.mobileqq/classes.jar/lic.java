import java.util.HashMap;

public class lic
{
  public int a;
  protected HashMap<String, Integer> a;
  
  public static int a(lic paramlic, String paramString)
  {
    if (paramlic == null) {}
    while ((paramlic.a == null) || (!paramlic.a.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)paramlic.a.get(paramString)).intValue();
  }
  
  public static void a(lic paramlic, String paramString, int paramInt)
  {
    if (paramlic == null) {
      return;
    }
    if (paramlic.a == null) {
      paramlic.a = new HashMap();
    }
    paramlic.a.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lic
 * JD-Core Version:    0.7.0.1
 */