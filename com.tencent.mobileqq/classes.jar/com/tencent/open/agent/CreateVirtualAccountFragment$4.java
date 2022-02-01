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
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (this.b.getQBaseActivity().checkSelfPermission("android.permission.CAMERA") != 0) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
          if (paramInt != 0)
          {
            this.b.getQBaseActivity().requestPermissions(new CreateVirtualAccountFragment.4.1(this), 2, new String[] { "android.permission.CAMERA" });
          }
          else
          {
            paramView = this.b;
            CreateVirtualAccountFragment.a(paramView, QQLiteStatusUtil.b(paramView.getActivity()));
          }
        }
        else
        {
          paramView = this.b;
          CreateVirtualAccountFragment.a(paramView, QQLiteStatusUtil.b(paramView.getActivity()));
        }
      }
    }
    else {
      QQLiteStatusUtil.a(this.b.getActivity());
    }
    try
    {
      this.a.dismiss();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.4
 * JD-Core Version:    0.7.0.1
 */