package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OpenSdkIMBlockFragment$1
  implements View.OnClickListener
{
  OpenSdkIMBlockFragment$1(OpenSdkIMBlockFragment paramOpenSdkIMBlockFragment) {}
  
  public void onClick(View paramView)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a.getQBaseActivity(), 230);
    localQQCustomDialog.setTitle(2131896961);
    localQQCustomDialog.setMessage(2131896959);
    localQQCustomDialog.setPositiveButton(2131896960, new OpenSdkIMBlockFragment.1.1(this));
    localQQCustomDialog.show();
    AuthReporter.a(OpenSdkIMBlockFragment.a(this.a), "0X800B65A");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkIMBlockFragment.1
 * JD-Core Version:    0.7.0.1
 */