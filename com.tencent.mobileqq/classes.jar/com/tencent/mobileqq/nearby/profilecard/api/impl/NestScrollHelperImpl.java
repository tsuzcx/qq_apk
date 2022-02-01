package com.tencent.mobileqq.nearby.profilecard.api.impl;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.NearbyProfilePagerAdapter;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.mobileqq.nearby.profilecard.api.INestScrollHelper;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public class NestScrollHelperImpl
  implements INestScrollHelper
{
  private static final String TAG = "NestScrollHelper";
  private int mPos;
  private ViewPager mViewPager;
  
  private View getScrollableView()
  {
    Object localObject = this.mViewPager.getAdapter();
    if ((localObject != null) && ((localObject instanceof FragmentPagerAdapter)))
    {
      localObject = ((NearbyProfileDisplayPanel.NearbyProfilePagerAdapter)localObject).a(this.mViewPager.getCurrentItem());
      if (localObject == null) {
        Log.i("NestScrollHelper", "getScrollableView: fragment is null");
      }
      if ((localObject instanceof NearbyMomentFragment)) {
        return ((NearbyMomentFragment)localObject).d();
      }
      if ((localObject instanceof NearbyProfileFragment)) {
        return ((NearbyProfileFragment)localObject).b();
      }
    }
    return null;
  }
  
  private boolean isAdapterViewTop(ListView paramListView)
  {
    if ((paramListView != null) && (paramListView.getFirstVisiblePosition() == 0))
    {
      paramListView = paramListView.getChildAt(0);
      if ((paramListView == null) || (paramListView.getTop() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isLinearLayoutTop(LinearLayout paramLinearLayout)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLinearLayout != null)
    {
      View localView = paramLinearLayout.getChildAt(0);
      bool1 = bool2;
      if (localView != null)
      {
        Rect localRect = new Rect();
        paramLinearLayout.getHitRect(localRect);
        bool1 = bool2;
        if (localView.getLocalVisibleRect(localRect))
        {
          bool1 = bool2;
          if (localRect.top == 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isTop()
  {
    View localView = getScrollableView();
    if (localView == null)
    {
      Log.e("NestScrollHelper", "isTop: scrollableView is null");
      return true;
    }
    if ((localView instanceof ListView)) {
      return isAdapterViewTop((ListView)localView);
    }
    if ((localView instanceof LinearLayout)) {
      return isLinearLayoutTop((LinearLayout)localView);
    }
    return true;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPos = paramInt;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.mViewPager = paramViewPager;
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = getScrollableView();
    if (localView == null)
    {
      Log.e("NestScrollHelper", "smoothScrollBy: scrollableView is null");
      return;
    }
    if ((localView instanceof ListView)) {
      ((ListView)localView).smoothScrollBy(paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.api.impl.NestScrollHelperImpl
 * JD-Core Version:    0.7.0.1
 */