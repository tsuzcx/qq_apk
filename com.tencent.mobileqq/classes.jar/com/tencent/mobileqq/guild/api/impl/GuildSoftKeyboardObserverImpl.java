package com.tencent.mobileqq.guild.api.impl;

import android.view.View;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.mobileqq.guild.api.IGuildSoftKeyboardObserver;
import com.tencent.mobileqq.guild.api.IGuildSoftKeyboardObserver.OnSoftKeyboardToggledListenerTemp;
import com.tencent.widget.immersive.ImmersiveUtils;

public class GuildSoftKeyboardObserverImpl
  implements IGuildSoftKeyboardObserver
{
  private SoftKeyboardObserver mSoftKeyboardObserver;
  
  public void destroy()
  {
    SoftKeyboardObserver localSoftKeyboardObserver = this.mSoftKeyboardObserver;
    if (localSoftKeyboardObserver != null) {
      localSoftKeyboardObserver.a();
    }
  }
  
  public void newSoftKeyboardObserverImpl(View paramView, IGuildSoftKeyboardObserver.OnSoftKeyboardToggledListenerTemp paramOnSoftKeyboardToggledListenerTemp)
  {
    this.mSoftKeyboardObserver = new SoftKeyboardObserver(paramView, new GuildSoftKeyboardObserverImpl.1(this, paramOnSoftKeyboardToggledListenerTemp), ImmersiveUtils.getStatusBarHeight(paramView.getContext()) + 160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildSoftKeyboardObserverImpl
 * JD-Core Version:    0.7.0.1
 */