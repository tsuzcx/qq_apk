package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.EnterItem;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.OnItemClickListener;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class NearbyHybridFragment$13
  implements NearbyFragmentEnterAdapter.OnItemClickListener
{
  NearbyHybridFragment$13(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a(View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    paramView = (NearbyFragmentEnterAdapter.EnterItem)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a(paramInt);
    Object localObject;
    if (paramView.jdField_a_of_type_Int == 1)
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a());
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    default: 
      label96:
      NearbyUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "click_op_button", paramView.jdField_a_of_type_Int);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "onItemClick:" + paramView.jdField_c_of_type_JavaLangString + ", " + paramView.jdField_a_of_type_JavaLangString);
      }
      if ((paramView.jdField_c_of_type_Int == 1) && (!TextUtils.isEmpty(paramView.e)) && (this.a.getActivity() != null) && (PackageUtil.a(this.a.getActivity(), paramView.e)) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null)) {
        if (TextUtils.isEmpty(paramView.d)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramView.d));
        ((Intent)localObject).setFlags(268435456);
        BaseApplicationImpl.getContext().startActivity((Intent)localObject);
        if (bool) {
          break;
        }
        this.a.a(paramView);
      }
      catch (Exception localException)
      {
        QLog.d("nearby.NearbyHybridFragment", 2, "jump to app with scheme Excepyion e = " + localException.getMessage());
        bool = false;
        continue;
      }
      bool = PackageUtil.a(this.a.getActivity(), paramView.e, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
      continue;
      localException.a(39);
      break label96;
      localException.a(25);
      break label96;
      localException.a(23);
      localException.a(26);
      break label96;
      localException.a(40);
      break label96;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter == null) {
        break label96;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      break label96;
      localException.a(41);
      break label96;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.13
 * JD-Core Version:    0.7.0.1
 */