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
    if (!SendBottomBar.h(this.a))
    {
      SendBottomBar.a(this.a, true);
      new Handler().postDelayed(new SendBottomBar.4.1(this), 800L);
      SendBottomBar.i(this.a);
      int i = SendBottomBar.c(this.a).u();
      if (i != 1)
      {
        if (i != 5) {
          switch (i)
          {
          default: 
            if (!AppNetConnInfo.isNetSupport())
            {
              FMToastUtil.a(2131896111);
            }
            else
            {
              int j = SendBottomBar.c(this.a).t();
              if (j == 1) {
                i = 1;
              } else {
                i = 0;
              }
              if (j == 5) {
                this.a.c();
              } else if ((i == 0) && (!SendBottomBar.c(this.a).m)) {
                SendBottomBar.o(this.a);
              } else {
                SendBottomBar.b(this.a, true);
              }
            }
            break;
          case 10: 
            SendBottomBar.k(this.a);
            break;
          case 9: 
            this.a.b();
            break;
          case 8: 
            SendBottomBar.n(this.a);
            break;
          case 7: 
            SendBottomBar.j(this.a);
            break;
          }
        } else {
          SendBottomBar.m(this.a);
        }
      }
      else {
        SendBottomBar.l(this.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.4
 * JD-Core Version:    0.7.0.1
 */