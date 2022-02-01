package com.tencent.ttpic.model;

import com.tencent.ttpic.openapi.model.DistortionItem;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.List;

public class FaceFeatureItem
{
  private String dataPath;
  private List<DistortionItem> distortionItemList;
  private List<FaceItem> faceOffItemList;
  private String id;
  private int maskAnchorPoint;
  private List<StickerItem> stickerItems;
  
  public String getDataPath()
  {
    return this.dataPath;
  }
  
  public List<DistortionItem> getDistortionItemList()
  {
    return this.distortionItemList;
  }
  
  public List<FaceItem> getFaceOffItemList()
  {
    return this.faceOffItemList;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getMaskAnchorPoint()
  {
    return this.maskAnchorPoint;
  }
  
  public List<StickerItem> getStickerItems()
  {
    return this.stickerItems;
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setDistortionItemList(List<DistortionItem> paramList)
  {
    this.distortionItemList = paramList;
  }
  
  public void setFaceOffItemList(List<FaceItem> paramList)
  {
    this.faceOffItemList = paramList;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMaskAnchorPoint(int paramInt)
  {
    this.maskAnchorPoint = paramInt;
  }
  
  public void setStickerItems(List<StickerItem> paramList)
  {
    this.stickerItems = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceFeatureItem
 * JD-Core Version:    0.7.0.1
 */