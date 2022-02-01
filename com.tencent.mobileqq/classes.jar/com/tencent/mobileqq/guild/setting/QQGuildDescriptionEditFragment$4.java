package com.tencent.mobileqq.guild.setting;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.guild.api.IGuildSoftKeyboardObserver;
import com.tencent.mobileqq.qroute.QRoute;

class QQGuildDescriptionEditFragment$4
  implements View.OnFocusChangeListener
{
  QQGuildDescriptionEditFragment$4(QQGuildDescriptionEditFragment paramQQGuildDescriptionEditFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQGuildDescriptionEditFragment.a(this.a, (IGuildSoftKeyboardObserver)QRoute.api(IGuildSoftKeyboardObserver.class));
      QQGuildDescriptionEditFragment.c(this.a).newSoftKeyboardObserverImpl(paramView, new QQGuildDescriptionEditFragment.4.1(this));
      return;
    }
    this.a.r.setVisibility(8);
    if (QQGuildDescriptionEditFragment.c(this.a) != null) {
      QQGuildDescriptionEditFragment.c(this.a).destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildDescriptionEditFragment.4
 * JD-Core Version:    0.7.0.1
 */