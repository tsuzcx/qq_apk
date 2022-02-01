package com.tencent.tkd.topicsdk.widget.videocrop;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchRunnable;", "Ljava/lang/Runnable;", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;)V", "run", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoFramesRetriever$FrameFetchRunnable
  implements Runnable
{
  public void run()
  {
    if (VideoFramesRetriever.a(this.this$0) == null) {}
    VideoFramesRetriever.FrameFetchTask localFrameFetchTask;
    long l;
    Object localObject4;
    for (;;)
    {
      return;
      try
      {
        while (!VideoFramesRetriever.a(this.this$0))
        {
          Object localObject1 = VideoFramesRetriever.a(this.this$0).take();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "mFramesFetchingQueue.take()");
          localFrameFetchTask = (VideoFramesRetriever.FrameFetchTask)localObject1;
          if (VideoFramesRetriever.a(this.this$0)) {
            break;
          }
          l = System.currentTimeMillis();
          localObject1 = VideoFramesRetriever.a(this.this$0);
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localObject4 = ((MediaMetadataRetriever)localObject1).getFrameAtTime((localFrameFetchTask.b() + localFrameFetchTask.a()) / 2 * 1000L);
          if (localObject4 != null) {
            break label137;
          }
          TLog.b("VideoFramesRetriever", "getThumbnail Failed");
        }
        if (((Bitmap)localObject4).getWidth() <= ((Bitmap)localObject4).getHeight()) {}
      }
      catch (Throwable localThrowable)
      {
        localThrowable = localThrowable;
        TLog.c("VideoFramesRetriever", "FrameFetchRunnable, Exception:", localThrowable);
        return;
      }
      finally {}
    }
    label137:
    for (int i = 1;; i = 0)
    {
      float f;
      label171:
      Object localObject3;
      if (i != 0)
      {
        f = VideoFramesRetriever.a(this.this$0) / ((Bitmap)localObject4).getHeight();
        localObject3 = new Matrix();
        ((Matrix)localObject3).postScale(f, f);
        if (i == 0) {
          break label376;
        }
        localObject3 = Bitmap.createBitmap((Bitmap)localObject4, (((Bitmap)localObject4).getWidth() - ((Bitmap)localObject4).getHeight()) / 2, 0, ((Bitmap)localObject4).getHeight(), ((Bitmap)localObject4).getHeight(), (Matrix)localObject3, true);
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "Bitmap.createBitmap(\n   …                        )");
      }
      for (;;)
      {
        ((Bitmap)localObject4).recycle();
        localObject4 = new FramesProcessor.Frame();
        ((FramesProcessor.Frame)localObject4).a(((Bitmap)localObject3).copy(Bitmap.Config.RGB_565, true));
        ((FramesProcessor.Frame)localObject4).a(localFrameFetchTask.b() / VideoFramesRetriever.b(this.this$0));
        ((Bitmap)localObject3).recycle();
        TLog.a("VideoFramesRetriever", "end get frame bitmap, cost time=" + (System.currentTimeMillis() - l));
        localObject3 = VideoFramesRetriever.a(this.this$0);
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        ((FrameAdapter)localObject3).a((FramesProcessor.Frame)localObject4);
        VideoFramesRetriever.a(this.this$0).remove(Integer.valueOf(localFrameFetchTask.b()));
        break;
        f = VideoFramesRetriever.a(this.this$0) / ((Bitmap)localObject4).getWidth();
        break label171;
        label376:
        localObject3 = Bitmap.createBitmap((Bitmap)localObject4, 0, (((Bitmap)localObject4).getHeight() - ((Bitmap)localObject4).getWidth()) / 2, ((Bitmap)localObject4).getWidth(), ((Bitmap)localObject4).getWidth(), (Matrix)localObject3, true);
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "Bitmap.createBitmap(\n   …                        )");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoFramesRetriever.FrameFetchRunnable
 * JD-Core Version:    0.7.0.1
 */