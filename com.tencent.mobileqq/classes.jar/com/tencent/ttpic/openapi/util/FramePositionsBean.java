package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.Collections;
import java.util.List;

public class FramePositionsBean
{
  public List<FramePosition> framePositions;
  
  public void checkFrameOrder()
  {
    Object localObject = this.framePositions;
    if (localObject == null) {
      return;
    }
    Collections.sort((List)localObject, new FramePositionsBean.1(this));
    int j = this.framePositions.size();
    int i = 0;
    while (i < j)
    {
      if (i != ((FramePosition)this.framePositions.get(i)).index)
      {
        localObject = new FramePosition();
        ((FramePosition)localObject).index = i;
        if (i == 0) {
          ((FramePosition)localObject).copy((FramePosition)this.framePositions.get(i));
        } else {
          ((FramePosition)localObject).updateValue((FramePosition)this.framePositions.get(i - 1), (FramePosition)this.framePositions.get(i));
        }
        this.framePositions.add(i, localObject);
      }
      j = this.framePositions.size();
      i += 1;
    }
  }
  
  public void updateFramePosition(int paramInt, StickerItem paramStickerItem)
  {
    if ((paramInt < 0) && (this.framePositions != null)) {
      return;
    }
    if (this.framePositions.size() > paramInt)
    {
      FramePosition localFramePosition = (FramePosition)this.framePositions.get(paramInt);
      if (localFramePosition != null) {
        localFramePosition.updateFramePosition(paramStickerItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.FramePositionsBean
 * JD-Core Version:    0.7.0.1
 */