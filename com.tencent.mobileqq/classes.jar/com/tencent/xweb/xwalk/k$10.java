package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.TextureView;
import android.view.View;
import com.tencent.xweb.internal.IWebView.a;
import org.xwalk.core.Log;

class k$10
  implements Runnable
{
  k$10(k paramk, View paramView, IWebView.a parama) {}
  
  public void run()
  {
    Bitmap localBitmap = ((TextureView)this.a).getBitmap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFinishGetBitmap with ");
    localStringBuilder.append(localBitmap);
    Log.d("XWWebView", localStringBuilder.toString());
    this.b.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k.10
 * JD-Core Version:    0.7.0.1
 */