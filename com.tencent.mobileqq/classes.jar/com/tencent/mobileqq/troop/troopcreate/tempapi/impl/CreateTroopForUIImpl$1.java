package com.tencent.mobileqq.troop.troopcreate.tempapi.impl;

import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import java.util.ArrayList;

class CreateTroopForUIImpl$1
  implements ContactSearchResultPresenter.OnActionListener
{
  CreateTroopForUIImpl$1(CreateTroopForUIImpl paramCreateTroopForUIImpl) {}
  
  public void onAction(View paramView)
  {
    IContactSearchModel localIContactSearchModel = (IContactSearchModel)paramView.getTag(2131380884);
    if (localIContactSearchModel == null) {
      return;
    }
    String str1 = localIContactSearchModel.a();
    String str2 = localIContactSearchModel.b().toString();
    boolean bool = localIContactSearchModel instanceof ContactSearchModelDiscussionMember;
    if (bool) {
      paramView = ((ContactSearchModelDiscussionMember)localIContactSearchModel).e();
    } else if ((localIContactSearchModel instanceof ContactSearchModelNewTroopMember)) {
      paramView = ((ContactSearchModelNewTroopMember)localIContactSearchModel).a;
    } else {
      paramView = "-1";
    }
    if (((CreateTroopForUIImpl.access$000(this.a).jdField_a_of_type_JavaUtilArrayList == null) || (!CreateTroopForUIImpl.access$000(this.a).jdField_a_of_type_JavaUtilArrayList.contains(str1))) && (!CreateTroopForUIImpl.access$000(this.a).a(str1)))
    {
      if (CreateTroopForUIImpl.access$000(this.a).b()) {
        return;
      }
      int i = 0;
      if (bool) {
        i = 2;
      } else if ((localIContactSearchModel instanceof ContactSearchModelNewTroopMember)) {
        i = 1;
      } else if (!(localIContactSearchModel instanceof ContactSearchModelFriend)) {
        if ((localIContactSearchModel instanceof ContactSearchModelPhoneContact))
        {
          if (str1.startsWith("+")) {
            i = 4;
          }
        }
        else {
          i = -1;
        }
      }
      if (i != -1) {
        CreateTroopForUIImpl.access$000(this.a).c.add(NewTroopContactView.a(str1, str2, i, paramView));
      }
      CreateTroopForUIImpl.access$000(this.a).m();
      CreateTroopForUIImpl.access$000(this.a).jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView$ExpandableListAdapter.notifyDataSetChanged();
      CreateTroopForUIImpl.access$000(this.a).b(true);
      CreateTroopForUIImpl.access$000(this.a).jdField_a_of_type_AndroidWidgetEditText.setText("");
      CreateTroopForUIImpl.access$000(this.a).o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.tempapi.impl.CreateTroopForUIImpl.1
 * JD-Core Version:    0.7.0.1
 */