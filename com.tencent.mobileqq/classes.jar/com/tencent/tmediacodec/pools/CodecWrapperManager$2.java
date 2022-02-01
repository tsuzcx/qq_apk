package com.tencent.tmediacodec.pools;

import android.support.annotation.NonNull;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.util.LogUtils;

class CodecWrapperManager$2
  implements PoolActionCallback
{
  CodecWrapperManager$2(CodecWrapperManager paramCodecWrapperManager) {}
  
  public void onErase(@NonNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    if (LogUtils.isLogEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onErase codecWrapper:");
      localStringBuilder.append(paramReuseCodecWrapper);
      LogUtils.d("CodecWrapperManager", localStringBuilder.toString());
    }
    paramReuseCodecWrapper.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.CodecWrapperManager.2
 * JD-Core Version:    0.7.0.1
 */