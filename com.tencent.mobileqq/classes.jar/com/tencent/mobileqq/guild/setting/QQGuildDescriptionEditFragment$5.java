package com.tencent.mobileqq.guild.setting;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.guild.util.QQGuildTextUtils;
import com.tencent.mobileqq.guild.util.QQGuildTextUtils.CharacterCountInfo;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildDescriptionEditFragment$5
  implements View.OnClickListener
{
  QQGuildDescriptionEditFragment$5(QQGuildDescriptionEditFragment paramQQGuildDescriptionEditFragment) {}
  
  @RequiresApi(api=21)
  public void onClick(View paramView)
  {
    Editable localEditable = this.a.p.getText();
    if (QQGuildTextUtils.a(localEditable).b() <= 25.0F) {
      if (QQGuildTextUtils.a(localEditable).b() <= 0.0F) {
        QQGuildDescriptionEditFragment.a(this.a, "");
      } else {
        QQGuildDescriptionEditFragment.a(this.a, localEditable);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildDescriptionEditFragment.5
 * JD-Core Version:    0.7.0.1
 */