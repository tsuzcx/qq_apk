package com.tencent.mobileqq.widget;

import acut;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import bbct;
import com.tencent.mobileqq.data.ChatMessage;
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
  private long jdField_a_of_type_Long = -1L;
  private View jdField_a_of_type_AndroidViewView;
  protected ListView a;
  protected Runnable a;
  HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public MqqHandler a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  protected boolean c;
  protected int d;
  protected boolean d;
  protected final int e;
  protected int f;
  protected int g = -1;
  protected int h;
  protected int i;
  int j = 0;
  public int k = -1;
  protected int l;
  
  public ScrollerRunnable(ListView paramListView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.e = ViewConfiguration.get(this.jdField_a_of_type_ComTencentWidgetListView.getContext()).getScaledFadingEdgeLength();
    if (bbct.d() / 1048576L > 512L) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.l = ((int)(this.jdField_a_of_type_ComTencentWidgetListView.getContext().getResources().getDimension(2131298865) + 0.5D));
      return;
      bool = false;
    }
  }
  
  public int a()
  {
    return this.k;
  }
  
  public void a()
  {
    this.l = 0;
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 110
    //   10: iconst_2
    //   11: new 112	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   18: ldc 115
    //   20: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: iload_1
    //   34: ifne +28 -> 62
    //   37: aload_0
    //   38: getfield 49	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   41: invokevirtual 132	java/util/HashMap:isEmpty	()Z
    //   44: ifne +18 -> 62
    //   47: aload_0
    //   48: getfield 49	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   51: invokevirtual 135	java/util/HashMap:clear	()V
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 137	com/tencent/mobileqq/widget/ScrollerRunnable:f	I
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_0
    //   63: getfield 49	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: iload_1
    //   67: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokevirtual 147	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   73: ifeq -14 -> 59
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 137	com/tencent/mobileqq/widget/ScrollerRunnable:f	I
    //   81: aload_0
    //   82: getfield 49	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   85: iload_1
    //   86: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokevirtual 151	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 139	java/lang/Integer
    //   95: invokevirtual 154	java/lang/Integer:intValue	()I
    //   98: isub
    //   99: putfield 137	com/tencent/mobileqq/widget/ScrollerRunnable:f	I
    //   102: goto -43 -> 59
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	ScrollerRunnable
    //   0	110	1	paramInt	int
    //   105	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	105	finally
    //   37	59	105	finally
    //   62	102	105	finally
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: iload_1
    //   7: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokevirtual 147	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 137	com/tencent/mobileqq/widget/ScrollerRunnable:f	I
    //   26: iload_2
    //   27: iadd
    //   28: putfield 137	com/tencent/mobileqq/widget/ScrollerRunnable:f	I
    //   31: aload_0
    //   32: getfield 49	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   35: iload_1
    //   36: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: iload_2
    //   40: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq -32 -> 18
    //   53: ldc 110
    //   55: iconst_2
    //   56: new 112	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   63: ldc 161
    //   65: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_1
    //   69: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 163
    //   74: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: iload_2
    //   78: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: goto -69 -> 18
    //   90: astore 4
    //   92: aload_0
    //   93: monitorexit
    //   94: aload 4
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	ScrollerRunnable
    //   0	97	1	paramInt1	int
    //   0	97	2	paramInt2	int
    //   13	2	3	bool	boolean
    //   90	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	90	finally
    //   21	87	90	finally
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, int paramInt4)
  {
    this.k = paramInt1;
    a(paramInt2, paramInt3, paramRunnable, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, MqqHandler paramMqqHandler, int paramInt4)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    a(paramInt1, paramInt2, paramInt3, paramRunnable, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, Runnable paramRunnable, int paramInt3)
  {
    b();
    this.g = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    if (QLog.isColorLevel()) {
      QLog.d("ScrollerRunnable", 2, new Object[] { "start, from:", Integer.valueOf(paramInt3), "aniPos:", Integer.valueOf(paramInt2), "mTargetPos:", Integer.valueOf(this.jdField_b_of_type_Int) });
    }
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
    a(paramInt1, 0, null, paramInt2);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    this.jdField_a_of_type_ComTencentWidgetListView.post(new ScrollerRunnable.2(this));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  protected void e()
  {
    long l1 = System.currentTimeMillis();
    if (System.currentTimeMillis() - jdField_b_of_type_Long < 1000L) {}
    int n;
    do
    {
      return;
      if (this.g != -1) {
        jdField_b_of_type_Long = l1;
      }
      n = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
    } while (this.g < n);
    Object localObject;
    int i1;
    int m;
    if ((this.k == 5) && (this.jdField_a_of_type_Long > 0L))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
      if ((localObject instanceof acut))
      {
        localObject = ((acut)localObject).a();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          i1 = ((List)localObject).size();
          m = 0;
        }
      }
    }
    for (;;)
    {
      if (m < i1)
      {
        if (((ChatMessage)((List)localObject).get(m)).uniseq == this.jdField_a_of_type_Long) {
          this.g = m;
        }
      }
      else
      {
        if (this.g == -1) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(this.g - n);
        if (localObject == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ScrollerRunnable", 2, "FlushMessageItem:" + localObject.hashCode() + "," + ((View)localObject).getParent());
        }
        if (this.h != 1) {
          break label268;
        }
        ((View)localObject).post(new ScrollerRunnable.3(this, (View)localObject));
        return;
      }
      m += 1;
    }
    label268:
    ((View)localObject).post(new ScrollerRunnable.4(this, (View)localObject));
  }
  
  public void run()
  {
    int m;
    int n;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.j = 0;
      if (this.jdField_c_of_type_Boolean)
      {
        m = Math.max(0, this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount());
        if (!this.jdField_c_of_type_Boolean) {
          break label184;
        }
        n = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() + m - this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount() - 1;
        label71:
        if (this.jdField_b_of_type_Int > m) {
          break label199;
        }
        m = m - this.jdField_b_of_type_Int + 1;
        this.jdField_a_of_type_Int = 2;
        label93:
        if (m <= 0) {
          break label363;
        }
        this.jdField_d_of_type_Int = (1000 / m);
        label106:
        this.jdField_c_of_type_Int = -1;
      }
    }
    else
    {
      i1 = this.jdField_a_of_type_ComTencentWidgetListView.getHeight();
      if (!this.jdField_c_of_type_Boolean) {
        break label373;
      }
      n = Math.max(0, this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount());
      label146:
      switch (this.jdField_a_of_type_Int)
      {
      }
    }
    label184:
    label199:
    label363:
    label373:
    View localView;
    label519:
    label539:
    label591:
    do
    {
      do
      {
        return;
        m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
        break;
        n = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() + m - 1;
        break label71;
        if (this.jdField_b_of_type_Int >= n)
        {
          m = this.jdField_b_of_type_Int - n + 1;
          this.jdField_a_of_type_Int = 1;
          break label93;
        }
      } while ((this.k != 23) && (this.k != 14) && (this.k != 17) && (this.k != 100) && (this.k != 11) && (this.k != 6) && (this.k != 26) && (this.k != 18) && (this.k != 21) && (this.k != 22) && (this.k != 5) && (this.k != 10) && (this.k != 13) && (this.k != 101) && (this.k != 102));
      e();
      return;
      this.jdField_d_of_type_Int = 1000;
      break label106;
      n = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      break label146;
      if (this.jdField_d_of_type_Boolean) {}
      int i2;
      for (m = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1 - this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount();; m = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1)
      {
        i2 = n + m;
        if (m < 0) {
          break;
        }
        if (i2 != this.jdField_c_of_type_Int) {
          break label539;
        }
        if (this.j <= 10) {
          break label519;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_b_of_type_Int + 1);
        if (i2 != this.jdField_b_of_type_Int) {
          this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(-this.l, this.jdField_d_of_type_Int);
        }
        c();
        if (this.f == 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(this.f, this.jdField_d_of_type_Int);
        a(0);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      this.j += 1;
      return;
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(m);
      int i3 = localView.getHeight();
      int i4 = localView.getTop();
      int i5 = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingBottom();
      if (i2 < this.jdField_a_of_type_ComTencentWidgetListView.getCount() - 1)
      {
        n = this.e;
        if (!this.jdField_a_of_type_Boolean) {
          break label828;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(n + (i3 - (i1 - i5 - i4)), this.jdField_d_of_type_Int);
      }
      for (;;)
      {
        this.jdField_c_of_type_Int = i2;
        if (i2 < this.jdField_b_of_type_Int) {
          this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        }
        if ((this.k == 23) || (this.k == 14) || (this.k == 17) || (this.k == 100) || (this.k == 11) || (this.k == 6) || (this.k == 26) || (this.k == 18) || (this.k == 5) || (this.k == 10) || (this.k == 13) || (this.k == 101) || (this.k == 102)) {
          e();
        }
        if (i2 < this.jdField_b_of_type_Int) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_b_of_type_Int + 1);
        if (i2 != this.jdField_b_of_type_Int) {
          this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(-this.l, this.jdField_d_of_type_Int);
        }
        c();
        return;
        n = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingBottom();
        break label591;
        if (i2 < this.jdField_b_of_type_Int) {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(m);
        }
      }
      if (n == this.jdField_c_of_type_Int)
      {
        if (this.j > 10)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_b_of_type_Int + 1);
          this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(-this.l, this.jdField_d_of_type_Int);
          c();
          return;
        }
        this.j += 1;
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        return;
      }
      this.j = 0;
      if (n <= this.jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_b_of_type_Int + 1);
        this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(-this.l, this.jdField_d_of_type_Int);
        c();
        return;
      }
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
    } while (localView == null);
    label828:
    int i1 = localView.getTop();
    if (n > this.jdField_b_of_type_Int)
    {
      m = this.e;
      label1000:
      if (!this.jdField_a_of_type_Boolean) {
        break label1060;
      }
      this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(i1 - m, this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = n;
      if (n <= this.jdField_b_of_type_Int) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      return;
      m = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingTop() + this.f;
      break label1000;
      label1060:
      if (n > this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable
 * JD-Core Version:    0.7.0.1
 */