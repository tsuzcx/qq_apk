package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/File;", "exception", "Ljava/io/IOException;", "invoke"}, k=3, mv={1, 1, 16})
final class FilesKt__UtilsKt$copyRecursively$1
  extends Lambda
  implements Function2
{
  public static final 1 INSTANCE = new 1();
  
  FilesKt__UtilsKt$copyRecursively$1()
  {
    super(2);
  }
  
  @NotNull
  public final Void invoke(@NotNull File paramFile, @NotNull IOException paramIOException)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(paramIOException, "exception");
    throw ((Throwable)paramIOException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.FilesKt__UtilsKt.copyRecursively.1
 * JD-Core Version:    0.7.0.1
 */