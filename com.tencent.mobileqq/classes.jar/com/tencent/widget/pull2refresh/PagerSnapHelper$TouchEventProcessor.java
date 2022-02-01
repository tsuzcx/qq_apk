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
    PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, true);
    if (PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper))
    {
      boolean bool = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.c();
      PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, bool ^ true);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScrollStateChanged: isRealIdle=");
      ((StringBuilder)localObject).append(PagerSnapHelper.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper));
      QLog.d("PagerSnapHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (PagerSnapHelper.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)) {
      PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
    localObject = ((PagerSnapHelper)localObject).a(PagerSnapHelper.a((PagerSnapHelper)localObject));
    int i;
    if (localObject != null) {
      i = PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).getPosition((View)localObject);
    } else {
      i = -1;
    }
    PagerSnapHelper localPagerSnapHelper = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
    if (!PagerSnapHelper.a(localPagerSnapHelper, i, PagerSnapHelper.a(localPagerSnapHelper)))
    {
      PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, (View)localObject, this.jdField_b_of_type_Boolean);
    }
    else if ((!PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)) && (!PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
      if (i > PagerSnapHelper.a((PagerSnapHelper)localObject, PagerSnapHelper.a((PagerSnapHelper)localObject))) {
        PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper);
      } else if (i < PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)) {
        PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper);
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, false);
    if ((paramInt == 0) || (paramInt == 2))
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
      localObject = ((PagerSnapHelper)localObject).a(PagerSnapHelper.a((PagerSnapHelper)localObject));
      paramInt = -1;
      if (localObject != null)
      {
        this.jdField_b_of_type_Int = PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).getPosition((View)localObject);
        this.jdField_b_of_type_Int = PagerSnapHelper.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper, this.jdField_b_of_type_Int);
      }
      else
      {
        this.jdField_b_of_type_Int = -1;
      }
      if ((PagerSnapHelper.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper) != -1) && (PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).findViewByPosition(PagerSnapHelper.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)) == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: centerPosition has been recycler");
        }
        this.jdField_b_of_type_Boolean = true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onScrollStateChanged: lastCenterView=");
        if (localObject != null) {
          paramInt = PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).getPosition((View)localObject);
        }
        localStringBuilder.append(paramInt);
        QLog.d("PagerSnapHelper", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean onFling(float paramFloat1, float paramFloat2)
  {
    if (PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper) == null) {
      return false;
    }
    if (PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper).getAdapter() == null) {
      return false;
    }
    if (!PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)) {
      return false;
    }
    if (PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper) <= 0)
    {
      PagerSnapHelper localPagerSnapHelper = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
      PagerSnapHelper.a(localPagerSnapHelper, PagerSnapHelper.a(localPagerSnapHelper).getMinFlingVelocity());
    }
    int i = this.jdField_b_of_type_Int;
    if ((Math.abs(paramFloat2) <= PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper)) && (Math.abs(paramFloat1) <= PagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper))) {
      return false;
    }
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
    if (QLog.isColorLevel())
    {
      paramRecyclerView = new StringBuilder();
      paramRecyclerView.append("onScrollStateChanged: state=");
      paramRecyclerView.append(paramInt);
      QLog.d("PagerSnapHelper", 2, paramRecyclerView.toString());
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      TraceCompat.beginSection("snap onIdle");
      a();
      TraceCompat.endSection();
      return;
    }
    if (paramInt == 1)
    {
      TraceCompat.beginSection("snap onDragging");
      a(i);
      TraceCompat.endSection();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_Float <= 0.0F) {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
      }
      if (this.jdField_b_of_type_Float <= 0.0F)
      {
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        return false;
      }
    }
    else
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float - paramMotionEvent.getX());
        this.d = (this.jdField_b_of_type_Float - paramMotionEvent.getY());
      }
      else
      {
        this.jdField_c_of_type_Float = 0.0F;
        this.d = 0.0F;
      }
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_c_of_type_Boolean = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PagerSnapHelper.TouchEventProcessor
 * JD-Core Version:    0.7.0.1
 */