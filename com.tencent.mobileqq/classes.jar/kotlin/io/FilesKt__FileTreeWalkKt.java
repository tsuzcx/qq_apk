package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"walk", "Lkotlin/io/FileTreeWalk;", "Ljava/io/File;", "direction", "Lkotlin/io/FileWalkDirection;", "walkBottomUp", "walkTopDown", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/io/FilesKt")
class FilesKt__FileTreeWalkKt
  extends FilesKt__FileReadWriteKt
{
  @NotNull
  public static final FileTreeWalk walk(@NotNull File paramFile, @NotNull FileWalkDirection paramFileWalkDirection)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$walk");
    Intrinsics.checkParameterIsNotNull(paramFileWalkDirection, "direction");
    return new FileTreeWalk(paramFile, paramFileWalkDirection);
  }
  
  @NotNull
  public static final FileTreeWalk walkBottomUp(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$walkBottomUp");
    return FilesKt.walk(paramFile, FileWalkDirection.BOTTOM_UP);
  }
  
  @NotNull
  public static final FileTreeWalk walkTopDown(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$walkTopDown");
    return FilesKt.walk(paramFile, FileWalkDirection.TOP_DOWN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.io.FilesKt__FileTreeWalkKt
 * JD-Core Version:    0.7.0.1
 */