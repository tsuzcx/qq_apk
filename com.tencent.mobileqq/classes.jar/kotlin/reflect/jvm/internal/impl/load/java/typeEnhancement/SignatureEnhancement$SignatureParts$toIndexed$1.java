package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

final class SignatureEnhancement$SignatureParts$toIndexed$1
  extends Lambda
  implements Function2<KotlinType, LazyJavaResolverContext, Unit>
{
  SignatureEnhancement$SignatureParts$toIndexed$1(ArrayList paramArrayList)
  {
    super(2);
  }
  
  public final void invoke(@NotNull KotlinType paramKotlinType, @NotNull LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "ownerContext");
    LazyJavaResolverContext localLazyJavaResolverContext = ContextKt.copyWithNewDefaultTypeQualifiers(paramLazyJavaResolverContext, paramKotlinType.getAnnotations());
    Object localObject = this.$list;
    paramLazyJavaResolverContext = localLazyJavaResolverContext.getDefaultTypeQualifiers();
    if (paramLazyJavaResolverContext != null) {
      paramLazyJavaResolverContext = paramLazyJavaResolverContext.get(AnnotationTypeQualifierResolver.QualifierApplicabilityType.TYPE_USE);
    } else {
      paramLazyJavaResolverContext = null;
    }
    ((ArrayList)localObject).add(new TypeAndDefaultQualifiers(paramKotlinType, paramLazyJavaResolverContext));
    paramKotlinType = paramKotlinType.getArguments().iterator();
    while (paramKotlinType.hasNext())
    {
      paramLazyJavaResolverContext = (TypeProjection)paramKotlinType.next();
      if (paramLazyJavaResolverContext.isStarProjection())
      {
        localObject = this.$list;
        paramLazyJavaResolverContext = paramLazyJavaResolverContext.getType();
        Intrinsics.checkExpressionValueIsNotNull(paramLazyJavaResolverContext, "arg.type");
        ((ArrayList)localObject).add(new TypeAndDefaultQualifiers(paramLazyJavaResolverContext, null));
      }
      else
      {
        localObject = (1)this;
        paramLazyJavaResolverContext = paramLazyJavaResolverContext.getType();
        Intrinsics.checkExpressionValueIsNotNull(paramLazyJavaResolverContext, "arg.type");
        ((1)localObject).invoke(paramLazyJavaResolverContext, localLazyJavaResolverContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.toIndexed.1
 * JD-Core Version:    0.7.0.1
 */