package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/os/Handler;", "invoke"}, k=3, mv={1, 1, 16})
final class ThumbnailProviderManager$generateHandler$2
  extends Lambda
  implements Function0<Handler>
{
  public static final 2 INSTANCE = new 2();
  
  ThumbnailProviderManager$generateHandler$2()
  {
    super(0);
  }
  
  @NotNull
  public final Handler invoke()
  {
    HandlerThread localHandlerThread = new HandlerThread("VideoThumbProviderManager", 0);
    localHandlerThread.start();
    return new Handler(localHandlerThread.getLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager.generateHandler.2
 * JD-Core Version:    0.7.0.1
 */