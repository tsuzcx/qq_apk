package dov.com.qq.im.AECamera.View;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import bgxh;
import bgza;
import bgzb;
import bgzc;
import bgzd;
import bgze;
import bhfm;
import bhgs;
import bhog;
import bjac;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import vms;
import wsh;
import wus;

public class AEProviderContainerView
  extends FrameLayout
{
  public int a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bgza(this);
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private bgxh jdField_a_of_type_Bgxh;
  private AEBeautyProviderView jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView;
  private AEFilterProviderView jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private wsh jdField_a_of_type_Wsh = wsh.jdField_a_of_type_Wsh;
  private wus jdField_a_of_type_Wus;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = true;
  private View d;
  
  public AEProviderContainerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = vms.a(getContext(), 195.0F);
    i();
  }
  
  public AEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = vms.a(getContext(), 195.0F);
    i();
  }
  
  public AEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = vms.a(getContext(), 195.0F);
    i();
  }
  
  private void i()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131492956, null);
    addView(localView);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131297588);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131300667);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131306358));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131306359);
    this.d = localView.findViewById(2131298439);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_AndroidViewView);
  }
  
  private void j()
  {
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 0: 
      k();
      return;
    }
    l();
  }
  
  private void k()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_AndroidViewView.setSelected(true);
    this.jdField_a_of_type_AndroidViewView.setSelected(false);
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView = null;
    }
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView == null)
    {
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView = new AEFilterProviderView(getContext());
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.setNeedTabBar(false);
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.d(vms.a(getContext(), 162.0F));
      if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView);
      }
    }
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView != null)
    {
      if (!this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.d)
      {
        this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.a(null);
        this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.setFilterItemBorderMode(this.jdField_c_of_type_Boolean);
      }
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.c();
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_AndroidViewView.setSelected(false);
    this.jdField_a_of_type_AndroidViewView.setSelected(true);
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.d();
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView = null;
    }
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView == null)
    {
      this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView = new AEBeautyProviderView(getContext());
      if (this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView);
      }
    }
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView != null)
    {
      if (!this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.setController(this.jdField_a_of_type_Bgxh);
        this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.a(null);
      }
      this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.a();
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new bgzd(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = bhog.a(this, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bgze(this));
    startAnimation((Animation)localObject);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Wsh == wsh.c;
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AEProviderContainerView", 2, "doOpenProviderView failed isInflated" + this.jdField_b_of_type_Boolean);
      }
      return;
    }
    j();
    e();
  }
  
  public boolean b()
  {
    int j = 1;
    boolean bool2 = false;
    int i;
    if ((this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView != null) || (this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView != null))
    {
      if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView == null) {
        break label82;
      }
      if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.getVisibility() != 0) {
        break label72;
      }
      i = 1;
    }
    label72:
    label77:
    label82:
    for (boolean bool1 = i | 0x0;; bool1 = false)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView != null) {
        if (this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.getVisibility() != 0) {
          break label77;
        }
      }
      for (i = j;; i = 0)
      {
        bool2 = bool1 | i;
        return bool2;
        i = 0;
        break;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.e();
    }
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView != null) {
      this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      m();
    }
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.d();
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView = null;
    }
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView = null;
    }
    if (this.jdField_a_of_type_Wus != null) {
      this.jdField_a_of_type_Wus.a(196613, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEProviderContainerView", 2, "panel closed");
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this, "translationY", new float[] { this.jdField_a_of_type_Int, 0.0F }));
    ((AnimatorSet)localObject).addListener(new bgzb(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = bhog.a(this, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bgzc(this));
    startAnimation((Animation)localObject);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.f();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.b();
    }
    bjac.a().b(null, (Activity)getContext(), 0);
    bjac.a().a(null, 0);
    ((bhgs)bhfm.a(5)).a((Activity)getContext());
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView != null) {
      this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView.c();
    }
  }
  
  public void setBackGroundAlpha(float paramFloat)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if (localView != null) {
          localView.setAlpha(paramFloat);
        }
      }
    }
  }
  
  public void setCaptureMode(wsh paramwsh)
  {
    this.jdField_a_of_type_Wsh = paramwsh;
  }
  
  public void setControllerAndManager(bgxh parambgxh, wus paramwus)
  {
    this.jdField_a_of_type_Bgxh = parambgxh;
    this.jdField_a_of_type_Wus = paramwus;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void setFilterItemBorderMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAECameraViewAEFilterProviderView.setFilterItemBorderMode(this.jdField_c_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AEProviderContainerView
 * JD-Core Version:    0.7.0.1
 */