package shark;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofHeader$Companion;", "", "()V", "supportedVersions", "", "", "Lshark/HprofVersion;", "parseHeaderOf", "Lshark/HprofHeader;", "hprofFile", "Ljava/io/File;", "source", "Lokio/BufferedSource;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofHeader$Companion
{
  /* Error */
  @NotNull
  public final HprofHeader a(@NotNull java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 39
    //   3: invokestatic 45	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: invokevirtual 51	java/io/File:length	()J
    //   10: lconst_0
    //   11: lcmp
    //   12: ifeq +88 -> 100
    //   15: new 53	java/io/FileInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: checkcast 58	java/io/InputStream
    //   26: invokestatic 63	okio/Okio:source	(Ljava/io/InputStream;)Lokio/Source;
    //   29: invokestatic 67	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   32: checkcast 69	java/io/Closeable
    //   35: astore_3
    //   36: aconst_null
    //   37: checkcast 38	java/lang/Throwable
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: checkcast 71	okio/BufferedSource
    //   47: astore 4
    //   49: aload_2
    //   50: astore_1
    //   51: getstatic 75	shark/HprofHeader:a	Lshark/HprofHeader$Companion;
    //   54: astore 5
    //   56: aload_2
    //   57: astore_1
    //   58: aload 4
    //   60: ldc 77
    //   62: invokestatic 80	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   65: aload_2
    //   66: astore_1
    //   67: aload 5
    //   69: aload 4
    //   71: invokevirtual 83	shark/HprofHeader$Companion:a	(Lokio/BufferedSource;)Lshark/HprofHeader;
    //   74: astore 4
    //   76: aload_3
    //   77: aload_2
    //   78: invokestatic 89	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   81: aload 4
    //   83: areturn
    //   84: astore_2
    //   85: goto +8 -> 93
    //   88: astore_2
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: athrow
    //   93: aload_3
    //   94: aload_1
    //   95: invokestatic 89	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   98: aload_2
    //   99: athrow
    //   100: new 91	java/lang/IllegalArgumentException
    //   103: dup
    //   104: ldc 93
    //   106: invokespecial 96	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   109: checkcast 38	java/lang/Throwable
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	Companion
    //   0	113	1	paramFile	java.io.File
    //   40	38	2	localThrowable1	Throwable
    //   84	1	2	localObject1	Object
    //   88	11	2	localThrowable2	Throwable
    //   35	59	3	localCloseable	java.io.Closeable
    //   47	35	4	localObject2	Object
    //   54	14	5	localCompanion	Companion
    // Exception table:
    //   from	to	target	type
    //   43	49	84	finally
    //   51	56	84	finally
    //   58	65	84	finally
    //   67	76	84	finally
    //   91	93	84	finally
    //   43	49	88	java/lang/Throwable
    //   51	56	88	java/lang/Throwable
    //   58	65	88	java/lang/Throwable
    //   67	76	88	java/lang/Throwable
  }
  
  @NotNull
  public final HprofHeader a(@NotNull BufferedSource paramBufferedSource)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSource, "source");
    if ((paramBufferedSource.exhausted() ^ true))
    {
      String str = paramBufferedSource.readUtf8(paramBufferedSource.indexOf((byte)0));
      HprofVersion localHprofVersion = (HprofVersion)HprofHeader.d().get(str);
      if (localHprofVersion != null)
      {
        paramBufferedSource.skip(1L);
        int i = paramBufferedSource.readInt();
        return new HprofHeader(paramBufferedSource.readLong(), localHprofVersion, i);
      }
      paramBufferedSource = new StringBuilder();
      paramBufferedSource.append("Unsupported Hprof version [");
      paramBufferedSource.append(str);
      paramBufferedSource.append("] not in supported list ");
      paramBufferedSource.append(HprofHeader.d().keySet());
      throw ((Throwable)new IllegalStateException(paramBufferedSource.toString().toString()));
    }
    throw ((Throwable)new IllegalArgumentException("Source has no available bytes"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofHeader.Companion
 * JD-Core Version:    0.7.0.1
 */