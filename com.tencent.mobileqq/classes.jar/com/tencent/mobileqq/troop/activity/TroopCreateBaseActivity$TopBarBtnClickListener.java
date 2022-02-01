package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopCreateBaseActivity$TopBarBtnClickListener
  implements View.OnClickListener
{
  int a = 0;
  String b;
  TroopCreateBaseActivity c = null;
  
  public TroopCreateBaseActivity$TopBarBtnClickListener(TroopCreateBaseActivity paramTroopCreateBaseActivity, int paramInt, String paramString)
  {
    this.c = paramTroopCreateBaseActivity;
    this.a = paramInt;
    this.b = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (this.c != null)
    {
      if (TextUtils.isEmpty(this.b))
      {
        int i = this.a;
        if (i == 0) {
          this.c.b();
        } else if (i == 1) {
          this.c.c();
        } else if (i == 2) {
          this.c.d();
        }
      }
      else
      {
        CustomWebView localCustomWebView = this.c.c;
        if (localCustomWebView != null) {
          localCustomWebView.callJs(this.b, new String[] { "" });
        }
      }
      this.c.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity.TopBarBtnClickListener
 * JD-Core Version:    0.7.0.1
 */