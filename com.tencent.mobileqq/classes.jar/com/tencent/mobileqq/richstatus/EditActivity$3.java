package com.tencent.mobileqq.richstatus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditActivity$3
  implements View.OnClickListener
{
  EditActivity$3(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.EditActivity.3
 * JD-Core Version:    0.7.0.1
 */