package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SubstitutingScope
  implements MemberScope
{
  private final Lazy _allDescriptors$delegate;
  private Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
  private final TypeSubstitutor substitutor;
  private final MemberScope workerScope;
  
  public SubstitutingScope(@NotNull MemberScope paramMemberScope, @NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    this.workerScope = paramMemberScope;
    paramMemberScope = paramTypeSubstitutor.getSubstitution();
    Intrinsics.checkExpressionValueIsNotNull(paramMemberScope, "givenSubstitutor.substitution");
    this.substitutor = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(paramMemberScope, false, 1, null).buildSubstitutor();
    this._allDescriptors$delegate = LazyKt.lazy((Function0)new SubstitutingScope._allDescriptors.2(this));
  }
  
  private final Collection<DeclarationDescriptor> get_allDescriptors()
  {
    return (Collection)this._allDescriptors$delegate.getValue();
  }
  
  private final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> paramCollection)
  {
    if (this.substitutor.isEmpty()) {
      return paramCollection;
    }
    if (paramCollection.isEmpty()) {
      return paramCollection;
    }
    LinkedHashSet localLinkedHashSet = CollectionsKt.newLinkedHashSetWithExpectedSize(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localLinkedHashSet.add(substitute((DeclarationDescriptor)paramCollection.next()));
    }
    return (Collection)localLinkedHashSet;
  }
  
  private final <D extends DeclarationDescriptor> D substitute(D paramD)
  {
    if (this.substitutor.isEmpty()) {
      return paramD;
    }
    if (this.substitutedDescriptors == null) {
      this.substitutedDescriptors = ((Map)new HashMap());
    }
    Map localMap = this.substitutedDescriptors;
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    Object localObject2 = localMap.get(paramD);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      if ((paramD instanceof Substitutable))
      {
        localObject1 = ((Substitutable)paramD).substitute(this.substitutor);
        if (localObject1 != null)
        {
          localObject1 = (DeclarationDescriptor)localObject1;
          localMap.put(paramD, localObject1);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, ");
          ((StringBuilder)localObject1).append("but ");
          ((StringBuilder)localObject1).append(paramD);
          ((StringBuilder)localObject1).append(" substitution fails");
          throw ((Throwable)new AssertionError(((StringBuilder)localObject1).toString()));
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unknown descriptor in scope: ");
        ((StringBuilder)localObject1).append(paramD);
        throw ((Throwable)new IllegalStateException(((StringBuilder)localObject1).toString().toString()));
      }
    }
    paramD = (DeclarationDescriptor)localObject1;
    if (paramD != null) {
      return paramD;
    }
    throw new TypeCastException("null cannot be cast to non-null type D");
  }
  
  @Nullable
  public ClassifierDescriptor getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    paramName = this.workerScope.getContributedClassifier(paramName, paramLookupLocation);
    if (paramName != null) {
      return (ClassifierDescriptor)substitute((DeclarationDescriptor)paramName);
    }
    return null;
  }
  
  @NotNull
  public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorKindFilter, "kindFilter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    return get_allDescriptors();
  }
  
  @NotNull
  public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    return substitute(this.workerScope.getContributedFunctions(paramName, paramLookupLocation));
  }
  
  @NotNull
  public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    return substitute(this.workerScope.getContributedVariables(paramName, paramLookupLocation));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope
 * JD-Core Version:    0.7.0.1
 */