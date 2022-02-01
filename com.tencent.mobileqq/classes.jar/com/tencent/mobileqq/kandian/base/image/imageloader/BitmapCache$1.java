package com.tencent.mobileqq.kandian.base.image.imageloader;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.base.image.Releaser;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class BitmapCache$1
  implements Releaser<Bitmap>
{
  BitmapCache$1(BitmapCache paramBitmapCache) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    ??? = BitmapCache.TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("recycle:");
    ((StringBuilder)localObject2).append(paramBitmap);
    Utils.a((String)???, ((StringBuilder)localObject2).toString());
    if (!Utils.a())
    {
      paramBitmap.recycle();
      return;
    }
    int i;
    label273:
    synchronized (BitmapCache.access$000(this.a))
    {
      localObject2 = new ArrayList();
      int k = 0;
      i = 0;
      int j = k;
      if (i < BitmapCache.access$000(this.a).size())
      {
        Bitmap localBitmap = (Bitmap)((SoftReference)BitmapCache.access$000(this.a).get(i)).get();
        if (localBitmap != null)
        {
          if (localBitmap != paramBitmap) {
            break label273;
          }
          j = 1;
        }
        else
        {
          ((List)localObject2).add(BitmapCache.access$000(this.a).get(i));
          break label273;
        }
      }
      if (!((List)localObject2).isEmpty()) {
        BitmapCache.access$000(this.a).removeAll((Collection)localObject2);
      }
      if (j == 0)
      {
        paramBitmap = new SoftReference(paramBitmap);
        BitmapCache.access$000(this.a).add(paramBitmap);
        return;
      }
      ??? = BitmapCache.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reuse same bitmap ");
      ((StringBuilder)localObject2).append(paramBitmap);
      QLog.e((String)???, 1, ((StringBuilder)localObject2).toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.imageloader.BitmapCache.1
 * JD-Core Version:    0.7.0.1
 */