package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface JavaClassFinder
{
  @Nullable
  public abstract JavaClass findClass(@NotNull JavaClassFinder.Request paramRequest);
  
  @Nullable
  public abstract JavaPackage findPackage(@NotNull FqName paramFqName);
  
  @Nullable
  public abstract Set<String> knownClassNamesInPackage(@NotNull FqName paramFqName);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
 * JD-Core Version:    0.7.0.1
 */