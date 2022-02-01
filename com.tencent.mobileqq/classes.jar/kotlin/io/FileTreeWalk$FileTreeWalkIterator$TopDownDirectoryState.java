package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "", "step", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState
  extends FileTreeWalk.DirectoryState
{
  private int fileIndex;
  private File[] fileList;
  private boolean rootVisited;
  
  public FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState(File paramFile)
  {
    super(localObject);
  }
  
  @Nullable
  public File step()
  {
    if (!this.rootVisited)
    {
      localObject = FileTreeWalk.access$getOnEnter$p(this.this$0.this$0);
      if ((localObject != null) && (!((Boolean)((Function1)localObject).invoke(getRoot())).booleanValue())) {
        return null;
      }
      this.rootVisited = true;
      return getRoot();
    }
    Object localObject = this.fileList;
    if (localObject != null)
    {
      i = this.fileIndex;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (i >= localObject.length)
      {
        localObject = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
        if (localObject != null) {
          localObject = (Unit)((Function1)localObject).invoke(getRoot());
        }
        return null;
      }
    }
    if (this.fileList == null)
    {
      this.fileList = getRoot().listFiles();
      if (this.fileList == null)
      {
        localObject = FileTreeWalk.access$getOnFail$p(this.this$0.this$0);
        if (localObject != null) {
          localObject = (Unit)((Function2)localObject).invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
        }
      }
      localObject = this.fileList;
      if (localObject != null)
      {
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        if (localObject.length != 0) {}
      }
      else
      {
        localObject = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
        if (localObject != null) {
          localObject = (Unit)((Function1)localObject).invoke(getRoot());
        }
        return null;
      }
    }
    localObject = this.fileList;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int i = this.fileIndex;
    this.fileIndex = (i + 1);
    return localObject[i];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState
 * JD-Core Version:    0.7.0.1
 */