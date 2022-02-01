package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmBuiltInClassDescriptorFactory
  implements ClassDescriptorFactory
{
  @NotNull
  private static final ClassId CLONEABLE_CLASS_ID;
  private static final Name CLONEABLE_NAME;
  public static final JvmBuiltInClassDescriptorFactory.Companion Companion = new JvmBuiltInClassDescriptorFactory.Companion(null);
  private static final FqName KOTLIN_FQ_NAME = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
  private final NotNullLazyValue cloneable$delegate;
  private final Function1<ModuleDescriptor, DeclarationDescriptor> computeContainingDeclaration;
  private final ModuleDescriptor moduleDescriptor;
  
  static
  {
    Object localObject = KotlinBuiltIns.FQ_NAMES.cloneable.shortName();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "KotlinBuiltIns.FQ_NAMES.cloneable.shortName()");
    CLONEABLE_NAME = (Name)localObject;
    localObject = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.cloneable.toSafe());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ClassId.topLevel(KotlinB…NAMES.cloneable.toSafe())");
    CLONEABLE_CLASS_ID = (ClassId)localObject;
  }
  
  public JvmBuiltInClassDescriptorFactory(@NotNull StorageManager paramStorageManager, @NotNull ModuleDescriptor paramModuleDescriptor, @NotNull Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> paramFunction1)
  {
    this.moduleDescriptor = paramModuleDescriptor;
    this.computeContainingDeclaration = paramFunction1;
    this.cloneable$delegate = paramStorageManager.createLazyValue((Function0)new JvmBuiltInClassDescriptorFactory.cloneable.2(this, paramStorageManager));
  }
  
  private final ClassDescriptorImpl getCloneable()
  {
    return (ClassDescriptorImpl)StorageKt.getValue(this.cloneable$delegate, this, $$delegatedProperties[0]);
  }
  
  @Nullable
  public ClassDescriptor createClass(@NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    if (Intrinsics.areEqual(paramClassId, CLONEABLE_CLASS_ID)) {
      return (ClassDescriptor)getCloneable();
    }
    return null;
  }
  
  @NotNull
  public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "packageFqName");
    if (Intrinsics.areEqual(paramFqName, KOTLIN_FQ_NAME)) {
      return (Collection)SetsKt.setOf(getCloneable());
    }
    return (Collection)SetsKt.emptySet();
  }
  
  public boolean shouldCreateClass(@NotNull FqName paramFqName, @NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "packageFqName");
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return (Intrinsics.areEqual(paramName, CLONEABLE_NAME)) && (Intrinsics.areEqual(paramFqName, KOTLIN_FQ_NAME));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */