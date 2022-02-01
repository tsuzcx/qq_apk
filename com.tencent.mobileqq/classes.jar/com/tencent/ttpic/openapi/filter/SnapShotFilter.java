package com.tencent.ttpic.openapi.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.ttpic.openapi.model.StickerItem;

public class SnapShotFilter
  extends StaticStickerFilter
{
  private int count = 0;
  private boolean hasSnapShot = false;
  private Frame mFrame;
  
  public SnapShotFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  public void clear()
  {
    if (this.mFrame != null)
    {
      this.mFrame.setCanUnlock(true);
      this.mFrame.unlock();
    }
  }
  
  public float getAlpha()
  {
    return this.item.alpha;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public Frame getFrame(int paramInt1, int paramInt2)
  {
    if (this.mFrame == null) {
      this.mFrame = FrameBufferCache.getInstance().get(paramInt1, paramInt2);
    }
    this.mFrame.setCanUnlock(false);
    return this.mFrame;
  }
  
  public boolean isHasSnapShot()
  {
    return this.hasSnapShot;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glEnable(3042);
    GLES20.glBlendFuncSeparate(770, 771, 1, 1);
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void setAlpha()
  {
    addParam(new UniformParam.FloatParam("alpha", getAlpha()));
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setHasSnapShot(boolean paramBoolean)
  {
    this.hasSnapShot = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.SnapShotFilter
 * JD-Core Version:    0.7.0.1
 */