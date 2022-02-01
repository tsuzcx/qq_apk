package com.tencent.tavcut.exporter;

import com.google.gson.Gson;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.Util;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.builder.MediaBuilderFactory;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class ImageExporter$1
  implements Runnable
{
  ImageExporter$1(ImageExporter paramImageExporter, ImageExporter.ImageExportCallback paramImageExportCallback, ExecutorService paramExecutorService) {}
  
  public void run()
  {
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    LinkedBlockingDeque localLinkedBlockingDeque = new LinkedBlockingDeque();
    long l = System.currentTimeMillis();
    int i = 0;
    for (;;)
    {
      if (i < ImageExporter.access$000(this.this$0).size())
      {
        if (ImageExporter.access$100(this.this$0))
        {
          if (this.val$callback != null) {
            this.val$callback.onCancelled();
          }
          this.val$executorService.shutdown();
        }
      }
      else {
        return;
      }
      MediaModel localMediaModel = (MediaModel)new Gson().fromJson(((MediaModel)ImageExporter.access$000(this.this$0).get(i)).toString(), MediaModel.class);
      VideoRenderChainConfigure localVideoRenderChainConfigure = new VideoRenderChainConfigure(true);
      Object localObject1 = localMediaModel.getMediaTemplateModel();
      label145:
      int j;
      if (!((MediaTemplateModel)localObject1).isAutoTemplateEmpty())
      {
        localVideoRenderChainConfigure.setSceneType(2);
        localObject1 = ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getPath();
        Object localObject2 = BitmapUtil.getImageSize((String)localObject1, false);
        if (ImageExporter.access$200(this.this$0) == null) {
          break label481;
        }
        j = ImageExporter.access$200(this.this$0).getMaxExportSize();
        label199:
        if (j != -1)
        {
          localObject3 = Util.constrainMaxSize((Size)localObject2, j);
          int k = ((Size)localObject2).getWidth() / ((Size)localObject3).getWidth();
          if (((Size)localObject2).getWidth() % ((Size)localObject3).getWidth() != 0) {
            break label486;
          }
          j = 0;
          k = j + k;
          j = k;
          if (k <= 0) {
            j = 1;
          }
          ((Size)localObject2).setWidth(((Size)localObject2).getWidth() / j);
          ((Size)localObject2).setHeight(((Size)localObject2).getHeight() / j);
        }
        ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().setWidth(((Size)localObject2).getWidth());
        ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().setHeight(((Size)localObject2).getHeight());
        localObject2 = ImageExporter.access$300(this.this$0, localMediaModel, (String)localObject1);
        localVideoRenderChainConfigure.setRenderSize((CGSize)localObject2);
        Object localObject3 = (String)ImageExporter.access$200(this.this$0).getOutputPaths().get(i);
        StickerController localStickerController = new StickerController(ImageExporter.access$400(this.this$0));
        ImageExporter.access$502(this.this$0, new CountDownLatch(1));
        MediaBuilderFactory.mediaBuilderAsync(localMediaModel, localStickerController, localVideoRenderChainConfigure, new ImageExporter.1.1(this, localStickerController, localMediaModel, (CGSize)localObject2, localLinkedBlockingDeque, (String)localObject3, (String)localObject1, localAtomicInteger, l));
      }
      try
      {
        ImageExporter.access$500(this.this$0).await();
        i += 1;
        continue;
        if (!((MediaTemplateModel)localObject1).isMovieTemplateEmpty())
        {
          localVideoRenderChainConfigure.setSceneType(1);
          break label145;
        }
        localVideoRenderChainConfigure.setSceneType(0);
        break label145;
        label481:
        j = -1;
        break label199;
        label486:
        j = 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.exporter.ImageExporter.1
 * JD-Core Version:    0.7.0.1
 */