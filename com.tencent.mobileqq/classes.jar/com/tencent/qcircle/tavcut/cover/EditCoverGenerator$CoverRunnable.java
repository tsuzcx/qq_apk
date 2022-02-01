package com.tencent.qcircle.tavcut.cover;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

class EditCoverGenerator$CoverRunnable
  implements Runnable
{
  private EditCoverGenerator$CoverRunnable(EditCoverGenerator paramEditCoverGenerator) {}
  
  public void run()
  {
    int j;
    label262:
    int i;
    for (;;)
    {
      Object localObject1 = EditCoverGenerator.access$400(this.this$0);
      j = 1;
      if ((localObject1 == null) || (EditCoverGenerator.access$400(this.this$0).isEmpty()) || (EditCoverGenerator.access$500(this.this$0) == null) || (EditCoverGenerator.access$600(this.this$0)) || (EditCoverGenerator.access$700(this.this$0))) {
        break;
      }
      Bitmap localBitmap = null;
      try
      {
        localObject1 = (EditCoverGenerator.CoverTask)EditCoverGenerator.access$400(this.this$0).take();
        try
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("run: index is ");
          ((StringBuilder)localObject2).append(EditCoverGenerator.CoverTask.access$800((EditCoverGenerator.CoverTask)localObject1));
          Logger.d("EditCoverGenerator", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("run: requestTimeMs is ");
          ((StringBuilder)localObject2).append(EditCoverGenerator.CoverTask.access$900((EditCoverGenerator.CoverTask)localObject1));
          Logger.d("EditCoverGenerator", ((StringBuilder)localObject2).toString());
          localObject2 = localObject1;
        }
        catch (InterruptedException localInterruptedException2) {}
        Logger.d("EditCoverGenerator", "run:  CoverTaskQueue.take() InterruptedException");
      }
      catch (InterruptedException localInterruptedException3)
      {
        localObject1 = null;
      }
      localInterruptedException3.printStackTrace();
      Object localObject3 = localObject1;
      if (localObject3 != null)
      {
        EditCoverGenerator.CoverTask.access$102(localObject3, true);
        try
        {
          if (EditCoverGenerator.access$500(this.this$0) != null)
          {
            Logger.d("EditCoverGenerator", "run: start generateThumbnailAtTimeSync");
            localObject1 = EditCoverGenerator.access$500(this.this$0).generateThumbnailAtTimeSync(EditCoverGenerator.CoverTask.access$200(localObject3));
            try
            {
              Logger.d("EditCoverGenerator", "run: end generateThumbnailAtTimeSync");
            }
            catch (Exception localException1)
            {
              break label262;
            }
          }
          else
          {
            localObject1 = null;
          }
        }
        catch (Exception localException2)
        {
          localObject1 = null;
          Logger.d("EditCoverGenerator", "run: generateThumbnailAtTimeSync Exception");
          localException2.printStackTrace();
        }
        Object localObject4 = localBitmap;
        if (localObject1 != null)
        {
          i = ((Bitmap)localObject1).getWidth();
          int k = ((Bitmap)localObject1).getHeight();
          localObject4 = new Matrix();
          ((Matrix)localObject4).postScale(1.0F, 1.0F);
          int i1 = (int)((i - EditCoverGenerator.access$1000(this.this$0) * 1.0F) / 2.0F);
          int m = (int)((k - EditCoverGenerator.access$1100(this.this$0) * 1.0F) / 2.0F);
          j = (int)(EditCoverGenerator.access$1000(this.this$0) * 1.0F);
          int n = (int)(EditCoverGenerator.access$1100(this.this$0) * 1.0F);
          if (i1 <= 0)
          {
            j = i;
            i = 0;
          }
          else
          {
            i = i1;
          }
          if (m <= 0) {
            m = 0;
          } else {
            k = n;
          }
          localBitmap = Bitmap.createBitmap((Bitmap)localObject1, i, m, j, k, (Matrix)localObject4, false);
          localObject4 = localBitmap;
          if (!((Bitmap)localObject1).isRecycled())
          {
            ((Bitmap)localObject1).recycle();
            localObject4 = localBitmap;
          }
        }
        if (localObject4 != null)
        {
          if (EditCoverGenerator.access$1200(this.this$0) != null) {
            EditCoverGenerator.access$1200(this.this$0).addCover(EditCoverGenerator.CoverTask.access$800(localObject3), (Bitmap)localObject4);
          }
          if (EditCoverGenerator.access$300(this.this$0) != null) {
            EditCoverGenerator.access$300(this.this$0).remove(Integer.valueOf(EditCoverGenerator.CoverTask.access$800(localObject3)));
          }
        }
        else
        {
          try
          {
            EditCoverGenerator.access$400(this.this$0).put(localObject3);
          }
          catch (InterruptedException localInterruptedException1)
          {
            localInterruptedException1.printStackTrace();
          }
        }
      }
    }
    if (EditCoverGenerator.access$700(this.this$0))
    {
      EditCoverGenerator.access$1300(this.this$0);
      return;
    }
    if (EditCoverGenerator.access$300(this.this$0) != null)
    {
      i = j;
      if (EditCoverGenerator.access$300(this.this$0).isEmpty()) {}
    }
    else if (EditCoverGenerator.access$600(this.this$0))
    {
      i = j;
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      EditCoverGenerator.access$1400(this.this$0);
      EditCoverGenerator.access$1500(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.cover.EditCoverGenerator.CoverRunnable
 * JD-Core Version:    0.7.0.1
 */