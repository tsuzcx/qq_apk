package okio;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, k=1, mv={1, 1, 16})
public final class Options
  extends AbstractList<ByteString>
  implements RandomAccess
{
  public static final Options.Companion Companion = new Options.Companion(null);
  @NotNull
  private final ByteString[] byteStrings;
  @NotNull
  private final int[] trie;
  
  private Options(ByteString[] paramArrayOfByteString, int[] paramArrayOfInt)
  {
    this.byteStrings = paramArrayOfByteString;
    this.trie = paramArrayOfInt;
  }
  
  @JvmStatic
  @NotNull
  public static final Options of(@NotNull ByteString... paramVarArgs)
  {
    return Companion.of(paramVarArgs);
  }
  
  @NotNull
  public ByteString get(int paramInt)
  {
    return this.byteStrings[paramInt];
  }
  
  @NotNull
  public final ByteString[] getByteStrings$okio()
  {
    return this.byteStrings;
  }
  
  public int getSize()
  {
    return this.byteStrings.length;
  }
  
  @NotNull
  public final int[] getTrie$okio()
  {
    return this.trie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Options
 * JD-Core Version:    0.7.0.1
 */