package com.tencent.tavcut.session;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.tavcut.view.TAVCutImageView;
import com.tencent.weseevideo.composition.image.WSImageRender.ImageRenderCallback;
import java.lang.ref.WeakReference;

class TAVCutImageSession$17$1
  implements WSImageRender.ImageRenderCallback
{
  TAVCutImageSession$17$1(TAVCutImageSession.17 param17) {}
  
  public void onCompletion(@Nullable Bitmap paramBitmap)
  {
    Object localObject = (WeakReference)TAVCutImageSession.access$200(this.this$1.this$0).get(this.this$1.val$index);
    if (localObject != null)
    {
      localObject = (TAVCutImageView)((WeakReference)localObject).get();
      if (localObject != null) {
        ((TAVCutImageView)localObject).setImageBitmap(paramBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.17.1
 * JD-Core Version:    0.7.0.1
 */