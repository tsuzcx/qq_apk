import android.os.Looper;

public final class plp
{
  public static final plq a;
  
  static
  {
    if (Looper.getMainLooper() != null) {}
    for (Looper localLooper = Looper.getMainLooper();; localLooper = Looper.myLooper())
    {
      a = new plq(localLooper);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     plp
 * JD-Core Version:    0.7.0.1
 */