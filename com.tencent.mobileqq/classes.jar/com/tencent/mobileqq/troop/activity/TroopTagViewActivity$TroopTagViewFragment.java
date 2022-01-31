package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bccj;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

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
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Bccj.c.setText(2131691961);
      this.jdField_a_of_type_Bccj.c.setVisibility(0);
      this.jdField_a_of_type_Bccj.a.setVisibility(8);
      this.jdField_a_of_type_Bccj.c.setOnClickListener(this);
      return i;
    }
    this.jdField_a_of_type_Bccj.c.setVisibility(8);
    this.jdField_a_of_type_Bccj.a.setVisibility(8);
    return i;
  }
  
  public boolean a(Bundle paramBundle)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    this.jdField_a_of_type_Int = localBundle.getInt("act_type", 3);
    this.jdField_b_of_type_JavaLangString = localBundle.getString("tags");
    if (localBundle.containsKey("subclass")) {}
    for (this.c = localBundle.getString("subclass");; this.c = "")
    {
      this.jdField_a_of_type_JavaLangString = localBundle.getString("troopuin");
      this.jdField_a_of_type_Boolean = localBundle.getBoolean("isAdmin");
      this.jdField_b_of_type_Int = localBundle.getInt("modifyToSrv", 1);
      return super.a(paramBundle);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_Bccj.c)
    {
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_Boolean))
      {
        paramView = new Intent(super.getActivity(), TroopTagViewActivity.class);
        paramView.putExtra("troopuin", this.jdField_a_of_type_JavaLangString);
        paramView.putExtra("tags", this.jdField_b_of_type_JavaLangString);
        paramView.putExtra("act_type", 2);
        paramView.putExtra("modifyToSrv", this.jdField_b_of_type_Int);
        paramView.putExtra("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        super.getActivity().startActivity(paramView);
        return;
      }
      super.onClick(paramView);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopTagViewActivity.TroopTagViewFragment
 * JD-Core Version:    0.7.0.1
 */