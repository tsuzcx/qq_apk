package com.tencent.tmediacodec.codec;

import android.view.Surface;
import com.tencent.tmediacodec.util.LogUtils;

class ReuseCodecWrapper$2
  implements Runnable
{
  ReuseCodecWrapper$2(ReuseCodecWrapper paramReuseCodecWrapper, Surface paramSurface) {}
  
  public void run()
  {
    if (LogUtils.isLogEnable())
    {
      String str = this.this$0.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("releaseOldSurface ");
      localStringBuilder.append(this.val$surface);
      LogUtils.d(str, localStringBuilder.toString());
    }
    this.val$surface.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper.2
 * JD-Core Version:    0.7.0.1
 */