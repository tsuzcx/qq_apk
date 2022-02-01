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
    if ((this.mUKYOApple == null) || (this.mUKYOTachi == null)) {}
    while ((this.triggerCtrlItem != null) && (!this.triggerCtrlItem.isTriggered())) {
      return paramFrame;
    }
    boolean bool = GlUtil.curBlendModeEnabled;
    GlUtil.setBlendMode(true);
    paramFrame = this.mUKYOTachi.RenderProcess(paramFrame);
    paramFrame = this.mUKYOApple.RenderProcess(paramFrame);
    paramFrame = this.mUKYOScore.RenderProcess(paramFrame);
    this.mUKYOTachi.checkAppStatus(this.mUKYOApple.getAppleStauts());
    GlUtil.setBlendMode(bool);
    return paramFrame;
  }
  
  public Frame RenderProcessForFilter(Frame paramFrame1, Frame paramFrame2, VideoFilterBase paramVideoFilterBase)
  {
    if ((this.copyFrame[0] == null) || (this.copyFrame[1] == null)) {
      return paramFrame1;
    }
    Frame localFrame2;
    Frame localFrame1;
    if (paramFrame1.getTextureId() == this.copyFrame[0].getTextureId())
    {
      localFrame2 = this.copyFrame[1];
      localFrame1 = paramFrame2;
      if (paramFrame2 == null) {
        localFrame1 = paramFrame1;
      }
      GLES20.glBindFramebuffer(36160, localFrame1.getFBO());
      GLES20.glViewport(0, 0, localFrame1.width, localFrame1.height);
      boolean bool = VideoFilterUtil.hasBlendMode(paramVideoFilterBase);
      if ((VideoFilterUtil.canUseBlendMode(paramVideoFilterBase)) && ((!this.directDraw) || (!bool))) {
        break label220;
      }
      if (!VideoFilterUtil.needCopy(paramVideoFilterBase)) {
        break label247;
      }
      GlUtil.setBlendMode(false);
      paramFrame2 = FrameUtil.renderProcessBySwitchFbo(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, this.mCopyFilter, paramFrame1, localFrame2);
      GlUtil.setBlendMode(true);
    }
    for (;;)
    {
      if ((VideoFilterUtil.maybeTransformFilter(paramVideoFilterBase)) && (VideoMaterial.needCopyTransform())) {
        paramFrame1 = VideoFrameUtil.renderProcessByCopy(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height, paramVideoFilterBase, this.mCopyFilter, paramFrame1, localFrame2);
      }
      for (;;)
      {
        this.directDraw = true;
        return paramFrame1;
        localFrame2 = this.copyFrame[0];
        break;
        paramFrame1 = VideoFrameUtil.renderProcessBySwitchFbo(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height, paramVideoFilterBase, paramFrame1, localFrame2);
        continue;
        label220:
        paramVideoFilterBase.OnDrawFrameGLSL();
        paramVideoFilterBase.renderTexture(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height);
        paramFrame1 = localFrame1;
      }
      label247:
      paramFrame2 = paramFrame1;
    }
  }
  
  public void apply()
  {
    if (this.mUKYOTachi != null) {
      this.mUKYOTachi.apply();
    }
    if (this.mUKYOApple != null) {
      this.mUKYOApple.apply();
    }
    if (this.mUKYOScore != null) {
      this.mUKYOScore.apply();
    }
    this.mCopyFilter.apply();
    int i = 0;
    while (i < this.copyFrame.length)
    {
      this.copyFrame[i] = new Frame();
      i += 1;
    }
  }
  
  public void clear()
  {
    if (this.mUKYOTachi != null) {
      this.mUKYOTachi.clear();
    }
    if (this.mUKYOApple != null) {
      this.mUKYOApple.clear();
    }
    if (this.mUKYOScore != null) {
      this.mUKYOScore.clear();
    }
    if (this.mCopyFilter != null) {
      this.mCopyFilter.clearGLSL();
    }
    int i = 0;
    while (i < this.copyFrame.length)
    {
      if (this.copyFrame[i] != null) {
        this.copyFrame[i].clear();
      }
      i += 1;
    }
  }
  
  public void reset()
  {
    if (this.mUKYOApple != null) {
      this.mUKYOApple.reset();
    }
    if (this.mUKYOTachi != null) {
      this.mUKYOTachi.reset();
    }
    if (this.mUKYOScore != null) {
      this.mUKYOScore.reset();
    }
    this.mIsPlaying = true;
  }
  
  public void setApple(UKYOApple paramUKYOApple)
  {
    this.mUKYOApple = paramUKYOApple;
    this.mUKYOApple.setListener(this.listener);
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.mUKYOTachi != null) {
      this.mUKYOTachi.setRenderMode(paramInt);
    }
    if (this.mUKYOApple != null) {
      this.mUKYOApple.setRenderMode(paramInt);
    }
    if (this.mUKYOScore != null) {
      this.mUKYOScore.setRenderMode(paramInt);
    }
  }
  
  public void setRole(UKYOTachi paramUKYOTachi)
  {
    this.mUKYOTachi = paramUKYOTachi;
    this.mUKYOTachi.setListener(this.listener);
  }
  
  public void setScore(UKYOScore paramUKYOScore)
  {
    this.mUKYOScore = paramUKYOScore;
    this.mUKYOScore.setListener(this.listener);
  }
  
  public void updatePreview(Object paramObject)
  {
    int i = 0;
    if (this.mUKYOTachi != null) {
      this.mUKYOTachi.updatePreview(paramObject);
    }
    int j;
    if (this.mUKYOApple != null)
    {
      this.mUKYOApple.updatePreview(paramObject);
      j = this.mUKYOApple.getHittingScore();
      i = this.mUKYOApple.getComboScore();
      this.mIsPlaying = this.mUKYOApple.isPlaying();
    }
    for (;;)
    {
      UKYOScore localUKYOScore;
      if (this.mUKYOScore != null)
      {
        this.mUKYOScore.updatePlayingState(this.mIsPlaying);
        this.mUKYOScore.updateScore(j);
        localUKYOScore = this.mUKYOScore;
        if (!this.mIsPlaying) {
          break label113;
        }
      }
      for (;;)
      {
        localUKYOScore.updateCombo(i);
        this.mUKYOScore.updatePreview(paramObject);
        return;
        label113:
        i = this.mUKYOScore.getMaxComboCount();
      }
      j = 0;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.mUKYOApple != null) {
      this.mUKYOApple.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mUKYOTachi != null) {
      this.mUKYOTachi.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mUKYOScore != null) {
      this.mUKYOScore.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOGame
 * JD-Core Version:    0.7.0.1
 */