package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface SignaturePropagator
{
  public static final SignaturePropagator DO_NOTHING = new SignaturePropagator.1();
  
  public abstract void reportSignatureErrors(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, @NotNull List<String> paramList);
  
  @NotNull
  public abstract SignaturePropagator.PropagatedSignature resolvePropagatedSignature(@NotNull JavaMethod paramJavaMethod, @NotNull ClassDescriptor paramClassDescriptor, @NotNull KotlinType paramKotlinType1, @Nullable KotlinType paramKotlinType2, @NotNull List<ValueParameterDescriptor> paramList, @NotNull List<TypeParameterDescriptor> paramList1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator
 * JD-Core Version:    0.7.0.1
 */