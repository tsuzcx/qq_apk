package dov.com.tencent.biz.qqstory.takevideo.sendpanel;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import bnpr;
import bnqd;
import bnqe;
import bnqf;
import bnqg;
import bnqh;
import com.tencent.mobileqq.mini.util.DisplayUtil;

public class SlideBottomPanel
  extends FrameLayout
{
  protected static float a;
  protected int a;
  protected long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  protected Interpolator a;
  public bnpr a;
  public boolean a;
  protected float b;
  public int b;
  protected Interpolator b;
  public boolean b;
  protected float c;
  protected int c;
  protected boolean c;
  protected float d;
  protected int d;
  protected boolean d;
  protected float e;
  protected int e;
  public boolean e;
  protected float f;
  protected int f;
  protected float g;
  private int g;
  protected float h;
  private int h;
  protected float i;
  private int i;
  public float j;
  protected float k;
  private float l;
  
  static
  {
    jdField_a_of_type_Float = 5.0F;
  }
  
  public SlideBottomPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateInterpolator();
    this.jdField_b_of_type_AndroidViewAnimationInterpolator = new AccelerateInterpolator();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.l = getResources().getDisplayMetrics().density;
    paramContext = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_h_of_type_Int = paramContext.getScaledMaximumFlingVelocity();
    this.jdField_a_of_type_Int = paramContext.getScaledMinimumFlingVelocity();
    this.jdField_d_of_type_Float = paramContext.getScaledTouchSlop();
    paramContext = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    paramAttributeSet = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(paramAttributeSet);
    this.jdField_i_of_type_Int = paramAttributeSet.heightPixels;
    this.jdField_i_of_type_Float = (this.jdField_i_of_type_Int - a(60));
    float f1 = a(84);
    this.j = f1;
    jdField_a_of_type_Float = f1;
    this.k = a(30);
    this.jdField_c_of_type_Int = 250;
    this.jdField_b_of_type_Int = this.jdField_i_of_type_Int;
    if ((DisplayUtil.hasNavBar(this.jdField_a_of_type_AndroidContentContext)) && (DisplayUtil.isNavigationBarShow((Activity)this.jdField_a_of_type_AndroidContentContext))) {}
    for (this.jdField_d_of_type_Int = a(30);; this.jdField_d_of_type_Int = a(51))
    {
      this.jdField_e_of_type_Int = ((int)(this.j - this.jdField_d_of_type_Int));
      this.jdField_f_of_type_Int = a(5);
      return;
    }
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt * this.l + 0.5F);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  protected double a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  protected int a()
  {
    if (this.jdField_e_of_type_Boolean) {
      return this.jdField_b_of_type_Int - this.jdField_d_of_type_Int;
    }
    return (int)(this.jdField_b_of_type_Int - this.j);
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      View localView = findViewWithTag(Integer.valueOf(1));
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { localView.getY(), this.jdField_b_of_type_Int - this.jdField_i_of_type_Float }).setDuration(this.jdField_c_of_type_Int);
      localValueAnimator.setTarget(localView);
      localValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      localValueAnimator.addUpdateListener(new bnqg(this, localView));
      localValueAnimator.addListener(new bnqh(this));
      localValueAnimator.start();
      this.jdField_b_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = false;
    } while (this.jdField_a_of_type_Bnpr == null);
    this.jdField_a_of_type_Bnpr.displayPanel();
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_d_of_type_Boolean) {}
    View localView;
    do
    {
      do
      {
        do
        {
          return;
          f();
        } while (Math.abs(this.jdField_b_of_type_Float) > Math.abs(this.jdField_c_of_type_Float));
        localView = findViewWithTag(Integer.valueOf(1));
        if ((!this.jdField_c_of_type_Boolean) && (Math.abs(paramMotionEvent.getY() - this.jdField_f_of_type_Float) > this.jdField_d_of_type_Float))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_g_of_type_Float = paramMotionEvent.getY();
          localView.addOnLayoutChangeListener(new bnqd(this));
        }
      } while (!this.jdField_c_of_type_Boolean);
      this.jdField_h_of_type_Float = (paramMotionEvent.getY() - this.jdField_g_of_type_Float);
      this.jdField_g_of_type_Float = paramMotionEvent.getY();
      float f1 = localView.getY();
      if ((this.jdField_a_of_type_Bnpr != null) && (f1 > this.jdField_b_of_type_Int - this.jdField_i_of_type_Float) && (f1 < this.jdField_b_of_type_Int - this.j)) {
        this.jdField_a_of_type_Bnpr.fadeBackground(1.0F - f1 / (this.jdField_b_of_type_Int - this.j));
      }
      if (this.jdField_h_of_type_Float + f1 <= this.jdField_b_of_type_Int - this.jdField_i_of_type_Float)
      {
        localView.offsetTopAndBottom((int)(this.jdField_b_of_type_Int - this.jdField_i_of_type_Float - f1));
        return;
      }
      if (f1 + this.jdField_h_of_type_Float < a()) {
        break;
      }
    } while (this.jdField_e_of_type_Boolean);
    if (this.jdField_h_of_type_Float > this.jdField_e_of_type_Int) {
      this.jdField_h_of_type_Float = this.jdField_e_of_type_Int;
    }
    localView.offsetTopAndBottom((int)this.jdField_h_of_type_Float);
    return;
    localView.offsetTopAndBottom((int)this.jdField_h_of_type_Float);
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Float = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    this.jdField_g_of_type_Float = f1;
    this.jdField_f_of_type_Float = f1;
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_g_of_type_Float > a()))
    {
      this.jdField_d_of_type_Boolean = true;
      return true;
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_g_of_type_Float <= a()))
    {
      this.jdField_d_of_type_Boolean = false;
      return false;
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_g_of_type_Float > this.jdField_b_of_type_Int - this.jdField_i_of_type_Float) && (this.jdField_g_of_type_Float <= this.jdField_b_of_type_Int - this.jdField_i_of_type_Float + this.j))
    {
      this.jdField_d_of_type_Boolean = true;
      return false;
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_g_of_type_Float < this.jdField_b_of_type_Int - this.jdField_i_of_type_Float))
    {
      b();
      this.jdField_d_of_type_Boolean = false;
    }
    return false;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      View localView = findViewWithTag(Integer.valueOf(1));
      int m = (int)(this.jdField_b_of_type_Int - this.j);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { localView.getY(), this.jdField_b_of_type_Int - this.j });
      localValueAnimator.setInterpolator(this.jdField_b_of_type_AndroidViewAnimationInterpolator);
      localValueAnimator.setTarget(localView);
      localValueAnimator.addUpdateListener(new bnqe(this, localView, m));
      localValueAnimator.addListener(new bnqf(this));
      localValueAnimator.start();
    } while (this.jdField_a_of_type_Bnpr == null);
    this.jdField_a_of_type_Bnpr.hidePanel();
  }
  
  protected void b(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    f();
    float f1;
    if (((!this.jdField_b_of_type_Boolean) && (paramMotionEvent.getY() - this.jdField_f_of_type_Float < 0.0F) && (Math.abs(paramMotionEvent.getY() - this.jdField_f_of_type_Float) > this.k)) || ((this.jdField_c_of_type_Float < 0.0F) && (Math.abs(this.jdField_c_of_type_Float) > Math.abs(this.jdField_b_of_type_Float)) && (Math.abs(this.jdField_c_of_type_Float) > this.jdField_a_of_type_Int)))
    {
      a();
      if (this.jdField_b_of_type_Boolean)
      {
        paramMotionEvent = findViewWithTag(Integer.valueOf(1));
        f1 = paramMotionEvent.getY();
        if ((f1 >= this.jdField_b_of_type_Int - this.jdField_i_of_type_Float) && (f1 >= this.jdField_b_of_type_Int - this.jdField_i_of_type_Float + this.k)) {
          break label434;
        }
        ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { f1, this.jdField_b_of_type_Int - this.jdField_i_of_type_Float }).setDuration(this.jdField_c_of_type_Int).start();
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_h_of_type_Float = 0.0F;
      return;
      if ((!this.jdField_b_of_type_Boolean) && (l1 - l2 < 300L) && (paramMotionEvent.getY() - this.jdField_f_of_type_Float < 0.0F) && (a(this.jdField_e_of_type_Float, this.jdField_f_of_type_Float, paramMotionEvent.getX(), paramMotionEvent.getY()) < jdField_a_of_type_Float))
      {
        a();
        break;
      }
      if ((this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean)) {
        break;
      }
      int m = (int)(paramMotionEvent.getY() - this.jdField_f_of_type_Float);
      if (((!this.jdField_e_of_type_Boolean) && (m > this.jdField_f_of_type_Int)) || ((this.jdField_e_of_type_Boolean) && (m < 0) && (Math.abs(m) < this.k))) {
        c();
      }
      if ((this.jdField_e_of_type_Boolean) || (m >= 0) || (Math.abs(m) >= this.k)) {
        break;
      }
      paramMotionEvent = findViewWithTag(Integer.valueOf(1));
      ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { paramMotionEvent.getY(), this.jdField_b_of_type_Int - this.j }).setDuration(this.jdField_c_of_type_Int).start();
      break;
      label434:
      if (f1 > this.jdField_b_of_type_Int - this.jdField_i_of_type_Float + this.k) {
        b();
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    View localView = findViewWithTag(Integer.valueOf(1));
    ObjectAnimator.ofFloat(localView, "y", new float[] { localView.getY(), this.jdField_b_of_type_Int - this.jdField_d_of_type_Int }).setDuration(this.jdField_c_of_type_Int).start();
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void d()
  {
    View localView = findViewWithTag(Integer.valueOf(1));
    ObjectAnimator.ofFloat(localView, "y", new float[] { localView.getY(), this.jdField_b_of_type_Int - this.j }).setDuration(this.jdField_c_of_type_Int).start();
    this.jdField_e_of_type_Boolean = false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    c(paramMotionEvent);
    if (this.jdField_a_of_type_Bnpr != null) {
      this.jdField_a_of_type_Bnpr.cancelAnimator();
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool1 = false;
      for (;;)
      {
        if (!bool1)
        {
          bool1 = bool2;
          if (!super.dispatchTouchEvent(paramMotionEvent)) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
        bool1 = a(paramMotionEvent);
        continue;
        a(paramMotionEvent);
        bool1 = false;
      }
      b(paramMotionEvent);
      g();
    }
  }
  
  public void e()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    b();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_h_of_type_Int);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_g_of_type_Int = getChildCount();
    paramInt2 = (int)(this.jdField_b_of_type_Int - this.j);
    paramInt1 = 0;
    while (paramInt1 < this.jdField_g_of_type_Int)
    {
      View localView = getChildAt(paramInt1);
      localView.layout(0, paramInt2, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt2);
      localView.setTag(Integer.valueOf(1));
      paramInt1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Boolean);
  }
  
  public void setSlidePanelListener(bnpr parambnpr)
  {
    this.jdField_a_of_type_Bnpr = parambnpr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel
 * JD-Core Version:    0.7.0.1
 */