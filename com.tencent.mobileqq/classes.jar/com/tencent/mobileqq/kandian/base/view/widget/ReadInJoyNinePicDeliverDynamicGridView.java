package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReadInJoyNinePicDeliverDynamicGridView
  extends GridView
{
  private AdapterView.OnItemClickListener A;
  private AdapterView.OnItemClickListener B = new ReadInJoyNinePicDeliverDynamicGridView.1(this);
  private ReadInJoyNinePicDeliverDynamicGridView.OnSelectedItemBitmapCreationListener C;
  private View D;
  private boolean E;
  private AbsListView.OnScrollListener F = new ReadInJoyNinePicDeliverDynamicGridView.6(this);
  private BitmapDrawable a;
  private Rect b;
  private Rect c;
  private int d = 0;
  private int e = 0;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j;
  private List<Long> k = new ArrayList();
  private long l = -1L;
  private boolean m = false;
  private int n = -1;
  private boolean o;
  private int p = 0;
  private boolean q = false;
  private int r = 0;
  private boolean s = false;
  private boolean t;
  private boolean u;
  private boolean v = true;
  private AbsListView.OnScrollListener w;
  private ReadInJoyNinePicDeliverDynamicGridView.OnDropListener x;
  private ReadInJoyNinePicDeliverDynamicGridView.OnDragListener y;
  private ReadInJoyNinePicDeliverDynamicGridView.OnEditModeChangeListener z;
  
  public ReadInJoyNinePicDeliverDynamicGridView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReadInJoyNinePicDeliverDynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReadInJoyNinePicDeliverDynamicGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public static float a(View paramView)
  {
    return Math.abs((paramView.getRight() - paramView.getLeft()) / 2);
  }
  
  @TargetApi(11)
  private AnimatorSet a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, paramFloat2 });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat3, paramFloat4 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    return localAnimatorSet;
  }
  
  private Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      if (paramConfig == Bitmap.Config.ARGB_8888) {
        return a(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      }
    }
    return null;
  }
  
  private Bitmap a(View paramView, float paramFloat, int paramInt)
  {
    int i1 = (int)(paramView.getWidth() * paramFloat);
    int i2 = (int)(paramView.getHeight() * paramFloat);
    Bitmap localBitmap = a(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    if (localBitmap == null) {
      return null;
    }
    paramView.draw(new Canvas(localBitmap));
    paramView = a(i1 + paramInt, i2 + paramInt, Bitmap.Config.ARGB_8888);
    if (paramView == null) {
      return null;
    }
    Canvas localCanvas = new Canvas(paramView);
    Paint localPaint = new Paint();
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    localCanvas.drawBitmap(localBitmap, null, new Rect(paramInt, paramInt, paramView.getWidth() - paramInt, paramView.getHeight() - paramInt), localPaint);
    return paramView;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ReadInJoyNinePicDeliverDynamicGridView.OnDragListener localOnDragListener = this.y;
    if (localOnDragListener != null) {
      localOnDragListener.a(paramInt1, paramInt2);
    }
    getAdapterInterface().a(paramInt1, paramInt2);
  }
  
  private void a(int paramInt1, int paramInt2, View paramView)
  {
    if (paramView != null)
    {
      int i1 = getPositionForView(this.D);
      int i2 = getPositionForView(paramView);
      if (!((ReadInJoyNinePicDeliverDynamicGridView.BaseDynamicGridAdapter)getAdapter()).b().get(i2).equals(""))
      {
        paramView = getAdapterInterface();
        if ((i2 != -1) && (paramView.a(i1)) && (paramView.a(i2)))
        {
          a(i1, i2);
          this.g = this.h;
          this.f = this.i;
          if ((g()) && (c())) {
            paramView = new ReadInJoyNinePicDeliverDynamicGridView.KitKatSwitchCellAnimator(this, paramInt2, paramInt1);
          } else if (c()) {
            paramView = new ReadInJoyNinePicDeliverDynamicGridView.PreHoneycombCellAnimator(this, paramInt2, paramInt1);
          } else {
            paramView = new ReadInJoyNinePicDeliverDynamicGridView.LSwitchCellAnimator(this, paramInt2, paramInt1);
          }
          c(this.l);
          paramView.a(i1, i2);
          return;
        }
        c(this.l);
      }
    }
  }
  
  public static void a(List paramList, int paramInt1, int paramInt2)
  {
    paramList.add(paramInt2, paramList.remove(paramInt1));
  }
  
  private boolean a(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y > paramPoint2.y) && (paramPoint1.x < paramPoint2.x);
  }
  
  public static float b(View paramView)
  {
    return Math.abs((paramView.getBottom() - paramView.getTop()) / 2);
  }
  
  private void b(int paramInt)
  {
    this.d = 0;
    this.e = 0;
    Object localObject = getChildAt(paramInt - getFirstVisiblePosition());
    if (localObject != null)
    {
      this.l = getAdapter().getItemId(paramInt);
      ReadInJoyNinePicDeliverDynamicGridView.OnSelectedItemBitmapCreationListener localOnSelectedItemBitmapCreationListener = this.C;
      if (localOnSelectedItemBitmapCreationListener != null) {
        localOnSelectedItemBitmapCreationListener.a((View)localObject, paramInt, this.l);
      }
      this.a = c((View)localObject);
      localOnSelectedItemBitmapCreationListener = this.C;
      if (localOnSelectedItemBitmapCreationListener != null) {
        localOnSelectedItemBitmapCreationListener.b((View)localObject, paramInt, this.l);
      }
      if (g()) {
        ((View)localObject).setVisibility(4);
      }
      this.m = true;
      c(this.l);
      localObject = this.y;
      if (localObject != null) {
        ((ReadInJoyNinePicDeliverDynamicGridView.OnDragListener)localObject).a(paramInt);
      }
    }
  }
  
  @TargetApi(11)
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    LinkedList localLinkedList = new LinkedList();
    if (i1 != 0)
    {
      i1 = Math.min(paramInt1, paramInt2);
      while (i1 < Math.max(paramInt1, paramInt2))
      {
        localObject = b(c(i1));
        i1 += 1;
        if (i1 % getColumnCount() == 0) {
          localLinkedList.add(a((View)localObject, -((View)localObject).getWidth() * (getColumnCount() - 1), 0.0F, ((View)localObject).getHeight(), 0.0F));
        } else {
          localLinkedList.add(a((View)localObject, ((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
        }
      }
    }
    int i1 = Math.max(paramInt1, paramInt2);
    while (i1 > Math.min(paramInt1, paramInt2))
    {
      localObject = b(c(i1));
      if ((getColumnCount() + i1) % getColumnCount() == 0) {
        localLinkedList.add(a((View)localObject, ((View)localObject).getWidth() * (getColumnCount() - 1), 0.0F, -((View)localObject).getHeight(), 0.0F));
      } else {
        localLinkedList.add(a((View)localObject, -((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
      }
      i1 -= 1;
    }
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(localLinkedList);
    ((AnimatorSet)localObject).setDuration(300L);
    ((AnimatorSet)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((AnimatorSet)localObject).addListener(new ReadInJoyNinePicDeliverDynamicGridView.5(this));
    ((AnimatorSet)localObject).start();
  }
  
  private boolean b(int paramInt1, int paramInt2, Point paramPoint1, View paramView, Point paramPoint2)
  {
    return ((d(paramPoint2, paramPoint1)) && (paramInt1 < paramView.getBottom()) && (paramInt2 > paramView.getLeft())) || ((c(paramPoint2, paramPoint1)) && (paramInt1 < paramView.getBottom()) && (paramInt2 < paramView.getRight())) || ((b(paramPoint2, paramPoint1)) && (paramInt1 > paramView.getTop()) && (paramInt2 > paramView.getLeft())) || ((a(paramPoint2, paramPoint1)) && (paramInt1 > paramView.getTop()) && (paramInt2 < paramView.getRight()));
  }
  
  private boolean b(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y > paramPoint2.y) && (paramPoint1.x > paramPoint2.x);
  }
  
  private long c(int paramInt)
  {
    return getAdapter().getItemId(paramInt);
  }
  
  private BitmapDrawable c(View paramView)
  {
    int i1 = ((int)(paramView.getWidth() * 1.1F) + 0) / 2;
    int i2 = ((int)(paramView.getHeight() * 1.1F) + 0) / 2;
    int i3 = (paramView.getRight() + paramView.getLeft()) / 2;
    int i4 = (paramView.getBottom() + paramView.getTop()) / 2;
    paramView = a(paramView, 1.1F, 0);
    paramView = new BitmapDrawable(getResources(), paramView);
    this.c = new Rect(i3 - i1, i4 - i2, i3 + i1, i4 + i2);
    this.b = new Rect(this.c);
    paramView.setBounds(this.b);
    return paramView;
  }
  
  private void c(long paramLong)
  {
    this.k.clear();
    int i2 = a(paramLong);
    int i1 = getFirstVisiblePosition();
    while (i1 <= getLastVisiblePosition())
    {
      if ((i2 != i1) && (getAdapterInterface().a(i1))) {
        this.k.add(Long.valueOf(c(i1)));
      }
      i1 += 1;
    }
  }
  
  public static boolean c()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private boolean c(int paramInt1, int paramInt2, Point paramPoint1, View paramView, Point paramPoint2)
  {
    return ((e(paramPoint2, paramPoint1)) && (paramInt1 < paramView.getBottom() - this.j)) || ((f(paramPoint2, paramPoint1)) && (paramInt1 > paramView.getTop() + this.j)) || ((g(paramPoint2, paramPoint1)) && (paramInt2 > paramView.getLeft() + this.j)) || ((h(paramPoint2, paramPoint1)) && (paramInt2 < paramView.getRight() - this.j));
  }
  
  private boolean c(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y < paramPoint2.y) && (paramPoint1.x < paramPoint2.x);
  }
  
  private void d()
  {
    this.o = a(this.b);
  }
  
  @TargetApi(11)
  private void d(View paramView)
  {
    Object localObject = new ReadInJoyNinePicDeliverDynamicGridView.2(this);
    localObject = ObjectAnimator.ofObject(this.a, "bounds", (TypeEvaluator)localObject, new Object[] { this.b });
    ((ObjectAnimator)localObject).addUpdateListener(new ReadInJoyNinePicDeliverDynamicGridView.3(this));
    ((ObjectAnimator)localObject).addListener(new ReadInJoyNinePicDeliverDynamicGridView.4(this, paramView));
    ((ObjectAnimator)localObject).start();
  }
  
  private boolean d(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y < paramPoint2.y) && (paramPoint1.x > paramPoint2.x);
  }
  
  private void e()
  {
    View localView = b(this.l);
    if ((localView != null) && ((this.m) || (this.q)))
    {
      this.m = false;
      this.q = false;
      this.o = false;
      this.n = -1;
      if (this.r != 0)
      {
        this.q = true;
        return;
      }
      this.b.offsetTo(localView.getLeft(), localView.getTop());
      if (Build.VERSION.SDK_INT > 11)
      {
        d(localView);
        return;
      }
      this.a.setBounds(this.b);
      invalidate();
      e(localView);
      return;
    }
    h();
  }
  
  private void e(View paramView)
  {
    this.k.clear();
    this.l = -1L;
    paramView.setVisibility(0);
    this.a = null;
    int i1 = 0;
    while (i1 < getLastVisiblePosition() - getFirstVisiblePosition())
    {
      paramView = getChildAt(i1);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      i1 += 1;
    }
    invalidate();
  }
  
  private boolean e(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y < paramPoint2.y) && (paramPoint1.x == paramPoint2.x);
  }
  
  private Point f(View paramView)
  {
    int i1 = getPositionForView(paramView);
    int i2 = getColumnCount();
    return new Point(i1 % i2, i1 / i2);
  }
  
  private void f()
  {
    boolean bool;
    if ((!this.t) && (!this.u)) {
      bool = true;
    } else {
      bool = false;
    }
    setEnabled(bool);
  }
  
  private boolean f(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y > paramPoint2.y) && (paramPoint1.x == paramPoint2.x);
  }
  
  private boolean g()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private boolean g(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y == paramPoint2.y) && (paramPoint1.x > paramPoint2.x);
  }
  
  private ReadInJoyNinePicDeliverDynamicGridView.DynamicGridAdapterInterface getAdapterInterface()
  {
    return (ReadInJoyNinePicDeliverDynamicGridView.DynamicGridAdapterInterface)getAdapter();
  }
  
  private int getColumnCount()
  {
    return getAdapterInterface().a();
  }
  
  private void h()
  {
    View localView = b(this.l);
    if (this.m) {
      e(localView);
    }
    this.m = false;
    this.o = false;
    this.n = -1;
  }
  
  private boolean h(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y == paramPoint2.y) && (paramPoint1.x < paramPoint2.x);
  }
  
  private void i()
  {
    int i1 = this.h - this.g;
    int i2 = this.i - this.f;
    int i3 = this.c.centerY();
    int i4 = this.d;
    int i5 = this.c.centerX();
    int i6 = this.e;
    this.D = b(this.l);
    Point localPoint = f(this.D);
    Iterator localIterator = this.k.iterator();
    Object localObject = null;
    float f1 = 0.0F;
    float f2 = 0.0F;
    while (localIterator.hasNext())
    {
      View localView = b(((Long)localIterator.next()).longValue());
      if ((localView != null) && (a(i3 + i4 + i1, i5 + i6 + i2, localPoint, localView, f(localView))))
      {
        float f4 = Math.abs(a(localView) - a(this.D));
        float f3 = Math.abs(b(localView) - b(this.D));
        if ((f4 >= f1) && (f3 >= f2))
        {
          f1 = f4;
          f2 = f3;
          localObject = localView;
        }
      }
    }
    a(i1, i2, localObject);
  }
  
  public int a(long paramLong)
  {
    View localView = b(paramLong);
    if (localView == null) {
      return -1;
    }
    return getPositionForView(localView);
  }
  
  public void a()
  {
    this.s = false;
    requestDisallowInterceptTouchEvent(false);
    ReadInJoyNinePicDeliverDynamicGridView.OnEditModeChangeListener localOnEditModeChangeListener = this.z;
    if (localOnEditModeChangeListener != null) {
      localOnEditModeChangeListener.a(false);
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.v) {
      return;
    }
    requestDisallowInterceptTouchEvent(true);
    if (paramInt != -1) {
      b(paramInt);
    }
    this.s = true;
    ReadInJoyNinePicDeliverDynamicGridView.OnEditModeChangeListener localOnEditModeChangeListener = this.z;
    if (localOnEditModeChangeListener != null) {
      localOnEditModeChangeListener.a(true);
    }
  }
  
  public void a(Context paramContext)
  {
    super.setOnScrollListener(this.F);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.p = ((int)(paramContext.density * 8.0F + 0.5F));
    this.j = ((int)(paramContext.density * 16.0F + 0.5F));
  }
  
  @VisibleForTesting
  boolean a(int paramInt1, int paramInt2, Point paramPoint1, View paramView, Point paramPoint2)
  {
    return (b(paramInt1, paramInt2, paramPoint1, paramView, paramPoint2)) || (c(paramInt1, paramInt2, paramPoint1, paramView, paramPoint2));
  }
  
  public boolean a(Rect paramRect)
  {
    int i1 = computeVerticalScrollOffset();
    int i2 = getHeight();
    int i3 = computeVerticalScrollExtent();
    int i4 = computeVerticalScrollRange();
    int i5 = paramRect.top;
    int i6 = paramRect.height();
    if ((i5 <= 0) && (i1 > 0))
    {
      smoothScrollBy(-this.p, 0);
      return true;
    }
    if ((i5 + i6 >= i2) && (i1 + i3 < i4))
    {
      smoothScrollBy(this.p, 0);
      return true;
    }
    return false;
  }
  
  public View b(long paramLong)
  {
    int i2 = getFirstVisiblePosition();
    ListAdapter localListAdapter = getAdapter();
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localListAdapter.getItemId(i2 + i1) == paramLong) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  public boolean b()
  {
    return this.s;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    BitmapDrawable localBitmapDrawable = this.a;
    if (localBitmapDrawable != null) {
      localBitmapDrawable.draw(paramCanvas);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.E)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(16777215, -2147483648));
      getLayoutParams().height = getMeasuredHeight();
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      ReadInJoyNinePicDeliverDynamicGridView.OnDropListener localOnDropListener;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if ((i1 == 6) && (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.n)) {
              e();
            }
          }
          else
          {
            h();
            if (this.a != null)
            {
              localOnDropListener = this.x;
              if (localOnDropListener != null) {
                localOnDropListener.a();
              }
            }
          }
        }
        else
        {
          i1 = this.n;
          if (i1 != -1)
          {
            i1 = paramMotionEvent.findPointerIndex(i1);
            this.h = ((int)paramMotionEvent.getY(i1));
            this.i = ((int)paramMotionEvent.getX(i1));
            i1 = this.h;
            int i2 = this.g;
            int i3 = this.i;
            int i4 = this.f;
            if (this.m)
            {
              this.b.offsetTo(this.c.left + (i3 - i4) + this.e, this.c.top + (i1 - i2) + this.d);
              this.a.setBounds(this.b);
              invalidate();
              i();
              this.o = false;
              d();
              return false;
            }
          }
        }
      }
      else
      {
        e();
        if (this.a != null)
        {
          localOnDropListener = this.x;
          if (localOnDropListener != null) {
            localOnDropListener.a();
          }
        }
      }
    }
    else
    {
      this.f = ((int)paramMotionEvent.getX());
      this.g = ((int)paramMotionEvent.getY());
      this.n = paramMotionEvent.getPointerId(0);
      if ((this.s) && (isEnabled()))
      {
        layoutChildren();
        b(pointToPosition(this.f, this.g));
      }
      else if (!isEnabled())
      {
        return false;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
  }
  
  public void setEditModeEnabled(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setExpendable(boolean paramBoolean)
  {
    this.E = paramBoolean;
  }
  
  public void setOnDragListener(ReadInJoyNinePicDeliverDynamicGridView.OnDragListener paramOnDragListener)
  {
    this.y = paramOnDragListener;
  }
  
  public void setOnDropListener(ReadInJoyNinePicDeliverDynamicGridView.OnDropListener paramOnDropListener)
  {
    this.x = paramOnDropListener;
  }
  
  public void setOnEditModeChangeListener(ReadInJoyNinePicDeliverDynamicGridView.OnEditModeChangeListener paramOnEditModeChangeListener)
  {
    this.z = paramOnEditModeChangeListener;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.A = paramOnItemClickListener;
    super.setOnItemClickListener(this.B);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.w = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(ReadInJoyNinePicDeliverDynamicGridView.OnSelectedItemBitmapCreationListener paramOnSelectedItemBitmapCreationListener)
  {
    this.C = paramOnSelectedItemBitmapCreationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView
 * JD-Core Version:    0.7.0.1
 */