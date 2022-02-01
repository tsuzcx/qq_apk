package com.tencent.mobileqq.selectmember;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class TroopMemberListInnerFrame$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TroopMemberListInnerFrame$3(TroopMemberListInnerFrame paramTroopMemberListInnerFrame, ViewGroup paramViewGroup) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame.c);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame;
    localObject = TroopMemberListInnerFrame.a((TroopMemberListInnerFrame)localObject, ((TroopMemberListInnerFrame)localObject).c);
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame.c.setTag(localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.3
 * JD-Core Version:    0.7.0.1
 */