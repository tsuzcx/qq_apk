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
        localObject = TMediaCodec.createDecoderByType(paramString);
        ((TMediaCodec)localObject).configure(getPreloadMediaFormat(paramString), localSurface, (MediaCrypto)null, 0);
        ((TMediaCodec)localObject).start();
        ((TMediaCodec)localObject).stop();
        ((TMediaCodec)localObject).release();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preloadCodecByMimeType sampleMimeType:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" surface:");
        ((StringBuilder)localObject).append(localSurface);
        ((StringBuilder)localObject).append(" success");
        LogUtils.d("PreloadCodecManager", ((StringBuilder)localObject).toString());
        return;
      }
      catch (Throwable localThrowable)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preloadCodecByMimeType sampleMimeType:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" exception...");
        LogUtils.w("PreloadCodecManager", ((StringBuilder)localObject).toString(), localThrowable);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadCodecByMimeType sampleMimeType:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" failed...");
    LogUtils.w("PreloadCodecManager", localStringBuilder.toString());
  }
  
  public final void preload(@NonNull Set<String> paramSet)
  {
    if ((!this.isPreloaded) && (Build.VERSION.SDK_INT >= 17))
    {
      ThreadManager.execute(new PreloadCodecManager.1(this, paramSet));
      return;
    }
    paramSet = new StringBuilder();
    paramSet.append("preload codec return, for isPreload:");
    paramSet.append(this.isPreloaded);
    paramSet.append(" apiLevel:");
    paramSet.append(Build.VERSION.SDK_INT);
    LogUtils.w("PreloadCodecManager", paramSet.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.preload.PreloadCodecManager
 * JD-Core Version:    0.7.0.1
 */