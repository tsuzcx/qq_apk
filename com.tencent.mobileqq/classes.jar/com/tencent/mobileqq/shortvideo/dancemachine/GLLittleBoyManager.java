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
    for (;;)
    {
      if (i < this.mLittleBoyList.size())
      {
        GLLittleBoy localGLLittleBoy = (GLLittleBoy)this.mLittleBoyList.get(i);
        if (localGLLittleBoy.getAnimation() == paramAnimation) {
          addDeadListLittleBoy(localGLLittleBoy);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void addDeadListLittleBoy(GLLittleBoy paramGLLittleBoy)
  {
    if (paramGLLittleBoy.mIsValidBoy) {
      throw new RuntimeException("状态错误,消失动画的对象是有效对象");
    }
    paramGLLittleBoy.setVisibility(false);
    paramGLLittleBoy.clearAnimation();
    paramGLLittleBoy.clearStatus();
    this.mDeadBoyList.add(paramGLLittleBoy);
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
        DanceLog.print("changeLittleBoyMissStatus", "[false]ID=" + localGLLittleBoy.getDanceData().id + " index" + localGLLittleBoy.mIndex + " centerY=" + f + " top=" + this.mRecognizeRegion.top);
      }
      i += 1;
    }
  }
  
  private Animation getLittleBoyAnimation(GLLittleBoy paramGLLittleBoy, double paramDouble)
  {
    paramGLLittleBoy = paramGLLittleBoy.getImageRegion();
    int i = (int)(1.0D / paramDouble * 1000.0D);
    float f = paramGLLittleBoy.height() / 2.0F;
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
    label149:
    label308:
    label474:
    while (localIterator.hasNext())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)localIterator.next();
      if (!localGLLittleBoy.mIsValidBoy)
      {
        makeSureBoyIsInvalid(localGLLittleBoy);
      }
      else
      {
        int i;
        if (localGLLittleBoy.mMatched)
        {
          this.mHaveMatched = true;
          f = localGLLittleBoy.getCurrentDrawRegionSize().centerY() - this.mRecognizeRegion.top;
          if (f <= 0.0F)
          {
            localGLLittleBoy.mMissed = true;
            localGLLittleBoy.mNeedMatch = false;
            continue;
          }
          if ((f >= this.mDistanceX20) && (f <= this.mDistanceX80)) {
            break label308;
          }
          this.mScoreTotal += 20;
          i = 20;
          localGLLittleBoy.mMatchedStatus = 1;
          localGLLittleBoy.mDataReport.mScore = i;
          if (localGLLittleBoy.mMatchedStatus > this.mCurrentScoreLevel) {
            this.mCurrentScoreLevel = localGLLittleBoy.mMatchedStatus;
          }
        }
        RectF localRectF = localGLLittleBoy.getCurrentDrawRegionSize();
        float f = localRectF.centerY();
        if (f <= this.mRecognizeRegion.top)
        {
          localGLLittleBoy.mMissed = true;
          localGLLittleBoy.mNeedMatch = false;
          DanceLog.print("HaveMatchedItems", "[true]ID=" + localGLLittleBoy.getDanceData().id + " index" + localGLLittleBoy.mIndex + " centerY=" + f + " top=" + this.mRecognizeRegion.top);
        }
        for (;;)
        {
          if (!localGLLittleBoy.mMissed) {
            break label474;
          }
          localGLLittleBoy.mMatchedStatus = 0;
          this.mHaveMissed = true;
          break;
          if (((f >= this.mDistanceX20) && (f <= this.mDistanceX40)) || ((f >= this.mDistanceX60) && (f <= this.mDistanceX80)))
          {
            this.mScoreTotal += 40;
            i = 40;
            localGLLittleBoy.mMatchedStatus = 2;
            break label149;
          }
          this.mScoreTotal += 50;
          i = 50;
          localGLLittleBoy.mMatchedStatus = 3;
          break label149;
          DanceLog.print("HaveMatchedItems", "[false]ID=" + localGLLittleBoy.getDanceData().id + " index" + localGLLittleBoy.mIndex + " centerY=" + f + " top=" + this.mRecognizeRegion.top + " [AccumulationBug]region.top=" + localRectF.top);
        }
      }
    }
  }
  
  private void judgeLittleBoyValidate()
  {
    Iterator localIterator = this.mLittleBoyList.iterator();
    while (localIterator.hasNext())
    {
      GLLittleBoy localGLLittleBoy = (GLLittleBoy)localIterator.next();
      if (!localGLLittleBoy.mIsValidBoy)
      {
        makeSureBoyIsInvalid(localGLLittleBoy);
        localGLLittleBoy.mNeedMatch = false;
      }
      else
      {
        RectF localRectF = localGLLittleBoy.getCurrentDrawRegionSize();
        float f1 = localRectF.centerY();
        localGLLittleBoy.resetValidBoyStatus();
        if (f1 >= this.mRecognizeRegion.bottom)
        {
          localGLLittleBoy.mNeedMatch = false;
        }
        else if (f1 <= this.mRecognizeRegion.top)
        {
          localGLLittleBoy.mMissed = true;
          localGLLittleBoy.mNeedMatch = false;
          DanceLog.print("judgeLittleBoyValidate", "[true]ID=" + localGLLittleBoy.getDanceData().id + " index" + localGLLittleBoy.mIndex + " centerY=" + f1 + " top=" + this.mRecognizeRegion.top);
        }
        else
        {
          DanceLog.print("judgeLittleBoyValidate", "[false]ID=" + localGLLittleBoy.getDanceData().id + " index" + localGLLittleBoy.mIndex + " centerY=" + f1 + " top=" + this.mRecognizeRegion.top + " [AccumulationBug]region.top=" + localRectF.top);
          if (localRectF.top <= 0.0F)
          {
            float f2 = f1 - this.mRecognizeRegion.top;
            if (f2 < 45.0F)
            {
              localGLLittleBoy.mMissed = true;
              localGLLittleBoy.mNeedMatch = false;
            }
            else
            {
              throw new RuntimeException("judgeLittleBoyValidate:centerY=" + f1 + " mRecognizeRegion.top" + this.mRecognizeRegion.top + " diff=" + f2 + " 图片过大,设计优化资源");
            }
          }
        }
      }
    }
  }
  
  private void makeSureBoyIsInvalid(GLLittleBoy paramGLLittleBoy)
  {
    if ((!paramGLLittleBoy.mIsValidBoy) && (!paramGLLittleBoy.mMatched) && (!paramGLLittleBoy.mMissed)) {
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
      if (localIterator.hasNext())
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
        for (;;)
        {
          localGLLittleBoy.draw();
          break;
          makeSureBoyIsInvalid(localGLLittleBoy);
        }
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
    int i;
    if (this.mHaveMatched)
    {
      i = this.mCurrentScoreLevel;
      if (this.mCurrentScoreLevel == -1) {
        throw new RuntimeException("匹配成功，但是状态不对.mHaveMatched=true,mCurrentScoreLevel=" + this.mCurrentScoreLevel);
      }
    }
    else
    {
      if (!this.mHaveMissed) {
        break label62;
      }
      i = 0;
    }
    return i;
    label62:
    return -1;
  }
  
  public int getTotalScore()
  {
    return this.mScoreTotal;
  }
  
  public void initLittleBoyBeginRegion()
  {
    Rect localRect = this.context.getSurfaceViewSize();
    int i = localRect.width();
    int j = localRect.height();
    this.mLittleBoyColum[0] = new RectF(DisplayUtils.pixelToRealPixel(65.0F), j, DisplayUtils.pixelToRealPixel(315), DisplayUtils.pixelToRealPixel(400) + j);
    this.mLittleBoyColum[1] = new RectF(i - DisplayUtils.pixelToRealPixel(315), j, i - DisplayUtils.pixelToRealPixel(65.0F), j + DisplayUtils.pixelToRealPixel(400));
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
    this.mDistanceX40 = (this.mDistanceX20 * 2.0F);
    this.mDistanceX60 = (this.mDistanceX20 * 3.0F);
    this.mDistanceX80 = (this.mDistanceX20 * 4.0F);
  }
  
  public void updateStartTimestamp(long paramLong)
  {
    this.mStartRecordMis = paramLong;
    this.mScoreTotal = 0;
    this.mHaveMatched = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager
 * JD-Core Version:    0.7.0.1
 */