package com.tencent.ttpic.filter.juyoujinggame;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.filter.RenderItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFrameUtil;

public class UKYOGame
  extends RenderItem
{
  private Frame[] copyFrame = new Frame[2];
  boolean directDraw;
  UKYOGame.RenderListener listener = new UKYOGame.1(this);
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private boolean mIsPlaying = true;
  private UKYOApple mUKYOApple;
  private UKYOScore mUKYOScore;
  private UKYOTachi mUKYOTachi;
  
  public UKYOGame()
  {
    super(null, null);
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.mUKYOApple != null)
    {
      if (this.mUKYOTachi == null) {
        return paramFrame;
      }
      if (this.triggerCtrlItem != null)
      {
        localFrame = paramFrame;
        if (!this.triggerCtrlItem.isTriggered()) {}
      }
      else
      {
        boolean bool = GlUtil.curBlendModeEnabled;
        GlUtil.setBlendMode(true);
        paramFrame = this.mUKYOTachi.RenderProcess(paramFrame);
        paramFrame = this.mUKYOApple.RenderProcess(paramFrame);
        localFrame = this.mUKYOScore.RenderProcess(paramFrame);
        this.mUKYOTachi.checkAppStatus(this.mUKYOApple.getAppleStauts());
        GlUtil.setBlendMode(bool);
      }
    }
    return localFrame;
  }
  
  public Frame RenderProcessForFilter(Frame paramFrame1, Frame paramFrame2, VideoFilterBase paramVideoFilterBase)
  {
    Object localObject = this.copyFrame;
    if (localObject[0] != null)
    {
      if (localObject[1] == null) {
        return paramFrame1;
      }
      Frame localFrame;
      if (paramFrame1.getTextureId() == this.copyFrame[0].getTextureId()) {
        localFrame = this.copyFrame[1];
      } else {
        localFrame = this.copyFrame[0];
      }
      localObject = paramFrame2;
      if (paramFrame2 == null) {
        localObject = paramFrame1;
      }
      GLES20.glBindFramebuffer(36160, ((Frame)localObject).getFBO());
      GLES20.glViewport(0, 0, ((Frame)localObject).width, ((Frame)localObject).height);
      boolean bool = VideoFilterUtil.hasBlendMode(paramVideoFilterBase);
      if ((VideoFilterUtil.canUseBlendMode(paramVideoFilterBase)) && ((!this.directDraw) || (!bool)))
      {
        paramVideoFilterBase.OnDrawFrameGLSL();
        paramVideoFilterBase.renderTexture(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height);
        paramFrame1 = (Frame)localObject;
      }
      else
      {
        if (VideoFilterUtil.needCopy(paramVideoFilterBase))
        {
          GlUtil.setBlendMode(false);
          paramFrame2 = FrameUtil.renderProcessBySwitchFbo(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, this.mCopyFilter, paramFrame1, localFrame);
          GlUtil.setBlendMode(true);
        }
        else
        {
          paramFrame2 = paramFrame1;
        }
        if ((VideoFilterUtil.maybeTransformFilter(paramVideoFilterBase)) && (VideoMaterial.needCopyTransform())) {
          paramFrame1 = VideoFrameUtil.renderProcessByCopy(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height, paramVideoFilterBase, this.mCopyFilter, paramFrame1, localFrame);
        } else {
          paramFrame1 = VideoFrameUtil.renderProcessBySwitchFbo(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height, paramVideoFilterBase, paramFrame1, localFrame);
        }
      }
      this.directDraw = true;
      return paramFrame1;
    }
    return paramFrame1;
  }
  
  public void apply()
  {
    Object localObject = this.mUKYOTachi;
    if (localObject != null) {
      ((UKYOTachi)localObject).apply();
    }
    localObject = this.mUKYOApple;
    if (localObject != null) {
      ((UKYOApple)localObject).apply();
    }
    localObject = this.mUKYOScore;
    if (localObject != null) {
      ((UKYOScore)localObject).apply();
    }
    this.mCopyFilter.apply();
    int i = 0;
    for (;;)
    {
      localObject = this.copyFrame;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = new Frame();
      i += 1;
    }
  }
  
  public void clear()
  {
    Object localObject = this.mUKYOTachi;
    if (localObject != null) {
      ((UKYOTachi)localObject).clear();
    }
    localObject = this.mUKYOApple;
    if (localObject != null) {
      ((UKYOApple)localObject).clear();
    }
    localObject = this.mUKYOScore;
    if (localObject != null) {
      ((UKYOScore)localObject).clear();
    }
    localObject = this.mCopyFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).clearGLSL();
    }
    int i = 0;
    for (;;)
    {
      localObject = this.copyFrame;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i] != null) {
        localObject[i].clear();
      }
      i += 1;
    }
  }
  
  public void reset()
  {
    Object localObject = this.mUKYOApple;
    if (localObject != null) {
      ((UKYOApple)localObject).reset();
    }
    localObject = this.mUKYOTachi;
    if (localObject != null) {
      ((UKYOTachi)localObject).reset();
    }
    localObject = this.mUKYOScore;
    if (localObject != null) {
      ((UKYOScore)localObject).reset();
    }
    this.mIsPlaying = true;
  }
  
  public void setRenderMode(int paramInt)
  {
    Object localObject = this.mUKYOTachi;
    if (localObject != null) {
      ((UKYOTachi)localObject).setRenderMode(paramInt);
    }
    localObject = this.mUKYOApple;
    if (localObject != null) {
      ((UKYOApple)localObject).setRenderMode(paramInt);
    }
    localObject = this.mUKYOScore;
    if (localObject != null) {
      ((UKYOScore)localObject).setRenderMode(paramInt);
    }
  }
  
  public void setScore(UKYOScore paramUKYOScore)
  {
    this.mUKYOScore = paramUKYOScore;
    this.mUKYOScore.setListener(this.listener);
  }
  
  public void updatePreview(Object paramObject)
  {
    Object localObject = this.mUKYOTachi;
    if (localObject != null) {
      ((UKYOTachi)localObject).updatePreview(paramObject);
    }
    localObject = this.mUKYOApple;
    int j = 0;
    int i;
    if (localObject != null)
    {
      ((UKYOApple)localObject).updatePreview(paramObject);
      j = this.mUKYOApple.getHittingScore();
      i = this.mUKYOApple.getComboScore();
      this.mIsPlaying = this.mUKYOApple.isPlaying();
    }
    else
    {
      i = 0;
    }
    localObject = this.mUKYOScore;
    if (localObject != null)
    {
      ((UKYOScore)localObject).updatePlayingState(this.mIsPlaying);
      this.mUKYOScore.updateScore(j);
      localObject = this.mUKYOScore;
      if (!this.mIsPlaying) {
        i = ((UKYOScore)localObject).getMaxComboCount();
      }
      ((UKYOScore)localObject).updateCombo(i);
      this.mUKYOScore.updatePreview(paramObject);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    Object localObject = this.mUKYOApple;
    if (localObject != null) {
      ((UKYOApple)localObject).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localObject = this.mUKYOTachi;
    if (localObject != null) {
      ((UKYOTachi)localObject).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    localObject = this.mUKYOScore;
    if (localObject != null) {
      ((UKYOScore)localObject).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOGame
 * JD-Core Version:    0.7.0.1
 */