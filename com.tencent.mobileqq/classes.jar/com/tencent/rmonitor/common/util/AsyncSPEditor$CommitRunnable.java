package com.tencent.rmonitor.common.util;

import android.content.SharedPreferences.Editor;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/AsyncSPEditor$CommitRunnable;", "Ljava/lang/Runnable;", "edit", "Landroid/content/SharedPreferences$Editor;", "(Lcom/tencent/rmonitor/common/util/AsyncSPEditor;Landroid/content/SharedPreferences$Editor;)V", "run", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
final class AsyncSPEditor$CommitRunnable
  implements Runnable
{
  private final SharedPreferences.Editor a;
  
  public AsyncSPEditor$CommitRunnable(SharedPreferences.Editor paramEditor)
  {
    this.a = localObject;
  }
  
  public void run()
  {
    try
    {
      this.a.commit();
      return;
    }
    catch (Exception localException)
    {
      Logger.b.a("RMonitor_common_AsyncSPEditor", (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.AsyncSPEditor.CommitRunnable
 * JD-Core Version:    0.7.0.1
 */