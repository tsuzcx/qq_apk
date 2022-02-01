package com.tencent.qcircle.tavcut.session;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.util.SparseArray;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.view.TAVCutImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class TAVCutImageSession$35
  implements Runnable
{
  TAVCutImageSession$35(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    if (TAVCutImageSession.access$400(this.this$0).get(this.val$index) == null) {
      return;
    }
    if (TAVCutImageSession.access$1400(this.this$0).get(this.val$index) == null)
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)TAVCutImageSession.access$200(this.this$0).get(this.val$index), (BitmapFactory.Options)localObject);
      int i = Math.max(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight);
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_4444;
      if (i > 1024) {
        ((BitmapFactory.Options)localObject).inSampleSize = (i / 1024 + 1);
      }
      Bitmap localBitmap1 = BitmapFactory.decodeFile((String)TAVCutImageSession.access$200(this.this$0).get(this.val$index), (BitmapFactory.Options)localObject);
      i = BitmapUtil.getImageRotation((String)TAVCutImageSession.access$200(this.this$0).get(this.val$index));
      localObject = localBitmap1;
      if (i != 0)
      {
        localObject = new Matrix();
        ((Matrix)localObject).setRotate(i);
        Bitmap localBitmap2 = BitmapUtil.retryMatrixBitmap(localBitmap1, localBitmap1.getWidth(), localBitmap1.getHeight(), (Matrix)localObject, false);
        localObject = localBitmap1;
        if (localBitmap2 != localBitmap1)
        {
          localObject = localBitmap1;
          if (localBitmap2 != null) {
            localObject = localBitmap2;
          }
        }
      }
      TAVCutImageSession.access$1400(this.this$0).put(this.val$index, localObject);
      TAVCutImageSession.access$1800(this.this$0).put(this.val$index, new ArrayList());
    }
    ((TAVCutImageView)((WeakReference)TAVCutImageSession.access$400(this.this$0).get(this.val$index)).get()).setImageBitmap((Bitmap)TAVCutImageSession.access$1400(this.this$0).get(this.val$index), (List)TAVCutImageSession.access$1800(this.this$0).get(this.val$index));
    this.this$0.resizeUI(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.35
 * JD-Core Version:    0.7.0.1
 */