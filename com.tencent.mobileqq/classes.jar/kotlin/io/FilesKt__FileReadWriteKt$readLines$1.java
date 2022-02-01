package kotlin.io;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class FilesKt__FileReadWriteKt$readLines$1
  extends Lambda
  implements Function1<String, Unit>
{
  FilesKt__FileReadWriteKt$readLines$1(ArrayList paramArrayList)
  {
    super(1);
  }
  
  public final void invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "it");
    this.$result.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.io.FilesKt__FileReadWriteKt.readLines.1
 * JD-Core Version:    0.7.0.1
 */