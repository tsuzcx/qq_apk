package com.tencent.videocut.utils;

import java.io.File;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/ZipIO;", "", "entry", "Ljava/util/zip/ZipEntry;", "output", "Ljava/io/File;", "(Ljava/util/zip/ZipEntry;Ljava/io/File;)V", "getEntry", "()Ljava/util/zip/ZipEntry;", "getOutput", "()Ljava/io/File;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class ZipIO
{
  @NotNull
  private final ZipEntry a;
  @NotNull
  private final File b;
  
  public ZipIO(@NotNull ZipEntry paramZipEntry, @NotNull File paramFile)
  {
    this.a = paramZipEntry;
    this.b = paramFile;
  }
  
  @NotNull
  public final ZipEntry a()
  {
    return this.a;
  }
  
  @NotNull
  public final File b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ZipIO))
      {
        paramObject = (ZipIO)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZipIO(entry=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", output=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.ZipIO
 * JD-Core Version:    0.7.0.1
 */