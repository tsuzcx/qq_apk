package com.tencent.open.agent;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.open.agent.util.QQLiteStatusUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class CreateVirtualAccountFragment$4
  implements ActionSheet.OnButtonClickListener
{
  CreateVirtualAccountFragment$4(CreateVirtualAccountFragment paramCreateVirtualAccountFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment.getQBaseActivity().checkSelfPermission("android.permission.CAMERA") != 0) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          if (paramInt != 0)
          {
            this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment.getQBaseActivity().requestPermissions(new CreateVirtualAccountFragment.4.1(this), 2, new String[] { "android.permission.CAMERA" });
          }
          else
          {
            paramView = this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment;
            CreateVirtualAccountFragment.a(paramView, QQLiteStatusUtil.a(paramView.getActivity()));
          }
        }
        else
        {
          paramView = this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment;
          CreateVirtualAccountFragment.a(paramView, QQLiteStatusUtil.a(paramView.getActivity()));
        }
      }
    }
    else {
      QQLiteStatusUtil.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment.getActivity());
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.4
 * JD-Core Version:    0.7.0.1
 */