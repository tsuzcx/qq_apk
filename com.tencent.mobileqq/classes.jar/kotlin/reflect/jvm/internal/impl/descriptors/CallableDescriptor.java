package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface CallableDescriptor
  extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility, Substitutable<CallableDescriptor>
{
  @Nullable
  public abstract ReceiverParameterDescriptor getDispatchReceiverParameter();
  
  @Nullable
  public abstract ReceiverParameterDescriptor getExtensionReceiverParameter();
  
  @NotNull
  public abstract CallableDescriptor getOriginal();
  
  @NotNull
  public abstract Collection<? extends CallableDescriptor> getOverriddenDescriptors();
  
  @Nullable
  public abstract KotlinType getReturnType();
  
  @NotNull
  public abstract List<TypeParameterDescriptor> getTypeParameters();
  
  @Nullable
  public abstract <V> V getUserData(CallableDescriptor.UserDataKey<V> paramUserDataKey);
  
  @NotNull
  public abstract List<ValueParameterDescriptor> getValueParameters();
  
  public abstract boolean hasSynthesizedParameterNames();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
 * JD-Core Version:    0.7.0.1
 */