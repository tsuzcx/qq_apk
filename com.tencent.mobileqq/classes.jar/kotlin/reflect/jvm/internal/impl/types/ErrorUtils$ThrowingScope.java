package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
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

class ErrorUtils$ThrowingScope
  implements MemberScope
{
  private final String debugMessage;
  
  private ErrorUtils$ThrowingScope(@NotNull String paramString)
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
    paramLookupLocation = new StringBuilder();
    paramLookupLocation.append(this.debugMessage);
    paramLookupLocation.append(", required name: ");
    paramLookupLocation.append(paramName);
    throw new IllegalStateException(paramLookupLocation.toString());
  }
  
  @NotNull
  public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    if (paramDescriptorKindFilter == null) {
      $$$reportNull$$$0(9);
    }
    if (paramFunction1 == null) {
      $$$reportNull$$$0(10);
    }
    throw new IllegalStateException(this.debugMessage);
  }
  
  @NotNull
  public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    if (paramName == null) {
      $$$reportNull$$$0(7);
    }
    if (paramLookupLocation == null) {
      $$$reportNull$$$0(8);
    }
    paramLookupLocation = new StringBuilder();
    paramLookupLocation.append(this.debugMessage);
    paramLookupLocation.append(", required name: ");
    paramLookupLocation.append(paramName);
    throw new IllegalStateException(paramLookupLocation.toString());
  }
  
  @NotNull
  public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation)
  {
    if (paramName == null) {
      $$$reportNull$$$0(5);
    }
    if (paramLookupLocation == null) {
      $$$reportNull$$$0(6);
    }
    paramLookupLocation = new StringBuilder();
    paramLookupLocation.append(this.debugMessage);
    paramLookupLocation.append(", required name: ");
    paramLookupLocation.append(paramName);
    throw new IllegalStateException(paramLookupLocation.toString());
  }
  
  @NotNull
  public Set<Name> getFunctionNames()
  {
    throw new IllegalStateException();
  }
  
  @NotNull
  public Set<Name> getVariableNames()
  {
    throw new IllegalStateException();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ThrowingScope{");
    localStringBuilder.append(this.debugMessage);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.ErrorUtils.ThrowingScope
 * JD-Core Version:    0.7.0.1
 */