package com.tencent.mobileqq.guild.base;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildNameBaseFragment$1
  implements View.OnClickListener
{
  QQGuildNameBaseFragment$1(QQGuildNameBaseFragment paramQQGuildNameBaseFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.q.getText() != null) && (this.a.q.getText().length() > 0)) {
      this.a.q.setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */