package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import bjde;
import bjdf;
import bjgp;
import bjko;
import com.tencent.widget.XListView;

public class GroupListOpenFrame
  extends OpenFrame
{
  protected EditText a;
  protected TextView a;
  protected bjdf a;
  protected RecommendListManager a;
  public XListView a;
  protected TextView b;
  
  public GroupListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.b();
    bjko.c("GroupListOpenFrame", "-->onResume()");
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    bjko.c("GroupListOpenFrame", "-->onCreate()");
    super.setContentView(2131562861);
    this.jdField_a_of_type_Bjdf = new bjdf(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131381622));
    paramBundle = (LinearLayout)super.a().getLayoutInflater().inflate(2131559721, null);
    paramBundle.findViewById(2131363845).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131378821));
    this.b = ((TextView)paramBundle.findViewById(2131378822));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager = ((RecommendListManager)paramBundle.findViewById(2131377865));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setActivity(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser);
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.a();
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131167296);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bjdf);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBundle.findViewById(2131366280));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new bjde(this));
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    bjko.c("GroupListOpenFrame", "-->onStart()");
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(false, true, "", this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getString(2131690936));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bjgp.a() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjdf.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame
 * JD-Core Version:    0.7.0.1
 */