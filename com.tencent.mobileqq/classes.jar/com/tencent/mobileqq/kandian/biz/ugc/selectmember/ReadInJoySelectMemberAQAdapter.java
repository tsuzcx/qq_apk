package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class ReadInJoySelectMemberAQAdapter
  extends SelectMemberBuddyListAdapter
{
  private SelectMemberLimit a;
  
  public ReadInJoySelectMemberAQAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, SelectMemberLimit paramSelectMemberLimit)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit = paramSelectMemberLimit;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.b()))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718030, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.c()) });
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, str, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718024), 0).a();
  }
  
  protected void a(SelectMemberBuddyListAdapter.SelectBuddyChildTag paramSelectBuddyChildTag, Friends paramFriends)
  {
    if (paramFriends != null)
    {
      SelectMemberLimit localSelectMemberLimit = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit;
      if ((localSelectMemberLimit != null) && (localSelectMemberLimit.a() != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a().isEmpty()) {
          return;
        }
        paramSelectBuddyChildTag.a.setBackgroundResource(2130849695);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a().contains(paramFriends.uin))
        {
          paramSelectBuddyChildTag.a.setEnabled(false);
          return;
        }
        paramSelectBuddyChildTag.a.setEnabled(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberAQAdapter
 * JD-Core Version:    0.7.0.1
 */