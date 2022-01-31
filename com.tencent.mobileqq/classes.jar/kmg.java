import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public final class kmg
  extends ThreadLocal
{
  protected CharsetDecoder a()
  {
    return Charset.forName("UTF-8").newDecoder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kmg
 * JD-Core Version:    0.7.0.1
 */