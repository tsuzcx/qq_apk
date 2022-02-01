package com.tencent.mobileqq.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class PhoneContactTabView
  extends TroopDiscussionBaseV
  implements View.OnClickListener, View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver;
  ContactFriendInnerFrame jdField_a_of_type_ComTencentMobileqqSelectmemberContactFriendInnerFrame;
  private PhoneContactTabView.ContactsListAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView$ContactsListAdapter;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private String jdField_a_of_type_JavaLangString;
  List<PhoneContact> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new PhoneContactTabView.2(this);
  
  public PhoneContactTabView(SelectMemberActivity paramSelectMemberActivity, ContactFriendInnerFrame paramContactFriendInnerFrame)
  {
    super(paramSelectMemberActivity);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactFriendInnerFrame = paramContactFriendInnerFrame;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364470));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368761));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379934));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new PhoneContactTabView.1(this));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService == null) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new PhoneContactTabView.3(this);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
  }
  
  private void j() {}
  
  public void a(Bundle paramBundle)
  {
    a(2131562810);
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.setHandler(PhoneContactTabView.class, this.jdField_a_of_type_MqqOsMqqHandler);
    h();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView$ContactsListAdapter = new PhoneContactTabView.ContactsListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView$ContactsListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(false, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718706), this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mTitleString);
    int i = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onStart state:");
      paramBundle.append(i);
      QLog.i("ContactsInnerFrame", 2, paramBundle.toString());
    }
    if ((i != 0) && (i != 1) && (i != 5)) {
      if (i != 6)
      {
        if (i != 7)
        {
          if (i != 9)
          {
            i();
            return;
          }
          d();
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindInfo().lastUsedFlag == 2L)
        {
          d();
          return;
        }
        g();
        return;
      }
    }
    g();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView$ContactsListAdapter.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isSoftInputShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeHandler(PhoneContactTabView.class);
    PhoneContactTabView.ContactsListAdapter localContactsListAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView$ContactsListAdapter;
    if (localContactsListAdapter != null) {
      localContactsListAdapter.c();
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView$ContactsListAdapter.notifyDataSetChanged();
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getContactListForPhoneSelector();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 1000L);
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView$ContactsListAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView$ContactsListAdapter = new PhoneContactTabView.ContactsListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView$ContactsListAdapter);
      }
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView$ContactsListAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqSelectmemberPhoneContactTabView$ContactsListAdapter.a(paramString);
    if (i != -1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getAction();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.PhoneContactTabView
 * JD-Core Version:    0.7.0.1
 */