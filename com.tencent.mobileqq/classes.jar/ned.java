import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

final class ned
  extends ThreadLocal<CharsetDecoder>
{
  protected CharsetDecoder a()
  {
    return Charset.forName("UTF-8").newDecoder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ned
 * JD-Core Version:    0.7.0.1
 */