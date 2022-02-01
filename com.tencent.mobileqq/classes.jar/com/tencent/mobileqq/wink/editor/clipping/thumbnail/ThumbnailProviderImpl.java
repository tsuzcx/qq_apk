package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.IThumbnailProvider;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.IViewThumbnailGeneratedListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderImpl;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;", "()V", "listenerCache", "", "", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IThumbnailGeneratedListener;", "getBitmapByTime", "Landroid/graphics/Bitmap;", "timeMs", "", "tag", "", "assetPath", "", "getDefaultBitmap", "registerListener", "", "listener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IViewThumbnailGeneratedListener;", "unRegisterListener", "ListenerWrapper", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbnailProviderImpl
  implements IThumbnailProvider
{
  public static final ThumbnailProviderImpl a = new ThumbnailProviderImpl();
  private static final Map<Integer, IThumbnailGeneratedListener> b = (Map)new LinkedHashMap();
  
  @Nullable
  public Bitmap a()
  {
    return ThumbnailProviderManager.a.a();
  }
  
  @Nullable
  public Bitmap a(long paramLong, @Nullable Object paramObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "assetPath");
    return ThumbnailProviderManager.a.a(paramLong, paramObject, paramString);
  }
  
  public void a(@NotNull IViewThumbnailGeneratedListener paramIViewThumbnailGeneratedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIViewThumbnailGeneratedListener, "listener");
    if (!b.containsKey(Integer.valueOf(paramIViewThumbnailGeneratedListener.hashCode())))
    {
      ThumbnailProviderImpl.ListenerWrapper localListenerWrapper = new ThumbnailProviderImpl.ListenerWrapper(paramIViewThumbnailGeneratedListener);
      b.put(Integer.valueOf(paramIViewThumbnailGeneratedListener.hashCode()), localListenerWrapper);
      ThumbnailProviderManager.a.a((IThumbnailGeneratedListener)localListenerWrapper);
    }
  }
  
  public void b(@NotNull IViewThumbnailGeneratedListener paramIViewThumbnailGeneratedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIViewThumbnailGeneratedListener, "listener");
    paramIViewThumbnailGeneratedListener = (IThumbnailGeneratedListener)b.remove(Integer.valueOf(paramIViewThumbnailGeneratedListener.hashCode()));
    if (paramIViewThumbnailGeneratedListener != null) {
      ThumbnailProviderManager.a.b(paramIViewThumbnailGeneratedListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderImpl
 * JD-Core Version:    0.7.0.1
 */