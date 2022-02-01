package com.tencent.tavsticker.model;

import android.graphics.Matrix;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.core.ITAVStickerRenderer;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.ScreenUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.List;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGImageLayer;
import org.libpag.PAGLayer;
import org.libpag.PAGMovie;
import org.libpag.PAGPlayer;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGSurface;
import org.libpag.PAGText;

public class TAVStickerProvider
  implements ITAVStickerRenderer
{
  private static final String TAG = "TAVStickerProvider";
  private boolean isHighQuality = true;
  private PAGPlayer pagPlayer = null;
  private CGSize renderSize = CGSize.CGSizeZero;
  private TAVSticker sticker = null;
  
  public TAVStickerProvider(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null)
    {
      this.sticker = paramTAVSticker;
      this.sticker.registerRenderer(this);
      resetRenderConfigs();
      return;
    }
    throw new IllegalArgumentException("initWithSticker, parameter 'tavSticker' can not null");
  }
  
  private void replacePagMovie(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    paramString = PAGMovie.FromVideoPath(paramString, paramLong1, paramLong2);
    this.sticker.getPagFile().replaceImage(paramInt, paramString);
  }
  
  private void replacePagMovie(PAGImageLayer paramPAGImageLayer, String paramString, CMTimeRange paramCMTimeRange)
  {
    if ((paramPAGImageLayer != null) && (this.sticker != null))
    {
      if (this.pagPlayer == null) {
        return;
      }
      if (paramCMTimeRange != null) {
        replacePagMovie(paramString, paramCMTimeRange.getStartUs(), paramCMTimeRange.getDuration().getTimeUs(), paramPAGImageLayer.editableIndex());
      }
    }
  }
  
  private void resetRenderConfigs()
  {
    if (this.pagPlayer == null) {
      return;
    }
    if ((!this.isHighQuality) && (TAVStickerUtil.isValidCGSize(this.renderSize)))
    {
      this.pagPlayer.setMaxFrameRate(24.0F);
      float f3 = ScreenUtil.getScreenWidth();
      float f1 = ScreenUtil.getScreenHeight();
      float f4 = this.renderSize.width;
      float f2 = this.renderSize.height;
      f3 = f4 / (f3 * 1.0F);
      f1 = f2 / (f1 * 1.0F);
      this.pagPlayer.setCacheScale(Math.max(f3, f1));
      return;
    }
    this.pagPlayer.setCacheEnabled(true);
    this.pagPlayer.setMaxFrameRate(60.0F);
    this.pagPlayer.setCacheScale(1.0F);
  }
  
  private void updateTransform()
  {
    if ((TAVStickerUtil.isValidCGSize(this.renderSize)) && (this.pagPlayer != null))
    {
      Object localObject = this.sticker;
      if (localObject != null)
      {
        localObject = TAVStickerUtil.getMatrix((TAVSticker)localObject, (int)this.renderSize.width, (int)this.renderSize.height);
        this.sticker.getPagFile().setMatrix((Matrix)localObject);
      }
    }
  }
  
  public long getPagSourceDuration(String paramString, boolean paramBoolean)
  {
    TAVSticker localTAVSticker = this.sticker;
    if (localTAVSticker != null) {
      return localTAVSticker.getPagSourceDuration(paramString, paramBoolean);
    }
    return 0L;
  }
  
  public TAVSticker getSticker()
  {
    return this.sticker;
  }
  
  public List<TAVStickerLayerItem> getUnderPointLayerItems(float paramFloat1, float paramFloat2)
  {
    if (this.pagPlayer != null)
    {
      if (this.sticker == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      PAGLayer[] arrayOfPAGLayer = this.pagPlayer.getLayersUnderPoint(paramFloat1, paramFloat2);
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
  
  public void release() {}
  
  public long replacePagMovie(String paramString1, String paramString2, CMTimeRange paramCMTimeRange, boolean paramBoolean)
  {
    TAVSticker localTAVSticker = this.sticker;
    if (localTAVSticker == null) {
      return 0L;
    }
    paramString1 = localTAVSticker.getPagImageLayerByName(paramString1, paramBoolean);
    if ((paramString1 != null) && (this.sticker.hasVideoTrack(paramString1)))
    {
      replacePagMovie(paramString1, paramString2, paramCMTimeRange);
      return paramString1.duration();
    }
    return 0L;
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
        localObject1 = (TAVSourceImage)paramList.get(i);
        if (localObject1 != null)
        {
          localObject2 = ((TAVSourceImage)localObject1).getPagImage();
          int m = ((TAVSourceImage)localObject1).getIndex();
          if ((this.pagPlayer != null) && (m >= 0) && (m < j)) {
            this.sticker.getPagFile().replaceImage(m, (PAGImage)localObject2);
          }
        }
        i += 1;
      }
    }
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    PAGPlayer localPAGPlayer = this.pagPlayer;
    if (localPAGPlayer != null) {
      localPAGPlayer.setCacheEnabled(paramBoolean);
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
    TAVSticker localTAVSticker = this.sticker;
    if ((localTAVSticker != null) && (localTAVSticker.getPagFile() != null)) {
      this.sticker.getPagFile().replaceImage(paramInt, paramPAGImage);
    }
  }
  
  public void setLayerColor(String paramString, int paramInt)
  {
    TAVSticker localTAVSticker = this.sticker;
    if ((localTAVSticker != null) && (localTAVSticker.getPagFile() != null))
    {
      paramString = this.sticker.getPagFile().getLayersByName(paramString);
      if (paramString == null) {
        return;
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localTAVSticker = paramString[i];
        if ((localTAVSticker instanceof PAGSolidLayer)) {
          ((PAGSolidLayer)localTAVSticker).setSolidColor(paramInt);
        }
        i += 1;
      }
    }
  }
  
  public void setPagPlayer(PAGPlayer paramPAGPlayer)
  {
    TAVSticker localTAVSticker = this.sticker;
    if (localTAVSticker != null)
    {
      if (localTAVSticker.getPagFile() == null) {
        return;
      }
      if (this.pagPlayer != paramPAGPlayer) {
        this.pagPlayer = paramPAGPlayer;
      }
      if (this.sticker.getPagFile().parent() == null) {
        this.pagPlayer.getComposition().addLayer(this.sticker.getPagFile());
      }
      this.sticker.getPagFile().setVisible(true);
    }
  }
  
  public void setPagSurface(PAGSurface paramPAGSurface)
  {
    PAGPlayer localPAGPlayer = this.pagPlayer;
    if ((localPAGPlayer != null) && (paramPAGSurface != localPAGPlayer.getSurface())) {
      this.pagPlayer.setSurface(paramPAGSurface);
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
    TAVSticker localTAVSticker = this.sticker;
    if ((localTAVSticker != null) && (localTAVSticker.getPagFile() != null)) {
      this.sticker.getPagFile().replaceText(paramInt, paramPAGText);
    }
  }
  
  public void updateRender(long paramLong)
  {
    try
    {
      if ((this.pagPlayer != null) && (this.sticker != null))
      {
        updateTransform();
        double d = this.sticker.computeProgress(paramLong);
        this.pagPlayer.setProgress(d);
        return;
      }
      TLog.e(TAG, "updateRender -> pagRenderer or sticker is null, return!");
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerProvider
 * JD-Core Version:    0.7.0.1
 */