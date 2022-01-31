package dov.com.qq.im.ae.album;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import bkls;
import bklt;
import bklu;
import blfg;
import com.tencent.mobileqq.R.styleable;

public class AEAlbumLinearLayout
  extends LinearLayout
  implements NestedScrollingParent
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private View jdField_a_of_type_AndroidViewView;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private bklu jdField_a_of_type_Bklu;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private int c;
  private int d = 0;
  private int e = 0;
  
  public AEAlbumLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEAlbumLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEAlbumLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AEAlbumLinearLayout);
    try
    {
      this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(0, 0);
    }
    catch (Exception paramAttributeSet)
    {
      for (;;)
      {
        blfg.a("AEAlbumLinearLayout", "constructor, error=", paramAttributeSet);
        paramContext.recycle();
      }
    }
    finally
    {
      paramContext.recycle();
    }
    setOrientation(1);
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  }
  
  private float a()
  {
    return 1.0F * getScrollY() / this.c;
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt == 1) {
      return b();
    }
    if (paramInt == 2) {
      return a();
    }
    return false;
  }
  
  private void c()
  {
    int i = this.c / 2;
    if ((getScrollY() > 0) && (getScrollY() < i)) {
      b();
    }
    while ((i > getScrollY()) || (getScrollY() >= this.c)) {
      return;
    }
    a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bkls(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bklt(this));
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public void a()
  {
    blfg.a("AEAlbumLinearLayout", "[collapsePreviewContainer]");
    if (getScrollY() >= this.c)
    {
      blfg.a("AEAlbumLinearLayout", "[collapsePreviewContainer], already collapsed");
      return;
    }
    this.e = 1;
    int i = this.c - getScrollY();
    int j = (int)(1.0F * i / this.c * 275.0F);
    blfg.a("AEAlbumLinearLayout", "[collapsePreviewContainer], dy=" + i + ", duration=" + j);
    d();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { getScrollY(), this.c });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(j);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public boolean a()
  {
    return getScrollY() == 0;
  }
  
  public void b()
  {
    blfg.a("AEAlbumLinearLayout", "[expandPreviewContainer]");
    if (getScrollY() <= 0)
    {
      blfg.a("AEAlbumLinearLayout", "[expandPreviewContainer], already expanded");
      return;
    }
    this.e = 2;
    int i = -getScrollY();
    int j = (int)(1.0F * getScrollY() / this.c * 275.0F);
    blfg.a("AEAlbumLinearLayout", "[expandPreviewContainer], dy=" + i + ", duration=" + j);
    d();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { getScrollY(), 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(j);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public boolean b()
  {
    return getScrollY() == this.c;
  }
  
  public int getNestedScrollAxes()
  {
    blfg.a("AEAlbumLinearLayout", "[getNestedScrollAxes]");
    return 2;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidViewView = getChildAt(0);
    this.jdField_b_of_type_AndroidViewView = getChildAt(1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    if ((this.jdField_b_of_type_Int < this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Int == 0)) {
      this.jdField_a_of_type_Int = (this.jdField_b_of_type_Int / 3);
    }
    this.c = (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidViewView.getLayoutParams().height = (getMeasuredHeight() - this.jdField_a_of_type_Int);
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + this.jdField_b_of_type_AndroidViewView.getMeasuredHeight());
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    blfg.a("AEAlbumLinearLayout", "[onNestedFling], velocityX=" + paramFloat1 + ", velocityY=" + paramFloat2 + ", consumed=" + paramBoolean);
    return super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    blfg.a("AEAlbumLinearLayout", "[onNestedPreFling], velocityX=" + paramFloat1 + ", velocityY=" + paramFloat2);
    if ((paramFloat2 > 0.0F) && (getScrollY() < this.c))
    {
      a();
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    blfg.a("AEAlbumLinearLayout", "[onNestedPreScroll], dy=" + paramInt2 + ", scrollY=" + getScrollY());
    int i;
    if ((paramInt2 > 0) && (getScrollY() < this.c))
    {
      paramInt1 = 1;
      if ((paramInt2 >= 0) || (getScrollY() <= 0) || (ViewCompat.canScrollVertically(paramView, -1))) {
        break label163;
      }
      i = 1;
      label75:
      if ((paramInt1 != 0) || (i != 0))
      {
        if (paramInt1 == 0) {
          break label169;
        }
        paramInt2 = Math.min(paramInt2, this.c - getScrollY());
        label102:
        scrollBy(0, paramInt2);
        paramArrayOfInt[1] = paramInt2;
        if (paramInt1 == 0) {
          break label182;
        }
      }
    }
    label163:
    label169:
    label182:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.d = paramInt1;
      if (this.jdField_a_of_type_Bklu != null)
      {
        this.jdField_a_of_type_Bklu.a(this.d);
        this.jdField_a_of_type_Bklu.a(a());
      }
      return;
      paramInt1 = 0;
      break;
      i = 0;
      break label75;
      paramInt2 = Math.max(paramInt2, -getScrollY());
      break label102;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    blfg.a("AEAlbumLinearLayout", "[onNestedScroll], dxConsumed=" + paramInt1 + ", dyConsumed=" + paramInt2 + ", dxUnconsumed=" + paramInt3 + ", dyUnconsumed=" + paramInt4);
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Bklu != null) {
      this.jdField_a_of_type_Bklu.a(a());
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    blfg.a("AEAlbumLinearLayout", "[onNestedScrollAccepted], axes=" + paramInt);
    super.onNestedScrollAccepted(paramView1, paramView2, paramInt);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    blfg.a("AEAlbumLinearLayout", "[onStartNestedScroll], nestedScrollAxes=" + paramInt);
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    blfg.a("AEAlbumLinearLayout", "[onStopNestedScroll], scrollY=" + getScrollY());
    super.onStopNestedScroll(paramView);
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bklu != null) {
        this.jdField_a_of_type_Bklu.a(this.d, a(this.d));
      }
      this.d = 0;
      return;
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void setScrollListener(@Nullable bklu parambklu)
  {
    this.jdField_a_of_type_Bklu = parambklu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.album.AEAlbumLinearLayout
 * JD-Core Version:    0.7.0.1
 */