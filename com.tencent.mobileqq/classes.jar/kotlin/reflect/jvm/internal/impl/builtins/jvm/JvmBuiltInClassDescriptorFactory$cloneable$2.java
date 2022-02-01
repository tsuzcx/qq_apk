package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltInClassDescriptorFactory$cloneable$2
  extends Lambda
  implements Function0<ClassDescriptorImpl>
{
  JvmBuiltInClassDescriptorFactory$cloneable$2(JvmBuiltInClassDescriptorFactory paramJvmBuiltInClassDescriptorFactory, StorageManager paramStorageManager)
  {
    super(0);
  }
  
  @NotNull
  public final ClassDescriptorImpl invoke()
  {
    ClassDescriptorImpl localClassDescriptorImpl = new ClassDescriptorImpl((DeclarationDescriptor)JvmBuiltInClassDescriptorFactory.access$getComputeContainingDeclaration$p(this.this$0).invoke(JvmBuiltInClassDescriptorFactory.access$getModuleDescriptor$p(this.this$0)), JvmBuiltInClassDescriptorFactory.access$getCLONEABLE_NAME$cp(), Modality.ABSTRACT, ClassKind.INTERFACE, (Collection)CollectionsKt.listOf(JvmBuiltInClassDescriptorFactory.access$getModuleDescriptor$p(this.this$0).getBuiltIns().getAnyType()), SourceElement.NO_SOURCE, false, this.$storageManager);
    localClassDescriptorImpl.initialize((MemberScope)new CloneableClassScope(this.$storageManager, (ClassDescriptor)localClassDescriptorImpl), SetsKt.emptySet(), null);
    return localClassDescriptorImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.cloneable.2
 * JD-Core Version:    0.7.0.1
 */