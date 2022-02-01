package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk$WalkState;", "", "root", "Ljava/io/File;", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
abstract class FileTreeWalk$WalkState
{
  @NotNull
  private final File root;
  
  public FileTreeWalk$WalkState(@NotNull File paramFile)
  {
    this.root = paramFile;
  }
  
  @NotNull
  public final File getRoot()
  {
    return this.root;
  }
  
  @Nullable
  public abstract File step();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.FileTreeWalk.WalkState
 * JD-Core Version:    0.7.0.1
 */