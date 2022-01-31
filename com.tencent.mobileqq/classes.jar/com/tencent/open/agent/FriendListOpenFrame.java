package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import bbjs;
import bblg;
import bbwr;
import bbws;
import bbwt;
import bbzv;
import bcab;
import bcds;
import behi;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.widget.AdapterView;

public class FriendListOpenFrame
  extends OpenFrame
  implements View.OnTouchListener, bbjs, bblg, bcab, behi
{
  public int a;
  protected Handler a;
  protected EditText a;
  public RelativeLayout a;
  protected bbws a;
  protected IndexView a;
  public PinnedDividerListView a;
  protected String a;
  
  public FriendListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new bbwr(this);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    super.setContentView(2131496798);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131298501));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)super.findViewById(2131302454));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131101491);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getLayoutInflater().inflate(2131496760, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300167));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297934)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Bbws.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a))
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
      i = this.jdField_a_of_type_Bbws.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    bcds.c("FriendListOpenFrame", "-->onImageLoaded() url = " + paramString1);
    paramString2 = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString1);
    paramString2.obj = paramBitmap;
    paramString2.what = 3;
    paramString2.setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString2);
  }
  
  public void b(Bundle paramBundle)
  {
    bcds.c("FriendListOpenFrame", "-->onStart()");
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    this.jdField_a_of_type_Int = paramBundle.getInt("group_index");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(true, false, this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getString(2131653392), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bbws == null)
    {
      this.jdField_a_of_type_Bbws = new bbws(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Bbws);
      return;
    }
    this.jdField_a_of_type_Bbws.b();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Bbws.notifyDataSetChanged();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bbwt)paramView.getTag();
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
      paramView = (Friend)this.jdField_a_of_type_Bbws.getItem(paramInt);
    } while (paramView == null);
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(paramView);
    if (this.jdField_a_of_type_Bbzv.a(paramView.jdField_a_of_type_JavaLangString))
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
 * Qualified Name:     com.tencent.open.agent.FriendListOpenFrame
 * JD-Core Version:    0.7.0.1
 */