import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class oss
  extends ThreadLocal
{
  protected DateFormat a()
  {
    return new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oss
 * JD-Core Version:    0.7.0.1
 */