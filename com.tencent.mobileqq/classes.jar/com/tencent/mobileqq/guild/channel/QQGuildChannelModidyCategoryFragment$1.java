package com.tencent.mobileqq.guild.channel;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildChannelModidyCategoryFragment$1
  implements View.OnClickListener
{
  QQGuildChannelModidyCategoryFragment$1(QQGuildChannelModidyCategoryFragment paramQQGuildChannelModidyCategoryFragment) {}
  
  public void onClick(View paramView)
  {
    if ((QQGuildChannelModidyCategoryFragment.a(this.a).getText() != null) && (QQGuildChannelModidyCategoryFragment.a(this.a).getText().length() > 0)) {
      QQGuildChannelModidyCategoryFragment.a(this.a).setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelModidyCategoryFragment.1
 * JD-Core Version:    0.7.0.1
 */