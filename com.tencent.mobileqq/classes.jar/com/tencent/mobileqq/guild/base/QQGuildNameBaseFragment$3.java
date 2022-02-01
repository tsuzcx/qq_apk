package com.tencent.mobileqq.guild.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildNameBaseFragment$3
  implements View.OnClickListener
{
  QQGuildNameBaseFragment$3(QQGuildNameBaseFragment paramQQGuildNameBaseFragment) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.q.getText().toString();
    this.a.a(str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */