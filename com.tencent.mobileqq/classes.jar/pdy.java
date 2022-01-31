import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;

public class pdy
{
  private static int a;
  private static int b;
  private static int c;
  private static int d;
  
  public static void a()
  {
    a = Aladdin.getConfig(293).getIntegerFromString("reportOn", 0);
    b = Aladdin.getConfig(293).getIntegerFromString("optOn", 0);
    c = Aladdin.getConfig(293).getIntegerFromString("lifoOn", 0);
    d = Aladdin.getConfig(293).getIntegerFromString("renderFirst", 0);
  }
  
  public static boolean a()
  {
    return a == 1;
  }
  
  public static boolean b()
  {
    return c == 1;
  }
  
  public static boolean c()
  {
    return d == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pdy
 * JD-Core Version:    0.7.0.1
 */