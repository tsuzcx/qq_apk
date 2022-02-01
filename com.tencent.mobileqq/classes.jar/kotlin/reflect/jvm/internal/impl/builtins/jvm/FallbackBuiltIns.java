package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.All;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

final class FallbackBuiltIns
  extends KotlinBuiltIns
{
  public static final FallbackBuiltIns.Companion Companion = new FallbackBuiltIns.Companion(null);
  @NotNull
  private static final KotlinBuiltIns Instance = (KotlinBuiltIns)new FallbackBuiltIns();
  
  private FallbackBuiltIns()
  {
    super((StorageManager)new LockBasedStorageManager("FallbackBuiltIns"));
    createBuiltInsModule(true);
  }
  
  @NotNull
  protected PlatformDependentDeclarationFilter.All getPlatformDependentDeclarationFilter()
  {
    return PlatformDependentDeclarationFilter.All.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns
 * JD-Core Version:    0.7.0.1
 */