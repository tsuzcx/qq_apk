package com.tencent.mobileqq.filemanager.widget;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SendBottomBar$4
  implements View.OnClickListener
{
  SendBottomBar$4(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (!SendBottomBar.b(this.a))
    {
      SendBottomBar.a(this.a, true);
      new Handler().postDelayed(new SendBottomBar.4.1(this), 800L);
      SendBottomBar.b(this.a);
      int i = SendBottomBar.a(this.a).b();
      if (i != 1)
      {
        if (i != 5) {
          switch (i)
          {
          default: 
            if (!AppNetConnInfo.isNetSupport())
            {
              FMToastUtil.a(2131698210);
            }
            else
            {
              int j = SendBottomBar.a(this.a).a();
              if (j == 1) {
                i = 1;
              } else {
                i = 0;
              }
              if (j == 5) {
                this.a.c();
              } else if (i != 0) {
                SendBottomBar.a(this.a, true);
              } else {
                SendBottomBar.h(this.a);
              }
            }
            break;
          case 10: 
            SendBottomBar.d(this.a);
            break;
          case 9: 
            this.a.b();
            break;
          case 8: 
            SendBottomBar.g(this.a);
            break;
          case 7: 
            SendBottomBar.c(this.a);
            break;
          }
        } else {
          SendBottomBar.f(this.a);
        }
      }
      else {
        SendBottomBar.e(this.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.4
 * JD-Core Version:    0.7.0.1
 */