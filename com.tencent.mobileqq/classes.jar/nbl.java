import java.nio.charset.Charset;

final class nbl
  extends ThreadLocal<Charset>
{
  protected Charset a()
  {
    return Charset.forName("UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbl
 * JD-Core Version:    0.7.0.1
 */