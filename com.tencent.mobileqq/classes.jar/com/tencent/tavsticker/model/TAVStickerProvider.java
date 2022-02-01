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
  private static final String TAG = "TAVStickerProvider";
  private boolean isHighQuality = true;
  private PAGRenderer pagRenderer = null;
  private CGSize renderSize = CGSize.CGSizeZero;
  private TAVSticker sticker = null;
  
  public TAVStickerProvider(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null)
    {
      this.sticker = paramTAVSticker;
      this.pagRenderer = new PAGRenderer();
      this.pagRenderer.setFile(this.sticker.getPagFile());
      this.sticker.registerRenderer(this);
      resetRenderConfigs();
      return;
    }
    throw new IllegalArgumentException("initWithSticker, parameter 'tavSticker' can not null");
  }
  
  private void resetRenderConfigs()
  {
    if (this.pagRenderer == null) {
      return;
    }
    if ((!this.isHighQuality) && (TAVStickerUtil.isValidCGSize(this.renderSize)))
    {
      this.pagRenderer.setMaxFrameRate(24.0F);
      float f3 = ScreenUtil.getScreenWidth();
      float f1 = ScreenUtil.getScreenHeight();
      float f4 = this.renderSize.width;
      float f2 = this.renderSize.height;
      f3 = f4 / (f3 * 1.0F);
      f1 = f2 / (f1 * 1.0F);
      this.pagRenderer.setCacheScale(Math.max(f3, f1));
      return;
    }
    this.pagRenderer.setCacheEnabled(true);
    this.pagRenderer.setMaxFrameRate(60.0F);
    this.pagRenderer.setCacheScale(1.0F);
  }
  
  private void updateTransform()
  {
    if ((TAVStickerUtil.isValidCGSize(this.renderSize)) && (this.pagRenderer != null))
    {
      Object localObject = this.sticker;
      if (localObject != null)
      {
        localObject = TAVStickerUtil.getMatrix((TAVSticker)localObject, (int)this.renderSize.width, (int)this.renderSize.height);
        this.pagRenderer.setMatrix((Matrix)localObject);
      }
    }
  }
  
  public TAVSticker getSticker()
  {
    return this.sticker;
  }
  
  public List<TAVStickerLayerItem> getUnderPointLayerItems(float paramFloat1, float paramFloat2)
  {
    if (this.pagRenderer != null)
    {
      if (this.sticker == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      PAGLayer[] arrayOfPAGLayer = this.pagRenderer.getLayersUnderPoint(paramFloat1, paramFloat2);
      if (arrayOfPAGLayer == null) {
        return null;
      }
      int j = arrayOfPAGLayer.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfPAGLayer[i];
        if (localObject != null)
        {
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
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public void release()
  {
    PAGRenderer localPAGRenderer = this.pagRenderer;
    if (localPAGRenderer != null)
    {
      localPAGRenderer.release();
      this.pagRenderer.setSurface(null);
      this.pagRenderer = null;
    }
  }
  
  public void replaceSourceImages(List<TAVSourceImage> paramList)
  {
    Object localObject1 = this.sticker;
    if ((localObject1 != null) && (((TAVSticker)localObject1).getPagFile() != null) && (!CollectionUtil.isEmptyList(paramList)))
    {
      paramList = new ArrayList(paramList);
      int j = this.sticker.getPagFile().numImages();
      int k = paramList.size();
      localObject1 = TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("replaceSourceImages ->  numImages : ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(", sourceImagesCount : ");
      ((StringBuilder)localObject2).append(k);
      TLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
      int i = 0;
      while (i < k)
      {
        localObject2 = (TAVSourceImage)paramList.get(i);
        if (localObject2 != null)
        {
          localObject1 = ((TAVSourceImage)localObject2).getPagImage();
          int m = ((TAVSourceImage)localObject2).getIndex();
          localObject2 = this.pagRenderer;
          if ((localObject2 != null) && (m >= 0) && (m < j)) {
            ((PAGRenderer)localObject2).replaceImage(m, (PAGImage)localObject1);
          }
        }
        i += 1;
      }
    }
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    PAGRenderer localPAGRenderer = this.pagRenderer;
    if (localPAGRenderer != null) {
      localPAGRenderer.setCacheEnabled(paramBoolean);
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
    PAGRenderer localPAGRenderer = this.pagRenderer;
    if (localPAGRenderer != null)
    {
      localPAGRenderer.replaceImage(paramInt, paramPAGImage);
      this.pagRenderer.flush();
    }
  }
  
  public void setLayerColor(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.pagRenderer;
    if (localObject1 != null)
    {
      localObject1 = ((PAGFile)((PAGRenderer)localObject1).getRootComposition()).getLayersByEditableIndex(paramInt1, 2);
      if (localObject1 == null) {
        return;
      }
      int i = localObject1.length;
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        Object localObject2 = localObject1[paramInt1];
        if ((localObject2 instanceof PAGSolidLayer)) {
          ((PAGSolidLayer)localObject2).setSolidColor(paramInt2);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void setPagSurface(PAGSurface paramPAGSurface)
  {
    PAGRenderer localPAGRenderer = this.pagRenderer;
    if ((localPAGRenderer != null) && (paramPAGSurface != localPAGRenderer.getSurface())) {
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
    PAGRenderer localPAGRenderer = this.pagRenderer;
    if (localPAGRenderer != null) {
      localPAGRenderer.setTextData(paramInt, paramPAGText);
    }
  }
  
  public void updateRender(long paramLong)
  {
    try
    {
      if ((this.pagRenderer != null) && (this.sticker != null))
      {
        updateTransform();
        double d = this.sticker.computeProgress(paramLong);
        this.pagRenderer.setProgress(d);
        this.pagRenderer.draw();
        return;
      }
      TLog.e(TAG, "updateRender -> pagRenderer or sticker is null, return!");
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerProvider
 * JD-Core Version:    0.7.0.1
 */