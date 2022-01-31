package com.tencent.tavmovie.sticker;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVMovieSticker
{
  private PointF centerPosition;
  private String filePath;
  private List<TAVStickerImageItem> imageList;
  private float rotation;
  private float scale;
  private TAVSticker sticker;
  private TAVMovieSticker.TAVMovieStickerMode stickerMode;
  private TAVMovieSticker.TAVTemplateStickerType stickerType;
  private List<TAVMovieStickerTextItem> textList;
  private CMTimeRange timeRange;
  
  public TAVMovieSticker() {}
  
  public TAVMovieSticker(@NonNull String paramString)
  {
    this(paramString, false);
  }
  
  public TAVMovieSticker(@NonNull String paramString, boolean paramBoolean)
  {
    this.filePath = paramString;
    this.scale = 1.0F;
    this.rotation = 0.0F;
    this.centerPosition = new PointF(0.5F, 0.5F);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.sticker = new TAVSticker().setAssetFilePath(paramString).setScale(1.0F).setRotate(0.0F).setCenterX(0.5F).setCenterY(0.5F).init();
        this.timeRange = this.sticker.getTimeRange();
        this.imageList = this.sticker.getStickerImageItems();
        paramString = this.sticker.getStickerTextItems();
        if ((paramString != null) && (paramString.size() > 0))
        {
          this.textList = new ArrayList();
          paramString = paramString.iterator();
          if (paramString.hasNext())
          {
            TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)paramString.next();
            TAVMovieStickerTextItem localTAVMovieStickerTextItem = new TAVMovieStickerTextItem();
            localTAVMovieStickerTextItem.setTextItem(localTAVStickerTextItem);
            localTAVMovieStickerTextItem.setText(localTAVStickerTextItem.getDefaultText());
            localTAVMovieStickerTextItem.setTextColor(localTAVStickerTextItem.getDefaultColor());
            this.textList.add(localTAVMovieStickerTextItem);
            continue;
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      this.sticker = new TAVSticker().setFilePath(paramString).setScale(1.0F).setRotate(0.0F).setCenterX(0.5F).setCenterY(0.5F).init();
    }
  }
  
  public TAVMovieSticker clone()
  {
    TAVMovieSticker localTAVMovieSticker = new TAVMovieSticker(this.filePath);
    localTAVMovieSticker.setStickerType(this.stickerType);
    localTAVMovieSticker.setPosition(this.centerPosition);
    localTAVMovieSticker.setRotation(this.rotation);
    localTAVMovieSticker.setScale(this.scale);
    localTAVMovieSticker.setTimeRange(this.timeRange.clone());
    return null;
  }
  
  public List<TAVStickerImageItem> getImageList()
  {
    return this.imageList;
  }
  
  public PointF getPosition()
  {
    return this.centerPosition;
  }
  
  public float getRotation()
  {
    return this.rotation;
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public TAVSticker getSticker()
  {
    return this.sticker;
  }
  
  public List<TAVStickerLayerInfo> getStickerLayerInfos()
  {
    if (this.sticker != null) {
      return this.sticker.getStickerLayerInfos();
    }
    return null;
  }
  
  public List<TAVStickerLayerInfo> getStickerLayerInfosFake()
  {
    if (this.sticker != null) {
      return this.sticker.getStickerLayerInfosFake();
    }
    return null;
  }
  
  public TAVMovieSticker.TAVMovieStickerMode getStickerMode()
  {
    return this.stickerMode;
  }
  
  public TAVMovieSticker.TAVTemplateStickerType getStickerType()
  {
    return this.stickerType;
  }
  
  public List<TAVMovieStickerTextItem> getTextList()
  {
    return this.textList;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public void setPosition(PointF paramPointF)
  {
    this.centerPosition = paramPointF;
    if (!this.centerPosition.equals(this.sticker.getCenterX(), this.sticker.getCenterY()))
    {
      this.sticker.setCenterX(this.centerPosition.x);
      this.sticker.setCenterY(this.centerPosition.y);
    }
  }
  
  public void setRotation(float paramFloat)
  {
    this.rotation = paramFloat;
    if (Math.abs(this.rotation - this.sticker.getRotate()) > 0.001F) {
      this.sticker.setRotate(this.rotation);
    }
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
    if (Math.abs(this.scale - this.sticker.getScale()) > 0.001F) {
      this.sticker.setScale(this.scale);
    }
  }
  
  public void setStickerMode(TAVMovieSticker.TAVMovieStickerMode paramTAVMovieStickerMode)
  {
    this.stickerMode = paramTAVMovieStickerMode;
  }
  
  public void setStickerType(TAVMovieSticker.TAVTemplateStickerType paramTAVTemplateStickerType)
  {
    this.stickerType = paramTAVTemplateStickerType;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
    if (!this.timeRange.equals(this.sticker.getTimeRange())) {
      this.sticker.setTimeRange(this.timeRange);
    }
  }
  
  public void updateImageData()
  {
    if (this.sticker != null) {
      this.sticker.updateImageData();
    }
  }
  
  public void updateTextData()
  {
    if (this.sticker != null) {
      this.sticker.updateTextData();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavmovie.sticker.TAVMovieSticker
 * JD-Core Version:    0.7.0.1
 */