package com.tencent.mobileqq.troop.troopcard.ui;

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
  int a = 0;
  
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
    if (VisitorTroopCardFragment.e(this.b) != null)
    {
      if (VisitorTroopCardFragment.e(this.b).b().size() == 0) {
        return;
      }
      paramInt1 = a(paramAbsListView);
      VisitorTroopCardFragment localVisitorTroopCardFragment = null;
      if ((paramInt1 > this.a) && (paramInt1 >= this.b.T) && (this.b.f.getVisibility() != 0))
      {
        paramAbsListView = this.b.U;
      }
      else
      {
        paramAbsListView = localVisitorTroopCardFragment;
        if (paramInt1 < this.a)
        {
          paramAbsListView = localVisitorTroopCardFragment;
          if (paramInt1 <= this.b.T)
          {
            paramAbsListView = localVisitorTroopCardFragment;
            if (this.b.f.getVisibility() == 0) {
              paramAbsListView = this.b.V;
            }
          }
        }
      }
      if ((paramAbsListView != null) && (paramAbsListView != this.b.b.getAnimation()))
      {
        paramAbsListView.reset();
        this.b.b.startAnimation(paramAbsListView);
        this.b.f.startAnimation(paramAbsListView);
        localVisitorTroopCardFragment = this.b;
        boolean bool;
        if (paramAbsListView == localVisitorTroopCardFragment.U) {
          bool = true;
        } else {
          bool = false;
        }
        VisitorTroopCardFragment.a(localVisitorTroopCardFragment, bool);
        VisitorTroopCardFragment.f(this.b);
      }
      this.a = paramInt1;
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
        if ((VisitorTroopCardFragment.c(this.b) != null) && (VisitorTroopCardFragment.c(this.b).p)) {
          VisitorTroopCardFragment.c(this.b).i();
        }
        if (VisitorTroopCardFragment.d(this.b) != null) {
          VisitorTroopCardFragment.d(this.b).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.3
 * JD-Core Version:    0.7.0.1
 */