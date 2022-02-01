import java.util.HashMap;

public class lfe
{
  public int a;
  protected HashMap<String, Integer> a;
  
  public static int a(lfe paramlfe, String paramString)
  {
    if (paramlfe == null) {}
    while ((paramlfe.a == null) || (!paramlfe.a.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)paramlfe.a.get(paramString)).intValue();
  }
  
  public static void a(lfe paramlfe, String paramString, int paramInt)
  {
    if (paramlfe == null) {
      return;
    }
    if (paramlfe.a == null) {
      paramlfe.a = new HashMap();
    }
    paramlfe.a.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfe
 * JD-Core Version:    0.7.0.1
 */