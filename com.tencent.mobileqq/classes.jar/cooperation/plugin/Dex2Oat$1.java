package cooperation.plugin;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

final class Dex2Oat$1
  implements ThreadFactory
{
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "PluginDex2Oat");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.Dex2Oat.1
 * JD-Core Version:    0.7.0.1
 */