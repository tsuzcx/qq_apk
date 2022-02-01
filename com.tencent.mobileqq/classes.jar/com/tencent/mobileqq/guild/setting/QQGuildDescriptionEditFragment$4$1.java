package com.tencent.mobileqq.guild.setting;

import android.content.res.Resources;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mobileqq.guild.api.IGuildSoftKeyboardObserver.OnSoftKeyboardToggledListenerTemp;

class QQGuildDescriptionEditFragment$4$1
  implements IGuildSoftKeyboardObserver.OnSoftKeyboardToggledListenerTemp
{
  QQGuildDescriptionEditFragment$4$1(QQGuildDescriptionEditFragment.4 param4) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      this.a.a.r.setVisibility(0);
      QQGuildDescriptionEditFragment.a(this.a.a, true);
      this.a.a.s.setBackground(this.a.a.getResources().getDrawable(2130849798));
      QQGuildDescriptionEditFragment.b(this.a.a).setVisibility(8);
      return;
    }
    if ((QQGuildDescriptionEditFragment.b(this.a.a).getVisibility() == 8) && (QQGuildDescriptionEditFragment.a(this.a.a))) {
      this.a.a.r.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildDescriptionEditFragment.4.1
 * JD-Core Version:    0.7.0.1
 */