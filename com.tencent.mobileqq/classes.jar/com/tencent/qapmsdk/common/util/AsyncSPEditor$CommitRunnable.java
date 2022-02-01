package com.tencent.qapmsdk.common.util;

import android.content.SharedPreferences.Editor;
import com.tencent.qapmsdk.common.logger.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/AsyncSPEditor$CommitRunnable;", "Ljava/lang/Runnable;", "edit", "Landroid/content/SharedPreferences$Editor;", "(Lcom/tencent/qapmsdk/common/util/AsyncSPEditor;Landroid/content/SharedPreferences$Editor;)V", "run", "", "common_release"}, k=1, mv={1, 1, 15})
final class AsyncSPEditor$CommitRunnable
  implements Runnable
{
  private final SharedPreferences.Editor edit;
  
  public AsyncSPEditor$CommitRunnable(SharedPreferences.Editor paramEditor)
  {
    this.edit = localObject;
  }
  
  public void run()
  {
    try
    {
      this.edit.commit();
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_common_AsyncSPEditor", (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.AsyncSPEditor.CommitRunnable
 * JD-Core Version:    0.7.0.1
 */