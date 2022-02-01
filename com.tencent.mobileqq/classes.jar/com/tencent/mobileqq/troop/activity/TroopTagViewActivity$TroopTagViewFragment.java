package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class TroopTagViewActivity$TroopTagViewFragment
  extends WebViewFragment
{
  protected String a;
  protected String b;
  protected String c;
  protected int d;
  protected boolean e = false;
  public int f = 1;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Bundle localBundle = this.intent.getExtras();
    this.d = localBundle.getInt("act_type", 3);
    this.b = localBundle.getString("tags");
    if (localBundle.containsKey("subclass")) {
      this.c = localBundle.getString("subclass");
    } else {
      this.c = "";
    }
    this.a = localBundle.getString("troopuin");
    this.e = localBundle.getBoolean("isAdmin");
    this.f = localBundle.getInt("modifyToSrv", 1);
    return super.doOnCreate(paramBundle);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new TroopTagViewActivity.TroopTagViewFragment.1(this, this.webViewSurface);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == getSwiftTitleUI().f)
    {
      if ((this.d == 1) && (this.e))
      {
        Intent localIntent = new Intent(super.getActivity(), TroopTagViewActivity.class);
        localIntent.putExtra("troopuin", this.a);
        localIntent.putExtra("tags", this.b);
        localIntent.putExtra("act_type", 2);
        localIntent.putExtra("modifyToSrv", this.f);
        localIntent.putExtra("uin", getAppRuntime().getCurrentAccountUin());
        super.getActivity().startActivity(localIntent);
      }
      else
      {
        super.onClick(paramView);
      }
    }
    else {
      super.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopTagViewActivity.TroopTagViewFragment
 * JD-Core Version:    0.7.0.1
 */