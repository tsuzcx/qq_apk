package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileSystemException;", "Ljava/io/IOException;", "file", "Ljava/io/File;", "other", "reason", "", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getOther", "getReason", "()Ljava/lang/String;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public class FileSystemException
  extends IOException
{
  @NotNull
  private final File file;
  @Nullable
  private final File other;
  @Nullable
  private final String reason;
  
  public FileSystemException(@NotNull File paramFile1, @Nullable File paramFile2, @Nullable String paramString)
  {
    super(ExceptionsKt.access$constructMessage(paramFile1, paramFile2, paramString));
    this.file = paramFile1;
    this.other = paramFile2;
    this.reason = paramString;
  }
  
  @NotNull
  public final File getFile()
  {
    return this.file;
  }
  
  @Nullable
  public final File getOther()
  {
    return this.other;
  }
  
  @Nullable
  public final String getReason()
  {
    return this.reason;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.io.FileSystemException
 * JD-Core Version:    0.7.0.1
 */