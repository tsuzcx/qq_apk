package com.tencent.tmediacodec.preload;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.TMediaCodec;
import com.tencent.tmediacodec.preload.glrender.OutputSurface;
import com.tencent.tmediacodec.reuse.ReusePolicy;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import com.tencent.tmediacodec.util.ThreadManager;
import java.util.Set;

public final class PreloadCodecManager
{
  private static final String TAG = "PreloadCodecManager";
  private boolean isPreloaded;
  
  private final MediaFormat getPreloadMediaFormat(String paramString)
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", paramString);
    ReusePolicy localReusePolicy = TCodecManager.getInstance().getReusePolicy();
    int i = localReusePolicy.initWidth;
    int j = localReusePolicy.initHeight;
    int k = Math.max(0, TUtils.getCodecMaxInputSize(paramString, i, j));
    localMediaFormat.setInteger("width", 1);
    localMediaFormat.setInteger("height", 1);
    localMediaFormat.setInteger("rotation-degrees", 0);
    localMediaFormat.setInteger("max-input-size", Math.max(k, 0));
    if (Build.VERSION.SDK_INT >= 19)
    {
      localMediaFormat.setInteger("max-width", i);
      localMediaFormat.setInteger("max-height", j);
    }
    return localMediaFormat;
  }
  
  @TargetApi(17)
  private final Surface getSurface()
  {
    return new OutputSurface(1, 1).getSurface();
  }
  
  public static boolean isInvalideMimeType(String paramString)
  {
    return (TextUtils.equals(paramString, "video/avc")) || (TextUtils.equals(paramString, "video/hevc"));
  }
  
  private final void preloadCodecByMimeType(String paramString)
  {
    Surface localSurface = getSurface();
    if (localSurface != null) {
      try
      {
        TMediaCodec localTMediaCodec = TMediaCodec.createDecoderByType(paramString);
        localTMediaCodec.configure(getPreloadMediaFormat(paramString), localSurface, (MediaCrypto)null, 0);
        localTMediaCodec.start();
        localTMediaCodec.stop();
        localTMediaCodec.release();
        LogUtils.d("PreloadCodecManager", "preloadCodecByMimeType sampleMimeType:" + paramString + " surface:" + localSurface + " success");
        return;
      }
      catch (Throwable localThrowable)
      {
        LogUtils.w("PreloadCodecManager", "preloadCodecByMimeType sampleMimeType:" + paramString + " exception...", localThrowable);
        return;
      }
    }
    LogUtils.w("PreloadCodecManager", "preloadCodecByMimeType sampleMimeType:" + paramString + " failed...");
  }
  
  public final void preload(@NonNull Set<String> paramSet)
  {
    if ((this.isPreloaded) || (Build.VERSION.SDK_INT < 17))
    {
      LogUtils.w("PreloadCodecManager", "preload codec return, for isPreload:" + this.isPreloaded + " apiLevel:" + Build.VERSION.SDK_INT);
      return;
    }
    ThreadManager.execute(new PreloadCodecManager.1(this, paramSet));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.preload.PreloadCodecManager
 * JD-Core Version:    0.7.0.1
 */