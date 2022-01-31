package com.tencent.ttpic.filter;

import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AudioUtils;
import com.tencent.ttpic.util.AudioUtils.Player;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.io.File;
import java.util.Map;

public class FabbyMvFilters
{
  public static final int CURRNET = 1;
  public static final int LAST = 2;
  public static final int NONE = 0;
  public StaticStickerFilter bgFilter;
  public StaticStickerFilter coverFilter;
  public StaticStickerFilter fgFilter;
  public BaseFilter filter;
  private GridEffectFilter gridEffectFilter = new GridEffectFilter();
  private boolean isRestarted = false;
  private long lastTriggerTime;
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  private Frame[] mCopyFrame = new Frame[2];
  private AudioUtils.Player mPlayer;
  private Frame mRotateFrame = new Frame();
  private Frame mScaleFrame = new Frame();
  public FabbyMvPart mvPart;
  private boolean needRestart = true;
  private RotateFilter rotateFilter = new RotateFilter();
  private ScaleFilter scaleFilter = new ScaleFilter();
  private long startTimeStamp = -1L;
  
  private void goNextPart(Map<Integer, FaceActionCounter> paramMap, int paramInt)
  {
    paramMap = (FaceActionCounter)paramMap.get(Integer.valueOf(VideoMaterialUtil.TRIGGER_TYPE.FABBY_PART.value));
    if ((paramMap != null) && (this.mvPart.partIndex == paramMap.count % paramInt))
    {
      paramMap.count += 1;
      paramMap.updateTime = (System.currentTimeMillis() + this.mvPart.transitionDuration);
    }
    if (this.mvPart.singlePart) {
      reset();
    }
  }
  
  private void playAudio(int paramInt, String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!TextUtils.isEmpty(this.mvPart.audio))
    {
      if (paramInt != 1) {
        break label154;
      }
      if (this.mPlayer == null)
      {
        paramString = paramString + File.separator + this.mvPart.audio;
        if (!paramString.startsWith("assets://")) {
          break label115;
        }
        this.mPlayer = AudioUtils.createPlayerFromAssets(VideoGlobalContext.getContext(), paramString.replace("assets://", ""), false);
      }
      if (!VideoPrefsUtil.getMaterialMute()) {
        break label130;
      }
      AudioUtils.stopPlayer(this.mPlayer);
      label102:
      if (this.needRestart) {
        break label149;
      }
    }
    for (;;)
    {
      this.isRestarted = bool1;
      return;
      label115:
      this.mPlayer = AudioUtils.createPlayerFromUri(VideoGlobalContext.getContext(), paramString, false);
      break;
      label130:
      AudioUtils.startPlayer(this.mPlayer, this.needRestart);
      this.needRestart = false;
      break label102;
      label149:
      bool1 = false;
    }
    label154:
    this.needRestart = true;
    if (VideoPrefsUtil.getMaterialMute())
    {
      AudioUtils.stopPlayer(this.mPlayer);
      return;
    }
    paramString = this.mPlayer;
    bool1 = bool2;
    if (!this.isRestarted) {
      bool1 = true;
    }
    AudioUtils.startPlayer(paramString, bool1);
    this.isRestarted = true;
  }
  
  private Frame renderForStaticFilters(Frame paramFrame, StaticStickerFilter paramStaticStickerFilter, long paramLong)
  {
    paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
    if (paramStaticStickerFilter == null) {
      return paramFrame;
    }
    paramStaticStickerFilter.updateVideoSize(paramFrame.width, paramFrame.height, 0.0D);
    paramStaticStickerFilter.updateFabbyProgress(paramLong);
    Frame localFrame1 = paramFrame;
    Frame localFrame2;
    if (paramFrame.getTextureId() == this.mCopyFrame[0].getTextureId())
    {
      localFrame2 = this.mCopyFrame[1];
      localFrame1.bindFrame(-1, localFrame1.width, localFrame1.height, 0.0D);
      VideoFilterUtil.setBlendMode(true);
      if (VideoFilterUtil.canUseBlendMode(paramStaticStickerFilter)) {
        break label232;
      }
      Frame localFrame3 = localFrame1;
      if (VideoFileUtil.needCopy(paramStaticStickerFilter)) {
        localFrame3 = FrameUtil.renderProcessBySwitchFbo(localFrame1.getTextureId(), localFrame1.width, localFrame1.height, this.mCopyFilter, paramFrame, localFrame2);
      }
      BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + paramStaticStickerFilter.getClass().getName());
      localFrame1 = FrameUtil.renderProcessBySwitchFbo(localFrame3.getTextureId(), localFrame3.width, localFrame3.height, paramStaticStickerFilter, paramFrame, localFrame2);
      BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + paramStaticStickerFilter.getClass().getName());
    }
    for (;;)
    {
      VideoFilterUtil.setBlendMode(false);
      return localFrame1;
      localFrame2 = this.mCopyFrame[0];
      break;
      label232:
      BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
      paramStaticStickerFilter.OnDrawFrameGLSL();
      paramStaticStickerFilter.renderTexture(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
      BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
    }
  }
  
  private void reset()
  {
    resetFilter();
    this.needRestart = true;
    this.isRestarted = false;
    this.startTimeStamp = -1L;
  }
  
  public void ApplyGLSLFilter()
  {
    if (this.bgFilter != null) {
      this.bgFilter.ApplyGLSLFilter();
    }
    if (this.fgFilter != null) {
      this.fgFilter.ApplyGLSLFilter();
    }
    if (this.coverFilter != null) {
      this.coverFilter.ApplyGLSLFilter();
    }
    this.mCopyFilter.ApplyGLSLFilter();
    this.gridEffectFilter.ApplyGLSLFilter();
    this.scaleFilter.ApplyGLSLFilter();
    this.rotateFilter.ApplyGLSLFilter();
    int i = 0;
    while (i < this.mCopyFrame.length)
    {
      this.mCopyFrame[i] = new Frame();
      i += 1;
    }
  }
  
  public void clear()
  {
    if (this.bgFilter != null) {
      this.bgFilter.clearGLSLSelf();
    }
    if (this.fgFilter != null) {
      this.fgFilter.clearGLSLSelf();
    }
    if (this.coverFilter != null) {
      this.coverFilter.clearGLSLSelf();
    }
    if (this.filter != null) {
      this.filter.clearGLSLSelf();
    }
    this.mCopyFilter.clearGLSLSelf();
    Frame[] arrayOfFrame = this.mCopyFrame;
    int j = arrayOfFrame.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFrame[i].clear();
      i += 1;
    }
    this.gridEffectFilter.clearGLSLSelf();
    this.scaleFilter.clearGLSLSelf();
    this.rotateFilter.clearGLSLSelf();
    this.mScaleFrame.clear();
    this.mRotateFrame.clear();
  }
  
  public void destroyAudioPlayer()
  {
    if (this.mPlayer != null)
    {
      AudioUtils.destroyPlayer(this.mPlayer);
      this.mPlayer = null;
    }
  }
  
  public int getGridMode(long paramLong)
  {
    float f = (float)(paramLong - this.startTimeStamp) / (float)this.mvPart.duration;
    return this.mvPart.getGridMode(f);
  }
  
  public Frame renderBgFilter(Frame paramFrame, long paramLong)
  {
    return renderForStaticFilters(paramFrame, this.bgFilter, paramLong);
  }
  
  public Frame renderCoverFilter(Frame paramFrame, long paramLong)
  {
    return renderForStaticFilters(paramFrame, this.coverFilter, paramLong);
  }
  
  public Frame renderFgFilter(Frame paramFrame, long paramLong)
  {
    return renderForStaticFilters(paramFrame, this.fgFilter, paramLong);
  }
  
  public int renderState(Map<Integer, FaceActionCounter> paramMap, int paramInt, long paramLong, String paramString)
  {
    int i = 0;
    paramMap = (FaceActionCounter)paramMap.get(Integer.valueOf(VideoMaterialUtil.TRIGGER_TYPE.FABBY_PART.value));
    if (paramMap != null)
    {
      if (this.mvPart.partIndex != paramMap.count % paramInt) {
        break label70;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        this.startTimeStamp = -1L;
      }
      playAudio(i, paramString);
      return i;
      label70:
      if ((this.mvPart.partIndex == (paramMap.count - 1) % paramInt) && (paramMap.updateTime >= paramLong)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public void resetFilter()
  {
    if (this.bgFilter != null) {
      this.bgFilter.resetFabbyProgress();
    }
    if (this.fgFilter != null) {
      this.fgFilter.resetFabbyProgress();
    }
    if (this.coverFilter != null) {
      this.coverFilter.resetFabbyProgress();
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.bgFilter != null) {
      VideoFilterUtil.setRenderMode(this.bgFilter, paramInt);
    }
    if (this.fgFilter != null) {
      VideoFilterUtil.setRenderMode(this.fgFilter, paramInt);
    }
    if (this.coverFilter != null) {
      VideoFilterUtil.setRenderMode(this.coverFilter, paramInt);
    }
    if (this.filter != null) {
      VideoFilterUtil.setRenderMode(this.filter, paramInt);
    }
    VideoFilterUtil.setRenderMode(this.gridEffectFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.scaleFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.rotateFilter, paramInt);
  }
  
  public Frame updateAndRender(Frame paramFrame1, Frame paramFrame2, long paramLong)
  {
    if (this.startTimeStamp < 0L) {
      this.startTimeStamp = paramLong;
    }
    float f = (float)(paramLong - this.startTimeStamp) / (float)this.mvPart.duration;
    int i = this.mvPart.getGridType(f);
    double d = this.mvPart.getScale(f);
    int j = (int)this.mvPart.getDegree(f);
    this.gridEffectFilter.setGridType(i);
    this.scaleFilter.setScale((float)d);
    this.rotateFilter.setDegree(j);
    Frame localFrame = paramFrame2;
    paramFrame2 = localFrame;
    if (Math.abs(d - 1.0D) > 0.0001D)
    {
      this.scaleFilter.RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, -1, 0.0D, this.mScaleFrame);
      paramFrame2 = this.mScaleFrame;
    }
    localFrame = paramFrame2;
    if (j % 360 != 0)
    {
      FrameUtil.clearFrame(this.mRotateFrame, 0.0F, 0.0F, 0.0F, 0.0F);
      this.rotateFilter.RenderProcess(paramFrame2.getTextureId(), paramFrame2.width, paramFrame2.height, -1, 0.0D, this.mRotateFrame);
      localFrame = this.mRotateFrame;
    }
    paramFrame1.bindFrame(-1, paramFrame1.width, paramFrame1.height, 0.0D);
    VideoFilterUtil.setBlendMode(true);
    this.gridEffectFilter.OnDrawFrameGLSL();
    this.gridEffectFilter.renderTexture(localFrame.getTextureId(), localFrame.width, localFrame.height);
    VideoFilterUtil.setBlendMode(false);
    return paramFrame1;
  }
  
  public boolean updateProgress(long paramLong, Map<Integer, FaceActionCounter> paramMap, int paramInt)
  {
    if ((this.mvPart.transitionItem != null) && (this.mvPart.transitionItem.triggerType > 1))
    {
      if ((((FaceActionCounter)paramMap.get(Integer.valueOf(this.mvPart.transitionItem.triggerType))).count - 1) % paramInt == this.mvPart.partIndex) {}
      for (bool = true;; bool = false)
      {
        if (bool)
        {
          goNextPart(paramMap, paramInt);
          this.lastTriggerTime = paramLong;
        }
        return bool;
      }
    }
    if (paramLong - this.startTimeStamp > this.mvPart.duration) {}
    for (boolean bool = true;; bool = false) {
      break;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.bgFilter != null) {
      this.bgFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.fgFilter != null) {
      this.fgFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.coverFilter != null) {
      this.coverFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyMvFilters
 * JD-Core Version:    0.7.0.1
 */