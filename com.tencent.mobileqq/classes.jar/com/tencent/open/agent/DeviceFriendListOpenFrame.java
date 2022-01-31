package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import bemh;
import benv;
import bezq;
import bezr;
import bezs;
import bfdi;
import bfdo;
import bfhg;
import bhqp;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class DeviceFriendListOpenFrame
  extends OpenFrame
  implements View.OnTouchListener, bemh, benv, bfdo, bhqp
{
  public static final String a;
  protected Handler a;
  protected EditText a;
  public RelativeLayout a;
  public bezr a;
  protected IndexView a;
  protected PinnedDividerListView a;
  
  static
  {
    jdField_a_of_type_JavaLangString = DeviceFriendListOpenFrame.class.getName();
  }
  
  public DeviceFriendListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new bezq(this);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    super.setContentView(2131562601);
    f();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Bezr.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Bezr.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    bfhg.c(jdField_a_of_type_JavaLangString, "-->onImageLoaded() url = " + paramString1);
    this.jdField_a_of_type_AndroidOsHandler.post(new DeviceFriendListOpenFrame.2(this, paramString1, paramBitmap));
  }
  
  public void b(Bundle paramBundle)
  {
    bfhg.c(jdField_a_of_type_JavaLangString, "-->onStart()");
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(true, true, this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getString(2131691003), this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getString(2131691879), this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getString(2131690624));
    if (this.jdField_a_of_type_Bezr == null)
    {
      this.jdField_a_of_type_Bezr = new bezr(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Bezr);
    }
    this.jdField_a_of_type_Bezr.b();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131364120));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)super.findViewById(2131368212));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167138);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getLayoutInflater().inflate(2131562564, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365849));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363520)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Bezr.b();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bezs)paramView.getTag();
    if ((paramAdapterView != null) && (paramAdapterView.a != null))
    {
      paramInt -= this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount();
      if (paramInt >= 0) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      paramView = (Friend)this.jdField_a_of_type_Bezr.getItem(paramInt);
    } while ((paramView == null) || ((this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.jdField_a_of_type_JavaUtilArrayList.contains(paramView.jdField_a_of_type_JavaLangString))));
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(paramView);
    if (this.jdField_a_of_type_Bfdi.a(paramView.jdField_a_of_type_JavaLangString))
    {
      paramAdapterView.a.setChecked(true);
      return;
    }
    paramAdapterView.a.setChecked(false);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.c();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.DeviceFriendListOpenFrame
 * JD-Core Version:    0.7.0.1
 */