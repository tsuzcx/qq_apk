package com.tencent.mobileqq.flashshow.widgets.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSBaseInputPopupWindow$2
  implements View.OnClickListener
{
  FSBaseInputPopupWindow$2(FSBaseInputPopupWindow paramFSBaseInputPopupWindow) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSBaseInputPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */