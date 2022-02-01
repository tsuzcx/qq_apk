package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class TypeIntersectionScope
  extends AbstractScopeAdapter
{
  public static final TypeIntersectionScope.Companion Companion = new TypeIntersectionScope.Companion(null);
  @NotNull
  private final ChainedMemberScope workerScope;
  
  private TypeIntersectionScope(ChainedMemberScope paramChainedMemberScope)
  {
    this.workerScope = paramChainedMemberScope;
  }
  
  @JvmStatic
  @NotNull
  public static final MemberScope create(@NotNull String paramString, @NotNull Collection<? extends KotlinType> paramCollection)
  {
    return Companion.create(paramString, paramCollection);
  }
  
  @NotNull
  public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    Object localObject1 = (Iterable)super.getContributedDescriptors(paramDescriptorKindFilter, paramFunction1);
    paramDescriptorKindFilter = new ArrayList();
    paramFunction1 = new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((DeclarationDescriptor)localObject2 instanceof CallableDescriptor)) {
        paramDescriptorKindFilter.add(localObject2);
      } else {
        paramFunction1.add(localObject2);
      }
    }
    paramFunction1 = new Pair(paramDescriptorKindFilter, paramFunction1);
    paramDescriptorKindFilter = (List)paramFunction1.component1();
    paramFunction1 = (List)paramFunction1.component2();
    if (paramDescriptorKindFilter != null) {
      return (Collection)CollectionsKt.plus(OverridingUtilsKt.selectMostSpecificInEachOverridableGroup((Collection)paramDescriptorKindFilter, (Function1)TypeIntersectionScope.getContributedDescriptors.2.INSTANCE), (Iterable)paramFunction1);
    }
    paramDescriptorKindFilter = new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
    for (;;)
    {
      throw paramDescriptorKindFilter;
    }
  }
  
  @NotNull
  public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(paramName, paramLookupLocation), (Function1)TypeIntersectionScope.getContributedFunctions.1.INSTANCE);
  }
  
  @NotNull
  public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(paramName, paramLookupLocation), (Function1)TypeIntersectionScope.getContributedVariables.1.INSTANCE);
  }
  
  @NotNull
  protected ChainedMemberScope getWorkerScope()
  {
    return this.workerScope;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope
 * JD-Core Version:    0.7.0.1
 */