package com.tencent.mobileqq.teamwork.fragment;

import android.util.SparseArray;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TeamWorkAuthorizeSettingFragment$3
  implements ActionSheet.OnButtonClickListener
{
  TeamWorkAuthorizeSettingFragment$3(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment, SparseArray paramSparseArray, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      paramInt = -1;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment);
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      paramInt = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).intValue();
      break;
      TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment, 2);
      continue;
      TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment, 1);
      continue;
      TeamWorkAuthorizeSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkFragmentTeamWorkAuthorizeSettingFragment, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */