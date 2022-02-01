package com.tencent.ttpic.openapi.factory;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils;
import com.tencent.ttpic.openapi.filter.PtuFilterFactory;
import com.tencent.view.RendererUtils;
import java.io.File;

final class TTPicFilterFactoryLocal$1
  implements Runnable
{
  TTPicFilterFactoryLocal$1(int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = TTPicFilterFactoryLocal.preloadBaseLUTImage();
      if (localObject == null) {
        return;
      }
      int i = RendererUtils.createTexture((Bitmap)localObject);
      Frame localFrame = new Frame();
      BaseFilter localBaseFilter = PtuFilterFactory.createFilter(this.val$filterId);
      localBaseFilter.applyFilterChain(true, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      localBaseFilter.RenderProcess(i, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), -1, 0.0D, localFrame);
      localObject = RendererUtils.saveTexture(localFrame.getLastRenderTextureId(), ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AEModule.getLutDirPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(this.val$filterName);
      localStringBuilder.append(".png");
      BitmapUtils.saveBitmap2PNG((Bitmap)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AEModule.getLutDirPath());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.val$filterName);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AEModule.getLutDirPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(this.val$filterName);
      localStringBuilder.append(".png2");
      FileEncryptUtils.encryptFile((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AEModule.getLutDirPath());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.val$filterName);
      ((StringBuilder)localObject).append(".png");
      new File(((StringBuilder)localObject).toString()).delete();
      RendererUtils.clearTexture(i);
      localFrame.clear();
      localBaseFilter.clearGLSL();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal.1
 * JD-Core Version:    0.7.0.1
 */