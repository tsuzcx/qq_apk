package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Visibility
{
  private final boolean isPublicAPI;
  @NotNull
  private final String name;
  
  protected Visibility(@NotNull String paramString, boolean paramBoolean)
  {
    this.name = paramString;
    this.isPublicAPI = paramBoolean;
  }
  
  @Nullable
  protected Integer compareTo(@NotNull Visibility paramVisibility)
  {
    Intrinsics.checkParameterIsNotNull(paramVisibility, "visibility");
    return Visibilities.compareLocal(this, paramVisibility);
  }
  
  @NotNull
  public String getInternalDisplayName()
  {
    return this.name;
  }
  
  public final boolean isPublicAPI()
  {
    return this.isPublicAPI;
  }
  
  public abstract boolean isVisible(@Nullable ReceiverValue paramReceiverValue, @NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility, @NotNull DeclarationDescriptor paramDeclarationDescriptor);
  
  @NotNull
  public Visibility normalize()
  {
    return this;
  }
  
  @NotNull
  public final String toString()
  {
    return getInternalDisplayName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.Visibility
 * JD-Core Version:    0.7.0.1
 */