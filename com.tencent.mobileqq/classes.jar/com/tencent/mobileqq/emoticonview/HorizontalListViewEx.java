package com.tencent.mobileqq.emoticonview;

import acge;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorizontalListViewEx
  extends HorizontalListView
{
  private static List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private int jdField_a_of_type_Int;
  private int b;
  
  public HorizontalListViewEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalListViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = AIOUtils.a(54.0F, paramContext.getResources());
    paramAttributeSet = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(paramAttributeSet);
    this.b = paramAttributeSet.widthPixels;
  }
  
  public static View a()
  {
    if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0)) {
      return (View)jdField_a_of_type_JavaUtilList.remove(0);
    }
    return null;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilList != null) {
      jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(int paramInt)
  {
    this.g = (this.jdField_a_of_type_Int * paramInt);
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getChildCount();
    if (a() != null)
    {
      paramCanvas = (EmoticonTabAdapter)a();
      int i = 0;
      if (i < j)
      {
        View localView = getChildAt(i);
        Object localObject = paramCanvas.getItem(this.k + i);
        EmoticonTabAdapter.ViewHolder localViewHolder;
        if (localView.getTag() != null)
        {
          localViewHolder = (EmoticonTabAdapter.ViewHolder)localView.getTag();
          if (localView != getSelectedView()) {
            break label118;
          }
          localView.setSelected(true);
          localViewHolder.a.setSelected(true);
          if (localObject != null) {
            localView.setContentDescription(((EmoticonTabAdapter.EmoticonTabItem)localObject).b);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label118:
          localView.setSelected(false);
          localViewHolder.a.setSelected(false);
          if (localObject != null) {
            localView.setContentDescription(((EmoticonTabAdapter.EmoticonTabItem)localObject).b);
          }
        }
      }
    }
  }
  
  public void setSelection(int paramInt)
  {
    int j = 0;
    super.setSelection(paramInt);
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {}
    while ((paramInt >= this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()) || (paramInt < 0)) {
      return;
    }
    int k = getFirstVisiblePosition();
    int m = getLastVisiblePosition();
    int n;
    int i;
    if ((paramInt > m) && (m != -1))
    {
      n = (paramInt + 2) * this.jdField_a_of_type_Int;
      j = n - this.h - this.b;
      i = j;
      if (jdField_a_of_type_Boolean)
      {
        i = j;
        if (QLog.isDevelopLevel())
        {
          QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond right screen, position:" + paramInt + ",lastPosition:" + m + ",tabPosition:" + n + ",mNextX:" + this.h + ",deltaX:" + j + ",mScreenWidth" + this.b);
          i = j;
        }
      }
    }
    while (i != 0)
    {
      b(i);
      return;
      if ((paramInt < k) && (k != -1))
      {
        n = this.jdField_a_of_type_Int * paramInt;
        j = n - this.h;
        i = j;
        if (jdField_a_of_type_Boolean)
        {
          i = j;
          if (QLog.isDevelopLevel())
          {
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond l eft screen, position:" + paramInt + ",firstPosition:" + k + ",tabPosition:" + n + ",mNextX:" + this.h + ",deltaX:" + j + ",mScreenWidth" + this.b);
            i = j;
          }
        }
      }
      else
      {
        View localView;
        int[] arrayOfInt;
        if (paramInt == k)
        {
          localView = getChildAt(0);
          arrayOfInt = new int[2];
          localView.getLocationOnScreen(arrayOfInt);
          i = arrayOfInt[0];
          if ((jdField_a_of_type_Boolean) && (QLog.isDevelopLevel())) {
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half left screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.h + ",deltaX:" + i);
          }
        }
        else if (paramInt == m)
        {
          localView = getChildAt(getChildCount() - 1);
          arrayOfInt = new int[2];
          localView.getLocationOnScreen(arrayOfInt);
          j = this.jdField_a_of_type_Int * 2 - (this.b - arrayOfInt[0]);
          i = j;
          if (j < 0) {
            i = 0;
          }
          if ((jdField_a_of_type_Boolean) && (QLog.isDevelopLevel())) {
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half right screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.h + ",deltaX:" + i);
          }
        }
        else
        {
          i = j;
          if (jdField_a_of_type_Boolean)
          {
            i = j;
            if (QLog.isDevelopLevel())
            {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view inside screen, position:" + paramInt + ",mNextX:" + this.h);
              i = j;
            }
          }
        }
      }
    }
    if ((k == -1) && (m == -1))
    {
      ViewCompat.postOnAnimation(this, new acge(this));
      return;
    }
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.HorizontalListViewEx
 * JD-Core Version:    0.7.0.1
 */