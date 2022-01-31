package com.tencent.mobileqq.emoticonview;

import aciy;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListAdapter;
import anja;
import anjb;
import anjc;
import belr;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorizontalListViewEx
  extends HorizontalListView
{
  private static List<View> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private int jdField_a_of_type_Int;
  private int b;
  
  public HorizontalListViewEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalListViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = aciy.a(54.0F, paramContext.getResources());
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
  
  public int a(int paramInt)
  {
    int i = this.mNextX + paramInt;
    if (i < 0) {
      return -1;
    }
    if (i > this.mMaxX) {
      return 1;
    }
    this.mScroller.a(this.mNextX, 0, paramInt, 0, 20);
    setCurrentScrollState(4098);
    requestLayout();
    return 0;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getChildCount();
    if (getAdapter() != null)
    {
      paramCanvas = (anja)getAdapter();
      int i = 0;
      if (i < j)
      {
        View localView = getChildAt(i);
        Object localObject = paramCanvas.getItem(this.mLeftViewAdapterIndex + i);
        anjc localanjc;
        if (localView.getTag() != null)
        {
          localanjc = (anjc)localView.getTag();
          if (localView != getSelectedView()) {
            break label118;
          }
          localView.setSelected(true);
          localanjc.a.setSelected(true);
          if (localObject != null) {
            localView.setContentDescription(((anjb)localObject).b);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label118:
          localView.setSelected(false);
          localanjc.a.setSelected(false);
          if (localObject != null) {
            localView.setContentDescription(((anjb)localObject).b);
          }
        }
      }
    }
  }
  
  public void resetCurrentX(int paramInt)
  {
    this.mCurrentX = (this.jdField_a_of_type_Int * paramInt);
  }
  
  public void setSelection(int paramInt)
  {
    int j = 0;
    super.setSelection(paramInt);
    if (this.mAdapter == null) {}
    while ((paramInt >= this.mAdapter.getCount()) || (paramInt < 0)) {
      return;
    }
    int k = getFirstVisiblePosition();
    int m = getLastVisiblePosition();
    int n;
    int i;
    if ((paramInt > m) && (m != -1))
    {
      n = (paramInt + 1) * this.jdField_a_of_type_Int;
      j = n - this.mNextX - (this.b - this.jdField_a_of_type_Int - this.jdField_a_of_type_Int);
      i = j;
      if (DEBUG)
      {
        i = j;
        if (QLog.isDevelopLevel())
        {
          QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond right screen, position:" + paramInt + ",lastPosition:" + m + ",tabPosition:" + n + ",mNextX:" + this.mNextX + ",deltaX:" + j + ",mScreenWidth" + this.b);
          i = j;
        }
      }
    }
    while (i != 0)
    {
      a(i);
      return;
      if ((paramInt < k) && (k != -1))
      {
        n = this.jdField_a_of_type_Int * paramInt;
        j = n - this.mNextX;
        i = j;
        if (DEBUG)
        {
          i = j;
          if (QLog.isDevelopLevel())
          {
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond l eft screen, position:" + paramInt + ",firstPosition:" + k + ",tabPosition:" + n + ",mNextX:" + this.mNextX + ",deltaX:" + j + ",mScreenWidth" + this.b);
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
          i = arrayOfInt[0] - this.jdField_a_of_type_Int;
          if ((DEBUG) && (QLog.isDevelopLevel())) {
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half left screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.mNextX + ",deltaX:" + i);
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
          if ((DEBUG) && (QLog.isDevelopLevel())) {
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half right screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.mNextX + ",deltaX:" + i);
          }
        }
        else
        {
          i = j;
          if (DEBUG)
          {
            i = j;
            if (QLog.isDevelopLevel())
            {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view inside screen, position:" + paramInt + ",mNextX:" + this.mNextX);
              i = j;
            }
          }
        }
      }
    }
    if ((k == -1) && (m == -1))
    {
      ViewCompat.postOnAnimation(this, new HorizontalListViewEx.1(this));
      return;
    }
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.HorizontalListViewEx
 * JD-Core Version:    0.7.0.1
 */