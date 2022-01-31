import android.os.Looper;

public final class pjv
{
  public static final pjw a;
  
  static
  {
    if (Looper.getMainLooper() != null) {}
    for (Looper localLooper = Looper.getMainLooper();; localLooper = Looper.myLooper())
    {
      a = new pjw(localLooper);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjv
 * JD-Core Version:    0.7.0.1
 */