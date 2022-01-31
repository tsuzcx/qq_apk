package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/AccessDeniedException;", "Lkotlin/io/FileSystemException;", "file", "Ljava/io/File;", "other", "reason", "", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class AccessDeniedException
  extends FileSystemException
{
  public AccessDeniedException(@NotNull File paramFile1, @Nullable File paramFile2, @Nullable String paramString)
  {
    super(paramFile1, paramFile2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.io.AccessDeniedException
 * JD-Core Version:    0.7.0.1
 */