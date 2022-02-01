package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface FunctionDescriptor$CopyBuilder<D extends FunctionDescriptor>
{
  @Nullable
  public abstract D build();
  
  @NotNull
  public abstract CopyBuilder<D> setAdditionalAnnotations(@NotNull Annotations paramAnnotations);
  
  @NotNull
  public abstract CopyBuilder<D> setCopyOverrides(boolean paramBoolean);
  
  @NotNull
  public abstract CopyBuilder<D> setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor);
  
  @NotNull
  public abstract CopyBuilder<D> setDropOriginalInContainingParts();
  
  @NotNull
  public abstract CopyBuilder<D> setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor);
  
  @NotNull
  public abstract CopyBuilder<D> setHiddenForResolutionEverywhereBesideSupercalls();
  
  @NotNull
  public abstract CopyBuilder<D> setHiddenToOvercomeSignatureClash();
  
  @NotNull
  public abstract CopyBuilder<D> setKind(@NotNull CallableMemberDescriptor.Kind paramKind);
  
  @NotNull
  public abstract CopyBuilder<D> setModality(@NotNull Modality paramModality);
  
  @NotNull
  public abstract CopyBuilder<D> setName(@NotNull Name paramName);
  
  @NotNull
  public abstract CopyBuilder<D> setOriginal(@Nullable CallableMemberDescriptor paramCallableMemberDescriptor);
  
  @NotNull
  public abstract CopyBuilder<D> setOwner(@NotNull DeclarationDescriptor paramDeclarationDescriptor);
  
  @NotNull
  public abstract CopyBuilder<D> setPreserveSourceElement();
  
  @NotNull
  public abstract CopyBuilder<D> setReturnType(@NotNull KotlinType paramKotlinType);
  
  @NotNull
  public abstract CopyBuilder<D> setSignatureChange();
  
  @NotNull
  public abstract CopyBuilder<D> setSubstitution(@NotNull TypeSubstitution paramTypeSubstitution);
  
  @NotNull
  public abstract CopyBuilder<D> setTypeParameters(@NotNull List<TypeParameterDescriptor> paramList);
  
  @NotNull
  public abstract CopyBuilder<D> setValueParameters(@NotNull List<ValueParameterDescriptor> paramList);
  
  @NotNull
  public abstract CopyBuilder<D> setVisibility(@NotNull Visibility paramVisibility);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
 * JD-Core Version:    0.7.0.1
 */