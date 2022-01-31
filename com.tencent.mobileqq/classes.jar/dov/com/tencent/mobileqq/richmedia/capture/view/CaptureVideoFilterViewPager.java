package dov.com.tencent.mobileqq.richmedia.capture.view;

import alpo;
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
import axlc;
import azcx;
import bngf;
import bngh;
import bnhm;
import bnhn;
import bnhp;
import bnhq;
import bnhr;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class CaptureVideoFilterViewPager
  extends UnHandleTouchEventViewPager
  implements bngh
{
  private int jdField_a_of_type_Int = -1;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private bnhr jdField_a_of_type_Bnhr;
  private WeakReference<bnhp> jdField_a_of_type_JavaLangRefWeakReference;
  public List<FilterCategoryItem> a;
  
  public CaptureVideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    c();
  }
  
  public CaptureVideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
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
      localFilterCategoryItem = this.jdField_a_of_type_Bnhr.a(paramInt);
      if (localFilterCategoryItem != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterViewPager", 2, "onPageSelect cannot find item");
    return;
    bngf.a().a(localFilterCategoryItem);
    Object localObject2 = (TextView)paramView.findViewById(2131379662);
    TextView localTextView = (TextView)paramView.findViewById(2131379661);
    Object localObject1 = (TextView)paramView.findViewById(2131379663);
    if (localFilterCategoryItem.a())
    {
      ((TextView)localObject2).setText(alpo.a(2131701819));
      localTextView.setText(" - No Filter - ");
      ((TextView)localObject1).setText("");
      ((TextView)localObject1).setCompoundDrawables(null, null, null, null);
      localObject1 = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject1).setDuration(500L);
      ((AlphaAnimation)localObject1).setStartOffset(500L);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      paramView.startAnimation((Animation)localObject1);
      ((AlphaAnimation)localObject1).setAnimationListener(new bnhm(this, paramView, paramInt));
      paramView.setVisibility(0);
      a(true);
      paramView.clearAnimation();
      paramView.startAnimation((Animation)localObject1);
      axlc.d = localFilterCategoryItem.jdField_b_of_type_Int + "";
      axlc.e = localFilterCategoryItem.a;
      if (azcx.a().jdField_a_of_type_Int != 1) {
        break label406;
      }
    }
    label406:
    for (paramInt = 1;; paramInt = 2)
    {
      axlc.e(paramInt);
      return;
      ((TextView)localObject2).setText(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
      localTextView.setText(" - " + localFilterCategoryItem.e + " - ");
      ((TextView)localObject1).setText(localFilterCategoryItem.f);
      localObject2 = getResources().getDrawable(2130845468);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth() / 3 * 2, ((Drawable)localObject2).getIntrinsicHeight() / 3 * 2);
      ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      break;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((bnhp)this.jdField_a_of_type_JavaLangRefWeakReference.get()).m(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "notifyVisiableChange " + paramBoolean);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Bnhr = new bnhr(this);
    setAdapter(this.jdField_a_of_type_Bnhr);
    setOnPageChangeListener(new bnhq(this));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Bnhr != null) {
      return this.jdField_a_of_type_Bnhr.a();
    }
    return 0;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new CaptureVideoFilterViewPager.2(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bnhr != null) {
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
    bngf.a().a(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bnhn(this, null);
    getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("action_brocassreceiver_for_filter"));
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    bngf.a().a();
    bngf.a().d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */