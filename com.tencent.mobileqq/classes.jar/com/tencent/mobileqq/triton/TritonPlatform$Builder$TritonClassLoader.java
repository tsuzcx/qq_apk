package com.tencent.mobileqq.triton;

import android.content.Context;
import dalvik.system.PathClassLoader;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/TritonPlatform$Builder$TritonClassLoader;", "Ldalvik/system/PathClassLoader;", "dexFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "(Ljava/io/File;Landroid/content/Context;)V", "originClassLoader", "Ljava/lang/ClassLoader;", "findClass", "Ljava/lang/Class;", "name", "", "TritonAPI_release"}, k=1, mv={1, 1, 16})
final class TritonPlatform$Builder$TritonClassLoader
  extends PathClassLoader
{
  private final ClassLoader originClassLoader;
  
  public TritonPlatform$Builder$TritonClassLoader(@NotNull File paramFile, @NotNull Context paramContext)
  {
    super(paramFile, str, localClassLoader.getParent());
    paramFile = paramContext.getClassLoader();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "context.classLoader");
    this.originClassLoader = paramFile;
  }
  
  @NotNull
  protected Class<?> findClass(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    try
    {
      Class localClass = super.findClass(paramString);
      Intrinsics.checkExpressionValueIsNotNull(localClass, "super.findClass(name)");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label20:
      break label20;
    }
    paramString = this.originClassLoader.loadClass(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "originClassLoader.loadClass(name)");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.TritonPlatform.Builder.TritonClassLoader
 * JD-Core Version:    0.7.0.1
 */