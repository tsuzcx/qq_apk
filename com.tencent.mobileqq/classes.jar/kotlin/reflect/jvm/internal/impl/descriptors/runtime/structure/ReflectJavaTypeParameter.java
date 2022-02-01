package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaTypeParameter
  extends ReflectJavaElement
  implements ReflectJavaAnnotationOwner, JavaTypeParameter
{
  @NotNull
  private final TypeVariable<?> typeVariable;
  
  public ReflectJavaTypeParameter(@NotNull TypeVariable<?> paramTypeVariable)
  {
    this.typeVariable = paramTypeVariable;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ReflectJavaTypeParameter)) && (Intrinsics.areEqual(this.typeVariable, ((ReflectJavaTypeParameter)paramObject).typeVariable));
  }
  
  @Nullable
  public ReflectJavaAnnotation findAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, paramFqName);
  }
  
  @NotNull
  public List<ReflectJavaAnnotation> getAnnotations()
  {
    return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
  }
  
  @Nullable
  public AnnotatedElement getElement()
  {
    TypeVariable localTypeVariable2 = this.typeVariable;
    TypeVariable localTypeVariable1 = localTypeVariable2;
    if (!(localTypeVariable2 instanceof AnnotatedElement)) {
      localTypeVariable1 = null;
    }
    return (AnnotatedElement)localTypeVariable1;
  }
  
  @NotNull
  public Name getName()
  {
    Name localName = Name.identifier(this.typeVariable.getName());
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(typeVariable.name)");
    return localName;
  }
  
  @NotNull
  public List<ReflectJavaClassifierType> getUpperBounds()
  {
    Object localObject1 = this.typeVariable.getBounds();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "typeVariable.bounds");
    Object localObject2 = (Collection)new ArrayList(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      ((Collection)localObject2).add(new ReflectJavaClassifierType(localObject1[i]));
      i += 1;
    }
    localObject2 = (List)localObject2;
    localObject1 = (ReflectJavaClassifierType)CollectionsKt.singleOrNull((List)localObject2);
    if (localObject1 != null) {
      localObject1 = ((ReflectJavaClassifierType)localObject1).getReflectType();
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(localObject1, Object.class)) {
      return CollectionsKt.emptyList();
    }
    return localObject2;
  }
  
  public int hashCode()
  {
    return this.typeVariable.hashCode();
  }
  
  public boolean isDeprecatedInJavaDoc()
  {
    return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(this.typeVariable);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaTypeParameter
 * JD-Core Version:    0.7.0.1
 */