package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface ResolutionScope
{
  @Nullable
  public abstract ClassifierDescriptor getContributedClassifier(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation);
  
  @NotNull
  public abstract Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter paramDescriptorKindFilter, @NotNull Function1<? super Name, Boolean> paramFunction1);
  
  @NotNull
  public abstract Collection<? extends FunctionDescriptor> getContributedFunctions(@NotNull Name paramName, @NotNull LookupLocation paramLookupLocation);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
 * JD-Core Version:    0.7.0.1
 */