package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import org.jetbrains.annotations.NotNull;

public final class KotlinJvmBinaryPackageSourceElement
  implements SourceElement
{
  private final LazyJavaPackageFragment packageFragment;
  
  public KotlinJvmBinaryPackageSourceElement(@NotNull LazyJavaPackageFragment paramLazyJavaPackageFragment)
  {
    this.packageFragment = paramLazyJavaPackageFragment;
  }
  
  @NotNull
  public SourceFile getContainingFile()
  {
    SourceFile localSourceFile = SourceFile.NO_SOURCE_FILE;
    Intrinsics.checkExpressionValueIsNotNull(localSourceFile, "SourceFile.NO_SOURCE_FILE");
    return localSourceFile;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.packageFragment);
    localStringBuilder.append(": ");
    localStringBuilder.append(this.packageFragment.getBinaryClasses$descriptors_jvm().keySet());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement
 * JD-Core Version:    0.7.0.1
 */