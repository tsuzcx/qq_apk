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
    boolean bool2 = false;
    if ((paramStickerItem == null) || (paramStickerItem.genderType < 1)) {
      bool1 = true;
    }
    PTFaceAttr localPTFaceAttr;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (this.detectInfo == null);
            bool1 = bool2;
          } while (this.detectInfo.aiAttr == null);
          bool1 = bool2;
        } while (!(this.detectInfo.aiAttr.getFaceAttr() instanceof PTFaceAttr));
        localPTFaceAttr = (PTFaceAttr)this.detectInfo.aiAttr.getFaceAttr();
        bool1 = bool2;
      } while (localPTFaceAttr.getFaceInfoList() == null);
      bool1 = bool2;
    } while (localPTFaceAttr.getFaceInfoList().size() <= 0);
    if ((paramStickerItem.genderType > 0) && (paramStickerItem.genderType == ((FaceInfo)localPTFaceAttr.getFaceInfoList().get(0)).gender)) {}
    for (boolean bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public void addItem(FaceStyleItem paramFaceStyleItem)
  {
    if (paramFaceStyleItem != null)
    {
      this.stickerItemList = paramFaceStyleItem.stickerItemList;
      int i = 0;
      while ((this.stickerItemList != null) && (i < this.stickerItemList.size()))
      {
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
    while ((this.stickerItemList != null) && (i < this.stickerItemList.size()))
    {
      StickerItem localStickerItem = (StickerItem)this.stickerItemList.get(i);
      if ((localStickerItem != null) && (localStickerItem.textureMaterials.equals(getTriggeredPhoto()))) {
        return localStickerItem.crazyFacePath;
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
    while ((this.stickerItemList != null) && (i < this.stickerItemList.size()))
    {
      StickerItem localStickerItem = (StickerItem)this.stickerItemList.get(i);
      if ((localStickerItem != null) && (localStickerItem.textureMaterials.equals(getTriggeredPhoto()))) {
        return localStickerItem;
      }
      i += 1;
    }
    return null;
  }
  
  public void hitCharmRange(double paramDouble)
  {
    if (this.stickerItemList != null)
    {
      Iterator localIterator = this.stickerItemList.iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.trigger.StyleChildTriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */