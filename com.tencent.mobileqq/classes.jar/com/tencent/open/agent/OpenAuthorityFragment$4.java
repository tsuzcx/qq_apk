package com.tencent.open.agent;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OpenAuthorityFragment$4
  implements View.OnClickListener
{
  OpenAuthorityFragment$4(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - OpenAuthorityFragment.d(this.a) > 1000L)
    {
      OpenAuthorityFragment.a(this.a).a.setClickable(false);
      Intent localIntent = new Intent();
      localIntent.putExtra("appid", OpenAuthorityFragment.a(this.a));
      localIntent.putExtra("key_proxy_appid", OpenAuthorityFragment.c(this.a));
      localIntent.putExtra("public_fragment_window_feature", 1);
      PublicFragmentActivity.Launcher.a(this.a.getActivity(), localIntent, PublicFragmentActivityForOpenSDK.class, CreateVirtualAccountFragment.class, 101);
      OpenAuthorityFragment.a(this.a).a.setClickable(true);
    }
    OpenAuthorityFragment.b(this.a, System.currentTimeMillis());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.4
 * JD-Core Version:    0.7.0.1
 */