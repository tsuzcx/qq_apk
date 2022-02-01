package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class LazyJavaStaticScope
  extends LazyJavaScope
{
  public LazyJavaStaticScope(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    super(paramLazyJavaResolverContext, null, 2, null);
  }
  
  protected void computeNonDeclaredProperties(@NotNull Name paramName, @NotNull Collection<PropertyDescriptor> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramCollection, "result");
  }
  
  @Nullable
  protected ReceiverParameterDescriptor getDispatchReceiverParameter()
  {
    return null;
  }
  
  @NotNull
  protected LazyJavaScope.MethodSignatureData resolveMethodSignature(@NotNull JavaMethod paramJavaMethod, @NotNull List<? extends TypeParameterDescriptor> paramList, @NotNull KotlinType paramKotlinType, @NotNull List<? extends ValueParameterDescriptor> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaMethod, "method");
    Intrinsics.checkParameterIsNotNull(paramList, "methodTypeParameters");
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "returnType");
    Intrinsics.checkParameterIsNotNull(paramList1, "valueParameters");
    return new LazyJavaScope.MethodSignatureData(paramKotlinType, null, paramList1, paramList, false, CollectionsKt.emptyList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope
 * JD-Core Version:    0.7.0.1
 */