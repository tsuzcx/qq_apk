package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import com.tencent.mobileqq.soload.api.SoLoadManager;

class NativeVueLoaderManager$1
  implements Runnable
{
  NativeVueLoaderManager$1(NativeVueLoaderManager paramNativeVueLoaderManager) {}
  
  public void run()
  {
    SoLoadManager.getInstance().download("nativevue", new NativeVueLoaderManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.NativeVueLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */