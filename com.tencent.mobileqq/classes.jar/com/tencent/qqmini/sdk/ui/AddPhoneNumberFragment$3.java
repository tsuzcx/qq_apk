package com.tencent.qqmini.sdk.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;

class AddPhoneNumberFragment$3
  implements View.OnClickListener
{
  AddPhoneNumberFragment$3(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(AddPhoneNumberFragment.access$200(this.this$0))) {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).sendSmsCodeRequest(AddPhoneNumberFragment.access$200(this.this$0), "+86", new AddPhoneNumberFragment.3.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.3
 * JD-Core Version:    0.7.0.1
 */