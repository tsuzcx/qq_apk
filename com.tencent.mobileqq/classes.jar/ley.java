import java.util.HashMap;

public class ley
{
  public int a;
  protected HashMap<String, Integer> a;
  
  public static int a(ley paramley, String paramString)
  {
    if (paramley == null) {}
    while ((paramley.a == null) || (!paramley.a.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)paramley.a.get(paramString)).intValue();
  }
  
  public static void a(ley paramley, String paramString, int paramInt)
  {
    if (paramley == null) {
      return;
    }
    if (paramley.a == null) {
      paramley.a = new HashMap();
    }
    paramley.a.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ley
 * JD-Core Version:    0.7.0.1
 */