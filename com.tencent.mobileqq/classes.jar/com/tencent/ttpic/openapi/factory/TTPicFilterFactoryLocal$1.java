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
      Bitmap localBitmap = TTPicFilterFactoryLocal.preloadBaseLUTImage();
      if (localBitmap == null) {
        return;
      }
      int i = RendererUtils.createTexture(localBitmap);
      Frame localFrame = new Frame();
      BaseFilter localBaseFilter = PtuFilterFactory.createFilter(this.val$filterId);
      localBaseFilter.applyFilterChain(true, localBitmap.getWidth(), localBitmap.getHeight());
      localBaseFilter.RenderProcess(i, localBitmap.getWidth(), localBitmap.getHeight(), -1, 0.0D, localFrame);
      BitmapUtils.saveBitmap2PNG(RendererUtils.saveTexture(localFrame.getLastRenderTextureId(), localBitmap.getWidth(), localBitmap.getHeight()), AEModule.getLutDirPath() + File.separator + this.val$filterName + ".png");
      FileEncryptUtils.encryptFile(AEModule.getLutDirPath() + File.separator + this.val$filterName + ".png", AEModule.getLutDirPath() + File.separator + this.val$filterName + ".png2");
      new File(AEModule.getLutDirPath() + File.separator + this.val$filterName + ".png").delete();
      RendererUtils.clearTexture(i);
      localFrame.clear();
      localBaseFilter.ClearGLSL();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal.1
 * JD-Core Version:    0.7.0.1
 */