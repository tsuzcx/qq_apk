package com.tencent.mobileqq.guild.channel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;

class QQGuildChannelModidyCategoryFragment$2
  implements View.OnClickListener
{
  QQGuildChannelModidyCategoryFragment$2(QQGuildChannelModidyCategoryFragment paramQQGuildChannelModidyCategoryFragment) {}
  
  public void onClick(View paramView)
  {
    if (QQGuildChannelModidyCategoryFragment.a(this.a) != null) {
      InputMethodUtil.b(QQGuildChannelModidyCategoryFragment.a(this.a));
    }
    String str = QQGuildChannelModidyCategoryFragment.a(this.a).getText().toString();
    QQGuildChannelModidyCategoryFragment.a(this.a, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelModidyCategoryFragment.2
 * JD-Core Version:    0.7.0.1
 */