package com.tencent.tmediacodec.codec;

import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tmediacodec.hook.SurfaceCallback;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.Set;

class ReuseCodecWrapper$1
  implements SurfaceCallback
{
  ReuseCodecWrapper$1(ReuseCodecWrapper paramReuseCodecWrapper) {}
  
  public void onDestroy(@NonNull SurfaceTexture paramSurfaceTexture)
  {
    if (TextUtils.equals(ReuseCodecWrapper.access$000(this.this$0), paramSurfaceTexture.toString()))
    {
      ReuseCodecWrapper.access$100(this.this$0).add(paramSurfaceTexture);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.this$0);
      localStringBuilder.append("      surfaceDestroyed ... surfaceTexture:");
      localStringBuilder.append(paramSurfaceTexture);
      localStringBuilder.append("     mStoreToRelease.size:");
      localStringBuilder.append(ReuseCodecWrapper.access$100(this.this$0).size());
      LogUtils.w("ReuseCodecWrapper", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper.1
 * JD-Core Version:    0.7.0.1
 */