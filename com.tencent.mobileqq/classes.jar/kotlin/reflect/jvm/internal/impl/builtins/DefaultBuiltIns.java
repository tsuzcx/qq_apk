package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class DefaultBuiltIns
  extends KotlinBuiltIns
{
  public static final DefaultBuiltIns.Companion Companion = new DefaultBuiltIns.Companion(null);
  @NotNull
  private static final DefaultBuiltIns Instance = new DefaultBuiltIns(false, 1, null);
  
  public DefaultBuiltIns()
  {
    this(false, 1, null);
  }
  
  public DefaultBuiltIns(boolean paramBoolean)
  {
    super((StorageManager)new LockBasedStorageManager("DefaultBuiltIns"));
    if (paramBoolean) {
      createBuiltInsModule(false);
    }
  }
  
  @NotNull
  public static final DefaultBuiltIns getInstance()
  {
    DefaultBuiltIns.Companion localCompanion = Companion;
    return Instance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns
 * JD-Core Version:    0.7.0.1
 */