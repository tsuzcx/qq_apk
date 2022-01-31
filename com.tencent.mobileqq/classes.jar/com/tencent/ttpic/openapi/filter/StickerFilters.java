package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.AEFilterBase;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.List;

public class StickerFilters
  extends AEFilterBase
{
  private boolean isBeforeFaceTransform = false;
  private AIAttr mAIAttr;
  private PTFaceAttr mFaceAttr;
  private PTSegAttr mSegAttr;
  private AESticker mSticker = null;
  private List<String> renderOrderList;
  private StickersMap stickersMap;
  
  public StickerFilters(AESticker paramAESticker, boolean paramBoolean)
  {
    super(null, null);
    setBeforeFaceTransform(paramBoolean);
    setSticker(paramAESticker);
    this.stickersMap = new StickersMap();
  }
  
  public void apply() {}
  
  public void clear()
  {
    this.mSticker = null;
  }
  
  public boolean isBeforeFaceTransform()
  {
    return this.isBeforeFaceTransform;
  }
  
  public Frame render(Frame paramFrame)
  {
    if ((this.mSticker == null) || (!this.mSticker.isValid())) {
      return paramFrame;
    }
    if (this.mSticker.getVideoMateral() != null) {
      this.renderOrderList = this.mSticker.getVideoMateral().getRenderOrderList();
    }
    if (isBeforeFaceTransform()) {
      return this.mSticker.processTransformRelatedFilters(paramFrame, this.mFaceAttr, this.mSegAttr, this.mAIAttr);
    }
    if ((this.renderOrderList != null) && (this.renderOrderList.size() > 0))
    {
      this.stickersMap.setRenderOrder(this.renderOrderList);
      return this.stickersMap.chainStickerFilters(this.mSticker, paramFrame, this.mFaceAttr, this.mSegAttr, this.mAIAttr);
    }
    return this.mSticker.processStickerFilters(paramFrame, this.mFaceAttr, this.mSegAttr, this.mAIAttr);
  }
  
  public void setAIAttr(AIAttr paramAIAttr)
  {
    this.mAIAttr = paramAIAttr;
  }
  
  public void setBeforeFaceTransform(boolean paramBoolean)
  {
    this.isBeforeFaceTransform = paramBoolean;
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.mFaceAttr = paramPTFaceAttr;
  }
  
  public void setSegAttr(PTSegAttr paramPTSegAttr)
  {
    this.mSegAttr = paramPTSegAttr;
  }
  
  public void setSticker(AESticker paramAESticker)
  {
    this.mSticker = paramAESticker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StickerFilters
 * JD-Core Version:    0.7.0.1
 */