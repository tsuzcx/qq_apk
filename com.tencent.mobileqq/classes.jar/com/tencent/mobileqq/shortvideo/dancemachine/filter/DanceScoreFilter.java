package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.GLFrameImage;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLScoreBoard;
import com.tencent.mobileqq.shortvideo.dancemachine.GLTextView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GameNumberResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ShareResource;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.util.List;
import java.util.Random;

public class DanceScoreFilter
  extends DanceBaseFilter
{
  private final int GAME_END_DELAY_TIME = 4000;
  private Animation bgAnim;
  private GLImageView bgView;
  private boolean mGamePlayEnd = false;
  private long mGamePlayEndTimestamp = 0L;
  private boolean mHaveCalledHandler = false;
  private Random mRandom = new Random();
  private ResourceManager mResourceManager = ResourceManager.getInstance();
  private boolean numAnimEnd = false;
  private long numAnimTime;
  private String overPercent = "";
  private GLTextView rankSys;
  private float rankSysBottom = 0.0F;
  private float rankSysTop = 0.0F;
  private Animation rateAnim;
  private GLImageView rateView;
  private Animation scoreAnim;
  private GLScoreBoard scoreBoardView;
  private String scoreRate;
  private GLImageView scoreView;
  private int shareHeight;
  private int shareY;
  private boolean startNumAnim = false;
  
  public DanceScoreFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private void drawNumAnim(int paramInt1, int paramInt2)
  {
    float f2 = 99.599998F;
    float f3 = 0.0F;
    long l = SystemClock.elapsedRealtime();
    float f1;
    if ((this.numAnimTime > 0L) && (this.numAnimTime < l) && (paramInt1 > 0))
    {
      l -= this.numAnimTime;
      if (l <= paramInt1) {
        break label321;
      }
      if (!this.numAnimEnd)
      {
        this.numAnimEnd = true;
        this.rateView.setVisibility(true);
        this.rateView.startAnimation(this.rateAnim);
        paramInt1 = ResourceManager.getInstance().getDancePostures().size();
        float f5 = paramInt2 * 1.0F / (paramInt1 * 50);
        this.mRandom.setSeed(System.nanoTime());
        float f4 = this.mRandom.nextInt(10) + 100.0F * f5 * 2.0F;
        f1 = f4;
        if (f4 > 97.0F)
        {
          this.mRandom.setSeed(System.nanoTime());
          f1 = (this.mRandom.nextFloat() - 0.14F) * 3.0F + 97.0F;
        }
        if (f5 != 0.0F) {
          break label346;
        }
        f1 = f3;
      }
    }
    label321:
    label346:
    for (;;)
    {
      f1 = (int)(f1 * 10.0F) / 10.0F;
      if (f1 > 99.599998F) {
        f1 = f2;
      }
      for (;;)
      {
        this.rankSys.clearTextCache();
        this.rankSys.setText("你的分数超过了", 7, -1);
        this.rankSys.setText("" + f1 + "%", 4, -18322);
        this.rankSys.setText("的用户", 3, -1);
        rankSystemComputeRegion();
        this.rankSys.setVisibility(true);
        this.overPercent = (f1 + "");
        this.scoreBoardView.setScore(paramInt2);
        for (;;)
        {
          this.scoreBoardView.draw();
          return;
          paramInt1 = (int)(paramInt2 * ((float)l / paramInt1));
          this.scoreBoardView.setScore(paramInt1);
        }
      }
    }
  }
  
  private void rankSystemComputeRegion()
  {
    Object localObject = this.mDanceManager.getContext().getSurfaceViewSize();
    int i = ((Rect)localObject).width();
    int j = ((Rect)localObject).height();
    localObject = new RectF(0.0F, 0.0F, i, j);
    float f2 = (i - this.rankSys.getTextWidth()) / 2.0F;
    float f1 = this.rankSysTop;
    float f3 = this.rankSysBottom - this.rankSysTop;
    if (f3 <= this.rankSys.getTextHeight()) {
      this.rankSys.setTextSize((int)f3);
    }
    for (;;)
    {
      ((RectF)localObject).set(f2, f1, i - f2, this.rankSys.getTextHeight() + f1);
      this.rankSys.setImageRegion((RectF)localObject);
      this.rankSys.setImageClipDrawRegion((RectF)localObject);
      return;
      f1 += (f3 - this.rankSys.getTextHeight()) / 2.0F;
    }
  }
  
  private Animation setupBgAnim()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(300L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new DanceScoreFilter.1(this));
    return localAnimationSet;
  }
  
  private Animation setupRateAnim()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(1.8F, 1.0F, 1.8F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(600L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(600L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setAnimationListener(new DanceScoreFilter.3(this));
    return localAnimationSet;
  }
  
  private Animation setupScoreAnim(int paramInt1, int paramInt2)
  {
    float f = this.mDanceManager.getContext().getViewPortRatio();
    AnimationSet localAnimationSet = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(DisplayUtils.pixelToRealPixel(50.0F) * f, DisplayUtils.pixelToRealPixel(50.0F) * f, -paramInt1 * f, f * paramInt2);
    localTranslateAnimation.setDuration(1000L);
    localTranslateAnimation.setInterpolator(new BounceInterpolator());
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setAnimationListener(new DanceScoreFilter.2(this));
    localAnimationSet.setStartOffset(300L);
    return localAnimationSet;
  }
  
  private void startShowNumber()
  {
    this.numAnimTime = SystemClock.elapsedRealtime();
    this.startNumAnim = true;
    this.mDanceManager.getContext().playSound(this.mResourceManager.mGameNumberResource.scoreSound);
  }
  
  public void onCloseClicked() {}
  
  public void onDrawFrame()
  {
    super.onDrawFrame();
    this.bgView.draw();
    this.scoreView.draw();
    this.rateView.draw();
    if (this.startNumAnim) {
      drawNumAnim(1500, this.mDanceManager.mGamePlayOutData.mScore);
    }
    this.rankSys.draw();
    if (this.mGamePlayEnd)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.numAnimTime;
      long l3 = this.mGamePlayEndTimestamp;
      if ((1050L - (l1 - l2) <= 0L) && (l1 - l3 >= 4000L) && (!this.mHaveCalledHandler))
      {
        QQDanceEventHandler localQQDanceEventHandler = getQQFilterRenderManager().getBusinessOperation().getDanceEventHandler();
        if (localQQDanceEventHandler != null) {
          localQQDanceEventHandler.scoreSceneEnd(this.mDanceManager.mGamePlayOutData.mScore, this.scoreRate, this.overPercent);
        }
        GLFrameImage.temporaryReleaseTextureCache();
        DanceLog.printFrameQueue("GLFrameImage", "DanceScoreFilter[onDrawFrame]:temporaryReleaseTextureCache");
        this.mHaveCalledHandler = true;
      }
    }
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    Object localObject = this.mDanceManager.getContext().getSurfaceViewSize();
    paramInt1 = ((Rect)localObject).width();
    paramInt2 = ((Rect)localObject).height();
    localObject = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    this.bgView.setImageRes(this.mResourceManager.mShareResource.shareBg);
    this.bgView.setImageRegion((RectF)localObject);
    this.bgView.setImageClipDrawRegion((RectF)localObject);
    this.scoreView.setImageRes(this.mResourceManager.mShareResource.shareScoreBg);
    int i = this.scoreView.getCurrentBackGround().getHeight();
    int j = this.scoreView.getCurrentBackGround().getWidth();
    double d = i / j;
    if (!Double.isNaN(d))
    {
      i = paramInt1 - DisplayUtils.pixelToRealPixel(50.0F) * 2;
      j = (int)(d * i);
      paramInt2 = (paramInt2 - j) / 2;
      localObject = new RectF(DisplayUtils.pixelToRealPixel(50.0F), paramInt2, paramInt1 - DisplayUtils.pixelToRealPixel(50.0F), paramInt2 + j);
      this.scoreView.setImageRegion((RectF)localObject);
      this.scoreView.setImageClipDrawRegion((RectF)localObject);
      this.shareHeight = j;
      this.shareY = paramInt2;
      RectF localRectF = new RectF(((RectF)localObject).left + i * 0.06F, ((RectF)localObject).top + j * 0.45F, ((RectF)localObject).right - i * 0.06F, ((RectF)localObject).top + j * 0.74F);
      this.scoreBoardView.setNumberInterval(DisplayUtils.pixelToRealPixel(0.0F));
      this.scoreBoardView.setScoreBoardSize(localRectF);
      this.scoreBoardView.setNumberImageSlope(0.0F);
      this.rankSysTop = (((RectF)localObject).top + j * 0.74F);
      this.rankSysBottom = (((RectF)localObject).top + j * 0.84F);
      paramInt1 = (int)(i * 0.18F);
      float f1 = ((RectF)localObject).left;
      float f2 = i;
      float f3 = ((RectF)localObject).top;
      float f4 = j;
      float f5 = ((RectF)localObject).left;
      float f6 = i;
      float f7 = paramInt1;
      float f8 = ((RectF)localObject).top;
      float f9 = j;
      localObject = new RectF(f1 + f2 * 0.41F, f3 + f4 * 0.16F, f6 * 0.41F + f5 + f7, paramInt1 + (f9 * 0.16F + f8));
      this.rateView.setImageClipDrawRegion((RectF)localObject);
      this.rateView.setImageRegion((RectF)localObject);
    }
    rankSystemComputeRegion();
  }
  
  public void onSurfaceCreate()
  {
    super.onSurfaceCreate();
    this.bgView = new GLImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.scoreView = new GLImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.scoreBoardView = new GLScoreBoard(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.rateView = new GLImageView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    ResourceManager.GameNumberResource localGameNumberResource = ResourceManager.getInstance().mGameNumberResource;
    this.scoreBoardView.setAnimationFrames(localGameNumberResource.gameNums);
    this.scoreBoardView.setLoadTextureMode(0);
    this.scoreBoardView.initAnimationFrame();
    this.rankSys = new GLTextView(this.mDanceManager.getContext(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.rankSys.setTextSize(DisplayUtils.pixelToRealPixel(32.0F));
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
  }
  
  public void rollbackStatusCallOnInitFilter()
  {
    this.startNumAnim = false;
    this.numAnimEnd = false;
    this.numAnimTime = 0L;
    this.bgView.clearAnimation();
    this.scoreView.clearAnimation();
    this.rateView.clearAnimation();
    this.bgAnim = setupBgAnim();
    this.rateAnim = setupRateAnim();
    this.scoreAnim = setupScoreAnim(this.shareHeight, this.shareY);
    this.bgView.setVisibility(true);
    this.scoreView.setVisibility(false);
    this.scoreBoardView.setVisibility(true);
    this.rateView.setVisibility(false);
    this.rankSys.setVisibility(false);
    this.bgView.startAnimation(this.bgAnim);
    this.scoreRate = "";
    this.mGamePlayEnd = false;
    this.mGamePlayEndTimestamp = 0L;
    this.mHaveCalledHandler = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceScoreFilter
 * JD-Core Version:    0.7.0.1
 */