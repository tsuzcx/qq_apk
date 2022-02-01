package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.widget.BounceScrollView;

class NearbyProfileEditPanel$16
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  NearbyProfileEditPanel$16(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView().getRootView().getHeight() - ((Rect)localObject).bottom;
    if (i <= 0) {
      return;
    }
    int j = this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getScrollY();
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getCurrentFocus();
    if ((localObject != null) && ((localObject instanceof EditText)) && (((View)localObject).getParent() != null))
    {
      int k = ((ViewGroup)((View)localObject).getParent()).getBottom();
      int m = this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getMeasuredHeight();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.smoothScrollBy(0, k + i - m - j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.16
 * JD-Core Version:    0.7.0.1
 */