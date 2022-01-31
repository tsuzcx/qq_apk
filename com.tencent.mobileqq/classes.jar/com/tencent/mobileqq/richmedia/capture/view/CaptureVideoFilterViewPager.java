package com.tencent.mobileqq.richmedia.capture.view;

import agxo;
import agxp;
import agxq;
import agxr;
import agxt;
import agxu;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.CaptureVideoFilterRefreshListener;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class CaptureVideoFilterViewPager
  extends UnHandleTouchEventViewPager
  implements CaptureVideoFilterManager.CaptureVideoFilterRefreshListener
{
  private int jdField_a_of_type_Int = -1;
  private agxu jdField_a_of_type_Agxu;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private CaptureVideoFilterViewPager.OnViewPageListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$OnViewPageListener;
  public List a;
  
  public CaptureVideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    e();
  }
  
  public CaptureVideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    e();
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
      localFilterCategoryItem = this.jdField_a_of_type_Agxu.a(paramInt);
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
    Object localObject2 = (TextView)paramView.findViewById(2131363469);
    TextView localTextView = (TextView)paramView.findViewById(2131363470);
    Object localObject1 = (TextView)paramView.findViewById(2131363471);
    if (localFilterCategoryItem.a())
    {
      ((TextView)localObject2).setText("无滤镜");
      paramView.setContentDescription("无滤镜No Filter");
      localTextView.setText(" - No Filter - ");
      ((TextView)localObject1).setText("");
      ((TextView)localObject1).setCompoundDrawables(null, null, null, null);
      localObject1 = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject1).setDuration(500L);
      ((AlphaAnimation)localObject1).setStartOffset(500L);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      paramView.startAnimation((Animation)localObject1);
      ((AlphaAnimation)localObject1).setAnimationListener(new agxq(this, paramView, paramInt));
      paramView.setVisibility(0);
      a(true);
      paramView.clearAnimation();
      paramView.startAnimation((Animation)localObject1);
      CaptureReportUtil.d = localFilterCategoryItem.jdField_b_of_type_Int + "";
      CaptureReportUtil.e = localFilterCategoryItem.jdField_a_of_type_JavaLangString;
      if (CameraControl.a().jdField_a_of_type_Int != 1) {
        break label467;
      }
    }
    label467:
    for (paramInt = 1;; paramInt = 2)
    {
      CaptureReportUtil.e(paramInt);
      return;
      ((TextView)localObject2).setText(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
      localTextView.setText(" - " + localFilterCategoryItem.e + " - ");
      ((TextView)localObject1).setText(localFilterCategoryItem.f);
      paramView.setContentDescription(localFilterCategoryItem.jdField_b_of_type_JavaLangString + "," + localFilterCategoryItem.f + "在使用");
      localObject2 = getResources().getDrawable(2130843096);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth() / 3 * 2, ((Drawable)localObject2).getIntrinsicHeight() / 3 * 2);
      ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      break;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$OnViewPageListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$OnViewPageListener.e(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "notifyVisiableChange " + paramBoolean);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Agxu = new agxu(this);
    setAdapter(this.jdField_a_of_type_Agxu);
    setOnPageChangeListener(new agxt(this));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Agxu != null) {
      return this.jdField_a_of_type_Agxu.a();
    }
    return 0;
  }
  
  public FilterDesc a()
  {
    if (this.jdField_a_of_type_Agxu == null) {
      return null;
    }
    Object localObject1 = this.jdField_a_of_type_Agxu.a(getCurrentItem());
    if ((localObject1 != null) && (((FilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList != null))
    {
      localObject1 = ((FilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = CaptureVideoFilterManager.a().a((String)localObject2);
        if (localObject2 != null) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new agxp(this));
  }
  
  public void a(CaptureVideoFilterViewPager.OnViewPageListener paramOnViewPageListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$OnViewPageListener = paramOnViewPageListener;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager$OnViewPageListener = null;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Agxu != null) && (CaptureVideoFilterManager.a(getContext()))) {
      ThreadManager.getUIHandler().post(new agxo(this));
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Agxu.b();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    CaptureVideoFilterManager.a().a(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new agxr(this, null);
    getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("action_brocassreceiver_for_filter"));
  }
  
  protected void onDetachedFromWindow()
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
      if (!paramFilterCategoryItem.jdField_a_of_type_JavaLangString.equals(((FilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */