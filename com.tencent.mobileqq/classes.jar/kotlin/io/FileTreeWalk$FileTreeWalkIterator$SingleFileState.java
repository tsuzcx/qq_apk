package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin._Assertions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class FileTreeWalk$FileTreeWalkIterator$SingleFileState
  extends FileTreeWalk.WalkState
{
  private boolean visited;
  
  public FileTreeWalk$FileTreeWalkIterator$SingleFileState(File paramFile)
  {
    super(localObject);
    if (_Assertions.ENABLED)
    {
      boolean bool = localObject.isFile();
      if ((_Assertions.ENABLED) && (!bool)) {
        throw ((Throwable)new AssertionError("rootFile must be verified to be file beforehand."));
      }
    }
  }
  
  @Nullable
  public File step()
  {
    if (this.visited) {
      return null;
    }
    this.visited = true;
    return getRoot();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.io.FileTreeWalk.FileTreeWalkIterator.SingleFileState
 * JD-Core Version:    0.7.0.1
 */