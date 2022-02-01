package com.tencent.qcircle.tavcut.exporter;

import android.opengl.EGLContext;
import com.google.gson.Gson;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderFactory;
import com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator.ImageGeneratorThread;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.RenderContext;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class ImageExporter$1
  implements Runnable
{
  ImageExporter$1(ImageExporter paramImageExporter, ImageExporter.ImageExportCallback paramImageExportCallback, ExecutorService paramExecutorService, AEFilterManager paramAEFilterManager, EGLContext paramEGLContext, AssetImageGenerator.ImageGeneratorThread paramImageGeneratorThread, RenderContext paramRenderContext) {}
  
  public void run()
  {
    1 local1 = this;
    Object localObject2 = new AtomicInteger(0);
    Object localObject1 = new LinkedBlockingDeque();
    long l = System.currentTimeMillis();
    int i = 0;
    while (i < ImageExporter.access$000(local1.this$0).size())
    {
      if (ImageExporter.access$100(local1.this$0))
      {
        localObject1 = local1.val$callback;
        if (localObject1 != null) {
          ((ImageExporter.ImageExportCallback)localObject1).onCancelled();
        }
        local1.val$executorService.shutdown();
        return;
      }
      MediaModel localMediaModel = (MediaModel)new Gson().fromJson(((MediaModel)ImageExporter.access$000(local1.this$0).get(i)).toString(), MediaModel.class);
      Object localObject4;
      Object localObject3;
      if (((String)ImageExporter.access$200(local1.this$0).get(i)).equals(Util.md5(((MediaModel)ImageExporter.access$000(local1.this$0).get(i)).toString())))
      {
        if (local1.val$callback != null)
        {
          localObject4 = ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getPath();
          localObject3 = localObject4;
          if (ImageExporter.access$300(local1.this$0, (String)localObject4)) {
            localObject3 = ImageExporter.access$400(local1.this$0, (LinkedBlockingDeque)localObject1, i, localMediaModel, (String)localObject4);
          }
          local1.val$callback.onImageExport((String)localObject3);
        }
        if (((AtomicInteger)localObject2).incrementAndGet() == ImageExporter.access$000(local1.this$0).size())
        {
          localObject2 = ImageExporter.access$500(local1.this$0);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("cost time: =========== ");
          ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
          Logger.d((String)localObject2, ((StringBuilder)localObject3).toString());
          if (local1.val$callback != null) {
            if (((LinkedBlockingDeque)localObject1).isEmpty()) {
              local1.val$callback.onExportComplete();
            } else {
              local1.val$callback.onFailed((Collection)localObject1);
            }
          }
          local1.val$executorService.shutdown();
          return;
        }
      }
      else
      {
        localObject3 = new VideoRenderChainConfigure(true);
        localObject4 = localMediaModel.getMediaTemplateModel();
        if (!((MediaTemplateModel)localObject4).isAutoTemplateEmpty())
        {
          ((VideoRenderChainConfigure)localObject3).setSceneType(2);
          localMediaModel.getMediaEffectModel().putParam("FRAME_PARAMS_KEY_IS_ON", "1");
        }
        else if (!((MediaTemplateModel)localObject4).isMovieTemplateEmpty())
        {
          ((VideoRenderChainConfigure)localObject3).setSceneType(1);
        }
        else
        {
          ((VideoRenderChainConfigure)localObject3).setSceneType(0);
        }
        ((VideoRenderChainConfigure)localObject3).setImageMode(true);
        localObject4 = ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getPath();
        Object localObject5 = BitmapUtil.getImageSize((String)localObject4, false);
        int j;
        if (ImageExporter.access$600(local1.this$0) != null) {
          j = ImageExporter.access$600(local1.this$0).getMaxExportSize();
        } else {
          j = -1;
        }
        if (j != -1)
        {
          localObject6 = Util.constrainMaxSize((Size)localObject5, j);
          int k = ((Size)localObject5).getWidth() / ((Size)localObject6).getWidth();
          if (((Size)localObject5).getWidth() % ((Size)localObject6).getWidth() == 0) {
            j = 0;
          } else {
            j = 1;
          }
          k = j + k;
          j = k;
          if (k <= 0) {
            j = 1;
          }
          ((Size)localObject5).setWidth(((Size)localObject5).getWidth() / j);
          ((Size)localObject5).setHeight(((Size)localObject5).getHeight() / j);
        }
        ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().setWidth(((Size)localObject5).getWidth());
        ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().setHeight(((Size)localObject5).getHeight());
        localObject5 = ImageExporter.access$700(local1.this$0, localMediaModel, (String)localObject4);
        ((VideoRenderChainConfigure)localObject3).setRenderSize((CGSize)localObject5);
        ((VideoRenderChainConfigure)localObject3).setScreenSize(ImageExporter.access$600(local1.this$0).getScreenSize());
        Object localObject6 = (String)ImageExporter.access$600(local1.this$0).getOutputPaths().get(i);
        StickerController localStickerController = new StickerController(ImageExporter.access$800(local1.this$0));
        ImageExporter.access$902(local1.this$0, new CountDownLatch(1));
        MediaBuilderFactory.mediaBuilderSync(localMediaModel, ImageExporter.access$800(local1.this$0), localStickerController, (VideoRenderChainConfigure)localObject3, new ImageExporter.1.1(this, localStickerController, localMediaModel, (CGSize)localObject5, (LinkedBlockingDeque)localObject1, (String)localObject6, (String)localObject4, (AtomicInteger)localObject2, l));
        local1 = this;
        try
        {
          ImageExporter.access$900(local1.this$0).await();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.ImageExporter.1
 * JD-Core Version:    0.7.0.1
 */