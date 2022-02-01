package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/TerminateException;", "Lkotlin/io/FileSystemException;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class TerminateException
  extends FileSystemException
{
  public TerminateException(@NotNull File paramFile)
  {
    super(paramFile, null, null, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.TerminateException
 * JD-Core Version:    0.7.0.1
 */