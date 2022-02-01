package com.tencent.mobileqq.guild.chatpie.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class GuildLiveChannelXPanelContainer
  extends XPanelContainer
{
  private final int o;
  private int p = ViewUtils.dpToPx(196.0F);
  
  public GuildLiveChannelXPanelContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuildLiveChannelXPanelContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.o = paramContext.getResources().getColor(2131166225);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        localView.setBackgroundColor(this.o);
        a((ViewGroup)localView);
      }
      i += 1;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, View paramView)
  {
    super.a(paramInt1, paramInt2 + this.p, paramInt3, paramInt4, paramBoolean, paramView);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (paramInt != 1)
    {
      ViewGroup localViewGroup = (ViewGroup)getCurrentPanelView();
      if (localViewGroup == null) {
        return;
      }
      Drawable localDrawable = localViewGroup.getBackground();
      if (((localDrawable instanceof ColorDrawable)) && (((ColorDrawable)localDrawable).getColor() == this.o)) {
        return;
      }
      localViewGroup.setBackgroundColor(this.o);
      a(localViewGroup);
    }
  }
  
  protected boolean a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("normalScreenLayout changed =  ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", left = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", top = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", right = ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", bottom = ");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(", softInputShowing = ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(", mStatus = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mPendingStatus = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mClickStatus = ");
    localStringBuilder.append(this.j);
    QLog.d("Guild_XPanelContainer", 4, localStringBuilder.toString());
    paramBoolean1 = super.a(paramBoolean1, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean2, paramView);
    paramView = new StringBuilder();
    paramView.append("mSoftInputChange = ");
    paramView.append(this.l);
    paramView.append(", mSoftInputShowing = ");
    paramView.append(this.k);
    QLog.d("Guild_XPanelContainer", 4, paramView.toString());
    return paramBoolean1;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = super.a(paramBoolean1, paramBoolean2);
    if (this.e == 1)
    {
      setStatus(0);
      requestLayout();
    }
    return paramBoolean1;
  }
  
  protected void b(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, View paramView)
  {
    int i = paramInt2;
    if (this.e == 0) {
      i = paramInt2 + this.p;
    }
    super.b(paramBoolean1, paramInt1, i, paramInt3, paramInt4, paramBoolean2, paramView);
  }
  
  public void setPaddingTop(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPaddingTop paddingTop = ");
    localStringBuilder.append(paramInt);
    QLog.d("Guild_XPanelContainer", 4, localStringBuilder.toString());
    if (paramInt <= 0) {
      return;
    }
    this.p = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.view.GuildLiveChannelXPanelContainer
 * JD-Core Version:    0.7.0.1
 */