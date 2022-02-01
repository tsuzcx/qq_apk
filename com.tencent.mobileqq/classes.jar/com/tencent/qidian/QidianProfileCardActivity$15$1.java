package com.tencent.qidian;

import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QidianProfileCardActivity$15$1
  implements View.OnClickListener
{
  QidianProfileCardActivity$15$1(QidianProfileCardActivity.15 param15) {}
  
  public void onClick(View paramView)
  {
    ((ClipboardManager)this.a.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.15.1
 * JD-Core Version:    0.7.0.1
 */