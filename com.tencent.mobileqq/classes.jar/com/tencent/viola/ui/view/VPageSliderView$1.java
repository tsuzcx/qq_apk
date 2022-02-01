package com.tencent.viola.ui.view;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.viola.ui.component.VPage;
import com.tencent.viola.ui.component.VPage.PAGEVIEWSTATE;
import com.tencent.viola.ui.component.VPageSlider;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Iterator;
import java.util.List;

class VPageSliderView$1
  implements ViewPager.OnPageChangeListener
{
  VPageSliderView$1(VPageSliderView paramVPageSliderView) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Object localObject;
    if (VPageSliderView.access$000(this.this$0) != null)
    {
      localObject = VPageSliderView.access$000(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VPageSliderView.VPagerSliderScrollListener)((Iterator)localObject).next()).onPageScrollStateChanged(paramInt);
      }
    }
    if (paramInt == 0) {
      try
      {
        if (((this.this$0.getComponent().getChild(VPageSliderView.access$100(this.this$0)) instanceof VPage)) && (((VPage)this.this$0.getComponent().getChild(VPageSliderView.access$100(this.this$0))).getCurrentPageState() != VPage.PAGEVIEWSTATE.DIDAPPEAR) && (((VPage)this.this$0.getComponent().getChild(VPageSliderView.access$100(this.this$0))).getCurrentPageState() != VPage.PAGEVIEWSTATE.NOTINIT))
        {
          ((VPage)this.this$0.getComponent().getChild(VPageSliderView.access$100(this.this$0))).setCurrentPageState(VPage.PAGEVIEWSTATE.DIDAPPEAR);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("page状态转换测试，DIDAPPEAR  position:");
          ((StringBuilder)localObject).append(VPageSliderView.access$100(this.this$0));
          ViolaLogUtils.d("VSliderViewPager", ((StringBuilder)localObject).toString());
        }
        paramInt = VPageSliderView.access$100(this.this$0);
        if ((paramInt - 1 >= 0) && (((VPage)this.this$0.getComponent().getChild(VPageSliderView.access$100(this.this$0) - 1)).getCurrentPageState() == VPage.PAGEVIEWSTATE.WILLAPPEAR))
        {
          ((VPage)this.this$0.getComponent().getChild(VPageSliderView.access$100(this.this$0) - 1)).setCurrentPageState(VPage.PAGEVIEWSTATE.DIDDISAPPEAR);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("page状态转换测试，DIDDISAPPEAR  position:");
          ((StringBuilder)localObject).append(VPageSliderView.access$100(this.this$0) - 1);
          ViolaLogUtils.d("VSliderViewPager", ((StringBuilder)localObject).toString());
        }
        if ((VPageSliderView.access$100(this.this$0) + 1 < this.this$0.getChildCount()) && (((VPage)this.this$0.getComponent().getChild(VPageSliderView.access$100(this.this$0) + 1)).getCurrentPageState() == VPage.PAGEVIEWSTATE.WILLAPPEAR))
        {
          ((VPage)this.this$0.getComponent().getChild(VPageSliderView.access$100(this.this$0) + 1)).setCurrentPageState(VPage.PAGEVIEWSTATE.DIDDISAPPEAR);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("page状态转换测试，DIDDISAPPEAR  position:");
          ((StringBuilder)localObject).append(VPageSliderView.access$100(this.this$0) + 1);
          ViolaLogUtils.d("VSliderViewPager", ((StringBuilder)localObject).toString());
        }
        VPageSliderView.access$302(this.this$0, false);
        VPageSliderView.access$502(this.this$0, false);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPageScrollStateChanged error = ");
        localStringBuilder.append(localException.getMessage());
        ViolaLogUtils.e("VSliderViewPager", localStringBuilder.toString());
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject;
    if (VPageSliderView.access$000(this.this$0) != null)
    {
      localObject = VPageSliderView.access$000(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VPageSliderView.VPagerSliderScrollListener)((Iterator)localObject).next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
    }
    if (VPageSliderView.access$100(this.this$0) == paramInt1)
    {
      if (paramInt2 > VPageSliderView.access$200(this.this$0))
      {
        if (!VPageSliderView.access$300(this.this$0))
        {
          VPageSliderView.access$400(this.this$0, paramInt1, VPage.PAGEVIEWSTATE.WILLDISAPPEAR);
          VPageSliderView.access$302(this.this$0, true);
        }
        if (!VPageSliderView.access$500(this.this$0))
        {
          paramInt1 += 1;
          if (paramInt1 < this.this$0.getChildCount())
          {
            VPageSliderView.access$400(this.this$0, paramInt1, VPage.PAGEVIEWSTATE.WILLAPPEAR);
            VPageSliderView.access$502(this.this$0, true);
          }
        }
      }
      else if (paramInt2 < VPageSliderView.access$200(this.this$0))
      {
        if (!VPageSliderView.access$300(this.this$0))
        {
          VPageSliderView.access$400(this.this$0, paramInt1, VPage.PAGEVIEWSTATE.WILLDISAPPEAR);
          VPageSliderView.access$302(this.this$0, true);
        }
        if (!VPageSliderView.access$500(this.this$0))
        {
          paramInt1 -= 1;
          if (paramInt1 >= 0)
          {
            VPageSliderView.access$400(this.this$0, paramInt1, VPage.PAGEVIEWSTATE.WILLAPPEAR);
            VPageSliderView.access$502(this.this$0, true);
          }
        }
      }
      VPageSliderView.access$202(this.this$0, paramInt2);
      return;
    }
    if (paramInt2 > VPageSliderView.access$200(this.this$0))
    {
      if (!VPageSliderView.access$300(this.this$0))
      {
        localObject = this.this$0;
        VPageSliderView.access$400((VPageSliderView)localObject, VPageSliderView.access$100((VPageSliderView)localObject), VPage.PAGEVIEWSTATE.WILLDISAPPEAR);
        VPageSliderView.access$302(this.this$0, true);
      }
      if ((!VPageSliderView.access$500(this.this$0)) && (VPageSliderView.access$100(this.this$0) - 1 <= this.this$0.getChildCount()))
      {
        localObject = this.this$0;
        VPageSliderView.access$400((VPageSliderView)localObject, VPageSliderView.access$100((VPageSliderView)localObject) - 1, VPage.PAGEVIEWSTATE.WILLAPPEAR);
        VPageSliderView.access$502(this.this$0, true);
      }
    }
    else if (paramInt2 < VPageSliderView.access$200(this.this$0))
    {
      if (!VPageSliderView.access$300(this.this$0))
      {
        localObject = this.this$0;
        VPageSliderView.access$400((VPageSliderView)localObject, VPageSliderView.access$100((VPageSliderView)localObject), VPage.PAGEVIEWSTATE.WILLDISAPPEAR);
        VPageSliderView.access$302(this.this$0, true);
      }
      if ((!VPageSliderView.access$500(this.this$0)) && (VPageSliderView.access$100(this.this$0) - 1 >= 0))
      {
        localObject = this.this$0;
        VPageSliderView.access$400((VPageSliderView)localObject, VPageSliderView.access$100((VPageSliderView)localObject) - 1, VPage.PAGEVIEWSTATE.WILLAPPEAR);
        VPageSliderView.access$502(this.this$0, true);
      }
    }
    VPageSliderView.access$202(this.this$0, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    if (VPageSliderView.access$000(this.this$0) != null)
    {
      localObject = VPageSliderView.access$000(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VPageSliderView.VPagerSliderScrollListener)((Iterator)localObject).next()).onPageSelected(paramInt);
      }
    }
    if (VPageSliderView.access$600(this.this$0) != null) {
      VPageSliderView.access$600(this.this$0).change(paramInt);
    }
    Object localObject = this.this$0;
    VPageSliderView.access$400((VPageSliderView)localObject, VPageSliderView.access$100((VPageSliderView)localObject), VPage.PAGEVIEWSTATE.DIDDISAPPEAR);
    VPageSliderView.access$400(this.this$0, paramInt, VPage.PAGEVIEWSTATE.DIDAPPEAR);
    VPageSliderView.access$102(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VPageSliderView.1
 * JD-Core Version:    0.7.0.1
 */