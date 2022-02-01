package com.tencent.mobileqq.kandian.glue.viola.adapter.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.commons.ImageAdapterHolder.ImgSpanListener;
import com.tencent.viola.ui.component.image.ImageAction;
import java.lang.ref.WeakReference;

class ComponentAdapter$ImageSpanAction
  implements ImageAction
{
  private WeakReference<ImageAdapterHolder.ImgSpanListener> a;
  private String b;
  
  public ComponentAdapter$ImageSpanAction(ImageAdapterHolder.ImgSpanListener paramImgSpanListener, String paramString)
  {
    this.a = new WeakReference(paramImgSpanListener);
    this.b = paramString;
  }
  
  public ImageView getTarget()
  {
    return null;
  }
  
  public void onCancel()
  {
    Object localObject = (ImageAdapterHolder.ImgSpanListener)this.a.get();
    if (localObject != null) {
      ((ImageAdapterHolder.ImgSpanListener)localObject).onSpanFInish(this.b, null, false, null);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load img span cancel: ");
    ((StringBuilder)localObject).append(this.b);
    QLog.e("ComponentAdapter", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onError()
  {
    Object localObject = (ImageAdapterHolder.ImgSpanListener)this.a.get();
    if (localObject != null) {
      ((ImageAdapterHolder.ImgSpanListener)localObject).onSpanFInish(this.b, null, false, null);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load img span error: ");
    ((StringBuilder)localObject).append(this.b);
    QLog.e("ComponentAdapter", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onSuccess(Object paramObject, String paramString, Bundle paramBundle)
  {
    if ((paramObject instanceof Drawable))
    {
      ImageAdapterHolder.ImgSpanListener localImgSpanListener = (ImageAdapterHolder.ImgSpanListener)this.a.get();
      if (localImgSpanListener != null) {
        localImgSpanListener.onSpanFInish(paramString, (Drawable)paramObject, true, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ui.ComponentAdapter.ImageSpanAction
 * JD-Core Version:    0.7.0.1
 */