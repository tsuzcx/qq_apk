package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Annotations$Companion$EMPTY$1
  implements Annotations
{
  @Nullable
  public Void findAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return null;
  }
  
  public boolean hasAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return Annotations.DefaultImpls.hasAnnotation(this, paramFqName);
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  @NotNull
  public Iterator<AnnotationDescriptor> iterator()
  {
    return CollectionsKt.emptyList().iterator();
  }
  
  @NotNull
  public String toString()
  {
    return "EMPTY";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY.1
 * JD-Core Version:    0.7.0.1
 */