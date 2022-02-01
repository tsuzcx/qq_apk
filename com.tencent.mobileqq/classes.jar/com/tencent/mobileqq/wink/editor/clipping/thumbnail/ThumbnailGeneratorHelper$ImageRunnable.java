package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import com.tencent.logger.Logger;
import com.tencent.tavcut.render.thumb.IThumbProvider;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ImageRunnable;", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper;)V", "isPause", "", "isRelease", "isTimeOut", "retryCount", "", "checkLoop", "obtainTask", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ImageThumbTask;", "run", "", "runnableFinish", "setPause", "pause", "setRelease", "release", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
final class ThumbnailGeneratorHelper$ImageRunnable
  implements Runnable
{
  private int a;
  private boolean b;
  private boolean c;
  private boolean d;
  
  private final ThumbnailGeneratorHelper.ImageThumbTask a()
  {
    Long localLong = null;
    Object localObject2 = (ThumbnailGeneratorHelper.ImageThumbTask)null;
    Object localObject1;
    try
    {
      localObject1 = (ThumbnailGeneratorHelper.ImageThumbTask)ThumbnailGeneratorHelper.e(this.this$0).poll(2000L, TimeUnit.MILLISECONDS);
      try
      {
        localObject2 = Logger.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("run: startTime is ");
        if (localObject1 != null) {
          localLong = Long.valueOf(((ThumbnailGeneratorHelper.ImageThumbTask)localObject1).a());
        }
        localStringBuilder.append(localLong);
        ((Logger)localObject2).a("VideoThumbImageGenerator", localStringBuilder.toString());
        return localObject1;
      }
      catch (InterruptedException localInterruptedException1) {}
      Logger.a.a("VideoThumbImageGenerator", (Throwable)localInterruptedException2);
    }
    catch (InterruptedException localInterruptedException2)
    {
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private final void b()
  {
    ThumbnailGeneratorHelper.a(this.this$0, (ImageRunnable)null);
    ThumbnailGeneratorHelper.a(this.this$0);
    if ((!this.c) && (!this.d)) {
      return;
    }
    ThumbnailGeneratorHelper.f(this.this$0);
  }
  
  private final boolean c()
  {
    return (!this.b) && (!this.c) && (!ThumbnailGeneratorHelper.e(this.this$0).isEmpty());
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void run()
  {
    ThumbnailGeneratorHelper.b(this.this$0);
    while (c())
    {
      ThumbnailGeneratorHelper.ImageThumbTask localImageThumbTask = a();
      if (localImageThumbTask == null)
      {
        this.d = true;
        break;
      }
      Object localObject = ThumbnailGeneratorHelper.c(this.this$0);
      if (localObject != null) {
        localObject = ((IThumbProvider)localObject).a(localImageThumbTask.a());
      } else {
        localObject = null;
      }
      if (localObject != null) {
        ThumbnailGeneratorHelper.d(this.this$0).a().a(null, localImageThumbTask.a(), (Bitmap)localObject);
      } else {
        try
        {
          if (this.a <= 3)
          {
            this.a += 1;
            localObject = Logger.a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("run: retry is ");
            localStringBuilder.append(this.a);
            ((Logger)localObject).a("VideoThumbImageGenerator", localStringBuilder.toString());
            ThumbnailGeneratorHelper.e(this.this$0).put(localImageThumbTask);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          Logger.a.a("VideoThumbImageGenerator", (Throwable)localInterruptedException);
        }
      }
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailGeneratorHelper.ImageRunnable
 * JD-Core Version:    0.7.0.1
 */