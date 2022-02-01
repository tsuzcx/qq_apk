package com.tencent.mobileqq.kandian.glue.viola.view;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.wormhole.WormholeManager;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaInstance.ViolaPageListener;

class ViolaBaseView$12
  implements ViolaInstance.ViolaPageListener
{
  ViolaBaseView$12(ViolaBaseView paramViolaBaseView) {}
  
  public void onComponentFloatBottom(View paramView, float paramFloat)
  {
    if (((ViolaBaseView.i(this.a) instanceof ViolaFragment)) && (((ViolaFragment)ViolaBaseView.i(this.a)).getCommonSuspensionGestureLayout() != null)) {
      ((CommonSuspensionGestureLayout)((ViolaFragment)ViolaBaseView.i(this.a)).getCommonSuspensionGestureLayout()).c(paramView, paramFloat);
    }
  }
  
  public void onComponentFloatCenter(View paramView, float paramFloat)
  {
    if (((ViolaBaseView.i(this.a) instanceof ViolaFragment)) && (((ViolaFragment)ViolaBaseView.i(this.a)).getCommonSuspensionGestureLayout() != null)) {
      ((CommonSuspensionGestureLayout)((ViolaFragment)ViolaBaseView.i(this.a)).getCommonSuspensionGestureLayout()).b(paramView, paramFloat);
    }
  }
  
  public void onComponentTopIndex(View paramView, float paramFloat)
  {
    if (((ViolaBaseView.i(this.a) instanceof ViolaFragment)) && (((ViolaFragment)ViolaBaseView.i(this.a)).getCommonSuspensionGestureLayout() != null)) {
      ((CommonSuspensionGestureLayout)((ViolaFragment)ViolaBaseView.i(this.a)).getCommonSuspensionGestureLayout()).a(paramView, paramFloat);
    }
  }
  
  public void onDispatchTouchEvent(String paramString, int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if (paramString.equals(ViolaBaseView.n(this.a).getMasterListRef())) {
      ViolaBaseView.c(this.a, paramInt2);
    }
  }
  
  public void onScroll(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (paramString.equals(ViolaBaseView.n(this.a).getMasterListRef()))
    {
      ViolaBaseView.c(this.a, paramInt5);
      ViolaBaseView.b(this.a, true);
      if (ViolaBaseView.o(this.a) != null) {
        ViolaBaseView.o(this.a).a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
      }
    }
  }
  
  public void onScrollStateChanged(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (ViolaBaseView.o(this.a) != null) {
      ViolaBaseView.o(this.a).a(paramString, paramInt1);
    }
    if (paramString.equals(ViolaBaseView.n(this.a).getMasterListRef()))
    {
      ViolaBaseView.c(this.a, paramInt2);
      ViolaBaseView.b(this.a, true);
    }
  }
  
  public void onWormholeCreated(View paramView)
  {
    WormholeManager.a().a(this.a);
  }
  
  public void pageOpenSuccess()
  {
    ViolaBaseView.b(this.a, 3);
    ViolaBaseView.l(this.a);
    ViolaBaseView.m(this.a);
    if ((!TextUtils.isEmpty(this.a.a)) && (this.a.a.contains("VideoFeeds.js")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(System.currentTimeMillis());
      PublicAccountReportUtils.a(null, null, "0X800AF0E", "0X800AF0E", 0, 0, null, null, null, localStringBuilder.toString(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.12
 * JD-Core Version:    0.7.0.1
 */