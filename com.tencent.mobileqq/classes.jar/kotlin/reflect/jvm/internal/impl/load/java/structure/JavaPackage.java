package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public abstract interface JavaPackage
  extends JavaAnnotationOwner, JavaElement
{
  @NotNull
  public abstract Collection<JavaClass> getClasses(@NotNull Function1<? super Name, Boolean> paramFunction1);
  
  @NotNull
  public abstract FqName getFqName();
  
  @NotNull
  public abstract Collection<JavaPackage> getSubPackages();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
 * JD-Core Version:    0.7.0.1
 */