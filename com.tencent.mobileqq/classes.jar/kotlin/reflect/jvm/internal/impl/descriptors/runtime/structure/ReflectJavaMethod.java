package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaMethod
  extends ReflectJavaMember
  implements JavaMethod
{
  @NotNull
  private final Method member;
  
  public ReflectJavaMethod(@NotNull Method paramMethod)
  {
    this.member = paramMethod;
  }
  
  @Nullable
  public JavaAnnotationArgument getAnnotationParameterDefaultValue()
  {
    Object localObject = getMember().getDefaultValue();
    ReflectJavaAnnotationArgument localReflectJavaAnnotationArgument = null;
    if (localObject != null) {
      localReflectJavaAnnotationArgument = ReflectJavaAnnotationArgument.Factory.create(localObject, null);
    }
    return (JavaAnnotationArgument)localReflectJavaAnnotationArgument;
  }
  
  public boolean getHasAnnotationParameterDefaultValue()
  {
    return JavaMethod.DefaultImpls.getHasAnnotationParameterDefaultValue(this);
  }
  
  @NotNull
  public Method getMember()
  {
    return this.member;
  }
  
  @NotNull
  public ReflectJavaType getReturnType()
  {
    ReflectJavaType.Factory localFactory = ReflectJavaType.Factory;
    Type localType = getMember().getGenericReturnType();
    Intrinsics.checkExpressionValueIsNotNull(localType, "member.genericReturnType");
    return localFactory.create(localType);
  }
  
  @NotNull
  public List<ReflectJavaTypeParameter> getTypeParameters()
  {
    TypeVariable[] arrayOfTypeVariable = getMember().getTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfTypeVariable, "member.typeParameters");
    Collection localCollection = (Collection)new ArrayList(arrayOfTypeVariable.length);
    int j = arrayOfTypeVariable.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new ReflectJavaTypeParameter(arrayOfTypeVariable[i]));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public List<JavaValueParameter> getValueParameters()
  {
    Type[] arrayOfType = getMember().getGenericParameterTypes();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfType, "member.genericParameterTypes");
    Annotation[][] arrayOfAnnotation = getMember().getParameterAnnotations();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfAnnotation, "member.parameterAnnotations");
    return getValueParameters(arrayOfType, arrayOfAnnotation, getMember().isVarArgs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod
 * JD-Core Version:    0.7.0.1
 */