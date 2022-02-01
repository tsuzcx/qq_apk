import java.nio.charset.Charset;

final class nqc
  extends ThreadLocal<Charset>
{
  protected Charset a()
  {
    return Charset.forName("UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nqc
 * JD-Core Version:    0.7.0.1
 */