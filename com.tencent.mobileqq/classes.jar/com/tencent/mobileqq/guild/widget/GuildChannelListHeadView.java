package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.util.QQGuildViewUtils;
import com.tencent.qphone.base.util.QLog;

public class GuildChannelListHeadView
  extends FrameLayout
  implements ISiblingTouchEventDispatcher
{
  private int a;
  private ViewGroup b;
  
  public GuildChannelListHeadView(@NonNull Context paramContext)
  {
    this(paramContext, null, 0, 0);
  }
  
  public GuildChannelListHeadView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 0);
  }
  
  public GuildChannelListHeadView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public GuildChannelListHeadView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    try
    {
      LayoutInflater.from(paramContext).inflate(2131625050, this);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ListViewHeadView", 1, "Inflate Error!", paramContext);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = super.dispatchTouchEvent(paramMotionEvent);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.b != null)
      {
        int i = getTop();
        int j = this.b.getTop();
        int k = getLeft();
        int m = this.b.getLeft();
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        paramMotionEvent.offsetLocation(k - m, i - j);
        bool1 = this.b.dispatchTouchEvent(paramMotionEvent);
      }
    }
    return bool1;
  }
  
  public int getTopPaddingHeight()
  {
    return this.a;
  }
  
  public void setShowJoinButton(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      findViewById(2131430163).setVisibility(0);
      return;
    }
    findViewById(2131430163).setVisibility(8);
  }
  
  public void setSiblingLayout(ViewGroup paramViewGroup)
  {
    this.b = paramViewGroup;
  }
  
  public void setTopPadding(int paramInt)
  {
    this.a = paramInt;
    QQGuildViewUtils.a(findViewById(2131437014), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.GuildChannelListHeadView
 * JD-Core Version:    0.7.0.1
 */