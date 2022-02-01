package com.tencent.mobileqq.fragment;

import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class NearbyHybridFragment$19
  implements ActionSheet.OnButtonClickListener
{
  NearbyHybridFragment$19(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getMyTabCardCache() == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getMyTabCard();
        }
        if ((NetworkUtil.isNetSupport(BaseApplication.getContext())) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
        {
          MineFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface);
          this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
        }
        else
        {
          QQToast.a(BaseApplication.getContext(), 1, this.a.getString(2131694422), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
        }
      }
    }
    else {
      this.a.o();
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    this.a.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.19
 * JD-Core Version:    0.7.0.1
 */