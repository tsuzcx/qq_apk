import java.util.HashMap;

public class lfd
{
  public int a;
  protected HashMap<String, Integer> a;
  
  public static int a(lfd paramlfd, String paramString)
  {
    if (paramlfd == null) {}
    while ((paramlfd.a == null) || (!paramlfd.a.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)paramlfd.a.get(paramString)).intValue();
  }
  
  public static void a(lfd paramlfd, String paramString, int paramInt)
  {
    if (paramlfd == null) {
      return;
    }
    if (paramlfd.a == null) {
      paramlfd.a = new HashMap();
    }
    paramlfd.a.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfd
 * JD-Core Version:    0.7.0.1
 */