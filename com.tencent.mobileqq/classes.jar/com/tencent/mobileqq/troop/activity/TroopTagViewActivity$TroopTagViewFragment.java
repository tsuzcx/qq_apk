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
  protected int a;
  protected String a;
  protected boolean a;
  public int b;
  protected String b;
  protected String c;
  
  public TroopTagViewActivity$TroopTagViewFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 1;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Bundle localBundle = this.intent.getExtras();
    this.jdField_a_of_type_Int = localBundle.getInt("act_type", 3);
    this.jdField_b_of_type_JavaLangString = localBundle.getString("tags");
    if (localBundle.containsKey("subclass")) {
      this.c = localBundle.getString("subclass");
    } else {
      this.c = "";
    }
    this.jdField_a_of_type_JavaLangString = localBundle.getString("troopuin");
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("isAdmin");
    this.jdField_b_of_type_Int = localBundle.getInt("modifyToSrv", 1);
    return super.doOnCreate(paramBundle);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new TroopTagViewActivity.TroopTagViewFragment.1(this, this.webViewSurface);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == getSwiftTitleUI().c)
    {
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_Boolean))
      {
        Intent localIntent = new Intent(super.getActivity(), TroopTagViewActivity.class);
        localIntent.putExtra("troopuin", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("tags", this.jdField_b_of_type_JavaLangString);
        localIntent.putExtra("act_type", 2);
        localIntent.putExtra("modifyToSrv", this.jdField_b_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopTagViewActivity.TroopTagViewFragment
 * JD-Core Version:    0.7.0.1
 */