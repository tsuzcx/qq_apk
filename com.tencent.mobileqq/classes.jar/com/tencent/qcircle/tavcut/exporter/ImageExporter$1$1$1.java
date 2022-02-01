package com.tencent.qcircle.tavcut.exporter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.media.ExifInterface;
import android.support.annotation.Nullable;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.image.WSImageRender;
import com.tencent.qcircle.weseevideo.composition.image.WSImageRender.ImageRenderCallback;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import java.io.IOException;
import java.util.List;
import java.util.List<Landroid.graphics.PointF;>;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class ImageExporter$1$1$1
  implements WSImageRender.ImageRenderCallback
{
  ImageExporter$1$1$1(ImageExporter.1.1 param1, VideoRenderChainManager paramVideoRenderChainManager, WSImageRender paramWSImageRender) {}
  
  public void onCompletion(@Nullable Bitmap paramBitmap, @Nullable List<PointF> paramList)
  {
    DurationUtil.start("imageRender.inRender");
    if (!BitmapUtil.isValidBitmap(paramBitmap))
    {
      paramBitmap = this.this$2.val$errorMsgs;
      paramList = new StringBuilder();
      paramList.append("image render result is an invalid bitmap! output path = ");
      paramList.append(this.this$2.val$outputPath);
      paramBitmap.add(paramList.toString());
    }
    else
    {
      if (ImageExporter.access$600(this.this$2.this$1.this$0) != null) {
        i = ImageExporter.access$600(this.this$2.this$1.this$0).getMaxExportSize();
      } else {
        i = -1;
      }
      if (i != -1)
      {
        DurationUtil.start("scaleBitmap");
        Object localObject = BitmapUtil.scaleBitmap(paramBitmap, i);
        DurationUtil.end("scaleBitmap");
        if (!BitmapUtil.isValidBitmap((Bitmap)localObject))
        {
          paramBitmap = this.this$2.val$errorMsgs;
          paramList = new StringBuilder();
          paramList.append("scale bitmap failed! output path = ");
          paramList.append(this.this$2.val$outputPath);
          paramBitmap.add(paramList.toString());
        }
        else
        {
          paramList = paramBitmap;
          if (localObject != paramBitmap) {
            paramList = (List<PointF>)localObject;
          }
          try
          {
            DurationUtil.start("saveBitmap");
            if (!BitmapUtil.saveBitmap(paramList, ImageExporter.access$600(this.this$2.this$1.this$0).getFormat(), ImageExporter.access$600(this.this$2.this$1.this$0).getQuality(), this.this$2.val$outputPath, new ExifInterface(this.this$2.val$sourcePath)))
            {
              paramBitmap = this.this$2.val$errorMsgs;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("image save failed! output path = ");
              ((StringBuilder)localObject).append(this.this$2.val$outputPath);
              paramBitmap.add(((StringBuilder)localObject).toString());
              paramList.recycle();
              break label327;
            }
            DurationUtil.end("saveBitmap");
          }
          catch (IOException paramBitmap)
          {
            Logger.e(paramBitmap);
          }
          paramList.recycle();
          i = 1;
          break label329;
        }
      }
    }
    label327:
    int i = 0;
    label329:
    if ((i != 0) && (this.this$2.this$1.val$callback != null)) {
      this.this$2.this$1.val$callback.onImageExport(this.this$2.val$outputPath);
    }
    if (this.this$2.val$resultCount.incrementAndGet() == ImageExporter.access$000(this.this$2.this$1.this$0).size())
    {
      paramBitmap = ImageExporter.access$500(this.this$2.this$1.this$0);
      paramList = new StringBuilder();
      paramList.append("cost time: =========== ");
      paramList.append(System.currentTimeMillis() - this.this$2.val$beginTime);
      Logger.d(paramBitmap, paramList.toString());
      if (this.this$2.this$1.val$callback != null) {
        if (this.this$2.val$errorMsgs.isEmpty()) {
          this.this$2.this$1.val$callback.onExportComplete();
        } else {
          this.this$2.this$1.val$callback.onFailed(this.this$2.val$errorMsgs);
        }
      }
      this.this$2.this$1.val$executorService.shutdown();
    }
    this.val$videoRenderChainManager.release();
    this.this$2.val$stickerController.destroy();
    this.val$imageRender.release();
    ImageExporter.access$900(this.this$2.this$1.this$0).countDown();
    DurationUtil.end("imageRender.inRender");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.ImageExporter.1.1.1
 * JD-Core Version:    0.7.0.1
 */