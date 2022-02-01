package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "f", "Ljava/io/File;", "e", "Ljava/io/IOException;", "invoke"}, k=3, mv={1, 1, 16})
final class FilesKt__UtilsKt$copyRecursively$2
  extends Lambda
  implements Function2<File, IOException, Unit>
{
  FilesKt__UtilsKt$copyRecursively$2(Function2 paramFunction2)
  {
    super(2);
  }
  
  public final void invoke(@NotNull File paramFile, @NotNull IOException paramIOException)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "f");
    Intrinsics.checkParameterIsNotNull(paramIOException, "e");
    if ((OnErrorAction)this.$onError.invoke(paramFile, paramIOException) == OnErrorAction.TERMINATE) {
      throw ((Throwable)new TerminateException(paramFile));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.io.FilesKt__UtilsKt.copyRecursively.2
 * JD-Core Version:    0.7.0.1
 */