package dov.com.qq.im.ae.biz.qcircle;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.view.ViewGroup;

class AECirclePhotoListFragment$1
  implements OnApplyWindowInsetsListener
{
  AECirclePhotoListFragment$1(AECirclePhotoListFragment paramAECirclePhotoListFragment) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView.findViewById(2131377356);
      if (paramView != null) {
        paramView.setPadding(0, paramWindowInsetsCompat.getSystemWindowInsetTop(), 0, 0);
      }
    }
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListFragment.1
 * JD-Core Version:    0.7.0.1
 */