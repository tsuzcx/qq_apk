package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.teamwork.IGroupTeamWorkAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class GroupTeamWorkListActivity$16
  extends GroupTeamWorkObserver
{
  GroupTeamWorkListActivity$16(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onDeletePanInfo success: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" \nretCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" \nerrorMsg: ");
      localStringBuilder.append(paramString);
      QLog.i("GroupTeamWorkListActivity", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, 5);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.app.getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getString(2131691493), 0).b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.app.getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getString(2131691486), 0).b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a(2);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, List<GPadInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      paramList = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onGetPadTemplateList success: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" \nretCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" \nerrorMsg: ");
      localStringBuilder.append(paramString);
      QLog.i(paramList, 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      GroupTeamWorkListActivity.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, 2);
      if (GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity) != null) {
        GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, List<GPadInfo> paramList, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramList = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onGetPadList success: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" \nretCode: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" \nerrorMsg: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n next =");
      localStringBuilder.append(paramInt2);
      QLog.i(paramList, 2, localStringBuilder.toString());
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity;
    paramString.b = paramInt2;
    boolean bool = GroupTeamWorkListActivity.a(paramString);
    int j = 0;
    int i = 0;
    if (bool)
    {
      if (paramBoolean) {
        paramInt2 = 1;
      } else {
        paramInt2 = 2;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a.obtainMessage(111, paramInt2, 0);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a.sendMessageDelayed(paramString, 500L);
      GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, false);
    }
    if (GroupTeamWorkListActivity.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a(2);
      GroupTeamWorkListActivity.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, false);
    }
    paramInt2 = 3;
    if (paramInt3 != 2) {
      if (paramInt3 == 3) {
        paramInt2 = 4;
      } else {
        paramInt2 = 2;
      }
    }
    if ((paramBoolean) && (paramInt1 == 0))
    {
      GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, paramInt2);
      paramInt1 = j;
    }
    else
    {
      if (paramInt2 == 2) {
        if ((GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity) != null) && (GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).getCount() == 0))
        {
          GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).setVisibility(8);
          if (GroupTeamWorkListActivity.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).getVisibility() == 0) {
            GroupTeamWorkListActivity.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).setVisibility(8);
          }
          GroupTeamWorkListActivity.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).setVisibility(0);
        }
        else
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.app.getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getString(2131693799), 0).b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getTitleBarHeight());
        }
      }
      paramInt1 = i;
      if (paramInt2 == 4)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.app.getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getString(2131693799), 0).b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getTitleBarHeight());
        paramInt1 = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a(2);
    }
    if (paramInt1 != 0) {
      GroupTeamWorkListActivity.d(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.16
 * JD-Core Version:    0.7.0.1
 */