package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UiApiPlugin$19
  implements View.OnClickListener
{
  UiApiPlugin$19(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a)) {
      this.b.callJs(this.a, new String[] { "" });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.19
 * JD-Core Version:    0.7.0.1
 */