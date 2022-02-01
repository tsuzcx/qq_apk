package com.tencent.weseevideo.model.effect;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavcut.bean.SolidData;
import com.tencent.tavcut.bean.TextItem;
import com.tencent.weseevideo.composition.effectnode.VideoEffectType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StickerModel
  extends VideoPagModel
{
  protected Bitmap bitmap;
  protected float centerX = 0.0F;
  protected float centerY = 0.0F;
  public boolean editable = true;
  boolean enableRotate = true;
  protected long endTime = 0L;
  protected String fontId = "";
  protected int height = 0;
  protected int layerIndex = -1;
  protected StickerModel.LimitArea limitArea;
  boolean lockRatio = true;
  protected String materialId = "";
  protected float maxScale = 0.0F;
  protected float minScale = 0.0F;
  protected float rotate = 0.0F;
  protected float scale = 0.5F;
  private float scaleX = 0.5F;
  private float scaleY = 0.5F;
  protected Map<String, SolidData> solidItems = new HashMap();
  protected List<TextItem> textItems = new ArrayList();
  protected String textPngPath;
  protected TextureInfo textureInfo;
  protected String texturePngPath;
  protected String type = "";
  protected int width = 0;
  private float xScaleMax = 0.0F;
  private float xScaleMin = 0.0F;
  private float yScaleMax = 0.0F;
  private float yScaleMin = 0.0F;
  
  public StickerModel()
  {
    this.effectType = VideoEffectType.TYPE_STICKER.value;
  }
  
  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public float getCenterX()
  {
    return this.centerX;
  }
  
  public float getCenterY()
  {
    return this.centerY;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public String getFontId()
  {
    return this.fontId;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getLayerIndex()
  {
    return this.layerIndex;
  }
  
  public StickerModel.LimitArea getLimitArea()
  {
    return this.limitArea;
  }
  
  public String getMaterialId()
  {
    return this.materialId;
  }
  
  public float getMaxScale()
  {
    return this.maxScale;
  }
  
  public float getMinScale()
  {
    return this.minScale;
  }
  
  public float getRotate()
  {
    return this.rotate;
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public float getScaleX()
  {
    return this.scaleX;
  }
  
  public float getScaleXMax()
  {
    return this.xScaleMax;
  }
  
  public float getScaleXMin()
  {
    return this.xScaleMin;
  }
  
  public float getScaleY()
  {
    return this.scaleY;
  }
  
  public float getScaleYMax()
  {
    return this.yScaleMax;
  }
  
  public float getScaleYMin()
  {
    return this.yScaleMin;
  }
  
  public Map<String, SolidData> getSolidItems()
  {
    return this.solidItems;
  }
  
  public List<TextItem> getTextItems()
  {
    return this.textItems;
  }
  
  public String getTextPngPath()
  {
    return this.textPngPath;
  }
  
  public TextureInfo getTextureInfo()
  {
    return this.textureInfo;
  }
  
  public String getTexturePngPath()
  {
    return this.texturePngPath;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean isEditable()
  {
    return this.editable;
  }
  
  public boolean isEnableRotate()
  {
    return this.enableRotate;
  }
  
  public boolean isLockRatio()
  {
    return this.lockRatio;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
  }
  
  public void setCenterX(float paramFloat)
  {
    this.centerX = paramFloat;
  }
  
  public void setCenterY(float paramFloat)
  {
    this.centerY = paramFloat;
  }
  
  public void setEditable(boolean paramBoolean)
  {
    this.editable = paramBoolean;
  }
  
  public void setEnableRotate(boolean paramBoolean)
  {
    this.enableRotate = paramBoolean;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setFontId(String paramString)
  {
    this.fontId = paramString;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setLayerIndex(int paramInt)
  {
    this.layerIndex = paramInt;
  }
  
  public void setLimitArea(StickerModel.LimitArea paramLimitArea)
  {
    this.limitArea = paramLimitArea;
  }
  
  public void setLockRatio(boolean paramBoolean)
  {
    this.lockRatio = paramBoolean;
  }
  
  public void setMaterialId(String paramString)
  {
    this.materialId = paramString;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.maxScale = paramFloat;
  }
  
  public void setMinScale(float paramFloat)
  {
    this.minScale = paramFloat;
  }
  
  public void setRotate(float paramFloat)
  {
    this.rotate = paramFloat;
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public void setScaleX(float paramFloat)
  {
    this.scaleX = paramFloat;
  }
  
  public void setScaleXMax(float paramFloat)
  {
    this.xScaleMax = paramFloat;
  }
  
  public void setScaleXMin(float paramFloat)
  {
    this.xScaleMin = paramFloat;
  }
  
  public void setScaleY(float paramFloat)
  {
    this.scaleY = paramFloat;
  }
  
  public void setScaleYMax(float paramFloat)
  {
    this.yScaleMax = paramFloat;
  }
  
  public void setScaleYMin(float paramFloat)
  {
    this.yScaleMin = paramFloat;
  }
  
  public void setSolidItems(Map<String, SolidData> paramMap)
  {
    this.solidItems = paramMap;
  }
  
  public void setTextItems(List<TextItem> paramList)
  {
    this.textItems = paramList;
  }
  
  public void setTextPngPath(String paramString)
  {
    this.textPngPath = paramString;
  }
  
  public void setTextureInfo(TextureInfo paramTextureInfo)
  {
    this.textureInfo = paramTextureInfo;
  }
  
  public void setTexturePngPath(String paramString)
  {
    this.texturePngPath = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.StickerModel
 * JD-Core Version:    0.7.0.1
 */