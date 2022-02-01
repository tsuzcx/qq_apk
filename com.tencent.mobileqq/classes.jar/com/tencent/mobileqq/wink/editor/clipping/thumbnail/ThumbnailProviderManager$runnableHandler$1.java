package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.os.Handler;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$runnableHandler$1", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IRunnableHandler;", "postRunnable", "", "runnable", "Ljava/lang/Runnable;", "runnableFailAndReleaseCache", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbnailProviderManager$runnableHandler$1
  implements IRunnableHandler
{
  public void a(@Nullable Runnable paramRunnable)
  {
    ThumbnailProviderManager.c(ThumbnailProviderManager.a).postAtFrontOfQueue(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager.runnableHandler.1
 * JD-Core Version:    0.7.0.1
 */