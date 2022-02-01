package com.tencent.mobileqq.guild.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

class BannerLayout$1
  implements Runnable
{
  BannerLayout$1(BannerLayout paramBannerLayout) {}
  
  public void run()
  {
    Context localContext = BannerLayout.a(this.this$0).getContentView().getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
      BannerLayout.a(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.BannerLayout.1
 * JD-Core Version:    0.7.0.1
 */