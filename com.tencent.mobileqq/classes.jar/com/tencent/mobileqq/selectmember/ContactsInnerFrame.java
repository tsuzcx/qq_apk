package com.tencent.mobileqq.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class ContactsInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  private IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver;
  private ContactsInnerFrame.ContactsListAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame$ContactsListAdapter;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  List<PhoneContact> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ContactsInnerFrame.1(this);
  
  public ContactsInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactsInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactsInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364470));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368761));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getContactListForSelector();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 1000L);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame$ContactsListAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame$ContactsListAdapter = new ContactsInnerFrame.ContactsListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame$ContactsListAdapter);
    }
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame$ContactsListAdapter.a();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService == null) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new ContactsInnerFrame.2(this);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
  }
  
  private void j() {}
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 768, null, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131562810);
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.setHandler(ContactsInnerFrame.class, this.jdField_a_of_type_MqqOsMqqHandler);
    g();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame$ContactsListAdapter = new ContactsInnerFrame.ContactsListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame$ContactsListAdapter);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame$ContactsListAdapter.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isSoftInputShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(true, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718718), this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131694786));
    int i = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState();
    if (i != 0) {
      if ((i != 1) && (i != 5))
      {
        if (i != 6)
        {
          if ((i != 7) && (i != 9)) {
            i();
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindInfo().lastUsedFlag == 2L)
          {
            h();
            return;
          }
          j();
        }
      }
      else
      {
        j();
        return;
      }
    }
    h();
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeHandler(ContactsInnerFrame.class);
    ContactsInnerFrame.ContactsListAdapter localContactsListAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame$ContactsListAdapter;
    if (localContactsListAdapter != null) {
      localContactsListAdapter.c();
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame$ContactsListAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    SelectActivityViewHolder localSelectActivityViewHolder = (SelectActivityViewHolder)paramView.getTag();
    if ((localSelectActivityViewHolder != null) && (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localSelectActivityViewHolder.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
    {
      Object localObject = localSelectActivityViewHolder.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      if (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        boolean bool = localSelectActivityViewHolder.jdField_a_of_type_Boolean;
        int i = 0;
        if (bool) {
          bool = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.onListViewItemClick(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString, ((PhoneContact)localObject).name, 5, "-1");
        } else if (localSelectActivityViewHolder.jdField_a_of_type_JavaLangString.startsWith("+")) {
          bool = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.onListViewItemClick(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString, ((PhoneContact)localObject).name, 4, "-1");
        } else {
          bool = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.onListViewItemClick(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString, ((PhoneContact)localObject).name, 0, "-1");
        }
        localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d) {
          if (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
          {
            if (localSelectActivityViewHolder.jdField_a_of_type_Boolean)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(localSelectActivityViewHolder.d.getText());
              ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718719));
              paramView.setContentDescription(((StringBuilder)localObject).toString());
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(localSelectActivityViewHolder.d.getText().toString());
              ((StringBuilder)localObject).append(HardCodeUtil.a(2131702716));
              paramView.setContentDescription(((StringBuilder)localObject).toString());
            }
          }
          else
          {
            if (localSelectActivityViewHolder.jdField_a_of_type_Boolean) {
              i = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getCheckPhoneNumberResId(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString);
            }
            if ((localSelectActivityViewHolder.jdField_a_of_type_Boolean) && (i != 0))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(localSelectActivityViewHolder.d.getText());
              ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(i));
              paramView.setContentDescription(((StringBuilder)localObject).toString());
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(localSelectActivityViewHolder.d.getText().toString());
              ((StringBuilder)localObject).append(HardCodeUtil.a(2131702710));
              paramView.setContentDescription(((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqSelectmemberContactsInnerFrame$ContactsListAdapter.a(paramString);
    if (i != -1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.ContactsInnerFrame
 * JD-Core Version:    0.7.0.1
 */