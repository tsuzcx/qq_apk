package com.tencent.qcircle.tavcut.exporter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.opengl.EGLContext;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator.ImageGeneratorThread;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.RenderContext;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class ImageExporter
{
  private final String TAG = ImageExporter.class.getSimpleName();
  private boolean cancel = false;
  private Context context;
  private ImageExportConfig imageExportConfig;
  private CountDownLatch mCountDownLatch;
  private List<MediaModel> mediaModels;
  private List<String> mediaModelsMD5;
  
  private CGSize calculateRenderSize(MediaModel paramMediaModel, String paramString)
  {
    paramMediaModel.getMediaEffectModel();
    int m = ((MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getWidth();
    int k = ((MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getHeight();
    int n = BitmapUtil.getImageRotation(paramString);
    int j;
    int i;
    if (n != 90)
    {
      j = m;
      i = k;
      if (n != 270) {}
    }
    else
    {
      i = m;
      j = k;
    }
    paramMediaModel = paramMediaModel.getMediaEffectModel().getCropModel();
    m = j;
    k = i;
    if (paramMediaModel != null)
    {
      m = j;
      k = i;
      if (paramMediaModel.getCropConfig() != null)
      {
        m = (int)(j * paramMediaModel.getCropConfig().getWidth());
        k = (int)(i * paramMediaModel.getCropConfig().getHeight());
      }
    }
    return constrainRenderSize(m, k);
  }
  
  private String cropSourcePath(LinkedBlockingDeque<String> paramLinkedBlockingDeque, int paramInt, MediaModel paramMediaModel, String paramString)
  {
    String str = (String)this.imageExportConfig.getOutputPaths().get(paramInt);
    paramMediaModel = BitmapUtil.decodeBitmapWithCrop(paramString, paramMediaModel.getMediaEffectModel().getCropModel().getCropConfig());
    try
    {
      if (!BitmapUtil.saveBitmap(paramMediaModel, this.imageExportConfig.getFormat(), this.imageExportConfig.getQuality(), str, new ExifInterface(paramString)))
      {
        paramString = new StringBuilder();
        paramString.append("image save failed! output path = ");
        paramString.append(str);
        paramLinkedBlockingDeque.add(paramString.toString());
      }
    }
    catch (IOException paramLinkedBlockingDeque)
    {
      Logger.e(paramLinkedBlockingDeque);
    }
    if (paramMediaModel != null) {
      paramMediaModel.recycle();
    }
    return str;
  }
  
  private boolean isNeedCrop(String paramString)
  {
    int i = BitmapUtil.getImageRotation(paramString);
    if (i != 90)
    {
      if (i == 270) {
        return true;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFileWithBuffer(paramString, localOptions);
      i = localOptions.outWidth;
      int j = localOptions.outHeight;
      double d1 = i;
      Double.isNaN(d1);
      double d2 = j;
      Double.isNaN(d2);
      float f = (float)(d1 * 1.0D / d2);
      if ((f < 1.333333F) && (f > 0.5625F)) {
        return false;
      }
    }
    return true;
  }
  
  public void cancel()
  {
    this.cancel = true;
  }
  
  protected CGSize constrainRenderSize(int paramInt1, int paramInt2)
  {
    CGSize localCGSize = new CGSize(paramInt1, paramInt2);
    Object localObject = this.imageExportConfig;
    int i;
    if (localObject != null) {
      i = ((ImageExportConfig)localObject).getMaxIntermediateRenderSize();
    } else {
      i = -1;
    }
    if (i != -1)
    {
      localObject = Util.constrainMaxSize(new Size(paramInt1, paramInt2), i);
      localCGSize.width = ((Size)localObject).getWidth();
      localCGSize.height = ((Size)localObject).getHeight();
    }
    localObject = this.imageExportConfig;
    if (localObject != null) {
      paramInt1 = ((ImageExportConfig)localObject).getMinIntermediateRenderSize();
    } else {
      paramInt1 = -1;
    }
    if (paramInt1 != -1)
    {
      localObject = Util.constrainMinSize(new Size((int)localCGSize.width, (int)localCGSize.height), paramInt1);
      localCGSize.width = ((Size)localObject).getWidth();
      localCGSize.height = ((Size)localObject).getHeight();
    }
    Logger.i(this.TAG, String.format("targetRenderSize = %d * %d", new Object[] { Integer.valueOf((int)localCGSize.width), Integer.valueOf((int)localCGSize.height) }));
    return localCGSize;
  }
  
  public void export(ImageExporter.ImageExportCallback paramImageExportCallback, EGLContext paramEGLContext, AssetImageGenerator.ImageGeneratorThread paramImageGeneratorThread, RenderContext paramRenderContext, AEFilterManager paramAEFilterManager)
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    localExecutorService.submit(new ImageExporter.1(this, paramImageExportCallback, localExecutorService, paramAEFilterManager, paramEGLContext, paramImageGeneratorThread, paramRenderContext));
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
  
  public void setMediaModelsMd5(List<String> paramList)
  {
    this.mediaModelsMD5 = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.ImageExporter
 * JD-Core Version:    0.7.0.1
 */