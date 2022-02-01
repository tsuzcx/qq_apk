package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class FileTreeWalk
  implements Sequence<File>
{
  private final FileWalkDirection direction;
  private final int maxDepth;
  private final Function1<File, Boolean> onEnter;
  private final Function2<File, IOException, Unit> onFail;
  private final Function1<File, Unit> onLeave;
  private final File start;
  
  public FileTreeWalk(@NotNull File paramFile, @NotNull FileWalkDirection paramFileWalkDirection)
  {
    this(paramFile, paramFileWalkDirection, null, null, null, 0, 32, null);
  }
  
  private FileTreeWalk(File paramFile, FileWalkDirection paramFileWalkDirection, Function1<? super File, Boolean> paramFunction1, Function1<? super File, Unit> paramFunction11, Function2<? super File, ? super IOException, Unit> paramFunction2, int paramInt)
  {
    this.start = paramFile;
    this.direction = paramFileWalkDirection;
    this.onEnter = paramFunction1;
    this.onLeave = paramFunction11;
    this.onFail = paramFunction2;
    this.maxDepth = paramInt;
  }
  
  @NotNull
  public Iterator<File> iterator()
  {
    return (Iterator)new FileTreeWalk.FileTreeWalkIterator(this);
  }
  
  @NotNull
  public final FileTreeWalk maxDepth(int paramInt)
  {
    if (paramInt <= 0) {
      throw ((Throwable)new IllegalArgumentException("depth must be positive, but was " + paramInt + '.'));
    }
    return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, paramInt);
  }
  
  @NotNull
  public final FileTreeWalk onEnter(@NotNull Function1<? super File, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "function");
    return new FileTreeWalk(this.start, this.direction, paramFunction1, this.onLeave, this.onFail, this.maxDepth);
  }
  
  @NotNull
  public final FileTreeWalk onFail(@NotNull Function2<? super File, ? super IOException, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "function");
    return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, paramFunction2, this.maxDepth);
  }
  
  @NotNull
  public final FileTreeWalk onLeave(@NotNull Function1<? super File, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "function");
    return new FileTreeWalk(this.start, this.direction, this.onEnter, paramFunction1, this.onFail, this.maxDepth);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.FileTreeWalk
 * JD-Core Version:    0.7.0.1
 */