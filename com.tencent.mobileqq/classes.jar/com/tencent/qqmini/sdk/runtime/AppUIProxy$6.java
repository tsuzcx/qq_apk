package com.tencent.qqmini.sdk.runtime;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.action.AppStateEvent;

class AppUIProxy$6
  implements View.OnClickListener
{
  AppUIProxy$6(AppUIProxy paramAppUIProxy) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.btn_close)
    {
      AppStateEvent.obtain(60).notifyRuntime(this.this$0.getRuntime());
      this.this$0.quit();
    }
    else
    {
      paramView.getId();
      int i = R.id.btn_more_menu;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.6
 * JD-Core Version:    0.7.0.1
 */