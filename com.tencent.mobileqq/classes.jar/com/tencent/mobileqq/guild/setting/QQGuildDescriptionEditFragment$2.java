package com.tencent.mobileqq.guild.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildDescriptionEditFragment$2
  implements View.OnClickListener
{
  QQGuildDescriptionEditFragment$2(QQGuildDescriptionEditFragment paramQQGuildDescriptionEditFragment) {}
  
  public void onClick(View paramView)
  {
    QQGuildDescriptionEditFragment localQQGuildDescriptionEditFragment = this.a;
    QQGuildDescriptionEditFragment.a(localQQGuildDescriptionEditFragment, QQGuildDescriptionEditFragment.a(localQQGuildDescriptionEditFragment) ^ true);
    if (!QQGuildDescriptionEditFragment.a(this.a))
    {
      this.a.j();
      this.a.s.setContentDescription(HardCodeUtil.a(2131901744));
    }
    else
    {
      this.a.p.setCursorVisible(true);
      this.a.i();
      this.a.r.setVisibility(0);
      this.a.s.setContentDescription(HardCodeUtil.a(2131901742));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildDescriptionEditFragment.2
 * JD-Core Version:    0.7.0.1
 */