package com.tencent.mobileqq.widget;

import akws;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class ScrollerRunnable
  implements Runnable
{
  private static long jdField_b_of_type_Long;
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  protected boolean a;
  private int jdField_b_of_type_Int;
  protected boolean b;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private final int f;
  private int g;
  private int h = -1;
  private int i = -1;
  
  public ScrollerRunnable(ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.f = ViewConfiguration.get(this.jdField_a_of_type_ComTencentWidgetListView.getContext()).getScaledFadingEdgeLength();
    if (DeviceInfoUtil.e() / 1048576L > 512L) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    c();
  }
  
  private void c()
  {
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - jdField_b_of_type_Long < 1000L) {}
    int k;
    do
    {
      return;
      jdField_b_of_type_Long = l;
      k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
    } while (this.h < k);
    Object localObject;
    int m;
    int j;
    if ((this.i == 5) && (this.jdField_a_of_type_Long > 0L))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
      if ((localObject instanceof ChatAdapter1))
      {
        localObject = ((ChatAdapter1)localObject).a();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          m = ((List)localObject).size();
          j = 0;
        }
      }
    }
    for (;;)
    {
      if (j < m)
      {
        if (((ChatMessage)((List)localObject).get(j)).uniseq == this.jdField_a_of_type_Long) {
          this.h = j;
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(this.h - k);
        if (localObject == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ScrollerRunnable", 2, "FlushMessageItem:" + localObject.hashCode() + "," + ((View)localObject).getParent());
        }
        ((View)localObject).postDelayed(new akws(this, (View)localObject), 300L);
        return;
      }
      j += 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 135
    //   10: iconst_2
    //   11: new 137	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   18: ldc 188
    //   20: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: iload_1
    //   34: ifne +28 -> 62
    //   37: aload_0
    //   38: getfield 44	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   41: invokevirtual 193	java/util/HashMap:isEmpty	()Z
    //   44: ifne +18 -> 62
    //   47: aload_0
    //   48: getfield 44	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   51: invokevirtual 196	java/util/HashMap:clear	()V
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 198	com/tencent/mobileqq/widget/ScrollerRunnable:g	I
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_0
    //   63: getfield 44	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: iload_1
    //   67: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokevirtual 208	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   73: ifeq -14 -> 59
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 198	com/tencent/mobileqq/widget/ScrollerRunnable:g	I
    //   81: aload_0
    //   82: getfield 44	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   85: iload_1
    //   86: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokevirtual 212	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 200	java/lang/Integer
    //   95: invokevirtual 215	java/lang/Integer:intValue	()I
    //   98: isub
    //   99: putfield 198	com/tencent/mobileqq/widget/ScrollerRunnable:g	I
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
    //   3: getfield 44	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: iload_1
    //   7: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokevirtual 208	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 198	com/tencent/mobileqq/widget/ScrollerRunnable:g	I
    //   26: iload_2
    //   27: iadd
    //   28: putfield 198	com/tencent/mobileqq/widget/ScrollerRunnable:g	I
    //   31: aload_0
    //   32: getfield 44	com/tencent/mobileqq/widget/ScrollerRunnable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   35: iload_1
    //   36: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: iload_2
    //   40: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: invokevirtual 220	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq -32 -> 18
    //   53: ldc 135
    //   55: iconst_2
    //   56: new 137	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   63: ldc 222
    //   65: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_1
    //   69: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 224
    //   74: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: iload_2
    //   78: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable)
  {
    this.i = paramInt1;
    a(paramInt2, paramInt3, paramRunnable);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    a(paramInt1, paramInt2, paramInt3, paramRunnable);
  }
  
  public void a(int paramInt1, int paramInt2, Runnable paramRunnable)
  {
    a();
    this.h = paramInt2;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_ComTencentWidgetListView.post(this);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 0, null);
  }
  
  public void run()
  {
    int j;
    int k;
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_Boolean)
      {
        j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
        if (!this.jdField_a_of_type_Boolean) {
          break label176;
        }
        k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() + j - this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount() - 1;
        label67:
        if (this.jdField_c_of_type_Int > j) {
          break label191;
        }
        j = j - this.jdField_c_of_type_Int + 1;
        this.jdField_b_of_type_Int = 2;
        label89:
        if (j <= 0) {
          break label319;
        }
        this.e = (1000 / j);
        label102:
        this.jdField_d_of_type_Int = -1;
      }
    }
    else
    {
      m = this.jdField_a_of_type_ComTencentWidgetListView.getHeight();
      if (!this.jdField_a_of_type_Boolean) {
        break label329;
      }
      j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      label138:
      switch (this.jdField_b_of_type_Int)
      {
      }
    }
    label176:
    label191:
    label329:
    label468:
    View localView;
    label319:
    label448:
    label511:
    do
    {
      do
      {
        return;
        j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
        break;
        k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() + j - 1;
        break label67;
        if (this.jdField_c_of_type_Int >= k)
        {
          j = this.jdField_c_of_type_Int - k + 1;
          this.jdField_b_of_type_Int = 1;
          break label89;
        }
      } while ((this.i != 21) && (this.i != 13) && (this.i != 15) && (this.i != 6) && (this.i != 24) && (this.i != 16) && (this.i != 19) && (this.i != 20) && (this.i != 5) && (this.i != 10) && (this.i != 12));
      c();
      return;
      this.e = 1000;
      break label102;
      j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      break label138;
      if (this.jdField_b_of_type_Boolean) {}
      int n;
      for (k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1 - this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount();; k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1)
      {
        n = j + k;
        if (k < 0) {
          break;
        }
        if (n != this.jdField_d_of_type_Int) {
          break label468;
        }
        if (this.jdField_a_of_type_Int <= 10) {
          break label448;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_c_of_type_Int);
        b();
        if (this.g == 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(this.g, this.e);
        a(0);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      this.jdField_a_of_type_Int += 1;
      return;
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(k);
      int i1 = localView.getHeight();
      int i2 = localView.getTop();
      if (n < this.jdField_a_of_type_ComTencentWidgetListView.getCount() - 1)
      {
        j = this.f;
        if (!this.jdField_c_of_type_Boolean) {
          break label658;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(j + (i1 - (m - i2)), this.e);
      }
      for (;;)
      {
        this.jdField_d_of_type_Int = n;
        if (n < this.jdField_c_of_type_Int) {
          this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        }
        if ((this.i != 21) && (this.i != 13) && (this.i != 15) && (this.i != 6) && (this.i != 24) && (this.i != 16) && (this.i != 5) && (this.i != 10) && (this.i != 12)) {
          break;
        }
        c();
        return;
        j = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingBottom();
        break label511;
        if (n < this.jdField_c_of_type_Int) {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(k);
        }
      }
      if (j == this.jdField_d_of_type_Int)
      {
        if (this.jdField_a_of_type_Int > 10)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_c_of_type_Int);
          b();
          return;
        }
        this.jdField_a_of_type_Int += 1;
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        return;
      }
      this.jdField_a_of_type_Int = 0;
      if (j <= this.jdField_c_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_c_of_type_Int);
        b();
      }
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
    } while (localView == null);
    label658:
    int m = localView.getTop();
    if (j > this.jdField_c_of_type_Int)
    {
      k = this.f;
      label793:
      if (!this.jdField_c_of_type_Boolean) {
        break label853;
      }
      this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollBy(m - k, this.e);
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = j;
      if (j <= this.jdField_c_of_type_Int) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      return;
      k = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingTop() + this.g;
      break label793;
      label853:
      if (j > this.jdField_c_of_type_Int) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable
 * JD-Core Version:    0.7.0.1
 */