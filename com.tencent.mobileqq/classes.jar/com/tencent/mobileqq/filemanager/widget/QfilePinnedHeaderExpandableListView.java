package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import ataa;
import atbq;
import augh;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;

public class QfilePinnedHeaderExpandableListView
  extends FPSPinnedHeaderExpandableListView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private augh jdField_a_of_type_Augh;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = -1;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
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
    setSelector(2131167296);
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
    if (this.e == 0) {
      return null;
    }
    if (paramInt1 > this.e * paramInt2) {
      paramInt1 = paramInt2 - 1;
    }
    for (;;)
    {
      localObject = ((ViewGroup)localObject).getChildAt(paramInt1);
      if (localObject != null) {
        break;
      }
      return null;
      paramInt1 /= this.e;
    }
    localObject = ((View)localObject).getTag();
    if (localObject != null)
    {
      if ((localObject instanceof ataa))
      {
        localObject = (ataa)localObject;
        return new int[] { ((ataa)localObject).jdField_b_of_type_Int, ((ataa)localObject).jdField_a_of_type_Int };
      }
      if (atbq.class.isInstance(localObject))
      {
        localObject = (atbq)localObject;
        return new int[] { ((atbq)localObject).jdField_b_of_type_Int, ((atbq)localObject).jdField_a_of_type_Int };
      }
    }
    return null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (this.jdField_b_of_type_Boolean)
    {
      i = paramMotionEvent.getAction();
      if ((i != 2) || (!this.jdField_d_of_type_Boolean)) {}
    }
    boolean bool;
    do
    {
      for (;;)
      {
        return true;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        switch (i & 0xFF)
        {
        default: 
        case 2: 
        case 0: 
          while (!this.jdField_d_of_type_Boolean)
          {
            return super.onInterceptTouchEvent(paramMotionEvent);
            float f3 = Math.abs(f1 - this.jdField_a_of_type_Float);
            if ((f3 > Math.abs(f2 - this.jdField_b_of_type_Float) * 1.73F) && (f3 > this.jdField_c_of_type_Float))
            {
              this.jdField_d_of_type_Boolean = true;
              this.jdField_a_of_type_Float = f1;
              this.jdField_b_of_type_Float = f2;
              continue;
              this.jdField_a_of_type_Float = f1;
              this.jdField_b_of_type_Float = f2;
              int[] arrayOfInt = a((int)f1, (int)f2);
              if (arrayOfInt != null)
              {
                i = arrayOfInt[0];
                this.jdField_c_of_type_Int = i;
                this.jdField_a_of_type_Int = i;
                i = arrayOfInt[1];
                this.jdField_d_of_type_Int = i;
                this.jdField_b_of_type_Int = i;
              }
            }
          }
        }
      }
      bool = this.jdField_d_of_type_Boolean;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Int = -1;
      this.jdField_a_of_type_Int = -1;
      this.jdField_d_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_Boolean = false;
    } while (!bool);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    float f1;
    float f2;
    label130:
    int j;
    if (this.jdField_b_of_type_Boolean)
    {
      i = paramMotionEvent.getAction();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      switch (i & 0xFF)
      {
      default: 
      case 2: 
        for (;;)
        {
          if (this.jdField_d_of_type_Boolean)
          {
            return true;
            if (!this.jdField_d_of_type_Boolean)
            {
              float f3 = Math.abs(f1 - this.jdField_a_of_type_Float);
              if ((f3 > Math.abs(f2 - this.jdField_b_of_type_Float) * 1.73F) && (f3 > this.jdField_c_of_type_Float))
              {
                this.jdField_d_of_type_Boolean = true;
                this.jdField_a_of_type_Float = f1;
                this.jdField_b_of_type_Float = f2;
              }
            }
            else
            {
              if (!this.jdField_d_of_type_Boolean) {
                continue;
              }
              if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != -1) && (this.jdField_b_of_type_Int != -1))
              {
                if (this.jdField_a_of_type_Augh != null) {
                  this.jdField_a_of_type_Augh.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
                }
                this.jdField_a_of_type_Boolean = true;
              }
              int[] arrayOfInt = a((int)f1, (int)f2);
              if (arrayOfInt == null) {
                break label461;
              }
              j = arrayOfInt[0];
              i = arrayOfInt[1];
            }
          }
        }
      }
    }
    while ((j != -1) && (i != -1))
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_Int = j;
        this.jdField_a_of_type_Int = j;
        this.jdField_d_of_type_Int = i;
        this.jdField_b_of_type_Int = i;
        if (this.jdField_a_of_type_Augh != null) {
          this.jdField_a_of_type_Augh.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = true;
        break;
        if (this.jdField_a_of_type_Augh == null) {
          break label130;
        }
        this.jdField_a_of_type_Augh.a(true);
        break label130;
      }
      this.jdField_c_of_type_Int = j;
      this.jdField_d_of_type_Int = i;
      if (this.jdField_a_of_type_Augh == null) {
        break;
      }
      this.jdField_a_of_type_Augh.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      break;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      break;
      boolean bool = this.jdField_d_of_type_Boolean;
      if (this.jdField_a_of_type_Augh != null)
      {
        if (this.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_Augh.b(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        }
        this.jdField_a_of_type_Augh.a(false);
      }
      this.jdField_c_of_type_Int = -1;
      this.jdField_a_of_type_Int = -1;
      this.jdField_d_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      if (!bool) {
        break;
      }
      return true;
      return super.onTouchEvent(paramMotionEvent);
      label461:
      i = -1;
      j = -1;
    }
  }
  
  public void setGridSize(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnIndexChangedListener(augh paramaugh)
  {
    this.jdField_a_of_type_Augh = paramaugh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */