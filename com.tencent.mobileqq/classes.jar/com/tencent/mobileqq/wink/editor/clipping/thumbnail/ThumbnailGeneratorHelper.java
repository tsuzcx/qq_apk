package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import com.tencent.logger.Logger;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.creator.IClipSourceCreator;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.render.thumb.IThumbProvider;
import com.tencent.videocut.utils.VideoUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IThumbnailGenerator;", "generatorSupplier", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorSupplier;", "model", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbAssetModel;", "(Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorSupplier;Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbAssetModel;)V", "clipSource", "Lcom/tencent/tavcut/model/ClipSource;", "runnable", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ImageRunnable;", "size", "Lcom/tencent/tavcut/composition/model/component/Size;", "thumbProvider", "Lcom/tencent/tavcut/render/thumb/IThumbProvider;", "videoThumbTaskQueue", "Ljava/util/concurrent/BlockingQueue;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ImageThumbTask;", "calculateRenderSize", "", "generateThumbnailByTime", "timeUs", "", "initThumbGenerator", "pause", "release", "releaseQueue", "releaseThumbGenerator", "resume", "startGenerate", "Companion", "ImageRunnable", "ImageThumbTask", "ReleaseRunnable", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbnailGeneratorHelper
  implements IThumbnailGenerator
{
  public static final ThumbnailGeneratorHelper.Companion a = new ThumbnailGeneratorHelper.Companion(null);
  private volatile ThumbnailGeneratorHelper.ImageRunnable b;
  private final ClipSource c;
  private IThumbProvider d;
  private Size e;
  private final BlockingQueue<ThumbnailGeneratorHelper.ImageThumbTask> f;
  private final ThumbnailGeneratorSupplier g;
  
  public ThumbnailGeneratorHelper(@NotNull ThumbnailGeneratorSupplier paramThumbnailGeneratorSupplier, @NotNull ThumbAssetModel paramThumbAssetModel)
  {
    this.g = paramThumbnailGeneratorSupplier;
    paramThumbnailGeneratorSupplier = Integer.valueOf(0);
    this.e = new Size(paramThumbnailGeneratorSupplier, paramThumbnailGeneratorSupplier, null, 4, null);
    this.f = ((BlockingQueue)new PriorityBlockingQueue());
    if (paramThumbAssetModel.b() != 1) {
      paramThumbnailGeneratorSupplier = TavCut.a.c().a(paramThumbAssetModel.a(), new TimeRange(0L, paramThumbAssetModel.c(), null, 4, null));
    } else {
      paramThumbnailGeneratorSupplier = TavCut.a.c().b(paramThumbAssetModel.a(), new TimeRange(0L, paramThumbAssetModel.c(), null, 4, null));
    }
    this.c = paramThumbnailGeneratorSupplier;
  }
  
  private final void b()
  {
    Logger.a.a("VideoThumbImageGenerator", "releaseQueue:");
    this.f.clear();
  }
  
  private final void c()
  {
    if (this.b != null)
    {
      Logger.a.a("VideoThumbImageGenerator", "mRunnable is run");
      return;
    }
    this.b = new ThumbnailGeneratorHelper.ImageRunnable(this);
    this.g.d().a((Runnable)this.b);
  }
  
  private final void d()
  {
    if (this.d == null)
    {
      ClipSource localClipSource = this.c;
      f();
      this.d = TavCut.a.a(localClipSource, this.e);
    }
  }
  
  private final void e()
  {
    IThumbProvider localIThumbProvider = this.d;
    if (localIThumbProvider != null) {
      localIThumbProvider.a();
    }
    this.d = ((IThumbProvider)null);
  }
  
  private final void f()
  {
    Object localObject = this.e.height;
    if (localObject == null) {
      return;
    }
    if (((Integer)localObject).intValue() == 0)
    {
      localObject = this.e.width;
      if (localObject == null) {
        return;
      }
      if (((Integer)localObject).intValue() == 0)
      {
        Size localSize = new Size(Integer.valueOf(this.g.b()), Integer.valueOf(this.g.c()), null, 4, null);
        localObject = VideoUtils.a.a(this.c.path);
        int i = ((Number)((Pair)localObject).component1()).intValue();
        int j = ((Number)((Pair)localObject).component2()).intValue();
        localObject = localSize;
        if (i != 0) {
          if (j == 0)
          {
            localObject = localSize;
          }
          else
          {
            float f1 = i / j;
            float f2;
            if (f1 > 1)
            {
              f2 = this.g.b();
              localObject = TuplesKt.to(Float.valueOf(f2), Float.valueOf(f2 * f1));
            }
            else
            {
              f2 = this.g.b();
              localObject = TuplesKt.to(Float.valueOf(f2 / f1), Float.valueOf(f2));
            }
            f1 = ((Number)((Pair)localObject).component1()).floatValue();
            localObject = new Size(Integer.valueOf((int)((Number)((Pair)localObject).component2()).floatValue()), Integer.valueOf((int)f1), null, 4, null);
          }
        }
        this.e = ((Size)localObject);
      }
    }
  }
  
  public void a()
  {
    if (this.b != null)
    {
      ThumbnailGeneratorHelper.ImageRunnable localImageRunnable = this.b;
      if (localImageRunnable != null) {
        localImageRunnable.a(true);
      }
      return;
    }
    b();
    this.g.d().a((Runnable)new ThumbnailGeneratorHelper.ReleaseRunnable(this));
  }
  
  public void a(long paramLong)
  {
    Object localObject = Logger.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("generateCoverByTime:");
    localStringBuilder.append(paramLong);
    ((Logger)localObject).a("VideoThumbImageGenerator", localStringBuilder.toString());
    localObject = new ThumbnailGeneratorHelper.ImageThumbTask(System.currentTimeMillis(), paramLong);
    try
    {
      this.f.put(localObject);
    }
    catch (InterruptedException localInterruptedException)
    {
      Logger.a.a("VideoThumbImageGenerator", (Throwable)localInterruptedException);
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailGeneratorHelper
 * JD-Core Version:    0.7.0.1
 */