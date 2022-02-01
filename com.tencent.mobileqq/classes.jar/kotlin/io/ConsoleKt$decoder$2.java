package kotlin.io;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/nio/charset/CharsetDecoder;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class ConsoleKt$decoder$2
  extends Lambda
  implements Function0<CharsetDecoder>
{
  public static final 2 INSTANCE = new 2();
  
  ConsoleKt$decoder$2()
  {
    super(0);
  }
  
  public final CharsetDecoder invoke()
  {
    return Charset.defaultCharset().newDecoder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.io.ConsoleKt.decoder.2
 * JD-Core Version:    0.7.0.1
 */