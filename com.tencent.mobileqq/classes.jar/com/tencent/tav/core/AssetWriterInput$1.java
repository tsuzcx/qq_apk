package com.tencent.tav.core;

import android.support.annotation.RequiresApi;

class AssetWriterInput$1
  implements Runnable
{
  AssetWriterInput$1(AssetWriterInput paramAssetWriterInput, Runnable paramRunnable) {}
  
  @RequiresApi(api=18)
  public void run()
  {
    if (this.this$0.start()) {
      this.val$callback.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput.1
 * JD-Core Version:    0.7.0.1
 */