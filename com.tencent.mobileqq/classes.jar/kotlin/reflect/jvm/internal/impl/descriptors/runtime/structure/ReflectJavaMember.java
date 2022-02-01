package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReflectJavaMember
  extends ReflectJavaElement
  implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember
{
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ReflectJavaMember)) && (Intrinsics.areEqual(getMember(), ((ReflectJavaMember)paramObject).getMember()));
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
  
  @NotNull
  public ReflectJavaClass getContainingClass()
  {
    Class localClass = getMember().getDeclaringClass();
    Intrinsics.checkExpressionValueIsNotNull(localClass, "member.declaringClass");
    return new ReflectJavaClass(localClass);
  }
  
  @NotNull
  public AnnotatedElement getElement()
  {
    Member localMember = getMember();
    if (localMember != null) {
      return (AnnotatedElement)localMember;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
  }
  
  @NotNull
  public abstract Member getMember();
  
  public int getModifiers()
  {
    return getMember().getModifiers();
  }
  
  @NotNull
  public Name getName()
  {
    Object localObject = getMember().getName();
    if (localObject != null)
    {
      localObject = Name.identifier((String)localObject);
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = SpecialNames.NO_NAME_PROVIDED;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "SpecialNames.NO_NAME_PROVIDED");
    return localObject;
  }
  
  @NotNull
  protected final List<JavaValueParameter> getValueParameters(@NotNull Type[] paramArrayOfType, @NotNull Annotation[][] paramArrayOfAnnotation, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfType, "parameterTypes");
    Intrinsics.checkParameterIsNotNull(paramArrayOfAnnotation, "parameterAnnotations");
    ArrayList localArrayList = new ArrayList(paramArrayOfType.length);
    List localList = Java8ParameterNamesLoader.INSTANCE.loadParameterNames(getMember());
    int i;
    if (localList != null) {
      i = localList.size() - paramArrayOfType.length;
    } else {
      i = 0;
    }
    int k = paramArrayOfType.length;
    int j = 0;
    while (j < k)
    {
      ReflectJavaType localReflectJavaType = ReflectJavaType.Factory.create(paramArrayOfType[j]);
      String str;
      if (localList != null)
      {
        str = (String)CollectionsKt.getOrNull(localList, j + i);
        if (str == null)
        {
          paramArrayOfType = new StringBuilder();
          paramArrayOfType.append("No parameter with index ");
          paramArrayOfType.append(j);
          paramArrayOfType.append('+');
          paramArrayOfType.append(i);
          paramArrayOfType.append(" (name=");
          paramArrayOfType.append(getName());
          paramArrayOfType.append(" type=");
          paramArrayOfType.append(localReflectJavaType);
          paramArrayOfType.append(") in ");
          paramArrayOfType.append(localList);
          paramArrayOfType.append("@ReflectJavaMember");
          throw ((Throwable)new IllegalStateException(paramArrayOfType.toString().toString()));
        }
      }
      else
      {
        str = null;
      }
      boolean bool;
      if ((paramBoolean) && (j == ArraysKt.getLastIndex(paramArrayOfType))) {
        bool = true;
      } else {
        bool = false;
      }
      localArrayList.add(new ReflectJavaValueParameter(localReflectJavaType, paramArrayOfAnnotation[j], str, bool));
      j += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
  }
  
  public int hashCode()
  {
    return getMember().hashCode();
  }
  
  public boolean isAbstract()
  {
    return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
  }
  
  public boolean isDeprecatedInJavaDoc()
  {
    return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
  }
  
  public boolean isFinal()
  {
    return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
  }
  
  public boolean isStatic()
  {
    return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(getMember());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
 * JD-Core Version:    0.7.0.1
 */