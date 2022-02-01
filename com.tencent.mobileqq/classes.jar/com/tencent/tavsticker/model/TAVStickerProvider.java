package com.tencent.tavsticker.model;

import android.graphics.Matrix;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavsticker.core.ITAVStickerRenderer;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.ScreenUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.List;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGLayer;
import org.libpag.PAGRenderer;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGSurface;
import org.libpag.PAGText;

public class TAVStickerProvider
  implements ITAVStickerRenderer
{
  private static final String TAG = TAVStickerProvider.class.getSimpleName();
  private boolean isHighQuality = true;
  private PAGRenderer pagRenderer = null;
  private CGSize renderSize = CGSize.CGSizeZero;
  private TAVSticker sticker = null;
  
  public TAVStickerProvider(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker == null) {
      throw new IllegalArgumentException("initWithSticker, parameter 'tavSticker' can not null");
    }
    this.sticker = paramTAVSticker;
    this.pagRenderer = new PAGRenderer();
    this.pagRenderer.setFile(this.sticker.getPagFile());
    this.sticker.registerRenderer(this);
    resetRenderConfigs();
  }
  
  private void resetRenderConfigs()
  {
    if (this.pagRenderer == null) {
      return;
    }
    if ((this.isHighQuality) || (!TAVStickerUtil.isValidCGSize(this.renderSize)))
    {
      this.pagRenderer.setCacheEnabled(true);
      this.pagRenderer.setMaxFrameRate(60.0F);
      this.pagRenderer.setCacheScale(1.0F);
      return;
    }
    this.pagRenderer.setMaxFrameRate(24.0F);
    float f3 = ScreenUtil.getScreenWidth();
    float f1 = ScreenUtil.getScreenHeight();
    float f4 = this.renderSize.width;
    float f2 = this.renderSize.height;
    f3 = f4 / (f3 * 1.0F);
    f1 = f2 / (f1 * 1.0F);
    this.pagRenderer.setCacheScale(Math.max(f3, f1));
  }
  
  private void updateTransform()
  {
    if ((TAVStickerUtil.isValidCGSize(this.renderSize)) && (this.pagRenderer != null) && (this.sticker != null))
    {
      Matrix localMatrix = TAVStickerUtil.getMatrix(this.sticker, (int)this.renderSize.width, (int)this.renderSize.height);
      this.pagRenderer.setMatrix(localMatrix);
    }
  }
  
  public TAVSticker getSticker()
  {
    return this.sticker;
  }
  
  public List<TAVStickerLayerItem> getUnderPointLayerItems(float paramFloat1, float paramFloat2)
  {
    if ((this.pagRenderer == null) || (this.sticker == null)) {}
    ArrayList localArrayList;
    PAGLayer[] arrayOfPAGLayer;
    do
    {
      return null;
      localArrayList = new ArrayList();
      arrayOfPAGLayer = this.pagRenderer.getLayersUnderPoint(paramFloat1, paramFloat2);
    } while (arrayOfPAGLayer == null);
    int j = arrayOfPAGLayer.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfPAGLayer[i];
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        int k = ((PAGLayer)localObject).editableIndex();
        if (3 == ((PAGLayer)localObject).layerType())
        {
          localObject = this.sticker.getTavStickerTextItem(k);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
        else if (5 == ((PAGLayer)localObject).layerType())
        {
          localObject = this.sticker.getTavStickerImageItem(k);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void release()
  {
    if (this.pagRenderer != null)
    {
      this.pagRenderer.release();
      this.pagRenderer.setSurface(null);
      this.pagRenderer = null;
    }
  }
  
  public void replaceSourceImages(List<TAVSourceImage> paramList)
  {
    if ((this.sticker != null) && (this.sticker.getPagFile() != null) && (!CollectionUtil.isEmptyList(paramList)))
    {
      paramList = new ArrayList(paramList);
      int j = this.sticker.getPagFile().numImages();
      int k = paramList.size();
      TLog.d(TAG, "replaceSourceImages ->  numImages : " + j + ", sourceImagesCount : " + k);
      int i = 0;
      if (i < k)
      {
        TAVSourceImage localTAVSourceImage = (TAVSourceImage)paramList.get(i);
        if (localTAVSourceImage == null) {}
        for (;;)
        {
          i += 1;
          break;
          PAGImage localPAGImage = localTAVSourceImage.getPagImage();
          int m = localTAVSourceImage.getIndex();
          if ((this.pagRenderer != null) && (m >= 0) && (m < j)) {
            this.pagRenderer.replaceImage(m, localPAGImage);
          }
        }
      }
    }
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    if (this.pagRenderer != null) {
      this.pagRenderer.setCacheEnabled(paramBoolean);
    }
  }
  
  public void setHighQuality(boolean paramBoolean)
  {
    if (this.isHighQuality != paramBoolean) {
      resetRenderConfigs();
    }
    this.isHighQuality = paramBoolean;
  }
  
  public void setImageData(int paramInt, PAGImage paramPAGImage)
  {
    if (this.pagRenderer != null)
    {
      this.pagRenderer.replaceImage(paramInt, paramPAGImage);
      this.pagRenderer.flush();
    }
  }
  
  public void setLayerColor(int paramInt1, int paramInt2)
  {
    PAGLayer[] arrayOfPAGLayer;
    if (this.pagRenderer != null)
    {
      arrayOfPAGLayer = ((PAGFile)this.pagRenderer.getRootComposition()).getLayersByEditableIndex(paramInt1, 2);
      if (arrayOfPAGLayer != null) {
        break label30;
      }
    }
    for (;;)
    {
      return;
      label30:
      int i = arrayOfPAGLayer.length;
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        PAGLayer localPAGLayer = arrayOfPAGLayer[paramInt1];
        if ((localPAGLayer instanceof PAGSolidLayer)) {
          ((PAGSolidLayer)localPAGLayer).setSolidColor(paramInt2);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void setPagSurface(PAGSurface paramPAGSurface)
  {
    if ((this.pagRenderer != null) && (paramPAGSurface != this.pagRenderer.getSurface())) {
      this.pagRenderer.setSurface(paramPAGSurface);
    }
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    if ((TAVStickerUtil.isValidCGSize(paramCGSize)) && (!paramCGSize.equals(this.renderSize)))
    {
      this.renderSize = paramCGSize;
      resetRenderConfigs();
    }
  }
  
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    if (this.pagRenderer != null) {
      this.pagRenderer.setTextData(paramInt, paramPAGText);
    }
  }
  
  /* Error */
  public void updateRender(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/tavsticker/model/TAVStickerProvider:pagRenderer	Lorg/libpag/PAGRenderer;
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: getfield 33	com/tencent/tavsticker/model/TAVStickerProvider:sticker	Lcom/tencent/tavsticker/model/TAVSticker;
    //   13: ifnonnull +15 -> 28
    //   16: getstatic 26	com/tencent/tavsticker/model/TAVStickerProvider:TAG	Ljava/lang/String;
    //   19: ldc_w 261
    //   22: invokestatic 264	com/tencent/tavsticker/log/TLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: invokespecial 266	com/tencent/tavsticker/model/TAVStickerProvider:updateTransform	()V
    //   32: aload_0
    //   33: getfield 33	com/tencent/tavsticker/model/TAVStickerProvider:sticker	Lcom/tencent/tavsticker/model/TAVSticker;
    //   36: lload_1
    //   37: invokevirtual 270	com/tencent/tavsticker/model/TAVSticker:computeProgress	(J)D
    //   40: dstore_3
    //   41: aload_0
    //   42: getfield 44	com/tencent/tavsticker/model/TAVStickerProvider:pagRenderer	Lorg/libpag/PAGRenderer;
    //   45: dload_3
    //   46: invokevirtual 274	org/libpag/PAGRenderer:setProgress	(D)V
    //   49: aload_0
    //   50: getfield 44	com/tencent/tavsticker/model/TAVStickerProvider:pagRenderer	Lorg/libpag/PAGRenderer;
    //   53: invokevirtual 277	org/libpag/PAGRenderer:draw	()V
    //   56: goto -31 -> 25
    //   59: astore 5
    //   61: aload_0
    //   62: monitorexit
    //   63: aload 5
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	TAVStickerProvider
    //   0	66	1	paramLong	long
    //   40	6	3	d	double
    //   59	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	59	finally
    //   16	25	59	finally
    //   28	56	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerProvider
 * JD-Core Version:    0.7.0.1
 */