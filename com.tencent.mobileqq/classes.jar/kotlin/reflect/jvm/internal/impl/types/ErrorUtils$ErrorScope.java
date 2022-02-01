package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ErrorUtils$ErrorScope
  implements MemberScope
{
  private final String debugMessage;
  
  private ErrorUtils$ErrorScope(@NotNull String paramString)
  {
    this.debugMessage = paramString;
  }
  
  @Nullable
  public ClassifierDescriptor getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    if (paramName == null) {
      $$$reportNull$$$0(1);
    }
    if (paramLookupLocation == null) {
      $$$reportNull$$$0(2);
    }
    return ErrorUtils.createErrorClass(paramName.asString());
  }
  
  @NotNull
  public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    if (paramDescriptorKindFilter == null) {
      $$$reportNull$$$0(16);
    }
    if (paramFunction1 == null) {
      $$$reportNull$$$0(17);
    }
    paramDescriptorKindFilter = Collections.emptyList();
    if (paramDescriptorKindFilter == null) {
      $$$reportNull$$$0(18);
    }
    return paramDescriptorKindFilter;
  }
  
  @NotNull
  public Set<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    if (paramName == null) {
      $$$reportNull$$$0(8);
    }
    if (paramLookupLocation == null) {
      $$$reportNull$$$0(9);
    }
    paramName = Collections.singleton(ErrorUtils.access$100(this));
    if (paramName == null) {
      $$$reportNull$$$0(10);
    }
    return paramName;
  }
  
  @NotNull
  public Set<? extends PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    if (paramName == null) {
      $$$reportNull$$$0(5);
    }
    if (paramLookupLocation == null) {
      $$$reportNull$$$0(6);
    }
    paramName = ErrorUtils.access$000();
    if (paramName == null) {
      $$$reportNull$$$0(7);
    }
    return paramName;
  }
  
  @NotNull
  public Set<Name> getFunctionNames()
  {
    Set localSet = Collections.emptySet();
    if (localSet == null) {
      $$$reportNull$$$0(11);
    }
    return localSet;
  }
  
  @NotNull
  public Set<Name> getVariableNames()
  {
    Set localSet = Collections.emptySet();
    if (localSet == null) {
      $$$reportNull$$$0(12);
    }
    return localSet;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ErrorScope{");
    localStringBuilder.append(this.debugMessage);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.ErrorUtils.ErrorScope
 * JD-Core Version:    0.7.0.1
 */