package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaConstructor
  extends ReflectJavaMember
  implements JavaConstructor
{
  @NotNull
  private final Constructor<?> member;
  
  public ReflectJavaConstructor(@NotNull Constructor<?> paramConstructor)
  {
    this.member = paramConstructor;
  }
  
  @NotNull
  public Constructor<?> getMember()
  {
    return this.member;
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
    Object localObject2 = getMember().getGenericParameterTypes();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "types");
    int i;
    if (localObject2.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return CollectionsKt.emptyList();
    }
    Object localObject3 = getMember().getDeclaringClass();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "klass");
    Object localObject1 = localObject2;
    if (((Class)localObject3).getDeclaringClass() != null)
    {
      localObject1 = localObject2;
      if (!Modifier.isStatic(((Class)localObject3).getModifiers())) {
        localObject1 = (Type[])ArraysKt.copyOfRange((Object[])localObject2, 1, localObject2.length);
      }
    }
    localObject3 = getMember().getParameterAnnotations();
    Object[] arrayOfObject = (Object[])localObject3;
    if (arrayOfObject.length >= localObject1.length)
    {
      localObject2 = localObject3;
      if (arrayOfObject.length > localObject1.length)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "annotations");
        localObject2 = (Annotation[][])ArraysKt.copyOfRange(arrayOfObject, arrayOfObject.length - localObject1.length, arrayOfObject.length);
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "realTypes");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "realAnnotations");
      return getValueParameters((Type[])localObject1, (Annotation[][])localObject2, getMember().isVarArgs());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Illegal generic signature: ");
    ((StringBuilder)localObject1).append(getMember());
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject1).toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor
 * JD-Core Version:    0.7.0.1
 */