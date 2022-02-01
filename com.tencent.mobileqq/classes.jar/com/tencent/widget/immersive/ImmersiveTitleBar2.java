package com.tencent.widget.immersive;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

public class ImmersiveTitleBar2
  extends View
{
  public static boolean TRANSLUCENT_STATUS_BAR = true;
  public static boolean mNeedDrawStatus = true;
  private int mStatusBarHeight;
  public int mViewHeight;
  
  public ImmersiveTitleBar2(Context paramContext)
  {
    super(paramContext);
    initUI(paramContext);
  }
  
  public ImmersiveTitleBar2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI(paramContext);
  }
  
  public ImmersiveTitleBar2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI(paramContext);
  }
  
  public void initUI(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "ImmersiveTitleBar initUI");
    }
    boolean bool2 = TRANSLUCENT_STATUS_BAR;
    boolean bool1 = true;
    if ((!bool2) || (ImmersiveUtils.isSupporImmersive() != 1)) {
      bool1 = false;
    }
    mNeedDrawStatus = bool1;
    this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(paramContext);
    if (mNeedDrawStatus) {
      setCustomHeight(this.mStatusBarHeight);
    } else {
      setCustomHeight(0);
    }
    if (QQTheme.b())
    {
      setBackgroundResource(2130850433);
      return;
    }
    setBackgroundColor(getResources().getColor(2131167114));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mViewHeight, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.mViewHeight);
  }
  
  public void resetBkColor(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  public void setCustomHeight(int paramInt)
  {
    this.mViewHeight = paramInt;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.immersive.ImmersiveTitleBar2
 * JD-Core Version:    0.7.0.1
 */