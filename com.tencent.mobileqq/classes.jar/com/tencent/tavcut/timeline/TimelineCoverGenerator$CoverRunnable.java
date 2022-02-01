package com.tencent.tavcut.timeline;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.cover.CoverCache;
import com.tencent.tavcut.util.FloatUtils;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class TimelineCoverGenerator$CoverRunnable
  implements Runnable
{
  public TimelineCoverGenerator$CoverRunnable(TimelineCoverGenerator paramTimelineCoverGenerator) {}
  
  public void run()
  {
    while ((this.this$0.mCoverTaskQueue != null) && (!this.this$0.mCoverTaskQueue.isEmpty()) && (this.this$0.mImageGenerator != null) && (!this.this$0.mReleased))
    {
      TimelineCoverGenerator.CoverTask localCoverTask1;
      try
      {
        localCoverTask1 = (TimelineCoverGenerator.CoverTask)this.this$0.mCoverTaskQueue.take();
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("run: index is ");
          localStringBuilder.append(TimelineCoverGenerator.CoverTask.access$000(localCoverTask1));
          Logger.d("TimelineCoverGenerator", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("run: requestTimeMs is ");
          localStringBuilder.append(TimelineCoverGenerator.CoverTask.access$200(localCoverTask1));
          Logger.d("TimelineCoverGenerator", localStringBuilder.toString());
          localCoverTask2 = localCoverTask1;
        }
        catch (InterruptedException localInterruptedException2) {}
        Logger.d("TimelineCoverGenerator", "run:  CoverTaskQueue.take() InterruptedException");
      }
      catch (InterruptedException localInterruptedException3)
      {
        localCoverTask1 = null;
      }
      localInterruptedException3.printStackTrace();
      TimelineCoverGenerator.CoverTask localCoverTask2 = localCoverTask1;
      if (localCoverTask2 != null)
      {
        TimelineCoverGenerator.CoverTask.access$102(localCoverTask2, true);
        Object localObject2;
        try
        {
          if (this.this$0.mImageGenerator != null)
          {
            Logger.d("TimelineCoverGenerator", "run: start generateThumbnailAtTimeSync");
            localObject2 = this.this$0.mImageGenerator.generateThumbnailAtTimeSync(new CMTime((float)TimelineCoverGenerator.CoverTask.access$300(localCoverTask2) / 1000.0F));
            try
            {
              Logger.d("TimelineCoverGenerator", "run: end generateThumbnailAtTimeSync");
            }
            catch (Exception localException1)
            {
              break label254;
            }
          }
          else
          {
            localObject2 = null;
          }
        }
        catch (Exception localException2)
        {
          localObject2 = null;
          label254:
          Logger.d("TimelineCoverGenerator", "run: generateThumbnailAtTimeSync Exception");
          localException2.printStackTrace();
        }
        Object localObject1;
        Bitmap localBitmap;
        if (localObject2 != null)
        {
          int i = ((Bitmap)localObject2).getWidth();
          int k = ((Bitmap)localObject2).getHeight();
          localObject1 = new Matrix();
          ((Matrix)localObject1).postScale(0.25F, 0.25F);
          int j = (int)((i - this.this$0.mCoverWidth * 4.0F) / 2.0F);
          int m = (int)((k - this.this$0.mCoverHeight * 4.0F) / 2.0F);
          int i1 = (int)(this.this$0.mCoverWidth * 4.0F);
          int n = (int)(this.this$0.mCoverHeight * 4.0F);
          if (j <= 0) {
            j = 0;
          } else {
            i = i1;
          }
          if (m <= 0) {
            m = 0;
          } else {
            k = n;
          }
          localBitmap = Bitmap.createBitmap((Bitmap)localObject2, j, m, i, k, (Matrix)localObject1, false);
          localObject1 = localBitmap;
          if (!((Bitmap)localObject2).isRecycled())
          {
            ((Bitmap)localObject2).recycle();
            localObject1 = localBitmap;
          }
        }
        else
        {
          localObject1 = null;
        }
        if (localObject1 != null)
        {
          if ((TimelineCoverGenerator.CoverTask.access$000(localCoverTask2) == this.this$0.mItemCount - 1) && (!FloatUtils.isEquals(this.this$0.mLastCoverWidth, this.this$0.mCoverWidth)))
          {
            localBitmap = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, (int)(this.this$0.mLastCoverWidth * 1.0F / this.this$0.mCoverWidth * ((Bitmap)localObject1).getWidth()), ((Bitmap)localObject1).getHeight());
            localObject2 = localBitmap;
            if (!((Bitmap)localObject1).isRecycled())
            {
              ((Bitmap)localObject1).recycle();
              localObject2 = localBitmap;
            }
          }
          else
          {
            localObject2 = localObject1;
          }
          if (this.this$0.mCoverCache != null) {
            this.this$0.mCoverCache.addCover(TimelineCoverGenerator.CoverTask.access$000(localCoverTask2), (Bitmap)localObject2);
          }
          if (this.this$0.mCoverTaskMap != null) {
            this.this$0.mCoverTaskMap.remove(Long.valueOf(TimelineCoverGenerator.CoverTask.access$300(localCoverTask2)));
          }
          if ((this.this$0.mCoverCache != null) && (this.this$0.mCoverCache.getCacheSize() == this.this$0.mItemCount))
          {
            this.this$0.mImageGenerator.getAssetImageGenerator().release();
            this.this$0.mImageGenerator = null;
          }
        }
        else
        {
          try
          {
            this.this$0.mCoverTaskQueue.put(localCoverTask2);
          }
          catch (InterruptedException localInterruptedException1)
          {
            localInterruptedException1.printStackTrace();
          }
        }
      }
    }
    if ((this.this$0.mCoverTaskMap != null) && (this.this$0.mCoverTaskMap.isEmpty()))
    {
      TimelineCoverGenerator.access$400(this.this$0);
      TimelineCoverGenerator.access$500(this.this$0);
    }
    if (this.this$0.mReleased) {
      TimelineCoverGenerator.access$600(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineCoverGenerator.CoverRunnable
 * JD-Core Version:    0.7.0.1
 */