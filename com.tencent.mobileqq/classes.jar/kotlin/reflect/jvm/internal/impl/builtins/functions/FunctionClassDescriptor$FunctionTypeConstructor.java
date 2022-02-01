package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import org.jetbrains.annotations.NotNull;

final class FunctionClassDescriptor$FunctionTypeConstructor
  extends AbstractClassTypeConstructor
{
  public FunctionClassDescriptor$FunctionTypeConstructor()
  {
    super(FunctionClassDescriptor.access$getStorageManager$p(localFunctionClassDescriptor));
  }
  
  @NotNull
  protected Collection<KotlinType> computeSupertypes()
  {
    Object localObject1 = this.this$0.getFunctionKind();
    int i = FunctionClassDescriptor.FunctionTypeConstructor.WhenMappings.$EnumSwitchMapping$0[localObject1.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            localObject1 = CollectionsKt.listOf(new ClassId[] { FunctionClassDescriptor.access$getKFunctionClassId$cp(), new ClassId(DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE, FunctionClassDescriptor.Kind.SuspendFunction.numberedClassName(this.this$0.getArity())) });
          } else {
            throw new NoWhenBranchMatchedException();
          }
        }
        else {
          localObject1 = CollectionsKt.listOf(FunctionClassDescriptor.access$getFunctionClassId$cp());
        }
      }
      else {
        localObject1 = CollectionsKt.listOf(new ClassId[] { FunctionClassDescriptor.access$getKFunctionClassId$cp(), new ClassId(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, FunctionClassDescriptor.Kind.Function.numberedClassName(this.this$0.getArity())) });
      }
    }
    else {
      localObject1 = CollectionsKt.listOf(FunctionClassDescriptor.access$getFunctionClassId$cp());
    }
    ModuleDescriptor localModuleDescriptor = FunctionClassDescriptor.access$getContainingDeclaration$p(this.this$0).getContainingDeclaration();
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (ClassId)((Iterator)localObject2).next();
      ClassDescriptor localClassDescriptor = FindClassInModuleKt.findClassAcrossModuleDependencies(localModuleDescriptor, (ClassId)localObject3);
      if (localClassDescriptor != null)
      {
        localObject3 = getParameters();
        Object localObject4 = localClassDescriptor.getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "descriptor.typeConstructor");
        localObject4 = (Iterable)CollectionsKt.takeLast((List)localObject3, ((TypeConstructor)localObject4).getParameters().size());
        localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(new TypeProjectionImpl((KotlinType)((TypeParameterDescriptor)((Iterator)localObject4).next()).getDefaultType()));
        }
        localObject3 = (List)localObject3;
        ((Collection)localObject1).add(KotlinTypeFactory.simpleNotNullType(Annotations.Companion.getEMPTY(), localClassDescriptor, (List)localObject3));
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Built-in class ");
        ((StringBuilder)localObject1).append(localObject3);
        ((StringBuilder)localObject1).append(" not found");
        throw ((Throwable)new IllegalStateException(((StringBuilder)localObject1).toString().toString()));
      }
    }
    return (Collection)CollectionsKt.toList((Iterable)localObject1);
  }
  
  @NotNull
  public FunctionClassDescriptor getDeclarationDescriptor()
  {
    return this.this$0;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getParameters()
  {
    return FunctionClassDescriptor.access$getParameters$p(this.this$0);
  }
  
  @NotNull
  protected SupertypeLoopChecker getSupertypeLoopChecker()
  {
    return (SupertypeLoopChecker)SupertypeLoopChecker.EMPTY.INSTANCE;
  }
  
  public boolean isDenotable()
  {
    return true;
  }
  
  @NotNull
  public String toString()
  {
    return getDeclarationDescriptor().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.FunctionTypeConstructor
 * JD-Core Version:    0.7.0.1
 */