package com.tencent.ttpic.trigger;

import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StyleChildTriggerCtrlItem
  extends TriggerCtrlItem
{
  List<StickerItem> stickerItemList;
  private Map<String, TriggerCtrlItem> triggerCtrlItemMap = new HashMap();
  
  private boolean isGenderMatch(StickerItem paramStickerItem)
  {
    if (paramStickerItem != null)
    {
      if (paramStickerItem.genderType < 1) {
        return true;
      }
      if ((this.detectInfo != null) && (this.detectInfo.aiAttr != null) && ((this.detectInfo.aiAttr.getFaceAttr() instanceof PTFaceAttr)))
      {
        PTFaceAttr localPTFaceAttr = (PTFaceAttr)this.detectInfo.aiAttr.getFaceAttr();
        if ((localPTFaceAttr.getFaceInfoList() != null) && (localPTFaceAttr.getFaceInfoList().size() > 0)) {
          return (paramStickerItem.genderType > 0) && (paramStickerItem.genderType == ((FaceInfo)localPTFaceAttr.getFaceInfoList().get(0)).gender);
        }
      }
      return false;
    }
    return true;
  }
  
  public void addItem(FaceStyleItem paramFaceStyleItem)
  {
    if (paramFaceStyleItem != null)
    {
      this.stickerItemList = paramFaceStyleItem.stickerItemList;
      int i = 0;
      for (;;)
      {
        paramFaceStyleItem = this.stickerItemList;
        if ((paramFaceStyleItem == null) || (i >= paramFaceStyleItem.size())) {
          break;
        }
        paramFaceStyleItem = (StickerItem)this.stickerItemList.get(i);
        TriggerCtrlItem localTriggerCtrlItem = new TriggerCtrlItem(paramFaceStyleItem);
        this.triggerCtrlItemMap.put(paramFaceStyleItem.textureMaterials, localTriggerCtrlItem);
        i += 1;
      }
    }
  }
  
  public String getTriggeredCosFun()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.stickerItemList;
      if ((localObject == null) || (i >= ((List)localObject).size())) {
        break;
      }
      localObject = (StickerItem)this.stickerItemList.get(i);
      if ((localObject != null) && (((StickerItem)localObject).textureMaterials.equals(getTriggeredPhoto()))) {
        return ((StickerItem)localObject).crazyFacePath;
      }
      i += 1;
    }
    return null;
  }
  
  public String getTriggeredPhoto()
  {
    Iterator localIterator = this.triggerCtrlItemMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((TriggerCtrlItem)localEntry.getValue()).isTriggered()) && (isGenderMatch(((TriggerCtrlItem)localEntry.getValue()).mStickerItem))) {
        return (String)localEntry.getKey();
      }
    }
    return null;
  }
  
  public StickerItem getTriggeredStickerItem()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.stickerItemList;
      if ((localObject == null) || (i >= ((List)localObject).size())) {
        break;
      }
      localObject = (StickerItem)this.stickerItemList.get(i);
      if ((localObject != null) && (((StickerItem)localObject).textureMaterials.equals(getTriggeredPhoto()))) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public void hitCharmRange(double paramDouble)
  {
    Object localObject = this.stickerItemList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        StickerItem localStickerItem = (StickerItem)((Iterator)localObject).next();
        if (localStickerItem.charmRange != null) {
          localStickerItem.charmRange.hit(paramDouble);
        }
      }
    }
    updateTriggerStatus(this.detectInfo);
  }
  
  public boolean isTriggered()
  {
    Iterator localIterator = this.triggerCtrlItemMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((TriggerCtrlItem)localEntry.getValue()).isTriggered()) && (isGenderMatch(((TriggerCtrlItem)localEntry.getValue()).mStickerItem))) {
        return true;
      }
    }
    return false;
  }
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo)
  {
    Iterator localIterator = this.triggerCtrlItemMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((TriggerCtrlItem)((Map.Entry)localIterator.next()).getValue()).updateTriggerStatus(paramPTDetectInfo);
    }
    this.detectInfo = paramPTDetectInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.trigger.StyleChildTriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */