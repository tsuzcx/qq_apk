package com.tencent.mobileqq.minigame.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class BlockAdView
  extends RelativeLayout
{
  private static final String TAG = "[minigame]BlockAdView";
  private AnimatorSet animatorSet;
  private ArrayList<BlockAdView.SingleBlockAdView> blockList = new ArrayList();
  private boolean hasEndBlockAdAnimation;
  public final int horizontalHeight = ViewUtils.dpToPx(65.0F);
  public final int horizontalSingleBlockWidth = ViewUtils.dpToPx(65.0F);
  protected ImageView mAdIcon;
  private boolean mIsHorizontal;
  protected LinearLayout mLinearLayout;
  private int mPlayCount;
  private int mRealAdNum;
  public final int sideGapHeightHorizontal = ViewUtils.dpToPx(4.0F);
  public final int sideGapHeightVertical = ViewUtils.dpToPx(4.0F);
  public final int sideGapWidthHorizontal = ViewUtils.dpToPx(4.0F);
  public final int sideGapWidthVertical = 0;
  public final int verticalSingleBlockHeight = ViewUtils.dpToPx(73.0F);
  public final int verticalWidth = ViewUtils.dpToPx(65.0F);
  
  public BlockAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramBoolean);
  }
  
  public BlockAdView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, 0, paramBoolean);
  }
  
  public BlockAdView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, 0, paramBoolean);
  }
  
  private void adjustUIUsingNewData(BlockAdInfo paramBlockAdInfo)
  {
    boolean bool2 = true;
    if (checkIsDataInvalid(paramBlockAdInfo))
    {
      this.mRealAdNum = 0;
      clearBlockAdAnimation();
      setVisibility(8);
      return;
    }
    if ((this.mRealAdNum == 1) && (this.mIsHorizontal))
    {
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, this.sideGapHeightHorizontal, 0, this.sideGapHeightHorizontal);
      this.mLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    Object localObject1 = paramBlockAdInfo.getGdtAdInfoList().subList(0, this.mRealAdNum);
    paramBlockAdInfo = paramBlockAdInfo.getBlockAdInfo().subList(0, this.mRealAdNum);
    clearBlockAdAnimation();
    this.mLinearLayout.removeAllViewsInLayout();
    int i = 0;
    if (i < this.mRealAdNum)
    {
      Object localObject2 = getContext();
      if (this.mRealAdNum < 3) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject2 = new BlockAdView.SingleBlockAdView(this, (Context)localObject2, bool1);
        ((BlockAdView.SingleBlockAdView)localObject2).setData((MiniAppInfo)paramBlockAdInfo.get(i), (GdtAd)((List)localObject1).get(i), this.mRealAdNum);
        this.mLinearLayout.addView((View)localObject2);
        this.blockList.add(localObject2);
        i += 1;
        break;
      }
    }
    updateBackground(true);
    if (this.mRealAdNum > 2) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      updateAdIcon(bool1);
      return;
    }
  }
  
  private BlockAdInfo calculateAndAdjustBlockAdInfo(BlockAdInfo paramBlockAdInfo)
  {
    if (paramBlockAdInfo == null) {
      return null;
    }
    int j = getSafeGap();
    int n = BlockAdManager.getInstance().getGameWidth() - j * 2;
    int i1 = BlockAdManager.getInstance().getGameHeight() - j * 2;
    int i2 = BlockAdManager.getInstance().gameDpTopx(paramBlockAdInfo.getLeft());
    int i3 = BlockAdManager.getInstance().gameDpTopx(paramBlockAdInfo.getTop());
    int i = paramBlockAdInfo.getSize();
    this.mRealAdNum = i;
    if ((i2 < j) || (i3 < j)) {
      return null;
    }
    int k;
    int m;
    if (this.mIsHorizontal)
    {
      k = this.horizontalHeight + this.sideGapHeightHorizontal * 2;
      if (i3 + k > i1) {
        return null;
      }
      if (this.horizontalSingleBlockWidth + i2 > n) {
        return null;
      }
      m = this.horizontalSingleBlockWidth * i + this.sideGapWidthHorizontal * 2;
      i = k;
      j = m;
      if (i2 + m > n)
      {
        m = (n - i2 - this.sideGapWidthHorizontal * 2) / this.horizontalSingleBlockWidth;
        this.mRealAdNum = m;
        j = this.horizontalSingleBlockWidth * m + this.sideGapWidthHorizontal * 2;
        i = k;
        if (m == 0) {
          return null;
        }
      }
    }
    else
    {
      k = this.verticalWidth + 0;
      if (i2 + k > n) {
        return null;
      }
      if (this.verticalSingleBlockHeight + i3 > i1) {
        return null;
      }
      m = this.verticalSingleBlockHeight * i;
      i = m;
      j = k;
      if (i3 + m > i1)
      {
        m = (i1 - i3 + 0) / this.verticalSingleBlockHeight;
        this.mRealAdNum = m;
        i = this.verticalSingleBlockHeight * m;
        j = k;
        if (m == 0) {
          return null;
        }
      }
    }
    paramBlockAdInfo.setRealWidth(ViewUtils.PxToDp(j));
    paramBlockAdInfo.setRealHeight(ViewUtils.PxToDp(i));
    return paramBlockAdInfo;
  }
  
  private boolean checkIsDataInvalid(BlockAdInfo paramBlockAdInfo)
  {
    return (this.mRealAdNum < 1) || (paramBlockAdInfo == null) || (paramBlockAdInfo.getGdtAdInfoList() == null) || (paramBlockAdInfo.getGdtAdInfoList().size() < this.mRealAdNum) || (paramBlockAdInfo.getBlockAdInfo() == null) || (paramBlockAdInfo.getBlockAdInfo().size() < this.mRealAdNum);
  }
  
  private int getPlayCount()
  {
    return this.mPlayCount;
  }
  
  public static int getSafeGap()
  {
    if (BlockAdManager.getInstance().getDensity() >= 3.0F)
    {
      i = 1;
      if (i == 0) {
        break label35;
      }
    }
    label35:
    for (int i = 8;; i = 16)
    {
      return BlockAdManager.getInstance().gameDpTopx(i);
      i = 0;
      break;
    }
  }
  
  private void init(Context paramContext, boolean paramBoolean)
  {
    this.mIsHorizontal = paramBoolean;
    this.mLinearLayout = new LinearLayout(paramContext);
    Object localObject = this.mLinearLayout;
    int i;
    if (paramBoolean)
    {
      i = 0;
      ((LinearLayout)localObject).setOrientation(i);
      if (!paramBoolean) {
        break label196;
      }
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(this.sideGapWidthHorizontal, this.sideGapHeightHorizontal, this.sideGapWidthHorizontal, this.sideGapHeightHorizontal);
    }
    for (;;)
    {
      this.mLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addView(this.mLinearLayout);
      this.mAdIcon = new ImageView(paramContext);
      this.mAdIcon.setImageDrawable(getResources().getDrawable(2130841040));
      paramContext = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(19.299999F), ViewUtils.dpToPx(11.3F));
      paramContext.addRule(9);
      paramContext.addRule(10);
      this.mAdIcon.setLayoutParams(paramContext);
      this.mAdIcon.setVisibility(8);
      addView(this.mAdIcon);
      setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      return;
      i = 1;
      break;
      label196:
      localObject = new RelativeLayout.LayoutParams(this.verticalWidth, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, this.sideGapHeightVertical, 0, this.sideGapHeightVertical);
    }
  }
  
  private void startMultiBlockAnimation()
  {
    float f = ViewUtils.dip2px(5.0F);
    Object localObject1 = new ObjectAnimator();
    ((ObjectAnimator)localObject1).setPropertyName("translationY");
    ((ObjectAnimator)localObject1).setFloatValues(new float[] { 0.0F, f });
    Object localObject2 = new ObjectAnimator();
    ((ObjectAnimator)localObject2).setPropertyName("translationY");
    ((ObjectAnimator)localObject2).setFloatValues(new float[] { f, 0.0F });
    ObjectAnimator localObjectAnimator1 = new ObjectAnimator();
    localObjectAnimator1.setPropertyName("translationY");
    localObjectAnimator1.setFloatValues(new float[] { 0.0F, f });
    ObjectAnimator localObjectAnimator2 = new ObjectAnimator();
    localObjectAnimator2.setPropertyName("translationY");
    localObjectAnimator2.setFloatValues(new float[] { f, 0.0F });
    this.animatorSet = new AnimatorSet();
    this.animatorSet.setInterpolator(new LinearInterpolator());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    localArrayList.add(localObject2);
    localArrayList.add(localObjectAnimator1);
    localArrayList.add(localObjectAnimator2);
    this.animatorSet.setDuration(120L);
    this.animatorSet.playSequentially(localArrayList);
    if (this.blockList.size() < 1) {
      return;
    }
    this.animatorSet.setTarget(this.blockList.get(0));
    this.animatorSet.start();
    localObject1 = new Handler(Looper.getMainLooper());
    localObject2 = new BlockAdView.1(this);
    this.animatorSet.addListener(new BlockAdView.2(this, (Handler)localObject1, (Runnable)localObject2));
    ((Handler)localObject1).post((Runnable)localObject2);
  }
  
  private void startSingleBlockAnimation()
  {
    Object localObject1 = ObjectAnimator.ofFloat(this, "rotation", new float[] { 0.0F, 15.0F });
    ((ObjectAnimator)localObject1).setDuration(120L);
    Object localObject2 = ObjectAnimator.ofFloat(this, "rotation", new float[] { 15.0F, -15.0F });
    ((ObjectAnimator)localObject2).setDuration(120L);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "rotation", new float[] { -15.0F, 15.0F });
    localObjectAnimator1.setDuration(120L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "rotation", new float[] { 15.0F, 0.0F });
    localObjectAnimator2.setDuration(120L);
    this.animatorSet = new AnimatorSet();
    this.animatorSet.setInterpolator(new LinearInterpolator());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    localArrayList.add(localObject2);
    localArrayList.add(localObjectAnimator1);
    localArrayList.add(localObjectAnimator2);
    this.animatorSet.playSequentially(localArrayList);
    localObject1 = new Handler(Looper.getMainLooper());
    localObject2 = new BlockAdView.3(this);
    ((Handler)localObject1).post((Runnable)localObject2);
    this.animatorSet.addListener(new BlockAdView.4(this, (Handler)localObject1, (Runnable)localObject2));
  }
  
  private void updateAdIcon(boolean paramBoolean)
  {
    if (this.mAdIcon == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mAdIcon.setVisibility(0);
      return;
    }
    this.mAdIcon.setVisibility(8);
  }
  
  private void updateBackground(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setBackgroundDrawable(getResources().getDrawable(2130841042));
      return;
    }
    setBackgroundColor(getResources().getColor(2131166636));
  }
  
  public void clearBlockAdAnimation()
  {
    this.hasEndBlockAdAnimation = true;
    if (this.animatorSet != null) {
      this.animatorSet.end();
    }
    if (this.blockList != null) {
      this.blockList.clear();
    }
    this.mPlayCount = 0;
  }
  
  public int getRealAdNum()
  {
    return this.mRealAdNum;
  }
  
  public int getRealHeight()
  {
    if (this.mIsHorizontal) {
      return this.horizontalHeight + this.sideGapHeightHorizontal * 2;
    }
    return this.mRealAdNum * this.verticalSingleBlockHeight + this.sideGapHeightVertical * 2;
  }
  
  public int getRealWidth()
  {
    if (this.mIsHorizontal) {
      return this.mRealAdNum * this.horizontalSingleBlockWidth + this.sideGapWidthHorizontal * 2;
    }
    return this.verticalWidth + 0;
  }
  
  public void setData(BlockAdInfo paramBlockAdInfo)
  {
    paramBlockAdInfo = calculateAndAdjustBlockAdInfo(paramBlockAdInfo);
    if (paramBlockAdInfo == null) {
      this.mRealAdNum = 0;
    }
    adjustUIUsingNewData(paramBlockAdInfo);
  }
  
  public void startBlockAnimation()
  {
    this.hasEndBlockAdAnimation = false;
    if (this.mRealAdNum == 1)
    {
      startSingleBlockAnimation();
      return;
    }
    startMultiBlockAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView
 * JD-Core Version:    0.7.0.1
 */