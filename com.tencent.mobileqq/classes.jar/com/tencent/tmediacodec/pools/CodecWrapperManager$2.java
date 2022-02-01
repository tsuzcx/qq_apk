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
    if (LogUtils.isLogEnable()) {
      LogUtils.d("CodecWrapperManager", "onErase codecWrapper:" + paramReuseCodecWrapper);
    }
    paramReuseCodecWrapper.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.CodecWrapperManager.2
 * JD-Core Version:    0.7.0.1
 */