package com.tencent.widget.pull2refresh;

import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

class PagerSnapHelper$TouchEventProcessor
  extends RecyclerView.OnScrollListener
  implements View.OnTouchListener, RecyclerViewCompat.OnFlingListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean = false;
  private float d;
  
  private PagerSnapHelper$TouchEventProcessor(PagerSnapHelper paramPagerSnapHelper) {}
  
  private void a()
  {
    boolean bool1 = true;
    PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, true);
    Object localObject;
    int i;
    if (PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper))
    {
      boolean bool2 = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.c();
      localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
      if (!bool2) {
        PagerSnapHelper.a((PagerSnapHelper)localObject, bool1);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: isRealIdle=" + PagerSnapHelper.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper));
      }
      if (PagerSnapHelper.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)) {
        PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, false);
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper));
      if (localObject == null) {
        break label178;
      }
      i = PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).getPosition((View)localObject);
      label136:
      if (PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, i, PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper))) {
        break label183;
      }
      PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, (View)localObject, this.jdField_b_of_type_Boolean);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
      label178:
      i = -1;
      break label136;
      label183:
      if ((!PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)) && (!PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper))) {
        if (i > PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper))) {
          PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper);
        } else if (i < PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)) {
          PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper);
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    int i = -1;
    PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, false);
    View localView;
    if ((paramInt == 0) || (paramInt == 2))
    {
      localView = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper));
      if (localView == null) {
        break label173;
      }
      this.jdField_b_of_type_Int = PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).getPosition(localView);
    }
    label173:
    for (this.jdField_b_of_type_Int = PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, this.jdField_b_of_type_Int);; this.jdField_b_of_type_Int = -1)
    {
      if ((PagerSnapHelper.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper) != -1) && (PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).findViewByPosition(PagerSnapHelper.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)) == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: centerPosition has been recycler");
        }
        this.jdField_b_of_type_Boolean = true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("onScrollStateChanged: lastCenterView=");
        paramInt = i;
        if (localView != null) {
          paramInt = PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).getPosition(localView);
        }
        QLog.d("PagerSnapHelper", 2, paramInt);
      }
      return;
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper) == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while ((PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).getAdapter() == null) || (!PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)));
      if (PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper) <= 0) {
        PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).getMinFlingVelocity());
      }
      i = this.jdField_b_of_type_Int;
    } while ((Math.abs(paramFloat2) <= PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)) && (Math.abs(paramFloat1) <= PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)));
    try
    {
      TraceCompat.beginSection("snapFromFling");
      boolean bool = PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper), this.jdField_c_of_type_Float, this.d, paramFloat1, paramFloat2, i);
      return bool;
    }
    finally
    {
      TraceCompat.endSection();
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: state=" + paramInt);
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      TraceCompat.beginSection("snap onIdle");
      a();
      TraceCompat.endSection();
    }
    while (paramInt != 1) {
      return;
    }
    TraceCompat.beginSection("snap onDragging");
    a(i);
    TraceCompat.endSection();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 2: 
      do
      {
        return false;
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_Float <= 0.0F) {
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
        }
      } while (this.jdField_b_of_type_Float > 0.0F);
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      return false;
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float - paramMotionEvent.getX());
    }
    for (this.d = (this.jdField_b_of_type_Float - paramMotionEvent.getY());; this.d = 0.0F)
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_c_of_type_Boolean = false;
      return false;
      this.jdField_c_of_type_Float = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PagerSnapHelper.TouchEventProcessor
 * JD-Core Version:    0.7.0.1
 */