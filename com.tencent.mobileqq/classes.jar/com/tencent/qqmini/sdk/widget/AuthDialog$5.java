package com.tencent.qqmini.sdk.widget;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class AuthDialog$5
  implements View.OnClickListener
{
  AuthDialog$5(AuthDialog paramAuthDialog, List paramList) {}
  
  public void onClick(View paramView)
  {
    AuthDialog.access$1000(this.this$0, (INTERFACE.StSubscribeMessage)this.val$subMsgNoMaintainAuth.get(0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.AuthDialog.5
 * JD-Core Version:    0.7.0.1
 */