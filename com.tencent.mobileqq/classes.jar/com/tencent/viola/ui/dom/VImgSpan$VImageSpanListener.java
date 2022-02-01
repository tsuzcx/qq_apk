package com.tencent.viola.ui.dom;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.viola.commons.ImageAdapterHolder.ImgSpanListener;
import java.lang.ref.WeakReference;

class VImgSpan$VImageSpanListener
  implements ImageAdapterHolder.ImgSpanListener
{
  private final WeakReference<VImgSpan> spanWeakRef;
  
  public VImgSpan$VImageSpanListener(VImgSpan paramVImgSpan)
  {
    this.spanWeakRef = new WeakReference(paramVImgSpan);
  }
  
  public void onSpanFInish(String paramString, Drawable paramDrawable, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.spanWeakRef.get() != null) {
      ((VImgSpan)this.spanWeakRef.get()).loadSpanFinish(paramString, paramDrawable, paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.VImgSpan.VImageSpanListener
 * JD-Core Version:    0.7.0.1
 */