package com.tencent.mobileqq.wink.pick.circle;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.widget.immersive.ImmersiveUtils;

class WinkCirclePhotoListFragment$1
  implements OnApplyWindowInsetsListener
{
  WinkCirclePhotoListFragment$1(WinkCirclePhotoListFragment paramWinkCirclePhotoListFragment) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView.findViewById(2131445137);
      WinkCirclePhotoListFragment localWinkCirclePhotoListFragment = this.a;
      localWinkCirclePhotoListFragment.h = paramView;
      if (paramView != null) {
        paramView.setPadding(0, ImmersiveUtils.getStatusBarHeight(localWinkCirclePhotoListFragment.getContext()), 0, 0);
      }
    }
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListFragment.1
 * JD-Core Version:    0.7.0.1
 */