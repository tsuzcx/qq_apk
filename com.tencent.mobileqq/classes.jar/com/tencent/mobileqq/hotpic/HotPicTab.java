package com.tencent.mobileqq.hotpic;

import adzj;
import adzk;
import adzl;
import adzn;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HotPicTab
  extends HorizontalListView
{
  private static final float jdField_b_of_type_Float;
  private static int q;
  private static final int r;
  private static final int s;
  private static final int t;
  private static final int u;
  private static final int v;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  adzl jdField_a_of_type_Adzl;
  private Context jdField_a_of_type_AndroidContentContext;
  public final Paint a;
  private Handler jdField_a_of_type_AndroidOsHandler = new adzj(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private int jdField_b_of_type_Int = -1;
  Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private int c = -1;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    q = localResources.getDisplayMetrics().widthPixels;
    r = (int)(40.0F * localResources.getDisplayMetrics().density + 0.5F);
    s = (int)(4.0F * localResources.getDisplayMetrics().density + 0.5F);
    t = 14;
    jdField_b_of_type_Float = localResources.getDisplayMetrics().density;
    u = localResources.getColor(2131494226);
    v = localResources.getColor(2131494220);
  }
  
  public HotPicTab(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(u);
  }
  
  public int a()
  {
    return this.m;
  }
  
  public HotPicTagInfo a()
  {
    if (this.jdField_a_of_type_Adzl != null)
    {
      Object localObject = this.jdField_a_of_type_Adzl.a;
      if (((List)localObject).size() > this.m)
      {
        localObject = (HotPicTagInfo)((List)localObject).get(this.m);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    setAdapter(null);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    setOnItemClickListener(null);
    this.jdField_a_of_type_Adzl = null;
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void a(List paramList, int paramInt)
  {
    boolean bool1 = false;
    paramList = new ArrayList(paramList);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(t * jdField_b_of_type_Float + 0.5F);
    Iterator localIterator = paramList.iterator();
    HotPicTagInfo localHotPicTagInfo;
    int j;
    for (int i = 0; localIterator.hasNext(); i = j + i)
    {
      localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
      j = (int)((int)(this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localHotPicTagInfo.tagName) + 0.5F) + jdField_b_of_type_Float * 26.0F);
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
    }
    if (i < q)
    {
      boolean bool2 = true;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      float f = q / i;
      localIterator = paramList.iterator();
      for (;;)
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
        i = (int)((int)((int)(this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localHotPicTagInfo.tagName) + 0.5F) + jdField_b_of_type_Float * 26.0F) * f);
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
      }
    }
    this.jdField_a_of_type_Adzl = new adzl(this, paramList, this.jdField_a_of_type_JavaUtilArrayList, bool1);
    this.jdField_a_of_type_Int = paramInt;
    setAdapter(this.jdField_a_of_type_Adzl);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.a(paramBoolean);
      return;
    }
    b(this.d);
    removeAllViewsInLayout();
    if (this.jdField_a_of_type_Int != -1)
    {
      int i = 0;
      int j = 0;
      while ((i < this.jdField_a_of_type_Int) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        j += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).intValue();
        i += 1;
      }
      i = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).intValue() * 1 / 2 + j;
      j = q * 1 / 2;
      if (i > j)
      {
        this.g = (i - j);
        this.m = this.jdField_a_of_type_Int;
        this.c = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Float = 1.0F;
        this.jdField_b_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      this.g = 0;
      break;
      this.m = 0;
      this.c = 0;
    }
  }
  
  public int b(int paramInt)
  {
    int i = this.h + paramInt;
    if (i < 0) {
      return -1;
    }
    if (i > this.i) {
      return 1;
    }
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.h, 0, paramInt, 0, 20);
    g(4098);
    requestLayout();
    return 0;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int k = 0;
    super.dispatchDraw(paramCanvas);
    int i = q;
    int j;
    if (this.c < this.k)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      View localView;
      Object localObject;
      int m;
      if (this.jdField_a_of_type_Float > 0.0F)
      {
        localView = getSelectedView();
        if ((localView != null) && (localView.getTag() != null))
        {
          localObject = ((adzn)localView.getTag()).a;
          m = (int)(localView.getLeft() + ((TextView)localObject).getLeft() - jdField_b_of_type_Float * 5.0F);
          k = localView.getLeft();
          k = (int)(((TextView)localObject).getRight() + k + jdField_b_of_type_Float * 5.0F);
          label121:
          float f1 = j;
          float f2 = this.jdField_a_of_type_Float;
          j = (int)((m - j) * f2 + f1);
          f1 = i;
          f2 = this.jdField_a_of_type_Float;
          i = (int)(f1 + (k - i) * f2);
        }
      }
      for (;;)
      {
        paramCanvas.drawRect(j, getHeight() - s, i, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
        if (this.c > this.l)
        {
          j = q;
          break;
        }
        localView = b(this.c);
        if ((localView == null) || (localView.getTag() == null)) {
          break label314;
        }
        localObject = (adzn)localView.getTag();
        j = (int)(localView.getLeft() + ((adzn)localObject).a.getLeft() - jdField_b_of_type_Float * 5.0F);
        i = localView.getLeft();
        i = (int)(((adzn)localObject).a.getRight() + i + jdField_b_of_type_Float * 5.0F);
        break;
        m = 0;
        break label121;
      }
      label314:
      j = 0;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (AppSetting.jdField_b_of_type_Boolean) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 50, paramInt8, paramBoolean);
  }
  
  public void setSelection(int paramInt)
  {
    if (this.m == paramInt) {}
    int n;
    do
    {
      return;
      super.setSelection(paramInt);
      n = q;
    } while ((this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (paramInt >= this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()) || (paramInt < 0));
    int k = getFirstVisiblePosition();
    int m = getLastVisiblePosition();
    int i;
    int j;
    if ((paramInt > m) && (m != -1))
    {
      i = 0;
      j = 0;
      while (i <= paramInt)
      {
        j += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).intValue();
        i += 1;
      }
      paramInt = j - this.h - n;
      if (paramInt == 0) {
        break label324;
      }
      b(paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (!Build.MODEL.equalsIgnoreCase("OPPO R7")) {
        break label358;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return;
      if ((paramInt < k) && (k != -1))
      {
        i = 0;
        j = 0;
        while (i < paramInt)
        {
          j += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).intValue();
          i += 1;
        }
        paramInt = j - this.h;
        break;
      }
      View localView;
      int[] arrayOfInt;
      if (paramInt == k)
      {
        localView = getChildAt(0);
        arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
        paramInt = arrayOfInt[0];
        break;
      }
      if (paramInt == m)
      {
        localView = getChildAt(getChildCount() - 1);
        arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
        i = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue() - (n - arrayOfInt[0]);
        paramInt = i;
        if (i >= 0) {
          break;
        }
        paramInt = 0;
        break;
      }
      if ((jdField_a_of_type_Boolean) && (QLog.isDevelopLevel())) {}
      paramInt = 0;
      break;
      label324:
      if ((k == -1) && (m == -1)) {
        ViewCompat.postOnAnimation(this, new adzk(this));
      } else {
        requestLayout();
      }
    }
    label358:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicTab
 * JD-Core Version:    0.7.0.1
 */