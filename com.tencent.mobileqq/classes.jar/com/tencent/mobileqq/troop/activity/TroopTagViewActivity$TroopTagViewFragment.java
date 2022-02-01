package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bgtw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

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
    this.jdField_b_of_type_Int = 1;
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_Boolean))
    {
      this.mSwiftTitleUI.rightViewText.setText(2131691727);
      this.mSwiftTitleUI.rightViewText.setVisibility(0);
      this.mSwiftTitleUI.rightViewImg.setVisibility(8);
      this.mSwiftTitleUI.rightViewText.setOnClickListener(this);
      return i;
    }
    this.mSwiftTitleUI.rightViewText.setVisibility(8);
    this.mSwiftTitleUI.rightViewImg.setVisibility(8);
    return i;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Bundle localBundle = this.intent.getExtras();
    this.jdField_a_of_type_Int = localBundle.getInt("act_type", 3);
    this.jdField_b_of_type_JavaLangString = localBundle.getString("tags");
    if (localBundle.containsKey("subclass")) {}
    for (this.c = localBundle.getString("subclass");; this.c = "")
    {
      this.jdField_a_of_type_JavaLangString = localBundle.getString("troopuin");
      this.jdField_a_of_type_Boolean = localBundle.getBoolean("isAdmin");
      this.jdField_b_of_type_Int = localBundle.getInt("modifyToSrv", 1);
      return super.doOnCreate(paramBundle);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.mSwiftTitleUI.rightViewText) {
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_Boolean))
      {
        Intent localIntent = new Intent(super.getActivity(), TroopTagViewActivity.class);
        localIntent.putExtra("troopuin", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("tags", this.jdField_b_of_type_JavaLangString);
        localIntent.putExtra("act_type", 2);
        localIntent.putExtra("modifyToSrv", this.jdField_b_of_type_Int);
        localIntent.putExtra("uin", this.mApp.getCurrentAccountUin());
        super.getActivity().startActivity(localIntent);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      continue;
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopTagViewActivity.TroopTagViewFragment
 * JD-Core Version:    0.7.0.1
 */