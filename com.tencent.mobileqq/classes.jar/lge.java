import java.util.HashMap;

public class lge
{
  public int a;
  protected HashMap<String, Integer> a;
  
  public static int a(lge paramlge, String paramString)
  {
    if (paramlge == null) {}
    while ((paramlge.a == null) || (!paramlge.a.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)paramlge.a.get(paramString)).intValue();
  }
  
  public static void a(lge paramlge, String paramString, int paramInt)
  {
    if (paramlge == null) {
      return;
    }
    if (paramlge.a == null) {
      paramlge.a = new HashMap();
    }
    paramlge.a.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lge
 * JD-Core Version:    0.7.0.1
 */