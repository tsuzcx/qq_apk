package com.tencent.mobileqq.minigame.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bhtq;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;

public class BlockAdView
  extends RelativeLayout
{
  public final int horizontalHeight = bhtq.b(65.0F);
  public final int horizontalSingleBlockWidth = bhtq.b(65.0F);
  protected ImageView mAdIcon;
  protected BlockAdView.BlockAdapter mAdapter;
  private Context mContext;
  private boolean mIsHorizontal;
  private int mRealAdNum;
  public final int sideGapHeightHorizontal = bhtq.b(4.0F);
  public final int sideGapHeightVertical = bhtq.b(4.0F);
  public final int sideGapWidthHorizontal = bhtq.b(4.0F);
  public final int sideGapWidthVertical = 0;
  public final int verticalSingleBlockHeight = bhtq.b(73.0F);
  public final int verticalWidth = bhtq.b(65.0F);
  
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
  
  private BlockAdInfo calculateAndAdjustBlockAdInfo(BlockAdInfo paramBlockAdInfo)
  {
    int m = 0;
    int k = 0;
    if (paramBlockAdInfo == null) {
      return null;
    }
    int i = getSafeGap();
    int n = BlockAdManager.getInstance().getGameWidth() - i * 2;
    int i3 = BlockAdManager.getInstance().getGameHeight() - i * 2;
    int i1 = BlockAdManager.getInstance().gameDpTopx(paramBlockAdInfo.getLeft());
    int i4 = BlockAdManager.getInstance().gameDpTopx(paramBlockAdInfo.getTop());
    int i2 = paramBlockAdInfo.getSize();
    this.mRealAdNum = i2;
    if ((i1 < i) || (i4 < i)) {
      return null;
    }
    int j;
    if (this.mIsHorizontal)
    {
      i = this.horizontalHeight;
      i = this.sideGapHeightHorizontal * 2 + i;
      if (i4 + i > i3) {
        return null;
      }
      if (this.horizontalSingleBlockWidth + i1 > n) {
        return null;
      }
      m = this.horizontalSingleBlockWidth;
      if (i2 == 1)
      {
        j = 0;
        j += i2 * m;
        if (i1 + j <= n) {
          break label404;
        }
        if (i2 != 1) {
          break label229;
        }
        j = 0;
        label177:
        m = (n - i1 - j) / this.horizontalSingleBlockWidth;
        this.mRealAdNum = m;
        n = this.horizontalSingleBlockWidth;
        if (m != 1) {
          break label239;
        }
      }
      label229:
      label239:
      for (j = k;; j = this.sideGapWidthHorizontal * 2)
      {
        if (m != 0) {
          break label249;
        }
        return null;
        j = this.sideGapWidthHorizontal * 2;
        break;
        j = this.sideGapWidthHorizontal * 2;
        break label177;
      }
      label249:
      j = n * m + j;
    }
    label404:
    for (;;)
    {
      paramBlockAdInfo.setRealWidth(bhtq.c(j));
      paramBlockAdInfo.setRealHeight(bhtq.c(i));
      return paramBlockAdInfo;
      i = this.verticalWidth;
      if (i2 == 1) {}
      j = i + 0;
      if (i1 + j > n) {
        return null;
      }
      if (this.verticalSingleBlockHeight + i4 > i3) {
        return null;
      }
      k = this.verticalSingleBlockHeight * i2;
      i = k;
      if (i4 + k > i3)
      {
        if (i2 == 1) {}
        k = (i3 - i4 + 0) / this.verticalSingleBlockHeight;
        this.mRealAdNum = k;
        n = this.verticalSingleBlockHeight;
        i = m;
        if (k == 1) {
          i = bhtq.b(8.0F);
        }
        i = n * k - i;
        if (k == 0) {
          return null;
        }
      }
    }
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
    this.mContext = paramContext;
    this.mAdapter = new BlockAdView.BlockAdapter(this);
    this.mIsHorizontal = paramBoolean;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      localObject = new HorizontalListView(paramContext);
      ((HorizontalListView)localObject).setAdapter(this.mAdapter);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(this.sideGapWidthHorizontal, this.sideGapHeightHorizontal, this.sideGapWidthHorizontal, this.sideGapHeightHorizontal);
      ((HorizontalListView)localObject).setLayoutParams(localLayoutParams);
      addView((View)localObject);
    }
    for (;;)
    {
      this.mAdIcon = new ImageView(paramContext);
      this.mAdIcon.setImageDrawable(getResources().getDrawable(2130841004));
      paramContext = new RelativeLayout.LayoutParams(bhtq.b(19.299999F), bhtq.b(11.3F));
      paramContext.addRule(9);
      paramContext.addRule(10);
      this.mAdIcon.setLayoutParams(paramContext);
      this.mAdIcon.setVisibility(8);
      addView(this.mAdIcon);
      setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      return;
      localObject = new ListView(paramContext);
      ((ListView)localObject).setAdapter(this.mAdapter);
      localLayoutParams = new RelativeLayout.LayoutParams(this.verticalWidth, -2);
      localLayoutParams.setMargins(0, this.sideGapHeightVertical, 0, this.sideGapHeightVertical);
      ((ListView)localObject).setLayoutParams(localLayoutParams);
      ((ListView)localObject).setDivider(null);
      addView((View)localObject);
    }
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
      setBackgroundDrawable(getResources().getDrawable(2130841006));
      return;
    }
    setBackgroundColor(getResources().getColor(2131166617));
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
    boolean bool2 = true;
    paramBlockAdInfo = calculateAndAdjustBlockAdInfo(paramBlockAdInfo);
    if (paramBlockAdInfo == null) {
      this.mRealAdNum = 0;
    }
    if ((this.mAdapter != null) && (paramBlockAdInfo != null))
    {
      this.mAdapter.setData(paramBlockAdInfo);
      if (this.mAdapter.getCount() <= 1) {
        break label80;
      }
      bool1 = true;
      updateBackground(bool1);
      if (this.mAdapter.getCount() <= 2) {
        break label85;
      }
    }
    label80:
    label85:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      updateAdIcon(bool1);
      this.mAdapter.notifyDataSetChanged();
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView
 * JD-Core Version:    0.7.0.1
 */