import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

final class nbk
  extends ThreadLocal<CharsetDecoder>
{
  protected CharsetDecoder a()
  {
    return Charset.forName("UTF-8").newDecoder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbk
 * JD-Core Version:    0.7.0.1
 */