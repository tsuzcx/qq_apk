package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltIns
  extends KotlinBuiltIns
{
  private boolean isAdditionalBuiltInsFeatureSupported = true;
  private ModuleDescriptor ownerModuleDescriptor;
  @NotNull
  private final NotNullLazyValue settings$delegate;
  
  public JvmBuiltIns(@NotNull StorageManager paramStorageManager, @NotNull JvmBuiltIns.Kind paramKind)
  {
    super(paramStorageManager);
    this.settings$delegate = paramStorageManager.createLazyValue((Function0)new JvmBuiltIns.settings.2(this, paramStorageManager));
    int i = JvmBuiltIns.WhenMappings.$EnumSwitchMapping$0[paramKind.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        createBuiltInsModule(true);
        return;
      }
      createBuiltInsModule(false);
    }
  }
  
  @NotNull
  protected AdditionalClassPartsProvider getAdditionalClassPartsProvider()
  {
    return (AdditionalClassPartsProvider)getSettings();
  }
  
  @NotNull
  protected List<ClassDescriptorFactory> getClassDescriptorFactories()
  {
    Iterable localIterable = super.getClassDescriptorFactories();
    Intrinsics.checkExpressionValueIsNotNull(localIterable, "super.getClassDescriptorFactories()");
    StorageManager localStorageManager = getStorageManager();
    Intrinsics.checkExpressionValueIsNotNull(localStorageManager, "storageManager");
    ModuleDescriptorImpl localModuleDescriptorImpl = getBuiltInsModule();
    Intrinsics.checkExpressionValueIsNotNull(localModuleDescriptorImpl, "builtInsModule");
    return CollectionsKt.plus(localIterable, new JvmBuiltInClassDescriptorFactory(localStorageManager, (ModuleDescriptor)localModuleDescriptorImpl, null, 4, null));
  }
  
  @NotNull
  protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter()
  {
    return (PlatformDependentDeclarationFilter)getSettings();
  }
  
  @NotNull
  public final JvmBuiltInsSettings getSettings()
  {
    return (JvmBuiltInsSettings)StorageKt.getValue(this.settings$delegate, this, $$delegatedProperties[0]);
  }
  
  public final void initialize(@NotNull ModuleDescriptor paramModuleDescriptor, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "moduleDescriptor");
    int i;
    if (this.ownerModuleDescriptor == null) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0)) {
      throw ((Throwable)new AssertionError("JvmBuiltins repeated initialization"));
    }
    this.ownerModuleDescriptor = paramModuleDescriptor;
    this.isAdditionalBuiltInsFeatureSupported = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns
 * JD-Core Version:    0.7.0.1
 */