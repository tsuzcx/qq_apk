package dov.com.qq.im.aeeditor.view.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.MainThread;
import bmpg;
import bmph;
import bmpi;

public class TimelineView
  extends RelativeLayout
{
  private View jdField_a_of_type_AndroidViewView;
  protected ViewGroup a;
  private bmpg jdField_a_of_type_Bmpg;
  protected SliderView a;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  protected int b;
  private View b;
  protected SliderView b;
  
  public TimelineView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TimelineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimelineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = 0;
    a();
  }
  
  private void a()
  {
    b();
    h();
    g();
  }
  
  private void a(boolean paramBoolean)
  {
    getParent().requestDisallowInterceptTouchEvent(false);
    if (this.jdField_a_of_type_Bmpg != null) {
      this.jdField_a_of_type_Bmpg.a(paramBoolean);
    }
  }
  
  private void b()
  {
    d();
    e();
    f();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = a();
    this.jdField_a_of_type_AndroidViewViewGroup.setId(c());
    addView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  private void e()
  {
    n();
    o();
  }
  
  private void f()
  {
    p();
    q();
  }
  
  private void g()
  {
    int i = 0;
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { this.jdField_a_of_type_DovComQqImAeeditorViewTimelineSliderView, this.jdField_b_of_type_DovComQqImAeeditorViewTimelineSliderView, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidViewView };
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = arrayOfView.length;
    if (i < j)
    {
      View localView = arrayOfView[i];
      if (localView == null) {}
      for (;;)
      {
        i += 1;
        break;
        localView.setVisibility(8);
      }
    }
  }
  
  private void h()
  {
    i();
    j();
    k();
    l();
    m();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setPadding(e(), 0, e(), 0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.leftMargin = h();
    localLayoutParams.rightMargin = h();
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
  }
  
  private void j()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAeeditorViewTimelineSliderView.getLayoutParams();
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.width = h();
    this.jdField_a_of_type_DovComQqImAeeditorViewTimelineSliderView.setLayoutParams(localLayoutParams);
  }
  
  private void k()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_DovComQqImAeeditorViewTimelineSliderView.getLayoutParams();
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.width = h();
    this.jdField_b_of_type_DovComQqImAeeditorViewTimelineSliderView.setLayoutParams(localLayoutParams);
  }
  
  private void l()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.addRule(5, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.addRule(6, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.addRule(7, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.height = k();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void m()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.addRule(5, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.addRule(7, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.addRule(8, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.height = k();
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void n()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewTimelineSliderView = a();
    this.jdField_a_of_type_DovComQqImAeeditorViewTimelineSliderView.setId(f());
    this.jdField_a_of_type_DovComQqImAeeditorViewTimelineSliderView.setSliderListener(new bmph(this));
    addView(this.jdField_a_of_type_DovComQqImAeeditorViewTimelineSliderView);
  }
  
  private void o()
  {
    this.jdField_b_of_type_DovComQqImAeeditorViewTimelineSliderView = b();
    this.jdField_b_of_type_DovComQqImAeeditorViewTimelineSliderView.setId(g());
    this.jdField_b_of_type_DovComQqImAeeditorViewTimelineSliderView.setSliderListener(new bmpi(this));
    addView(this.jdField_b_of_type_DovComQqImAeeditorViewTimelineSliderView);
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_a_of_type_AndroidViewView.setId(i());
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837854);
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void q()
  {
    this.jdField_b_of_type_AndroidViewView = b();
    this.jdField_b_of_type_AndroidViewView.setId(j());
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837833);
    addView(this.jdField_b_of_type_AndroidViewView);
  }
  
  protected View a()
  {
    return new FrameView(getContext());
  }
  
  @MainThread
  protected ViewGroup a()
  {
    return new ContentView(getContext());
  }
  
  @MainThread
  protected SliderView a()
  {
    SliderView localSliderView = new SliderView(getContext());
    localSliderView.setImageResource(2130837750);
    return localSliderView;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Bmpg != null) {
      this.jdField_a_of_type_Bmpg.a(paramFloat, true);
    }
  }
  
  @MainThread
  protected View b()
  {
    return new FrameView(getContext());
  }
  
  @MainThread
  protected SliderView b()
  {
    SliderView localSliderView = new SliderView(getContext());
    localSliderView.setImageResource(2130837751);
    return localSliderView;
  }
  
  public void b(float paramFloat)
  {
    if (this.jdField_a_of_type_Bmpg != null) {
      this.jdField_a_of_type_Bmpg.a(paramFloat, false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 0;
    View[] arrayOfView;
    View localView;
    int j;
    if (this.jdField_b_of_type_Int == 0)
    {
      arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
      int k = arrayOfView.length;
      i = 0;
      for (;;)
      {
        if (i >= k) {
          return;
        }
        localView = arrayOfView[i];
        if (localView != null) {
          break;
        }
        i += 1;
      }
      if (paramBoolean) {}
      for (j = 0;; j = 8)
      {
        localView.setVisibility(j);
        break;
      }
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
      j = arrayOfView.length;
      if (i < j)
      {
        localView = arrayOfView[i];
        if (localView == null) {}
        for (;;)
        {
          i += 1;
          break;
          localView.setVisibility(8);
        }
      }
    }
  }
  
  @IdRes
  protected int c()
  {
    return 2131362256;
  }
  
  public void c()
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    if (this.jdField_a_of_type_Bmpg != null) {
      this.jdField_a_of_type_Bmpg.b();
    }
  }
  
  protected int d()
  {
    return getResources().getDimensionPixelOffset(2131296320);
  }
  
  protected int e()
  {
    return getResources().getDimensionPixelOffset(2131296283);
  }
  
  @IdRes
  protected int f()
  {
    return 2131362257;
  }
  
  @IdRes
  protected int g()
  {
    return 2131362258;
  }
  
  protected int h()
  {
    return getResources().getDimensionPixelOffset(2131296322);
  }
  
  @IdRes
  protected int i()
  {
    return 2131362259;
  }
  
  @IdRes
  protected int j()
  {
    return 2131362255;
  }
  
  protected int k()
  {
    return getResources().getDimensionPixelOffset(2131296284);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    b(paramBoolean);
  }
  
  public void setSelectedStyle(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setTimelineListener(bmpg parambmpg)
  {
    this.jdField_a_of_type_Bmpg = parambmpg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.timeline.TimelineView
 * JD-Core Version:    0.7.0.1
 */