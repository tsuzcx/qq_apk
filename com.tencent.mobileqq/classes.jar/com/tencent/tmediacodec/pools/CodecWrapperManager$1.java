package com.tencent.tmediacodec.pools;

import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;

class CodecWrapperManager$1
  implements Runnable
{
  CodecWrapperManager$1(CodecWrapperManager paramCodecWrapperManager, ReuseCodecWrapper paramReuseCodecWrapper) {}
  
  public void run()
  {
    CodecCallback localCodecCallback = this.val$codecWrapper.getCallback();
    if (localCodecCallback != null) {
      localCodecCallback.onTransToRunningPool();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.CodecWrapperManager.1
 * JD-Core Version:    0.7.0.1
 */