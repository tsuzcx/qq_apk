package com.tencent.viola.ui.component.image;

import android.graphics.Bitmap;
import android.os.Bundle;

class VImage2$3
  implements Runnable
{
  VImage2$3(VImage2 paramVImage2, Bitmap paramBitmap, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    Bitmap localBitmap = this.val$bitmap;
    if (localBitmap != null)
    {
      this.this$0.onSuccess(localBitmap, this.val$url, this.val$extraBundle);
      return;
    }
    this.this$0.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.image.VImage2.3
 * JD-Core Version:    0.7.0.1
 */