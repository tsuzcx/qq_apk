package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin._Assertions;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
abstract class FileTreeWalk$DirectoryState
  extends FileTreeWalk.WalkState
{
  public FileTreeWalk$DirectoryState(@NotNull File paramFile)
  {
    super(paramFile);
    if (_Assertions.ENABLED)
    {
      boolean bool = paramFile.isDirectory();
      if ((_Assertions.ENABLED) && (!bool)) {
        throw ((Throwable)new AssertionError("rootDir must be verified to be directory beforehand."));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.FileTreeWalk.DirectoryState
 * JD-Core Version:    0.7.0.1
 */