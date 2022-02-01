package com.tencent.mobileqq.mini.profilecard;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import java.util.List;

public abstract class BaseMiniAppProfileCardView
  extends LinearLayout
{
  public BaseMiniAppProfileCardView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseMiniAppProfileCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseMiniAppProfileCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void setData(List<INTERFACE.StApiAppInfo> paramList);
  
  public abstract void setTextColor(int paramInt);
  
  public abstract void setTextColor(ColorStateList paramColorStateList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView
 * JD-Core Version:    0.7.0.1
 */