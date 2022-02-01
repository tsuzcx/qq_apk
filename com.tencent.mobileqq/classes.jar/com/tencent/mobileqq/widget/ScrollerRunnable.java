package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class ScrollerRunnable
  implements Runnable
{
  private static long b;
  protected int a;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  private TroopAioTips jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
  protected ListView a;
  protected Runnable a;
  HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap;
  protected MqqHandler a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  protected boolean c;
  protected int d;
  protected boolean d;
  protected final int e;
  private boolean e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  int j;
  protected int k;
  protected int l;
  private int m;
  
  public ScrollerRunnable(ListView paramListView)
  {
    boolean bool = false;
    this.f = 0;
    this.jdField_a_of_type_Boolean = true;
    this.m = 0;
    this.jdField_e_of_type_Boolean = false;
    this.g = -1;
    this.h = 0;
    this.j = 0;
    this.jdField_b_of_type_Boolean = false;
    this.k = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_e_of_type_Int = ViewConfiguration.get(this.jdField_a_of_type_ComTencentWidgetListView.getContext()).getScaledFadingEdgeLength();
    if (DeviceInfoUtil.a() / 1048576L > 512L) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    double d1 = this.jdField_a_of_type_ComTencentWidgetListView.getContext().getResources().getDimension(2131299168);
    Double.isNaN(d1);
    this.l = ((int)(d1 + 0.5D));
  }
  
  private boolean a()
  {
    TroopAioTips localTroopAioTips = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
    if (localTroopAioTips != null) {
      return localTroopAioTips.a(this.k);
    }
    return false;
  }
  
  public int a()
  {
    return this.k;
  }
  
  public void a()
  {
    this.l = 0;
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resetExtraScrollIfNeeded==>extraType:");
        localStringBuilder.append(paramInt);
        QLog.d("ScrollerRunnable", 2, localStringBuilder.toString());
      }
      if ((paramInt == 0) && (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.f = 0;
        return;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        this.f -= ((Integer)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt))).intValue();
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt1));
      if (bool) {
        return;
      }
      this.f += paramInt2;
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addExtraScroll==>extraType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" |extraDetal:");
        localStringBuilder.append(paramInt2);
        QLog.d("ScrollerRunnable", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, int paramInt4)
  {
    this.k = paramInt1;
    a(paramInt2, paramInt3, paramRunnable, paramInt4, false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, MqqHandler paramMqqHandler, int paramInt4)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    a(paramInt1, paramInt2, paramInt3, paramRunnable, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, Runnable paramRunnable, int paramInt3, boolean paramBoolean)
  {
    b();
    this.g = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    if (QLog.isColorLevel()) {
      QLog.d("ScrollerRunnable", 2, new Object[] { "start, from:", Integer.valueOf(paramInt3), "aniPos:", Integer.valueOf(paramInt2), "mTargetPos:", Integer.valueOf(this.jdField_b_of_type_Int) });
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.i = paramInt3;
    this.jdField_a_of_type_ComTencentWidgetListView.post(this);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.g = paramInt;
    this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(new ScrollerRunnable.1(this), paramLong);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(@Nullable TroopAioTips paramTroopAioTips)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = paramTroopAioTips;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, 0, null, paramInt2, false);
  }
  
  protected void c()
  {
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      localRunnable.run();
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    this.jdField_a_of_type_ComTencentWidgetListView.post(new ScrollerRunnable.2(this));
  }
  
  public void d()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      localView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  protected void e()
  {
    long l1 = System.currentTimeMillis();
    if (System.currentTimeMillis() - jdField_b_of_type_Long < 1000L) {
      return;
    }
    if (this.g != -1) {
      jdField_b_of_type_Long = l1;
    }
    int i1 = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
    if (this.g < i1) {
      return;
    }
    if ((this.k == 5) && (this.jdField_a_of_type_Long > 0L))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
      if ((localObject instanceof ChatAdapter1))
      {
        localObject = ((ChatAdapter1)localObject).a();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int i2 = ((List)localObject).size();
          n = 0;
          while (n < i2)
          {
            if (((ChatMessage)((List)localObject).get(n)).uniseq == this.jdField_a_of_type_Long)
            {
              this.g = n;
              break;
            }
            n += 1;
          }
        }
      }
    }
    int n = this.g;
    if (n == -1) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(n - i1);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FlushMessageItem:");
        localStringBuilder.append(localObject.hashCode());
        localStringBuilder.append(",");
        localStringBuilder.append(((View)localObject).getParent());
        QLog.i("ScrollerRunnable", 2, localStringBuilder.toString());
      }
      if (this.h == 1)
      {
        ((View)localObject).post(new ScrollerRunnable.3(this, (View)localObject));
        return;
      }
      ((View)localObject).post(new ScrollerRunnable.4(this, (View)localObject));
    }
  }
  
  public void run()
  {
    int n;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.j = 0;
      this.m = 0;
      if (this.jdField_c_of_type_Boolean) {
        n = Math.max(0, this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount());
      } else {
        n = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      }
      if (this.jdField_c_of_type_Boolean) {
        i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() + n - this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount();
      } else {
        i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() + n;
      }
      i1 -= 1;
      i2 = this.jdField_b_of_type_Int;
      if (i2 <= n)
      {
        n = n - i2 + 1;
        this.jdField_a_of_type_Int = 2;
      }
      else
      {
        if (i2 < i1) {
          break label173;
        }
        n = i2 - i1 + 1;
        this.jdField_a_of_type_Int = 1;
      }
      if (n > 0) {
        this.jdField_d_of_type_Int = (1000 / n);
      } else {
        this.jdField_d_of_type_Int = 1000;
      }
      this.jdField_c_of_type_Int = -1;
      break label185;
      label173:
      if (a()) {
        e();
      }
      return;
    }
    label185:
    int i2 = this.jdField_a_of_type_ComTencentWidgetListView.getHeight();
    if (this.jdField_c_of_type_Boolean) {
      n = Math.max(0, this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount());
    } else {
      n = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    }
    int i1 = this.jdField_a_of_type_Int;
    Object localObject;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      if ((this.jdField_e_of_type_Boolean) && (this.m > 4))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("jumpToTopDirect,listCount = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetListView.getCount());
          ((StringBuilder)localObject).append(" mTargetPos = ");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          QLog.d("ScrollerRunnable", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_b_of_type_Int + 1);
        this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(-this.l, this.jdField_d_of_type_Int);
        this.jdField_e_of_type_Boolean = false;
        c();
        return;
      }
      this.m += 1;
      if (n == this.jdField_c_of_type_Int)
      {
        n = this.j;
        if (n > 10)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_b_of_type_Int + 1);
          this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(-this.l, this.jdField_d_of_type_Int);
          c();
          return;
        }
        this.j = (n + 1);
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        return;
      }
      this.j = 0;
      i1 = this.jdField_b_of_type_Int;
      if (n <= i1)
      {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(i1 + 1);
        this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(-this.l, this.jdField_d_of_type_Int);
        c();
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
      if (localObject == null) {
        return;
      }
      i2 = ((View)localObject).getTop();
      if (n > this.jdField_b_of_type_Int) {
        i1 = this.jdField_e_of_type_Int;
      } else {
        i1 = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingTop() + this.f;
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(i2 - i1, this.jdField_d_of_type_Int);
      } else if (n > this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
      this.jdField_c_of_type_Int = n;
      if (n > this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      }
    }
    else
    {
      if (this.jdField_d_of_type_Boolean) {
        i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1 - this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount();
      } else {
        i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1;
      }
      int i3 = n + i1;
      if (i1 < 0) {
        return;
      }
      if (i3 == this.jdField_c_of_type_Int)
      {
        if (this.j > 10)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_b_of_type_Int + 1);
          if (i3 != this.jdField_b_of_type_Int) {
            this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(-this.l, this.jdField_d_of_type_Int);
          }
          c();
          n = this.f;
          if (n != 0)
          {
            this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(n, this.jdField_d_of_type_Int);
            a(0);
          }
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        this.j += 1;
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i1);
      int i4 = ((View)localObject).getHeight();
      int i5 = ((View)localObject).getTop();
      int i6 = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingBottom();
      if (i3 < this.jdField_a_of_type_ComTencentWidgetListView.getCount() - 1) {
        n = this.jdField_e_of_type_Int;
      } else {
        n = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingBottom();
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(i4 - (i2 - i6 - i5) + n, this.jdField_d_of_type_Int);
      } else if (i3 < this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(i1);
      }
      this.jdField_c_of_type_Int = i3;
      if (i3 < this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      }
      if (a()) {
        e();
      }
      n = this.jdField_b_of_type_Int;
      if (i3 >= n)
      {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(n + 1);
        if (i3 != this.jdField_b_of_type_Int) {
          this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(-this.l, this.jdField_d_of_type_Int);
        }
        c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable
 * JD-Core Version:    0.7.0.1
 */