package com.tencent.ttpic.model;

import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImagesSetting
{
  ArrayList<StickerItem> mStickerItems;
  
  public void creatItems(StickerItem paramStickerItem, Map<String, Integer> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    for (;;)
    {
      return;
      this.mStickerItems = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.mStickerItems.add(createStickerItem(str, ((Integer)paramMap.get(str)).intValue(), paramStickerItem));
      }
    }
  }
  
  public StickerItem createStickerItem(String paramString, int paramInt, StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {
      return null;
    }
    StickerItem localStickerItem = new StickerItem();
    localStickerItem.id = paramString;
    localStickerItem.frames = paramInt;
    localStickerItem.subFolder = localStickerItem.id;
    localStickerItem.frameDuration = paramStickerItem.frameDuration;
    localStickerItem.type = paramStickerItem.type;
    localStickerItem.stickerType = paramStickerItem.stickerType;
    return localStickerItem;
  }
  
  public List<StickerItem> getStickerItems()
  {
    return this.mStickerItems;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.ImagesSetting
 * JD-Core Version:    0.7.0.1
 */