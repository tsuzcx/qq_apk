package com.tencent.qqmini.miniapp.core.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class NativeViewContainer$9
  implements View.OnClickListener
{
  NativeViewContainer$9(NativeViewContainer paramNativeViewContainer) {}
  
  public void onClick(View paramView)
  {
    List localList = NativeViewContainer.access$200(this.this$0);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < NativeViewContainer.access$200(this.this$0).size())
        {
          NativeViewContainer.IConfirmListerner localIConfirmListerner = (NativeViewContainer.IConfirmListerner)NativeViewContainer.access$200(this.this$0).get(i);
          if (localIConfirmListerner != null) {
            localIConfirmListerner.onConfirm();
          }
        }
        else
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.9
 * JD-Core Version:    0.7.0.1
 */