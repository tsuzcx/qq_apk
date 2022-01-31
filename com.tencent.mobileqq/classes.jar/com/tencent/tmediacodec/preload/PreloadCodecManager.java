package com.tencent.tmediacodec.preload;

import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.TCodecManager.Companion;
import com.tencent.tmediacodec.reuse.ReusePolicy;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import com.tencent.tmediacodec.util.ThreadManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/preload/PreloadCodecManager;", "", "()V", "isPreloaded", "", "getPreloadMediaFormat", "Landroid/media/MediaFormat;", "sampleMimeType", "", "preload", "", "sampleMimeTypeSet", "", "preloadCodecByMimeType", "Companion", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class PreloadCodecManager
{
  public static final PreloadCodecManager.Companion Companion = new PreloadCodecManager.Companion(null);
  private static final String TAG = "PreloadCodecManager";
  private boolean isPreloaded;
  
  private final MediaFormat getPreloadMediaFormat(String paramString)
  {
    int i = 0;
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", paramString);
    ReusePolicy localReusePolicy = TCodecManager.Companion.getInstance().getReusePolicy();
    int k = localReusePolicy.getInitWidth();
    int m = localReusePolicy.getInitHeight();
    int j = Math.max(0, TUtils.getCodecMaxInputSize$default(TUtils.INSTANCE, paramString, k, m, false, 8, null));
    if (j > 0) {
      i = j;
    }
    localMediaFormat.setInteger("max-input-size", i);
    if (Build.VERSION.SDK_INT >= 19)
    {
      localMediaFormat.setInteger("max-width", k);
      localMediaFormat.setInteger("max-height", m);
    }
    return localMediaFormat;
  }
  
  private final void preloadCodecByMimeType(String paramString) {}
  
  public final void preload(@NotNull Set<String> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "sampleMimeTypeSet");
    if ((this.isPreloaded) || (Build.VERSION.SDK_INT < 17))
    {
      LogUtils.w$default(LogUtils.INSTANCE, "PreloadCodecManager", "preload codec return, for isPreload:" + this.isPreloaded + " apiLevel:" + Build.VERSION.SDK_INT, null, 4, null);
      return;
    }
    ThreadManager.INSTANCE.execute((Runnable)new PreloadCodecManager.preload.1(this, paramSet));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.preload.PreloadCodecManager
 * JD-Core Version:    0.7.0.1
 */