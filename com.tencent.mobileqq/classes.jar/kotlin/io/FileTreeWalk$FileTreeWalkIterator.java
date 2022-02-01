package kotlin.io;

import java.io.File;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class FileTreeWalk$FileTreeWalkIterator
  extends AbstractIterator<File>
{
  private final ArrayDeque<FileTreeWalk.WalkState> state = new ArrayDeque();
  
  public FileTreeWalk$FileTreeWalkIterator()
  {
    if (FileTreeWalk.access$getStart$p(localFileTreeWalk).isDirectory())
    {
      this.state.push(directoryState(FileTreeWalk.access$getStart$p(localFileTreeWalk)));
      return;
    }
    if (FileTreeWalk.access$getStart$p(localFileTreeWalk).isFile())
    {
      this.state.push(new FileTreeWalk.FileTreeWalkIterator.SingleFileState(this, FileTreeWalk.access$getStart$p(localFileTreeWalk)));
      return;
    }
    done();
  }
  
  private final FileTreeWalk.DirectoryState directoryState(File paramFile)
  {
    FileWalkDirection localFileWalkDirection = FileTreeWalk.access$getDirection$p(this.this$0);
    switch (FileTreeWalk.FileTreeWalkIterator.WhenMappings.$EnumSwitchMapping$0[localFileWalkDirection.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 1: 
      return (FileTreeWalk.DirectoryState)new FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState(this, paramFile);
    }
    return (FileTreeWalk.DirectoryState)new FileTreeWalk.FileTreeWalkIterator.BottomUpDirectoryState(this, paramFile);
  }
  
  private final File gotoNext()
  {
    for (;;)
    {
      FileTreeWalk.WalkState localWalkState = (FileTreeWalk.WalkState)this.state.peek();
      File localFile;
      if (localWalkState != null)
      {
        localFile = localWalkState.step();
        if (localFile == null) {
          this.state.pop();
        }
      }
      else
      {
        return null;
      }
      if ((Intrinsics.areEqual(localFile, localWalkState.getRoot())) || (!localFile.isDirectory()) || (this.state.size() >= FileTreeWalk.access$getMaxDepth$p(this.this$0))) {
        return localFile;
      }
      this.state.push(directoryState(localFile));
    }
  }
  
  public void computeNext()
  {
    File localFile = gotoNext();
    if (localFile != null)
    {
      setNext(localFile);
      return;
    }
    done();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.io.FileTreeWalk.FileTreeWalkIterator
 * JD-Core Version:    0.7.0.1
 */