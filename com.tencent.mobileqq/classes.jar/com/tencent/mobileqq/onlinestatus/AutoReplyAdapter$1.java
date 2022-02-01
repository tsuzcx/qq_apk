package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class AutoReplyAdapter$1
  implements View.OnClickListener
{
  AutoReplyAdapter$1(AutoReplyAdapter paramAutoReplyAdapter) {}
  
  public void onClick(View paramView)
  {
    if (AutoReplyAdapter.a(this.a).size() > 10)
    {
      QQToast.makeText(AutoReplyAdapter.b(this.a), 1, 2131887164, 1).show();
    }
    else if (AutoReplyAdapter.c(this.a) != null)
    {
      int i;
      if (AutoReplyAdapter.a(this.a).size() > 1) {
        i = AutoReplyAdapter.a(this.a).size() - 1;
      } else {
        i = 0;
      }
      AutoReplyText localAutoReplyText = new AutoReplyText("", i);
      localAutoReplyText.getExtra().putBoolean("addFlag", true);
      AutoReplyAdapter.c(this.a).b(localAutoReplyText, false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyAdapter.1
 * JD-Core Version:    0.7.0.1
 */