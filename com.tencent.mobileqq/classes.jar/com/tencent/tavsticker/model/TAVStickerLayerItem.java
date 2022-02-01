package com.tencent.tavsticker.model;

import com.tencent.tavsticker.core.TAVStickerParser;
import org.libpag.PAGLayer;

public abstract class TAVStickerLayerItem
{
  protected int layerIndex = -1;
  protected TAVStickerLayerInfo layerInfo = null;
  protected String layerName = "";
  protected int layerType = 0;
  
  public TAVStickerLayerItem() {}
  
  public TAVStickerLayerItem(PAGLayer paramPAGLayer)
  {
    if (paramPAGLayer != null)
    {
      this.layerIndex = paramPAGLayer.editableIndex();
      this.layerName = paramPAGLayer.layerName();
      this.layerType = paramPAGLayer.layerType();
      this.layerInfo = TAVStickerParser.parsePagLayer(paramPAGLayer);
    }
  }
  
  public int getLayerIndex()
  {
    return this.layerIndex;
  }
  
  public TAVStickerLayerInfo getLayerInfo()
  {
    return this.layerInfo;
  }
  
  public String getLayerName()
  {
    return this.layerName;
  }
  
  public int getLayerType()
  {
    return this.layerType;
  }
  
  public void setLayerIndex(int paramInt)
  {
    this.layerIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerLayerItem
 * JD-Core Version:    0.7.0.1
 */