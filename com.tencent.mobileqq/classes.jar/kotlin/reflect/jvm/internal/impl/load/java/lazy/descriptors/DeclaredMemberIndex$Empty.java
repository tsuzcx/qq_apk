package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeclaredMemberIndex$Empty
  implements DeclaredMemberIndex
{
  public static final Empty INSTANCE = new Empty();
  
  @Nullable
  public JavaField findFieldByName(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return null;
  }
  
  @NotNull
  public List<JavaMethod> findMethodsByName(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public Set<Name> getFieldNames()
  {
    return SetsKt.emptySet();
  }
  
  @NotNull
  public Set<Name> getMethodNames()
  {
    return SetsKt.emptySet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty
 * JD-Core Version:    0.7.0.1
 */