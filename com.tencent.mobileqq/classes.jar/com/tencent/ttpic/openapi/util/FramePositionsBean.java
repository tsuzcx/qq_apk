package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.Collections;
import java.util.List;

public class FramePositionsBean
{
  public List<FramePosition> framePositions;
  
  public void checkFrameOrder()
  {
    if (this.framePositions == null) {
      return;
    }
    Collections.sort(this.framePositions, new FramePositionsBean.1(this));
    int j = this.framePositions.size();
    int i = 0;
    label35:
    FramePosition localFramePosition;
    if (i < j) {
      if (i != ((FramePosition)this.framePositions.get(i)).index)
      {
        localFramePosition = new FramePosition();
        localFramePosition.index = i;
        if (i != 0) {
          break label122;
        }
        localFramePosition.copy((FramePosition)this.framePositions.get(i));
      }
    }
    for (;;)
    {
      this.framePositions.add(i, localFramePosition);
      j = this.framePositions.size();
      i += 1;
      break label35;
      break;
      label122:
      localFramePosition.updateValue((FramePosition)this.framePositions.get(i - 1), (FramePosition)this.framePositions.get(i));
    }
  }
  
  public void updateFramePosition(int paramInt, StickerItem paramStickerItem)
  {
    if ((paramInt < 0) && (this.framePositions != null)) {}
    FramePosition localFramePosition;
    do
    {
      do
      {
        return;
      } while (this.framePositions.size() <= paramInt);
      localFramePosition = (FramePosition)this.framePositions.get(paramInt);
    } while (localFramePosition == null);
    localFramePosition.updateFramePosition(paramStickerItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.FramePositionsBean
 * JD-Core Version:    0.7.0.1
 */