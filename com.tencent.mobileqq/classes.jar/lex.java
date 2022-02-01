import java.util.HashMap;

public class lex
{
  public int a;
  protected HashMap<String, Integer> a;
  
  public static int a(lex paramlex, String paramString)
  {
    if (paramlex == null) {}
    while ((paramlex.a == null) || (!paramlex.a.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)paramlex.a.get(paramString)).intValue();
  }
  
  public static void a(lex paramlex, String paramString, int paramInt)
  {
    if (paramlex == null) {
      return;
    }
    if (paramlex.a == null) {
      paramlex.a = new HashMap();
    }
    paramlex.a.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lex
 * JD-Core Version:    0.7.0.1
 */