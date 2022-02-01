package com.tencent.tavcut.exporter;

import android.content.Context;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.Util;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageExporter
{
  private final String TAG = ImageExporter.class.getSimpleName();
  private boolean cancel = false;
  private Context context;
  private ImageExportConfig imageExportConfig;
  private CountDownLatch mCountDownLatch;
  private List<MediaModel> mediaModels;
  
  private CGSize calculateRenderSize(MediaModel paramMediaModel, String paramString)
  {
    MediaEffectModel localMediaEffectModel = paramMediaModel.getMediaEffectModel();
    int k = ((MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getWidth();
    int m = ((MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getHeight();
    int i;
    if ("1".equals(localMediaEffectModel.getParam("FRAME_PARAMS_KEY_IS_ON")))
    {
      i = Math.max(k, m);
      return constrainRenderSize(i, i);
    }
    int n = BitmapUtil.getImageRotation(paramString);
    int j;
    if (n != 90)
    {
      i = m;
      j = k;
      if (n != 270) {}
    }
    else
    {
      j = m;
      i = k;
    }
    paramMediaModel = paramMediaModel.getMediaEffectModel().getCropModel();
    m = i;
    k = j;
    if (paramMediaModel != null)
    {
      m = i;
      k = j;
      if (paramMediaModel.getCropConfig() != null)
      {
        k = (int)(j * paramMediaModel.getCropConfig().getWidth());
        m = (int)(i * paramMediaModel.getCropConfig().getHeight());
      }
    }
    return constrainRenderSize(k, m);
  }
  
  public void cancel()
  {
    this.cancel = true;
  }
  
  protected CGSize constrainRenderSize(int paramInt1, int paramInt2)
  {
    CGSize localCGSize = new CGSize(paramInt1, paramInt2);
    int i;
    Size localSize;
    if (this.imageExportConfig != null)
    {
      i = this.imageExportConfig.getMaxIntermediateRenderSize();
      if (i != -1)
      {
        localSize = Util.constrainMaxSize(new Size(paramInt1, paramInt2), i);
        localCGSize.width = localSize.getWidth();
        localCGSize.height = localSize.getHeight();
      }
      if (this.imageExportConfig == null) {
        break label185;
      }
    }
    label185:
    for (paramInt1 = this.imageExportConfig.getMinIntermediateRenderSize();; paramInt1 = -1)
    {
      if (paramInt1 != -1)
      {
        localSize = Util.constrainMinSize(new Size((int)localCGSize.width, (int)localCGSize.height), paramInt1);
        localCGSize.width = localSize.getWidth();
        localCGSize.height = localSize.getHeight();
      }
      Logger.i(this.TAG, String.format("targetRenderSize = %d * %d", new Object[] { Integer.valueOf((int)localCGSize.width), Integer.valueOf((int)localCGSize.height) }));
      return localCGSize;
      i = -1;
      break;
    }
  }
  
  public void export(ImageExporter.ImageExportCallback paramImageExportCallback)
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    localExecutorService.submit(new ImageExporter.1(this, paramImageExportCallback, localExecutorService));
  }
  
  public List<MediaModel> getMediaModels()
  {
    return this.mediaModels;
  }
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void setImageExportConfig(ImageExportConfig paramImageExportConfig)
  {
    this.imageExportConfig = paramImageExportConfig;
  }
  
  public void setMediaModels(List<MediaModel> paramList)
  {
    this.mediaModels = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.exporter.ImageExporter
 * JD-Core Version:    0.7.0.1
 */