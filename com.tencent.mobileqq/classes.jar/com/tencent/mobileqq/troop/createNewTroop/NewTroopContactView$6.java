package com.tencent.mobileqq.troop.createNewTroop;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

class NewTroopContactView$6
  implements View.OnFocusChangeListener
{
  NewTroopContactView$6(NewTroopContactView paramNewTroopContactView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView = this.a.a();
      if (paramView != null)
      {
        paramView.d(true);
        paramView.a(NewTroopContactView.a(this.a), this.a.jdField_a_of_type_JavaUtilArrayList);
        FragmentTransaction localFragmentTransaction = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getSupportFragmentManager().beginTransaction();
        if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
          localFragmentTransaction.remove(this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment);
        }
        localFragmentTransaction.add(2131376997, paramView);
        localFragmentTransaction.commitAllowingStateLoss();
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView.6
 * JD-Core Version:    0.7.0.1
 */