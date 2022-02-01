package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class GLLittleBoyManager
  implements Animation.AnimationListener
{
  private GLViewContext context;
  private float halfSizeDismiss = 0.0F;
  private String key;
  private Comparator<GLLittleBoy> mCompare = new GLLittleBoyManager.4(this);
  private RectF mCurrentBlastRegion = new RectF();
  private int mCurrentScoreLevel;
  private ArrayList<GLLittleBoy> mDeadBoyList = new ArrayList();
  private float mDistanceX20;
  private float mDistanceX40;
  private float mDistanceX60;
  private float mDistanceX80;
  private boolean mHaveMatched;
  private boolean mHaveMissed;
  private RectF[] mLittleBoyColum = new RectF[2];
  private int mLittleBoyCount = 0;
  private ArrayList<GLLittleBoy> mLittleBoyList = new ArrayList();
  private final int mOffsetBoy = 65;
  private RectF mRecognizeRegion = new RectF();
  private int mScoreTotal;
  private TreeSet<GLLittleBoy> mSortedLittleBoyList;
  private long mStartRecordMis = 0L;
  
  public GLLittleBoyManager(GLViewContext paramGLViewContext, String paramString)
  {
    this.context = paramGLViewContext;
    this.key = paramString;
    this.mSortedLittleBoyList = new TreeSet(this.mCompare);
  }
  
  private void addDeadListLittleBoy(Animation paramAnimation)
  {
    int i = 0;
    while (i < this.mLittleBoyList.size())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)this.mLittleBoyList.get(i);
      if (localGLLittleBoy.getAnimation() == paramAnimation)
      {
        addDeadListLittleBoy(localGLLittleBoy);
        return;
      }
      i += 1;
    }
  }
  
  private void addDeadListLittleBoy(GLLittleBoy paramGLLittleBoy)
  {
    if (!paramGLLittleBoy.mIsValidBoy)
    {
      paramGLLittleBoy.setVisibility(false);
      paramGLLittleBoy.clearAnimation();
      paramGLLittleBoy.clearStatus();
      this.mDeadBoyList.add(paramGLLittleBoy);
      return;
    }
    throw new RuntimeException("状态错误,消失动画的对象是有效对象");
  }
  
  private void adjustLittleBoyRegion(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.context.getSurfaceViewSize();
    int k = ((Rect)localObject).width();
    int m = ((Rect)localObject).height();
    localObject = ResourceManager.getInstance();
    int j = paramInt2;
    int i = paramInt3;
    if (((ResourceManager)localObject).isCompressed)
    {
      j = (int)(paramInt2 / ((ResourceManager)localObject).compressRatio);
      i = (int)(paramInt3 / ((ResourceManager)localObject).compressRatio);
    }
    paramInt2 = (int)(j * 0.82F);
    paramInt3 = (int)(i * 0.82F);
    if (paramInt1 == 0)
    {
      this.mLittleBoyColum[0].set(DisplayUtils.pixelToRealPixel(65.0F), m, DisplayUtils.pixelToRealPixel(paramInt2 + 65), m + DisplayUtils.pixelToRealPixel(paramInt3));
      return;
    }
    this.mLittleBoyColum[1] = new RectF(k - DisplayUtils.pixelToRealPixel(paramInt2 + 65), m, k - DisplayUtils.pixelToRealPixel(65.0F), m + DisplayUtils.pixelToRealPixel(paramInt3));
  }
  
  private void changeLittleBoyMissStatus(Animation paramAnimation)
  {
    int i = 0;
    while (i < this.mLittleBoyList.size())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)this.mLittleBoyList.get(i);
      if ((localGLLittleBoy.getAnimation() == paramAnimation) && (localGLLittleBoy.mIsValidBoy))
      {
        localGLLittleBoy.mMissed = true;
        float f = localGLLittleBoy.getCurrentDrawRegionSize().centerY();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[false]ID=");
        localStringBuilder.append(localGLLittleBoy.getDanceData().id);
        localStringBuilder.append(" index");
        localStringBuilder.append(localGLLittleBoy.mIndex);
        localStringBuilder.append(" centerY=");
        localStringBuilder.append(f);
        localStringBuilder.append(" top=");
        localStringBuilder.append(this.mRecognizeRegion.top);
        DanceLog.print("changeLittleBoyMissStatus", localStringBuilder.toString());
      }
      i += 1;
    }
  }
  
  private Animation getLittleBoyAnimation(GLLittleBoy paramGLLittleBoy, double paramDouble)
  {
    paramGLLittleBoy = paramGLLittleBoy.getImageRegion();
    int i = (int)(1.0D / paramDouble * 1000.0D);
    paramGLLittleBoy.height();
    this.context.getViewPortRatio();
    paramGLLittleBoy = new TranslateAnimation(paramGLLittleBoy.left, paramGLLittleBoy.left, paramGLLittleBoy.top, 0.0F);
    paramGLLittleBoy.setDuration(i);
    paramGLLittleBoy.setFillEnabled(true);
    paramGLLittleBoy.setFillAfter(true);
    paramGLLittleBoy.setInterpolator(new LinearInterpolator());
    paramGLLittleBoy.setAnimationListener(new GLLittleBoyManager.1(this));
    return paramGLLittleBoy;
  }
  
  private Animation getMissedAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F));
    localAnimationSet.addAnimation(new AlphaAnimation(1.0F, 0.5F));
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setDuration(160L);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    localAnimationSet.setAnimationListener(new GLLittleBoyManager.2(this));
    return localAnimationSet;
  }
  
  private void judgeHaveMatchedItemsAndComputeScore()
  {
    this.mHaveMatched = false;
    this.mHaveMissed = false;
    this.mCurrentScoreLevel = -1;
    Iterator localIterator = this.mLittleBoyList.iterator();
    while (localIterator.hasNext())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)localIterator.next();
      if (!localGLLittleBoy.mIsValidBoy)
      {
        makeSureBoyIsInvalid(localGLLittleBoy);
      }
      else
      {
        if (localGLLittleBoy.mMatched)
        {
          this.mHaveMatched = true;
          f1 = localGLLittleBoy.getCurrentDrawRegionSize().centerY() - this.mRecognizeRegion.top;
          if (f1 <= 0.0F)
          {
            localGLLittleBoy.mMissed = true;
            localGLLittleBoy.mNeedMatch = false;
            continue;
          }
          float f2 = this.mDistanceX20;
          int i = 40;
          if ((f1 >= f2) && (f1 <= this.mDistanceX80))
          {
            if (((f1 >= f2) && (f1 <= this.mDistanceX40)) || ((f1 >= this.mDistanceX60) && (f1 <= this.mDistanceX80)))
            {
              this.mScoreTotal += 40;
              localGLLittleBoy.mMatchedStatus = 2;
            }
            else
            {
              this.mScoreTotal += 50;
              localGLLittleBoy.mMatchedStatus = 3;
              i = 50;
            }
          }
          else
          {
            this.mScoreTotal += 20;
            localGLLittleBoy.mMatchedStatus = 1;
            i = 20;
          }
          localGLLittleBoy.mDataReport.mScore = i;
          if (localGLLittleBoy.mMatchedStatus > this.mCurrentScoreLevel) {
            this.mCurrentScoreLevel = localGLLittleBoy.mMatchedStatus;
          }
        }
        Object localObject = localGLLittleBoy.getCurrentDrawRegionSize();
        float f1 = ((RectF)localObject).centerY();
        if (f1 <= this.mRecognizeRegion.top)
        {
          localGLLittleBoy.mMissed = true;
          localGLLittleBoy.mNeedMatch = false;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[true]ID=");
          ((StringBuilder)localObject).append(localGLLittleBoy.getDanceData().id);
          ((StringBuilder)localObject).append(" index");
          ((StringBuilder)localObject).append(localGLLittleBoy.mIndex);
          ((StringBuilder)localObject).append(" centerY=");
          ((StringBuilder)localObject).append(f1);
          ((StringBuilder)localObject).append(" top=");
          ((StringBuilder)localObject).append(this.mRecognizeRegion.top);
          DanceLog.print("HaveMatchedItems", ((StringBuilder)localObject).toString());
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[false]ID=");
          localStringBuilder.append(localGLLittleBoy.getDanceData().id);
          localStringBuilder.append(" index");
          localStringBuilder.append(localGLLittleBoy.mIndex);
          localStringBuilder.append(" centerY=");
          localStringBuilder.append(f1);
          localStringBuilder.append(" top=");
          localStringBuilder.append(this.mRecognizeRegion.top);
          localStringBuilder.append(" [AccumulationBug]region.top=");
          localStringBuilder.append(((RectF)localObject).top);
          DanceLog.print("HaveMatchedItems", localStringBuilder.toString());
        }
        if (localGLLittleBoy.mMissed)
        {
          localGLLittleBoy.mMatchedStatus = 0;
          this.mHaveMissed = true;
        }
      }
    }
  }
  
  private void judgeLittleBoyValidate()
  {
    Object localObject1 = this.mLittleBoyList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)((Iterator)localObject1).next();
      if (!localGLLittleBoy.mIsValidBoy)
      {
        makeSureBoyIsInvalid(localGLLittleBoy);
        localGLLittleBoy.mNeedMatch = false;
      }
      else
      {
        Object localObject2 = localGLLittleBoy.getCurrentDrawRegionSize();
        float f1 = ((RectF)localObject2).centerY();
        localGLLittleBoy.resetValidBoyStatus();
        if (f1 >= this.mRecognizeRegion.bottom)
        {
          localGLLittleBoy.mNeedMatch = false;
        }
        else if (f1 <= this.mRecognizeRegion.top)
        {
          localGLLittleBoy.mMissed = true;
          localGLLittleBoy.mNeedMatch = false;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[true]ID=");
          ((StringBuilder)localObject2).append(localGLLittleBoy.getDanceData().id);
          ((StringBuilder)localObject2).append(" index");
          ((StringBuilder)localObject2).append(localGLLittleBoy.mIndex);
          ((StringBuilder)localObject2).append(" centerY=");
          ((StringBuilder)localObject2).append(f1);
          ((StringBuilder)localObject2).append(" top=");
          ((StringBuilder)localObject2).append(this.mRecognizeRegion.top);
          DanceLog.print("judgeLittleBoyValidate", ((StringBuilder)localObject2).toString());
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[false]ID=");
          localStringBuilder.append(localGLLittleBoy.getDanceData().id);
          localStringBuilder.append(" index");
          localStringBuilder.append(localGLLittleBoy.mIndex);
          localStringBuilder.append(" centerY=");
          localStringBuilder.append(f1);
          localStringBuilder.append(" top=");
          localStringBuilder.append(this.mRecognizeRegion.top);
          localStringBuilder.append(" [AccumulationBug]region.top=");
          localStringBuilder.append(((RectF)localObject2).top);
          DanceLog.print("judgeLittleBoyValidate", localStringBuilder.toString());
          if (((RectF)localObject2).top <= 0.0F)
          {
            float f2 = f1 - this.mRecognizeRegion.top;
            if (f2 < 45.0F)
            {
              localGLLittleBoy.mMissed = true;
              localGLLittleBoy.mNeedMatch = false;
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("judgeLittleBoyValidate:centerY=");
              ((StringBuilder)localObject1).append(f1);
              ((StringBuilder)localObject1).append(" mRecognizeRegion.top");
              ((StringBuilder)localObject1).append(this.mRecognizeRegion.top);
              ((StringBuilder)localObject1).append(" diff=");
              ((StringBuilder)localObject1).append(f2);
              ((StringBuilder)localObject1).append(" 图片过大,设计优化资源");
              throw new RuntimeException(((StringBuilder)localObject1).toString());
            }
          }
        }
      }
    }
  }
  
  private void makeSureBoyIsInvalid(GLLittleBoy paramGLLittleBoy)
  {
    if ((!paramGLLittleBoy.mIsValidBoy) && (!paramGLLittleBoy.mMatched))
    {
      if (paramGLLittleBoy.mMissed) {
        return;
      }
      throw new RuntimeException("对象不是无效对象,mMatched=false mMissed=false");
    }
  }
  
  private void sortByCenterHeightValue()
  {
    this.mSortedLittleBoyList.clear();
    Iterator localIterator = this.mLittleBoyList.iterator();
    while (localIterator.hasNext())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)localIterator.next();
      this.mSortedLittleBoyList.add(localGLLittleBoy);
    }
  }
  
  public void clearStatus()
  {
    this.mDeadBoyList.clear();
    this.mLittleBoyList.clear();
    this.mSortedLittleBoyList.clear();
    this.mStartRecordMis = 0L;
    this.mScoreTotal = 0;
    this.mHaveMatched = false;
    this.mHaveMissed = false;
    this.mLittleBoyCount = 0;
    this.mCurrentScoreLevel = -1;
    Iterator localIterator = ResourceManager.getInstance().getDancePostures().iterator();
    while (localIterator.hasNext()) {
      ((ResourceManager.DancePosture)localIterator.next()).haveCreated = false;
    }
  }
  
  public void drawFrame()
  {
    if (this.mStartRecordMis > 0L)
    {
      judgeHaveMatchedItemsAndComputeScore();
      generateNewLittleBoy();
      Iterator localIterator = this.mLittleBoyList.iterator();
      GLLittleBoy localGLLittleBoy;
      while (localIterator.hasNext())
      {
        localGLLittleBoy = (GLLittleBoy)localIterator.next();
        if (localGLLittleBoy.mIsValidBoy)
        {
          if (localGLLittleBoy.mMissed)
          {
            localGLLittleBoy.mIsValidBoy = false;
            initLittleBoyNewRegion(localGLLittleBoy, false);
            localGLLittleBoy.mDataReport.mEnd = true;
            localGLLittleBoy.mDataReport.status = 0;
            if (!this.context.mReport.mHasReported) {
              this.context.mReport.mBoyData.add(localGLLittleBoy.mDataReport);
            }
          }
          if (localGLLittleBoy.mMatched)
          {
            localGLLittleBoy.mIsValidBoy = false;
            initLittleBoyNewRegion(localGLLittleBoy, true);
            localGLLittleBoy.mDataReport.mEnd = true;
            localGLLittleBoy.mDataReport.status = localGLLittleBoy.mMatchedStatus;
            if (!this.context.mReport.mHasReported) {
              this.context.mReport.mBoyData.add(localGLLittleBoy.mDataReport);
            }
          }
        }
        else
        {
          makeSureBoyIsInvalid(localGLLittleBoy);
        }
        localGLLittleBoy.draw();
      }
      localIterator = this.mDeadBoyList.iterator();
      while (localIterator.hasNext())
      {
        localGLLittleBoy = (GLLittleBoy)localIterator.next();
        if (!localGLLittleBoy.mIsValidBoy) {
          this.mLittleBoyList.remove(localGLLittleBoy);
        } else {
          throw new RuntimeException("状态错误,清理的对象是有效对象");
        }
      }
      this.mDeadBoyList.clear();
    }
  }
  
  public void generateNewLittleBoy()
  {
    float f = (float)((SystemClock.uptimeMillis() - this.mStartRecordMis) / 100L) / 10.0F;
    ResourceManager localResourceManager = ResourceManager.getInstance();
    Iterator localIterator = localResourceManager.getDancePostures().iterator();
    while (localIterator.hasNext())
    {
      ResourceManager.DancePosture localDancePosture = (ResourceManager.DancePosture)localIterator.next();
      if ((localDancePosture.appearTime <= f) && (!localDancePosture.haveCreated))
      {
        GLLittleBoy localGLLittleBoy = new GLLittleBoy(this.context, this.key);
        localGLLittleBoy.setAnimationFrames(localResourceManager.getPostureById(localDancePosture.id).danceCartoon);
        localGLLittleBoy.setAnimationPlayMode(1);
        localGLLittleBoy.setLoadTextureMode(1);
        localGLLittleBoy.setFrameDuration(62.0F);
        localGLLittleBoy.initAnimationFrame();
        localGLLittleBoy.setFrameAnimationParams(localDancePosture);
        int i = this.mLittleBoyCount;
        this.mLittleBoyCount = (i + 1);
        localGLLittleBoy.mIndex = i;
        Object localObject = localGLLittleBoy.getImageSize();
        i = localDancePosture.appearCol - 1;
        adjustLittleBoyRegion(i, ((GLImage)localObject).getWidth(), ((GLImage)localObject).getHeight());
        localObject = this.mLittleBoyColum[i];
        localGLLittleBoy.setImageRegion((RectF)localObject);
        localGLLittleBoy.setImageClipDrawRegion((RectF)localObject);
        localGLLittleBoy.setVisibility(true);
        localGLLittleBoy.startAnimation(getLittleBoyAnimation(localGLLittleBoy, localDancePosture.speed));
        this.mLittleBoyList.add(localGLLittleBoy);
        localDancePosture.haveCreated = true;
        localGLLittleBoy.mDataReport.mEnd = false;
        localGLLittleBoy.mDataReport.mId = localGLLittleBoy.getDanceData().id;
      }
    }
  }
  
  public Animation getBlastAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F));
    localAnimationSet.addAnimation(new AlphaAnimation(1.0F, 0.0F));
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setDuration(130L);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    localAnimationSet.setAnimationListener(this);
    return localAnimationSet;
  }
  
  public TreeSet<GLLittleBoy> getItems()
  {
    judgeLittleBoyValidate();
    sortByCenterHeightValue();
    return this.mSortedLittleBoyList;
  }
  
  public Animation getMatchedAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(100L);
    localScaleAnimation.setFillEnabled(true);
    localScaleAnimation.setFillBefore(true);
    localAnimationSet.addAnimation(localScaleAnimation);
    localScaleAnimation = new ScaleAnimation(1.1F, 0.0F, 1.1F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setStartOffset(100L);
    localScaleAnimation.setFillEnabled(true);
    localScaleAnimation.setFillBefore(false);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new GLLittleBoyManager.3(this));
    return localAnimationSet;
  }
  
  public int getShowStatus()
  {
    boolean bool = this.mHaveMatched;
    int i = -1;
    if (bool)
    {
      i = this.mCurrentScoreLevel;
      if (i != -1) {
        return i;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("匹配成功，但是状态不对.mHaveMatched=true,mCurrentScoreLevel=");
      localStringBuilder.append(this.mCurrentScoreLevel);
      throw new RuntimeException(localStringBuilder.toString());
    }
    if (this.mHaveMissed) {
      i = 0;
    }
    return i;
  }
  
  public int getTotalScore()
  {
    return this.mScoreTotal;
  }
  
  public void initLittleBoyBeginRegion()
  {
    Object localObject = this.context.getSurfaceViewSize();
    int i = ((Rect)localObject).width();
    int j = ((Rect)localObject).height();
    localObject = this.mLittleBoyColum;
    float f1 = DisplayUtils.pixelToRealPixel(65.0F);
    float f2 = j;
    float f3 = 315;
    float f4 = DisplayUtils.pixelToRealPixel(f3);
    float f5 = 400;
    localObject[0] = new RectF(f1, f2, f4, DisplayUtils.pixelToRealPixel(f5) + j);
    this.mLittleBoyColum[1] = new RectF(i - DisplayUtils.pixelToRealPixel(f3), f2, i - DisplayUtils.pixelToRealPixel(65.0F), j + DisplayUtils.pixelToRealPixel(f5));
  }
  
  public void initLittleBoyNewRegion(GLLittleBoy paramGLLittleBoy, boolean paramBoolean)
  {
    paramGLLittleBoy.saveMatchedPointRegion();
    paramGLLittleBoy.setConvertedImageAndClipRegion(paramGLLittleBoy.getSaveMatchedPointRegion());
    paramGLLittleBoy.clearAnimation();
    if (paramBoolean)
    {
      if (paramGLLittleBoy.mMatched)
      {
        paramGLLittleBoy.startAnimation(getMatchedAnimation());
        return;
      }
      throw new RuntimeException("initLittleBoyNewRegion,状态错误 mMatched=false");
    }
    if (paramGLLittleBoy.mMissed)
    {
      paramGLLittleBoy.startAnimation(getMissedAnimation());
      return;
    }
    throw new RuntimeException("initLittleBoyNewRegion,状态错误 mMissed=false");
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    addDeadListLittleBoy(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void updateRecognizeRegion(RectF paramRectF)
  {
    if (!this.mRecognizeRegion.equals(paramRectF))
    {
      this.mRecognizeRegion.set(paramRectF);
      this.context.mapNormalRegion(this.mRecognizeRegion);
    }
    this.mDistanceX20 = (this.mRecognizeRegion.height() / 5.0F);
    float f = this.mDistanceX20;
    this.mDistanceX40 = (2.0F * f);
    this.mDistanceX60 = (3.0F * f);
    this.mDistanceX80 = (f * 4.0F);
  }
  
  public void updateStartTimestamp(long paramLong)
  {
    this.mStartRecordMis = paramLong;
    this.mScoreTotal = 0;
    this.mHaveMatched = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager
 * JD-Core Version:    0.7.0.1
 */