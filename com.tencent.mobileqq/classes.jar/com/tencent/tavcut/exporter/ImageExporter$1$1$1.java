package com.tencent.tavcut.exporter;

import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.support.annotation.Nullable;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.tavcut.util.Logger;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.image.WSImageRender;
import com.tencent.weseevideo.composition.image.WSImageRender.ImageRenderCallback;
import com.tencent.weseevideo.editor.sticker.StickerController;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class ImageExporter$1$1$1
  implements WSImageRender.ImageRenderCallback
{
  ImageExporter$1$1$1(ImageExporter.1.1 param1, VideoRenderChainManager paramVideoRenderChainManager, WSImageRender paramWSImageRender) {}
  
  public void onCompletion(@Nullable Bitmap paramBitmap)
  {
    DurationUtil.end("imageRender.render");
    int k = 0;
    int i;
    if (!BitmapUtil.isValidBitmap(paramBitmap))
    {
      this.this$2.val$errorMsgs.add("image render result is an invalid bitmap! output path = " + this.this$2.val$outputPath);
      i = k;
      if ((i != 0) && (this.this$2.this$1.val$callback != null)) {
        this.this$2.this$1.val$callback.onImageExport(this.this$2.val$outputPath);
      }
      if (this.this$2.val$resultCount.incrementAndGet() == ImageExporter.access$000(this.this$2.this$1.this$0).size()) {
        if (this.this$2.this$1.val$callback != null)
        {
          if (!this.this$2.val$errorMsgs.isEmpty()) {
            break label441;
          }
          this.this$2.this$1.val$callback.onExportComplete();
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.this$2.this$1.val$executorService.shutdown();
        this.val$videoRenderChainManager.release();
        this.this$2.val$stickerController.destroy();
        this.val$imageRender.release();
        return;
        if (ImageExporter.access$200(this.this$2.this$1.this$0) != null) {}
        Bitmap localBitmap2;
        for (int j = ImageExporter.access$200(this.this$2.this$1.this$0).getMaxExportSize();; j = -1)
        {
          i = k;
          if (j == -1) {
            break;
          }
          DurationUtil.start("scaleBitmap");
          localBitmap2 = BitmapUtil.scaleBitmap(paramBitmap, j);
          DurationUtil.end("scaleBitmap");
          if (BitmapUtil.isValidBitmap(localBitmap2)) {
            break label318;
          }
          this.this$2.val$errorMsgs.add("scale bitmap failed! output path = " + this.this$2.val$outputPath);
          i = k;
          break;
        }
        label318:
        Bitmap localBitmap1 = paramBitmap;
        if (localBitmap2 != paramBitmap) {
          localBitmap1 = localBitmap2;
        }
        try
        {
          DurationUtil.start("saveBitmap");
          if (!BitmapUtil.saveBitmap(localBitmap1, ImageExporter.access$200(this.this$2.this$1.this$0).getQuality(), this.this$2.val$outputPath, new ExifInterface(this.this$2.val$sourcePath)))
          {
            this.this$2.val$errorMsgs.add("image save failed! output path = " + this.this$2.val$outputPath);
            i = k;
          }
        }
        catch (IOException paramBitmap)
        {
          Logger.e(paramBitmap);
        }
      }
      for (;;)
      {
        i = 1;
        break;
        DurationUtil.end("saveBitmap");
      }
      label441:
      this.this$2.this$1.val$callback.onFailed(this.this$2.val$errorMsgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.exporter.ImageExporter.1.1.1
 * JD-Core Version:    0.7.0.1
 */