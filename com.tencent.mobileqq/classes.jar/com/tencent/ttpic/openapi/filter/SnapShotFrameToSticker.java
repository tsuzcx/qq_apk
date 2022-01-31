package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
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
    if (this.mCopyFilter != null) {
      this.mCopyFilter.ClearGLSL();
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
  
  public void updateTexture(List<VideoFilterBase> paramList, Frame paramFrame, PTDetectInfo paramPTDetectInfo)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      Object localObject;
      if (paramList.hasNext())
      {
        localObject = (VideoFilterBase)paramList.next();
        if (!(localObject instanceof SnapShotFilter)) {
          continue;
        }
        localObject = (SnapShotFilter)localObject;
        if (((SnapShotFilter)localObject).getStickerItem().stickerType == VideoFilterFactory.STICKER_TYPE.SNAP_SHOT.type)
        {
          if (((SnapShotFilter)localObject).getTriggerStatus(paramPTDetectInfo) == TRIGGERED_STATUS.NOT_TRIGGERED) {
            ((SnapShotFilter)localObject).setHasSnapShot(false);
          }
          if ((((SnapShotFilter)localObject).getStickerItem().snapshotTime == VideoFilterFactory.SNAP_SHOT_TIME.NO_STICKER.type) && (((SnapShotFilter)localObject).isCurrentFrameTriggered(paramPTDetectInfo)) && (((SnapShotFilter)localObject).getTriggerStatus(paramPTDetectInfo) != TRIGGERED_STATUS.NOT_TRIGGERED) && (!((SnapShotFilter)localObject).isHasSnapShot()))
          {
            frameToSticker((SnapShotFilter)localObject, paramFrame);
            ((SnapShotFilter)localObject).setHasSnapShot(true);
            ((SnapShotFilter)localObject).setAlpha();
          }
        }
      }
      else
      {
        return;
      }
      if (((SnapShotFilter)localObject).getStickerItem().type == VideoFilterFactory.POSITION_TYPE.TRANSPARENT.type) {
        frameToStickerTexture((SnapShotFilter)localObject, paramFrame);
      }
    }
  }
  
  public void updateTextureWithSticker(List<VideoFilterBase> paramList, Frame paramFrame, PTDetectInfo paramPTDetectInfo)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      Object localObject;
      if (paramList.hasNext())
      {
        localObject = (VideoFilterBase)paramList.next();
        if (!(localObject instanceof SnapShotFilter)) {
          continue;
        }
        localObject = (SnapShotFilter)localObject;
        if (((SnapShotFilter)localObject).getStickerItem().stickerType == VideoFilterFactory.STICKER_TYPE.SNAP_SHOT.type)
        {
          if (((SnapShotFilter)localObject).getTriggerStatus(paramPTDetectInfo) == TRIGGERED_STATUS.NOT_TRIGGERED) {
            ((SnapShotFilter)localObject).setHasSnapShot(false);
          }
          if ((((SnapShotFilter)localObject).getStickerItem().snapshotTime == VideoFilterFactory.SNAP_SHOT_TIME.STICKER.type) && (((SnapShotFilter)localObject).isCurrentFrameTriggered(paramPTDetectInfo)) && (((SnapShotFilter)localObject).getTriggerStatus(paramPTDetectInfo) != TRIGGERED_STATUS.NOT_TRIGGERED) && (!((SnapShotFilter)localObject).isHasSnapShot()))
          {
            frameToSticker((SnapShotFilter)localObject, paramFrame);
            ((SnapShotFilter)localObject).setHasSnapShot(true);
            ((SnapShotFilter)localObject).setAlpha();
          }
        }
      }
      else
      {
        return;
      }
      if (((SnapShotFilter)localObject).getStickerItem().type == VideoFilterFactory.POSITION_TYPE.TRANSPARENT.type) {
        frameToStickerTexture((SnapShotFilter)localObject, paramFrame);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.SnapShotFrameToSticker
 * JD-Core Version:    0.7.0.1
 */