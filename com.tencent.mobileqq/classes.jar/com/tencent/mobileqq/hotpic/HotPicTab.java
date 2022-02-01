package com.tencent.mobileqq.hotpic;

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
import com.tencent.mobileqq.theme.ThemeUtil;
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
  private static int d;
  private static final int e;
  private static final int f;
  private static final int g;
  private static final int h;
  private static final int i;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  public final Paint a;
  private Handler jdField_a_of_type_AndroidOsHandler = new HotPicTab.1(this);
  HotPicTab.HotPicTabAdapter jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab$HotPicTabAdapter;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private int jdField_b_of_type_Int = -1;
  Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private int c = -1;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    d = localResources.getDisplayMetrics().widthPixels;
    e = (int)(40.0F * localResources.getDisplayMetrics().density + 0.5F);
    f = (int)(4.0F * localResources.getDisplayMetrics().density + 0.5F);
    g = 14;
    jdField_b_of_type_Float = localResources.getDisplayMetrics().density;
    h = localResources.getColor(2131167041);
    i = localResources.getColor(2131167033);
  }
  
  public HotPicTab(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(h);
  }
  
  public int a()
  {
    return this.mCurrentlySelectedAdapterIndex;
  }
  
  public int a(int paramInt)
  {
    int j = this.mNextX + paramInt;
    if (j < 0) {
      return -1;
    }
    if (j > this.mMaxX) {
      return 1;
    }
    this.mScroller.startScroll(this.mNextX, 0, paramInt, 0, 20);
    setCurrentScrollState(4098);
    requestLayout();
    return 0;
  }
  
  public HotPicTagInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab$HotPicTabAdapter != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab$HotPicTabAdapter.a;
      if (((List)localObject).size() > this.mCurrentlySelectedAdapterIndex)
      {
        localObject = (HotPicTagInfo)((List)localObject).get(this.mCurrentlySelectedAdapterIndex);
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
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab$HotPicTabAdapter = null;
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void a(List<HotPicTagInfo> paramList, int paramInt)
  {
    boolean bool1 = false;
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {}
    Iterator localIterator;
    HotPicTagInfo localHotPicTagInfo;
    for (int j = 2131165373;; j = 2131167390)
    {
      setBackgroundResource(j);
      paramList = new ArrayList(paramList);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(g * jdField_b_of_type_Float + 0.5F);
      localIterator = paramList.iterator();
      int k;
      for (j = 0; localIterator.hasNext(); j = k + j)
      {
        localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
        k = (int)((int)(this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localHotPicTagInfo.tagName) + 0.5F) + jdField_b_of_type_Float * 26.0F);
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(k));
      }
    }
    if (j < d)
    {
      boolean bool2 = true;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      float f1 = d / j;
      localIterator = paramList.iterator();
      for (;;)
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
        j = (int)((int)((int)(this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localHotPicTagInfo.tagName) + 0.5F) + jdField_b_of_type_Float * 26.0F) * f1);
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab$HotPicTabAdapter = new HotPicTab.HotPicTabAdapter(this, paramList, this.jdField_a_of_type_JavaUtilArrayList, bool1);
    this.jdField_a_of_type_Int = paramInt;
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab$HotPicTabAdapter);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    int m = 0;
    super.dispatchDraw(paramCanvas);
    int j = d;
    int k;
    if (this.c < this.mLeftViewAdapterIndex)
    {
      j = 0;
      k = 0;
    }
    for (;;)
    {
      View localView;
      Object localObject;
      int n;
      if (this.jdField_a_of_type_Float > 0.0F)
      {
        localView = getSelectedView();
        if ((localView != null) && (localView.getTag() != null))
        {
          localObject = ((HotPicTab.ViewHolder)localView.getTag()).a;
          n = (int)(localView.getLeft() + ((TextView)localObject).getLeft() - jdField_b_of_type_Float * 5.0F);
          m = localView.getLeft();
          m = (int)(((TextView)localObject).getRight() + m + jdField_b_of_type_Float * 5.0F);
          label121:
          float f1 = k;
          float f2 = this.jdField_a_of_type_Float;
          k = (int)((n - k) * f2 + f1);
          f1 = j;
          f2 = this.jdField_a_of_type_Float;
          j = (int)(f1 + (m - j) * f2);
        }
      }
      for (;;)
      {
        paramCanvas.drawRect(k, getHeight() - f, j, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
        if (this.c > this.mRightViewAdapterIndex)
        {
          k = d;
          break;
        }
        localView = getChild(this.c);
        if ((localView == null) || (localView.getTag() == null)) {
          break label314;
        }
        localObject = (HotPicTab.ViewHolder)localView.getTag();
        k = (int)(localView.getLeft() + ((HotPicTab.ViewHolder)localObject).a.getLeft() - jdField_b_of_type_Float * 5.0F);
        j = localView.getLeft();
        j = (int)(((HotPicTab.ViewHolder)localObject).a.getRight() + j + jdField_b_of_type_Float * 5.0F);
        break;
        n = 0;
        break label121;
      }
      label314:
      k = 0;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (AppSetting.d) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 50, paramInt8, paramBoolean);
  }
  
  public void reset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.reset(paramBoolean);
      return;
    }
    initView(this.isFromRightToLeft);
    removeAllViewsInLayout();
    if (this.jdField_a_of_type_Int != -1)
    {
      int j = 0;
      int k = 0;
      while ((j < this.jdField_a_of_type_Int) && (j < this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        k += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(j)).intValue();
        j += 1;
      }
      j = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).intValue() * 1 / 2 + k;
      k = d * 1 / 2;
      if (j > k)
      {
        this.mCurrentX = (j - k);
        this.mCurrentlySelectedAdapterIndex = this.jdField_a_of_type_Int;
        this.c = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Float = 1.0F;
        this.mDataChanged = true;
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      this.mCurrentX = 0;
      break;
      this.mCurrentlySelectedAdapterIndex = 0;
      this.c = 0;
    }
  }
  
  public void setSelection(int paramInt)
  {
    if (this.mCurrentlySelectedAdapterIndex == paramInt) {}
    int i1;
    do
    {
      return;
      super.setSelection(paramInt);
      i1 = d;
    } while ((this.mAdapter == null) || (paramInt >= this.mAdapter.getCount()) || (paramInt < 0));
    int m = getFirstVisiblePosition();
    int n = getLastVisiblePosition();
    int j;
    int k;
    if ((paramInt > n) && (n != -1))
    {
      j = 0;
      k = 0;
      while (j <= paramInt)
      {
        k += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(j)).intValue();
        j += 1;
      }
      paramInt = k - this.mNextX - i1;
      if (paramInt == 0) {
        break label324;
      }
      a(paramInt);
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
      if ((paramInt < m) && (m != -1))
      {
        j = 0;
        k = 0;
        while (j < paramInt)
        {
          k += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(j)).intValue();
          j += 1;
        }
        paramInt = k - this.mNextX;
        break;
      }
      View localView;
      int[] arrayOfInt;
      if (paramInt == m)
      {
        localView = getChildAt(0);
        arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
        paramInt = arrayOfInt[0];
        break;
      }
      if (paramInt == n)
      {
        localView = getChildAt(getChildCount() - 1);
        arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
        j = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue() - (i1 - arrayOfInt[0]);
        paramInt = j;
        if (j >= 0) {
          break;
        }
        paramInt = 0;
        break;
      }
      if ((DEBUG) && (QLog.isDevelopLevel())) {}
      paramInt = 0;
      break;
      label324:
      if ((m == -1) && (n == -1)) {
        ViewCompat.postOnAnimation(this, new HotPicTab.2(this));
      } else {
        requestLayout();
      }
    }
    label358:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicTab
 * JD-Core Version:    0.7.0.1
 */