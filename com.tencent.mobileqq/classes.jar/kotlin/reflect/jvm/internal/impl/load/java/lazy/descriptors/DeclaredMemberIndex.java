package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface DeclaredMemberIndex
{
  @Nullable
  public abstract JavaField findFieldByName(@NotNull Name paramName);
  
  @NotNull
  public abstract Collection<JavaMethod> findMethodsByName(@NotNull Name paramName);
  
  @NotNull
  public abstract Set<Name> getFieldNames();
  
  @NotNull
  public abstract Set<Name> getMethodNames();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
 * JD-Core Version:    0.7.0.1
 */