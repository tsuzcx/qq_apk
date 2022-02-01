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
  public static final String AD_REF_ID = "biz_src_miniappD";
  private static final String TAG = "[minigame]BlockAdView";
  private AnimatorSet animatorSet;
  private ArrayList<BlockAdView.SingleBlockAdView> blockList = new ArrayList();
  private boolean hasEndBlockAdAnimation = false;
  public final int horizontalHeight = ViewUtils.b(65.0F);
  public final int horizontalSingleBlockWidth = ViewUtils.b(65.0F);
  protected ImageView mAdIcon;
  private boolean mIsHorizontal = false;
  protected LinearLayout mLinearLayout;
  private int mPlayCount = 0;
  private int mRealAdNum = 0;
  public final int sideGapHeightHorizontal = ViewUtils.b(4.0F);
  public final int sideGapHeightVertical = ViewUtils.b(4.0F);
  public final int sideGapWidthHorizontal = ViewUtils.b(4.0F);
  public final int sideGapWidthVertical = 0;
  public final int verticalSingleBlockHeight = ViewUtils.b(73.0F);
  public final int verticalWidth = ViewUtils.b(65.0F);
  
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
    boolean bool1 = checkIsDataInvalid(paramBlockAdInfo);
    boolean bool2 = false;
    if (bool1)
    {
      this.mRealAdNum = 0;
      clearBlockAdAnimation();
      setVisibility(8);
      return;
    }
    if ((this.mRealAdNum == 1) && (this.mIsHorizontal))
    {
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      i = this.sideGapHeightHorizontal;
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, i, 0, i);
      this.mLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    Object localObject1 = paramBlockAdInfo.getGdtAdInfoList().subList(0, this.mRealAdNum);
    paramBlockAdInfo = paramBlockAdInfo.getBlockAdInfo().subList(0, this.mRealAdNum);
    clearBlockAdAnimation();
    this.mLinearLayout.removeAllViewsInLayout();
    int i = 0;
    while (i < this.mRealAdNum)
    {
      Object localObject2 = getContext();
      if (this.mRealAdNum < 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject2 = new BlockAdView.SingleBlockAdView(this, (Context)localObject2, bool1);
      ((BlockAdView.SingleBlockAdView)localObject2).setData((MiniAppInfo)paramBlockAdInfo.get(i), (GdtAd)((List)localObject1).get(i), this.mRealAdNum);
      this.mLinearLayout.addView((View)localObject2);
      this.blockList.add(localObject2);
      i += 1;
    }
    updateBackground(true);
    bool1 = bool2;
    if (this.mRealAdNum > 2) {
      bool1 = true;
    }
    updateAdIcon(bool1);
  }
  
  private BlockAdInfo calculateAndAdjustBlockAdInfo(BlockAdInfo paramBlockAdInfo)
  {
    if (paramBlockAdInfo == null) {
      return null;
    }
    int j = getSafeGap();
    int k = BlockAdManager.getInstance().getGameWidth();
    int i = j * 2;
    int m = k - i;
    int i1 = BlockAdManager.getInstance().getGameHeight() - i;
    int n = BlockAdManager.getInstance().gameDpTopx(paramBlockAdInfo.getLeft());
    int i2 = BlockAdManager.getInstance().gameDpTopx(paramBlockAdInfo.getTop());
    i = paramBlockAdInfo.getSize();
    this.mRealAdNum = i;
    if (n >= j)
    {
      if (i2 < j) {
        return null;
      }
      if (this.mIsHorizontal)
      {
        k = this.horizontalHeight + this.sideGapHeightHorizontal * 2;
        if (i2 + k > i1) {
          return null;
        }
        i1 = this.horizontalSingleBlockWidth;
        if (n + i1 > m) {
          return null;
        }
        i2 = this.sideGapWidthHorizontal;
        j = i * i1 + i2 * 2;
        i = j;
        if (n + j > m)
        {
          j = (m - n - i2 * 2) / i1;
          this.mRealAdNum = j;
          i = i1 * j + i2 * 2;
          if (j == 0) {
            return null;
          }
        }
        j = i;
        i = k;
      }
      else
      {
        j = this.verticalWidth + 0;
        if (n + j > m) {
          return null;
        }
        k = this.verticalSingleBlockHeight;
        if (i2 + k > i1) {
          return null;
        }
        i *= k;
        if (i2 + i > i1)
        {
          m = (i1 - i2 + 0) / k;
          this.mRealAdNum = m;
          i = k * m;
          if (m == 0) {
            return null;
          }
        }
      }
      paramBlockAdInfo.setRealWidth(ViewUtils.c(j));
      paramBlockAdInfo.setRealHeight(ViewUtils.c(i));
      return paramBlockAdInfo;
    }
    return null;
  }
  
  private boolean checkIsDataInvalid(BlockAdInfo paramBlockAdInfo)
  {
    int i = this.mRealAdNum;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i >= 1)
    {
      bool1 = bool2;
      if (paramBlockAdInfo != null)
      {
        bool1 = bool2;
        if (paramBlockAdInfo.getGdtAdInfoList() != null)
        {
          bool1 = bool2;
          if (paramBlockAdInfo.getGdtAdInfoList().size() >= this.mRealAdNum)
          {
            bool1 = bool2;
            if (paramBlockAdInfo.getBlockAdInfo() != null)
            {
              if (paramBlockAdInfo.getBlockAdInfo().size() < this.mRealAdNum) {
                return true;
              }
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private int getPlayCount()
  {
    return this.mPlayCount;
  }
  
  public static int getSafeGap()
  {
    int i;
    if (BlockAdManager.getInstance().getDensity() >= 3.0F) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = 8;
    } else {
      i = 16;
    }
    return BlockAdManager.getInstance().gameDpTopx(i);
  }
  
  private void init(Context paramContext, boolean paramBoolean)
  {
    this.mIsHorizontal = paramBoolean;
    this.mLinearLayout = new LinearLayout(paramContext);
    this.mLinearLayout.setOrientation(paramBoolean ^ true);
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (paramBoolean)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      i = this.sideGapWidthHorizontal;
      int j = this.sideGapHeightHorizontal;
      localLayoutParams.setMargins(i, j, i, j);
    }
    else
    {
      localLayoutParams = new RelativeLayout.LayoutParams(this.verticalWidth, -2);
      i = this.sideGapHeightVertical;
      localLayoutParams.setMargins(0, i, 0, i);
    }
    this.mLinearLayout.setLayoutParams(localLayoutParams);
    addView(this.mLinearLayout);
    this.mAdIcon = new ImageView(paramContext);
    this.mAdIcon.setImageDrawable(getResources().getDrawable(2130841073));
    paramContext = new RelativeLayout.LayoutParams(ViewUtils.b(19.299999F), ViewUtils.b(11.3F));
    paramContext.addRule(9);
    paramContext.addRule(10);
    this.mAdIcon.setLayoutParams(paramContext);
    this.mAdIcon.setVisibility(8);
    addView(this.mAdIcon);
    setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
  }
  
  private void startMultiBlockAnimation()
  {
    float f = ViewUtils.a(5.0F);
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
    ImageView localImageView = this.mAdIcon;
    if (localImageView == null) {
      return;
    }
    if (paramBoolean)
    {
      localImageView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(8);
  }
  
  private void updateBackground(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setBackgroundDrawable(getResources().getDrawable(2130841075));
      return;
    }
    setBackgroundColor(getResources().getColor(2131166669));
  }
  
  public void clearBlockAdAnimation()
  {
    this.hasEndBlockAdAnimation = true;
    Object localObject = this.animatorSet;
    if (localObject != null) {
      ((AnimatorSet)localObject).end();
    }
    localObject = this.blockList;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    this.mPlayCount = 0;
  }
  
  public int getRealAdNum()
  {
    return this.mRealAdNum;
  }
  
  public int getRealHeight()
  {
    int i;
    if (this.mIsHorizontal) {
      i = this.horizontalHeight;
    }
    for (int j = this.sideGapHeightHorizontal;; j = this.sideGapHeightVertical)
    {
      return i + j * 2;
      i = this.mRealAdNum * this.verticalSingleBlockHeight;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView
 * JD-Core Version:    0.7.0.1
 */