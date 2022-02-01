package com.tencent.mobileqq.ecshop.view.hippy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;

public class QQShopHeaderView
  extends LinearLayout
  implements HippyViewBase
{
  public QQShopHeaderView(@NonNull Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(getContext()).inflate(2131561475, this);
  }
  
  public QQShopHeaderView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.hippy.QQShopHeaderView
 * JD-Core Version:    0.7.0.1
 */