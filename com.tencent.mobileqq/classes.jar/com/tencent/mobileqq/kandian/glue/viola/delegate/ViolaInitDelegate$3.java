package com.tencent.mobileqq.kandian.glue.viola.delegate;

import android.text.TextUtils;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ViolaInitDelegate$3
  implements ViewPager.OnPageChangeListener
{
  ViolaInitDelegate$3(ViolaInitDelegate paramViolaInitDelegate) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((!TextUtils.isEmpty(ViolaInitDelegate.a(this.a))) && (paramFloat != 0.0F) && (paramInt2 != 0))
    {
      Object localObject = this.a;
      ((ViolaInitDelegate)localObject).a(ViolaInitDelegate.a((ViolaInitDelegate)localObject));
      ViolaInitDelegate.a(this.a, null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("violaViewPager onPageScrolled potition : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" , mCurrentPosition:");
      ((StringBuilder)localObject).append(ViolaInitDelegate.a(this.a));
      QLog.d("ViolaInitDelegate", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = 0;
    while (i < ViolaInitDelegate.a(this.a).size())
    {
      ViolaBaseView localViolaBaseView = (ViolaBaseView)ViolaInitDelegate.a(this.a).get(i);
      if (localViolaBaseView != null) {
        if (i != paramInt)
        {
          localViolaBaseView.a(false);
          localViolaBaseView.onActivityPause();
        }
        else
        {
          localViolaBaseView.a(true);
          localViolaBaseView.onActivityResume();
        }
      }
      i += 1;
    }
    ViolaInitDelegate.a(this.a, paramInt);
    ViolaInitDelegate.a(this.a).dealFlingEnableWhenSwitcher(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaInitDelegate.3
 * JD-Core Version:    0.7.0.1
 */