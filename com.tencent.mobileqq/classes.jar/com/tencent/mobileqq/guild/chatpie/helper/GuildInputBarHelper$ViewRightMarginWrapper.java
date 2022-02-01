package com.tencent.mobileqq.guild.chatpie.helper;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.Keep;

public class GuildInputBarHelper$ViewRightMarginWrapper
{
  View a;
  
  public GuildInputBarHelper$ViewRightMarginWrapper(View paramView)
  {
    this.a = paramView;
  }
  
  @Keep
  public int getTrueRightMargin()
  {
    if ((this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
      return ((ViewGroup.MarginLayoutParams)this.a.getLayoutParams()).rightMargin;
    }
    return 0;
  }
  
  @Keep
  public void setTrueRightMargin(int paramInt)
  {
    Object localObject = this.a.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt;
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper.ViewRightMarginWrapper
 * JD-Core Version:    0.7.0.1
 */