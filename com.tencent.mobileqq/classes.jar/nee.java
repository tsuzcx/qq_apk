import java.nio.charset.Charset;

final class nee
  extends ThreadLocal<Charset>
{
  protected Charset a()
  {
    return Charset.forName("UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nee
 * JD-Core Version:    0.7.0.1
 */