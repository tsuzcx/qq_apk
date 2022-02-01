package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.dancemachine.GLMaskImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLProgressBar;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.DancePosture;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GeneralResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ReadyResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ScanResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.StartResource;
import com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.filter.QQFaceDanceMechineFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.util.List;
import java.util.TreeSet;

public class DanceReadyFilter
  extends DanceBaseFilter
{
  private Animation bgAnim;
  private GLImageView bgImgView;
  private GLImageView bottomTextView;
  private boolean hasStartedProgress = false;
  private int height;
  private boolean isEnterReady = false;
  TreeSet<GLLittleBoy> littleTs = new TreeSet(new DanceReadyFilter.9(this));
  private GLLittleBoy mGlLittleBoy;
  private ResourceManager mResourceManager;
  private GLProgressBar mScanProgress;
  private final int mTotalProgress = 2000;
  private Animation numAnim;
  private int numP1Index = 3;
  private int numP2Index = 3;
  private long numProgTime = 0L;
  private GLImageView numberImgView;
  private GLImageView readyImgView;
  private Animation readyInAnim;
  private Animation readyOutAnim;
  private Animation recogAnim;
  private GLImageView recogImgView;
  private long recognizeComsume = 0L;
  private long recognizeStartTime = 0L;
  private Animation scanAnim;
  private int scanHeight;
  private GLMaskImageView scanImgView;
  private Animation startAnim;
  private GLImageView startImgView;
  private boolean startProgressAnim = false;
  private GLImageView topTextView;
  
  public DanceReadyFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private void clearRecognizeData()
  {
    this.recognizeComsume = 0L;
    this.recognizeStartTime = 0L;
  }
  
  private void drawProgressAnim(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.numProgTime > 0L) && (this.numProgTime < l) && (paramInt > 0))
    {
      l -= this.numProgTime;
      if (l <= paramInt) {
        break label57;
      }
      this.mScanProgress.setProgress(paramInt);
    }
    for (;;)
    {
      this.mScanProgress.draw();
      return;
      label57:
      this.mScanProgress.setProgress(l);
    }
  }
  
  private void setReadyBoy()
  {
    ResourceManager.DancePosture localDancePosture = new ResourceManager.DancePosture();
    if (QmcfManager.getInstance().getCurrQmcfMode() == 2) {
      localDancePosture.id = "C";
    }
    for (;;)
    {
      this.mGlLittleBoy.setFrameAnimationParams(localDancePosture);
      this.mGlLittleBoy.resetValidBoyStatus();
      this.mGlLittleBoy.setMaxMatchTimes(2, true);
      return;
      if (QQFaceDanceMechineFilter.isEnableFaceDance)
      {
        localDancePosture.id = "F";
        this.mGlLittleBoy.isReadyMatch = true;
      }
    }
  }
  
  private Animation setupBgAnim()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  private Animation setupNumAnim()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new DanceReadyFilter.2(this));
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(600L);
    ((Animation)localObject).setStartOffset(100L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setDuration(600L);
    ((Animation)localObject).setStartOffset(100L);
    ((Animation)localObject).setAnimationListener(new DanceReadyFilter.3(this));
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setStartOffset(700L);
    return localAnimationSet;
  }
  
  private Animation setupReadyAnim(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(300L);
      localScaleAnimation.setStartOffset(300L);
      localScaleAnimation.setFillEnabled(true);
      localScaleAnimation.setFillAfter(true);
      localScaleAnimation.setAnimationListener(new DanceReadyFilter.6(this));
      return localScaleAnimation;
    }
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setFillEnabled(true);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new DanceReadyFilter.7(this));
    return localScaleAnimation;
  }
  
  private Animation setupRecogAnim()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new DanceReadyFilter.8(this));
    localAlphaAnimation.setStartOffset(100L);
    return localAlphaAnimation;
  }
  
  private Animation setupScanAnim(int paramInt1, int paramInt2)
  {
    float f = this.mDanceManager.getContext().getViewPortRatio();
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -paramInt1 * f, f * paramInt2);
    localTranslateAnimation.setDuration(2000L);
    localTranslateAnimation.setRepeatCount(-1);
    return localTranslateAnimation;
  }
  
  private Animation setupStartAnim()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new AlphaAnimation(1.0F, 1.0F);
    ((Animation)localObject).setDuration(300L);
    ((Animation)localObject).setAnimationListener(new DanceReadyFilter.4(this));
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setStartOffset(300L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 1.04F, 1.0F, 1.04F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(450L);
    ((Animation)localObject).setStartOffset(500L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 1.29F, 1.0F, 1.29F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(150L);
    ((Animation)localObject).setStartOffset(950L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.6F);
    ((Animation)localObject).setDuration(150L);
    ((Animation)localObject).setStartOffset(950L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 0.13F, 1.0F, 1.29F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setStartOffset(1100L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.5F);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setStartOffset(1100L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 10.5F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setStartOffset(1200L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setStartOffset(1200L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setStartOffset(300L);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new DanceReadyFilter.5(this));
    localAnimationSet.setStartOffset(300L);
    return localAnimationSet;
  }
  
  private void startProgressAnim()
  {
    this.numProgTime = SystemClock.elapsedRealtime();
    this.startProgressAnim = true;
  }
  
  public TreeSet<GLLittleBoy> getCurrentVisible()
  {
    if (this.mGlLittleBoy == null) {
      return super.getCurrentVisible();
    }
    this.littleTs.clear();
    this.littleTs.add(this.mGlLittleBoy);
    return this.littleTs;
  }
  
  public boolean getFilterParam()
  {
    return this.isEnterReady;
  }
  
  public void onCloseClicked()
  {
    DanceLog.print("DanceReadyFilter", "onCloseClicked begin...");
    this.mDanceManager.getContext().stopAllSound();
    this.mDanceManager.selectToFilter(0);
    DanceLog.print("DanceReadyFilter", "onCloseClicked end...");
  }
  
  public void onDrawFrame()
  {
    super.onDrawFrame();
    if ((this.mGlLittleBoy.isMatched()) && (!this.hasStartedProgress))
    {
      this.recognizeComsume = (System.currentTimeMillis() - this.recognizeStartTime);
      startProgressAnim();
      this.hasStartedProgress = true;
    }
    this.scanImgView.draw();
    this.recogImgView.draw();
    this.topTextView.draw();
    this.bottomTextView.draw();
    if (this.startProgressAnim) {
      drawProgressAnim(2000);
    }
    this.bgImgView.draw();
    this.readyImgView.draw();
    this.numberImgView.draw();
    this.startImgView.draw();
    TrAsyncTextureLoad.getInstance().updateGLFrameImageCache();
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    Object localObject1 = this.mDanceManager.getContext().getSurfaceViewSize();
    paramInt1 = ((Rect)localObject1).width();
    paramInt2 = ((Rect)localObject1).height();
    Object localObject2 = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    label108:
    int i;
    int j;
    double d1;
    label473:
    label504:
    int k;
    int m;
    if (QQFaceDanceMechineFilter.isEnableFaceDance)
    {
      localObject1 = this.mResourceManager.mScanResource.facerecognizePic;
      this.recogImgView.setImageRes((String)localObject1);
      this.recogImgView.setImageRegion((RectF)localObject2);
      this.recogImgView.setImageClipDrawRegion((RectF)localObject2);
      if (!QQFaceDanceMechineFilter.isEnableFaceDance) {
        break label1141;
      }
      localObject1 = this.mResourceManager.mScanResource.facemaskPic;
      this.scanImgView.setMaskImage((String)localObject1);
      this.scanImgView.setImageRes(this.mResourceManager.mScanResource.scanPic);
      if (this.scanImgView.getCurrentBackGround().getHeight() != 0)
      {
        i = (int)(this.scanImgView.getCurrentBackGround().getHeight() / this.scanImgView.getCurrentBackGround().getWidth() * paramInt1);
        localObject1 = new RectF(0.0F, -i, paramInt1, 0.0F);
        this.scanImgView.setImageRegion((RectF)localObject1);
        this.scanImgView.setImageClipDrawRegion((RectF)localObject1);
        this.scanImgView.setVisibility(true);
        this.scanHeight = i;
        this.height = paramInt2;
      }
      i = paramInt1 - DisplayUtils.pixelToRealPixel(215.0F) * 2;
      j = (paramInt2 - i) / 2;
      localObject1 = new RectF(DisplayUtils.pixelToRealPixel(215.0F), j, paramInt1 - DisplayUtils.pixelToRealPixel(215.0F), i + j);
      this.numberImgView.setImageRes((String)this.mResourceManager.mReadyResource.readyNums.get(2));
      this.numberImgView.setImageRegion((RectF)localObject1);
      this.numberImgView.setImageClipDrawRegion((RectF)localObject1);
      localObject1 = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
      this.bgImgView.setImageRes(this.mResourceManager.mGeneralResource.bgPic);
      this.bgImgView.setImageRegion((RectF)localObject1);
      this.bgImgView.setImageClipDrawRegion((RectF)localObject1);
      localObject1 = new RectF(DisplayUtils.pixelToRealPixel(92.0F), DisplayUtils.pixelToRealPixel(0.0F), paramInt1 - DisplayUtils.pixelToRealPixel(92.0F), DisplayUtils.pixelToRealPixel(300.0F));
      this.readyImgView.setImageRes(this.mResourceManager.mReadyResource.ready);
      this.readyImgView.setImageRegion((RectF)localObject1);
      this.readyImgView.setImageClipDrawRegion((RectF)localObject1);
      i = (int)(paramInt2 * 0.1D);
      double d2 = paramInt2;
      if (!QQFaceDanceMechineFilter.isEnableFaceDance) {
        break label1156;
      }
      d1 = 0.04D;
      j = (int)(d1 * d2);
      localObject2 = this.topTextView;
      if (!QQFaceDanceMechineFilter.isEnableFaceDance) {
        break label1163;
      }
      localObject1 = this.mResourceManager.mScanResource.facetopText;
      ((GLImageView)localObject2).setImageRes((String)localObject1);
      k = this.topTextView.getCurrentBackGround().getHeight();
      m = this.topTextView.getCurrentBackGround().getWidth();
      d1 = k / m;
      if (!Double.isNaN(d1))
      {
        k = (int)(j / d1);
        m = (paramInt1 - k) / 2;
        localObject1 = new RectF(m, i, k + m, j + i);
        this.topTextView.setImageRegion((RectF)localObject1);
        this.topTextView.setImageClipDrawRegion((RectF)localObject1);
      }
      i = (int)(paramInt2 * 0.9D);
      j = (int)(paramInt2 * 0.03D);
      localObject2 = this.bottomTextView;
      if (!QQFaceDanceMechineFilter.isEnableFaceDance) {
        break label1178;
      }
    }
    label1156:
    label1163:
    label1178:
    for (localObject1 = this.mResourceManager.mScanResource.facebottomText;; localObject1 = this.mResourceManager.mScanResource.bottomText)
    {
      ((GLImageView)localObject2).setImageRes((String)localObject1);
      k = this.bottomTextView.getCurrentBackGround().getHeight();
      m = this.bottomTextView.getCurrentBackGround().getWidth();
      d1 = k / m;
      if (!Double.isNaN(d1))
      {
        k = (int)(j / d1);
        m = (paramInt1 - k) / 2;
        localObject1 = new RectF(m, i, k + m, i + j);
        this.bottomTextView.setImageRegion((RectF)localObject1);
        this.bottomTextView.setImageClipDrawRegion((RectF)localObject1);
      }
      i = paramInt1 - DisplayUtils.pixelToRealPixel(7.0F) * 2;
      this.startImgView.setImageRes(this.mResourceManager.mStartResource.startPic);
      j = this.startImgView.getCurrentBackGround().getHeight();
      k = this.startImgView.getCurrentBackGround().getWidth();
      j = (int)(j / k * i);
      k = (paramInt2 - j) / 2;
      localObject1 = new RectF(DisplayUtils.pixelToRealPixel(7.0F), k, i + DisplayUtils.pixelToRealPixel(7.0F), j + k);
      this.startImgView.setImageRegion((RectF)localObject1);
      this.startImgView.setImageClipDrawRegion((RectF)localObject1);
      paramInt2 = (int)(paramInt2 * 0.85D);
      float f1 = DisplayUtils.pixelToRealPixel(14.0F);
      localObject1 = new RectF(DisplayUtils.pixelToRealPixel(128.0F), paramInt2, paramInt1 - DisplayUtils.pixelToRealPixel(128.0F), paramInt2 + f1);
      this.mScanProgress.setBackgroundRegion((RectF)localObject1);
      this.mScanProgress.setBackgroundClipRegion((RectF)localObject1);
      this.mScanProgress.setBackgroundImageRes(this.mResourceManager.mScanResource.scanBg);
      this.mScanProgress.setProgressImageRes(this.mResourceManager.mScanResource.scanContent);
      paramInt1 = DisplayUtils.pixelToRealPixel(8.0F);
      i = this.mScanProgress.getProgressImage().getWidth();
      float f2 = 14.0F / this.mScanProgress.getProgressImage().getHeight();
      i = DisplayUtils.pixelToRealPixel((int)(i * f2));
      localObject1 = new RectF(DisplayUtils.pixelToRealPixel(128.0F), paramInt2, DisplayUtils.pixelToRealPixel(128.0F) + i, paramInt2 + f1);
      this.mScanProgress.setProgressRegion((RectF)localObject1);
      this.mScanProgress.setProgressStretchRelativeRegion(paramInt1, i - paramInt1);
      this.mScanProgress.setMaxProgress(2000);
      this.mScanProgress.setProgress(0L);
      this.mScanProgress.setProgressBarListener(new DanceReadyFilter.1(this));
      return;
      localObject1 = this.mResourceManager.mScanResource.recognizePic;
      break;
      label1141:
      localObject1 = this.mResourceManager.mScanResource.maskPic;
      break label108;
      d1 = 0.08D;
      break label473;
      localObject1 = this.mResourceManager.mScanResource.topText;
      break label504;
    }
  }
  
  public void onSurfaceCreate()
  {
    super.onSurfaceCreate();
    this.mResourceManager = ResourceManager.getInstance();
    this.recogImgView = new GLImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.bgImgView = new GLImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.readyImgView = new GLImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.startImgView = new GLImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.numberImgView = new GLImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.scanImgView = new GLMaskImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_MASK_GL_VIEW_FRAGMENT_MASK");
    this.mGlLittleBoy = new GLLittleBoy(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.mScanProgress = new GLProgressBar(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.topTextView = new GLImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.bottomTextView = new GLImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    setReadyBoy();
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    clearRecognizeData();
  }
  
  public void rollbackStatusCallOnInitFilter()
  {
    if (this.mGlLittleBoy != null) {
      this.mGlLittleBoy.resetValidBoyStatus();
    }
    this.isEnterReady = false;
    this.hasStartedProgress = false;
    this.mScanProgress.clearStatus();
    this.mScanProgress.setProgress(0L);
    this.startProgressAnim = false;
    this.readyImgView.clearAnimation();
    this.bgImgView.clearAnimation();
    this.recogImgView.clearAnimation();
    this.numberImgView.clearAnimation();
    this.startImgView.clearAnimation();
    this.scanImgView.clearAnimation();
    this.numP1Index = 3;
    this.numP2Index = 3;
    this.numProgTime = 0L;
    this.numberImgView.setVisibility(false);
    this.readyImgView.setVisibility(false);
    this.bgImgView.setVisibility(false);
    this.startImgView.setVisibility(false);
    this.recogImgView.setVisibility(true);
    this.scanImgView.setVisibility(true);
    this.topTextView.setVisibility(true);
    this.bottomTextView.setVisibility(true);
    this.mScanProgress.setVisibility(true);
    this.numAnim = setupNumAnim();
    this.startAnim = setupStartAnim();
    this.readyInAnim = setupReadyAnim(false);
    this.readyOutAnim = setupReadyAnim(true);
    this.bgAnim = setupBgAnim();
    this.recogAnim = setupRecogAnim();
    this.scanAnim = setupScanAnim(this.scanHeight, this.height);
    this.scanImgView.startAnimation(this.scanAnim);
    this.numberImgView.setImageRes((String)this.mResourceManager.mReadyResource.readyNums.get(2));
    this.recognizeStartTime = System.currentTimeMillis();
    DanceLog.print("DanceReadyFilter", "rollbackStatusCallOnInitFilter end...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter
 * JD-Core Version:    0.7.0.1
 */