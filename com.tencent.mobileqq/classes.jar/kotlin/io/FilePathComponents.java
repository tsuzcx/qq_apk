package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FilePathComponents;", "", "root", "Ljava/io/File;", "segments", "", "(Ljava/io/File;Ljava/util/List;)V", "isRooted", "", "()Z", "getRoot", "()Ljava/io/File;", "rootName", "", "getRootName", "()Ljava/lang/String;", "getSegments", "()Ljava/util/List;", "size", "", "getSize", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "subPath", "beginIndex", "endIndex", "toString", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class FilePathComponents
{
  @NotNull
  private final File root;
  @NotNull
  private final List<File> segments;
  
  public FilePathComponents(@NotNull File paramFile, @NotNull List<? extends File> paramList)
  {
    this.root = paramFile;
    this.segments = paramList;
  }
  
  @NotNull
  public final File component1()
  {
    return this.root;
  }
  
  @NotNull
  public final List<File> component2()
  {
    return this.segments;
  }
  
  @NotNull
  public final FilePathComponents copy(@NotNull File paramFile, @NotNull List<? extends File> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "root");
    Intrinsics.checkParameterIsNotNull(paramList, "segments");
    return new FilePathComponents(paramFile, paramList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FilePathComponents))
      {
        paramObject = (FilePathComponents)paramObject;
        if ((Intrinsics.areEqual(this.root, paramObject.root)) && (Intrinsics.areEqual(this.segments, paramObject.segments))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final File getRoot()
  {
    return this.root;
  }
  
  @NotNull
  public final String getRootName()
  {
    String str = this.root.getPath();
    Intrinsics.checkExpressionValueIsNotNull(str, "root.path");
    return str;
  }
  
  @NotNull
  public final List<File> getSegments()
  {
    return this.segments;
  }
  
  public final int getSize()
  {
    return this.segments.size();
  }
  
  public int hashCode()
  {
    Object localObject = this.root;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.segments;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  public final boolean isRooted()
  {
    String str = this.root.getPath();
    Intrinsics.checkExpressionValueIsNotNull(str, "root.path");
    return ((CharSequence)str).length() > 0;
  }
  
  @NotNull
  public final File subPath(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2) && (paramInt2 <= getSize()))
    {
      Iterable localIterable = (Iterable)this.segments.subList(paramInt1, paramInt2);
      String str = File.separator;
      Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
      return new File(CollectionsKt.joinToString$default(localIterable, (CharSequence)str, null, null, 0, null, null, 62, null));
    }
    throw ((Throwable)new IllegalArgumentException());
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilePathComponents(root=");
    localStringBuilder.append(this.root);
    localStringBuilder.append(", segments=");
    localStringBuilder.append(this.segments);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.FilePathComponents
 * JD-Core Version:    0.7.0.1
 */