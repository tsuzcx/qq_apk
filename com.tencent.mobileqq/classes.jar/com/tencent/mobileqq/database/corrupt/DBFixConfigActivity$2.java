package com.tencent.mobileqq.database.corrupt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DBFixConfigActivity$2
  implements View.OnClickListener
{
  DBFixConfigActivity$2(DBFixConfigActivity paramDBFixConfigActivity) {}
  
  public void onClick(View paramView)
  {
    ThreadManager.post(this.a.j, 8, null, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.2
 * JD-Core Version:    0.7.0.1
 */