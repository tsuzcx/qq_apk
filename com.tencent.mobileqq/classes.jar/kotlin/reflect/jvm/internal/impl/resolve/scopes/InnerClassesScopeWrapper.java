package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class InnerClassesScopeWrapper
  extends MemberScopeImpl
{
  @NotNull
  private final MemberScope workerScope;
  
  public InnerClassesScopeWrapper(@NotNull MemberScope paramMemberScope)
  {
    this.workerScope = paramMemberScope;
  }
  
  @Nullable
  public ClassifierDescriptor getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    paramName = this.workerScope.getContributedClassifier(paramName, paramLookupLocation);
    paramLookupLocation = null;
    if (paramName != null)
    {
      if (!(paramName instanceof ClassDescriptor)) {
        paramLookupLocation = null;
      } else {
        paramLookupLocation = paramName;
      }
      paramLookupLocation = (ClassDescriptor)paramLookupLocation;
      if (paramLookupLocation != null) {
        return (ClassifierDescriptor)paramLookupLocation;
      }
      paramLookupLocation = paramName;
      if (!(paramName instanceof TypeAliasDescriptor)) {
        paramLookupLocation = null;
      }
      paramLookupLocation = (ClassifierDescriptor)paramLookupLocation;
    }
    return paramLookupLocation;
  }
  
  @NotNull
  public List<ClassifierDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    paramDescriptorKindFilter = paramDescriptorKindFilter.restrictedToKindsOrNull(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
    if (paramDescriptorKindFilter != null)
    {
      paramFunction1 = (Iterable)this.workerScope.getContributedDescriptors(paramDescriptorKindFilter, paramFunction1);
      paramDescriptorKindFilter = (Collection)new ArrayList();
      paramFunction1 = paramFunction1.iterator();
      while (paramFunction1.hasNext())
      {
        Object localObject = paramFunction1.next();
        if ((localObject instanceof ClassifierDescriptorWithTypeParameters)) {
          paramDescriptorKindFilter.add(localObject);
        }
      }
      return (List)paramDescriptorKindFilter;
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public Set<Name> getFunctionNames()
  {
    return this.workerScope.getFunctionNames();
  }
  
  @NotNull
  public Set<Name> getVariableNames()
  {
    return this.workerScope.getVariableNames();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Classes from ");
    localStringBuilder.append(this.workerScope);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper
 * JD-Core Version:    0.7.0.1
 */