package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GLRecognizeRegionView
{
  public static final int GOOD = 1;
  public static final int GREAT = 2;
  public static final int INVALID_STATUS = -1;
  public static final int MISS = 0;
  public static final int PERFECT = 3;
  private GLViewContext context;
  private boolean mAnimationHasStarted = false;
  private ArrayList<GLRecognizeRegionView.MatchStatusShow> mCacheMessageShow = new ArrayList();
  private GLRecognizeRegionView.MatchStatusShow mCurrentMessage;
  private RectF mExpandRegionSize = new RectF();
  private RectF mGoodTypefaceRegion = new RectF();
  private RectF mGreatTypefaceRegion = new RectF();
  private GLImageView mLeftBottom;
  private GLImageView mLeftTop;
  private LinkedList<GLRecognizeRegionView.MatchStatusShow> mMessageShowMgr = new LinkedList();
  private RectF mPerfectTypefaceRegion = new RectF();
  private RectF mRegionSize = new RectF();
  private GLImageView mRightBottom;
  private GLImageView mRightTop;
  private GLFrameImage mScoreStatus;
  private GLFrameImage mScoreStatusBackground;
  private GLFrameImage mScoreStatusMongolian;
  private GLRecognizeRegionView.StatusListener mStatusListener;
  private TranslateAnimation mTransformLeftBottom;
  private TranslateAnimation mTransformLeftTop;
  private TranslateAnimation mTransformRightBottom;
  private TranslateAnimation mTransformRightTop;
  private List<Animation> mVibrateAnimGreat;
  private List<Animation> mVibrateAnimPerfect;
  private List<GLImageView> mVibrateLayout;
  
  public GLRecognizeRegionView(GLViewContext paramGLViewContext, String paramString)
  {
    this.context = paramGLViewContext;
    this.mLeftTop = new GLImageView(paramGLViewContext, paramString);
    this.mLeftBottom = new GLImageView(paramGLViewContext, paramString);
    this.mRightTop = new GLImageView(paramGLViewContext, paramString);
    this.mRightBottom = new GLImageView(paramGLViewContext, paramString);
    this.mScoreStatus = new GLFrameImage(paramGLViewContext, paramString);
    this.mScoreStatusMongolian = new GLFrameImage(paramGLViewContext, paramString);
    this.mScoreStatusBackground = new GLFrameImage(paramGLViewContext, paramString);
    clearStatus();
  }
  
  private void changeScoreStatus(int paramInt)
  {
    this.mScoreStatusMongolian.setCurrentImage(paramInt);
    this.mScoreStatusMongolian.setVisibility(true);
    this.mScoreStatusMongolian.clearAnimation();
    this.mScoreStatusBackground.setCurrentImage(paramInt);
    this.mScoreStatusBackground.setVisibility(true);
    this.mScoreStatusBackground.clearAnimation();
    if (paramInt == 0)
    {
      this.mScoreStatus.setVisibility(false);
      this.mScoreStatus.clearAnimation();
    }
    else
    {
      this.mScoreStatus.setCurrentImage(paramInt);
      this.mScoreStatus.setVisibility(true);
      this.mScoreStatus.clearAnimation();
    }
    setScoreStatusTypefaceBarRegion(paramInt);
  }
  
  private void initAnimation()
  {
    float f1 = this.mRegionSize.centerX();
    float f2 = this.mRegionSize.centerY();
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    RectF localRectF = this.mLeftTop.getImageClipDrawRegion();
    this.mTransformLeftTop = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.mTransformLeftTop.setDuration(200L);
    this.mTransformLeftTop.setInterpolator(localLinearInterpolator);
    localRectF = this.mLeftBottom.getImageClipDrawRegion();
    this.mTransformLeftBottom = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.mTransformLeftBottom.setDuration(200L);
    this.mTransformLeftBottom.setInterpolator(localLinearInterpolator);
    localRectF = this.mRightTop.getImageClipDrawRegion();
    this.mTransformRightTop = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.mTransformRightTop.setDuration(200L);
    this.mTransformRightTop.setInterpolator(localLinearInterpolator);
    localRectF = this.mRightBottom.getImageClipDrawRegion();
    this.mTransformRightBottom = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.mTransformRightBottom.setDuration(200L);
    this.mTransformRightBottom.setInterpolator(localLinearInterpolator);
    setupVibrateAnimation();
  }
  
  private void newGreatVibrateAnimation()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mVibrateLayout.size())
    {
      localArrayList.add(setupSingleVibrateAnimation((GlView)this.mVibrateLayout.get(i), 75, 1));
      i += 1;
    }
    this.mVibrateAnimGreat = localArrayList;
  }
  
  private void newPerfectVibrateAnimation()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mVibrateLayout.size())
    {
      localArrayList.add(setupSingleVibrateAnimation((GlView)this.mVibrateLayout.get(i), 75, 2));
      i += 1;
    }
    this.mVibrateAnimPerfect = localArrayList;
  }
  
  private void setScoreStatusInvisible()
  {
    this.mScoreStatus.setVisibility(false);
    this.mScoreStatusBackground.setVisibility(false);
    this.mScoreStatusMongolian.setVisibility(false);
  }
  
  private void setScoreStatusTypefaceBarRegion(int paramInt)
  {
    RectF localRectF;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          localRectF = null;
        } else {
          localRectF = this.mPerfectTypefaceRegion;
        }
      }
      else {
        localRectF = this.mGreatTypefaceRegion;
      }
    }
    else {
      localRectF = this.mGoodTypefaceRegion;
    }
    if (localRectF != null)
    {
      this.mScoreStatus.setImageRegion(localRectF);
      this.mScoreStatus.setImageClipDrawRegion(localRectF);
    }
  }
  
  private void setupVibrateAnimation()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mLeftTop);
    localArrayList.add(this.mLeftBottom);
    localArrayList.add(this.mRightTop);
    localArrayList.add(this.mRightBottom);
    this.mVibrateLayout = localArrayList;
  }
  
  public void addMatchStatusShowToCache(GLRecognizeRegionView.MatchStatusShow paramMatchStatusShow)
  {
    this.mCacheMessageShow.add(paramMatchStatusShow);
  }
  
  public void addQueueScoreStatus(int paramInt)
  {
    if (paramInt > -1)
    {
      GLRecognizeRegionView.MatchStatusShow localMatchStatusShow = getNewMatchStatusShow();
      localMatchStatusShow.status = paramInt;
      this.mMessageShowMgr.add(localMatchStatusShow);
    }
  }
  
  public void clearStatus()
  {
    this.mMessageShowMgr.clear();
    this.mCurrentMessage = null;
    this.mAnimationHasStarted = false;
  }
  
  public void draw()
  {
    startAnimation();
    this.mLeftTop.draw();
    this.mLeftBottom.draw();
    this.mRightTop.draw();
    this.mRightBottom.draw();
    Object localObject1 = this.mCurrentMessage;
    if ((localObject1 != null) && (((GLRecognizeRegionView.MatchStatusShow)localObject1).checkHaveStopped()))
    {
      addMatchStatusShowToCache(this.mCurrentMessage);
      this.mCurrentMessage = null;
      setScoreStatusInvisible();
    }
    if (this.mMessageShowMgr.isEmpty())
    {
      if (this.mCurrentMessage == null) {
        setScoreStatusInvisible();
      }
    }
    else
    {
      localObject1 = (GLRecognizeRegionView.MatchStatusShow)this.mMessageShowMgr.removeLast();
      Object localObject2 = this.mCurrentMessage;
      int i = 1;
      if (localObject2 != null)
      {
        if (((GLRecognizeRegionView.MatchStatusShow)localObject1).status > this.mCurrentMessage.status)
        {
          this.mCurrentMessage.setHaveStopped();
          addMatchStatusShowToCache(this.mCurrentMessage);
          this.mCurrentMessage = ((GLRecognizeRegionView.MatchStatusShow)localObject1);
        }
        else
        {
          i = 0;
        }
      }
      else {
        this.mCurrentMessage = ((GLRecognizeRegionView.MatchStatusShow)localObject1);
      }
      this.mMessageShowMgr.clear();
      if (i != 0)
      {
        changeScoreStatus(this.mCurrentMessage.status);
        localObject1 = this.mStatusListener;
        if (localObject1 != null) {
          ((GLRecognizeRegionView.StatusListener)localObject1).onStatusChanged(this.mCurrentMessage.status);
        }
        localObject1 = this.mCurrentMessage.getMongolianAnimation();
        this.mScoreStatusMongolian.startAnimation((Animation)localObject1);
        localObject1 = this.mCurrentMessage.getBackGroundAnimation();
        if (localObject1 != null) {
          this.mScoreStatusBackground.startAnimation((Animation)localObject1);
        }
        localObject1 = GLRecognizeRegionView.MatchStatusShow.access$000(this.mCurrentMessage);
        if (localObject1 != null) {
          this.mScoreStatus.startAnimation((Animation)localObject1);
        }
        if (this.mCurrentMessage.status == 2)
        {
          newGreatVibrateAnimation();
          startVibrateAnimation(this.mVibrateAnimGreat);
        }
        if (this.mCurrentMessage.status == 3)
        {
          newPerfectVibrateAnimation();
          startVibrateAnimation(this.mVibrateAnimPerfect);
        }
        playAudioTips(this.mCurrentMessage.status);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("newMessageItem=false  mCurrentMessage=");
        ((StringBuilder)localObject2).append(this.mCurrentMessage.getMessageStatus());
        ((StringBuilder)localObject2).append(" topMessage=");
        ((StringBuilder)localObject2).append(((GLRecognizeRegionView.MatchStatusShow)localObject1).getMessageStatus());
        ((StringBuilder)localObject2).append(this.mCurrentMessage.getAnimationLog());
        DanceLog.print("GLRecognizeRegionView", ((StringBuilder)localObject2).toString());
      }
    }
    this.mScoreStatusMongolian.draw();
    this.mScoreStatusBackground.draw();
    this.mScoreStatus.draw();
  }
  
  public GLRecognizeRegionView.MatchStatusShow getNewMatchStatusShow()
  {
    GLRecognizeRegionView.MatchStatusShow localMatchStatusShow;
    if (this.mCacheMessageShow.size() > 0) {
      localMatchStatusShow = (GLRecognizeRegionView.MatchStatusShow)this.mCacheMessageShow.remove(0);
    } else {
      localMatchStatusShow = new GLRecognizeRegionView.MatchStatusShow();
    }
    localMatchStatusShow.resetStatus();
    return localMatchStatusShow;
  }
  
  public void playAudioTips(int paramInt)
  {
    ResourceManager.GamingResource localGamingResource = ResourceManager.getInstance().mGamingResource;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          this.context.playSound(localGamingResource.perfectSound);
          return;
        }
        this.context.playSound(localGamingResource.greatSound);
        return;
      }
      this.context.playSound(localGamingResource.goodSound);
      return;
    }
    this.context.playSound(localGamingResource.missSound);
  }
  
  public void setExpandRecognizeRegion(RectF paramRectF)
  {
    this.mExpandRegionSize.set(paramRectF);
  }
  
  public void setLeftBottomImage(String paramString)
  {
    this.mLeftBottom.setImageRes(paramString);
  }
  
  public void setLeftTopImage(String paramString)
  {
    this.mLeftTop.setImageRes(paramString);
  }
  
  public void setRecognizeRegion(RectF paramRectF)
  {
    if (!this.mRegionSize.equals(paramRectF))
    {
      this.mRegionSize.set(paramRectF);
      float f = DisplayUtils.pixelToRealPixel(82.0F);
      RectF localRectF = new RectF();
      localRectF.left = paramRectF.left;
      localRectF.top = paramRectF.top;
      localRectF.right = (localRectF.left + f);
      localRectF.bottom = (localRectF.top + f);
      this.mLeftTop.setImageRegion(localRectF);
      this.mLeftTop.setImageClipDrawRegion(localRectF);
      localRectF.left = paramRectF.left;
      localRectF.top = (paramRectF.bottom - f);
      localRectF.right = (paramRectF.left + f);
      localRectF.bottom = paramRectF.bottom;
      this.mLeftBottom.setImageRegion(localRectF);
      this.mLeftBottom.setImageClipDrawRegion(localRectF);
      localRectF.left = (paramRectF.right - f);
      localRectF.top = paramRectF.top;
      localRectF.right = paramRectF.right;
      localRectF.bottom = (paramRectF.top + f);
      this.mRightTop.setImageRegion(localRectF);
      this.mRightTop.setImageClipDrawRegion(localRectF);
      localRectF.left = (paramRectF.right - f);
      localRectF.top = (paramRectF.bottom - f);
      localRectF.right = paramRectF.right;
      localRectF.bottom = paramRectF.bottom;
      this.mRightBottom.setImageRegion(localRectF);
      this.mRightBottom.setImageClipDrawRegion(localRectF);
      this.context.mapNormalRegion(this.mRegionSize);
      initAnimation();
    }
  }
  
  public void setRightBottomImage(String paramString)
  {
    this.mRightBottom.setImageRes(paramString);
  }
  
  public void setRightTopImage(String paramString)
  {
    this.mRightTop.setImageRes(paramString);
  }
  
  public void setScoreStatusBackgroundBarRegion(RectF paramRectF)
  {
    this.mScoreStatusBackground.setImageRegion(paramRectF);
    this.mScoreStatusBackground.setImageClipDrawRegion(paramRectF);
  }
  
  public void setScoreStatusBackgroundImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(0, paramString1);
    localArrayList.add(1, paramString2);
    localArrayList.add(2, paramString3);
    localArrayList.add(3, paramString4);
    this.mScoreStatusBackground.setAnimationFrames(localArrayList);
    this.mScoreStatusBackground.setLoadTextureMode(0);
    this.mScoreStatusBackground.initAnimationFrame();
    this.mScoreStatusBackground.setVisibility(false);
  }
  
  public void setScoreStatusMongolianBarRegion(RectF paramRectF)
  {
    this.mScoreStatusMongolian.setImageRegion(paramRectF);
    this.mScoreStatusMongolian.setImageClipDrawRegion(paramRectF);
  }
  
  public void setScoreStatusMongolianImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(0, paramString1);
    localArrayList.add(1, paramString2);
    localArrayList.add(2, paramString3);
    localArrayList.add(3, paramString4);
    this.mScoreStatusMongolian.setAnimationFrames(localArrayList);
    this.mScoreStatusMongolian.setLoadTextureMode(0);
    this.mScoreStatusMongolian.initAnimationFrame();
    this.mScoreStatusMongolian.setVisibility(false);
  }
  
  public void setScoreStatusTypefaceImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(0, paramString1);
    localArrayList.add(1, paramString2);
    localArrayList.add(2, paramString3);
    localArrayList.add(3, paramString4);
    this.mScoreStatus.setAnimationFrames(localArrayList);
    this.mScoreStatus.setLoadTextureMode(0);
    this.mScoreStatus.initAnimationFrame();
    this.mScoreStatus.setVisibility(false);
  }
  
  public void setStatusListner(GLRecognizeRegionView.StatusListener paramStatusListener)
  {
    this.mStatusListener = paramStatusListener;
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.mLeftTop.setVisibility(paramBoolean);
    this.mLeftBottom.setVisibility(paramBoolean);
    this.mRightTop.setVisibility(paramBoolean);
    this.mRightBottom.setVisibility(paramBoolean);
  }
  
  public AnimationSet setupSingleVibrateAnimation(GlView paramGlView, int paramInt1, int paramInt2)
  {
    float f1 = paramGlView.mClipRegion.left;
    float f2 = paramGlView.mClipRegion.top;
    float f3 = paramGlView.context.getRealVideoRatio();
    AnimationSet localAnimationSet = new AnimationSet(true);
    int i = 0;
    while (i < paramInt2)
    {
      if (i == 0) {
        paramGlView = new TranslateAnimation(f1, f1 - 10.0F * f3, f2, f2 - 18.0F * f3);
      } else {
        paramGlView = new TranslateAnimation(0.0F, f3 * -10.0F, 0.0F, -18.0F * f3);
      }
      long l = paramInt1;
      paramGlView.setDuration(l);
      int j = i * 4 * paramInt1;
      paramGlView.setStartOffset(j);
      paramGlView.setFillEnabled(true);
      paramGlView.setFillBefore(false);
      paramGlView.setFillAfter(true);
      localAnimationSet.addAnimation(paramGlView);
      paramGlView = new TranslateAnimation(0.0F, 20.0F * f3, 0.0F, 36.0F * f3);
      paramGlView.setStartOffset(paramInt1 * 1 + j);
      paramGlView.setDuration(l);
      paramGlView.setFillEnabled(true);
      paramGlView.setFillBefore(false);
      paramGlView.setFillAfter(true);
      localAnimationSet.addAnimation(paramGlView);
      paramGlView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -23.0F * f3);
      paramGlView.setStartOffset(paramInt1 * 2 + j);
      paramGlView.setDuration(l);
      paramGlView.setFillEnabled(true);
      paramGlView.setFillBefore(false);
      paramGlView.setFillAfter(true);
      localAnimationSet.addAnimation(paramGlView);
      paramGlView = new TranslateAnimation(0.0F, -10.0F * f3, 0.0F, 5.0F * f3);
      paramGlView.setStartOffset(j + paramInt1 * 3);
      paramGlView.setDuration(l);
      paramGlView.setFillEnabled(true);
      paramGlView.setFillBefore(false);
      paramGlView.setFillAfter(true);
      localAnimationSet.addAnimation(paramGlView);
      i += 1;
    }
    return localAnimationSet;
  }
  
  public void startAnimation()
  {
    if (!this.mAnimationHasStarted)
    {
      this.mLeftTop.startAnimation(this.mTransformLeftTop);
      this.mLeftBottom.startAnimation(this.mTransformLeftBottom);
      this.mRightTop.startAnimation(this.mTransformRightTop);
      this.mRightBottom.startAnimation(this.mTransformRightBottom);
      this.mAnimationHasStarted = true;
    }
  }
  
  public void startVibrateAnimation(List<Animation> paramList)
  {
    if (this.mVibrateLayout.size() != paramList.size()) {
      return;
    }
    int i = 0;
    while (i < this.mVibrateLayout.size())
    {
      GLImageView localGLImageView = (GLImageView)this.mVibrateLayout.get(i);
      localGLImageView.clearAnimation();
      localGLImageView.startAnimation((Animation)paramList.get(i));
      i += 1;
    }
  }
  
  public void updateScoreStatusTypefaceRegion(int paramInt)
  {
    int i = this.context.getSurfaceViewSize().width();
    GLImage localGLImage = this.mScoreStatus.getImageByIndex(1);
    int j = (i - DisplayUtils.pixelToRealPixel(localGLImage.getWidth())) / 2;
    RectF localRectF = this.mGoodTypefaceRegion;
    float f1 = j;
    float f2 = paramInt;
    localRectF.set(f1, f2, i - j, DisplayUtils.pixelToRealPixel(localGLImage.getHeight()) + paramInt);
    localGLImage = this.mScoreStatus.getImageByIndex(2);
    j = (i - DisplayUtils.pixelToRealPixel(localGLImage.getWidth())) / 2;
    this.mGreatTypefaceRegion.set(j, f2, i - j, DisplayUtils.pixelToRealPixel(localGLImage.getHeight()) + paramInt);
    localGLImage = this.mScoreStatus.getImageByIndex(3);
    j = (i - DisplayUtils.pixelToRealPixel(localGLImage.getWidth())) / 2;
    this.mPerfectTypefaceRegion.set(j, f2, i - j, paramInt + DisplayUtils.pixelToRealPixel(localGLImage.getHeight()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLRecognizeRegionView
 * JD-Core Version:    0.7.0.1
 */