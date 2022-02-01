package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.Nullable;

final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1
  extends Lambda
  implements Function1<KotlinType, ClassDescriptor>
{
  public static final 1 INSTANCE = new 1();
  
  LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1()
  {
    super(1);
  }
  
  @Nullable
  public final ClassDescriptor invoke(KotlinType paramKotlinType)
  {
    ClassifierDescriptor localClassifierDescriptor = paramKotlinType.getConstructor().getDeclarationDescriptor();
    paramKotlinType = localClassifierDescriptor;
    if (!(localClassifierDescriptor instanceof ClassDescriptor)) {
      paramKotlinType = null;
    }
    return (ClassDescriptor)paramKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes.1.1
 * JD-Core Version:    0.7.0.1
 */