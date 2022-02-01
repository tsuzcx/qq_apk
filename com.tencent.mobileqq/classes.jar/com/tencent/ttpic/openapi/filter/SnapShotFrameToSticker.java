package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.SNAP_SHOT_TIME;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import java.util.Iterator;
import java.util.List;

public class SnapShotFrameToSticker
{
  private BaseFilter mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  
  public void ApplyGLSLFilter()
  {
    this.mCopyFilter.apply();
  }
  
  public void clear()
  {
    BaseFilter localBaseFilter = this.mCopyFilter;
    if (localBaseFilter != null) {
      localBaseFilter.clearGLSL();
    }
  }
  
  public void frameToSticker(SnapShotFilter paramSnapShotFilter, Frame paramFrame)
  {
    Frame localFrame = paramSnapShotFilter.getFrame(paramFrame.width, paramFrame.height);
    if (localFrame.getTextureId() != 0) {
      FrameUtil.clearFrame(localFrame, 0.0F, 0.0F, 0.0F, 0.0F, localFrame.width, localFrame.height);
    }
    this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, localFrame);
    paramSnapShotFilter.updateTextureParam(localFrame.getTextureId());
    paramSnapShotFilter.renderTexture(localFrame.getTextureId(), localFrame.width, localFrame.height);
  }
  
  public void frameToStickerTexture(SnapShotFilter paramSnapShotFilter, Frame paramFrame)
  {
    if (paramFrame == null) {
      return;
    }
    paramSnapShotFilter.updateTextureParam(paramFrame.getTextureId());
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public void updateTexture(List<RenderItem> paramList, Frame paramFrame, PTDetectInfo paramPTDetectInfo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramPTDetectInfo = (RenderItem)paramList.next();
      if ((paramPTDetectInfo.filter instanceof SnapShotFilter))
      {
        SnapShotFilter localSnapShotFilter = (SnapShotFilter)paramPTDetectInfo.filter;
        if (localSnapShotFilter.getStickerItem().stickerType == VideoFilterFactory.STICKER_TYPE.SNAP_SHOT.type)
        {
          if (!paramPTDetectInfo.triggerCtrlItem.isTriggered()) {
            localSnapShotFilter.setHasSnapShot(false);
          }
          if ((paramPTDetectInfo.triggerCtrlItem.isTriggered()) && (localSnapShotFilter.getStickerItem().snapshotTime == VideoFilterFactory.SNAP_SHOT_TIME.NO_STICKER.type) && (!localSnapShotFilter.isHasSnapShot()))
          {
            frameToSticker(localSnapShotFilter, paramFrame);
            localSnapShotFilter.setHasSnapShot(true);
            localSnapShotFilter.setAlpha();
            return;
          }
        }
        if (localSnapShotFilter.getStickerItem().type == VideoFilterFactory.POSITION_TYPE.TRANSPARENT.type) {
          frameToStickerTexture(localSnapShotFilter, paramFrame);
        }
      }
    }
  }
  
  public void updateTextureWithSticker(List<RenderItem> paramList, Frame paramFrame, PTDetectInfo paramPTDetectInfo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramPTDetectInfo = (RenderItem)paramList.next();
      if ((paramPTDetectInfo.filter instanceof SnapShotFilter))
      {
        SnapShotFilter localSnapShotFilter = (SnapShotFilter)paramPTDetectInfo.filter;
        if (localSnapShotFilter.getStickerItem().stickerType == VideoFilterFactory.STICKER_TYPE.SNAP_SHOT.type)
        {
          if (!paramPTDetectInfo.triggerCtrlItem.isTriggered()) {
            localSnapShotFilter.setHasSnapShot(false);
          }
          if ((paramPTDetectInfo.triggerCtrlItem.isTriggered()) && (localSnapShotFilter.getStickerItem().snapshotTime == VideoFilterFactory.SNAP_SHOT_TIME.STICKER.type) && (!localSnapShotFilter.isHasSnapShot()))
          {
            frameToSticker(localSnapShotFilter, paramFrame);
            localSnapShotFilter.setHasSnapShot(true);
            localSnapShotFilter.setAlpha();
            return;
          }
        }
        if (localSnapShotFilter.getStickerItem().type == VideoFilterFactory.POSITION_TYPE.TRANSPARENT.type) {
          frameToStickerTexture(localSnapShotFilter, paramFrame);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.SnapShotFrameToSticker
 * JD-Core Version:    0.7.0.1
 */