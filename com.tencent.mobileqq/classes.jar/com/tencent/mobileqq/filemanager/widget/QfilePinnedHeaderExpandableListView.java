package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.mobileqq.filemanager.activity.adapter.DelDownloadHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;

public class QfilePinnedHeaderExpandableListView
  extends FPSPinnedHeaderExpandableListView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private QfilePinnedHeaderExpandableListView.OnSelectListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = -1;
  private int e;
  
  public QfilePinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
    setNeedCheckSpringback(true);
    a(paramContext);
    setTouchSlop(paramContext);
  }
  
  public QfilePinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    setTouchSlop(paramContext);
  }
  
  public QfilePinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    setTouchSlop(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setSelector(2131167333);
    setGroupIndicator(null);
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    int i = getFirstVisiblePosition();
    Object localObject = (ViewGroup)getChildAt(pointToPosition(paramInt1, paramInt2) - i);
    if (localObject == null) {
      return null;
    }
    paramInt2 = ((ViewGroup)localObject).getChildCount();
    i = this.e;
    if (i == 0) {
      return null;
    }
    if (paramInt1 > i * paramInt2) {
      paramInt1 = paramInt2 - 1;
    } else {
      paramInt1 /= i;
    }
    localObject = ((ViewGroup)localObject).getChildAt(paramInt1);
    if (localObject == null) {
      return null;
    }
    localObject = ((View)localObject).getTag();
    if (localObject != null)
    {
      if ((localObject instanceof ImageHolder))
      {
        localObject = (ImageHolder)localObject;
        return new int[] { ((ImageHolder)localObject).jdField_b_of_type_Int, ((ImageHolder)localObject).jdField_a_of_type_Int };
      }
      if (DelDownloadHolder.class.isInstance(localObject))
      {
        localObject = (DelDownloadHolder)localObject;
        return new int[] { ((DelDownloadHolder)localObject).jdField_b_of_type_Int, ((DelDownloadHolder)localObject).jdField_a_of_type_Int };
      }
    }
    return null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      int i = paramMotionEvent.getAction();
      if ((i == 2) && (this.jdField_c_of_type_Boolean)) {
        return true;
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i &= 0xFF;
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              break label233;
            }
          }
          else
          {
            float f3 = Math.abs(f1 - this.jdField_a_of_type_Float);
            if ((f3 <= Math.abs(f2 - this.jdField_b_of_type_Float) * 1.73F) || (f3 <= this.jdField_c_of_type_Float)) {
              break label233;
            }
            this.jdField_c_of_type_Boolean = true;
            this.jdField_a_of_type_Float = f1;
            this.jdField_b_of_type_Float = f2;
            break label233;
          }
        }
        boolean bool = this.jdField_c_of_type_Boolean;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_c_of_type_Int = -1;
        this.jdField_a_of_type_Int = -1;
        this.d = -1;
        this.jdField_b_of_type_Int = -1;
        this.jdField_a_of_type_Boolean = false;
        if (bool) {
          return true;
        }
      }
      else
      {
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
        int[] arrayOfInt = a((int)f1, (int)f2);
        if (arrayOfInt != null)
        {
          i = arrayOfInt[0];
          this.jdField_c_of_type_Int = i;
          this.jdField_a_of_type_Int = i;
          i = arrayOfInt[1];
          this.d = i;
          this.jdField_b_of_type_Int = i;
        }
      }
      label233:
      if (this.jdField_c_of_type_Boolean) {
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      int i = paramMotionEvent.getAction();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i &= 0xFF;
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              break label461;
            }
          }
          else
          {
            if (!this.jdField_c_of_type_Boolean)
            {
              float f3 = Math.abs(f1 - this.jdField_a_of_type_Float);
              if ((f3 > Math.abs(f2 - this.jdField_b_of_type_Float) * 1.73F) && (f3 > this.jdField_c_of_type_Float))
              {
                this.jdField_c_of_type_Boolean = true;
                this.jdField_a_of_type_Float = f1;
                this.jdField_b_of_type_Float = f2;
              }
              else
              {
                localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener;
                if (localObject != null) {
                  ((QfilePinnedHeaderExpandableListView.OnSelectListener)localObject).a(true);
                }
              }
            }
            if (!this.jdField_c_of_type_Boolean) {
              break label461;
            }
            int j;
            if (!this.jdField_a_of_type_Boolean)
            {
              i = this.jdField_a_of_type_Int;
              if (i != -1)
              {
                j = this.jdField_b_of_type_Int;
                if (j != -1)
                {
                  localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener;
                  if (localObject != null) {
                    ((QfilePinnedHeaderExpandableListView.OnSelectListener)localObject).a(i, j);
                  }
                  this.jdField_a_of_type_Boolean = true;
                }
              }
            }
            localObject = a((int)f1, (int)f2);
            if (localObject != null)
            {
              j = localObject[0];
              i = localObject[1];
            }
            else
            {
              i = -1;
              j = -1;
            }
            if ((j == -1) || (i == -1)) {
              break label461;
            }
            if (!this.jdField_a_of_type_Boolean)
            {
              this.jdField_c_of_type_Int = j;
              this.jdField_a_of_type_Int = j;
              this.d = i;
              this.jdField_b_of_type_Int = i;
              localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener;
              if (localObject != null) {
                ((QfilePinnedHeaderExpandableListView.OnSelectListener)localObject).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
              }
              this.jdField_a_of_type_Boolean = true;
              break label461;
            }
            this.jdField_c_of_type_Int = j;
            this.d = i;
            localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener;
            if (localObject == null) {
              break label461;
            }
            ((QfilePinnedHeaderExpandableListView.OnSelectListener)localObject).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.d);
            break label461;
          }
        }
        boolean bool = this.jdField_c_of_type_Boolean;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener;
        if (localObject != null)
        {
          if (bool) {
            ((QfilePinnedHeaderExpandableListView.OnSelectListener)localObject).b(this.jdField_c_of_type_Int, this.d);
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener.a(false);
        }
        this.jdField_c_of_type_Int = -1;
        this.jdField_a_of_type_Int = -1;
        this.d = -1;
        this.jdField_b_of_type_Int = -1;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Boolean = false;
        if (bool) {
          return true;
        }
      }
      else
      {
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
      }
      label461:
      if (this.jdField_c_of_type_Boolean) {
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setGridSize(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnIndexChangedListener(QfilePinnedHeaderExpandableListView.OnSelectListener paramOnSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener = paramOnSelectListener;
  }
  
  public void setTouchSlop(Context paramContext)
  {
    this.jdField_c_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 15);
  }
  
  public void setWhetherImageTab(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */