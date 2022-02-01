package com.tencent.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthorizationDescriptionDialog$1
  implements View.OnClickListener
{
  AuthorizationDescriptionDialog$1(AuthorizationDescriptionDialog paramAuthorizationDescriptionDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.AuthorizationDescriptionDialog.1
 * JD-Core Version:    0.7.0.1
 */