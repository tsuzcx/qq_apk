package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SignaturePropagator$PropagatedSignature
{
  private final boolean hasStableParameterNames;
  private final KotlinType receiverType;
  private final KotlinType returnType;
  private final List<String> signatureErrors;
  private final List<TypeParameterDescriptor> typeParameters;
  private final List<ValueParameterDescriptor> valueParameters;
  
  public SignaturePropagator$PropagatedSignature(@NotNull KotlinType paramKotlinType1, @Nullable KotlinType paramKotlinType2, @NotNull List<ValueParameterDescriptor> paramList, @NotNull List<TypeParameterDescriptor> paramList1, @NotNull List<String> paramList2, boolean paramBoolean)
  {
    this.returnType = paramKotlinType1;
    this.receiverType = paramKotlinType2;
    this.valueParameters = paramList;
    this.typeParameters = paramList1;
    this.signatureErrors = paramList2;
    this.hasStableParameterNames = paramBoolean;
  }
  
  @NotNull
  public List<String> getErrors()
  {
    List localList = this.signatureErrors;
    if (localList == null) {
      $$$reportNull$$$0(7);
    }
    return localList;
  }
  
  @Nullable
  public KotlinType getReceiverType()
  {
    return this.receiverType;
  }
  
  @NotNull
  public KotlinType getReturnType()
  {
    KotlinType localKotlinType = this.returnType;
    if (localKotlinType == null) {
      $$$reportNull$$$0(4);
    }
    return localKotlinType;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getTypeParameters()
  {
    List localList = this.typeParameters;
    if (localList == null) {
      $$$reportNull$$$0(6);
    }
    return localList;
  }
  
  @NotNull
  public List<ValueParameterDescriptor> getValueParameters()
  {
    List localList = this.valueParameters;
    if (localList == null) {
      $$$reportNull$$$0(5);
    }
    return localList;
  }
  
  public boolean hasStableParameterNames()
  {
    return this.hasStableParameterNames;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator.PropagatedSignature
 * JD-Core Version:    0.7.0.1
 */