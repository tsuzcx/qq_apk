package com.tencent.widget.itemtouchhelper;

import amet;
import ameu;
import amev;
import amew;
import amex;
import amfa;
import amfb;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnChildAttachStateChangeListener
{
  public float a;
  public int a;
  private long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RecyclerView.ChildDrawingOrderCallback jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ChildDrawingOrderCallback;
  private final RecyclerView.OnItemTouchListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnItemTouchListener = new ameu(this);
  public RecyclerView.ViewHolder a;
  public RecyclerView a;
  public VelocityTracker a;
  public View a;
  public GestureDetectorCompat a;
  public ItemTouchHelper.Callback a;
  public final Runnable a;
  public final List a;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  public float b;
  int jdField_b_of_type_Int = 0;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  float jdField_c_of_type_Float;
  public int c;
  private List jdField_c_of_type_JavaUtilList;
  float jdField_d_of_type_Float;
  public int d;
  private List jdField_d_of_type_JavaUtilList;
  public float e;
  private int e;
  public float f;
  float g;
  float h;
  
  public ItemTouchHelper(ItemTouchHelper.Callback paramCallback)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new amet(this);
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback = paramCallback;
  }
  
  private int a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.jdField_b_of_type_Int == 2) {}
    int j;
    int i;
    do
    {
      do
      {
        do
        {
          return 0;
          j = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramViewHolder);
          i = (this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.d(j, ViewCompat.getLayoutDirection(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView)) & 0xFF00) >> 8;
        } while (i == 0);
        j = (j & 0xFF00) >> 8;
        if (Math.abs(this.jdField_e_of_type_Float) <= Math.abs(this.f)) {
          break;
        }
        k = a(paramViewHolder, i);
        if (k > 0)
        {
          if ((j & k) == 0) {
            return ItemTouchHelper.Callback.a(k, ViewCompat.getLayoutDirection(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView));
          }
          return k;
        }
        i = b(paramViewHolder, i);
      } while (i <= 0);
      return i;
      int k = b(paramViewHolder, i);
      if (k > 0) {
        return k;
      }
      i = a(paramViewHolder, i);
    } while (i <= 0);
    if ((j & i) == 0) {
      return ItemTouchHelper.Callback.a(i, ViewCompat.getLayoutDirection(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView));
    }
    return i;
  }
  
  private int a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int j = 8;
    if ((paramInt & 0xC) != 0)
    {
      int i;
      if (this.jdField_e_of_type_Float > 0.0F)
      {
        i = 8;
        if ((this.jdField_a_of_type_AndroidViewVelocityTracker == null) || (this.jdField_a_of_type_Int <= -1)) {
          break label155;
        }
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.b(this.jdField_d_of_type_Float));
        f2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(this.jdField_a_of_type_Int);
        f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(this.jdField_a_of_type_Int);
        if (f2 <= 0.0F) {
          break label149;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (i != j) || (f2 < this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_c_of_type_Float)) || (f2 <= Math.abs(f1))) {
          break label155;
        }
        return j;
        i = 4;
        break;
        label149:
        j = 4;
      }
      label155:
      float f1 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth();
      float f2 = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.b(paramViewHolder);
      if (((paramInt & i) != 0) && (Math.abs(this.jdField_e_of_type_Float) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private RecyclerView.ViewHolder a(MotionEvent paramMotionEvent)
  {
    RecyclerView.LayoutManager localLayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
    if (this.jdField_a_of_type_Int == -1) {}
    do
    {
      float f3;
      float f1;
      do
      {
        return null;
        int i = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
        f3 = paramMotionEvent.getX(i);
        float f4 = this.jdField_a_of_type_Float;
        f1 = paramMotionEvent.getY(i);
        float f2 = this.jdField_b_of_type_Float;
        f3 = Math.abs(f3 - f4);
        f1 = Math.abs(f1 - f2);
      } while (((f3 < this.jdField_e_of_type_Int) && (f1 < this.jdField_e_of_type_Int)) || ((f3 > f1) && (localLayoutManager.canScrollHorizontally())) || ((f1 > f3) && (localLayoutManager.canScrollVertically())));
      paramMotionEvent = a(paramMotionEvent);
    } while (paramMotionEvent == null);
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(paramMotionEvent);
  }
  
  private List a(RecyclerView.ViewHolder paramViewHolder)
  {
    int i;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    label137:
    View localView;
    if (this.jdField_c_of_type_JavaUtilList == null)
    {
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
      this.jdField_d_of_type_JavaUtilList = new ArrayList();
      i = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a();
      m = Math.round(this.g + this.jdField_e_of_type_Float) - i;
      n = Math.round(this.h + this.f) - i;
      i1 = paramViewHolder.itemView.getWidth() + m + i * 2;
      i2 = paramViewHolder.itemView.getHeight() + n + i * 2;
      i3 = (m + i1) / 2;
      i4 = (n + i2) / 2;
      RecyclerView.LayoutManager localLayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      int i5 = localLayoutManager.getChildCount();
      i = 0;
      if (i >= i5) {
        break label403;
      }
      localView = localLayoutManager.getChildAt(i);
      if (localView != paramViewHolder.itemView) {
        break label188;
      }
    }
    for (;;)
    {
      i += 1;
      break label137;
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_d_of_type_JavaUtilList.clear();
      break;
      label188:
      if ((localView.getBottom() >= n) && (localView.getTop() <= i2) && (localView.getRight() >= m) && (localView.getLeft() <= i1))
      {
        RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(localView);
        if (this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, localViewHolder))
        {
          int j = Math.abs(i3 - (localView.getLeft() + localView.getRight()) / 2);
          int k = localView.getTop();
          k = Math.abs(i4 - (localView.getBottom() + k) / 2);
          int i6 = j * j + k * k;
          int i7 = this.jdField_c_of_type_JavaUtilList.size();
          k = 0;
          j = 0;
          while ((j < i7) && (i6 > ((Integer)this.jdField_d_of_type_JavaUtilList.get(j)).intValue()))
          {
            k += 1;
            j += 1;
          }
          this.jdField_c_of_type_JavaUtilList.add(k, localViewHolder);
          this.jdField_d_of_type_JavaUtilList.add(k, Integer.valueOf(i6));
        }
      }
    }
    label403:
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  private void a(float[] paramArrayOfFloat)
  {
    if ((this.jdField_c_of_type_Int & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.g + this.jdField_e_of_type_Float - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.getLeft());
    }
    while ((this.jdField_c_of_type_Int & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.h + this.f - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.getTop());
      return;
      paramArrayOfFloat[0] = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.getTranslationX();
    }
    paramArrayOfFloat[1] = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.getTranslationY();
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramView.getWidth() + paramFloat3) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramView.getHeight() + paramFloat4);
  }
  
  private int b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int j = 2;
    if ((paramInt & 0x3) != 0)
    {
      int i;
      if (this.f > 0.0F)
      {
        i = 2;
        if ((this.jdField_a_of_type_AndroidViewVelocityTracker == null) || (this.jdField_a_of_type_Int <= -1)) {
          break label152;
        }
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.b(this.jdField_d_of_type_Float));
        f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(this.jdField_a_of_type_Int);
        f2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(this.jdField_a_of_type_Int);
        if (f2 <= 0.0F) {
          break label146;
        }
      }
      for (;;)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (j != i) || (f2 < this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_c_of_type_Float)) || (f2 <= Math.abs(f1))) {
          break label152;
        }
        return j;
        i = 1;
        break;
        label146:
        j = 1;
      }
      label152:
      float f1 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight();
      float f2 = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.b(paramViewHolder);
      if (((paramInt & i) != 0) && (Math.abs(this.f) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private void b()
  {
    this.jdField_e_of_type_Int = ViewConfiguration.get(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext()).getScaledTouchSlop();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnItemTouchListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnChildAttachStateChangeListener(this);
    d();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeItemDecoration(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeOnItemTouchListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnItemTouchListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeOnChildAttachStateChangeListener(this);
    int i = this.jdField_b_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      amfb localamfb = (amfb)this.jdField_b_of_type_JavaUtilList.get(0);
      this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, localamfb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
      i -= 1;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_d_of_type_Int = -1;
    e();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetItemtouchhelperGestureDetectorCompat != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperGestureDetectorCompat = new GestureDetectorCompat(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), new amfa(this));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void f()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return;
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ChildDrawingOrderCallback == null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ChildDrawingOrderCallback = new amex(this);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setChildDrawingOrderCallback(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ChildDrawingOrderCallback);
  }
  
  public int a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    int i = this.jdField_b_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      amfb localamfb = (amfb)this.jdField_b_of_type_JavaUtilList.get(i);
      if (localamfb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == paramViewHolder)
      {
        localamfb.jdField_b_of_type_Boolean |= paramBoolean;
        if (!localamfb.jdField_c_of_type_Boolean) {
          localamfb.b();
        }
        this.jdField_b_of_type_JavaUtilList.remove(i);
        return localamfb.jdField_c_of_type_Int;
      }
      i -= 1;
    }
    return 0;
  }
  
  public amfb a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramMotionEvent = null;
      return paramMotionEvent;
    }
    View localView = a(paramMotionEvent);
    int i = this.jdField_b_of_type_JavaUtilList.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label74;
      }
      amfb localamfb = (amfb)this.jdField_b_of_type_JavaUtilList.get(i);
      paramMotionEvent = localamfb;
      if (localamfb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView == localView) {
        break;
      }
      i -= 1;
    }
    label74:
    return null;
  }
  
  public View a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null)
    {
      paramMotionEvent = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView;
      if (a(paramMotionEvent, f1, f2, this.g + this.jdField_e_of_type_Float, this.h + this.f)) {
        return paramMotionEvent;
      }
    }
    int i = this.jdField_b_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (amfb)this.jdField_b_of_type_JavaUtilList.get(i);
      View localView = paramMotionEvent.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView;
      if (a(localView, f1, f2, paramMotionEvent.jdField_e_of_type_Float, paramMotionEvent.f)) {
        return localView;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findChildViewUnder(f1, f2);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
  }
  
  public void a(amfb paramamfb, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new amew(this, paramamfb, paramInt));
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.isLayoutRequested()) {}
    label10:
    int i;
    int j;
    Object localObject;
    int k;
    int m;
    do
    {
      do
      {
        float f1;
        do
        {
          break label10;
          do
          {
            return;
          } while (this.jdField_b_of_type_Int != 2);
          f1 = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(paramViewHolder);
          i = (int)(this.g + this.jdField_e_of_type_Float);
          j = (int)(this.h + this.f);
        } while ((Math.abs(j - paramViewHolder.itemView.getTop()) < paramViewHolder.itemView.getHeight() * f1) && (Math.abs(i - paramViewHolder.itemView.getLeft()) < f1 * paramViewHolder.itemView.getWidth()));
        localObject = a(paramViewHolder);
      } while (((List)localObject).size() == 0);
      localObject = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(paramViewHolder, (List)localObject, i, j);
      if (localObject == null)
      {
        this.jdField_c_of_type_JavaUtilList.clear();
        this.jdField_d_of_type_JavaUtilList.clear();
        return;
      }
      k = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
      m = paramViewHolder.getAdapterPosition();
    } while (!this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramViewHolder, (RecyclerView.ViewHolder)localObject));
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramViewHolder, m, (RecyclerView.ViewHolder)localObject, k, i, j);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder) && (paramInt == this.jdField_b_of_type_Int)) {
      return;
    }
    this.jdField_a_of_type_Long = -9223372036854775808L;
    int k = this.jdField_b_of_type_Int;
    a(paramViewHolder, true);
    this.jdField_b_of_type_Int = paramInt;
    if (paramInt == 2)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewHolder.itemView;
      f();
    }
    int i = 0;
    int j = 0;
    Object localObject;
    float f1;
    float f2;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
      if (((RecyclerView.ViewHolder)localObject).itemView.getParent() == null) {
        break label510;
      }
      if (k == 2)
      {
        j = 0;
        e();
      }
    }
    else
    {
      switch (j)
      {
      default: 
        f1 = 0.0F;
        f2 = 0.0F;
        label169:
        if (k == 2)
        {
          i = 8;
          label179:
          a(this.jdField_a_of_type_ArrayOfFloat);
          float f3 = this.jdField_a_of_type_ArrayOfFloat[0];
          float f4 = this.jdField_a_of_type_ArrayOfFloat[1];
          localObject = new amev(this, (RecyclerView.ViewHolder)localObject, i, k, f3, f4, f1, f2, j, (RecyclerView.ViewHolder)localObject);
          ((amfb)localObject).a(this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, i, f1 - f3, f2 - f4));
          this.jdField_b_of_type_JavaUtilList.add(localObject);
          ((amfb)localObject).a();
          i = 1;
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
          if (paramViewHolder != null)
          {
            this.jdField_c_of_type_Int = ((this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramViewHolder) & (1 << paramInt * 8 + 8) - 1) >> this.jdField_b_of_type_Int * 8);
            this.g = paramViewHolder.itemView.getLeft();
            this.h = paramViewHolder.itemView.getTop();
            this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
            if (paramInt == 2) {
              this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.performHapticFeedback(0);
            }
          }
          paramViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getParent();
          if (paramViewHolder != null) {
            if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
              break label539;
            }
          }
        }
        label277:
        break;
      }
    }
    label539:
    for (boolean bool = true;; bool = false)
    {
      paramViewHolder.requestDisallowInterceptTouchEvent(bool);
      if (i == 0) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
      }
      this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.invalidate();
      return;
      j = a((RecyclerView.ViewHolder)localObject);
      break;
      f2 = 0.0F;
      f1 = Math.signum(this.jdField_e_of_type_Float) * this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth();
      break label169;
      f1 = 0.0F;
      f2 = Math.signum(this.f) * this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight();
      break label169;
      if (j > 0)
      {
        i = 2;
        break label179;
      }
      i = 4;
      break label179;
      label510:
      a(((RecyclerView.ViewHolder)localObject).itemView);
      this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, (RecyclerView.ViewHolder)localObject);
      i = j;
      break label277;
    }
  }
  
  public void a(@Nullable RecyclerView paramRecyclerView)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == paramRecyclerView) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
        c();
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    } while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null);
    paramRecyclerView = paramRecyclerView.getResources();
    this.jdField_c_of_type_Float = paramRecyclerView.getDimension(2131559509);
    this.jdField_d_of_type_Float = paramRecyclerView.getDimension(2131559510);
    b();
  }
  
  public void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    this.jdField_e_of_type_Float = (f1 - this.jdField_a_of_type_Float);
    this.f = (f2 - this.jdField_b_of_type_Float);
    if ((paramInt1 & 0x4) == 0) {
      this.jdField_e_of_type_Float = Math.max(0.0F, this.jdField_e_of_type_Float);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.jdField_e_of_type_Float = Math.min(0.0F, this.jdField_e_of_type_Float);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.f = Math.max(0.0F, this.f);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.f = Math.min(0.0F, this.f);
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      this.jdField_a_of_type_AndroidViewView = null;
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ChildDrawingOrderCallback != null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  public boolean a()
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      if (!((amfb)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_c_of_type_Boolean) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) || (paramInt1 != 2) || (this.jdField_b_of_type_Int == 2) || (!this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a())) {}
    RecyclerView.ViewHolder localViewHolder;
    float f1;
    float f2;
    do
    {
      float f3;
      float f4;
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getScrollState() == 1);
            localViewHolder = a(paramMotionEvent);
          } while (localViewHolder == null);
          paramInt1 = (this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, localViewHolder) & 0xFF00) >> 8;
        } while (paramInt1 == 0);
        f1 = paramMotionEvent.getX(paramInt2);
        f2 = paramMotionEvent.getY(paramInt2);
        f1 -= this.jdField_a_of_type_Float;
        f2 -= this.jdField_b_of_type_Float;
        f3 = Math.abs(f1);
        f4 = Math.abs(f2);
      } while ((f3 < this.jdField_e_of_type_Int) && (f4 < this.jdField_e_of_type_Int));
      if (f3 <= f4) {
        break;
      }
    } while (((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) || ((f1 > 0.0F) && ((paramInt1 & 0x8) == 0)));
    do
    {
      this.f = 0.0F;
      this.jdField_e_of_type_Float = 0.0F;
      this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
      a(localViewHolder, 1);
      return true;
      if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
        break;
      }
    } while ((f2 <= 0.0F) || ((paramInt1 & 0x2) != 0));
    return false;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null)
    {
      this.jdField_a_of_type_Long = -9223372036854775808L;
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l1;
    int j;
    int i;
    label128:
    int k;
    if (this.jdField_a_of_type_Long == -9223372036854775808L)
    {
      l1 = 0L;
      RecyclerView.LayoutManager localLayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
      if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      }
      localLayoutManager.calculateItemDecorationsForChild(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView, this.jdField_a_of_type_AndroidGraphicsRect);
      if (!localLayoutManager.canScrollHorizontally()) {
        break label350;
      }
      j = (int)(this.g + this.jdField_e_of_type_Float);
      i = j - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getPaddingLeft();
      if ((this.jdField_e_of_type_Float >= 0.0F) || (i >= 0)) {
        break label298;
      }
      if (!localLayoutManager.canScrollVertically()) {
        break label407;
      }
      k = (int)(this.h + this.f);
      j = k - this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getPaddingTop();
      if ((this.f >= 0.0F) || (j >= 0)) {
        break label355;
      }
      label178:
      if (i == 0) {
        break label424;
      }
      i = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.getWidth(), i, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth(), l1);
    }
    label407:
    label424:
    for (;;)
    {
      if (j != 0) {
        j = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.getHeight(), j, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight(), l1);
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (this.jdField_a_of_type_Long == -9223372036854775808L) {
            this.jdField_a_of_type_Long = l2;
          }
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollBy(i, j);
          return true;
          l1 = l2 - this.jdField_a_of_type_Long;
          break;
          label298:
          if (this.jdField_e_of_type_Float > 0.0F)
          {
            j = j + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.getWidth() + this.jdField_a_of_type_AndroidGraphicsRect.right - (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth() - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getPaddingRight());
            i = j;
            if (j > 0) {
              break label128;
            }
          }
          label350:
          i = 0;
          break label128;
          label355:
          if (this.f > 0.0F)
          {
            k = k + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView.getHeight() + this.jdField_a_of_type_AndroidGraphicsRect.bottom - (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getPaddingBottom());
            j = k;
            if (k > 0) {
              break label178;
            }
          }
          j = 0;
          break label178;
        }
        this.jdField_a_of_type_Long = -9223372036854775808L;
        return false;
      }
    }
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.setEmpty();
  }
  
  public void onChildViewAttachedToWindow(View paramView) {}
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    a(paramView);
    paramView = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(paramView);
    if (paramView == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) && (paramView == this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder))
      {
        a(null, 0);
        return;
      }
      a(paramView, false);
    } while (!this.jdField_a_of_type_JavaUtilList.remove(paramView.itemView));
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramView);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    float f2 = 0.0F;
    this.jdField_d_of_type_Int = -1;
    float f1;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null)
    {
      a(this.jdField_a_of_type_ArrayOfFloat);
      f1 = this.jdField_a_of_type_ArrayOfFloat[0];
      f2 = this.jdField_a_of_type_ArrayOfFloat[1];
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(paramCanvas, paramRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_Int, f1, f2);
      return;
      f1 = 0.0F;
    }
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    float f2 = 0.0F;
    float f1;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null)
    {
      a(this.jdField_a_of_type_ArrayOfFloat);
      f1 = this.jdField_a_of_type_ArrayOfFloat[0];
      f2 = this.jdField_a_of_type_ArrayOfFloat[1];
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.b(paramCanvas, paramRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_Int, f1, f2);
      return;
      f1 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper
 * JD-Core Version:    0.7.0.1
 */