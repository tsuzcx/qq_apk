package dov.com.qq.im.ae.camera.ui.panel;

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
import biju;
import biod;
import bioe;
import biof;
import biog;
import bioh;
import bivx;
import biwb;
import bjae;
import bjbk;
import bjiy;
import bkqo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import vzo;

public class AEProviderContainerView
  extends FrameLayout
{
  public int a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new biod(this);
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private biju jdField_a_of_type_Biju;
  private bivx jdField_a_of_type_Bivx = bivx.jdField_a_of_type_Bivx;
  private biwb jdField_a_of_type_Biwb;
  private AEBeautyProviderView jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView;
  private AEFilterProviderView jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
    this.jdField_a_of_type_Int = vzo.a(getContext(), 195.0F);
    i();
  }
  
  public AEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = vzo.a(getContext(), 195.0F);
    i();
  }
  
  public AEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = vzo.a(getContext(), 195.0F);
    i();
  }
  
  private void i()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131558496, null);
    addView(localView);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363138);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131366269);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131372055));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131372056);
    this.d = localView.findViewById(2131363996);
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
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView = null;
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView == null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView = new AEFilterProviderView(getContext());
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setNeedTabBar(false);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.d(vzo.a(getContext(), 162.0F));
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView);
      }
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null)
    {
      if (!this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.d)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.a(null);
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setFilterItemBorderMode(this.jdField_c_of_type_Boolean);
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.c();
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_AndroidViewView.setSelected(false);
    this.jdField_a_of_type_AndroidViewView.setSelected(true);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.d();
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView = null;
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView == null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView = new AEBeautyProviderView(getContext());
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView);
      }
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView != null)
    {
      if (!this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.setController(this.jdField_a_of_type_Biju);
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.a(null);
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.a();
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new biog(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = bjiy.a(this, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bioh(this));
    startAnimation((Animation)localObject);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bivx == bivx.c;
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
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) || (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView == null) {
        break label82;
      }
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.getVisibility() != 0) {
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
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView != null) {
        if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.getVisibility() != 0) {
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
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.e();
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      m();
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.d();
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView = null;
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView = null;
    }
    if (this.jdField_a_of_type_Biwb != null) {
      this.jdField_a_of_type_Biwb.a(196613, new Object[0]);
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
    ((AnimatorSet)localObject).addListener(new bioe(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = bjiy.a(this, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new biof(this));
    startAnimation((Animation)localObject);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.f();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.b();
    }
    bkqo.a().b(null, (Activity)getContext(), 0);
    bkqo.a().a(null, 0);
    ((bjbk)bjae.a(5)).a((Activity)getContext());
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView.c();
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
  
  public void setCaptureMode(bivx parambivx)
  {
    this.jdField_a_of_type_Bivx = parambivx;
  }
  
  public void setControllerAndManager(biju parambiju, biwb parambiwb)
  {
    this.jdField_a_of_type_Biju = parambiju;
    this.jdField_a_of_type_Biwb = parambiwb;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void setFilterItemBorderMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setFilterItemBorderMode(this.jdField_c_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView
 * JD-Core Version:    0.7.0.1
 */