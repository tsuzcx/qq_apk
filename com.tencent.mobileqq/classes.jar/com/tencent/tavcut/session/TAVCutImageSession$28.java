package com.tencent.tavcut.session;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tavcut.view.TAVCutImageView;
import java.lang.ref.WeakReference;

class TAVCutImageSession$28
  implements Runnable
{
  TAVCutImageSession$28(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = (WeakReference)TAVCutImageSession.access$400(this.this$0).get(this.a);
    if (localObject1 == null) {
      return;
    }
    localObject1 = (TAVCutImageView)((WeakReference)localObject1).get();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (Bitmap)TAVCutImageSession.access$1400(this.this$0).get(this.a);
    if (localObject2 != null)
    {
      Object localObject3 = ((TAVCutImageView)localObject1).getParent();
      if ((localObject3 instanceof ViewGroup))
      {
        localObject3 = (ViewGroup)localObject3;
        int i = ((ViewGroup)localObject3).getWidth() - ((ViewGroup)localObject3).getPaddingLeft() - ((ViewGroup)localObject3).getPaddingRight();
        int j = ((ViewGroup)localObject3).getHeight() - ((ViewGroup)localObject3).getPaddingTop() - ((ViewGroup)localObject3).getPaddingBottom();
        int k = ((Bitmap)localObject2).getWidth();
        int m = ((Bitmap)localObject2).getHeight();
        localObject2 = (FrameLayout.LayoutParams)((TAVCutImageView)localObject1).getStickerContainer().getLayoutParams();
        float f1 = k;
        float f2 = m;
        float f3 = f1 * 1.0F / f2;
        float f4 = i * 1.0F;
        float f5 = j;
        if (f3 > f4 / f5)
        {
          ((FrameLayout.LayoutParams)localObject2).width = i;
          i = (int)(f4 * f2 / f1);
          ((FrameLayout.LayoutParams)localObject2).height = i;
          ((FrameLayout.LayoutParams)localObject2).topMargin = ((j - i) / 2);
          ((FrameLayout.LayoutParams)localObject2).leftMargin = 0;
        }
        else
        {
          ((FrameLayout.LayoutParams)localObject2).height = j;
          j = (int)(f5 * 1.0F * f1 / f2);
          ((FrameLayout.LayoutParams)localObject2).width = j;
          ((FrameLayout.LayoutParams)localObject2).leftMargin = ((i - j) / 2);
          ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
        }
        ((TAVCutImageView)localObject1).getStickerContainer().setLayoutParams((ViewGroup.LayoutParams)localObject2);
        TAVCutImageSession.access$1500(this.this$0, ((TAVCutImageView)localObject1).getStickerContainer(), this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.28
 * JD-Core Version:    0.7.0.1
 */