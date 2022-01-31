import android.os.SystemClock;

public class lui
{
  private static volatile long a;
  
  public static long a()
  {
    return a;
  }
  
  public static void a()
  {
    a = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lui
 * JD-Core Version:    0.7.0.1
 */