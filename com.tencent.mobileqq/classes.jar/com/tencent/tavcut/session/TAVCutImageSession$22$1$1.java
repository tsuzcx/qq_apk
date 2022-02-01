package com.tencent.tavcut.session;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.tavcut.view.TAVCutImageView;
import java.lang.ref.WeakReference;

class TAVCutImageSession$22$1$1
  implements Runnable
{
  TAVCutImageSession$22$1$1(TAVCutImageSession.22.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    Object localObject1 = (WeakReference)TAVCutImageSession.access$200(this.this$2.this$1.this$0).get(this.this$2.this$1.val$index);
    Object localObject2;
    int j;
    int k;
    int m;
    if (localObject1 != null)
    {
      localObject1 = (TAVCutImageView)((WeakReference)localObject1).get();
      if (localObject1 != null)
      {
        ((TAVCutImageView)localObject1).setImageBitmap(this.val$bitmap);
        localObject2 = ((TAVCutImageView)localObject1).getParent();
        if ((localObject2 instanceof ViewGroup))
        {
          localObject2 = (ViewGroup)localObject2;
          int i = ((ViewGroup)localObject2).getWidth() - ((ViewGroup)localObject2).getPaddingLeft() - ((ViewGroup)localObject2).getPaddingRight();
          j = ((ViewGroup)localObject2).getHeight() - ((ViewGroup)localObject2).getPaddingTop() - ((ViewGroup)localObject2).getPaddingBottom();
          k = this.val$bitmap.getWidth();
          m = this.val$bitmap.getHeight();
          localObject2 = ((TAVCutImageView)localObject1).getLayoutParams();
          if (k * 1.0F / m <= i * 1.0F / j) {
            break label192;
          }
          ((ViewGroup.LayoutParams)localObject2).width = i;
          ((ViewGroup.LayoutParams)localObject2).height = ((int)(i * 1.0F * m / k));
        }
      }
    }
    for (;;)
    {
      ((TAVCutImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      return;
      label192:
      ((ViewGroup.LayoutParams)localObject2).height = j;
      ((ViewGroup.LayoutParams)localObject2).width = ((int)(j * 1.0F * k / m));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.22.1.1
 * JD-Core Version:    0.7.0.1
 */