package com.tencent.mobileqq.troop.troopcard;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.recommend.TroopDataCardRecomTroopListWrapper;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;

class VisitorTroopCardFragment$3
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  VisitorTroopCardFragment$3(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  private int a(AbsListView paramAbsListView)
  {
    int i = 0;
    View localView = paramAbsListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int j = paramAbsListView.getFirstVisiblePosition();
    int k = localView.getTop();
    if (j >= 1) {
      i = paramAbsListView.getHeight();
    }
    return -k + j * localView.getHeight() + i;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment) != null)
    {
      if (VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment).a().size() == 0) {
        return;
      }
      paramInt1 = a(paramAbsListView);
      VisitorTroopCardFragment localVisitorTroopCardFragment = null;
      if ((paramInt1 > this.jdField_a_of_type_Int) && (paramInt1 >= this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.getVisibility() != 0))
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
      }
      else
      {
        paramAbsListView = localVisitorTroopCardFragment;
        if (paramInt1 < this.jdField_a_of_type_Int)
        {
          paramAbsListView = localVisitorTroopCardFragment;
          if (paramInt1 <= this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_Int)
          {
            paramAbsListView = localVisitorTroopCardFragment;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.getVisibility() == 0) {
              paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
            }
          }
        }
      }
      if ((paramAbsListView != null) && (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_b_of_type_AndroidWidgetRelativeLayout.getAnimation()))
      {
        paramAbsListView.reset();
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(paramAbsListView);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation(paramAbsListView);
        localVisitorTroopCardFragment = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment;
        boolean bool;
        if (paramAbsListView == localVisitorTroopCardFragment.jdField_a_of_type_AndroidViewAnimationAlphaAnimation) {
          bool = true;
        } else {
          bool = false;
        }
        VisitorTroopCardFragment.a(localVisitorTroopCardFragment, bool);
        VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment);
      }
      this.jdField_a_of_type_Int = paramInt1;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = paramAbsListView.getLastVisiblePosition();
      int i = paramAbsListView.getCount();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramInt == i - 1)
      {
        View localView = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
        bool1 = bool2;
        if (paramAbsListView.getHeight() >= localView.getBottom()) {
          bool1 = true;
        }
      }
      if (QLog.isColorLevel())
      {
        paramAbsListView = new StringBuilder();
        paramAbsListView.append("onScrollStateChanged, reachBottom = ");
        paramAbsListView.append(bool1);
        QLog.d("VisitorTroopCardFragment.Activity", 2, paramAbsListView.toString());
      }
      if (bool1)
      {
        if ((VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment) != null) && (VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment).c)) {
          VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment).e();
        }
        if (VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment) != null) {
          VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.3
 * JD-Core Version:    0.7.0.1
 */