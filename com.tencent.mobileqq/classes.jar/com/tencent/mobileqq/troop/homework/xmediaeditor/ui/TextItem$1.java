package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class TextItem$1
  implements View.OnClickListener
{
  TextItem$1(TextItem paramTextItem) {}
  
  public void onClick(View paramView)
  {
    if (!paramView.hasFocus())
    {
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new TextItem.1.1(this, paramView));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.1
 * JD-Core Version:    0.7.0.1
 */