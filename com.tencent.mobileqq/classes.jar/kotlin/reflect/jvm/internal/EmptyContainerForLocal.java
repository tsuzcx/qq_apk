package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/EmptyContainerForLocal;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "fail", "", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class EmptyContainerForLocal
  extends KDeclarationContainerImpl
{
  public static final EmptyContainerForLocal INSTANCE = new EmptyContainerForLocal();
  
  private final Void fail()
  {
    throw ((Throwable)new KotlinReflectionInternalError("Introspecting local functions, lambdas, anonymous functions and local variables is not yet fully supported in Kotlin reflection"));
  }
  
  @NotNull
  public Collection<ConstructorDescriptor> getConstructorDescriptors()
  {
    fail();
    throw null;
  }
  
  @NotNull
  public Collection<FunctionDescriptor> getFunctions(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    fail();
    throw null;
  }
  
  @NotNull
  public Class<?> getJClass()
  {
    fail();
    throw null;
  }
  
  @Nullable
  public PropertyDescriptor getLocalProperty(int paramInt)
  {
    return null;
  }
  
  @NotNull
  public Collection<KCallable<?>> getMembers()
  {
    fail();
    throw null;
  }
  
  @NotNull
  public Collection<PropertyDescriptor> getProperties(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    fail();
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.EmptyContainerForLocal
 * JD-Core Version:    0.7.0.1
 */