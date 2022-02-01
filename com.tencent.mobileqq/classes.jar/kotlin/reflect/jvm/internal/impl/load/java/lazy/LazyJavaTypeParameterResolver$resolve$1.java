package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class LazyJavaTypeParameterResolver$resolve$1
  extends Lambda
  implements Function1<JavaTypeParameter, LazyJavaTypeParameterDescriptor>
{
  LazyJavaTypeParameterResolver$resolve$1(LazyJavaTypeParameterResolver paramLazyJavaTypeParameterResolver)
  {
    super(1);
  }
  
  @Nullable
  public final LazyJavaTypeParameterDescriptor invoke(@NotNull JavaTypeParameter paramJavaTypeParameter)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaTypeParameter, "typeParameter");
    Integer localInteger = (Integer)LazyJavaTypeParameterResolver.access$getTypeParameters$p(this.this$0).get(paramJavaTypeParameter);
    if (localInteger != null)
    {
      int i = ((Number)localInteger).intValue();
      return new LazyJavaTypeParameterDescriptor(ContextKt.child(LazyJavaTypeParameterResolver.access$getC$p(this.this$0), (TypeParameterResolver)this.this$0), paramJavaTypeParameter, LazyJavaTypeParameterResolver.access$getTypeParametersIndexOffset$p(this.this$0) + i, LazyJavaTypeParameterResolver.access$getContainingDeclaration$p(this.this$0));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver.resolve.1
 * JD-Core Version:    0.7.0.1
 */