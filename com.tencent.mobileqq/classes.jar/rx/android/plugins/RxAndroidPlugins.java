package rx.android.plugins;

import java.util.concurrent.atomic.AtomicReference;
import rx.annotations.Beta;

public final class RxAndroidPlugins
{
  private static final RxAndroidPlugins INSTANCE = new RxAndroidPlugins();
  private final AtomicReference<RxAndroidSchedulersHook> schedulersHook = new AtomicReference();
  
  public static RxAndroidPlugins getInstance()
  {
    return INSTANCE;
  }
  
  public RxAndroidSchedulersHook getSchedulersHook()
  {
    if (this.schedulersHook.get() == null) {
      this.schedulersHook.compareAndSet(null, RxAndroidSchedulersHook.getDefaultInstance());
    }
    return (RxAndroidSchedulersHook)this.schedulersHook.get();
  }
  
  public void registerSchedulersHook(RxAndroidSchedulersHook paramRxAndroidSchedulersHook)
  {
    if (!this.schedulersHook.compareAndSet(null, paramRxAndroidSchedulersHook)) {
      throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
    }
  }
  
  @Beta
  public void reset()
  {
    this.schedulersHook.set(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.android.plugins.RxAndroidPlugins
 * JD-Core Version:    0.7.0.1
 */