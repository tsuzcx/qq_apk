package com.tencent.mobileqq.richmedia.capture.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.CaptureVideoFilterRefreshListener;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class CaptureVideoFilterViewPager
  extends UnHandleTouchEventViewPager
  implements CaptureVideoFilterManager.CaptureVideoFilterRefreshListener
{
  private int jdField_a_of_type_Int = -1;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private CaptureVideoFilterViewPager.OnViewPageListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$OnViewPageListener;
  private CaptureVideoFilterViewPager.VideoFilterPagerAdapter jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$VideoFilterPagerAdapter;
  List<FilterCategoryItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public CaptureVideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public CaptureVideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageSelect position: " + paramInt + ", mCurPosition: " + this.jdField_a_of_type_Int);
    }
    if (paramInt == this.jdField_a_of_type_Int) {}
    FilterCategoryItem localFilterCategoryItem;
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = paramInt;
      paramView.setVisibility(0);
      localFilterCategoryItem = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
      if (localFilterCategoryItem != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterViewPager", 2, "onPageSelect cannot find item");
    return;
    CaptureVideoFilterManager.a().a(localFilterCategoryItem);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$OnViewPageListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$OnViewPageListener.a(localFilterCategoryItem);
    }
    Object localObject2 = (TextView)paramView.findViewById(2131381383);
    TextView localTextView = (TextView)paramView.findViewById(2131381382);
    Object localObject1 = (TextView)paramView.findViewById(2131381384);
    if (localFilterCategoryItem.a())
    {
      ((TextView)localObject2).setText(HardCodeUtil.a(2131701517));
      paramView.setContentDescription("无滤镜No Filter");
      localTextView.setText(" - No Filter - ");
      ((TextView)localObject1).setText("");
      ((TextView)localObject1).setCompoundDrawables(null, null, null, null);
      localObject1 = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject1).setDuration(500L);
      ((AlphaAnimation)localObject1).setStartOffset(500L);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      paramView.startAnimation((Animation)localObject1);
      ((AlphaAnimation)localObject1).setAnimationListener(new CaptureVideoFilterViewPager.3(this, paramView, paramInt));
      paramView.setVisibility(0);
      a(true);
      paramView.clearAnimation();
      paramView.startAnimation((Animation)localObject1);
      CaptureReportUtil.d = localFilterCategoryItem.jdField_b_of_type_Int + "";
      CaptureReportUtil.e = localFilterCategoryItem.a;
      if (CameraControl.a().jdField_a_of_type_Int != 1) {
        break label473;
      }
    }
    label473:
    for (paramInt = 1;; paramInt = 2)
    {
      CaptureReportUtil.b(paramInt);
      return;
      ((TextView)localObject2).setText(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
      localTextView.setText(" - " + localFilterCategoryItem.e + " - ");
      ((TextView)localObject1).setText(localFilterCategoryItem.f);
      paramView.setContentDescription(localFilterCategoryItem.jdField_b_of_type_JavaLangString + "," + localFilterCategoryItem.f + HardCodeUtil.a(2131701516));
      localObject2 = getResources().getDrawable(2130846262);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth() / 3 * 2, ((Drawable)localObject2).getIntrinsicHeight() / 3 * 2);
      ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      break;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$OnViewPageListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$OnViewPageListener.a(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "notifyVisiableChange " + paramBoolean);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$VideoFilterPagerAdapter = new CaptureVideoFilterViewPager.VideoFilterPagerAdapter(this);
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$VideoFilterPagerAdapter);
    setOnPageChangeListener(new CaptureVideoFilterViewPager.VideoFilterPageChangeListener(this));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$VideoFilterPagerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$VideoFilterPagerAdapter.a();
    }
    return 0;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new CaptureVideoFilterViewPager.2(this));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$VideoFilterPagerAdapter != null) && (CaptureVideoFilterManager.a(getContext()))) {
      ThreadManager.getUIHandler().post(new CaptureVideoFilterViewPager.1(this));
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    CaptureVideoFilterManager.a().a(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new CaptureVideoFilterViewPager.FilterBroadcastReceiver(this, null);
    getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("action_brocassreceiver_for_filter"));
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    CaptureVideoFilterManager.a().a();
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("VideoFilterViewPager", 2, localException.getMessage());
    }
  }
  
  public void setCurrentItem(FilterCategoryItem paramFilterCategoryItem)
  {
    int i;
    if (paramFilterCategoryItem != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label67;
      }
      if (!paramFilterCategoryItem.a.equals(((FilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(i)).a)) {
        break label60;
      }
    }
    for (;;)
    {
      setCurrentItem(a() * 20 + i, false);
      return;
      label60:
      i += 1;
      break;
      label67:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */