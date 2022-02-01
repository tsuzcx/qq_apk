package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class CloneableClassScope
  extends GivenFunctionsMemberScope
{
  @NotNull
  private static final Name CLONE_NAME;
  public static final CloneableClassScope.Companion Companion = new CloneableClassScope.Companion(null);
  
  static
  {
    Name localName = Name.identifier("clone");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"clone\")");
    CLONE_NAME = localName;
  }
  
  public CloneableClassScope(@NotNull StorageManager paramStorageManager, @NotNull ClassDescriptor paramClassDescriptor)
  {
    super(paramStorageManager, paramClassDescriptor);
  }
  
  @NotNull
  protected List<FunctionDescriptor> computeDeclaredFunctions()
  {
    SimpleFunctionDescriptorImpl localSimpleFunctionDescriptorImpl = SimpleFunctionDescriptorImpl.create((DeclarationDescriptor)getContainingClass(), Annotations.Companion.getEMPTY(), CLONE_NAME, CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE);
    localSimpleFunctionDescriptorImpl.initialize(null, getContainingClass().getThisAsReceiverParameter(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), (KotlinType)DescriptorUtilsKt.getBuiltIns((DeclarationDescriptor)getContainingClass()).getAnyType(), Modality.OPEN, Visibilities.PROTECTED);
    return CollectionsKt.listOf(localSimpleFunctionDescriptorImpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope
 * JD-Core Version:    0.7.0.1
 */