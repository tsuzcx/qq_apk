package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public abstract interface MemberScope
  extends ResolutionScope
{
  public static final MemberScope.Companion Companion = MemberScope.Companion.$$INSTANCE;
  
  @NotNull
  public abstract Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation);
  
  @NotNull
  public abstract Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation);
  
  @NotNull
  public abstract Set<Name> getFunctionNames();
  
  @NotNull
  public abstract Set<Name> getVariableNames();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
 * JD-Core Version:    0.7.0.1
 */